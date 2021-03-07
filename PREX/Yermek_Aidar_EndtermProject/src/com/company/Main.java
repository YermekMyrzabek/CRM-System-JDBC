package com.company;

import com.company.controllers.AnalyzedDataController;
import com.company.controllers.TransactionController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.AnalyzedDataRepository;
import com.company.repositories.TransactionRepository;
import com.company.repositories.interfaces.IAnalyzeRepository;
import com.company.repositories.interfaces.ITransactionRepository;


public class Main {

    public static void main(String[] args) {

        IDB db = new PostgresDB();
        ITransactionRepository repo = new TransactionRepository(db);
        IAnalyzeRepository repo2=new AnalyzedDataRepository(db);
        TransactionController controller1 = new TransactionController(repo);
        AnalyzedDataController controller2 = new AnalyzedDataController(repo2, repo);
        MyApplication app = new MyApplication(controller1, controller2);
        app.start();
    }
}
