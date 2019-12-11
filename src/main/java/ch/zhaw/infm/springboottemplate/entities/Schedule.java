package ch.zhaw.infm.springboottemplate.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Beispiel-Entity-Klasse zur Verwaltung von Welten
 */
@Entity
public class Schedule implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scheduleID;

	private String startat;
	private String endatt;
	private int interval;
	private int duration;
	private String scheduleName;
	
	@ManyToOne
	private Lamp scheduleLamps;
	@ManyToOne
	private Engine scheduleEngines;
	
	
	public String getStartat() {
		return startat;
	}
	public void setStartat(String startat) {
		this.startat = startat;
	}
	public String getEndatt() {
		return endatt;
	}
	public void setEndatt(String endatt) {
		this.endatt = endatt;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	public Lamp getScheduleLamps() {
		return scheduleLamps;
	}
	public void setScheduleLamps(Lamp scheduleLamps) {
		this.scheduleLamps = scheduleLamps;
	}
	public Engine getScheduleEngines() {
		return scheduleEngines;
	}
	public void setScheduleEngines(Engine scheduleEngines) {
		this.scheduleEngines = scheduleEngines;
	}
	public Long getScheduleID() {
		return scheduleID;
	}
	
}
