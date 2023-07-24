import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private static int n;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		dfs(0, 0);
        
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

	private static void dfs(int number, int index) {
		if (index == n) {
			sb.append(number).append('\n');
			return;
		}

		for (int i = 1; i < 10; i++) {
			int temp = 10 * number + i;

			if (isPrimeNumber(temp)) {
				dfs(temp, index + 1);
			}
		}
	}

	private static boolean isPrimeNumber(int number) {
		if (number < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}
}
