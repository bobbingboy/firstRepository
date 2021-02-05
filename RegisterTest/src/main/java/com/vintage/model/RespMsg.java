package com.vintage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespMsg {
	private int code;
	private String msg;
	private Object data;
}
