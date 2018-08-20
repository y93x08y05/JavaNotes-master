package com.jack.basic.Other2;

import java.io.IOException;
import java.io.InputStream;

/**
 * 虚拟机存在两个classLoaderTest类
 * 一个是由系统应用程序类加载器加载的，另一个是由自定义类加载器加载
 * 虽然来自同一个Class文件，但是两个独立的类
 */
public class classLoaderTest {
    public static void main(String [] args)throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(filename);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = classLoader.loadClass("classLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof classLoaderTest);
    }
}