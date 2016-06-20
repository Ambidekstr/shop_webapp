package com.ambidekstr.shop.controller;

import com.ambidekstr.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ambidekstr on 19-Jun-16.
 */

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("products", productService.showAllProducts());
        return "index";
    }


}
