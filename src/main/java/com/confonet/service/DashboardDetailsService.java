package com.confonet.service;

import org.springframework.http.ResponseEntity;

public interface DashboardDetailsService {
	
	public ResponseEntity<Object> getCustomer(Integer id);
	
}
