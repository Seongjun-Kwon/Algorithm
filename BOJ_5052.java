import java.io.*;
import java.util.HashMap;

public class Main {
    static int t, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            boolean check = false;

            for (int i = 0; i < n; i++) {
                map.put(br.readLine(), i);
            }

            for (String key : map.keySet()) {
                for (int i = 0; i < key.length(); i++) {
                    if (map.containsKey(key.substring(0, i))) {
                        check = true;
                        break;
                    }
                }

                if (check) {
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
