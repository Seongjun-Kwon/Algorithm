import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] arr = new int[n];
        int[] tmp = new int[n];
        Map<Integer, Integer> map = new HashMap<>();


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            tmp[i] = arr[i];
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], cnt++);
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(map.get(tmp[i])).append(' ');
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
