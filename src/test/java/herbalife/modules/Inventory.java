package herbalife.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Inventory {
	private InventoryPayload data;
	
	@JsonProperty("isSuccess")
	private boolean isSuccess;

	public InventoryPayload getData() {
		return data;
	}

	public void setData(InventoryPayload data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
}
