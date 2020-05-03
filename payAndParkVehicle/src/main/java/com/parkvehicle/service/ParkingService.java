package com.parkvehicle.service;

import com.parkvehicle.exception.RecordNotFoundException;
import com.parkvehicle.model.ParkingEntity;
import com.parkvehicle.request.ParkingVO;

public interface ParkingService {

	public ParkingEntity parkvehicleentry(ParkingVO parking) throws Exception;

	public ParkingEntity exitparking(String vno) throws RecordNotFoundException;

}
