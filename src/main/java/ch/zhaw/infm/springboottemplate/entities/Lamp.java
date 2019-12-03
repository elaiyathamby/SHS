package ch.zhaw.infm.springboottemplate.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * Beispiel-Entity-Klasse zur Verwaltung von Welten
 */
@Entity
public class Lamp extends Device implements Serializable {
	
	/*@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lampID;

	private String lampName;
	private boolean isActive;
	private Long price;*/
	
	private String color;
	private int brightness;
	private String lampType;

	/*@ManyToOne
	private Room lampRoom;*/
	@OneToMany
	private Set<Schedule> lampSchedules;
	
	
	

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
