package com.etf.korisnik_service.controller;

import com.etf.korisnik_service.repository.KorisnikAnketaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("korisnik_anketa")
@RestController
public class KorisnikAnketaController {
    @Autowired
    private KorisnikAnketaInterface korisnikAnketaRepository;
}
