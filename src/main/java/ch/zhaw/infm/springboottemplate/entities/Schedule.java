package ch.zhaw.infm.springboottemplate.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Schedule implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scheduleID;

	private String startat;

	private String endat;
	private int interval;
	private int duration;
	private String schedulename;

	@ManyToOne
	private Lamp scheduleLamps;
	@ManyToOne
	private Engine scheduleEngines;

	public Schedule() {
	}

	public Schedule(String startat, String endat, int interval, int duration, String schedulename, Lamp scheduleLamps,
			Engine scheduleEngines) {
		this.startat = startat;
		this.endat = endat;
		this.interval = interval;
		this.duration = duration;
		this.schedulename = schedulename;
		this.scheduleLamps = scheduleLamps;
		this.scheduleEngines = scheduleEngines;
	}

	public String getStartat() {
		return startat;
	}

	public void setStartat(String startat) {
		this.startat = startat;
	}

	public String getEndatt() {
		return endat;
	}

	public void setEndatt(String endat) {
		this.endat = endat;
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
		return schedulename;
	}

	public void setScheduleName(String scheduleName) {
		this.schedulename = scheduleName;
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
