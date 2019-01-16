package herbalife.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductData {
		private String SKU;
		private int bullet;
		public String getSKU() {
			return SKU;
		}
		public void setSKU(String sKU) {
			SKU = sKU;
		}
		public int getBullet() {
			return bullet;
		}
		public void setBullet(int bullet) {
			this.bullet = bullet;
		}
}
