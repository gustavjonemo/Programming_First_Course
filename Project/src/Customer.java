
public class Customer {
	private int customerNr;
	private static int start = 1;
	private String name;
	private long idNr;

	/**
	 * Skapar en kund (kontoinnehavare) med namnet ’name’ och id-nummer ’idNr’.
	 * Kunden tilldelas också ett unikt kundnummer.
	 */
	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		customerNr = start++;
	}

	/** Tar reda på kundens namn. */
	String getName() {
		return name;
	}

	/** Tar reda på kundens personnummer. */
	long getIdNr() {
		return idNr;
	}

	/** Tar reda på kundens kundnummer. */
	int getCustomerNr() {
		return customerNr;
	}

	/** Returnerar en strängbeskrivning av kunden. */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(", id ");
		sb.append(idNr);
		sb.append(", kundnr ");
		sb.append(customerNr);
		return sb.toString();
	}
}
