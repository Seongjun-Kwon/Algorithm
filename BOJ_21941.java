import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Map<String, Integer> map = new HashMap<>();
		String S = br.readLine();
		int m = Integer.parseInt(br.readLine());
		int[] dp = new int[S.length() + 1];

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String A = st.nextToken();
			int score = Integer.parseInt(st.nextToken());
			map.put(A, score);
		}

		for (int i = 0; i < S.length(); i++) {
			dp[i + 1] = Math.max(dp[i + 1], dp[i] + 1);

			for (String removeStr : map.keySet()) {
				if (S.startsWith(removeStr, i)) {
					dp[i + removeStr.length()] = Math.max(dp[i + removeStr.length()], dp[i] + map.get(removeStr));
				}
			}
		}

		bw.write(Integer.toString(dp[S.length()]));
		br.close();
		bw.flush();
		bw.close();
	}
}
