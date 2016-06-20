package com.ambidekstr.shop.dao;

import com.ambidekstr.shop.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Ambidekstr on 19-Jun-16.
 */
@Component
public class PurchaseDaoJDBC implements PurchaseDAO {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void addPurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase (Product, Quantity, PurchaseDate) VALUES (?,?,?)";
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, purchase.getProduct());
            ps.setInt(2, purchase.getQuantity());
            ps.setString(3,purchase.getDayOfPurchase());
            int a = 10;
            ps.execute();
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if(ps !=null)
                    ps.close();
                if(con !=null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Purchase> showAllPurchases() {
        List<Purchase> purchases = new ArrayList<>();
        String sql = "SELECT * FROM online_shop.purchase";
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);
            while (resultSet.next()){
                Purchase purchase = new Purchase();
                purchase.setPurchaseId(resultSet.getInt(1));
                purchase.setProduct(resultSet.getString(2));
                purchase.setQuantity(resultSet.getInt(3));
                purchase.setDayOfPurchase(resultSet.getString(4));
                try {
                    purchase.setDate(new SimpleDateFormat("dd.MM.yy").parse(resultSet.getString(4)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                purchases.add(purchase);
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if(ps !=null)
                    ps.close();
                if(con !=null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return purchases;
    }

    @Override
    public List<Purchase> showPurchasesDuringPeriod(long period) {
        Date per = null;
        if(period==6){
            per = new Date(new Date().getTime()-15778800000L);

        }else if(period == 3){
            per = new Date(new Date().getTime()-7889400000L);
        }else{
            per = new Date(new Date().getTime()-2629800000L);
        }
        List<Purchase> purchases = new ArrayList<>();
        String sql = "SELECT * FROM online_shop.purchase";
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);
            while (resultSet.next()){
                Purchase purchase = new Purchase();
                purchase.setPurchaseId(resultSet.getInt(1));
                purchase.setProduct(resultSet.getString(2));
                purchase.setQuantity(resultSet.getInt(3));
                purchase.setDayOfPurchase(resultSet.getString(4));
                try {
                    purchase.setDate(new SimpleDateFormat("dd.MM.yy").parse(resultSet.getString(4)));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(purchase.getDate().compareTo(per)>=0) {
                    purchases.add(purchase);
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if(ps !=null)
                    ps.close();
                if(con !=null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return purchases;
    }
}
