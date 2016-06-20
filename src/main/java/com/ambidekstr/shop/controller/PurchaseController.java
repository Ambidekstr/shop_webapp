package com.ambidekstr.shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ambidekstr.shop.model.Product;
import com.ambidekstr.shop.model.Purchase;
import com.ambidekstr.shop.service.ProductService;
import com.ambidekstr.shop.service.PurchaseService;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Ambidekstr on 19-Jun-16.
 */
@Controller
public class PurchaseController {

    private PurchaseService purchaseService;

    private Purchase purchase;

    private ProductService productService;

    private int id;

    @Autowired
    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setPurchaseService(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public String buy(@ModelAttribute(value = "purcha")Purchase purchase, Model model){
        Product product = productService.getAllProducts().get(id);
        purchase.setProduct(product.getProduct());
        purchase.setDayOfPurchase(new SimpleDateFormat("dd.MM.yy").format(Calendar.getInstance().getTime()));
        purchaseService.addPurchase(purchase);
        return "redirect:/products";
    }
    @RequestMapping(value = "/form")
    public String form(Model model){
        model.addAttribute("purcha", new Purchase());
        Product product = productService.getAllProducts().get(id);
        return "form";
    }

    @RequestMapping(value = "/{id}/buy", method = RequestMethod.GET)
    public String buyForm(@PathVariable("id")int id, Model model){
        this.id = id;
        model.addAttribute("product", productService.getAllProducts().get(id));
        model.addAttribute("purcha",new Purchase());
        return "redirect:/form";
    }
    @RequestMapping(value = "/purchases", method = RequestMethod.GET)
    public String annualPurchases(Model model){
        model.addAttribute("allPurchases", purchaseService.showAllPurchases());
        return "purchase";
    }
    @RequestMapping(value = "/purchases/{month}", method = RequestMethod.GET)
    public String purchases(@PathVariable("month")long month, Model model){
        return "redirect:/purchases"+month;
    }
    @RequestMapping(value = "/purchases1", method = RequestMethod.GET)
    public String purchasesForLastMonth( Model model){
        model.addAttribute("Purchases1", purchaseService.showPurchasesDuringPeriod(1));
        return "purchases1";
    }
    @RequestMapping(value = "/purchases3", method = RequestMethod.GET)
    public String purchasesForLastThreeMonth(Model model){
        model.addAttribute("Purchases3", purchaseService.showPurchasesDuringPeriod(3));
        return "purchase3";
    }
    @RequestMapping(value = "/purchases6", method = RequestMethod.GET)
    public String purchasesForSixMonth( Model model){
        model.addAttribute("Purchases6", purchaseService.showPurchasesDuringPeriod(6));
        return "purchase6";
    }

}

