import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int n;
    static PriorityQueue<Integer> maxPq;
    static PriorityQueue<Integer> minPq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        minPq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (maxPq.size() <= minPq.size()) {
                maxPq.add(num);

                if (!minPq.isEmpty() && maxPq.peek() > minPq.peek()) {
                    minPq.add(maxPq.poll());
                    maxPq.add(minPq.poll());
                }
            } else {
                minPq.add(num);

                if (maxPq.peek() > minPq.peek()) {
                    minPq.add(maxPq.poll());
                    maxPq.add(minPq.poll());
                }
            }

            sb.append(maxPq.peek()).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
