import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] Args) {
		Bank bank = new Bank();
		// testAdd(bank);
		boolean run = true;
		while (run) {
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println("Tryck Enter för att fortsätta");
			scan.nextLine();
			printMenu();
			System.out.print("val: ");
			int menyval = scan.nextInt();
			scan.nextLine();
			switch (menyval) {
			case 1:
				System.out.print("Id: ");
				long id = scan.nextLong();
				if (bank.findAccountsForHolder(id).isEmpty() == true) {
					System.out.println("Inga konton kunde hittas");
				} else {
					System.out.println(bank.findAccountsForHolder(id));
				}
				scan.nextLine();
				break;
			case 2:
				System.out.print("Namn: ");
				ArrayList<Customer> temp = bank.findByPartofName(scan.nextLine());
				ArrayList<Customer> temp2 = temp;
				for (int i = 0; i < temp.size(); i++) {
					for (int i2 = 0; i2 < temp2.size(); i2++) {
						if (temp.get(i).getCustomerNr() == temp2.get(i2).getCustomerNr() && i != i2) {
							temp.remove(i);
							i2 = -1;
						}
					}
				}
				if (temp.isEmpty() == true) {
					System.out.println("Inget sådant konto kunde hittas");
				} else {
					for (int i = 0; i < temp.size(); i++) {
						System.out.println(temp.get(i).toString());
					}
				}
				break;

			case 3:
				System.out.print("Kontonummer: ");
				int c = scan.nextInt();
				System.out.print("Mängd att sätta in: ");
				int d = scan.nextInt();
				if (bank.findByNumber(c) == null) {
					System.out.println("Det angivna kontonummret finns inte");
				} else if (d < 0) {
					System.out.println("Enbart positiva instättningar är tillåtna");
				} else if (bank.findByNumber(c) != null && d >= 0) {
					bank.findByNumber(c).deposit(d);
					System.out.println("Insättning slutförd!");
				}
				scan.nextLine();
				break;

			case 4:
				System.out.print("Kontonummer: ");
				int e = scan.nextInt();
				System.out.print("Mängd att ta ut: ");
				int f = scan.nextInt();
				if (bank.findByNumber(e) == null) {
					System.out.println("Det angivna kontonummret finns inte");
				} else if (f < 0) {
					System.out.println("Enbart positiva uttagningar är tillåtna");
				} else if (bank.findByNumber(e).getAmount() - f < 0) {
					System.out.println("Saldot får inte vara negativt. Saldo: " + bank.findByNumber(e).getAmount()
							+ "  Önskad mängd att ta ut: " + f);
				} else if (bank.findByNumber(e) != null && f >= 0 && bank.findByNumber(e).getAmount() - f >= 0) {
					bank.findByNumber(e).withdraw(f);
					System.out.println("Uttagning slutförd!");
				}
				scan.nextLine();
				break;

			case 5:
				System.out.print("Från konto med kontonummer: ");
				int a1 = scan.nextInt();
				System.out.print("Till konto med kontonummer: ");
				int a2 = scan.nextInt();
				System.out.print("Mängd att föra över: ");
				int amount = scan.nextInt();
				if (bank.findByNumber(a1) == null || bank.findByNumber(a2) == null) {
					System.out.println("Ett eller fler av de angivna kontonummren finns inte");
				} else if (amount < 0) {
					System.out.println("Enbart positiva överföringar är tillåtna");
				} else if (amount > bank.findByNumber(a1).getAmount()) {
					System.out.println("Angiven mängd finns inte på kontot. Önskad mängd: " + amount + "  Saldo: "
							+ bank.findByNumber(a1).getAmount());
				} else {
					bank.findByNumber(a1).withdraw(amount);
					bank.findByNumber(a2).deposit(amount);
					System.out.println("Överföring slutförd!");
				}
				scan.nextLine();
				break;

			case 6:
				System.out.print("Namn: ");
				String a = scan.nextLine();
				System.out.print("Id; ");
				long b = scan.nextLong();
				System.out.println("Konto skapat: " + bank.addAccount(a, b));
				scan.nextLine();
				break;

			case 7:
				System.out.print("Konto: ");
				int gonner = scan.nextInt();
				if (bank.findByNumber(gonner) == null) {
					System.out.println("Det angivna kontonummret finns inte");
				} else {
					bank.removeAccount(gonner);
					System.out.println("Konto borttaget!");
				}
				scan.nextLine();
				break;

			case 8:
				ArrayList<BankAccount> acc = bank.getAllAccounts();
				if (acc.isEmpty() == true) {
					System.out.println("Inga konton kunde hittas");
				} else {
					for (BankAccount konto : acc) {
						System.out.println(konto);
					}
				}
				break;

			case 9:
				run = false;
				break;
			}
		}
	}

	private static void printMenu() {
		System.out.println(
				"1. Hitta konto utifrån innehavare\n2. Sök kontoinnehavare utifrån (del av) namn\n3. Sätt in\n4. Ta ut\n5. Överföring\n6. Skapa konto\n7. Ta bort konto\n8. Skriv ut konton\n9. Avsluta");
	}

	private static void testAdd(Bank bank) {
		bank.addAccount("Johanna Andréa Emma Renée Mårtensson", 1);
		bank.addAccount("Gustav Per Erik Jönemo", 1337);
		bank.addAccount("Anders Kelén", 999);
	}
}
