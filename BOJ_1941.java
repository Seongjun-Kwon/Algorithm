import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] arr;
    static boolean[] select;
    static boolean[] vis;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new char[5][5];
        select = new boolean[25];

        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        solve(0, 0, 0, 0);

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve(int idx, int sCnt, int yCnt, int allCnt) { // 25명의 공주 중 7명을 중복x, 순서 상관x 하게 선택
        if (allCnt == 7) {
            if (sCnt >= 4 && isPossible()) { // s가 4개 이상이고 모두 인접해있을 경우
                ans++;
                return;
            }

            return;
        }

        for (int i = idx; i < 25; i++) {
            if (select[i]) {
                continue;
            }

            select[i] = true;

            if (arr[i / 5][i % 5] == 'S') {
                solve(i + 1, sCnt + 1, yCnt, allCnt + 1);
            } else {
                solve(i + 1, sCnt, yCnt + 1, allCnt + 1);
            }

            select[i] = false;
        }
    }

    static boolean isPossible() { // 학생들끼리 서로 붙어있는지 확인
        Queue<Integer> q = new LinkedList<>();
        vis = new boolean[25];

        for (int i = 0; i < 25; i++) {
            if (select[i]) {
                vis[i] = true;
                q.add(i);
                break;
            }
        }

        int cnt = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur / 5 + dr[i];
                int nc = cur % 5 + dc[i];

                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || !select[nr * 5 + nc] || vis[nr * 5 + nc]) {
                    continue;
                }

                vis[nr * 5 + nc] = true;
                q.add(nr * 5 + nc);
                cnt++;
            }
        }

        if (cnt == 7) {
            return true;
        } else {
            return false;
        }
    }
}
