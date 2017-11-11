package com.qisibajie.designpattern.templatemethod;

public class Coffee extends CaffeineBeverage {
    public void addCondiments() {
        System.out.println("Add Sugar and Milk");
    }

    public void brew() {
        System.out.println("Dripping Coffee through filter");
    }

}
