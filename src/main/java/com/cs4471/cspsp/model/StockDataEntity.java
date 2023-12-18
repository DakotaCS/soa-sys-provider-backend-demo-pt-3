package com.cs4471.cspsp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * @author Dakota Soares
 * @version 2023.1.1
 * @since 2023-10-27
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "stock_data")
public class StockDataEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private Date date;

  private Double open;

  private Double high;

  private Double low;

  private Double close;

  private Integer volume;

  private String ticker_name;
}
