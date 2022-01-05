import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class Date {
        int start, end;

        public Date(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int n;
    static int ans;
    static int standard;
    static boolean flag;
    static Date[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        ans = 0;
        standard = 301;
        flag = false;
        arr = new Date[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startM = Integer.parseInt(st.nextToken());
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endD = Integer.parseInt(st.nextToken());

            int start = startM * 100 + startD;
            int end = endM * 100 + endD;

            arr[i] = new Date(start, end);
        }

        solve();

        bw.write(Integer.toString(ans));
        br.close();
        bw.flush();
        bw.close();
    }

    static void solve() {
        while (standard < 1201) {
            int maxEnd = standard;

            for (Date d : arr) {
                if (d.start <= standard && maxEnd < d.end) {
                    maxEnd = d.end;
                    flag = true;
                }
            }

            if (flag) {
                standard = maxEnd;
                flag = false;
                ans++;
            } else {
                ans = 0;
                return;
            }
        }
    }
}
