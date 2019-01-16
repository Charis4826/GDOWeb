package herbalife.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class VolumeLimits {
	private String consignmentVolumeLimit;
	private String consignmentVolumeLimitUsed;
	private String personalVolumeLimit;
	private String personalVolumeLimitUsed;
	
	public String getConsignmentVolumeLimit() {
		return consignmentVolumeLimit;
	}
	
	public void setConsignmentVolumeLimit(String consignmentVolumeLimit) {
		this.consignmentVolumeLimit = consignmentVolumeLimit;
	}
	
	public String getConsignmentVolumeLimitUsed() {
		return consignmentVolumeLimitUsed;
	}
	
	public void setConsignmentVolumeLimitUsed(String consignmentVolumeLimitUsed) {
		this.consignmentVolumeLimitUsed = consignmentVolumeLimitUsed;
	}
	
	public String getPersonalVolumeLimit() {
		return personalVolumeLimit;
	}
	
	public void setPersonalVolumeLimit(String personalVolumeLimit) {
		this.personalVolumeLimit = personalVolumeLimit;
	}
	
	public String getPersonalVolumeLimitUsed() {
		return personalVolumeLimitUsed;
	}
	
	public void setPersonalVolumeLimitUsed(String personalVolumeLimitUsed) {
		this.personalVolumeLimitUsed = personalVolumeLimitUsed;
	}

}
