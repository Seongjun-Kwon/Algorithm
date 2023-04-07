import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int T, n, m;
	private static int[] A, B;
	private static List<Integer> subA, subB;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		A = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		m = Integer.parseInt(br.readLine());
		B = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		subA = new ArrayList<>();
		subB = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int sum = 0;

			for (int j = i; j < n; j++) {
				sum += A[j];
				subA.add(sum);
			}
		}
		for (int i = 0; i < m; i++) {
			int sum = 0;

			for (int j = i; j < m; j++) {
				sum += B[j];
				subB.add(sum);
			}
		}

		Collections.sort(subA);
		Collections.sort(subB);

		bw.write(Long.toString(solve()));
		br.close();
		bw.flush();
		bw.close();
	}

	private static long solve() {
		int pointA = 0;
		int pointB = subB.size() - 1;
		long cnt = 0;

		while (pointA < subA.size() && pointB >= 0) {
			int sum = subA.get(pointA) + subB.get(pointB);

			if (sum == T) {
				int aVal = subA.get(pointA);
				int bVal = subB.get(pointB);
				long aCnt = 0;
				long bCnt = 0;

				while (pointA < subA.size() && subA.get(pointA) == aVal) {
					aCnt++;
					pointA++;
				}
				while (pointB >= 0 && subB.get(pointB) == bVal) {
					bCnt++;
					pointB--;
				}

				cnt += aCnt * bCnt;

			} else if (sum < T) {
				pointA++;
			} else { // sum > T
				pointB--;
			}
		}

		return cnt;
	}
}
