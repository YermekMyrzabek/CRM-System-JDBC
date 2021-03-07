package com.company.controllers;

import com.company.entities.Transaction;

import com.company.repositories.interfaces.ITransactionRepository;

import java.util.List;

public class TransactionController {
        private final ITransactionRepository repo;

        public TransactionController(ITransactionRepository repo) {
            this.repo = repo;
        }
    public String getTransaction(int transaction_id) {
        Transaction transaction = repo.getTransaction(transaction_id);

        return (transaction == null ? "Transaction was not found!" : transaction.toString());
    }

    public String getAllTransactions() {
        List<Transaction> transactions = repo.getAllTransactions();

        return transactions.toString();
    }

    public int getProfitability(){
        List<Transaction> transactions =repo.getAllTransactions();

        return repo.getProfitability(transactions);
    }

}
