import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] val;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		val = new int[N];
		ans = new int[2];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			val[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(val);

		solve();
		sb.append(ans[0]).append(' ').append(ans[1]);

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

	private static void solve() {
		int start = 0;
		int end = N - 1;
		int result = Integer.MAX_VALUE;

		while (start < end) {
			int sum = val[start] + val[end];

			if (Math.abs(sum) < result) {
				result = Math.abs(sum);
				ans[0] = val[start];
				ans[1] = val[end];

				if (sum == 0) {
					break;
				}
			}

			if (sum < 0) {
				start++;
			} else {
				end--;
			}
		}
	}
}
