
public class BankAccount {
	private Customer holder;
	private double balance = 0;
	private static int start = 1;
	private int accNr;

	/**
	 * Skapar ett nytt bankkonto åt en innehavare med namn ’holderName’ och id
	 * ’holderId’. Kontot tilldelas ett unikt kontonummer och innehåller
	 * inledningsvis 0 kr.
	 */
	BankAccount(String holderName, long holderId) {
		holder = new Customer(holderName, holderId);
		accNr = start++;
	}

	/**
	 * Skapar ett nytt bankkonto med innehavare ’holder’. Kontot tilldelas ett
	 * unikt kontonummer och innehåller inledningsvis 0 kr.
	 */
	BankAccount(Customer holder){
		this.holder = holder;
		accNr = start++;
	}

	/** Tar reda på kontots innehavare. */
	Customer getHolder(){
		return holder;
	}

	/** Tar reda på det kontonummer som identifierar detta konto. */
	int getAccountNumber(){
	return accNr;
	}

	/** Tar reda på hur mycket pengar som finns på kontot. */
	double getAmount(){
		return balance;
	}

	/** Sätter in beloppet ’amount’ på kontot. */
	void deposit(double amount){
		balance = balance + amount;
	}

	/**
	 * Tar ut beloppet ’amount’ från kontot. Om kontot saknar täckning blir
	 * saldot negativt.
	 */
	void withdraw(double amount){
		balance = balance - amount;
	}

	/** Returnerar en strängrepresentation av bankkontot. */
	public String toString(){
	StringBuilder sb = new StringBuilder();
	sb.append("konto ");
	sb.append(accNr);
	sb.append(" (");
	sb.append(holder.toString());
	sb.append("): ");
	sb.append(balance);
	return sb.toString();
	}
}
