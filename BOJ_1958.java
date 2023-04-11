import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String firstStr = br.readLine();
		String secondStr = br.readLine();
		String thirdStr = br.readLine();

		// dp[i][j][k] = 첫번째 str 의 i 번째, 두번째 str 의 j 번째, 세번째 str 의 k 번째까지 의 LCS
		int[][][] dp = new int[firstStr.length() + 1][secondStr.length() + 1][thirdStr.length() + 1];

		for (int i = 1; i < firstStr.length() + 1; i++) {
			for (int j = 1; j < secondStr.length() + 1; j++) {
				for (int k = 1; k < thirdStr.length() + 1; k++) {
					if (firstStr.charAt(i - 1) == secondStr.charAt(j - 1) && secondStr.charAt(j - 1) == thirdStr.charAt(k - 1)) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					} else {
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
					}
				}
			}
		}

		bw.write(Integer.toString(dp[firstStr.length()][secondStr.length()][thirdStr.length()]));
		br.close();
		bw.flush();
		bw.close();
	}
}
