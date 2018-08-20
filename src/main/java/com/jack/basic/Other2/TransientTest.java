package com.jack.basic.Other2;

import java.io.*;

public class TransientTest {
    public static void main(String [] args){
        User user = new User();
        user.setUsername("Jack");
        user.setPassword("123456");
        System.out.println("read before serializable:");
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("C:/Users/10648/Downloads/蜂群算法论文/Read.txt")
            );
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("C:/Users/10648/Downloads/蜂群算法论文/Read.txt")
            );
            user = (User) in.readObject();
            in.close();
            System.out.println("\nread after serializable");
            System.out.println("username: " + user.getUsername());
            System.out.println("password: " + user.getPassword());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class User implements Serializable{
    private static final long serialVersionUID = 8294180014912103005L;

    private String username;
    private transient String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
