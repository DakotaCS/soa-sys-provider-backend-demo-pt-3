package com.cs4471.cspsp.controller.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * @author Dakota Soares
 * @version 2023.1.1
 * @since 2023-10-27
 */

@Data
public class StockDataEntityDto {

    private Integer id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private String ticker_name;
    private Double open;
    private Double close;
    private Date date;
}
