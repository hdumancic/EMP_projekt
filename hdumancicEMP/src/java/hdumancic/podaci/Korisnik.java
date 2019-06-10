/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdumancic.podaci;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hrvoje Dumančić
 */
public class Korisnik {

    public Korisnik(int id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public Korisnik() {
    }
 
    
    private int id;
    private String firstname;
    private String lastname;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    static public List<Korisnik> dohvatiListuKorisnika() {
        List<Korisnik> lista = new ArrayList<>();
        
        lista.add(kreirajKorisnika(1,"Hrvoje", "Dumančić", "hdumancic@foi.hr"));
        lista.add(kreirajKorisnika(2,"Božo", "Čulo", "bculo@foi.hr"));
        lista.add(kreirajKorisnika(3,"Vedran", "Grbavac", "vgrbavac@foi.hr"));
        lista.add(kreirajKorisnika(4,"Darjan", "Baričević", "dbariveci@foi.hr"));
        lista.add(kreirajKorisnika(5,"Luka", "Garić", "lgaric@foi.hr"));
        lista.add(kreirajKorisnika(6,"Darko", "Gajić", "dgajic@foi.hr"));
        lista.add(kreirajKorisnika(7,"Patrik", "Fumić", "pfumic@foi.hr"));
        lista.add(kreirajKorisnika(8,"Kristijan", "Maoduš", "kmaodus@foi.hr"));
        lista.add(kreirajKorisnika(9,"Kristijan", "Carek", "kcarek@foi.hr"));
        lista.add(kreirajKorisnika(10,"Tomislav", "Horvat", "thorvat@foi.hr"));
        lista.add(kreirajKorisnika(11,"Marin", "Mačinković", "mmacinkov@foi.hr"));
        return lista;
    }
    
    static public Korisnik kreirajKorisnika(int id, String firstname, String lastname, String email) {
        return new Korisnik(id, firstname, lastname, email);
    }
}
