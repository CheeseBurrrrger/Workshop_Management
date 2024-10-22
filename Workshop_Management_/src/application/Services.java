package application;

import java.util.ArrayList;

public class Services {
	private ArrayList<Service>Services = new ArrayList<Service>();
	public Services() {
	}
	public void doService(String Merk, String VIN, String namaMobil, String isMesin,int ccMesin,String kodeMesin) {
		Service e = new Service(Merk, VIN, namaMobil, isMesin, ccMesin, kodeMesin);
		Services.add(e);
		e=null;
	}
	public Service getServices(int i) {
		return Services.get(i);
	}
	public int getSize() {
		return Services.size();
	}
}