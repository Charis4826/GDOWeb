package herbalife.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AuthResponsePayload {
	private AuthResponse data;

	public AuthResponse getData() {
		return data;
	}

	public void setData(AuthResponse data) {
		this.data = data;
	}
	 

}
