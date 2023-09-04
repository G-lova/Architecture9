package org.example.seminar10.agregator;

import java.util.ArrayList;
import java.util.List;


public class Recipe {
    private int id;
    private String name;
    private List<RecipeIngredient> items;
    private String cooking;

    public Recipe(int id, String name, String cooking) {
        this.id = id;
        this.name = name;
        this.items = new ArrayList<>();
        this.cooking = cooking;
    }

    public void addIngredient(RecipeIngredient item) {
        items.add(item);
    }

    public void removeIngredient(RecipeIngredient item) {
        items.remove(item);
    }

    public double getRecipeEnergy() {
        double recipeEnergy = 0;
        for (RecipeIngredient item : items) {
            recipeEnergy += item.getProduct().getEnergy() * item.getQuantity();
        }
        return recipeEnergy;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<RecipeIngredient> getItems() {
        return items;
    }

    public String getCooking() {
        return cooking;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(List<RecipeIngredient> items) {
        this.items = items;
    }

    public void setCooking(String cooking) {
        this.cooking = cooking;
    }
}
