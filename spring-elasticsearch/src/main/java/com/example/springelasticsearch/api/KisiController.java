package com.example.springelasticsearch.api;

import com.example.springelasticsearch.entity.Kisi;
import com.example.springelasticsearch.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kisi")
public class KisiController {

    private final KisiRepository kisiRepository;


    @PostConstruct
    public void init() {
        Kisi kisi = new Kisi();
        kisi.setAd("Berkay");
        kisi.setSoyad("bB");
        kisi.setAdres("asdasdasd");
        kisi.setId("123123");
        kisi.setDogumTarihi(new Date(System.currentTimeMillis()));
        kisiRepository.save(kisi);
    }


    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
        List<Kisi> kisiList = kisiRepository.getByCustomQuery(search);
        return ResponseEntity.ok(kisiList);
    }

    @GetMapping("/contains/{search}")
    public ResponseEntity<List<Kisi>> getContains (@PathVariable String search) {
        List<Kisi> kisiList = kisiRepository.findByAdLikeOrSoyadLikeOrAdresContains(search,search,search);
        return ResponseEntity.ok(kisiList);
    }
}
