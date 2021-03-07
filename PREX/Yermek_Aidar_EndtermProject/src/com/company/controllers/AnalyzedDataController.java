package com.company.controllers;

import com.company.entities.Transaction;
import com.company.repositories.interfaces.IAnalyzeRepository;
import com.company.repositories.interfaces.ITransactionRepository;

import java.util.List;

public class AnalyzedDataController {
    private final IAnalyzeRepository repo;
    private final ITransactionRepository repo1;

    public AnalyzedDataController(IAnalyzeRepository repo, ITransactionRepository repo11) {
        this.repo = repo;
        this.repo1 = repo11;
    }


    public int getFavoriteItem(String from_date, String to_date) {
        List<Transaction> transactions = repo1.getAllTransactions();

        return (repo.getFavoriteItem(transactions, from_date, to_date));
    }

    public String getTopAgeGroup(){
        List<Transaction> transactions = repo1.getAllTransactions();
        return repo.getTopAgeGroup(transactions);
    }


}
