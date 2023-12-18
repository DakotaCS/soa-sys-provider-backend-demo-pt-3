package com.cs4471.cspsp.service;

import com.cs4471.cspsp.model.StockDataEntity;
import com.cs4471.cspsp.repository.StockDataPagingAndSortingRepository;
import com.cs4471.cspsp.repository.StockDataRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Dakota Soares
 * @version 2023.1.1
 * @since 2023-10-27
 */
@Service
@Transactional
public class StockDataService {

    @Autowired
    StockDataRepository stockDataRepository;
    @Autowired
    StockDataPagingAndSortingRepository stockDataPagingAndSortingRepository;

    public List<StockDataEntity> getStockData() {
        return stockDataRepository.findAll();
    }

    public StockDataEntity getStockDataById(Integer id) {
        return stockDataRepository.findById(id).orElse(null);
    }

    public List<StockDataEntity> getAllStockDataWithPagination(int pageNo, int pageSize) {
        Page<StockDataEntity> stockEntitiesWithPagination =
                stockDataPagingAndSortingRepository.findAll(PageRequest.of(pageNo, pageSize));
        List<StockDataEntity> stockDataEntityList = new ArrayList<>();
        stockEntitiesWithPagination.forEach(stockDataEntity -> {
            stockDataEntityList.add(stockDataEntity);
        });
        return stockDataEntityList;
    }

    public List<StockDataEntity> getAllStocksByTickerName(String tickerName) {
        return stockDataRepository.getByTickerName(tickerName);
    }

    public List<StockDataEntity> getAllStocksByDateRange(Date start, Date end) {
        return stockDataRepository.getAllByDateRange(start, end);
    }
}
