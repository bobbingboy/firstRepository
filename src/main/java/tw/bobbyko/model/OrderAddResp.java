package tw.bobbyko.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrderAddResp extends ErrorResp{
	
	@JsonProperty(value ="success")
	private Boolean success;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	
}
