import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private static String S;
	private static boolean[] vis;
	private static int[] alphabet;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		S = br.readLine();
		vis = new boolean[S.length()];
		alphabet = new int[26];

		for (int i = 0; i < S.length(); i++) {
			alphabet[S.charAt(i) - 'a']++;
		}

		solve(0, "");

		for (int i = 0; i < 26; i++) {
			if (alphabet[i] > 0) {
				ans /= factorial(alphabet[i]);
			}
		}

		bw.write(Integer.toString(ans));
		br.close();
		bw.flush();
		bw.close();
	}

	private static void solve(int len, String tmp) {
		if (len == S.length()) {
			if (isLucky(tmp)) {
				ans++;
				return;
			}
			return;
		}

		for (int i = 0; i < S.length(); i++) {
			if (vis[i]) {
				continue;
			}

			vis[i] = true;
			solve(len + 1, tmp + S.charAt(i));
			vis[i] = false;
		}
	}

	private static boolean isLucky(String S) {
		for (int i = 0; i < S.length() - 1; i++) {
			if (S.charAt(i) == S.charAt(i + 1)) {
				return false;
			}
		}
		return true;
	}

	private static int factorial(int num) {
		int tmp = 1;

		for (int i = num; i > 1; i--) {
			tmp *= i;
		}

		return tmp;
	}
}
