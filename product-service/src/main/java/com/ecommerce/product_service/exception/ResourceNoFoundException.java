package com.ecommerce.product_service.exception;

import lombok.Getter;

@Getter
public class ResourceNoFoundException extends RuntimeException {
    private final String resourceName;
    private final String fieldName;
    private final String fieldValue;

    public ResourceNoFoundException(String resourceName, String fieldName, String fieldValue) {
        super( String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));

        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
