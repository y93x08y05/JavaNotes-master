package com.jack.basic.demo;

import java.io.*;
import java.text.SimpleDateFormat;

/**
 * Created by Jack on 8/30/2018 10:30 AM
 */
public class FileProcess {
    public static void main(String[] args) {
        String s1=
                "-66 -64 -70 -67 -78 -67 -82 -72 \n" +
                "\n" +
                "-72 -69 -66 -63 -77 -72 -68 -73 \n" +
                "\n";
//        processString(s1);
        readFile();
    }
    private static void processString(String s1) {
        String []str=s1.split(" ");
        StringBuilder sb=new StringBuilder();
        int flag=0;
        for (int i=0;i<str.length;i++) {
            if (str[i]!="\n") {
                if (flag==0) {
                    sb.append("A ");
                    flag++;
                } else if (flag==1) {
                    sb.append("B ");
                    flag++;
                } else if (flag==2) {
                    sb.append("C ");
                    flag++;
                } else if (flag==3) {
                    sb.append("D ");
                    flag++;
                } else if (flag==4) {
                    sb.append("E ");
                    flag++;
                } else if (flag==5) {
                    sb.append("F ");
                    flag++;
                } else if (flag==6) {
                    sb.append("G ");
                    flag++;
                } else {
                    sb.append("H ");
                    flag=0;
                }
                sb.append(str[i]);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
    private static void readFile() {
        StringBuilder sb=new StringBuilder();
        BufferedReader reader=null;
        String temp;
        int line=1;
        int flag=1;
        try {
            reader=new BufferedReader(new FileReader("C:/intern/蓝牙元数据/信标位置2.8_1 0837_test.txt"));
            while ((temp=reader.readLine())!=null) {
                if (line%2==1) {
                    if (flag<10) {
                        sb.append("00"+flag+" ");
                    } else if (flag<100){
                        sb.append("0"+flag+" ");
                    } else {
                        sb.append(flag+" ");
                    }
                    String []s=temp.split(" ");
                    for (int i=0;i<s.length;i++) {
                        if (i==0) {
                            sb.append("A ");
                        } else if (i==1) {
                            sb.append("B ");
                        } else if (i==2) {
                            sb.append("C ");
                        } else if (i==3) {
                            sb.append("D ");
                        } else if (i==4) {
                            sb.append("E ");
                        } else if (i==5) {
                            sb.append("F ");
                        } else if (i==6) {
                            sb.append("G ");
                        } else {
                            sb.append("H ");
                        }
                        sb.append(s[i]);
                        sb.append(" ");
                    }
                    sb.append("\n");
                    flag++;
                }
                line++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader!=null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(sb.toString());
            saveFile(sb.toString());
        }
    }
    private static void saveFile(String str) {
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        long l=System.currentTimeMillis();
        String filePath="C:/intern/蓝牙新数据/信标位置2.8_1 0837_test.txt";
//        String filePath="C:/intern/蓝牙数据/"+new Date(l).getHours()+"点"+
//                new Date(l).getMinutes()+"分"+new Date(l).getSeconds()+"秒.txt";
        File file=new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileWriter writer;
        try {
            writer=new FileWriter(file);
            writer.write(str);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
