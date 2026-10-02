    package com.ecommerce.inventory_service.exception;

import lombok.Getter;

@Getter
public class ResourceNoFoundException extends RuntimeException {
    private final String resourceName;
    private final String fieldName;
    private final Long fieldValue;

    public ResourceNoFoundException(String resourceName, String fieldName, Long fieldValue) {
        super( String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));

        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
