package TokoElektronikSetiaMakmur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TOKO {
	private String merk,prosesor;
	static int n=0;
	private int stok, harga,kuantitas,diskon;
	private static int sumMoney;
	static Connection con=null;
	public LocalDateTime currentDateTime = null; 
	protected static int uniqueID=0;
	public String getIdItem() {
		return IdItem;
	}
	public void setIdItem(String iDMerk) {
		this.IdItem = iDMerk;
	}
	public LocalDateTime getCurrentDateTime() {
		return currentDateTime;
	}
	public void setCurrentDateTime(LocalDateTime currentDateTime) {
		this.currentDateTime = currentDateTime;
	}
	protected String IdItem=null;
	Scanner in = new Scanner (System.in);
	protected TOKO(String merk,String prosesor, int stok, int harga){
		
		this.merk=merk;
		this.prosesor=prosesor;
		this.harga=harga;
		this.stok=stok;
		
	}
	public static void koneksi() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokoe","root","");
	}
	public static int id_transaksi_terbaruSQl() throws ClassNotFoundException, SQLException {
		int temp=0;
		TOKO.koneksi();
		 String sql = "select max(id_transaksi) \r\n"
		 		+ "	from tokoe.transaksi t";
			Statement stmt = con.createStatement();		
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				temp = rs.getInt("max(id_transaksi)");
				return temp;
			}
			con.close();
			return temp;
	}
	public int melihatStokSql() throws SQLException, ClassNotFoundException {
		int sisa=0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokoe","root","");
		 String sql = "select stok_item\r\n"
		 		+ "from tokoe.produk \r\n"
		 		+ "where MERK = '"+getMerk()+"';\n";
			Statement stmt = con.createStatement();		
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				sisa = rs.getInt("stok_item");
				return sisa;
			}
			con.close();
			return sisa;
				
			
	}
	public int melihatStokTerjualSql() throws SQLException, ClassNotFoundException {
		int sisa=0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokoe","root","");
		 String sql = "select TOTAL_KUANTITAS\r\n"
		 		+ "from tokoe.HASILPENJUALANMERK  \r\n"
		 		+ "where MERK = '"+getMerk()+"'";
			Statement stmt = con.createStatement();		
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				sisa = rs.getInt("TOTAL_KUANTITAS");
				return sisa;
			}
			con.close();
			return sisa;
	}
	public void memperbaruiStok() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokoe","root","");
	}
	public void insertProduk()throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokoe","root","");
  		String sql = "insert into tokoe.produk values\r\n"
				+"('"+getMerk()+"',"+getHarga()+","+getStok()+",'"+getIdItem()+"');\n";
		Statement stmt = con.createStatement();		
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println("insert success");
		con.close();
	}
	public void insertItem() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokoe","root","");

			}
	public void transaksiSql() throws ClassNotFoundException, SQLException {
		setCurrentDateTime(LocalDateTime.now());
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tokoe","root","");
		
	}
	public static int getUniqueIDLanjutan () {
		return TOKO.uniqueID;
	}
	public static int getUniqueIDAwalan() throws ClassNotFoundException, SQLException {
		setUniqueID(TOKO.id_transaksi_terbaruSQl());
		return TOKO.uniqueID;
	}
	public static void setUniqueID(int uniqueID) {
		TOKO.uniqueID += uniqueID;
	}
	public static int getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(int sumMoney) {
		this.sumMoney += sumMoney;
	}
	public int getKuantitas() {
		return kuantitas;
	}
	public void setKuantitas(int kuantitas) {
		this.kuantitas = kuantitas;
	}
	public int getDiskon() {
		return diskon;
	}
	public void setDiskon(int diskon) {
		this.diskon = diskon;
	}
	public String getMerk() {
		return merk;
	}
	public void setMerk(String merk) {
		this.merk = merk;
	}
	public String getProsesor() {
		return prosesor;
	}
	public void setProsesor(String prosesor) {
		this.prosesor = prosesor;
	}
	public int getStok() {
		return stok;
	}
	public void setStok(int stok) {
		this.stok = stok;
	}
	public int getHarga() {
		return harga;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
	public char answer () {
		if(getStok()==0)return 'N';
		else {System.out.println("Stok saat ini tersedia hanya: "+getStok());
		System.out.println("Apakah tetap ingin bertransaksi jumlah stok yang ada? (Y/N)");
		String ans = in.nextLine();
		if(ans.equalsIgnoreCase("y"))return 'Y';
		else return 'N';
		}
	}
	public String transaksi(int kuantitas) throws ClassNotFoundException, SQLException{
		if(uniqueID==0)getUniqueIDAwalan();
		if(getStok()<kuantitas){
			setKuantitas(0);
		}
		else setKuantitas(kuantitas);
		System.out.println(	"\n================================================="+
							"\n===================TRANSAKSI=====================");
		if (getStok() >= kuantitas) {
            setStok(getStok()-kuantitas);
            n=duitToko();
            setSumMoney(n);
            setUniqueID(1);
            transaksiSql();
            memperbaruiStok();
            return 	toString()+
            		"\nJumlah Pembelian: "+getKuantitas()+
                    "\nTotal Harga\t: " + duitToko()+
                    "\n\n==============================="
                    + "\n  TRANSAKSI BERHASIL DILAKUKAN\n"
                    + "===============================";
        }
        else{
			if(answer()=='Y') {
				setKuantitas(getStok());
				int temp=getStok();
				setStok(0);
		        n=duitToko();
		        setSumMoney(n);
	            setUniqueID(1);
		        transaksiSql();
	            memperbaruiStok();
				return 	toString()+
						"\nJumlah Pembelian: "+temp+
						"\nTotal Harga\t: " + duitToko()+
						"\n\n================================================="+
						"\n  TRANSAKSI BERHASIL DILAKUKAN\n"+
						"=================================================";
				}
			else {
				return 
					toString()+"\n\n================================================\n"+
					"   		TRANSAKSI GAGAL DILAKUKAN"+
					"\n      		 STOK TIDAK CUKUP\n"+
					"================================================";
			}
		}
	}
    public String transaksi(int kuantitas, int diskon) throws ClassNotFoundException, SQLException {
		if(uniqueID==0)getUniqueIDAwalan();
		if(getStok()<kuantitas){
			setKuantitas(0);
		}
		else setKuantitas(kuantitas);
		this.diskon=diskon;
		System.out.println("\n================================================\n==================TRANSAKSI=================");
        if (getStok() >= kuantitas) {
            setStok(getStok()-kuantitas);
            n=duitToko();
            setSumMoney(n);
            setUniqueID(1);
            transaksiSql();
            memperbaruiStok();
            return 	toString()+
            		"\nDiskon\t\t: "+diskon+"%"+
                    "\nNominal Diskon\t: "+ getHarga()/diskon+
                    "\nJumlah Pembelian: "+kuantitas+
                    "\nTotal Harga\t: " + duitToko()+
                    "\n\n================================================"
                    + "\n  		TRANSAKSI BERHASIL DILAKUKAN\n"
                    + "================================================";
        }
        else{        	
        	if(answer()=='Y') {
        		setKuantitas(getStok());
        		int temp=getStok();
        		setStok(0);
                n=duitToko();
                setSumMoney(n);
                setUniqueID(1);
                transaksiSql();
                memperbaruiStok();
                return 	toString()+
                		"\nDiskon\t\t: "+diskon+"%"+
                        "\nNominal Diskon\t: "+ getHarga()/diskon+
                        "\nJumlah Pembelian: "+temp+
                        "\nTotal Harga\t: " + duitToko()+
                        "\n\n================================================"
                        + "\n  		TRANSAKSI BERHASIL DILAKUKAN\n"
                        + "================================================";
        	}
        	else {
				return toString()+
					"\n\n================================================\n"+
            		"   	   TRANSAKSI GAGAL DILAKUKAN"+
            		"\n       		STOK TIDAK CUKUP\n"+
            		"================================================";
			}
        }
    }
	public String restock() throws ClassNotFoundException, SQLException{
		if (getStok() <= 2) {
	        System.out.print(toString()+"\nMasukkan stok sesuai keinginan Anda: ");
	        int n = in.nextInt();
	        setStok(getStok()+n);
			memperbaruiStok();
	        System.out.print("Berhasil Menambahkan Stok Sebanyak: ");
            return ""+n;
        } else {
            return toString();
        }
	}
	public String toString() {
		try {
			return  "===============Merk "+getMerk()+"================="+
					"\nProsesor\t: "+getProsesor()+
					"\nStok Tersedia\t: "+melihatStokSql()+
					"\nHarga Barang/pcs: "+getHarga();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		return "";
	}
	public String penghasilanToko() throws ClassNotFoundException, SQLException{
		System.out.println("===================Merk "+getMerk()+"===================="+
		"\nStok terjual\t\t\t\t  : "+melihatStokTerjualSql()+
		"\nHarga Barang/pcs\t\t\t  : "+getHarga());
		if(getDiskon()!=0){
		return 	"Total Penghasilan sebelum dipotong diskon : "+(getKuantitas()*getHarga())+
				"\nTotal Penghasilan setelah dipotong diskon : "+duitToko();
		}
		else {
		return 	"Total Penghasilan sebelum dipotong diskon : "+duitToko()+
				"\nTotal penghasilan setelah dipotong diskon : "+duitToko();
		}
	} 
	public int duitToko (){
		if(getDiskon()!=0&&getKuantitas()!=0){
		   return ((getKuantitas()*getHarga())-(getHarga()*getDiskon()/100));
		}
		else return (getKuantitas()*getHarga());
	}
}