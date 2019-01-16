package herbalife.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Addresses {
	private String billingAddress;
	private String fiscalAddress;
	private String mailingAddress;

	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public String getFiscalAddress() {
		return fiscalAddress;
	}

	public void setFiscalAddress(String fiscalAddress) {
		this.fiscalAddress = fiscalAddress;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
}
