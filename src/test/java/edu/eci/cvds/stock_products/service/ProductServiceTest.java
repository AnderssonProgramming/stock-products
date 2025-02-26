package edu.eci.cvds.stock_products.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.eci.cvds.stock_products.model.ProductModel;
import edu.eci.cvds.stock_products.model.StockAgent;
import edu.eci.cvds.stock_products.repository.ProductRepository;


/*
* Clase para tener de referencia el comportamiento de la interfaz aplicada a las interacciones
* del método notify. No lo hago en la interfaz porque siendo así tanto para LogAgent como para 
* WarningAgent habría que hacer @Override de esos métodos.
*/
class TestObserver implements StockAgent {
    private boolean notificado = false;
    private ProductModel productoNotificado;

    @Override
    public void notify(ProductModel producto) {
        notificado = true;
        productoNotificado = producto;
    }
        
    public boolean isNotificado() {
        return notificado;
    }
        
    public ProductModel getProductoNotificado() {
        return productoNotificado;
    }
}

public class ProductServiceTest {
    private ProductRepository repo;
    private ProductService service;
    private TestObserver observer1;
    private TestObserver observer2;

    @BeforeEach
    public void setUp() {
        repo = new ProductRepository();
        service = new ProductService(repo);
        observer1 = new TestObserver();
        observer2 = new TestObserver();
        
        service.addObserver(observer1);
        service.addObserver(observer2);
    }

    @Test
    public void testAgregarProducto() {
        ProductModel producto = new ProductModel("MCBook", 2000.0, 5, "Computadoras");
        service.addProduct(producto);
        
        ProductModel obtenido = repo.getProduct("MCBook");
        assertNotNull(obtenido);
        assertEquals("MCBook", obtenido.getName());
    }
    
    @Test
    public void testModificarStockConNotificacion() {
        ProductModel producto = new ProductModel("Tablet", 300.0, 10, "Electrónica");
        repo.addProduct(producto);
        service.modifyStock("Tablet", 2); 
        ProductModel modificado = repo.getProduct("Tablet");
        assertEquals(2, modificado.getQuantity());
        
        // Notificación de ambos observadores
        assertTrue(observer1.isNotificado(), "Observer 1 debería haber sido notificado");
        assertTrue(observer2.isNotificado(), "Observer 2 debería haber sido notificado");
        
        // Verificar que el producto notificado es el correcto
        assertEquals("Tablet", observer1.getProductoNotificado().getName());
        assertEquals("Tablet", observer2.getProductoNotificado().getName());
    }
}
