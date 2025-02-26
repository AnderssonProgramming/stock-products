package edu.eci.cvds.stock_products.model;

public class ProductModel {

    private String name;
    private double price;
    private int quantity;
    private String category;

    /*
     * This is the constructor
     */
    public ProductModel (String name,double price,int quantity, String category){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    /*
     * GETTERS AND SETTERS
     */

     
    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getCategory(){
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
}
