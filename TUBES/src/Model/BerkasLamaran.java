/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author FebbyFebriansyah
 */
public class BerkasLamaran implements Serializable{

    private long idBerkas;
    private Pelamar profilPelamar;

    public BerkasLamaran(long idBerkas, Pelamar pelamar) {
        this.idBerkas = idBerkas;
        profilPelamar = pelamar;
        
    }

    public BerkasLamaran(long idBerkas) {
        this.idBerkas = idBerkas;
    }

    public void setIdBerkas(long idBerkas) {
        this.idBerkas = idBerkas;
    }

    public long getIdBerkas() {
        return idBerkas;
    }

    public String getNamaPelamar() {
        return profilPelamar.getName();
    }
    public String getEmailPelamar(){
        return profilPelamar.getEmail();
    }
    public long getNoTelpPelamar(){
        return profilPelamar.getNoTlp();
    }
}
