package com.parkvehicle.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="parkinghistory")
public class ParkingEntity {

	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "parkingseq")
	@SequenceGenerator(name="parkingid",sequenceName = "parkingidseq",allocationSize = 6)
	@Column(name="parkingid",updatable = false,nullable = false)
	private long parkingid;
	
	private String vnumber;
	
	private String ownername;
	
	private String ownermobile;
	
	@Column(name="parkstatus")
	private String parkingstatus;
	
	public String getParkingstatus() {
		return parkingstatus;
	}

	public void setParkingstatus(String parkingstatus) {
		this.parkingstatus = parkingstatus;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public String getOwnermobile() {
		return ownermobile;
	}

	public void setOwnermobile(String ownermobile) {
		this.ownermobile = ownermobile;
	}

	public java.sql.Timestamp getTransdate() {
		return transdate;
	}

	public void setTransdate(java.sql.Timestamp transdate) {
		this.transdate = transdate;
	}

	private long bno;
	
	private String city;
	
	private String location;
	
	private long vehicletype;
	
	private long floor;
	
	private long lotno;
	
	private Double amount;//2 or 4 wheels
	
	@Column(name="enterdate")
	@CreationTimestamp
	private java.sql.Timestamp transdate;
	
	private Timestamp exitdate;

	public long getParkingid() {
		return parkingid;
	}

	public void setParkingid(long parkingid) {
		this.parkingid = parkingid;
	}

	public String getVnumber() {
		return vnumber;
	}

	public void setVnumber(String vnumber) {
		this.vnumber = vnumber;
	}

	public long getBno() {
		return bno;
	}

	public void setBno(long bno) {
		this.bno = bno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(long vehicletype) {
		this.vehicletype = vehicletype;
	}

	public long getFloor() {
		return floor;
	}

	public void setFloor(long floor) {
		this.floor = floor;
	}

	public long getLotno() {
		return lotno;
	}

	public void setLotno(long lotno) {
		this.lotno = lotno;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Timestamp getExitdate() {
		return exitdate;
	}

	public void setExitdate(Timestamp exitdate) {
		this.exitdate = exitdate;
	}
	
	
	
	
	
	
	
	
	
	
	
}
