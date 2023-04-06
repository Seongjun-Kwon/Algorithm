import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static int N, W;
	private static ArrayList<ArrayList<Integer>> tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		tree = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;

			tree.get(from).add(to);
			tree.get(to).add(from);
		}

		int leafCnt = 0;

		for (int i = 1; i < N; i++) {
			if (tree.get(i).size() == 1) {
				leafCnt++;
			}
		}

		bw.write(String.format("%.10f", (double)W / leafCnt));
		br.close();
		bw.flush();
		bw.close();
	}
}
