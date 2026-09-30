package com.ecommerce.product_service.dataloader;

import com.ecommerce.product_service.model.Product;
import com.ecommerce.product_service.repository.ProductRepositiry;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component   //ayuda a Spring a detectar esta clase como un componente y crear una instancia de ella en el contexto de la aplicación
@RequiredArgsConstructor
public class TestDataLoader implements CommandLineRunner {

    private final ProductRepositiry productRepositiry;

    @Override
    public void run(String... args) throws Exception {
        // Aquí puedes agregar la lógica para cargar datos de prueba en tu base de datos

        // Product product = Product.builder()
        //         .name("Producto de prueba")
        //         .description("Descripción del producto de prueba")
        //         .price(BigDecimal.valueOf(1200))
        //         .build();

        // productRepositiry.save(product);
        // System.out.println("Cargando datos de prueba..." +  product.getName());
    }

}
