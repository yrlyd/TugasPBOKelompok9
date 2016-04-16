/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author FebbyFebriansyah
 */
import Database.ManageFile;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Aplikasi {

    private List<Perusahaan> daftarPerusahaan;
    private List<Pelamar> daftarPelamar;
    private ManageFile file;
//    private Console console;
//    private int jumlahPerusahaan;
//    private int jumlahPelamar;

//    public Aplikasi(int maxPerusahaan, int maxPelamar) {
//        daftarPerusahaan = new ArrayList<>();
//        jumlahPerusahaan = 0;
//        daftarPelamar = new ArrayList<>();
//        jumlahPelamar = 0;
//    }
    public Aplikasi() throws IOException {
        daftarPerusahaan = new ArrayList<>();
        daftarPelamar = new ArrayList<>();
        file = new ManageFile();
        loadPerusahaan();
        loadPelamar();
//        mainMenu();
    }

    public void loadPelamar() throws FileNotFoundException, IOException {
        try {
            daftarPelamar = (ArrayList<Pelamar>) file.getObject("filePelamar.dat");
        } catch (FileNotFoundException fnfe) {
            File f = new File("filePelamar.dat");
            f.createNewFile();
        } catch (EOFException eof) {
            daftarPelamar = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }

    public void savePelamar() throws FileNotFoundException, IOException {
        try {
            file.saveObject(daftarPelamar, "filePelamar.dat");
        } catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }

    public void loadPerusahaan() throws FileNotFoundException, IOException {
        try {
            daftarPerusahaan = (ArrayList<Perusahaan>) file.getObject("filePerusahaan.dat");
        } catch (FileNotFoundException fnfe) {
            File f = new File("filePerusahaan.dat");
            f.createNewFile();
        } catch (EOFException eof) {
            daftarPerusahaan = new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }

    public void savePerusahaan() throws FileNotFoundException, IOException {
        try {
            file.saveObject(daftarPerusahaan, "filePerusahaan.dat");
        } catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException("file not found");
        } catch (IOException ex) {
            throw new IOException("error " + ex.getMessage());
        }
    }


    public void lihatLowongan() {
        for (int i = 0; i < daftarPerusahaan.size(); i++) {
            if (daftarPerusahaan.get(i) == null) {
                System.out.println("Tidak ada Perusahaan yang membuka lowongan");
            } else {
                for (int j = 0; j < daftarPerusahaan.get(i).getJumlahLowongan(); j++) {
                    System.out.print("Nama Perusahaan : " + daftarPerusahaan.get(i).getName());
                    System.out.println(daftarPerusahaan.get(i).getLowongan(j));
                    System.out.println("-----------------------------------------\n");
                }
            }
        }
    }

    public Lowongan cariLowongan(String nama, Perusahaan perusahaan) {
//        Lowongan lowongan = null;
//        for(int i = 0;i<daftarPerusahaan.size();i++){
//            for(int j;)
//        }
//        for (int i = 0; i < perusahaan.getJumlahLowongan(); i++) {
//            if (perusahaan.getLowongan(i).getNamaLowongan() == nama) {
//                lowongan = perusahaan.getLowongan(i);
//            }
//        }
        for (Lowongan l : perusahaan.getDaftarLowongan()) {
            if (l.getNamaLowongan().equals(nama)) {
                return l;
            }
        }
        return null;
    }

    public void daftarLowongan(Pelamar p, Lowongan lowongan) {
//        lowongan.addBerkas(p.getBerkas());
        boolean ada = false;
        for (int i = 0; i < daftarPerusahaan.size(); i++) {
            for (int j = 0; j < daftarPerusahaan.get(i).getDaftarLowongan().size(); j++) {
                if (daftarPerusahaan.get(i).getLowongan(j).equals(lowongan)) {
                    if (daftarPerusahaan.get(i).getLowongan(j).getBerkasMasukById(p.getBerkas().getIdBerkas()) == null) {
                        daftarPerusahaan.get(i).getLowongan(j).addBerkas(p.getBerkas());
                    } else {
                        ada = true;
                    }
                }
            }
        }
        if (ada == true) {
            System.out.println("\nAnda sudah mendaftar ke suatu lowongan");
        } else {
            System.out.println("\nAnda berhasil didaftarkan");
        }
    }

    public void addPerusahaan(Perusahaan perusahaan) {
        daftarPerusahaan.add(perusahaan);
//        jumlahPerusahaan++;
    }

    public void addPelamar(Pelamar pelamar) {
        daftarPelamar.add(pelamar);
//        jumlahPelamar++;
    }

    public Pelamar getPelamar(String id) {
        Pelamar pelamar = null;
        for (int i = 0; i < daftarPelamar.size(); i++) {
            if (daftarPelamar.get(i).getId().equals(id)) {
                pelamar = daftarPelamar.get(i);
            }
        }
        return pelamar;
    }

    public Perusahaan cariPerusahaan(String nama) {
        for (Perusahaan p : daftarPerusahaan) {
            if (p.getName().equals(nama)) {
                return p;
            }
        }
        return null;
    }
    public String cariIdPerusahaan(String Id){
        for (Perusahaan p : daftarPerusahaan){
            if (p.getId().equals(Id)){
                return p.getId();
            }
        }
        return null;
    }
    public Pelamar cariPelamar(String nama) {
        for (Pelamar p : daftarPelamar) {
            if (p.getName().equals(nama)) {
//                return p;
            }
        }
        return null;
    }
    public String cariIdPelamar(String Id){
        for (Pelamar p : daftarPelamar){
            if (p.getId().equals(Id)){
                return p.getId();
            }
        }
        return null;
    }

    public void deletePelamar(String id) {
        for (int i = 0; i < daftarPelamar.size(); i++) {
            if (daftarPelamar.get(i).getId() == id) {
                daftarPelamar.remove(i);
            }
        }
//        jumlahPelamar--;
    }

    public Perusahaan getPerusahaan(String id) {
        Perusahaan perusahaan = null;
        for (int i = 0; i < daftarPerusahaan.size(); i++) {
            if (daftarPerusahaan.get(i).getId().equals(id)) {
                perusahaan = daftarPerusahaan.get(i);
            }
        }
        return perusahaan;
    }

    public void deletePerusahaan(String id) {
        for (int i = 0; i < daftarPerusahaan.size(); i++) {
            if (daftarPerusahaan.get(i).getId() == id) {
                daftarPerusahaan.remove(i);
            }
        }
//        jumlahPerusahaan--;
    }

    public boolean cekPemberitahuan(long idBerkas) {
        boolean diterima = false;
        for (int i = 0; i < daftarPerusahaan.size(); i++) {
            for (int j = 0; j < daftarPerusahaan.get(i).getDaftarLowongan().size(); j++) {
                for (int k = 0; k < daftarPerusahaan.get(i).getLowongan(j).getJumlahBerkasDiterima(); k++) {
                    if (daftarPerusahaan.get(i).getLowongan(j).getBerkasDiterima(k).getIdBerkas() == idBerkas) {
                        diterima = true;
                    }
                }
            }
        }
        return diterima;
    }

    public Perusahaan cekPerusahaanPenerima(long idBerkas) {
        boolean diterima = false;
        Perusahaan penerima = null;
        for (int i = 0; i < daftarPerusahaan.size(); i++) {
            for (int j = 0; j < daftarPerusahaan.get(i).getDaftarLowongan().size(); j++) {
                for (int k = 0; k < daftarPerusahaan.get(i).getLowongan(j).getJumlahBerkasDiterima(); k++) {
                    if (daftarPerusahaan.get(i).getLowongan(j).getBerkasDiterima(k).getIdBerkas() == idBerkas) {
                        diterima = true;
                    }
                }
            }
            if (diterima == true) {
                penerima = daftarPerusahaan.get(i);
            }
        }
        return penerima;
    }

    public Lowongan cekLowonganYangDiterima(long idBerkas) {
        boolean diterima = false;
        Lowongan jabatan = null;
        for (int i = 0; i < daftarPerusahaan.size(); i++) {
            for (int j = 0; j < daftarPerusahaan.get(i).getDaftarLowongan().size(); j++) {
                for (int k = 0; k < daftarPerusahaan.get(i).getLowongan(j).getJumlahBerkasDiterima(); k++) {
                    if (daftarPerusahaan.get(i).getLowongan(j).getBerkasDiterima(k).getIdBerkas() == idBerkas) {
                        diterima = true;
                    }
                }
                if (diterima == true) {
                    jabatan = daftarPerusahaan.get(i).getLowongan(j);
                }
            }
        }
        return jabatan;
    }

    public List<Pelamar> getDaftarPelamar() {
        return daftarPelamar;
    }

    public List<Perusahaan> getDaftarPerusahaan() {
        return daftarPerusahaan;
    }
    
}
