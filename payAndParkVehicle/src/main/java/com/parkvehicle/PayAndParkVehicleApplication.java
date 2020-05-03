package com.parkvehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.parkvehicle.config.RibbonConfiguration;

@EnableEurekaClient
@EnableFeignClients
@RibbonClient(name="payandparkvehicle",configuration = RibbonConfiguration.class)
@SpringBootApplication
public class PayAndParkVehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayAndParkVehicleApplication.class, args);
	}

}
