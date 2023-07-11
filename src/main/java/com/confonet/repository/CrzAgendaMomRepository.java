package com.confonet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.confonet.entity.CrzAgendaMomDto;

@Repository
public interface CrzAgendaMomRepository extends JpaRepository<CrzAgendaMomDto, Integer>{

}
