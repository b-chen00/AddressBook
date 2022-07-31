package AddressBook;

public class Contact implements Comparable<Contact>{
	int id;
	String name;
	String email;
	String phone;
	String notes;

	public Contact(int i, String n, String e, String p, String no){
		id = i;
		name = n;
		email = e;
		phone = p;
		notes = no;
	}

	public int GetId(){
		return id;
	}

	public String GetName(){
		return name;
	}

	public String GetEmail(){
		return email;
	}

	public String GetPhone(){
		return phone;
	}

	public String GetNotes(){
		return notes;
	}

	public int compareTo(Contact other){
		return name.compareTo(other.GetName());
	}
}
