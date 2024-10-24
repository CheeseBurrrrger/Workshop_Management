package TokoElektronikSetiaMakmur;
public class HP extends TOKO{
	private int noImei;
	private boolean tipeCharger;
	protected HP(String merk, String prosesor, int stok, int harga, int noImei,boolean tipeCharger) {
		super(merk, prosesor, stok, harga);
		this.noImei=noImei;
		this.tipeCharger=tipeCharger;
	}
	public int getNoImei() {
		return noImei;
	}
	public void setNoImei(int noImei) {
		this.noImei = noImei;
	}
	public String isTipeCharger() {
		if(tipeCharger) {
			return "Type C";
		} else {
			return "Type A";
		}
	}
	public void setTipeCharger(boolean tipeCharger) {
		this.tipeCharger = tipeCharger;
	}
	@Override
	public String toString(){
		return  super.toString()+
				"\nNo IMEI\t\t: "+getNoImei()+
				"\nTipe Charger\t: "+isTipeCharger();
				
	}
}