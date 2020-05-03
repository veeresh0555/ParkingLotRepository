package com.parkvehicle.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.parkvehicle.model.ParkingEntity;


@Repository
public interface ParkingRepository extends JpaRepository<ParkingEntity, Long> {

	
	@Query("select park from ParkingEntity park where vnumber=:vnumber")
	Optional<ParkingEntity> findByvno(@Param("vnumber")String vnumber);

}
