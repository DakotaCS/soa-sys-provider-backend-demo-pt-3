package com.cs4471.cspsp.controller;

import java.util.List;
import com.cs4471.cspsp.controller.dto.StockDataEntityDto;
import com.cs4471.cspsp.controller.dto.StockDataEntityWithDetailDto;
import com.cs4471.cspsp.service.RegisterNewService;
import com.cs4471.cspsp.service.StockDataService;
import com.cs4471.cspsp.util.BeanMapper;
import com.cs4471.cspsp.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Dakota Soares
 * @version 2023.1.1
 * @since 2023-10-29
 */

@RestController
@RequestMapping("/api")
public class StockDataController {

	@Autowired
	StockDataService stockDataService;
	@Autowired RegisterNewService registerNewService;

	@GetMapping("/stocks")
	public ResponseEntity<Object> getAllStockData() {
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("This endpoint is not implemented");
	}

	@GetMapping("/stocks/pageable/{pageNo}")
	public ResponseEntity<List<StockDataEntityDto>> getAllStockDataPageable(
			@PathVariable(name = "pageNo") Integer pageNo) {
		registerNewService.registerNewService(1,"GET","/stocks/pageable/10");
		return ResponseEntity.ok(BeanMapper.mapList(stockDataService.getAllStockDataWithPagination(
				pageNo,100), StockDataEntityDto.class));
	}

	@GetMapping("/stocks/{id}")
	public ResponseEntity<Object> getStockDataById(
			@PathVariable(name = "id") Integer id) {
		registerNewService.registerNewService(1,"GET","/stocks/999999");
		return ResponseEntity.ok(
				stockDataService.getStockDataById(id) != null ? BeanMapper.map(
						stockDataService.getStockDataById(id), StockDataEntityWithDetailDto.class) :
						ResponseEntity.notFound().build());
	}

	@GetMapping("/stocks/ticker/{tickerName}")
	public ResponseEntity<Object> getStockDataByTickerName(
			@PathVariable(name = "tickerName") String tickerName) {
		registerNewService.registerNewService(1,"GET","/stocks/ticker/DEF");
		return ResponseEntity.ok(
				stockDataService.getAllStocksByTickerName(tickerName) != null ? BeanMapper.mapList(
						stockDataService.getAllStocksByTickerName(tickerName), StockDataEntityWithDetailDto.class) :
						ResponseEntity.notFound().build());
	}

	@GetMapping("/stocks/date")
	public ResponseEntity<Object> getStockDataByDateRange(
			@RequestParam(name = "startDate") String startDate,
			@RequestParam(name = "endDate") String endDate) {
		registerNewService.registerNewService(1,"GET",
				"/stocks/date?startDate=2012-12-31&endDate=2013-01-02");
		return ResponseEntity.ok(BeanMapper.mapList( stockDataService.getAllStocksByDateRange(
				DateTimeUtils.parseStringToDate(startDate),
				DateTimeUtils.parseStringToDate(endDate)),
				StockDataEntityDto.class));
	}
}
