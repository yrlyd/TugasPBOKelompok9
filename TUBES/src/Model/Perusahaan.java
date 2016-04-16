/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
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

    public Perusahaan(String id, String name, String email, long noTlp) {
        super(id, name, email, noTlp);
//        this.maxLowongan = maxLowongan;
        daftarLowongan = new ArrayList();
    }

    @Override
    public String getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        return super.getEmail(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getNoTlp() {
        return super.getNoTlp(); //To change body of generated methods, choose Tools | Templates.
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
        Lowongan lowongan = new Lowongan(idLowongan, namaLowongan, deadline);
        daftarLowongan.add(lowongan);
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
            }
        }
        return l;
    }

    //removeLowongan tuh hapus semua??
    public void removeLowongan(long idLowongan) {
        for (int i = 0; i < daftarLowongan.size(); i++) {
            if (daftarLowongan.get(i).getIdLowongan() == idLowongan) {
                daftarLowongan.remove(i);
            }
        }
//        jumlahLowongan=0;
    }

    public void lihatPelamar() {
        //System.out.println("daftar id pelamar (lewat berkas)");
//        String namaP = "";
//        String emailP = "";
//        long idBerkasP = 0;
//        long noTelpP = 0;
//        String namaLowongan = "";
//        long idLowongan;
        System.out.println();
        System.out.println("====Daftar Pelamar yang di Approve====");
        for (int a = 0; a < daftarLowongan.size(); a++) {
            for (int b = 0; b < daftarLowongan.get(a).getJumlahBerkasDiterima(); b++) {
                if (daftarLowongan.get(a).getBerkasDiterima(b) != null) {
                    System.out.println("ID Berkas\t: " + daftarLowongan.get(a).getBerkasDiterima(b).getIdBerkas());
                    System.out.println("Nama\t\t: " + daftarLowongan.get(a).getBerkasDiterima(b).getNamaPelamar());
                    System.out.println("Email\t\t: " + daftarLowongan.get(a).getBerkasDiterima(b).getEmailPelamar());
                    System.out.println("Kontak\t\t: " + daftarLowongan.get(a).getBerkasDiterima(b).getNoTelpPelamar());
                    System.out.println("Di Approve sebagai " + daftarLowongan.get(a).getNamaLowongan() + "(ID Lowongan : " + daftarLowongan.get(a).getIdLowongan() + ")");
                    System.out.println("----------------------------------------------------------");
                }
            }
        }System.out.println();
        System.out.println("====Daftar Pelamar yang belum di Approve====");
        for (int i = 0; i < daftarLowongan.size(); i++) {
            for (int j = 0; j < daftarLowongan.get(i).getJumlahBerkasMasuk(); j++) {
//                idBerkasP = daftarLowongan.get(i).getBerkasMasuk(j).getIdBerkas();
//                namaP = daftarLowongan.get(i).getBerkasMasuk(j).getNamaPelamar();
//                emailP = daftarLowongan.get(i).getBerkasMasuk(j).getEmailPelamar();
//                noTelpP = daftarLowongan.get(i).getBerkasMasuk(j).getNoTelpPelamar();
//                id = daftarLowongan.get(i).getIdLowongan();
//                namaLowongan = daftarLowongan.get(i).getNamaLowongan();
                if (daftarLowongan.get(i).getBerkasMasuk(j) != null) {
                    System.out.println("ID Berkas\t: " + daftarLowongan.get(i).getBerkasMasuk(j).getIdBerkas());
                    System.out.println("Nama Pelamar\t: " + daftarLowongan.get(i).getBerkasMasuk(j).getNamaPelamar());
                    System.out.println("Email\t\t: " + daftarLowongan.get(i).getBerkasMasuk(j).getEmailPelamar());
                    System.out.println("Kontak\t\t: " + daftarLowongan.get(i).getBerkasMasuk(j).getNoTelpPelamar());
                    System.out.println("Melamar sebagai " + daftarLowongan.get(i).getNamaLowongan() + "(ID Lowongan : " + daftarLowongan.get(i).getIdLowongan() + ")");
                    System.out.println("----------------------------------------------------------");
                }
            }
        }
//        return (//"ID Berkas\t: "+idBerkasP
//                "\nNama Pelamar : "+namaP
//                //+"\nEmail\t: "+emailP
//                //+"\nKontak\t: "+noTelpP
//                +"\nMelamar sebagai "+namaLowongan//+"(ID Lowongan : "+id+"\n"
//                +"----------------------------------------------------------").toString();
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

    public ArrayList<Lowongan> getDaftarLowongan() {
        return daftarLowongan;
    }

}
