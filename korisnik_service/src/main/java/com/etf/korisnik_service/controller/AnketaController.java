package com.etf.korisnik_service.controller;

import com.etf.korisnik_service.repository.AnketaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("anketa")
@RestController
public class AnketaController {
    @Autowired
    private AnketaInterface anketaRepository;
}