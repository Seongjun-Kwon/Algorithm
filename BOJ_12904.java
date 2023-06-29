import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private static String s, t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		s = br.readLine();
		t = br.readLine();

		int answer = solve();

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

	private static int solve() {
		while (t.length() > 1) {
			if (t.charAt(t.length() - 1) == 'A') {
				deleteLastA();
			} else {
				deleteLastBAndReverse();
			}

			if (t.equals(s)) {
				return 1;
			}
		}

		if (t.equals(s)) {
			return 1;
		} else {
			return 0;
		}
	}

	private static void deleteLastA() {
		t = t.substring(0, t.lastIndexOf("A"));
	}

	private static void deleteLastBAndReverse() {
		t = t.substring(0, t.lastIndexOf("B"));
		StringBuffer buffer = new StringBuffer(t);
		t = buffer.reverse().toString();
	}
}
