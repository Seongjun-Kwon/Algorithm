import java.io.*;

public class Main {
    static int T;
    static long[] gSum;
    static long[] fSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        gSum = new long[1000001];
        fSum = new long[1000001];

        getDivisorSum();

        for (int i = 1; i < gSum.length; i++) {
            gSum[i] += gSum[i - 1] + fSum[i];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(gSum[N]).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void getDivisorSum() {
        for (int i = 1; i < fSum.length; i++) {
            for (int j = 1; i * j < fSum.length; j++) {
                fSum[i * j] += i;
            }
        }
    }
}
