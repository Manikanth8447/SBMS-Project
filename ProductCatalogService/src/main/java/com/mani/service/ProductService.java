package com.mani.service;

import java.util.List;

import com.mani.entity.Category;
import com.mani.entity.Product;

public interface ProductService {
	String createProduct(Product product);

	Product getProductById(Long id);

	List<Product> getAllProducts();

	String updateProduct(Long id, Product product);

	String deleteProductById(Long id);

	String createCategory(Category category);

	List<Category> getAllCategories();
}
