package TokoElektronikSetiaMakmur;
import java.sql.SQLException;
import java.util.Scanner;
public class main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
    int Pilihan;
	Scanner in      = new Scanner(System.in);
	ios     ipong   = new ios("ipon 16", "m1", 20, 20000000, 2351, false, true, true);
	Huawei  Huawai  = new Huawei("Huawai", "Naga", 15000000, 10, 8907, false, "4");
	Android Mi      = new Android("Siomay", "SnapNaga", 25, 2000000, 3456, true, "23");
	MACBOOK Mac     = new MACBOOK("MacBuku", "M4", 15, 30000000, true, true);
	Windows jendela = new Windows("Lenopo", "Intel Core-i10", 5, 10000000, true, false);
	TOKO arrayDagangan[] = {ipong,Huawai,Mi,Mac,jendela};	



	//	for(TOKO x : arrayDagangan) {
//		x.insertItem();
//		x.insertProduk();
//	}
	do {
        System.out.println("\nPilihan Menu");
        System.out.println("1. Transaksi");
        System.out.println("2. List Stok");
        System.out.println("3. Restock");
        System.out.println("4. Pendapatan Toko");
        System.out.println("5. Exit");
        System.out.print("Masukkan pilihan Anda: ");
        Pilihan = in.nextInt();
        switch (Pilihan) {
            case 1:
				System.out.println("Pembelian Barang: ");
                System.out.println(ipong.transaksi(4));
				System.out.println(Huawai.transaksi(3, 10));
				System.out.println(Mi.transaksi(4, 20));
				System.out.println(Mac.transaksi(2, 5));
				System.out.println(jendela.transaksi(3, 15));
				
                break;
            case 2:
                System.out.println("List Stok Barang: ");
                for(TOKO x : arrayDagangan) {
                    System.out.println(x.toString());
                } break;
            case 3:
				System.out.println("Restock Barang:");
				for(TOKO x : arrayDagangan) {
	                System.out.println(x.restock());
	            } break;
            case 4:
                for(TOKO x : arrayDagangan) {
                    System.out.println(x.penghasilanToko());
                }
                    System.out.println("\nAkumulasi penghasilan semua item: "+TOKO.getSumMoney());
                break;
            case 5:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println( "--------Pilihan tidak valid. Silakan pilih 1-5--------"+
                                    "\n------------------------------------------------------");
            }
        } while (Pilihan != 5);
	in.close();
    }
}


//ide: karyawan: sales,service,admin
//ide: nota sisi kustomer