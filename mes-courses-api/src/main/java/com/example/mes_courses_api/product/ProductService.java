package com.example.mes_courses_api.product;

import com.example.mes_courses_api.list_item.ListItemDTO;
import com.example.mes_courses_api.list_item.ListItemRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Resource
    ProductRepository productRepository;

    @Resource
    ListItemRepository listItemRepository;

    @Resource
    ProductMapper productMapper;

    public ProductEntity find(Long productId) {
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException());

        return product;
    }

    List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    ProductDTO create(ProductDTO productRequest) {
        ProductEntity productEntity = productMapper.toEntity(productRequest);
        return productMapper.toDto(productRepository.save(productEntity));
    }

    ProductDTO update(Long productId, ProductDTO updateReq) {
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Le produit n'existe pas"));
        product.setName(updateReq.name());
        product.setUnit(updateReq.unit());
        return productMapper.toDto(productRepository.save(product));
    }

    @Transactional
    void delete (Long productId) {
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Le produit n'existe pas"));
        listItemRepository.deleteByProduct(product);
        productRepository.delete(product);
    }
}
