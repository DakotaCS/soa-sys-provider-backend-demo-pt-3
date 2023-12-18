package com.cs4471.cspsp.util;

import com.cs4471.cspsp.controller.StockDataController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Dakota Soares
 * @version 2023.1.1
 * @since 2023-12-05
 */

@Component
public class RegisterServiceHelperScheduler implements CommandLineRunner {
    @Autowired StockDataController stockDataController;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Evaluating Services...");
        //List of Services That will Register to the Registry
        stockDataController.getAllStockDataPageable(10);
        stockDataController.getStockDataById(999999);
        stockDataController.getStockDataByTickerName("DEFAULT");
        stockDataController.getStockDataByDateRange("2012-12-31","2013-01-02");
        System.out.println("Done Evaluating Services...");
    }
}