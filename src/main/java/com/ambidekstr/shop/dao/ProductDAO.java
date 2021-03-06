package com.ambidekstr.shop.dao;

import com.ambidekstr.shop.model.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by Ambidekstr on 19-Jun-16.
 */
public interface ProductDAO {

    Map<Integer,Product> getAllProducts();

    List<Product> showAllProducts();

}
