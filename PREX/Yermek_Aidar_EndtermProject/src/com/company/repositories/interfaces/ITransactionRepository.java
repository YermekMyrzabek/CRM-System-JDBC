package com.company.repositories.interfaces;

import com.company.entities.Transaction;


import java.util.List;

public interface ITransactionRepository {
    Transaction getTransaction(int transaction_id);
    List<Transaction> getAllTransactions();
    int getProfitability (List<Transaction> transactions);
}
