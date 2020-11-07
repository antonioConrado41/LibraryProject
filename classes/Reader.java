package classes;

public class Reader {

	private int ID;
	private String name;
	private String address;

	public Reader(int ID, String name, String address) {
		this.ID = ID;
		this.name = name;
		this.address = address;

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object ref) {
		Reader other = (Reader) ref;

		if ((this.ID == other.ID) && (this.name.equalsIgnoreCase(other.name))
				&& (this.address.equalsIgnoreCase(other.address))) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Reader ID: " + ID + " Name: " + name + " Address: " + address;
	}
}
