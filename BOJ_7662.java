import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>(); // key: 저장할 값, value: 그 값의 갯수
            int k = Integer.parseInt(br.readLine());

            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char cmd = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (cmd == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (cmd == 'D') {
                    if (map.isEmpty()) {
                        continue;
                    }

                    if (num == -1) {
                        int minKey = map.firstKey();

                        if (map.get(minKey) == 1) { // 만약 최솟값이 1개면 제거
                            map.remove(minKey);
                        } else { // 1개 이상이면 갯수를 한개 줄인다
                            map.put(minKey, map.get(minKey) - 1);
                        }
                    } else if (num == 1) {
                        int maxKey = map.lastKey();

                        if (map.get(maxKey) == 1) { // 만약 최댓값이 1개면 제거
                            map.remove(maxKey);
                        } else { // 1개 이상이면 갯수를 한개 줄인다
                            map.put(maxKey, map.get(maxKey) - 1);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append('\n');
            } else {
                sb.append(map.lastKey()).append(' ').append(map.firstKey()).append('\n');
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}
