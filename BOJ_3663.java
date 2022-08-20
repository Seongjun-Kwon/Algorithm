import java.io.*;

public class Main {
    static int testNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        testNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testNum; i++) {
            String name = br.readLine();
            int answer = solve(name);
            sb.append(answer).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static int solve(String name) {
        int answer = 0;
        answer += getLeftRightCnt(name);

        for (int i = 0; i < name.length(); i++) {
            answer += getUpDownCount(name.charAt(i));
        }

        return answer;
    }

    static int getLeftRightCnt(String name) {
        int leftRightCnt = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                continue;
            }

            int endIdx = i + 1;

            while (endIdx < name.length() && name.charAt(endIdx) == 'A') {
                endIdx++;
            }

            int leftCnt = i == 0 ? 0 : i - 1;
            int rightCnt = name.length() - endIdx;

            leftRightCnt = Math.min(leftRightCnt, leftCnt + rightCnt + Math.min(leftCnt, rightCnt));
        }

        return leftRightCnt;
    }

    static int getUpDownCount(char c) {
        return Math.min(c - 'A', 'Z' - c + 1);
    }
}
