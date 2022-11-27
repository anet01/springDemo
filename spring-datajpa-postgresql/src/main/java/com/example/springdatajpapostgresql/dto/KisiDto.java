package com.example.springdatajpapostgresql.dto;

import com.example.springdatajpapostgresql.entity.Adres;
import lombok.*;

import java.util.List;

@Data
public class KisiDto {

    private Long id;
    private String ad;
    private String soyad;
    private List<String> adresList;
}
