/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.ControllerMain;
import Model.Aplikasi;
import ViewConsole.Console;
import java.io.IOException;

/**
 *
 * @author FebbyFebriansyah
 */
public class Driver {

    public static void main(String[] args) throws IOException {
        Aplikasi app = new Aplikasi();
        ControllerMain c=new ControllerMain(app);
//        app.mainMenu();
    }
}
/*
    should be fix (berdasarkan hasil output) : 
    1. Menu Pelamar : - lihat semua lowongan = klo null outputin ke pelamar supaya tau bahwa tidak ada lowongan v
                        - buat berkas = kalo id berkas udah ada outputin id berkas sudah ada. v

                        - daftar lowongan = masih error masuk ke trycatch, padahal perusahaan udah ada v
                                                di method daftarLowongan kok malah NullPointerException, apa berkasLamaran gak masuk?? v
                                                - Pelamar harusnya ga bisa daftar ke Perusahaan yang sama lebih dari satu kali
                                                - Pelamar hanya bisa daftar Lowongan sekali saja
                                                    jika lebih outputkan Anda sudah mendaftar ke perusahaan ini
                                                    supaya di menu Perusahaan di lihat pelamar ga ke outputin pelamar yang melamar
                                                        dengan lowongan yang sama
                        - Cari Lowongan = > 
                                                > lebih baik gunakan id daripada nama untuk mencari lowongan atau perusahaan v
                                                > kalo nama perusahaan ga ditemukan, gak usah tampilin ke user untuk input nama lowongan 
                                                    justru harus outputin bahwa nama lowongan tidak di temukan v
                                                > nama perusahaan udah di temukan, tp lowongan tidak, padahal udah bener v
                        - buat menu untuk lihat Pemberitahuan = berisi informasi bahwa Pelamar sudah diterima di Perusahaan tertentu
                            atau Berkas anda telah terkirim ke perusahaan blabla
                            atau Anda tidak memiliki Pemberitahuan apapun
    *2. Menu Perusahaan : - buat lowongan = - kasih deskripsi pekerjaan
                                                - klo nginputin lebih dari 2, kok input nama lowongannya di skip?
                                                - Keluarkan pesan untuk input dengan id yang sama
                            - lihat pelamar = kesalahan : null -> masuk ke trycatch -> hapus logout secara otomatis (FIX INI KALO UDAH BIKIN PERSISTENCE)
                            - Approve Pelamar = kesalahan : null -> masuk ke trycatch -> hapus logout secara otomatis (FIX INI KALO UDAH BIKIN PERSISTENCE)
    3. Menu Hapus Akun : Seharusnya menu ini ada di dalam akun yang sudah login v v

    4. Hapus untuk nginput maximum Lowongan

    should be fix (berdasarkan fungsionalias/Class) :
    0. all : Kasih info profil untuk setiap user v v
    1. Berkas Lamaran : tambahkan method untuk ngirimin profil pelamar ke perusahaan22
                            
    2. Jika semua bug sudah di fix : - hapus semua kommen 
                                        - hapus catch yang mengoutputkan "Akun logout secara otomatis"
                                        - cari cara agar semua class yang memiliki fungsionalitas tidak memiliki mekanisme input/output
                                            karena semua mekanisme tersebut dianjurkan hanya ada pada menu atau class Aplikasi

    Tambahan fungsionalitas :
    1. class ManageFile  = 
                            - saveObject
                            - loadObject
    2. Buat file untuk :
                            - daftar akun
                            - daftar Pelamar
                            - daftar Perusahaan :
                                - lowongan
                                - yang mendaftar ke lowongan
                                - yang diterima lowongan
    3. Yang perlu ditambahkan di class diagram :
            - tipe data parameternya jadi getBerkasMasukById(long id)
            - Penambahan method cek di aplikasi
            - parameter removeLowongan jadi(long idLowongan)
            - 
*/
