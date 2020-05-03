package com.parkvehicle.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parkvehicle.client.BankServiceClient;
import com.parkvehicle.client.ParkingLotBulkClient;
import com.parkvehicle.exception.RecordNotFoundException;
import com.parkvehicle.model.ParkingEntity;
import com.parkvehicle.repository.ParkingRepository;
import com.parkvehicle.request.LotDetail;
import com.parkvehicle.request.ParkingVO;
import com.parkvehicle.request.TransactionHistory;

@Service
public class ParkingServiceImpl implements ParkingService {

	@Autowired
	ParkingRepository parkRepository;
	
	@Autowired
	ParkingLotBulkClient bulkclient;
	
	
	@Autowired
	BankServiceClient bankclient;
	

	@Transactional
	@Override
	public ParkingEntity parkvehicleentry(ParkingVO parking) throws Exception {
		ResponseEntity<LotDetail> pvehicle= bulkclient.parkvehicle(parking.getLotid(), parking.getVtype());
		if(pvehicle.getBody().getLotid()==parking.getLotid()) {
			LotDetail updatedlot=pvehicle.getBody();
			ResponseEntity<TransactionHistory> payment=bankclient.payment(parking.getCid(), updatedlot.getAmount());
			if(payment.getBody().getUserid()==parking.getCid()) {
				ParkingEntity savepark=new ParkingEntity();
				savepark.setVnumber(parking.getVnumber());
				savepark.setOwnername(parking.getOwnername());
				savepark.setOwnermobile(parking.getOwnermobile());
				savepark.setBno(updatedlot.getBno());
				savepark.setCity(updatedlot.getCity());
				savepark.setLocation(updatedlot.getLocation());
				savepark.setFloor(updatedlot.getFloor());
				savepark.setLotno(updatedlot.getLotid());
				savepark.setVehicletype(parking.getVtype());
				savepark.setAmount(updatedlot.getAmount());
				savepark.setParkingstatus("enter");
				return parkRepository.save(savepark);
			}else {
				throw new RecordNotFoundException(""+payment.getBody());
			}
			}else {
			throw new RecordNotFoundException(""+pvehicle.getBody());
		}
		
		
		
	}


	@Transactional
	@Override
	public ParkingEntity exitparking(String vno) throws RecordNotFoundException {
		Optional<ParkingEntity> parkentity=parkRepository.findByvno(vno);
		if(parkentity.isPresent()) {
			ParkingEntity pentity=parkentity.get();
			ResponseEntity<LotDetail> exitlot=bulkclient.exitvehicle(pentity.getLotno());
			if(exitlot.getBody().getLotid()==pentity.getLotno()) {
				pentity.setParkingstatus("exit");
				java.sql.Timestamp exitdate = new java.sql.Timestamp(new java.util.Date().getTime());
				pentity.setExitdate(exitdate);
				return parkRepository.save(pentity);
			}else {
				throw new RecordNotFoundException(""+exitlot.getBody());
			}
		}else {
			throw new RecordNotFoundException("Vehicle Number Not Found");
		}
	}

	
	
}
