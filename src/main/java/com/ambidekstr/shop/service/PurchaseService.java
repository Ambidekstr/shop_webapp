package com.ambidekstr.shop.service;

import com.ambidekstr.shop.model.Purchase;

import java.util.List;

/**
 * Created by Ambidekstr on 19-Jun-16.
 */
public interface PurchaseService {

    void addPurchase(Purchase purchase);

    List<Purchase> showAllPurchases();

    List<Purchase> showPurchasesDuringPeriod(long period);
}
