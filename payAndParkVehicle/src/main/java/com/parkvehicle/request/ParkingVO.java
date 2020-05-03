package com.parkvehicle.request;

public class ParkingVO {

	private long cid;
	private String vnumber;
	private String ownername;
	private String ownermobile;
	public String getOwnermobile() {
		return ownermobile;
	}
	public void setOwnermobile(String ownermobile) {
		this.ownermobile = ownermobile;
	}
	private long vtype;
	private long lotid;
	
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public String getVnumber() {
		return vnumber;
	}
	public void setVnumber(String vnumber) {
		this.vnumber = vnumber;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public long getVtype() {
		return vtype;
	}
	public void setVtype(long vtype) {
		this.vtype = vtype;
	}
	public long getLotid() {
		return lotid;
	}
	public void setLotid(long lotid) {
		this.lotid = lotid;
	}
	
	
	
	
}
