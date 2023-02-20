import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		System.out.println("Skriv två tal");
		Scanner scan = new Scanner(System.in);
		double nbr1 = scan.nextDouble();
		double nbr2 = scan.nextDouble();
		double sum = nbr1 + nbr2;
		double dif = nbr1 - nbr2;
		if(dif < 0){
			dif = nbr2 - nbr1;
		}
		double pro = nbr1 * nbr2;
		double div = nbr1 / nbr2;
		System.out.println("Summan av talen är " + sum + "\n Skillnaden av talen är " + dif + "\n Produkten av talen är " + pro + "\n Kvoten av talen är " + div);
		scan.close();
	}
}