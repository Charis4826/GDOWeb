package herbalife.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCountInfoPayload {
	private UserCountInfo userCountInfo;

	public UserCountInfo getUserCountInfo() {
		return userCountInfo;
	}

	public void setUserCountInfo(UserCountInfo userCountInfo) {
		this.userCountInfo = userCountInfo;
	}
	
}
