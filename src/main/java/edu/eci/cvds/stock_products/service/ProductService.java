package edu.eci.cvds.stock_products.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.cvds.stock_products.model.ProductModel;
import edu.eci.cvds.stock_products.model.StockAgent;
import edu.eci.cvds.stock_products.repository.ProductRepository;

@Service
public class ProductService {
    private ProductRepository repository;
    private List<StockAgent> observers;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
        this.observers = new ArrayList<>();
    }

    public void addObserver(StockAgent observer) {
        observers.add(observer);
    }
    
    public void addProduct(ProductModel product) {
        repository.addProduct(product);
    }

    public void removeObserver(StockAgent observer) {
        observers.remove(observer);
    }
    
    public void notifyObservers(ProductModel product) {
        for (StockAgent observer : observers) {
            observer.notify(product);
        }
    }

    public void modifyStock(String newProduct, int newQuantity) {
        ProductModel product = repository.getProduct(newProduct);
        if (product != null) {
           product.setQuantity(newQuantity);
           repository.updateProduct(product);
           notifyObservers(product); 
        }
    }
}
