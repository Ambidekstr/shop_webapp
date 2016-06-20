package com.ambidekstr.shop.dao;

import com.ambidekstr.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ambidekstr on 19-Jun-16.
 */
@Component
public class ProductDaoJDBC implements ProductDAO {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Map<Integer, Product> getAllProducts() {
        Map<Integer,Product> productMap = new HashMap<>();
        String sql = "SELECT * FROM online_shop.product";
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);
            while (resultSet.next()){
                productMap.put(resultSet.getInt(1),new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3)));
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

        return productMap;
    }

    @Override
    public List<Product> showAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM online_shop.product";
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con = dataSource.getConnection();
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);
            while (resultSet.next()){
                products.add(new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3)));
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
        return products;
    }


}
