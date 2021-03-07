package com.company.repositories.interfaces;


import com.company.entities.Transaction;

import java.util.List;

public interface IAnalyzeRepository {
    int getFavoriteItem(List<Transaction> transactions, String from_date, String to_date);
    String getTopAgeGroup(List<Transaction> transactions);


}
