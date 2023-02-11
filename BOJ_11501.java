import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] price = new int[N];
			long sum = 0;
			int maxPrice = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				price[j] = Integer.parseInt(st.nextToken());
			}

			for (int k = N - 1; k >= 0; k--) {
				maxPrice = Math.max(price[k], maxPrice);

				if (price[k] < maxPrice) {
					sum += maxPrice - price[k];
				}
			}

			sb.append(sum).append('\n');
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
