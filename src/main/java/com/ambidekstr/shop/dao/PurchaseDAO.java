package com.ambidekstr.shop.dao;

import com.ambidekstr.shop.model.Purchase;

import java.util.List;

/**
 * Created by Ambidekstr on 19-Jun-16.
 */
public interface PurchaseDAO {

    void addPurchase(Purchase purchase);

    List<Purchase> showAllPurchases();

    List<Purchase> showPurchasesDuringPeriod(long period);

}
