/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author FebbyFebriansyah
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Aplikasi {

    private ArrayList<Perusahaan> daftarPerusahaan;
    private ArrayList<Pelamar> daftarPelamar;
//    private int jumlahPerusahaan;
//    private int jumlahPelamar;

    public Aplikasi(int maxPerusahaan, int maxPelamar) {
        daftarPerusahaan = new ArrayList();
//        jumlahPerusahaan = 0;
        daftarPelamar = new ArrayList();
//        jumlahPelamar = 0;
    }

    public void lihatLowongan() {
        for (int i = 0; i < daftarPerusahaan.size(); i++) {
            for (int j = 0; j < daftarPerusahaan.get(i).getJumlahLowongan(); j++) {
                System.out.println("Nama Perusahaan : "+daftarPerusahaan.get(i).getName());
                System.out.println(daftarPerusahaan.get(i).getLowongan(j));
                System.out.println();
            }
        }
    }

    public Lowongan cariLowongan(String nama, Perusahaan perusahaan) {
        Lowongan lowongan = null;
        for (int i = 0; i < perusahaan.getJumlahLowongan(); i++) {
            if (perusahaan.getLowongan(i).getNamaLowongan() == nama) {
                lowongan = perusahaan.getLowongan(i);
            }
        }
        return lowongan;
    }

    public void daftarLowongan(Pelamar p, Lowongan lowongan) {
        lowongan.addBerkas(p.getBerkas());
    }

    public void addPerusahaan(Perusahaan perusahaan) {
        daftarPerusahaan.add(perusahaan);
//        jumlahPerusahaan++;
    }

    public void addPelamar(Pelamar pelamar) {
        daftarPelamar.add(pelamar);
//        jumlahPelamar++;
    }

    public Pelamar getPelamar(long id) {
        Pelamar pelamar = null;
        for (int i = 0; i < daftarPelamar.size(); i++) {
            if (daftarPelamar.get(i).getId() == id) {
                pelamar = daftarPelamar.get(i);
            }
        }
        return pelamar;
    }

    public void deletePelamar(long id) {
        for (int i = 0; i < daftarPelamar.size(); i++) {
            if (daftarPelamar.get(i).getId() == id) {
                daftarPelamar.remove(i);
            }
        }
//        jumlahPelamar--;
    }

    public Perusahaan getPerusahaan(long id) {
        Perusahaan perusahaan = null;
        for (int i = 0; i < daftarPerusahaan.size(); i++) {
            if (daftarPerusahaan.get(i).getId() == id) {
                perusahaan = daftarPerusahaan.get(i);
            }
        }
        return perusahaan;
    }

    public void deletePerusahaan(long id) {
        for (int i = 0; i < daftarPerusahaan.size(); i++) {
            if (daftarPerusahaan.get(i).getId() == id) {
                daftarPerusahaan.remove(i);
            }
        }
//        jumlahPerusahaan--;
    }

    public void menuPerusahaan() {
        int pil, ulang = 0;
        long id;
        String namaLowongan;
        Scanner in = new Scanner(System.in);
        Scanner st = new Scanner(System.in);

        System.out.print("Masukkan ID Perusahaan\t: ");
        id = in.nextLong();
//        try {
        if (getPerusahaan(id) != null) {
            do {
                System.out.println("Menu Perusahaan");
                System.out.println("===============");
                System.out.println("1. Membuat Lowongan");
                System.out.println("2. Lihat Pelamar");
                System.out.println("3. Approve Pelamar");
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
                        System.out.print("Nama Lowongan\t : ");
                        namaLowongan = st.nextLine();
                        System.out.print("Deadline\t: ");
                        deadline = st.next();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                        Date date = null;
                        try {
                            date = dateFormat.parse(deadline);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        getPerusahaan(id).createLowongan(idLowongan, namaLowongan, date);
                        System.out.println("Lowongan berhasil dibuat");
                        break;
                    case 2:
                        try {
                            System.out.println("Lihat Pelamar");
                            System.out.println("=============");
                            if (getPerusahaan(id).lihatPelamar() != null) {
                                System.out.println(getPerusahaan(id).lihatPelamar());
                            } else {
                                System.out.println("Tidak ada Pelamar");
                            }
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
                            if (getPerusahaan(id).approvePelamar(i, j) == true) {
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
                    case 9:
                        mainMenu();
                        ulang = 1;
                        break;
                    case 0:
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

    public void menuPelamar() {
        int pil, ulang = 0;
        long id, idLowongan, idBerkas;
        String namaPerusahaan, namaLowongan;
        Scanner in = new Scanner(System.in);
        Scanner st = new Scanner(System.in);
        System.out.print("Masukkan No.KTP\t: ");
        id = in.nextLong();
        if (getPelamar(id) != null) {
            do {
                System.out.println("Menu Pelamar");
                System.out.println("============");
                System.out.println("1. Buat Berkas");
                System.out.println("2. Lihat Semua Lowongan");
                System.out.println("3. Cari Lowongan");
                System.out.println("4. Daftar Lowongan");
                System.out.println("9. Logout");
                System.out.println("0. Exit");
                System.out.print("\nInput Pilihan : ");
                pil = in.nextInt();
                switch (pil) {
                    case 1:
                        System.out.println("Buat Berkas");
                        System.out.println("===========");
                        System.out.print("Masukkan ID untuk  Berkas Lamaran : ");
                        idBerkas = in.nextLong();
                        getPelamar(id).createBerkas(idBerkas);
                        break;
                    case 2:
                        System.out.println("Lihat Semua Lowongan");
                        System.out.println("====================");
                        try {
                            lihatLowongan();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Maaf, Karena Terjadi Kesalahan");
                            System.out.println("Akun Logout Secara Otomatis");
                            mainMenu();
                        }
                        break;
                    case 3:
                        try {
                            Perusahaan perusahaan = null;
                            System.out.println("Cari Lowongan");
                            System.out.println("=============");
                            System.out.print("Masukkan Nama Perusahaan : ");
                            namaPerusahaan = st.nextLine();
                            for (int i = 0; i < daftarPerusahaan.size(); i++) {
                                if (daftarPerusahaan.get(i).getName() == namaPerusahaan) {
                                    perusahaan = daftarPerusahaan.get(i);
                                } else {
                                    System.out.println("Nama Perusahaan tidak ditemukan");
                                    break;
                                }
                            }
                            System.out.print("Masukkan Nama Lowongan : ");
                            namaLowongan = st.nextLine();
                            if (cariLowongan(namaLowongan, perusahaan) != null) {
                                System.out.println("Lowongan yang Anda maksud ditemukan");
                                System.out.println("Perusahaan " + namaPerusahaan + " membuka lowongan " + namaLowongan);
                            } else {
                                System.out.println("Lowongan yang Anda maksud tidak ditemukan");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Maaf, Karena Terjadi Kesalahan");
                            System.out.println("Akun Logout Secara Otomatis");
                            mainMenu();
                        }
                        break;

                    case 4:
                        try {
                            Perusahaan perusahaan = null;
                            Lowongan lowongan = null;
                            System.out.println("Daftar Lowongan");
                            System.out.println("===============");
                            System.out.print("Masukkan Nama Perusahaan yang Ingin dilamar: ");
                            namaPerusahaan = st.nextLine();
                            for (int i = 0; i < daftarPerusahaan.size(); i++) {
                                if (daftarPerusahaan.get(i).getName() == namaPerusahaan) {
                                    perusahaan = daftarPerusahaan.get(i);
                                } else {
                                    System.out.println("Nama Perusahaan tidak ditemukan");
                                }
                            }
                            System.out.print("Masukkan Nama Lowongan yang Ingin dilamar: ");
                            namaLowongan = st.nextLine();
                            if (cariLowongan(namaLowongan, perusahaan) != null) {
                                System.out.println("Lowongan yang Anda maksud ditemukan");
                                System.out.println("Perusahaan " + namaPerusahaan + " membuka lowongan " + namaLowongan);
                                lowongan = cariLowongan(namaLowongan, perusahaan);
                                daftarLowongan(getPelamar(id), lowongan);
                                System.out.println("\nAnda berhasil didaftarkan");
                            } else {
                                System.out.println("Lowongan yang Anda maksud tidak ditemukan");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Maaf, Karena Terjadi Kesalahan");
                            System.out.println("Akun Logout Secara Otomatis");
                            mainMenu();
                        }
                        break;
                    case 9:
                        ulang = 1;
                        mainMenu();
                        break;
                    case 0:
                        ulang = 1;
                        System.exit(0);
                }
            } while (ulang == 0);
        } else {
            System.out.println("\nNo.KTP tidak di temukan\n");
            mainMenu();
        }
    }

    public void menuBuatAkun() {
        int pil, maxLowongan, ulang = 0;
        long id, noTlp;
        String nama, email;
        Scanner in = new Scanner(System.in);
        Scanner st = new Scanner(System.in);
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
                    System.out.print("No.KTP\t\t: ");
                    id = in.nextLong();
                    System.out.print("Nama\t\t: ");
                    nama = st.nextLine();
                    System.out.print("Email\t\t: ");
                    email = st.nextLine();
                    System.out.print("No.Telepon/HP\t: ");
                    noTlp = in.nextLong();
                    pelamar = new Pelamar(id, nama, email, noTlp);
                    addPelamar(pelamar);
                    mainMenu();
                    ulang = 1;
                    break;
                case 2:
                    Perusahaan perusahaan;
                    System.out.println("Buat Akun Perusahaan");
                    System.out.println("====================");
                    System.out.print("ID Perusahaan\t\t: ");
                    id = in.nextLong();
                    System.out.print("Nama Perusahaan\t\t: ");
                    nama = st.nextLine();
                    System.out.print("Email Perusahaan\t: ");
                    email = st.nextLine();
                    System.out.print("Kontak Perusahaan\t: ");
                    noTlp = in.nextLong();
                    System.out.print("Maximum Lowongan\t: ");
                    maxLowongan = in.nextInt();
                    perusahaan = new Perusahaan(id, nama, email, noTlp, maxLowongan);
                    addPerusahaan(perusahaan);
                    mainMenu();
                    ulang = 1;
                    break;
                case 9:
                    mainMenu();
                    ulang = 1;
                    break;
                case 0:
                    ulang = 1;
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (ulang == 0);
    }

    //Di menuHapusAkun kasih try catch
    public void menuHapusAkun() {
        int pil, ulang = 0;
        long id;
        Scanner in = new Scanner(System.in);
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
                    System.out.print("Masukkan No.KTP\t: ");
                    id = in.nextLong();
                    if (getPelamar(id) != null) {
                        deletePelamar(id);
                        System.out.println("Akun Pelamar Berhasil dihapus");
                    } else {
                        System.out.println("No.KTP tidak di temukan");
                    }
                    ulang = 1;
                    mainMenu();
                    break;
                case 2:
                    System.out.print("Masukkan ID Perusahaan\t: ");
                    id = in.nextLong();
                    if (getPerusahaan(id) != null) {
                        deletePerusahaan(id);
                        System.out.println("Akun Perusahaan Berhasil dihapus");
                    } else {
                        System.out.println("ID perusahaan tidak di temukan");
                    }
                    ulang = 1;
                    mainMenu();
                    break;
                case 9:
                    mainMenu();
                    ulang = 1;
                    break;
                case 0:
                    ulang = 1;
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (ulang == 0);
    }

    public void mainMenu() {
        int pil, ulang = 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Sitem Informasi Lowongan Pekerjaan\n");

            System.out.println("LOGIN ");
            System.out.println("=============");
            System.out.println("1. Buat Akun");
            System.out.println("2. Pelamar");
            System.out.println("3. Perusahaan");
            System.out.println("4. Hapus Akun");
            System.out.println("0. Exit");
            System.out.print("\nLogin sebagai : ");
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
                case 0:
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

