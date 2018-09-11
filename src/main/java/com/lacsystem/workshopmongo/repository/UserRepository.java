package com.lacsystem.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lacsystem.workshopmongo.domain.User;

/**
 * @author Luiz.Cesario
 *
 */

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
