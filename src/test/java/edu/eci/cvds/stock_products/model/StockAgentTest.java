package edu.eci.cvds.stock_products.model;


import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class StockAgentTest {

    @Test
    void testAgenteLog() {
        LogAgent agente = new LogAgent();
        ProductModel producto = new ProductModel("PS5", 500.0, 8, "Consolas");
        agente.notify(producto);
        assertNotEquals("Product:" + producto.getName() + "-> " + producto.getQuantity() + "available units",agente);
    }
    
    @Test
    void testAgenteAdvertencia() {
        WarningAgent agente = new WarningAgent();
        ProductModel producto = new ProductModel("Xbox", 450.0, 3, "Consolas");
        agente.notify(producto);
        assertNotEquals("WARNING!!! The product stock:" + producto.getName() + "is very low, only miss" +  producto.getQuantity() + "units.",agente);
    }
}
