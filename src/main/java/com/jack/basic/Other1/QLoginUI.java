package com.jack.basic.Other1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zhangta on 3/8/2018.
 */
public class QLoginUI extends JFrame {
    //定义组件
    //北部区域
    JLabel jl1; //放置图片

    //南部区域
    JButton jb1, jb2, jb3;//登录、取消、注册向导
    JPanel jp1;//注意：panel面板，pane是窗格

    //中部区域
    JTabbedPane jtp;// 选项卡窗格
    JPanel jp2, jp3, jp4;
    //QQ选项
    JLabel jl2, jl3, jl4, jl5;//QQ号码、QQ密码、忘记密码、申请保护
    JTextField jtf; //文本框
    JPasswordField jpf;//密码框
    JButton jb4;//清除号码
    JCheckBox jcb1, jcb2;//隐身登录、记住密码
    //手机选项
    JLabel jl2a, jl3a, jl4a, jl5a;//手机号码 、QQ密码、忘记密码、申请保护
    JTextField jtfa;    //文本框
    JPasswordField jpfa;//密码框
    JButton jb4a;//清除号码
    JCheckBox jcb1a, jcb2a;//隐身登录、记住密码

    public static void main(String[] args) {
        QLoginUI testLogin = new QLoginUI();

    }
    //构造函数
    public QLoginUI(){
        //创建组件
        //北部区域
        jl1 = new JLabel(new ImageIcon("images/QQ.jpg"));
        //中部区域
        jtp = new JTabbedPane();    //选项卡窗格
        //中部QQ JPanel1
        jp2 = new JPanel();
        jl2 = new JLabel("QQ号码：", JLabel.CENTER);
        jl3 = new JLabel("QQ密码：", JLabel.CENTER);
        jl4 = new JLabel("忘记密码", JLabel.CENTER);
        jl4.setFont(new Font("宋体", Font.PLAIN, 13));
        jl4.setForeground(Color.blue);
        jl5 = new JLabel("<html><a href='www.qq.com'>申请密码保护</a></html>");
        jcb1 = new JCheckBox("隐身登录");
        jcb2 = new JCheckBox("记住密码");
        jtf = new JTextField(18);
        jpf = new JPasswordField(18);
        jb4 = new JButton("清除号码");

        //中部手机JPanel2
        jp3 = new JPanel();
        jl2a = new JLabel("手机号码：", JLabel.CENTER);
        jl3a = new JLabel("QQ密 码：", JLabel.CENTER);
        jl4a = new JLabel("忘记密码", JLabel.CENTER);
        jl4a.setFont(new Font("宋体", Font.PLAIN, 13));
        jl4a.setForeground(Color.blue);
        jl5a = new JLabel("<html><a href='www.qq.com'>申请密码保护</a></html>");
        jcb1a = new JCheckBox("隐身登录");
        jcb2a = new JCheckBox("记住密码");
        jtfa = new JTextField(18);
        jpfa = new JPasswordField(18);
        jb4a = new JButton("清除号码");

        //南部区域
        jp1 = new JPanel();
        jb1 = new JButton("登录");
        jb2 = new JButton("取消");
        jb3 = new JButton("注册向导");

        //设置布局
        jp2.setLayout(new GridLayout(3, 3));


        //添加组件
        jp1.add(jb1);   //南部
        jp1.add(jb2);
        jp1.add(jb3);
        //中部
        jp2.add(jl2);
        jp2.add(jtf);
        jp2.add(jb4);
        jp2.add(jl3);
        jp2.add(jpf);
        jp2.add(jl4);
        jp2.add(jcb1);
        jp2.add(jcb2);
        jp2.add(jl5);

        //面板3采用网格布局3行3列
        jp3.setLayout(new GridLayout(3, 3));
            /*选项卡2,注意：不能图省事，将与jp2面板中的相同组件再加添到jp3面板中，
                否则jp2的中的组件就会显示在jp3中，jp2就会失去相应的组件*/
        jp3.add(jl2a);
        jp3.add(jtfa);
        jp3.add(jb4a);

        jp3.add(jl3a);
        jp3.add(jpfa);
        jp3.add(jl4a);

        jp3.add(jcb1a);
        jp3.add(jcb2a);
        jp3.add(jl5a);

        //将面板添加到选项卡窗格
        jtp.add("QQ号码", jp2);
        jtp.add("手机号码", jp3);
        jtp.add("电子邮箱", jp4);

        //加入窗体
        this.add(jl1, BorderLayout.NORTH);  // 图片标签位于北部
        this.add(jp1, BorderLayout.SOUTH);  //按钮位于南部
        this.add(jtp, BorderLayout.CENTER); //选项卡窗格位于中部

        this.setSize(400, 265);
        this.setResizable(false);   //禁止改变窗体大小
        this.setTitle("QQ2014");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
