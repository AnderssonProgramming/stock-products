package edu.eci.cvds.stock_products.model;

public class WarningAgent implements StockAgent {
    @Override
    public void notify(ProductModel product) {
        if (product.getQuantity() < 5){
            System.out.println("WARNING!!! The product stock: " + product.getName() + " is very low, only miss " + product.getQuantity() + " units.");
        }

    }
}
