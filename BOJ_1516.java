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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		List<List<Integer>> buildings = new ArrayList<>();
		int[] time = new int[n];
		int[] minTime = new int[n];
		int[] inDegreeCount = new int[n];

		for (int i = 0; i < n; i++) {
			buildings.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			minTime[i] = time[i];

			while (true) {
				int before = Integer.parseInt(st.nextToken()) - 1;

				if (before == -2) {
					break;
				}

				inDegreeCount[i]++;
				buildings.get(before).add(i);
			}
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < inDegreeCount.length; i++) {
			if (inDegreeCount[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int current = q.poll();

			for (int next : buildings.get(current)) {
				inDegreeCount[next]--;
				minTime[next] = Math.max(minTime[next], minTime[current] + time[next]);

				if (inDegreeCount[next] == 0) {
					q.add(next);
				}
			}
		}

		for (int i = 0; i < minTime.length; i++) {
			sb.append(minTime[i]).append('\n');
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
