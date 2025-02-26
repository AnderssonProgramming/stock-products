package edu.eci.cvds.stock_products.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import edu.eci.cvds.stock_products.model.ProductModel;

public class ProductRepositoryTest {

    @Test
    public void testAgregarYObtenerProducto() {
        ProductRepository repo = new ProductRepository();
        ProductModel producto = new ProductModel("Teclado", 50.0, 30, "Accesorios");
        
        repo.addProduct(producto);
        ProductModel obtenido = repo.getProduct("Teclado");
        
        assertNotNull(obtenido);
        assertEquals("Teclado", obtenido.getName());
    }
    
    @Test
    public void testActualizarProducto() {
        ProductRepository repo = new ProductRepository();
        ProductModel producto = new ProductModel("Monitor", 200.0, 15, "Electrónica");
        
        repo.addProduct(producto);
        producto.setQuantity(10);
        repo.updateProduct(producto);
        
        ProductModel actualizado = repo.getProduct("Monitor");
        assertEquals(10, actualizado.getQuantity());
    }
}
