package herbalife.modules;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class VolumeData {
	private ErrorModel error;
	private String realTimeVolume;
	private List<RecentHistory> recentHistory;
	public ErrorModel getError() {
		return error;
	}
	public void setError(ErrorModel error) {
		this.error = error;
	}
	public String getRealTimeVolume() {
		return realTimeVolume;
	}
	public void setRealTimeVolume(String realTimeVolume) {
		this.realTimeVolume = realTimeVolume;
	}
	public List<RecentHistory> getRecentHistory() {
		return recentHistory;
	}
	public void setRecentHistory(List<RecentHistory> recentHistory) {
		this.recentHistory = recentHistory;
	}

}
