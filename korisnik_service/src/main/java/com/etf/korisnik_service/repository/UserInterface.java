package com.etf.korisnik_service.repository;

import com.etf.korisnik_service.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserInterface extends CrudRepository<User,Integer> {}
