/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdumancic.zrna;

import hdumancic.podaci.Korisnik;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hrvoje Dumančić
 */
@Named(value = "pregledKorisnika")
@SessionScoped
public class pregledKorisnika implements Serializable {

    private List<Korisnik> listaKorisnika;
    private List<Korisnik> filtriranaListaKorisnika;
    private String poruka;
    private String inputFirstName;
    private String inputLastName;
    private String inputEmail;
    private String dropDown = "";

    public String getDropDown() {
        return dropDown;
    }

    public void setDropDown(String dropDown) {
        this.dropDown = dropDown;
    }
    
    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
    
    /**
     * Creates a new instance of pregledKorisnika
     */
    public pregledKorisnika() {
        listaKorisnika = Korisnik.dohvatiListuKorisnika();
    }
    
    public String dohvatiKorisnike() {
        listaKorisnika = Korisnik.dohvatiListuKorisnika();
        postaviPoruku("");
        return "";
    }

    
    public List<Korisnik> getFiltriranaListaKorisnika() {
        if(filtriranaListaKorisnika == null)
            filtriranaListaKorisnika = Korisnik.dohvatiListuKorisnika();
        return filtriranaListaKorisnika;
    }

    public void setFiltriranaListaKorisnika(List<Korisnik> filtriranaListaKorisnika) {
        this.filtriranaListaKorisnika = filtriranaListaKorisnika;
    }
    
    public String dohvatiPotrebneKorisnike() {
        System.out.println("Kliknuto");
        if(dropDown == null || dropDown.isEmpty()) {
            filtriranaListaKorisnika = listaKorisnika;
        } else {
            filtriranaListaKorisnika = new ArrayList<>();
            for(Korisnik a : listaKorisnika) {
                if(a.getFirstname().toLowerCase().contains(dropDown.toLowerCase()) 
                        || a.getLastname().toLowerCase().contains(dropDown.toLowerCase())) {
                    filtriranaListaKorisnika.add(a);
                }
            }
        }
        return "";
    }
    
    public String dodajKorisnika() {
        if(provjeriIspravnostPodataka()) {
            listaKorisnika.add(Korisnik.kreirajKorisnika(listaKorisnika.size()+1, 
                    inputFirstName, inputLastName, inputEmail));
            postaviPoruku("Dodan novi korisnik: " + inputFirstName + " " + inputLastName);
        }
        return "";
    }
    
    public String obrisiKorisnika(int id) {
        System.out.println("Usao sam u brisanje");
        for(Korisnik k : listaKorisnika) {
            if(k.getId() == id) {
                postaviPoruku("Obrisan korisnik: " + k.getFirstname() + " " + k.getLastname());
                listaKorisnika.remove(k);
                System.out.println("Velicina liste: " + listaKorisnika.size());
                break;
            }
        }
        return "";
    }
    
    public void postaviPoruku(String message) {
        poruka = message;
        System.out.println(message);
    }
    
    private boolean provjeriIspravnostPodataka() {
        if(inputEmail == null || inputFirstName == null || inputLastName == null) {
            postaviPoruku("Potrebni podaci za kreiranje novog putnika nisu uneseni");
            return false;
        }
        return true;
    }
    
    public String urediKorisnika(int id) {
        if(provjeriIspravnostPodataka()) {
            for(Korisnik k : listaKorisnika) {
                if (k.getId() == id) {
                    k.setFirstname(inputFirstName);
                    k.setLastname(inputLastName);
                    k.setEmail(inputEmail);
                    postaviPoruku("Korisnik ažuriran!");
                    break;
                }
            }
        }
        return "";   
    }
    
    public List<Korisnik> getListaKorisnika() {
        return listaKorisnika;
    }

    public void setListaKorisnika(List<Korisnik> listaKorisnika) {
        this.listaKorisnika = listaKorisnika;
    }

    public String getInputFirstName() {
        return inputFirstName;
    }

    public void setInputFirstName(String inputFirstName) {
        this.inputFirstName = inputFirstName;
    }

    public String getInputLastName() {
        return inputLastName;
    }

    public void setInputLastName(String inputLastName) {
        this.inputLastName = inputLastName;
    }

    public String getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(String inputEmail) {
        this.inputEmail = inputEmail;
    }
    
    public String getIdString(int id)
    {
        return String.valueOf(id);
    }
    
}
