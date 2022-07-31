package AddressBook;
import java.util.*;

public class AddressBook{
	private static Scanner in;
	private static ArrayList<Contact> book;

	public static int AddWindow(){
		System.out.println("\nMain Window --> Add a new contact window: (Enter the following information)");
		System.out.println("============================================================================");
		System.out.println("Name: ");
		String name = in.nextLine();
		System.out.println("Email: ");
		String email = in.nextLine();
		System.out.println("Phone: ");
		String phone = in.nextLine();
		System.out.println("Notes: ");
		String notes = in.nextLine();
		Contact ToAdd = new Contact(book.size() + 1, name, email, phone, notes);
		book.add(ToAdd);
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Saved successfully ... Press Enter to go back to the Main Window");
		in.nextLine();
		return 0;
	}

	public static int SearchWindow(){
		System.out.println("\nMain Window --> Search for Contact window: (Choose one of the following options");
		System.out.println("===============================================================================");
		System.out.println("(1) Search by Name");
		System.out.println("(2) Search by Email");
		System.out.println("(3) Search by Phone");
		System.out.println("\nEnter Your Choice:");
		String line = in.nextLine();
		while (line.equals("") || !Character.isDigit(line.charAt(0)) || Integer.parseInt(line) < 1 || Integer.parseInt(line) > 3){
			System.out.println("Invalid input: enter only 1 integer as option");
			line = in.nextLine();
		}
		String criteria = "";
		switch (line){
			case "1":
				criteria = "Name";
				break;
			case "2":
				criteria = "Email";
				break;
			case "3":
				criteria = "Phone";
				break;
		}
		String output = String.format("\nMain Window --> Search for Contact window: --> Search by %s", criteria);
		System.out.println(output);
		System.out.println("===============================================================================");
		output = String.format("(%s) Enter %s", line, criteria);
		System.out.println(output);
		String ToMatch = in.nextLine();
		System.out.println("ID | Name            | Email             | Phone       | Notes");
		for (Contact c : book){
			boolean match = false;
			if (line.equals("1") && c.GetName().equals(ToMatch)){
				match = true;
			}
			if (line.equals("2") && c.GetEmail().equals(ToMatch)){
				match = true;
			}
			if (line.equals("3") && c.GetPhone().equals(ToMatch)){
				match = true;
			}
			if (match){
				String i = String.format("%1$-3s", c.GetId() + "");
				String n = String.format("%1$-17s", c.GetName());
				String e = String.format("%1$-19s", c.GetEmail());
				String p = String.format("%1$-13s", c.GetPhone());
				String no = String.format("%1$-30s", c.GetNotes());
				System.out.println(i + "|" + n + "|" + e + "|" + p + "|" + no);
			}
		}
		System.out.println("--------------------------------------------------------------");
		System.out.println("\nChoose one of these options:");
		System.out.println("(1) To delete a contact");
		System.out.println("(2) Back to main Window");
		line = in.nextLine();
		while (line.equals("") || !Character.isDigit(line.charAt(0)) || Integer.parseInt(line) < 1 || Integer.parseInt(line) > 2){
			System.out.println("Invalid input: enter only 1 integer as option");
			line = in.nextLine();
		}
		if (line.equals("2")){
			System.out.println("");
			return 0;
		}
		output = String.format("\nMain Window --> Search for Contact window: --> Search by %s --> Delete a Contact", criteria);
		System.out.println(output);
		System.out.println("===============================================================================");
		System.out.println("Enter the Contact ID:");
		String status = "ID not found";
		int id = Integer.parseInt(in.nextLine());
		for (Contact c : book){
			if (c.GetId() == id){
				book.remove(c);
				status = "Deleted";
				break;
			}
		}
		output = String.format("%s...press Enter to go back to main window", status);
		System.out.println(output);
		in.nextLine();
		return 0;
	}

	public static int DisplayWindow(){
		System.out.println("\nMain Window --> Display All Contacts");
		System.out.println("==============================================================");
		System.out.println("--------------------------------------------------------------");
		System.out.println("ID | Name            | Email             | Phone       | Notes");
		Collections.sort(book);
		for (Contact c : book){
			String i = String.format("%1$-3s", c.GetId() + "");
			String n = String.format("%1$-17s", c.GetName());
			String e = String.format("%1$-19s", c.GetEmail());
			String p = String.format("%1$-13s", c.GetPhone());
			String no = String.format("%1$-30s", c.GetNotes());
			System.out.println(i + "|" + n + "|" + e + "|" + p + "|" + no);
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("Press Enter to go back to the Main Window");
		in.nextLine();
		System.out.println("\n");
		return 0;
	}

	public static void main (String[] args){
		in = new Scanner(System.in);
		book = new ArrayList<>();
		int CurrentOption = 0;
		String line;
		while (CurrentOption != 4){
			System.out.println("Main Window");
			System.out.println("=====================================");
			System.out.println("Choose one of the following options:");
			System.out.println("(1) Add a new contact");
			System.out.println("(2) Search for contact");
			System.out.println("(3) Display all contacts");
			System.out.println("(4) Quit");
			line = in.nextLine();
			while (line.equals("") || !Character.isDigit(line.charAt(0)) || Integer.parseInt(line) < 1 || Integer.parseInt(line) > 4){
				System.out.println("Invalid input: enter only 1 integer as option");
				line = in.nextLine();
			}
			CurrentOption = Integer.parseInt(line);
			switch (CurrentOption){
				case 1: AddWindow();
					break;
				case 2: SearchWindow();
					break;
				case 3: DisplayWindow();
					break;
			}
		}
		in.close();
	}
}
