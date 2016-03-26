/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author FebbyFebriansyah
 */
public class Perusahaan extends Orang {

    private ArrayList<Lowongan> daftarLowongan;
//    private int jumlahLowongan = 0;
//    private int maxLowongan;

    public Perusahaan(long id, String name, String email, long noTlp, int maxLowongan) {
        super(id, name, email, noTlp);
//        this.maxLowongan = maxLowongan;
        daftarLowongan = new ArrayList();
    }
    /*public Perusahaan(int maxLowongan) {
        
     }*/
    /*
     di CreateLowongan nanti tambahin :
     Pekerjaan
     dsb
     Kasih try catct buat ArrayIndexOutOfBound
     */

    public void createLowongan(long idLowongan, String namaLowongan, Date deadline) {
        daftarLowongan.add(new Lowongan(idLowongan, namaLowongan, deadline));
//        jumlahLowongan++;
    }

    public Lowongan getLowongan(int i) {
        return daftarLowongan.get(i);
    }

    public Lowongan getlowonganById(long id) {
        Lowongan l = null;
        for (int i = 0; i < daftarLowongan.size(); i++) {
            if (daftarLowongan.get(i).getIdLowongan() == id) {
                l = daftarLowongan.get(i);
            } else {
                System.out.println("maaf id yang dicari tidak ditemukan");
            }
        }
        return l;
    }

    //removeLowongan tuh hapus semua??
    public void removeLowongan() {
        for (int i = 0; i < daftarLowongan.size(); i++) {
            daftarLowongan.remove(i);
        }
//        jumlahLowongan=0;
    }

    public String lihatPelamar() {
        //System.out.println("daftar id pelamar (lewat berkas)");
        String nama = null;
        for (int i = 0; i < daftarLowongan.size(); i++) {
            for (int j = 0; j < daftarLowongan.get(i).getJumlahBerkasMasuk(); j++) {
                nama = daftarLowongan.get(i).getBerkasMasuk(j).getNamaPelamar();
            }
        }
        return nama;
    }

    //Approve Pelamar tuh ngepindahin berkas jadi di terima aja
    //atau yang dari berkas di terima di setujui/di jadiin pelamarnya tuh bener keterima??
    public boolean approvePelamar(long idLowongan, long idBerkas) {
        //i adalah indeks daftarLowongan dan x adalah indeks Berkas Masuk
        boolean accept = false;
        for (int i = 0; i < daftarLowongan.size(); i++) {
            if (daftarLowongan.get(i).getIdLowongan() == idLowongan) {
                for (int j = 0; j < daftarLowongan.get(i).getJumlahBerkasMasuk(); j++) {
                    if (daftarLowongan.get(i).getBerkasMasuk(j).getIdBerkas() == idBerkas) {
                        daftarLowongan.get(i).pindahBerkas(j);
                        accept = true;
                    }
                }
            }
        }
        return accept;
    }

    public int getJumlahLowongan() {
        return daftarLowongan.size();
    }
}
