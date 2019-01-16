package herbalife.modules;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryData {
	private List<ProductData> productData;

	public List<ProductData> getProductData() {
		return productData;
	}

	public void setProductData(List<ProductData> productData) {
		this.productData = productData;
	}
}
