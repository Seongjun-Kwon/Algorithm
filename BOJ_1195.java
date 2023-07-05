import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private static String shortGear;
	private static String longGear;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		shortGear = br.readLine();
		longGear = br.readLine();

		if (shortGear.length() > longGear.length()) {
			String temp = shortGear;
			shortGear = longGear;
			longGear = temp;
		}

		int answer = shortGear.length() + longGear.length();

		for (int i = 1; i < shortGear.length(); i++) {
			boolean gear = true;

			for (int j = 0; j < i; j++) {
				if (shortGear.charAt(shortGear.length() - i + j) == '2' && longGear.charAt(j) == '2') {
					gear = false;
					break;
				}
			}

			if (gear) {
				answer = Math.min(answer, shortGear.length() + longGear.length() - i);
			}
		}

		for (int i = 0; i < longGear.length() - shortGear.length() + 1; i++) {
			boolean gear = true;

			for (int j = 0; j < shortGear.length(); j++) {
				if (shortGear.charAt(j) == '2' && longGear.charAt(i + j) == '2') {
					gear = false;
					break;
				}
			}

			if (gear) {
				answer = Math.min(answer, longGear.length());
			}
		}

		for (int i = 1; i < shortGear.length(); i++) {
			boolean gear = true;

			for (int j = 0; j < i; j++) {
				if (shortGear.charAt(j) == '2' && longGear.charAt(longGear.length() - i + j) == '2') {
					gear = false;
					break;
				}
			}

			if (gear) {
				answer = Math.min(answer, shortGear.length() + longGear.length() - i);
			}
		}

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}
}
