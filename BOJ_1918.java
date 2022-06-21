import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Stack<Character> sta = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!sta.isEmpty() && getPriority(sta.peek()) >= getPriority(c)) {
                    sb.append(sta.pop());
                }

                sta.push(c);
            } else if (c == '(') {
                sta.push(c);
            } else if (c == ')') {
                while (!sta.isEmpty() && sta.peek() != '(') {
                    sb.append(sta.pop());
                }

                sta.pop();
            } else {
                sb.append(c);
            }
        }

        while (!sta.isEmpty()) {
            sb.append(sta.pop());
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static int getPriority(char operator) {
        if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '(' || operator == ')') {
            return 0;
        }

        return -1;
    }
}
