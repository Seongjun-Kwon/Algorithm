import java.io.*;
import java.util.Arrays;

public class Main {
    static int t, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            String[] str = new String[n];
            boolean check = false;

            for (int i = 0; i < n; i++) {
                str[i] = br.readLine();
            }

            Arrays.sort(str);

            for (int i = 0; i < n - 1; i++) {
                if (str[i + 1].startsWith(str[i])) {
                    check = true;
                    break;
                }
            }

            if (check) {
                sb.append("NO").append('\n');
            } else {
                sb.append("YES").append('\n');
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
