package com.hwlmsp.springboot;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends MongoRepository<Customer, String> {

}
