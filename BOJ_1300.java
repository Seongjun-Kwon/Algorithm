import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int lo = 0;
		int hi = k;

		while (lo + 1 < hi) {
			int cnt = 0;
			int mid = (lo + hi) / 2;

			for (int i = 1; i < N + 1; i++) {
				cnt += Math.min(mid / i, N);
			}

			if (cnt >= k) {
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
}
