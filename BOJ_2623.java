import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] indeg = new int[n];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num == 0) continue;

            int cur = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num - 1; j++) {
                int nxt = Integer.parseInt(st.nextToken());
                indeg[nxt - 1]++;
                arr.get(cur - 1).add(nxt - 1);
                cur = nxt;
            }
        }

        int[] ans = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (q.isEmpty()) {
                System.out.println(0);
                System.exit(0);
            }

            int cur = q.poll();
            ans[i] = cur + 1;

            for (int nxt : arr.get(cur)) {
                indeg[nxt]--;

                if (indeg[nxt] == 0) {
                    q.add(nxt);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(ans[i] + "\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
