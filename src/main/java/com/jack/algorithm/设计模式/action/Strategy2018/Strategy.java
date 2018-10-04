package com.jack.algorithm.设计模式.action.Strategy2018;

public class Strategy {
    private Insurance insurance;
    private Salary salary;
    private Tax tax;
    public void computer(){
        salary.computerSalary();
        insurance.computerInsurance();
        tax.computerTax();
    }

    public Salary getSalary() {
        return salary;
    }
    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}