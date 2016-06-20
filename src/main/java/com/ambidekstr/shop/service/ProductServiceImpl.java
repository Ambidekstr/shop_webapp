package com.ambidekstr.shop.service;

import com.ambidekstr.shop.dao.ProductDAO;
import com.ambidekstr.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Ambidekstr on 19-Jun-16.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> showAllProducts() {
        return productDAO.showAllProducts();
    }

    @Override
    public Map<Integer, Product> getAllProducts() {
        return productDAO.getAllProducts();
    }
}
