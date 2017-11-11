package com.qisibajie.designpattern.templatemethod;

public class Tea extends CaffeineBeverage {
    public void addCondiments() {
        System.out.println("Adding Lemon");
    }

    public void brew() {
        System.out.println("Steeping the tea");
    }
}
