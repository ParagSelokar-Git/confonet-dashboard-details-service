package com.confonet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.confonet.entity.CrzAgendaDetailsDto;
import com.confonet.entity.CrzAgendaMomDto;
import com.confonet.repository.CrzAgendaMomRepository;
import com.confonet.response.CrzAgendaDetailsResponse;
import com.confonet.response.CrzAgendaMomDetailEntity;
import com.confonet.response.ResponseHandler;

import reactor.core.publisher.Mono;

@Service
public class DashboardDetailsServiceImpl implements DashboardDetailsService {

	@Autowired
	private CrzAgendaMomRepository crzAgendaMomRepository;

	@Autowired
	WebClient webClient;

	@Override
	public ResponseEntity<Object> getCustomer(Integer id) {

		CrzAgendaMomDetailEntity crzAgendaMomDetailEntity = new CrzAgendaMomDetailEntity();

		Optional<CrzAgendaMomDto> crzAgendaMomDto = crzAgendaMomRepository.findById(id);
		CrzAgendaMomDto momDetailDto = crzAgendaMomDto.orElse(null);
		crzAgendaMomDetailEntity.setCrzAgendaMom(momDetailDto);

		if(momDetailDto!=null) {
		CrzAgendaDetailsResponse getAgendaDetailsById = getAgendaDetailsResponseById(momDetailDto.getAgenda_id());
		crzAgendaMomDetailEntity.setCrzAgendaDetailsResponse(getAgendaDetailsById);
		}
		return ResponseHandler.generateResponse("Dashboard details fetched succesfully", HttpStatus.OK, null,
				crzAgendaMomDetailEntity);
	}

	public CrzAgendaDetailsDto getAgendaDetailsById(Integer id) {
		Mono<CrzAgendaDetailsDto> crzAgendaDetailsResponse = webClient.get().uri("/getCust?id=" + id).retrieve()
				.bodyToMono(CrzAgendaDetailsDto.class);
		return crzAgendaDetailsResponse.block();
	}

	public CrzAgendaDetailsResponse getAgendaDetailsResponseById(Integer id) {
		Mono<CrzAgendaDetailsResponse> crzAgendaDetailsResponse = webClient.get().uri("/getCust?id=" + id).retrieve()
				.bodyToMono(CrzAgendaDetailsResponse.class);
		return crzAgendaDetailsResponse.block();

	}
}
