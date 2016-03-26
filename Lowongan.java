/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author FebbyFebriansyah
 */
public class Lowongan {

    private long idLowongan;
    private ArrayList<BerkasLamaran> berkasMasuk;
    private ArrayList<BerkasLamaran> berkasDiterima;
    private Date deadline;
    private String namaLowongan;
//    private int jumlahBerkasMasuk = 0;
//    private int jumlahBerkasDiterima = 0;
//    private int maxBerkasMasuk;
//    private int maxBerkasDiterima;

    public Lowongan(long idLowongan, int maxBerkasMasuk, int maxBerkasDiterima) {
        this.idLowongan = idLowongan;
//        this.maxBerkasMasuk = maxBerkasMasuk;
//        this.maxBerkasDiterima = maxBerkasDiterima;
        berkasMasuk = new ArrayList();
//        berkasMasuk[0] = new BerkasLamaran(00000);
        berkasDiterima = new ArrayList();

    }

    public Lowongan(long idLowongan, String namaLowongan, Date deadline) {
        this.idLowongan = idLowongan;
        this.namaLowongan = namaLowongan;
        this.deadline = deadline;
    }

    public String getNamaLowongan() {
        return namaLowongan;
    }

    public void setDeadline(Date dealine) {
        this.deadline = deadline;
    }

    public void setIdLowongan(long idLowongan) {
        this.idLowongan = idLowongan;
    }

    public long getIdLowongan() {
        return idLowongan;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void addBerkas(BerkasLamaran b) {
        berkasMasuk.add(b);
//        jumlahBerkasMasuk++;
    }

    public void terimaBerkas(BerkasLamaran b) {
        berkasDiterima.add(b);
//        jumlahBerkasDiterima++;
    }

    public BerkasLamaran getBerkasMasuk(int i) {
        return berkasMasuk.get(i);
    }

    public BerkasLamaran getBerkasMasukById(int id) {
        BerkasLamaran b = null;
        for (int i = 0; i < berkasMasuk.size(); i++) {
            if (berkasMasuk.get(i).getIdBerkas() == id) {
                b = berkasMasuk.get(i);
            } else {
                System.out.println("maaf, id yang anda cari tidak ditemukan");
            }
        }
        return b;
    }

    //Remove Berkas Masuk tuh di hapus semua atau cukup satu aja?
    public void RemoveBerkasMasuk() {
        berkasMasuk.clear();
//        for (int i = 0; i < berkasMasuk.size(); i++) {
//            berkasMasuk.remove(i);
//        }
    }

    //Nanti yang pindah Berkas ini pake try catch
    public void pindahBerkas(int i) {
        //berkasDiterima[jumlahBerkasDiterima] = berkasMasuk[i];
        terimaBerkas(berkasMasuk.get(i));
    }

    public BerkasLamaran getBerkasDiterima(int i) {
        return berkasDiterima.get(i);
    }

    public int getJumlahBerkasMasuk() {
        return berkasMasuk.size();
    }

    public int getJumlahBerkasDiterima() {
        return berkasDiterima.size();
    }

    public String toString() {
        return "ID Lowongan : " + getIdLowongan() +"\nNama Lowongan : "+getNamaLowongan()+"\nDeadline : " + getDeadline();
    }
}

