package com.deliveryBoy.app.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deliveryBoy.app.Services.KafkaService;

class ReqBody{
	private Double lattitude;
	private Double longitude;
	private String timeStamp;
	
	public Double getLattitude() {
		return lattitude;
	}
	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getDate() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	@Override
	public String toString() {
		return "(lattitude=" + lattitude + ", longitude=" + longitude + ", timeStamp=" + timeStamp + ")";
	}
	
}


@RestController
@RequestMapping("/location")
public class Controller {
	@Autowired
	private KafkaService kafkaService;
	
	@PostMapping("/update")
	public ResponseEntity<?> updateController(@RequestBody ReqBody body){
		System.out.println(body);
		
		this.kafkaService.updateLocation(body.toString());
		return new ResponseEntity<>(Map.of("message","Location Updated"),HttpStatus.OK);
	}
}
