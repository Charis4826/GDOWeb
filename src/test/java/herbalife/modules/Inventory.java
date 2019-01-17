package herbalife.modules;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Inventory extends RestResponseWrapper<Inventory.InventoryPayload> {
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class InventoryPayload {

		private List<ProductData> products;

		public List<ProductData> getProducts() {
			return products;
		}

		public void setProducts(List<ProductData> products) {
			this.products = products;
		}
	}
}
