import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> list;

	/** Skapar en ny bank utan konton. */
	Bank() {
		list = new ArrayList<BankAccount>();
	}

	/**
	 * Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare med
	 * de givna uppgifterna ska inte en ny Customer skapas, utan istället den
	 * befintliga användas. Det nya kontonumret returneras.
	 */
	public int addAccount(String holderName, long idNr) {
		Customer newHolder = findHolder(idNr);
		BankAccount newAccount;
		if (newHolder == null) {
			newAccount = new BankAccount(holderName, idNr);
			list.add(newAccount);
		} else {
			newAccount = new BankAccount(newHolder);
			list.add(newAccount);
		}
		return newAccount.getAccountNumber();
	}

	/**
	 * Returnerar den kontoinnehavaren som har det givna id-numret, eller null
	 * om ingen sådan finns.
	 */
	public Customer findHolder(long idNr) {
		for (int i = 0; i < list.size(); i++){
			if(list.get(i).getHolder().getIdNr() == idNr) {
				return list.get(i).getHolder();
			}
		}
		return null;
	}

	/**
	 * Tar bort konto med nummer ’number’ från banken. Returnerar true om kontot
	 * fanns (och kunde tas bort), annars false.
	 */
	boolean removeAccount(int number) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountNumber() == number) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Returnerar en lista innehållande samtliga bankkonton i banken. Listan är
	 * sorterad på kontoinnehavarnas namn.
	 */
	ArrayList<BankAccount> getAllAccounts() {
		for (int i = 0; i < list.size(); i++) {
			for (int k = 0; k < list.size(); k++) {
				if (list.get(i).getHolder().getName().compareTo(list.get(k).getHolder().getName()) < 0) {
					BankAccount temp = list.set(i, list.get(k));
					list.set(k, temp);
				}
			}
		}
		return list;
	}

	/**
	 * Söker upp och returnerar bankkontot med kontonummer ’accountNumber’.
	 * Returnerar null om inget sådant konto finns.
	 */
	BankAccount findByNumber(int accountNumber) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountNumber() == accountNumber) {
				return list.get(i);
			}
		}
		return null;
	}

	/**
	 * Söker upp alla bankkonton som innehas av kunden med id-nummer ’idNr’.
	 * Kontona returneras i en lista. Kunderna antas ha unika id-nummer.
	 */
	ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> tempList = new ArrayList<BankAccount>();
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getHolder().getIdNr()==idNr){
				tempList.add(list.get(i));
			}
		}
		return tempList;
	}

	/**
	 * Söker upp kunder utifrån en sökning på namn eller del av namn. Alla
	 * personer vars namn innehåller strängen ’namePart’ inkluderas i
	 * resultatet, som returneras som en lista. Samma person kan förekomma flera
	 * gånger i resultatet. Sökningen är "case insensitive", det vill säga gör
	 * ingen skillnad på stora och små bokstäver.
	 */
	ArrayList<Customer> findByPartofName(String namePart) {
		ArrayList<Customer> tempList = new ArrayList<Customer>();
		
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getHolder().getName().toLowerCase().contains(namePart.toLowerCase())){
				tempList.add(list.get(i).getHolder());
			}
		}
		return tempList;
	}
}
