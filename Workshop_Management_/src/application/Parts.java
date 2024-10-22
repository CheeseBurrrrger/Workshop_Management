package application;

import java.util.ArrayList;

public class Parts {
	private ArrayList<Part> Parts = new ArrayList<Part>();
	public Parts() {
	}
	public int getSize() {
		return Parts.size();
	}
	public ArrayList<Part> getParts() {
		return Parts;
	}
	public void setParts(ArrayList<Part> parts) {
		Parts = parts;
	}
	public void decreasePartsQuantity (int partNumber,int n) {
		for (int i = 0; i<Parts.size();i++) {
			if (Parts.get(i).getPartNumber()==partNumber) {
				Parts.get(i).setStok(-n);
				System.out.println("Berhasil mengurangi stok!");
				break;
			}	
		}
	}	
}