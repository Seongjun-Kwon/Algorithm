import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = Integer.MAX_VALUE;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int lo = 0;
        int hi = 1;

        while (lo <= hi && hi < n) {

            if (arr[hi] - arr[lo] > m) {
                if (ans > arr[hi] - arr[lo]) {
                    ans = arr[hi] - arr[lo];
                }

                lo++;
                continue;
            } else if (arr[hi] - arr[lo] < m) {
                hi++;
                continue;
            } else {
                ans = m;
                break;
            }
        }

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }
}
