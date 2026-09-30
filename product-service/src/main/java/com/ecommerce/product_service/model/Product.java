package com.ecommerce.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value="product")  //se usa para indicar que esta clase es un documento de MongoDB y se almacenará en la colección "product"
@AllArgsConstructor //sirve para generar un constructor con todos los argumentos de la clase
@NoArgsConstructor //sirve para generar un constructor sin argumentos
@Data //sirve para generar los métodos getters y setters, equals, hashCode y toString automáticamente
@Builder //sirve para generar un patrón de diseño Builder para crear objetos de la clase Product de manera más legible y flexible

public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
