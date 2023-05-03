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

	static class Point {
		int x, y, dis;

		public Point(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}

	private static int n, T;
	private static List<List<Point>> points;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		points = new ArrayList<>();

		for (int i = 0; i < T + 1; i++) {
			points.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			points.get(y).add(new Point(x, y, 0));
		}

		int answer = solve();

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

	private static int solve() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0));

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (cur.y == T) {
				return cur.dis;
			}

			for (int i = -2; i <= 2; i++) {
				int ny = cur.y + i;

				if (ny < 0 || ny > T) {
					continue;
				}

				for (int j = 0; j < points.get(ny).size(); j++) {
					Point nxt = points.get(ny).get(j);

					if (Math.abs(cur.x - nxt.x) > 2 || nxt.dis > 0) {
						continue;
					}

					q.add(nxt);
					nxt.dis = cur.dis + 1;
				}
			}
		}

		return -1;
	}
}
