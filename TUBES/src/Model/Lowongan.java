/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author FebbyFebriansyah
 */
public class Lowongan implements Serializable {

    private long idLowongan;
    private ArrayList<BerkasLamaran> berkasMasuk;
    private ArrayList<BerkasLamaran> berkasDiterima;
    private Date deadline;
    private String namaLowongan;

    public Lowongan(long idLowongan, int maxBerkasMasuk, int maxBerkasDiterima) {
        this.idLowongan = idLowongan;
        berkasMasuk = new ArrayList();
        berkasDiterima = new ArrayList();

    }

    public Lowongan(long idLowongan, String namaLowongan, Date deadline) {
        berkasMasuk = new ArrayList();
        berkasDiterima = new ArrayList();
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
    }

    public void terimaBerkas(BerkasLamaran b) {
        berkasDiterima.add(b);
    }

    public BerkasLamaran getBerkasMasuk(int i) {
        return berkasMasuk.get(i);
    }

    public BerkasLamaran getBerkasMasukById(long id) {
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

    public void RemoveBerkasMasuk() {
        berkasMasuk.clear();
    }

    public void pindahBerkas(int i) {
        terimaBerkas(berkasMasuk.get(i));
        berkasMasuk.remove(i);
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
        return "\n\tID Lowongan : " + getIdLowongan() +"\n\tNama Lowongan : "+getNamaLowongan()+"\n\tDeadline : " + getDeadline();
    }
}
