import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < M + 1; i++) {
                adj.add(new ArrayList<>());
            }

            int[] indeg = new int[M + 1];
            int[] strahler = new int[M + 1]; // strahler[i] = i의 순서값
            int[][] info = new int[M + 1][2]; // info[i][0] = i로 들어오는 강의 순서 중 가장 큰 값, info[i][1] = info[i][0]의 갯수

            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                adj.get(A).add(B);
                indeg[B]++;
            }

            topoSort(M, indeg, adj, strahler, info);

            sb.append(K).append(' ').append(strahler[M]).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void topoSort(int M, int[] indeg, ArrayList<ArrayList<Integer>> adj, int[] strahler, int[][] info) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < M + 1; i++) {
            if (indeg[i] == 0) {
                q.add(i);
                strahler[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < adj.get(cur).size(); i++) {
                int nxt = adj.get(cur).get(i);

                if (strahler[cur] > info[nxt][0]) {
                    info[nxt][0] = strahler[cur];
                    info[nxt][1] = 1;
                } else if (strahler[cur] == info[nxt][0]) {
                    info[nxt][1]++;
                }

                if (info[nxt][1] >= 2) {
                    strahler[nxt] = info[nxt][0] + 1;
                } else if (info[nxt][1] == 1) {
                    strahler[nxt] = info[nxt][0];
                }

                indeg[nxt]--;

                if (indeg[nxt] == 0) {
                    q.add(nxt);
                }
            }
        }
    }
}
