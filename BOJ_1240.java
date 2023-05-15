import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int to, distance;

		public Node(int to, int distance) {
			this.to = to;
			this.distance = distance;
		}
	}

	private static int n, m;
	private static List<List<Node>> tree = new ArrayList<>();
	private static int[] dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int distance = Integer.parseInt(st.nextToken());
			tree.get(from).add(new Node(to, distance));
			tree.get(to).add(new Node(from, distance));
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			sb.append(bfs(from, to)).append('\n');
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

	private static int bfs(int from, int to) {
		Queue<Integer> q = new LinkedList<>();
		q.add(from);
		dis = new int[n];

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == to) {
				break;
			}

			for (int i = 0; i < tree.get(cur).size(); i++) {
				int nxt = tree.get(cur).get(i).to;

				if (dis[nxt] > 0) {
					continue;
				}

				q.add(nxt);
				dis[nxt] = dis[cur] + tree.get(cur).get(i).distance;
			}
		}

		return dis[to];
	}
}
