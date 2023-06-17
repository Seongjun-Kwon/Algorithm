import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	private static class City implements Comparable<City> {
		int index;
		int value;

		public City(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(City o) {
			return this.value - o.value;
		}
	}

	private static int n, m, x;
	private static List<List<City>> cities;
	private static int[][] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken()) - 1;
		cities = new ArrayList<>();
		distance = new int[n][n];

		for (int i = 0; i < n; i++) {
			cities.add(new ArrayList<>());
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int time = Integer.parseInt(st.nextToken());

			cities.get(from).add(new City(to, time));
		}

		for (int i = 0; i < n; i++) {
			solve(i, distance[i]);
		}

		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, distance[i][x] + distance[x][i]);
		}

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

	private static void solve(int start, int[] distance) {
		PriorityQueue<City> pq = new PriorityQueue<>();
		distance[start] = 0;
		pq.add(new City(start, distance[start]));

		while (!pq.isEmpty()) {
			City now = pq.poll();
			int startToNowDistance = now.value;

			if (startToNowDistance > distance[now.index]) {
				continue;
			}

			for (City next : cities.get(now.index)) {
				int nowToNextDistance = next.value;

				if (startToNowDistance + nowToNextDistance < distance[next.index]) {
					distance[next.index] = startToNowDistance + nowToNextDistance;
					pq.add(new City(next.index, distance[next.index]));
				}
			}
		}
	}
}
