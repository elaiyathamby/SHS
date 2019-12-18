package ch.zhaw.infm.springboottemplate.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class House implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long houseID;

	private String address;
	private int houseSizeM2;
	private String houseName;

	@OneToMany
	private Set<Floor> floors;

	@ManyToOne
	private User user;

	public House() {
	}

	public House(String address, int houseSizeM2, String houseName, Set<Floor> floors, User user) {
		this.address = address;
		this.houseSizeM2 = houseSizeM2;
		this.houseName = houseName;
		this.floors = floors;
		this.user = user;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
