package TokoElektronikSetiaMakmur;
public class Laptop extends TOKO{
    private Boolean tipeLayar;
    protected Laptop(String merk, String prosesor, int stok, int harga, Boolean tipeLayar){
    super(merk, prosesor, stok, harga);
    this.tipeLayar = tipeLayar;}
    public String isTipeLayar() {
        if(tipeLayar==true){
        return "HD";
    }
        else{
        return "OLED" ;}
    }
    public void setTipeLayar(Boolean tipeLayar) {
        this.tipeLayar = tipeLayar;
    }
    public String toString(){
        return  super.toString()+
                "\nTipe Layar\t: "+ isTipeLayar();
    }
}