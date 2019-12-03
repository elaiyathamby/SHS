package ch.zhaw.infm.springboottemplate.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.mapping.List;

/**
 * 
 */
@Entity
public class House implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long houseID;
    private String adress;
    private int houseSizeM2;
    private String houseName;
    
    @OneToMany
    private Set<Floor> floors;
    
    @ManyToOne
    private User user;
    
	public Set<Floor> getFloors() {
		return floors;
	}
	public void setFloors(Set<Floor> floors) {
		this.floors = floors;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Long getHouseID() {
		return houseID;
	}
	public void setHouseID(Long houseID) {
		this.houseID = houseID;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getHouseSizeM2() {
		return houseSizeM2;
	}
	public void setHouseSizeM2(int houseSizeM2) {
		this.houseSizeM2 = houseSizeM2;
	}
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
    
   
}
