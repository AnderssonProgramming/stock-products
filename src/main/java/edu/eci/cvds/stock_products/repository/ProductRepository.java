package edu.eci.cvds.stock_products.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import edu.eci.cvds.stock_products.model.ProductModel;

public class ProductRepository {

    //Uso ConcurrentHashMap porque necesito almacenar por clave-valor de manera semejante cada producto.
    private Map<String,ProductModel> products = new ConcurrentHashMap<>(); 

    public void addProduct(ProductModel product){
        products.put(product.getName(), product);
    }

    public ProductModel getProduct(String name){
        return products.get(name);
    }

    public void updateProduct(ProductModel product){
        products.put(product.getName(), product);
    }
}