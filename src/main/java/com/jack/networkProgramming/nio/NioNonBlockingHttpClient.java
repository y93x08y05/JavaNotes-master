package com.jack.networkProgramming.nio;

import com.jack.networkProgramming.socket.HttpUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: Jack
 * @Date: 2018/9/22 14:01
 */
public class NioNonBlockingHttpClient {
    private static Selector selector;
    private Charset charset=Charset.forName("utf8");
    static {
        try {
            selector=Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        NioNonBlockingHttpClient client=new NioNonBlockingHttpClient();
        for (String host:HttpUtil.HOSTS) {
            client.request(host,HttpUtil.PORT);
        }
        client.select();
    }
    public void request(String host,int port) throws IOException {
        SocketChannel socketChannel=SocketChannel.open();
        socketChannel.socket().setSoTimeout(5000);
        SocketAddress remote=new InetSocketAddress(host,port);
        //只有在socketChannel.configureBlocking(false)之后的代码才是非阻塞
        //如果在此之前建立连接，则连接依然为阻塞调用
        socketChannel.configureBlocking(false);
        socketChannel.connect(remote);
        socketChannel.register(selector,SelectionKey.OP_CONNECT|SelectionKey.OP_READ|SelectionKey.OP_WRITE);
    }
    public void select() throws IOException {
        while (selector.select(500)>0) {
            Set keys=selector.selectedKeys();
            Iterator iterator=keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key= (SelectionKey) iterator.next();
                iterator.remove();
                if (key.isConnectable()) {
                    connect(key);
                } else if (key.isWritable()) {
                    write(key);
                } else if (key.isReadable()) {
                    receive(key);
                }
            }
        }
    }
    //SelectionKey代表SocketChannel在选择器中注册的事件句柄
    private void connect(SelectionKey key) throws IOException {
        SocketChannel channel= (SocketChannel) key.channel();
        channel.finishConnect();
        InetSocketAddress remote= (InetSocketAddress) channel.socket().getRemoteSocketAddress();
        String host=remote.getHostName();
        int port=remote.getPort();
        System.out.println(String.format("访问地址：%s:%s 连接成功！",host,port));
    }
    private void write(SelectionKey key) throws IOException {
        SocketChannel channel= (SocketChannel) key.channel();
        InetSocketAddress remote= (InetSocketAddress) channel.socket().getRemoteSocketAddress();
        String host=remote.getHostName();
        String request=HttpUtil.compositeRequest(host);
        System.out.println(request);
        channel.write(charset.encode(request));
        /**
         * 选择器用来监听事件变化的两个参数interestOps和readyOps
         * interestOps表示SocketChannel所关心的事件类型
         * readOps表示SocketChannel当前就绪的事件类型
         */
        key.interestOps(SelectionKey.OP_READ);
    }
    private void receive(SelectionKey key) throws IOException {
        SocketChannel channel= (SocketChannel) key.channel();
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();
        String receiveData=charset.decode(buffer).toString();
        //当没有数据可读时，取消在选择器中的关联，并关闭socket连接
        if ("".equals(receiveData)) {
            key.cancel();
            channel.close();
            return;
        }
        System.out.println(receiveData);
    }
}