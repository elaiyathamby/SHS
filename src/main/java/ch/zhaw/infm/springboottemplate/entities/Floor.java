package ch.zhaw.infm.springboottemplate.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
