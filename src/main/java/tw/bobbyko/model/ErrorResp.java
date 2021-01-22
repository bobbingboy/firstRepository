package tw.bobbyko.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ErrorResp {

	@JsonProperty(value = "ERROR_CODE")
	private String errorCode;

	@JsonProperty(value = "MESSAGE")
	private String message;
}
