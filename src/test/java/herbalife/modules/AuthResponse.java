package herbalife.modules;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AuthResponse {
	
		private String token;
		private MemberShip membership;
		private VolumeData volumeData;
		private List<Notification> notifications;

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public MemberShip getMembership() {
			return membership;
		}

		public void setMembership(MemberShip membership) {
			this.membership = membership;
		}

		public VolumeData getVolumeData() {
			return volumeData;
		}

		public void setVolumeData(VolumeData volumeData) {
			this.volumeData = volumeData;
		}

		public List<Notification> getNotifications() {
			return notifications;
		}

		public void setNotifications(List<Notification> notifications) {
			this.notifications = notifications;
		}

}
