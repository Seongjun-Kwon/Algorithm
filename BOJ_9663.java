import java.io.*;

public class Main {
    static int n, ans;
    static int[] row_col; // row_col[i] = j 라고 하면, i행의 퀸은 j열에 위치한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        ans = 0;
        row_col = new int[n];

        solve(0);

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int r) {
        if (r == n) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) { // 0부터 n-1 열
            row_col[r] = i;

            if (isPossilble(r)) {
                solve(r + 1);
            }
        }
    }

    static boolean isPossilble(int r) {
        for (int i = 0; i < r; i++) {
            if (row_col[r] == row_col[i]) { // 0 ~ r-1행에 위치한 퀸이 r행에 위치한 퀸과 같은 열에 위치하는지 검사
                return false;
            }
        }

        for (int i = 0; i < r; i++) {
            if (Math.abs(r - i) == Math.abs(row_col[r] - row_col[i])) { // 0 ~ r-1행에 위치한 퀸이 r행에 위치한 퀸과 대각선으로 위치하는지 검사
                return false;
            }
        }

        return true;
    }
}
