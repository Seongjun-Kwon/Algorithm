import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int tmp = lowerBound(arr[i]);

            if (ans > tmp && tmp >= m) {
                ans = tmp;
            }
        }

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static int lowerBound(int target) {
        int lo = -1;
        int hi = n - 1;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] >= target + m) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return arr[hi] - target;
    }
}
