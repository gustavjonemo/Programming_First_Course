import java.util.Scanner;

public class Memory {

	public static void main(String[] Args) throws InterruptedException {
		Tools t = new Tools();
		Scanner scan = new Scanner(System.in);
		for (int n = 5; n < 12; n++) {
			System.out.println("Försök komma ihåg talen!");
			Thread.sleep(2000);
			t.GetCountdown(3);
			int[] a = t.GetArray(n);
			int correct = 0;
			for (int d = 0; d < n; d++) {
				System.out.print(a[d] + " ");
	
				correct = correct + a[d] * (int)Math.pow(10, ( n - d - 1));
			}
			Thread.sleep(5000);
			for (int h = 0; h < 50; h++) {
				System.out.println(" ");
			}
			System.out.print("Kommer du ihåg? Svar: ");
			int answer = scan.nextInt();

			if (answer == correct) {
				System.out.println("\nDu svarade rätt! Grattis! Nu ökar vi svårighetsgraden.\n");
				Thread.sleep(2000);
			} else {
				System.out.print("Aj då... Bättre lycka nästa gång!");
				break;
			}
		}
	}
}