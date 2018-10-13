package com.jack.nowcoder.autumn.shenxinfu;

/**
 * @Author: Jack
 * @Date: 2018/10/13 19:18
 * JSON是一种可以用来保存配置的数据格式，其结构为树状。
 * JSON中某个子节点的位置可以用JSON路径的形式表示，
 * JSON路径类似于UNIX文件路径，以/分隔父子节点名。
 * JSON路径中不会出现空格。
 * 输入描述：
 * 第一行为一个正整数N，表示接下来有N行数据
 * 第二行到第N+1行为字符串Path，表示待检查访问权限的JSON路径，
 * 第N+2行为一个正整数T，表示接下来有T行数据，
 * 接下来会有T行数据，格式为“权限，JSON路径”
 * 权限有两种取值，Y和N。
 * JSON的路径最大长度为256.
 * 输出描述：
 * 输出权限，权限表示该节点的实际访问权限
 * 输入：
 * 1
 * /mem/total
 * 3
 * Y /mem/daemons/findme
 * N /mem/daemons
 * Y /mem
 * 输出：
 * Y
 */
public class Main3 {
    public static void main(String[] args) {

    }
}