package com.qisibajie.designpattern.templatemethod;

public abstract class CaffeineBeverage {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void pourInCup() {
        System.out.println("Pouring in cup");
    }

    void boilWater() {
        System.out.println("Boiling water");
    }
}
