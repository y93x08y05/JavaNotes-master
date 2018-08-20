package com.jack.designMode.create.SimpleFactory2018;

public class Client {
    public static String HE_BEI = "HeBei";
    public static String Ji_Lin = "JiLin";
    public static void main(String [] args){
        Salary salary = SimpleFactory.createSalary(HE_BEI);
        salary.computerSalary();
        Salary salary1 = SimpleFactory.createSalary(Ji_Lin);
        salary1.computerSalary();
    }
}