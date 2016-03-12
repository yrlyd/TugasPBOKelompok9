# TugasPBOKelompok9
public class Perusahaan extends Orang{
	private Lowongan[] daftarLowongan;
	private int jumlahLowongan=0;
	private int maxLowongan;
	
	public Perusahaan(int maxLowongan){
		this.maxLowongan=maxLowongan;
		daftarLowongan=new Lowongan[maxLowongan];
	}
/* 	public void createLowongan(Date deadline){
		????????
	} */
	
	public void addLowongan(long idLowongan){
		daftarLowongna[jumlahLowongan]=new Lowongan(idLowongan);
	}
	public Lowongan getLowongan(int i){
		return daftarLowongan[i];
	}
	public Lowongan getlowonganById(long id){
		for (int i=1; i<maxLowongan; i++){
			if (Lowongan[i].getIdLowongan()=id)
				return Lowongan[i];
			else {
				System.out.println("maaf id yang dicari tidak ditemukan");
		}
	public void removeLowongan(){
		daftarLowongan[jumlahLowongan]=null;
	}
	public void lihatPelamar(){
		System.out.println("daftar id pelamar (lewat berkas)");
		for(int i=0; i<jumlahLowongan; i++){
			System.out.println(daftarLowongan[i].getIdLowongan());
		}
	}
	public void approvePelamar(int i,int x){
		daftarLowongan[i].pindahBerkas(x);
	}
}
