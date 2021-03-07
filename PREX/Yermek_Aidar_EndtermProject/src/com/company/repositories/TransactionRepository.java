package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Transaction;
import com.company.repositories.interfaces.ITransactionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TransactionRepository implements ITransactionRepository {
    private final IDB db;

    public TransactionRepository(IDB db) {
        this.db = db;
    }

    @Override
    public Transaction getTransaction(int transaction_id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT transaction_id,customer_id,item_id,transaction_status,transaction_time FROM \"Transaction\"" +
                    " WHERE transaction_id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, transaction_id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Transaction transaction = new Transaction(rs.getInt("transaction_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("item_id"),
                        rs.getBoolean("transaction_status"),
                        rs.getString("transaction_time"));

                return transaction;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }


    @Override
    public List<Transaction> getAllTransactions() {

        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT transaction_id,customer_id,item_id,transaction_status,transaction_time FROM \"Transaction\"";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Transaction> transactions = new LinkedList<>();
            while (rs.next()) {
                Transaction transaction = new Transaction(rs.getInt("transaction_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("item_id"),
                        rs.getBoolean("transaction_status"),
                        rs.getString("transaction_time"));

                transactions.add(transaction);
            }
            return transactions;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        return null;
    }

    @Override
    public int getProfitability(List<Transaction> transactions) {

        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT item_id FROM \"Transaction\" WHERE transaction_status = true";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<Integer> itemIDs = new ArrayList<Integer>();
            while (rs.next()) {
                int item_id = rs.getInt("item_id");
                itemIDs.add(item_id);
            }
            int profitabilityAmount = 0;
            for (int id : itemIDs) {
                String sql2 = "SELECT item_price FROM \"Item\" WHERE item_id =" + id;
                Statement st2 = con.createStatement();
                ResultSet rs2 = st2.executeQuery(sql2);
                while(rs2.next()) {
                    profitabilityAmount += rs2.getInt("item_price");
                }
            }
            return profitabilityAmount;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }



        }
        return 0;
    }

}
