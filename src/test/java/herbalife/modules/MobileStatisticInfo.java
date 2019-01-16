package herbalife.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MobileStatisticInfo {
	private UserCountInfoPayload data;
	
	@JsonProperty("isSuccess")
	private boolean isSuccess;
	
	public MobileStatisticInfo() {
		
	}
	
	public UserCountInfoPayload getData() {
		return data;
	}
	public void setData(UserCountInfoPayload data) {
		this.data = data;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
}
