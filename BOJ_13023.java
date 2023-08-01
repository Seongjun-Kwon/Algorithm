import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int n, m;
	private static List<List<Integer>> friends;
	private static boolean[] visit;
	private static boolean isABCDE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		friends = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			friends.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			friends.get(from).add(to);
			friends.get(to).add(from);
		}

		for (int i = 0; i < n; i++) {
			visit[i] = true;
			dfs(i, 1);
			visit[i] = false;

			if (isABCDE) {
				sb.append(1);
				break;
			}
		}

		if (sb.length() == 0) {
			sb.append(0);
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

	private static void dfs(int now, int depth) {
		if (depth >= 5) {
			isABCDE = true;
			return;
		}

		for (int i = 0; i < friends.get(now).size(); i++) {
			int next = friends.get(now).get(i);

			if (visit[next]) {
				continue;
			}

			visit[next] = true;
			dfs(next, depth + 1);
			visit[next] = false;
		}
	}
}
