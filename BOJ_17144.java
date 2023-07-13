import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	private static int r, c, t, cleanerTopR, cleanerBottomR;
	private static int[][] room;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		room = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < c; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());

				if (cleanerTopR == 0 & room[i][j] == -1) {
					cleanerTopR = i;
					cleanerBottomR = i + 1;
				}
			}
		}

		for (int i = 0; i < t; i++) {
			diffuse();
			cleanAir();
		}

		bw.write(Integer.toString(getAnswer()));
		br.close();
		bw.flush();
		bw.close();
	}

	private static void diffuse() {
		int[][] temp = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (room[i][j] <= 0) {
					continue;
				}

				int diffusionAmount = room[i][j] / 5;

				for (int k = 0; k < 4; k++) {
					int nextR = i + dr[k];
					int nextC = j + dc[k];

					if (nextR < 0 || nextC < 0 || nextR >= r || nextC >= c || room[nextR][nextC] == -1) {
						continue;
					}

					room[i][j] -= diffusionAmount;
					temp[nextR][nextC] += diffusionAmount;
				}
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				room[i][j] += temp[i][j];
			}
		}
	}

	private static void cleanAir() {
		cleanTop();
		cleanBottom();
	}

	private static void cleanTop() {
		for (int i = cleanerTopR; i > 0; i--) {
			if (room[i][0] == -1) {
				continue;
			}
			room[i][0] = room[i - 1][0];
		}

		for (int i = 0; i < c - 1; i++) {
			room[0][i] = room[0][i + 1];
		}

		for (int i = 0; i < cleanerTopR; i++) {
			room[i][c - 1] = room[i + 1][c - 1];
		}

		for (int i = c - 1; i > 0; i--) {
			room[cleanerTopR][i] = room[cleanerTopR][i - 1];

			if (room[cleanerTopR][i - 1] == -1) {
				room[cleanerTopR][i] = 0;
			}
		}
	}

	private static void cleanBottom() {
		for (int i = cleanerBottomR; i < r - 1; i++) {
			if (room[i][0] == -1) {
				continue;
			}
			room[i][0] = room[i + 1][0];
		}

		for (int i = 0; i < c - 1; i++) {
			room[r - 1][i] = room[r - 1][i + 1];
		}

		for (int i = r - 1; i > cleanerBottomR; i--) {
			room[i][c - 1] = room[i - 1][c - 1];
		}

		for (int i = c - 1; i > 0; i--) {
			room[cleanerBottomR][i] = room[cleanerBottomR][i - 1];

			if (room[cleanerBottomR][i - 1] == -1) {
				room[cleanerBottomR][i] = 0;
			}
		}
	}

	private static int getAnswer() {
		int answer = 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (room[i][j] == -1) {
					continue;
				}

				answer += room[i][j];
			}
		}

		return answer;
	}
}
