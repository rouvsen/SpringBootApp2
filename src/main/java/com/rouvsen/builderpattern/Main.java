package com.rouvsen.builderpattern;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.PizzaBuilder("large").name("").cheese(true).pepperoni(true) .build();
        System.out.println(pizza);
    }
}
