/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewConsole;

import Model.Aplikasi;
import Model.Lowongan;
import Model.Pelamar;
import Model.Perusahaan;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author FebbyFebriansyah
 */
public class Console {

    private Aplikasi model;
    private Scanner in;
    private Scanner st;

    public Console(Aplikasi model) throws IOException {
        this.model = model;
        in = new Scanner(System.in);
        st = new Scanner(System.in);
        mainMenu();
    }

    public void menuPerusahaan() throws IOException {
        int pil, ulang = 0;
        String id;
        String namaLowongan;
//        Scanner in = new Scanner(System.in);
//        Scanner st = new Scanner(System.in);

        System.out.print("Masukkan ID Perusahaan\t: ");
        id = st.nextLine();
//        try {
        if (model.getPerusahaan(id) != null) {
            do {
                System.out.println("\n***Perusahaan " + model.getPerusahaan(id).getName() + "***\n");
                System.out.println("Menu Perusahaan");
                System.out.println("===============");
                System.out.println("1. Membuat Lowongan");
                System.out.println("2. Lihat Pelamar");
                System.out.println("3. Approve Pelamar");
                System.out.println("4. Hapus Semua Berkas yang Masuk");
                System.out.println("5. Hapus Lowongan");
                System.out.println("9. Logout");
                System.out.println("0. exit");
                System.out.print("\nInput Pilihan : ");
                pil = in.nextInt();
                switch (pil) {
                    case 1:
                        long idLowongan;
                        String deadline;
                        System.out.println("Membuat Lowongan");
                        System.out.println("================");
                        System.out.print("ID Lowongan\t: ");
                        idLowongan = in.nextLong();
                        st.nextLine();
                        System.out.print("Nama Lowongan\t : ");
                        namaLowongan = st.nextLine();
                        System.out.print("Deadline(dd-MMM-yyyy)\t: ");
                        deadline = st.next();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                        Date date = null;
                        try {
                            date = dateFormat.parse(deadline);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        model.getPerusahaan(id).createLowongan(idLowongan, namaLowongan, date);
                        System.out.println("Lowongan berhasil dibuat");
                        break;
                    case 2:
                        try {
                            System.out.println("Lihat Pelamar");
                            System.out.println("=============");
                            model.getPerusahaan(id).lihatPelamar();
//                            if (getPerusahaan(id).lihatPelamar() != null) {
//                                System.out.println(getPerusahaan(id).lihatPelamar());
//                            } else {
//                                System.out.println("Tidak ada Pelamar");
//                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Maaf, Karena Terjadi Kesalahan");
                            System.out.println("Akun Logout Secara Otomatis");
                            mainMenu();
                        }
                        break;
                    case 3:
                        long i,
                         j;
                        try {
                            System.out.println("Approve Pelamar");
                            System.out.println("===============");
                            System.out.print("Masukkan ID Lowongan\t: ");
                            i = in.nextInt();
                            System.out.print("Masukkan ID Berkas Masuk: ");
                            j = in.nextInt();
                            if (model.getPerusahaan(id).approvePelamar(i, j) == true) {
                                System.out.println("Pelamar Berhasil di Approve");
                            } else {
                                System.out.println("Pelamar tidak berhasil di Approve");
                                System.out.println("Karena ID Lowongan atau ID Berkas Masuk tidak ditemukan");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Maaf, Karena Terjadi Kesalahan");
                            System.out.println("Akun Logout Secara Otomatis");
                            mainMenu();
                        }
                        break;
                    case 4:
                        System.out.println("Hapus Semua Berkas yang Masuk");
                        System.out.println("=============================");
                        System.out.print("Masukkan nama lowongannya : ");
                        String hapusBerkas = st.nextLine();
                        if (model.cariLowongan(hapusBerkas, model.getPerusahaan(id)) != null) {
                            Lowongan hapusLowongan = model.cariLowongan(hapusBerkas, model.getPerusahaan(id));
                            model.getPerusahaan(id).getlowonganById(hapusLowongan.getIdLowongan()).RemoveBerkasMasuk();
                            System.out.println("Berkas yang masuk ke lowongan " + hapusBerkas + " berhasil dihapus");
                        } else {
                            System.out.println("Nama Lowongan tidak ditemukan");
                        }
                        break;
                    case 5:
                        System.out.println("Hapus Lowongan");
                        System.out.println("==============");
//                        System.out.println("Catatan : Dalam menghapus lowongan ini"
//                        +"\n\tmaka pelamar yang telah di Approve juga akan terhapus"
//                                + "\n\tKarena Anda dianggap telah memili");
                        System.out.print("Masukkan ID Lowongan yang akan dihapus : ");
                        long hapusLowongan = in.nextLong();
                        if (model.getPerusahaan(id).getlowonganById(hapusLowongan) != null) {
                            model.getPerusahaan(id).removeLowongan(hapusLowongan);
                            System.out.println("Lowongan berhasil dihapus");
                        } else {
                            System.out.println("Lowongan tidak ditemukan");
                        }
                        break;
                    case 9:
                        model.savePerusahaan();
                        mainMenu();
                        ulang = 1;
                        break;
                    case 0:
                        model.savePelamar();
                        model.savePerusahaan();
                        ulang = 1;
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            } while (ulang == 0);
        } else {
            //pas udah di delete akunnya kok malah error ya?, padahal akun yg null ituh udh masuk ke else harusnya
            System.out.println("\nID Perusahaan tidak ditemukan\n");
            mainMenu();
        }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }

    public void menuPelamar() throws IOException {
        int pil, ulang = 0;
        String id; 
        long idLowongan, idBerkas;
        String namaPerusahaan, namaLowongan;
//        Scanner in = new Scanner(System.in);
//        Scanner st = new Scanner(System.in);
        System.out.print("Masukkan username: ");
        id = st.nextLine();
        if (model.getPelamar(id) != null) {
            do {
                System.out.println("\n***Hi! " + model.getPelamar(id).getName() + "***\n");
                System.out.println("Menu Pelamar");
                System.out.println("============");
                System.out.println("1. Buat Berkas");
                System.out.println("2. Lihat Semua Lowongan");
                System.out.println("3. Cari Lowongan");
                System.out.println("4. Daftar Lowongan");
                System.out.println("5. Cek Pemberitahuan");
                System.out.println("9. Logout");
                System.out.println("0. Exit");
                System.out.print("\nInput Pilihan : ");
                pil = in.nextInt();
                switch (pil) {
                    case 1:
                        System.out.println("Buat Berkas");
                        System.out.println("===========");
                        System.out.print("Masukkan ID untuk Berkas Lamaran : ");
                        idBerkas = in.nextLong();
                        model.getPelamar(id).createBerkas(idBerkas);
                        break;
                    case 2:
                        System.out.println("Lihat Semua Lowongan");
                        System.out.println("====================");
                        try {
                            model.lihatLowongan();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Maaf, Karena Terjadi Kesalahan");
                            System.out.println("Akun Logout Secara Otomatis");
                            mainMenu();
                        }
                        break;
                    case 3:
                        try {
                            String namaCari;
                            System.out.println("Cari Lowongan");
                            System.out.println("=============");
                            System.out.print("Masukkan Nama Perusahaan : ");
                            namaCari = st.nextLine();
                            Perusahaan p = model.cariPerusahaan(namaCari);
                            if (p != null) {
                                System.out.print("Masukkan Nama Lowongan : ");
                                namaLowongan = st.nextLine();
                                if (model.cariLowongan(namaLowongan, p) != null) {
                                    Lowongan low = model.cariLowongan(namaLowongan, p);
                                    System.out.println("Lowongan yang Anda maksud ditemukan");
                                    System.out.println("Perusahaan " + p.getName() + " membuka lowongan " + low.getNamaLowongan());
                                } else {
                                    System.out.println("Lowongan yang Anda maksud tidak ditemukan");
                                }
                            } else {
                                System.out.println("Nama Perusahaan Tidak Ditemukan");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Maaf, Karena Terjadi Kesalahan");
                            System.out.println("Akun Logout Secara Otomatis");
                            mainMenu();
                        }
                        break;

                    case 4:
//                        try {
                        String namaCari;
                        System.out.println("Daftar Lowongan");
                        System.out.println("===============");
                        if (model.getPelamar(id).getBerkas() != null) {
                            System.out.print("Masukkan Nama Perusahaan yang Ingin dilamar : ");
                            namaCari = st.nextLine();
//                            for (int i = 0; i < daftarPerusahaan.size(); i++) {
//                                if (daftarPerusahaan.get(i).getName() == namaCari) {
//                                    perusahaan = daftarPerusahaan.get(i);
//                                }
//                            }
                            Perusahaan p = model.cariPerusahaan(namaCari);
                            if (p == null) {
                                System.out.println("\nNama Perusahaan Tidak Ditemukan\n");
                            } else {
                                System.out.print("Masukkan Nama Lowongan yang Ingin dilamar: ");
                                namaLowongan = st.nextLine();
                                Lowongan lowongan = model.cariLowongan(namaLowongan, p);
                                if (lowongan != null) {
                                    System.out.println("Lowongan yang Anda maksud ditemukan");
                                    System.out.println("Perusahaan " + p.getName() + " membuka lowongan " + lowongan.getNamaLowongan());
                                    model.daftarLowongan(model.getPelamar(id), lowongan);
//                                System.out.println("\nAnda berhasil didaftarkan");
                                } else {
                                    System.out.println("Lowongan yang Anda maksud tidak ditemukan");
                                }
                            }
                        } else {
                            System.out.println("Anda perlu membuat berkas terlebih dahulu");
                        }
//                        } catch (Exception e) {
//                            System.out.println(e.getMessage());
//                            System.out.println("Maaf, Karena Terjadi Kesalahan");
//                            System.out.println("Akun Logout Secara Otomatis");
//                            mainMenu();
//                        }
                        break;
//                    case 8 : 
//                        System.out.println(getPelamar(id).getBerkas());
                    case 5:
                        System.out.println("Cek Pemberitahuan");
                        System.out.println("=================");
                        if (model.getPelamar(id).getBerkas() != null) {
                            if (model.cekPemberitahuan(model.getPelamar(id).getBerkas().getIdBerkas()) == true) {
                                Perusahaan penerima = model.cekPerusahaanPenerima(model.getPelamar(id).getBerkas().getIdBerkas());
                                Lowongan jabatan = model.cekLowonganYangDiterima(model.getPelamar(id).getBerkas().getIdBerkas());
                                System.out.println("=======================================================");
                                System.out.println("Selamat " + model.getPelamar(id).getName() + " !\n"
                                        + "Anda diterima di Perusahaan " + penerima.getName()
                                        + "\nsebagai " + jabatan.getNamaLowongan());
                                System.out.println("=======================================================");
                            } else {
                                System.out.println("Anda belum memiliki pemberitahuan");
                            }
                        } else {
                            System.out.println("Anda perlu membuat berkas apabila ingin melamar");
                        }
                        break;
                    case 9:
                        model.savePelamar();
                        ulang = 1;
                        mainMenu();
                        break;
                    case 0:
                        model.savePelamar();
                        model.savePerusahaan();
                        ulang = 1;
                        System.exit(0);
                }
            } while (ulang == 0);
        } else {
            System.out.println("\n username tidak di temukan\n");
            mainMenu();
        }
    }

    public void menuBuatAkun() throws IOException {
        int pil, maxLowongan, ulang = 0;
        String id;
        long noTlp;
        String nama, email;
//        Scanner in = new Scanner(System.in);
//        Scanner st = new Scanner(System.in);
        do {
            //Runtime.getRuntime().exec("cls");
            System.out.println("Buat Akun");
            System.out.println("=========");
            System.out.println("1. Buat Akun Pelamar");
            System.out.println("2. Buat Akun Perusahaan");
            System.out.println("9. Kembali ke Main Menu");
            System.out.println("0. Exit");
            System.out.print("\nInput Pilihan : ");
            pil = in.nextInt();
            switch (pil) {
                case 1:
                    Pelamar pelamar;
                    System.out.println("Buat Akun Pelamar");
                    System.out.println("=================");
                    System.out.print("username\t\t: ");
                    id = st.nextLine();
                    System.out.print("Nama\t\t: ");
                    nama = st.nextLine();
                    System.out.print("Email\t\t: ");
                    email = st.nextLine();
                    System.out.print("No.Telepon/HP\t: ");
                    noTlp = in.nextLong();
                    pelamar = new Pelamar(id, nama, email, noTlp);
                    model.addPelamar(pelamar);
                    model.savePelamar();
                    mainMenu();
                    ulang = 1;
                    break;
                case 2:
                    Perusahaan perusahaan;
                    System.out.println("Buat Akun Perusahaan");
                    System.out.println("====================");
                    System.out.print("ID Perusahaan\t\t: ");
                    id = st.nextLine();
                    System.out.print("Nama Perusahaan\t\t: ");
                    nama = st.nextLine();
                    System.out.print("Email Perusahaan\t: ");
                    email = st.nextLine();
                    System.out.print("Kontak Perusahaan\t: ");
                    noTlp = in.nextLong();
//                    System.out.print("Maximum Lowongan\t: ");
//                    maxLowongan = in.nextInt();
                    perusahaan = new Perusahaan(id, nama, email, noTlp);
                    model.addPerusahaan(perusahaan);
                    model.savePerusahaan();
                    mainMenu();
                    ulang = 1;
                    break;
                case 9:
                    mainMenu();
                    ulang = 1;
                    break;
                case 0:
                    model.savePelamar();
                    model.savePerusahaan();
                    ulang = 1;
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (ulang == 0);
    }

    //Di menuHapusAkun kasih try catch
    public void menuHapusAkun() throws IOException {
        int pil, ulang = 0;
        String id;
//        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Hapus Akun");
            System.out.println("==========");
            System.out.println("1. Hapus Akun Pelamar");
            System.out.println("2. Hapus Akun Perusahaan");
            System.out.println("9. Kembali ke Main Menu");
            System.out.println("0. Exit");
            System.out.print("\nInput Pilihan : ");
            pil = in.nextInt();
            switch (pil) {
                case 1:
                    System.out.print("Masukkan username\t: ");
                    id = st.nextLine();
                    if (model.getPelamar(id) != null) {
                        model.deletePelamar(id);
                        System.out.println("Akun Pelamar Berhasil dihapus");
                    } else {
                        System.out.println("username tidak di temukan");
                    }
                    model.savePelamar();
                    ulang = 1;
                    mainMenu();
                    break;
                case 2:
                    System.out.print("Masukkan ID Perusahaan\t: ");
                    id = st.nextLine();
                    if (model.getPerusahaan(id) != null) {
                        model.deletePerusahaan(id);
                        System.out.println("Akun Perusahaan Berhasil dihapus");
                    } else {
                        System.out.println("ID perusahaan tidak di temukan");
                    }
                    model.savePerusahaan();
                    ulang = 1;
                    mainMenu();
                    break;
                case 9:
                    mainMenu();
                    ulang = 1;
                    break;
                case 0:
                    model.savePelamar();
                    model.savePerusahaan();
                    ulang = 1;
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (ulang == 0);
    }

    public void mainMenu() throws IOException {
        int pil, ulang = 0;
//        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Sitem Informasi Lowongan Pekerjaan\n");

            System.out.println("  MAIN MENU ");
            System.out.println("=============");
            System.out.println("1. Buat Akun");
            System.out.println("2. Login sebagai Pelamar");
            System.out.println("3. Login Sebagai Perusahaan");
            System.out.println("4. Hapus Akun");
            System.out.println("0. Exit");
            System.out.print("\nInput : ");
            pil = in.nextInt();
            switch (pil) {
                case 1:
                    menuBuatAkun();
                    ulang = 1;
                    break;
                case 2:
                    menuPelamar();
                    ulang = 1;
                    break;
                case 3:
                    menuPerusahaan();
                    ulang = 1;
                    break;
                case 4:
                    menuHapusAkun();
                    ulang = 1;
                    break;
//                case 5:
//                    for (Perusahaan p : daftarPerusahaan) {
//                        System.out.println(p.getName() + p.getId());
//                    }
//                    break;
                case 0:
                    model.savePelamar();
                    model.savePerusahaan();
                    ulang = 1;
                    System.exit(0);
                    break;
                default:
                    ulang = 0;
                    break;
            }
        } while (ulang == 0);
    }
}
