package ch.zhaw.infm.springboottemplate.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * Beispiel-Entity-Klasse zur Verwaltung von Welten
 */
@MappedSuperclass
public class Device implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deviceID;

	private String deviceName;
	private boolean isActive;
	private Long price;
	
	@ManyToOne
	private Room room;
	@OneToMany
	private Set<Schedule> schedules;
	

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Long getDeviceId() {
		return deviceID;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceID = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

}
