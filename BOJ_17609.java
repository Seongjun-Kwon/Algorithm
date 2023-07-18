import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String str = br.readLine();

			if (isPalindrome(str)) {
				sb.append(0).append('\n');
			} else if (isPseudoPalindrome(str, 0, str.length() - 1, true)) {
				sb.append(1).append('\n');
			} else {
				sb.append(2).append('\n');
			}
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

	private static boolean isPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;

		while (start < end) {
			if (str.charAt(start++) != str.charAt(end--)) {
				return false;
			}
		}

		return true;
	}

	private static boolean isPseudoPalindrome(String str, int start, int end, boolean canDelete) {
		while (start < end) {
			if (str.charAt(start) == str.charAt(end)) {
				start++;
				end--;
				continue;
			} else {
				if (canDelete) {
					return isPseudoPalindrome(str, start + 1, end, false)
							|| isPseudoPalindrome(str, start, end - 1, false);
				} else {
					return false;
				}
			}
		}

		return true;
	}
}
