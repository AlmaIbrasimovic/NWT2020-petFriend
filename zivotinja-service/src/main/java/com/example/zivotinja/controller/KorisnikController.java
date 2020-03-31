package com.example.zivotinja.controller;
import com.example.zivotinja.model.Korisnik;
import com.example.zivotinja.service.KorisnikService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class KorisnikController {

    private KorisnikService korisnikService;
    KorisnikController (KorisnikService korisnikService) {
        this.korisnikService = korisnikService;

    }

    // GET metode
    @GetMapping("/korisnici")
    List<Korisnik> all() {
        return korisnikService.findAll();
    }

    @GetMapping ("/korisnici/{id}")
    public Korisnik one (@PathVariable Long id) {
        return korisnikService.findById(id);
    }

    /*
    // DELETE metode
    @DeleteMapping("/korisnici")
    void izbrisiSveKorisnike() {
        korisnikRepository.deleteAll();
    }

    @DeleteMapping ("korisnici/{id}")
    void izbrisiKorisnika (@PathVariable Long id) {
        korisnikRepository.deleteById(id);
    }

    // PUT metode
    @PutMapping("/korisnici/{id}")
    Korisnik updateKorisnika(@RequestBody Korisnik noviKorisnik, @PathVariable Long id) {
        return korisnikRepository.findById(id)
                .map(korisnik -> {
                    korisnik.setId(noviKorisnik.getId());
                    return korisnikRepository.save(korisnik);
                })
                .orElseGet(() -> {
                    noviKorisnik.setId(id);
                    return korisnikRepository.save(noviKorisnik);
                });
    }

    // POST metode
    @PostMapping ("/korisnici")
    Korisnik noviKorisnik (@RequestBody Korisnik nKor) {
        return korisnikRepository.save(nKor);
    }
    */

}

