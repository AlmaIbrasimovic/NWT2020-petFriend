package com.etf.korisnik_service.model;

import javax.persistence.*;

@Entity
@Table(name = "korisnik_zivotinja")
public class KorisnikZivotinja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Korisnik korisnik;
    @ManyToOne
    private Zivotinja zivotinja;

    public KorisnikZivotinja(Korisnik korisnik, Zivotinja zivotinja) {
        this.korisnik = korisnik;
        this.zivotinja = zivotinja;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Zivotinja getZivotinja() {
        return zivotinja;
    }

    public void setZivotinja(Zivotinja zivotinja) {
        this.zivotinja = zivotinja;
    }
}
