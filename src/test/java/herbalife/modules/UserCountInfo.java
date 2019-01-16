package herbalife.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCountInfo {
	private int favoriteCount;
	private int customerCount;
	private int learningPointAvailable;
	private int creditCardCount;
	private int eventTicketCount;
	private int payingOrderCount;
	private int deliveringOrderCount;
	private int receivingOrderCount;
	private int completedOrderCount;
	private int combinationCount;

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

	public int getCustomerCount() {
		return customerCount;
	}

	public void setCustomerCount(int customerCount) {
		this.customerCount = customerCount;
	}

	public int getLearningPointAvailable() {
		return learningPointAvailable;
	}

	public void setLearningPointAvailable(int learningPointAvailable) {
		this.learningPointAvailable = learningPointAvailable;
	}

	public int getCreditCardCount() {
		return creditCardCount;
	}

	public void setCreditCardCount(int creditCardCount) {
		this.creditCardCount = creditCardCount;
	}

	public int getEventTicketCount() {
		return eventTicketCount;
	}

	public void setEventTicketCount(int eventTicketCount) {
		this.eventTicketCount = eventTicketCount;
	}

	public int getPayingOrderCount() {
		return payingOrderCount;
	}

	public void setPayingOrderCount(int payingOrderCount) {
		this.payingOrderCount = payingOrderCount;
	}

	public int getDeliveringOrderCount() {
		return deliveringOrderCount;
	}

	public void setDeliveringOrderCount(int deliveringOrderCount) {
		this.deliveringOrderCount = deliveringOrderCount;
	}

	public int getReceivingOrderCount() {
		return receivingOrderCount;
	}

	public void setReceivingOrderCount(int receivingOrderCount) {
		this.receivingOrderCount = receivingOrderCount;
	}

	public int getCompletedOrderCount() {
		return completedOrderCount;
	}

	public void setCompletedOrderCount(int completedOrderCount) {
		this.completedOrderCount = completedOrderCount;
	}

	public int getCombinationCount() {
		return combinationCount;
	}

	public void setCombinationCount(int combinationCount) {
		this.combinationCount = combinationCount;
	}
}
