package com.example.springdatajpapostgresql.service;

import com.example.springdatajpapostgresql.dto.KisiDto;
import com.example.springdatajpapostgresql.entity.Adres;
import com.example.springdatajpapostgresql.entity.Kisi;
import com.example.springdatajpapostgresql.repo.AdresRepository;
import com.example.springdatajpapostgresql.repo.KisiReporsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {

    private final KisiReporsitory kisiReporsitory;
    private final AdresRepository adresRepository;

    @Override
    @Transactional
    public KisiDto save(KisiDto kisiDto) {
        Kisi kisi = new Kisi();
        kisi.setAd(kisiDto.getAd());
        kisi.setSoyad(kisiDto.getSoyad());
        final Kisi kisiDb = kisiReporsitory.save(kisi);

        List<Adres> adresList = new ArrayList<>();
        kisiDto.getAdresList().forEach(item -> {
            Adres adres = new Adres();
            adres.setAdres(item);
            adres.setAdresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisiDb);
            adresList.add(adres);
        });

        adresRepository.saveAll(adresList);
        kisiDto.setId(kisiDb.getId());
        return kisiDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiList = kisiReporsitory.findAll();
        List<KisiDto> kisiDtos = new ArrayList<>();
        kisiList.forEach(it -> {
            KisiDto kisiDto = new KisiDto();
            kisiDto.setAd(it.getAd());
            kisiDto.setSoyad(it.getSoyad());
            kisiDto.setId(it.getId());
            kisiDto.setAdresList(it.getAdresList().stream()
                    .map(Adres::getAdres).collect(Collectors.toList()));
            kisiDtos.add(kisiDto);
        });
        return kisiDtos;
    }

    @Override
    public Page<KisiDto> getAll(Pageable pageable) {
        return null;
    }
}
