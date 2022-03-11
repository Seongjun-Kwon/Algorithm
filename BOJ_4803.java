import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] vis;
    static int caseIdx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            caseIdx++;

            int treeCnt = 0;
            tree = new ArrayList<>();
            vis = new boolean[n + 1];

            for (int i = 0; i < n + 1; i++) {
                tree.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                tree.get(from).add(to);
                tree.get(to).add(from);
            }

            for (int i = 1; i < n + 1; i++) {
                if (vis[i]) {
                    continue;
                }

                vis[i] = true;

                if (dfs(0, i)) {
                    treeCnt++;
                }
            }

            sb.append("Case ").append(caseIdx).append(": ");

            if (treeCnt == 0) {
                sb.append("No trees.\n");
            } else if (treeCnt == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(treeCnt).append(" trees.\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static boolean dfs(int prev, int idx) { // 참이면 사이클이 없기에 트리, 거짓이면 트리가 아님
        for (int node : tree.get(idx)) {
            if (node == prev) {
                continue;
            }

            if (vis[node]) {
                return false;
            }

            vis[node] = true;
            
            if (!dfs(idx, node)) {
                return false;
            }
        }

        return true;
    }
}
