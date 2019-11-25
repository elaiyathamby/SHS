package ch.zhaw.infm.springboottemplate.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
