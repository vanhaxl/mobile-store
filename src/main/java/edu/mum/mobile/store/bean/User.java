package edu.mum.mobile.store.bean;

public class User {
	private int id;
    private String email;
    private String password;
    private int isAdmin;
    private String fullname;
    private String telephone;
    private String address;

    public User() {

    }

    public User(String email, String password, int isAdmin) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String email, String username, String password, int isAdmin, String fullname, String telephone, String address) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.fullname = fullname;
        this.telephone = telephone;
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
