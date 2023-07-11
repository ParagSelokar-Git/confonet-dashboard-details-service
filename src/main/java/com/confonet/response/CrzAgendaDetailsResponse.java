package com.confonet.response;

import java.io.Serializable;
import java.sql.Date;

import com.confonet.entity.CrzAgendaDetailsDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrzAgendaDetailsResponse implements Serializable{

	private Integer agenda_id;
	
	private String agenda_name;
	
	private String title_of_meeting;

	private String meeting_mode;

	private String meeting_link;

	private String meeting_venue;

	private Date agenda_creation_date;

	private Date meeting_start_date;

	private Date meeting_end_date;

	private String meeting_day_wise_details;

	private Integer agenda_history_id;

	private String status;

	private Integer created_by;

	private Date created_on;

	private Integer updated_by;

	private Date updated_on;

	private String remarks;
}
