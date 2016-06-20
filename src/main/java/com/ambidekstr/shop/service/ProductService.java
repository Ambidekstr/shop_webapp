package com.ambidekstr.shop.service;

import com.ambidekstr.shop.model.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by Ambidekstr on 19-Jun-16.
 */
public interface ProductService {

    List<Product> showAllProducts();

    Map<Integer,Product> getAllProducts();
}
