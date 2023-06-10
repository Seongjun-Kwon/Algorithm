import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	private static int n, k;
	private static int[] dis = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		Arrays.fill(dis, -1);

		solve(n);

		bw.write(Integer.toString(dis[k]));
		br.close();
		bw.flush();
		bw.close();
	}

	private static void solve(int start) {
		Deque<Integer> deque = new LinkedList<>();
		deque.add(start);
		dis[start] = 0;

		while (!deque.isEmpty()) {
			int now = deque.pollFirst();

			if (now == k) {
				break;
			}

			if (2 * now <= 100000 && dis[2 * now] == -1) {
				deque.addFirst(2 * now);
				dis[2 * now] = dis[now];
			}
			if (now != 100000 && dis[now + 1] == -1) {
				deque.addLast(now + 1);
				dis[now + 1] = dis[now] + 1;
			}
			if (now != 0 && dis[now - 1] == -1) {
				deque.addLast(now - 1);
				dis[now - 1] = dis[now] + 1;
			}
		}
	}
}
