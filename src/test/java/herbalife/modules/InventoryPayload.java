package herbalife.modules;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryPayload {
	private List<ProductData> products;

	public List<ProductData> getProducts() {
		return products;
	}

	public void setProducts(List<ProductData> products) {
		this.products = products;
	}

	 
	
}
