# TugasPBOKelompok9
public class Lowongan{
	private long idLowongan;
	private BerkasLamaran[] berkasMasuk;
	private BerkasLamaran[] berkasDiterima;
	private int jumlahBerkas=0;
	private int jumlahBerkasDiterima=0;
	private int maxBerkasMasuk;
	private int maxBerkasDiterima;
	
	public Lowongan(long idLowongan, int maxBerkasMasuk, int maxBerkasDiterima){
		this.idLowongan=idLowongan;
		this.maxBerkasMasuk=maxBerkasMasuk;
		this.maxBerkasDiterima=maxBerkasDiterima;
		berkasMasuk=new BerkasLamaran[maxBerkasMasuk];
		berkasMasuk[0]=new BerkasLamaran(00000);
		berkasDiterima=new BerkasLamaran[maxBerkasDiterima];
		
	}
	public void setIdLowongan(long idLowongan){
		this.idLowongan=idLowongan;
	}
	public long getIdLowongan(){
		return idLowongan;
	}
	public void addBerkas(BerkasLamaran b){
		berkasMasuk[jumlahBerkas]=b;
	}
	public void terimaBerkas(BerkasLamaran b){
		berkasDiterima[jumlahBerkasDiterima]=b;
	}
	public BerkasLamaran getBerkasMasuk(int i){
		return berkasMasuk[i];
	}
	public BerkasLamaran getBerkasMasukById(int id){
		for (int i=1; i<jumlahBerkasMasuk; i++){
			if (berkasMasuk[i].getIdBerkas()==id){
				return berkasMasuk[i];
			}
			else {
				System.out.println("maaf, id yang anda cari tidak ditemukan");
			}
		}
	}
	public void RemoveBerkasMasuk(){
		berkasMasuk[jumlahBerkasMasuk]=null;
	}
	public void pindahBerkas(int i){
		berkasDiterima[jumlahBerkasDiterima]=berkasMasuk[i];

		}
	public BerkasLamaran getBerkasDiterima(int i){
		return berkasDiterima[i];
	}
}
