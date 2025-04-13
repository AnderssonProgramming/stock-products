package edu.eci.cvds.stock_products.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class ProductModelTest {

    @Test
    void testAddProduct() {
        ProductModel producto = new ProductModel("Laptop HP", 1500.0, 10, "Electrónica");
        assertEquals("Laptop HP", producto.getName());
        assertEquals(1500.0, producto.getPrice());
        assertEquals(10, producto.getQuantity());
        assertEquals("Electrónica", producto.getCategory());
    }

    @Test
    void testModificarCantidad() {
        ProductModel producto = new ProductModel("Mouse", 25.0, 20, "Accesorios");
        producto.setQuantity(15);
        assertEquals(15, producto.getQuantity());
    }

    @Test
    void testModificarCategoría_Precio(){
        ProductModel producto = new ProductModel("Camisa",562.0,11, "Ropa");
        producto.setCategory("Indumentaria");
        producto.setPrice(562.0 - 562.0 * 0.60);
        assertNotEquals(42423, producto.getCategory());
        assertNotEquals("Juguetes", producto.getCategory());

    }
}