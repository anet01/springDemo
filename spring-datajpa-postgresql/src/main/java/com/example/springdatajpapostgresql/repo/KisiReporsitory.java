package com.example.springdatajpapostgresql.repo;

import com.example.springdatajpapostgresql.dto.KisiDto;
import com.example.springdatajpapostgresql.entity.Kisi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KisiReporsitory extends JpaRepository<Kisi, Long> {



}
