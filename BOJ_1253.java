import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int answer = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		for (int i = 0; i < N; i++) {
			int start = 0;
			int end = N - 1;

			while (start < end) {
				if (i == start) {
					start++;
				}
				if (i == end) {
					end--;
				}

				if (start >= end) {
					break;
				}

				if (num[start] + num[end] < num[i]) {
					start++;
				} else if (num[start] + num[end] > num[i]) {
					end--;
				} else {
					answer++;
					break;
				}
			}
		}

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}
}
