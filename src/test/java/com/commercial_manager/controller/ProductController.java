package com.commercial_manager.controller;



import com.commercial_manager.controllers.ProductController;
import com.commercial_manager.models.entity.Product;
import com.commercial_manager.service.IProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private IProductService productService;

    @InjectMocks
    private ProductController productController;

    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        product = new Product();
        product.setId(1L);
        product.setName("Producto Test");
    }

    @Test
    void index_ShouldReturnListOfProducts() {
        when(productService.findAll()).thenReturn(List.of(product));

        List<Product> result = productController.index();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Producto Test", result.get(0).getName());
        verify(productService, times(1)).findAll();
    }

    @Test
    void show_ShouldReturnProductById() {
        when(productService.findById(1L)).thenReturn(product);

        Product result = productController.show(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Producto Test", result.getName());
        verify(productService, times(1)).findById(1L);
    }

    @Test
    void save_ShouldReturnOkResponse() {
        Map<String, Object> serviceResponse = new HashMap<>();
        serviceResponse.put("message", "Producto guardado");
        when(productService.save(product)).thenReturn(serviceResponse);

        ResponseEntity<?> response = productController.save(product);

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody() instanceof Map);
        assertEquals("Producto guardado", ((Map<?, ?>) response.getBody()).get("message"));
        verify(productService, times(1)).save(product);
    }

    @Test
    void update_ShouldReturnOkResponse() {
        Map<String, Object> serviceResponse = new HashMap<>();
        serviceResponse.put("message", "Producto actualizado");
        when(productService.update(product)).thenReturn(serviceResponse);

        ResponseEntity<?> response = productController.update(product);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Producto actualizado", ((Map<?, ?>) response.getBody()).get("message"));
        verify(productService, times(1)).update(product);
    }

    @Test
    void delete_ShouldReturnOkResponse() {
        when(productService.delete(1L)).thenReturn("Producto eliminado");

        ResponseEntity<?> response = productController.delete(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Producto eliminado", response.getBody());
        verify(productService, times(1)).delete(1L);
    }
}
