package com.mongodb.springmongorestapi.repository;

import com.mongodb.springmongorestapi.entitiy.Kullanici;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KullaniciRepository extends MongoRepository<Kullanici, String> {


}
