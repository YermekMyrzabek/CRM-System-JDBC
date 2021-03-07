package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Transaction;
import com.company.repositories.interfaces.IAnalyzeRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnalyzedDataRepository implements IAnalyzeRepository {

    private final IDB db;

    public AnalyzedDataRepository(IDB db) {
        this.db = db;
    }

    @Override
    public int getFavoriteItem(List<Transaction> transactions, String from_date, String to_date) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT item_id FROM \"Transaction\" WHERE transaction_status = true AND transaction_time >\'" + from_date + "\' AND " + "transaction_time >\'" + to_date + "\'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<Integer> itemIDs = new ArrayList<Integer>();
            while (rs.next()) {
                int item_id = rs.getInt("item_id");
                itemIDs.add(item_id);
            }
            int count = 1, tempCount;
            int popular = itemIDs.get(0);
            int temp = 0;

            for (int id : itemIDs) {
                temp = id;
                tempCount = 0;
                for (int id2 : itemIDs) {
                    if (temp == id2) {
                        tempCount++;
                    }
                }
                if (tempCount > count) {
                    popular = temp;
                    count = tempCount;
                }
            }
            return popular ;

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

    @Override
    public String getTopAgeGroup(List<Transaction> transactions) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT customer_id FROM \"Transaction\" WHERE transaction_status = true";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<Integer> customerIDs = new ArrayList<>();
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                customerIDs.add(customer_id);
            }
            int counter1=0;
            int counter2=0;
            int counter3=0;
            int counter4=0;
            for(int id:customerIDs) {
                String fixed_age_group="SELECT ageGroup FROM \"Customer\" WHERE customer_id="+id;
                if(fixed_age_group=="0-18") {
                    counter1++;
                }
                else if(fixed_age_group=="19-36") {
                    counter2++;
                }
                else if(fixed_age_group=="37-54") {
                    counter3++;
                }
                else {
                    counter4++;
                }
                if (counter1>counter2 && counter1>counter3 && counter1>counter4 ) {
                    return "0-18";
                }
                if (counter2>counter1 && counter2>counter3 && counter2>counter4 ) {
                    return "19-36";
                }
                if (counter3>counter1 && counter3>counter2 && counter3>counter4 ) {
                    return "37-54";
                }
                else {
                    return "55-72";
                }

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
}
