/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author FebbyFebriansyah
 */
public class Pelamar extends Orang{

    private ArrayList<BerkasLamaran> arrBerkas;
    private BerkasLamaran berkas;

    public Pelamar(String id, String name, String email, long noTlp) {
        super(id, name, email, noTlp);
        arrBerkas = new ArrayList();
    }

    public void createBerkas(long idBerkas) {
        if (arrBerkas.size() != 0) {
            for (int i = 0; i < arrBerkas.size(); i++) {
                if (arrBerkas.get(i).getIdBerkas() == idBerkas) {
                    System.out.println("\nID Berkas sudah ada\n");
                } 
                else {
//                    berkas = new BerkasLamaran(idBerkas, this);
//                    arrBerkas.add(berkas);
                    System.out.println("Anda telah mempunyai berkas");
                }
            }            
        } else {
            berkas = new BerkasLamaran(idBerkas, this);
            arrBerkas.add(berkas);
        }
    }

    public BerkasLamaran getBerkas() {
        return berkas;
    }
}
