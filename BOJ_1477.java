import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int N, M, L;
	private static int[] restArea;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		restArea = new int[N + 2];
		restArea[0] = 0;
		restArea[N + 1] = L;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			restArea[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(restArea);

		int lo = 0;
		int hi = L;

		while (lo +1< hi) {
			int mid = (lo + hi) / 2;

			if (getRestAreaCnt(mid) <= M) {
				hi = mid;
			} else {
				lo = mid;
			}
		}

		bw.write(Integer.toString(hi));
		br.close();
		bw.flush();
		bw.close();
	}

	public static int getRestAreaCnt(int distance) {
		int cnt = 0;

		for (int i = 0; i < N + 1; i++) {
			cnt += (restArea[i + 1] - restArea[i] - 1) / distance;
		}
		return cnt;
	}
}
