package com.cs4471.cspsp.repository;

import com.cs4471.cspsp.model.StockDataEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StockDataPagingAndSortingRepository extends PagingAndSortingRepository<StockDataEntity, Integer> {}