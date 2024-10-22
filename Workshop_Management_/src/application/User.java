package application;

public class User {
	private int idUser;
	private String namaUser, emailUser, passwordUser;
	private boolean isAdmin,isMechanic;
	public boolean isMechanic() {
		return isMechanic;
	}
	public void setMechanic(boolean isMechanic) {
		this.isMechanic = isMechanic;
	}
	User(String namaUser, String emailUser, String passwordUser){
		setNamaUser(namaUser);
		setEmailUser(emailUser);
		setPasswordUser(passwordUser);
		if(namaUser=="root"&&passwordUser=="admin")
			setAdmin(true);
		else if(namaUser.contains("mekanik")&&passwordUser.contains("mekanik"))
			setMechanic(true);
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getNamaUser() {
		return namaUser;
	}

	public void setNamaUser(String namaUser) {
		this.namaUser = namaUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public boolean isAdmin() {
		return isAdmin;
	}
	public int getIdUser() {
		return idUser;
	}
	public String role() {
		if(isAdmin()==true)return "Admin";
		else if(isMechanic()==true)return "Mekanik";
		else return "unknown?";
	}
	@Override
	public String toString() {
		return "\nid user\t: "+getIdUser()+
				"\nNama\t: "+getNamaUser()+
				"\nEmail\t: "+getEmailUser()+
				"\nPassword: "+getPasswordUser()+
				"\nRole\t: "+role();		
	}
}