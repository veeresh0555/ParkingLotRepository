package com.parkvehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkvehicle.client.ParkingLotBulkClient;
import com.parkvehicle.exception.RecordNotFoundException;
import com.parkvehicle.model.ParkingEntity;
import com.parkvehicle.request.LotDetail;
import com.parkvehicle.request.ParkingVO;
import com.parkvehicle.service.ParkingService;

@RestController
@RequestMapping("/paypark")
public class ParkingController {
	
	@Autowired
	Environment env;
	
	@Autowired
	ParkingService parkingservice;
	
	@Autowired
	ParkingLotBulkClient bulkclient;

	@GetMapping("/parkinginfo")
	public String parkinfo() {
		String port=env.getProperty("local.server.port");
		return "PayAndParkVehicle service Running port on "+port;
	}
	
	@GetMapping("/lotinfo")
	public String lotinf() {
		return bulkclient.lotinf();
	}
	
	@GetMapping
	public ResponseEntity<List<LotDetail>> searchavailablelot() throws RecordNotFoundException{
		return bulkclient.searchavailablelot();
	}
	
	@GetMapping("/searchfilledlot")
	public ResponseEntity<List<LotDetail>> searchfilledlot() throws RecordNotFoundException{
		return bulkclient.searchfilledlot();
	}
	
	@GetMapping("/{lottype}")
	public ResponseEntity<List<LotDetail>> findByLotType(@PathVariable("lottype")long lottype) throws RecordNotFoundException{
		return bulkclient.findByLotType(lottype);
	}
	
	@PostMapping
	public ResponseEntity<ParkingEntity> parkvehicle(ParkingVO parking) throws Exception{
		ParkingEntity parkvehickle=parkingservice.parkvehicleentry(parking);
		return new ResponseEntity<ParkingEntity>(parkvehickle, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/exitvehicle/{vno}")
	public ResponseEntity<ParkingEntity> exitvehicle(@PathVariable("vno")String vno) throws RecordNotFoundException{
		ParkingEntity exitpark=parkingservice.exitparking(vno);
		return new ResponseEntity<>(exitpark,new HttpHeaders(), HttpStatus.OK);
	}
	

	
	
	
	
	
	
	
	
	
	
}
