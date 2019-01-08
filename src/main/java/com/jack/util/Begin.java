package com.jack.util;

/**
 * @Author: Jack
 * @Date: 2018/12/24 22:19
 */
public class Begin {
    private static final String VmTask = "F:/毕业论文/实验结果/多组结果/";
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            if (i < 9) {
                Start.begin(VmTask + "ABC-0" + String.valueOf(i + 1));
            } else {
                Start.begin(VmTask + "ABC-" + String.valueOf(i + 1));
            }
            sb.append(Start.sb.substring(Start.sb.lastIndexOf(",")));
        }
        FileUtils.saveFile(sb.toString(), VmTask + "Load.txt");
    }
}