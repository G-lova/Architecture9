package org.example.seminar10.agregator;

public class RecipeIngredient {
    private Product product;
    private int quantity;

    public RecipeIngredient(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;

    }
}
