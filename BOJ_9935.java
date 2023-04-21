import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		String explosion = br.readLine();
		Stack<Character> sta = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			sta.push(str.charAt(i));

			if (sta.size() < explosion.length()) {
				continue;
			}

			boolean isExplode = true;

			for (int j = 0; j < explosion.length(); j++) {
				if (sta.get(sta.size() - explosion.length() + j) != explosion.charAt(j)) {
					isExplode = false;
					break;
				}
			}

			if (isExplode) {
				for (int k = 0; k < explosion.length(); k++) {
					sta.pop();
				}
			}
		}

		for (int i = 0; i < sta.size(); i++) {
			sb.append(sta.get(i));
		}

		if (sb.length() == 0) {
			sb.append("FRULA");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
