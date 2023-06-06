import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private static int n;
	private static String answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		moo(n);

		bw.write(answer);
		br.close();
		bw.flush();
		bw.close();
	}

	private static void moo(int num) {
		int size = 3;
		int k = 0;

		if (num == 1) {
			answer = "m";
		} else if (1 < num && num <= 3) {
			answer = "o";
		} else { // num > 4
			while (size < num) {
				size = size * 2 + k + 4;
				k++;
			}

			int frontSize = (size - k - 3) / 2;

			if (frontSize < num && num < size - frontSize + 1) {
				if (num == frontSize + 1) {
					answer = "m";
				} else {
					answer = "o";
				}
			} else { // num > frontSize + k + 3
				moo(num - (frontSize + k + 3));
			}
		}
	}
}
