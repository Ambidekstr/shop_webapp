package com.ambidekstr.shop.model;

import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Created by Ambidekstr on 19-Jun-16.
 */
@Component
public class Purchase {
    private int purchaseId;
    private String product;
    private int quantity;
    private String dayOfPurchase;
    private Date date;


    public Purchase() {
    }

    public Purchase(int purchaseId, String product, int quantity) {
        this.purchaseId = purchaseId;
        this.product = product;
        this.quantity = quantity;
        this.dayOfPurchase = new SimpleDateFormat("dd.MM.yy").format(Calendar.getInstance().getTime());
        try {
            this.date = new SimpleDateFormat("dd.MM.yy").parse(dayOfPurchase);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDayOfPurchase() {
        return dayOfPurchase;
    }

    public void setDayOfPurchase(String dayOfPurchase) {
        this.dayOfPurchase = dayOfPurchase;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
