import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static int n, eraseNum;
	private static List<List<Integer>> tree;
	private static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			tree.add(new ArrayList<>());
		}

		int rootNum = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int parentIdx = Integer.parseInt(st.nextToken());

			if (parentIdx == -1) {
				rootNum = i;
			} else {
				tree.get(parentIdx).add(i);
			}
		}

		eraseNum = Integer.parseInt(br.readLine());

		solve(rootNum);

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}

	private static void solve(int cur) {
		if (cur == eraseNum) {
			return;
		}
		if (tree.get(cur).size() == 0) {
			answer++;
			return;
		}

		for (int child : tree.get(cur)) {
			if (child == eraseNum && tree.get(cur).size() == 1) {
				answer++;
			}
			solve(child);
		}
	}
}
