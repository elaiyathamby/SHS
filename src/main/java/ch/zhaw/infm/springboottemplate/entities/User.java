package ch.zhaw.infm.springboottemplate.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * Beispiel-Entity-Klasse zur Verwaltung von Welten
 */
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    private String userName;
    private String password;
    
    @OneToMany
    private Set<House> houses;
    
	public Set<House> getHouses() {
		return houses;
	}
	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
    
    
    
}
