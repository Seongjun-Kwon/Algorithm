import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Jewel implements Comparable<Jewel> {
        int weight, price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.weight <= o.weight ? -1 : 1;
        }
    }

    static int n, k;
    static Jewel[] jewel;
    static int[] bag;
    static PriorityQueue<Integer> pq;
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        jewel = new Jewel[n];
        bag = new int[k];
        pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            jewel[i] = new Jewel(weight, price);
        }

        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewel);
        Arrays.sort(bag);

        solve();

        bw.write(Long.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve() {
        int idx = 0;

        for (int i = 0; i < k; i++) {

            while (idx < n && jewel[idx].weight <= bag[i]) {
                pq.add(jewel[idx].price);
                idx++;
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
    }
}
