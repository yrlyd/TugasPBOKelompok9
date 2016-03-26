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
public class Pelamar extends Orang {

    private BerkasLamaran berkas;

    public Pelamar(long id, String name, String email, long noTlp) {
        super(id, name, email, noTlp);
    }

    public void createBerkas(long idBerkas) {
        berkas = new BerkasLamaran(idBerkas, super.getName());
    }

    public BerkasLamaran getBerkas() {
        return berkas;
    }

}

