package com.rouvsen.builderpattern;

public class Pizza {

    private String size;
    private String name;
    private boolean cheese;
    private boolean pepperoni;

    public Pizza(PizzaBuilder builder){
        this.size = builder.size;
        this.name = builder.name;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
    }

    public String getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public boolean isCheese() {
        return cheese;
    }

    public boolean isPepperoni() {
        return pepperoni;
    }

    @Override
    public String toString() {
        return "Pizza{size='%s', name='%s', cheese=%s, pepperoni=%s}"
                .formatted(size, name, cheese, pepperoni);
    }

    public static class PizzaBuilder{
        private String size;
        private String name;
        private boolean cheese;
        private boolean pepperoni;

        public PizzaBuilder(String size){
            this.size = size;
        }

        public PizzaBuilder name(String name){
            this.name = name;
            return this;
        }
        public PizzaBuilder cheese(boolean cheese){
            this.cheese = cheese;
            return this;
        }
        public PizzaBuilder pepperoni(boolean pepperoni){
            this.pepperoni = pepperoni;
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }
    }
}
