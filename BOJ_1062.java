import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static String[] word;
	static boolean[] vis;
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		word = new String[N];
		vis = new boolean[26];
		vis['a' - 97] = true;
		vis['c' - 97] = true;
		vis['i' - 97] = true;
		vis['t' - 97] = true;
		vis['n' - 97] = true;

		if (K < 5) {
			answer = 0;
		} else if (K == 26) {
			answer = N;
		} else {
			for (int i = 0; i < N; i++) {
				word[i] = br.readLine();
				word[i] = word[i].substring(4, word[i].length() - 4);
			}

			solve(0, 0);
		}

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

	public static void solve(int idx, int cnt) {
		if (cnt == K - 5) {
			int tmpCnt = 0;

			for (int i = 0; i < N; i++) {
				boolean canRead = true;

				for (int j = 0; j < word[i].length(); j++) {
					if (!vis[word[i].charAt(j) - 97]) {
						canRead = false;
						break;
					}
				}

				if (canRead) {
					tmpCnt++;
				}
			}

			answer = Math.max(tmpCnt, answer);
			return;
		}

		for (int i = idx; i < 26; i++) {
			if (vis[i]) {
				continue;
			}
			vis[i] = true;
			solve(i + 1, cnt + 1);
			vis[i] = false;
		}
	}
}
