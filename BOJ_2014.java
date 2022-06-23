import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int k, n;
    static long[] primeNumber;
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        primeNumber = new long[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            primeNumber[i] = Long.parseLong(st.nextToken());
            pq.add(primeNumber[i]);
        }

        solve();

        long answer = pq.poll();

        bw.write(Long.toString(answer));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve() {
        for (int i = 0; i < n - 1; i++) {
            long now = pq.poll();

            for (int j = 0; j < k; j++) {
                long nxt = now * primeNumber[j];
                pq.add(nxt);

                if (now % primeNumber[j] == 0) {
                    break;
                }
            }
        }
    }
}
