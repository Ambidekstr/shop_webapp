package com.ambidekstr.shop.service;

import com.ambidekstr.shop.dao.PurchaseDAO;
import com.ambidekstr.shop.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ambidekstr on 19-Jun-16.
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

    private PurchaseDAO purchaseDAO;

    @Autowired
    public void setPurchaseDAO(PurchaseDAO purchaseDAO) {
        this.purchaseDAO = purchaseDAO;
    }

    @Override
    public void addPurchase(Purchase purchase) {
        purchaseDAO.addPurchase(purchase);
    }

    @Override
    public List<Purchase> showAllPurchases() {
        return purchaseDAO.showAllPurchases();
    }

    @Override
    public List<Purchase> showPurchasesDuringPeriod(long period) {
        return purchaseDAO.showPurchasesDuringPeriod(period);
    }
}
