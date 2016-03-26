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
public class BerkasLamaran {

    private long idBerkas;
    private String namaPelamar;

    public BerkasLamaran(long idBerkas, String namaPelamar) {
        this.idBerkas = idBerkas;
        this.namaPelamar = namaPelamar;
    }

    public BerkasLamaran(long idBerkas) {
        this.idBerkas = idBerkas;
    }

    public void setIdBerkas(long idBerkas) {
        this.idBerkas = idBerkas;
    }

    public long getIdBerkas() {
        return idBerkas;
    }

    public String getNamaPelamar() {
        return namaPelamar;
    }

}
