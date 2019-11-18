package ch.zhaw.infm.springboottemplate.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Beispiel-Entity-Klasse zur Verwaltung von Welten
 */
@Entity
public class Engine implements Serializable  {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deviceID;
	
	private String deviceName;
	private boolean isActive;
	private Long price;
	private int rotationSpeed;
	private int power;
	private int torque;
	
	private Long roomID;

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

	public int getRotationSpeed() {
		return rotationSpeed;
	}

	public void setRotationSpeed(int rotationSpeed) {
		this.rotationSpeed = rotationSpeed;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getTorque() {
		return torque;
	}

	public void setTorque(int torque) {
		this.torque = torque;
	}

	public Long getRoomID() {
		return roomID;
	}

	public void setRoomID(Long roomID) {
		this.roomID = roomID;
	}

	public Long getDeviceID() {
		return deviceID;
	}

	
	
	

}
