package com.example.springbootapidocs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/pet")
@Api(value = "Pet Dökümantasyonu")
public class PetController {

    private List<Pet> petList = new ArrayList<>();


    @PostConstruct
    public void init(){
        petList.add(new Pet(1,"asdas", new Date() ));
    }

    @PostMapping
    @ApiOperation(value = "Yeni pet ekleme metodu")
    public ResponseEntity<Pet> petEkle(@RequestBody @ApiParam(value = "hayvan") Pet pet) {
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    @ApiOperation(value = "Tüm petleri getirme metodu", notes = "bu metod notu")
    public ResponseEntity<List<Pet>> getAll(){
        return ResponseEntity.ok(petList);
    }
}
