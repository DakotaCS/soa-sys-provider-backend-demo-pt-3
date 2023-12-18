package com.cs4471.cspsp.repository;

import com.cs4471.cspsp.model.StockDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import java.util.List;

/**
 * @author Dakota Soares
 * @version 2023.1.1
 * @since 2023-10-27
 */

public interface StockDataRepository extends JpaRepository<StockDataEntity, Integer> {
    @Query("select s from StockDataEntity s where s.ticker_name = ?1")
    List<StockDataEntity> getByTickerName(String ticker_name);

    @Query("select s from StockDataEntity s where s.date >= ?1 and s.date <= ?2")
    List<StockDataEntity> getAllByDateRange(Date start, Date end);
}
