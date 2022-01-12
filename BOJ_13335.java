import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, w, L, ans;
    static Queue<Integer> q;
    static int[] bridge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        ans = 0;
        q = new LinkedList<>();
        bridge = new int[w];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        solve();

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve() {
        while (true) {
            int tmp = nowWeight(); // 현재 다리 위에 있는 트럭의 무게

            if (tmp <= L) {
                tmp -= bridge[w - 1]; // 나가는 트럭의 무게를 빼준다.
                move();

                if (!q.isEmpty() && (tmp + q.peek()) <= L) { // 다리에 추가로 트럭이 더 올라갈 수 있는 경우
                    bridge[0] = q.poll();
                }
            }

            ans++;

            if (isEmptyBridge()) { // 다리가 비었으면 탈출
                return;
            }
        }
    }

    static int nowWeight() {
        int sum = 0;

        for (int i = 0; i < w; i++) {
            sum += bridge[i];
        }

        return sum;
    }

    static void move() {
        for (int i = w - 1; i > 0; i--) {
            bridge[i] = bridge[i - 1];
        }

        bridge[0] = 0;
    }

    static boolean isEmptyBridge() {
        for (int i = 0; i < w; i++) {
            if (bridge[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
