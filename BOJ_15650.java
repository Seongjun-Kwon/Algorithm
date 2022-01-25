import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int n, m;
    static boolean[] vis;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        vis = new boolean[n + 1];
        arr = new int[m];

        solve(1, 0);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int num, int cnt) { // idx는 현재 보고 있는 수, cnt는 선택한 수의 갯수
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(' ');
            }

            sb.append('\n');
            return;
        }

        for (int i = num; i < n + 1; i++) { // i가 idx 부터 시작하기 때문에 선택한 수열을 오름차순으로 나열 가능하다
            if (vis[i]) { // 중복 선택 방지
                continue;
            }

            vis[i] = true;
            arr[cnt] = i;
            solve(i + 1, cnt + 1);
            vis[i] = false;
        }
    }
}
