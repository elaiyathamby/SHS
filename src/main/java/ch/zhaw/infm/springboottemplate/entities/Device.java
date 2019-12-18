package ch.zhaw.infm.springboottemplate.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
public class Device implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deviceID;

	private String deviceName;
	private boolean isActive;
	private Long price;

	@ManyToOne
	private Room room;
	@OneToMany
	private Set<Schedule> schedules;

	public Device() {
	}

	public Device(String deviceName, boolean isActive, Long price, Room room, Set<Schedule> schedules) {
		this.deviceName = deviceName;
		this.isActive = isActive;
		this.price = price;
		this.room = room;
		this.schedules = schedules;
	}

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