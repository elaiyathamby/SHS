package ch.zhaw.infm.springboottemplate.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * 
 */
@Entity
public class Room implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roomID;

	private int roomSizeM2;
	private String roomName;

	@OneToMany
	private Set<Lamp> lamps;
	@OneToMany
	private Set<Engine> engines;
	@ManyToOne
	private Floor floor;

	public Set<Lamp> getDevices() {
		return lamps;
	}

	public void setDevices(Set<Lamp> lamps) {
		this.lamps = lamps;
	}

	public Set<Engine> getEngines() {
		return engines;
	}

	public void setEngines(Set<Engine> engines) {
		this.engines = engines;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public void setRoomID(Long roomID) {
		this.roomID = roomID;
	}

	public int getRoomSizeM2() {
		return roomSizeM2;
	}

	public void setRoomSizeM2(int roomSizeM2) {
		this.roomSizeM2 = roomSizeM2;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Long getRoomID() {
		return roomID;
	}

}
