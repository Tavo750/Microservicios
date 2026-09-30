package com.ecommerce.product_service.service.impl;

import com.ecommerce.product_service.dto.ProductRequestDTO;
import com.ecommerce.product_service.dto.ProductResponseDTO;
import com.ecommerce.product_service.exception.ResourceNoFoundException;
import com.ecommerce.product_service.mapper.ProductMapper;
import com.ecommerce.product_service.model.Product;
import com.ecommerce.product_service.repository.ProductRepositiry;
import com.ecommerce.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepositiry repository;
    private final ProductMapper mapper;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {
        Product product = mapper.toProduct(requestDTO);
        Product savedProduct = repository.save(product);
        log.info("Producto {} creado", savedProduct.getName());
        return mapper.toProductResponseDTO(savedProduct);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return repository.findAll()
                .stream()
                .map(mapper::toProductResponseDTO)
                .toList();
    }

    @Override
    public ProductResponseDTO getProductById(String id) {
        Product product = repository.findById(id).orElseThrow(
                () -> new ResourceNoFoundException("Producto","id", id)
        );
        return mapper.toProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(String id, ProductRequestDTO productRequest) {
        Product product = repository.findById(id).orElseThrow(
                () -> new ResourceNoFoundException("Producto","id", id)
        );
        mapper.updateProductFromRequest(productRequest, product);
        Product updateProduct = repository.save(product);
        log.info("Producto {} actualizado", updateProduct.getName());

        return mapper.toProductResponseDTO(updateProduct);
    }

    @Override
    public void deleteProduct(String id) {
        if(!repository.existsById(id)){
            throw new ResourceNoFoundException("Producto","id", id);
        }
        repository.deleteById(id);
        log.info("Producto eliminado con id {}", id);

    }
}
