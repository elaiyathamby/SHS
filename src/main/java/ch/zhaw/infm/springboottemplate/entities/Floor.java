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
public class Floor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long floorID;
    
    private int floorNumber;
    private int floorSize;
    
    @ManyToOne
    private House house;
	@OneToMany
    private Set<Room> room;
    
    public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public Set<Room> getRoom() {
		return room;
	}
	public void setRoom(Set<Room> room) {
		this.room = room;
	}
	public void setFloorID(Long floorID) {
		this.floorID = floorID;
	}
    
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	public int getFloorSize() {
		return floorSize;
	}
	public void setFloorSize(int floorSize) {
		this.floorSize = floorSize;
	}
	public Long getFloorID() {
		return floorID;
	}
    
	
   
}
