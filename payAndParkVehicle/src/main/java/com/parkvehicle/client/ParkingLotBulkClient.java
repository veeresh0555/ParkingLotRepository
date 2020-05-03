package com.parkvehicle.client;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.parkvehicle.exception.RecordNotFoundException;
import com.parkvehicle.request.LotDetail;

@FeignClient(name = "http://parkinglotbulk/parkinglotbulk")
public interface ParkingLotBulkClient {
	
	
	@GetMapping("/lotinfo")
	public String lotinf();
	
	@GetMapping
	public ResponseEntity<List<LotDetail>> searchavailablelot() throws RecordNotFoundException;
	
	@GetMapping("/searchfilledlot")
	public ResponseEntity<List<LotDetail>> searchfilledlot() throws RecordNotFoundException;
	
	@GetMapping("/{lottype}")
	public ResponseEntity<List<LotDetail>> findByLotType(@PathVariable("lottype")long lottype) throws RecordNotFoundException;
	
	@PostMapping("/{lotid}/{lottype}")
	public ResponseEntity<LotDetail> parkvehicle(@PathVariable("lotid")long lotid,@PathVariable("lottype")long lottype) throws RecordNotFoundException;
	
	@PostMapping("/exitvehicle/{lotid}")
	public ResponseEntity<LotDetail> exitvehicle(@PathVariable("lotid")long lotid) throws RecordNotFoundException;
	
	

}
