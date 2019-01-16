package herbalife.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryPayload {
	private InventoryData inventoryData;

	public InventoryData getInventoryData() {
		return inventoryData;
	}

	public void setInventoryData(InventoryData inventoryData) {
		this.inventoryData = inventoryData;
	}
	
}
