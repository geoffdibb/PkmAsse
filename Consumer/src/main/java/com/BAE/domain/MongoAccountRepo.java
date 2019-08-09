package com.BAE.domain;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.BAE.domain.repository.Search;

@Repository
public interface MongoAccountRepo extends MongoRepository<Search, Long>{
}