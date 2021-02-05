package com.vintage.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class ShoppingOrder {
	 private Integer id;

	    private String shopper;

	    private Integer totalqty;

	    private BigDecimal totalprice;

	    private Boolean iscompleted;

	    private String createby;

	    private Date createtime;
}
