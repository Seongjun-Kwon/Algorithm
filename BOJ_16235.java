import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Tree implements Comparable<Tree> {
		int r, c, age;

		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}

	static int n, m, k;
	static int[][] field;
	static int[][] A;
	static PriorityQueue<Tree> pq = new PriorityQueue<>();
	static List<Tree> liveTrees = new ArrayList<>();
	static List<Tree> deadTrees = new ArrayList<>();
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		field = new int[n][n];
		A = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				field[i][j] = 5;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			pq.add(new Tree(x, y, age));
		}

		solve();

		bw.write(Integer.toString(pq.size()));
		br.close();
		bw.flush();
		bw.close();
	}

	private static void solve() {
		while (k-- > 0) {
			doSpring();
			doSummer();
			doAutumn();
			doWinter();
		}
	}

	private static void doSpring() {
		int size = pq.size();

		for (int i = 0; i < size; i++) {
			Tree cur = pq.poll();

			if (field[cur.r][cur.c] >= cur.age) {
				liveTrees.add(cur);
				field[cur.r][cur.c] -= cur.age;
				cur.age++;
			} else {
				deadTrees.add(cur);
			}
		}

		pq.addAll(liveTrees);
		liveTrees.clear();
	}

	private static void doSummer() {
		for (Tree cur : deadTrees) {
			int food = cur.age / 2;
			field[cur.r][cur.c] += food;
		}

		deadTrees.clear();
	}

	private static void doAutumn() {
		List<Tree> newTrees = new ArrayList<>();

		for (Tree cur : pq) {
			if (cur.age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];

					if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
						continue;
					}
					newTrees.add(new Tree(cur.r + dr[i], cur.c + dc[i], 1));
				}
			}
		}

		pq.addAll(newTrees);
	}

	private static void doWinter() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				field[i][j] += A[i][j];
			}
		}
	}
}
