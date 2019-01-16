package herbalife.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Flags {
	@JsonProperty("advisoryRequired")
	private boolean advisoryRequired;
	@JsonProperty("cantBuy")
	private boolean cantBuy;
	private String distributorStatus;
	@JsonProperty("hardCashOnly")
	private boolean hardCashOnly;
	@JsonProperty("isCustomer")
	private boolean isCustomer;
	@JsonProperty("isDeleted")
	private boolean isDeleted;
	@JsonProperty("isTerminated")
	private boolean isTerminated;
	public boolean isAdvisoryRequired() {
		return advisoryRequired;
	}
	public void setAdvisoryRequired(boolean advisoryRequired) {
		this.advisoryRequired = advisoryRequired;
	}
	public boolean getCantBuy() {
		return cantBuy;
	}
	public void setCantBuy(boolean cantBuy) {
		this.cantBuy = cantBuy;
	}
	public String getDistributorStatus() {
		return distributorStatus;
	}
	public void setDistributorStatus(String distributorStatus) {
		this.distributorStatus = distributorStatus;
	}
	public boolean isHardCashOnly() {
		return hardCashOnly;
	}
	public void setHardCashOnly(boolean hardCashOnly) {
		this.hardCashOnly = hardCashOnly;
	}
	public boolean isCustomer() {
		return isCustomer;
	}
	public void setCustomer(boolean isCustomer) {
		this.isCustomer = isCustomer;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public boolean isTerminated() {
		return isTerminated;
	}
	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}
	
	
	
}
