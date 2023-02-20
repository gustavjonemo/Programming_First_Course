import java.util.Random;

public class Tools {

	public int[] GetArray(int n) {
		Random r = new Random();
		int[] a = new int[n];
		int t = 0;
		int x;
		while (t < n) {
			x = r.nextInt(10);
			a[t] = x;
			t = (t + 1);
		}
		return a;
	}

	public void GetCountdown(int s) throws InterruptedException {
		while (s > 1) {
			System.out.print(s + ", ");
			s--;
			Thread.sleep(1000);
		}
		System.out.println("1...");
		Thread.sleep(1000);
	}
}