import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static String str;
    static Stack<Character> sta;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        str = br.readLine();
        sta = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            while (k > 0 && !sta.isEmpty() && c > sta.peek()) {
                sta.pop();
                k--;
            }

            sta.push(c);
        }

        while (sta.size() > 0) {
            sb.append(sta.pop());
        }

        bw.write(sb.reverse().substring(0, sb.length() - k));
        br.close();
        bw.flush();
        bw.close();
    }
}
