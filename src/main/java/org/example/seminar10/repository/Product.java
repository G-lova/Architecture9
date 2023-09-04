package org.example.seminar10.repository;

public class Product {
    private int id;
    private String name;
    private String unit;
    private int energy;

    public Product(int id, String name, String unit, int energy) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.energy = energy;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getEnergy() {
        return energy;
    }
}