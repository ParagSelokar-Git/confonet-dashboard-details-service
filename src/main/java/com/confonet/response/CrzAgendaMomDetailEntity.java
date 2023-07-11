package com.confonet.response;

import java.util.Optional;

import com.confonet.entity.CrzAgendaDetailsDto;
import com.confonet.entity.CrzAgendaMomDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CrzAgendaMomDetailEntity {
	private CrzAgendaMomDto crzAgendaMom;
	private CrzAgendaDetailsDto crzAgendaDetails;
	private CrzAgendaDetailsResponse crzAgendaDetailsResponse;
}
