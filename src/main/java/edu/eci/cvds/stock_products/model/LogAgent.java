package edu.eci.cvds.stock_products.model;

public class LogAgent implements StockAgent {
    @Override
    public void notify(ProductModel product) {
        System.out.println("Product: " + product.getName() + "->" + " " + product.getQuantity() + " available units ");
    }

}
