package tw.bobbyko.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrderAddReq {
	@JsonProperty(value = "USERNAME")
	private String username;

	@JsonProperty(value = "USERPWD")
	private String userpwd;

	
}
