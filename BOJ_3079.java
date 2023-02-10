import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = new int[N];

		long maxTime = Long.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			T[i] = Integer.parseInt(br.readLine());
			maxTime = Math.max(maxTime, T[i]);
		}

		maxTime = M * maxTime;
		long lo = 0;
		long hi = maxTime;

		while (lo + 1 < hi) {
			long mid = (lo + hi) / 2;
			long sum = 0;

			for (int i = 0; i < N; i++) {
				sum += mid / T[i];
			}

			if (sum >= M) {
				hi = mid;
			} else {
				lo = mid;
			}
		}

		bw.write(Long.toString(hi));
		br.close();
		bw.flush();
		bw.close();
	}
}
