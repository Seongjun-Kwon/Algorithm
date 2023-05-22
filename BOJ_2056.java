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

	private static int n;
	private static int[] inDegreeCount;
	private static int[] time;
	private static int[] minTime;
	private static List<List<Integer>> works;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		inDegreeCount = new int[n];
		time = new int[n];
		minTime = new int[n];
		works = new ArrayList<>();
		int answer = 0;

		for (int i = 0; i < n; i++) {
			works.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int beforeNum = Integer.parseInt(st.nextToken());
			inDegreeCount[i] = beforeNum;

			for (int j = 0; j < beforeNum; j++) {
				int before = Integer.parseInt(st.nextToken()) - 1;
				works.get(before).add(i);
			}
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < inDegreeCount.length; i++) {
			minTime[i] = time[i];

			if (inDegreeCount[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int currentWork = q.poll();

			for (int i = 0; i < works.get(currentWork).size(); i++) {
				int nextWork = works.get(currentWork).get(i);
				minTime[nextWork] = Math.max(minTime[nextWork], minTime[currentWork] + time[nextWork]);
				inDegreeCount[nextWork]--;

				if (inDegreeCount[nextWork] == 0) {
					q.add(nextWork);
				}
			}
		}

		for (int i = 0; i < minTime.length; i++) {
			if (answer < minTime[i]) {
				answer = minTime[i];
			}
		}

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}
}
