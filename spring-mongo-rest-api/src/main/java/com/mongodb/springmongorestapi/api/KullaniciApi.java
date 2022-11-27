package com.mongodb.springmongorestapi.api;



import com.mongodb.springmongorestapi.entitiy.Kullanici;
import com.mongodb.springmongorestapi.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/kullanici")
public class KullaniciApi {

    @Autowired
    private KullaniciRepository kullaniciRepository; //Servise layerı koyulmalı.. şimdilik böyle

    @PostConstruct
    public void init() {
        Kullanici kullanici = new Kullanici();
        kullanici.setAdi("Berkay");
        kullanici.setSoyadi("bB");
        kullaniciRepository.save(kullanici);
    }

    @PostMapping
    public ResponseEntity<Kullanici> ekle(@RequestBody Kullanici kullanici){
        return ResponseEntity.ok(kullaniciRepository.save(kullanici));
    }

    @GetMapping
    public ResponseEntity<List<Kullanici>> tumunuListele(){
        return ResponseEntity.ok(kullaniciRepository.findAll());
    }

}
