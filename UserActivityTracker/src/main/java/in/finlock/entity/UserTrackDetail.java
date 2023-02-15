package in.finlock.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserTrackDetail {

	@Id
	private String sessionId;

	private String username;

	private String location;

	private String ipAddress;

	private String osName;

	private String browserName;

	private LocalDateTime logIn;

	private LocalDateTime logOut;

	private int time;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String user) {
		this.username = user;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public LocalDateTime getLogIn() {
		return logIn;
	}

	public void setLogIn(LocalDateTime logIn) {
		this.logIn = logIn;
	}

	public LocalDateTime getLogOut() {
		return logOut;
	}

	public void setLogOut(LocalDateTime logOut) {
		this.logOut = logOut;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	@Override
	public String toString() {
		return "UserTrackDetail [sessionId=" + sessionId + ", username=" + username + ", location=" + location
				+ ", ipAddress=" + ipAddress + ", osName=" + osName + ", browserName=" + browserName + ", logIn="
				+ logIn + ", logOut=" + logOut + ", time=" + time + "]";
	}

}
