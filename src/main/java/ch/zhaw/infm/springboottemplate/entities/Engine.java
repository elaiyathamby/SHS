package ch.zhaw.infm.springboottemplate.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Beispiel-Entity-Klasse zur Verwaltung von Welten
 */
@Entity
public class Engine extends Device implements Serializable  {
	
	/*@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long engineID;

	private String engineName;
	private boolean isActive;
	private Long price;*/
	
	private int rotationSpeed;
	private int power;
	private int torque;
	
	/*@ManyToOne
	private Room engineRoom;*/
	@ManyToMany
	private Set<Schedule> engineSchedules;
	
	

	public Set<Schedule> getEngineSchedules() {
		return engineSchedules;
	}

	public void setEngineSchedules(Set<Schedule> engineSchedules) {
		this.engineSchedules = engineSchedules;
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


	
	
	

}
