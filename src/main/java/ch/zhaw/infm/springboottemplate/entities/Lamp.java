package ch.zhaw.infm.springboottemplate.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Lamp extends Device implements Serializable {

	private String color;
	private int brightness;
	private String lampType;

	@OneToMany
	private Set<Schedule> lampSchedules;

	public Lamp() {
	}

	public Lamp(String deviceName, boolean isActive, Long price, Room room, Set<Schedule> schedules, String color,
			int brightness, String lampType, Set<Schedule> lampSchedules) {
		super(deviceName, isActive, price, room, schedules);
		this.color = color;
		this.brightness = brightness;
		this.lampType = lampType;
		this.lampSchedules = lampSchedules;
	}

	public Set<Schedule> getLampSchedules() {
		return lampSchedules;
	}

	public void setLampSchedules(Set<Schedule> lampSchedules) {
		this.lampSchedules = lampSchedules;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	public String getLampType() {
		return lampType;
	}

	public void setLampType(String lampType) {
		this.lampType = lampType;
	}

}
