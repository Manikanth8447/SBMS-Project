package com.mani.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mani.entity.Category;
import com.mani.entity.Product;
import com.mani.repository.CategoryRepository;
import com.mani.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public String createProduct(Product product) {
        productRepository.save(product);
        return "Product created successfully!";
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public String updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            productRepository.save(product);
            return "Product updated successfully!";
        }
        return "Product not found!";
    }

    @Override
    public String deleteProductById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Product deleted successfully!";
        }
        return "Product not found!";
    }

    @Override
    public String createCategory(Category category) {
        categoryRepository.save(category);
        return "Category created successfully!";
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
