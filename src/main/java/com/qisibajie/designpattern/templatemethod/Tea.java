package com.qisibajie.designpattern.templatemethod;

public class Tea {
    void prepareRecipe() {
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }

    private void addLemon() {
        System.out.println("Adding Lemon");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    private void steepTeaBag() {
        System.out.println("Steeping the tea");
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }
}
