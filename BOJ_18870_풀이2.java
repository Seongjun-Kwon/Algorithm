import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int n;
    static int[] arr;
    static int[] sortedArr;
    static ArrayList<Integer> noDuplicationArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sortedArr = new int[n];
        noDuplicationArr = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }

        Arrays.sort(sortedArr);

        for (int i = 0; i < n - 1; i++) {
            if (sortedArr[i] != sortedArr[i + 1]) {
                noDuplicationArr.add(sortedArr[i]);
            }
        }

        noDuplicationArr.add(sortedArr[n - 1]);

        for (int i = 0; i < n; i++) {
            lowerBound(arr[i]);
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void lowerBound(int target) {
        int lo = -1;
        int hi = noDuplicationArr.size() - 1;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;

            if (noDuplicationArr.get(mid) >= target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        sb.append(hi).append(' ');
    }
}
