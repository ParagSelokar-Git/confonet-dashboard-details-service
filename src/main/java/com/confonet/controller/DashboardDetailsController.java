package com.confonet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.confonet.service.DashboardDetailsService;

@RestController
@RequestMapping("/dashboard")
public class DashboardDetailsController {
	
	private static final Logger log = LoggerFactory.getLogger(DashboardDetailsController.class);

	@Autowired
	private DashboardDetailsService custDetailsService;
	
	@GetMapping("/getCust")
	public ResponseEntity<Object> getCustomerDetails(@RequestParam Integer id) {

		log.info("API Request to get DashboardDetails");
		return custDetailsService.getCustomer(id);
	}
	
}
