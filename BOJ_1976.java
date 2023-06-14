import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	private static int n, m;
	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				int connectionInfo = Integer.parseInt(st.nextToken());

				if (connectionInfo == 1) {
					union(i, j);
				}
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		int startParent = find(start);

		for (int i = 0; i < m - 1; i++) {
			int now = Integer.parseInt(st.nextToken()) - 1;

			if (find(now) != startParent) {
				sb.append("NO");
				break;
			}
		}

		if (sb.length() == 0) {
			sb.append("YES");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return;
		}

		if (x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}

	private static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		parent[x] = find(parent[x]);
		return parent[x];
	}
}
