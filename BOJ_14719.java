import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] height = new int[w];
		int answer = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < w; i++) {
			int leftMax = Integer.MIN_VALUE;
			int rightMax = Integer.MIN_VALUE;

			for (int j = 0; j < i; j++) {
				leftMax = Math.max(leftMax, height[j]);
			}
			for (int k = i + 1; k < w; k++) {
				rightMax = Math.max(rightMax, height[k]);
			}

			int leftRightMin = Math.min(leftMax, rightMax);

			if (height[i] < leftRightMin) {
				answer += leftRightMin - height[i];
			}
		}

		bw.write(Integer.toString(answer));
		br.close();
		bw.flush();
		bw.close();
	}
}
