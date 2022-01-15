import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            int lo = -1;
            int hi = n - 1;

            while (lo + 1 < hi) {
                int mid = (lo + hi) / 2;

                if (arr[mid] >= num) {
                    hi = mid;
                } else if (arr[mid] < num) {
                    lo = mid;
                }
            }

            if (arr[hi] == num) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
