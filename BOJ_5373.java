import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int cnt;
    static int[][][] cube = new int[6][3][3];

    /*              U
          0  1  2
          3  4  5
          6  7  8
L        __________  R          B
36 37 38|F18 19 20 | 45 46 47 | 27 28 29
39 40 41| 21 22 23 | 48 49 50 | 30 31 32
42 43 44| 24 25 26 | 51 52 53 | 33 34 35
         -----------
          9  10 11
          12 13 14
          15 16 17
          D
*/

    static int[][] side = {
            {36, 37, 38, 18, 19, 20, 45, 46, 47, 27, 28, 29},        //U
            {33, 34, 35, 51, 52, 53, 24, 25, 26, 42, 43, 44},        //D
            {6, 7, 8, 44, 41, 38, 11, 10, 9, 45, 48, 51},            //F
            {2, 1, 0, 53, 50, 47, 15, 16, 17, 36, 39, 42},           //B
            {0, 3, 6, 35, 32, 29, 9, 12, 15, 18, 21, 24},            //L
            {8, 5, 2, 26, 23, 20, 17, 14, 11, 27, 30, 33}            //R
    };

    static char[] cubeColor = new char[54];
    static char[] color = {'w', 'y', 'r', 'o', 'g', 'b'}; // 윗면(w) 0, 아랫면(y) 1, 앞면(r) 2, 뒷면(o) 3, 왼쪽(g) 4, 오른쪽(b) 5

    static HashMap<Character, Integer> cubePlane = new HashMap<Character, Integer>() {
        {
            put('U', 0);
            put('D', 1);
            put('F', 2);
            put('B', 3);
            put('L', 4);
            put('R', 5);
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        setCube();

        cnt = Integer.parseInt(br.readLine());

        while (cnt-- > 0) {
            setCubeColor();

            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                String cmd = st.nextToken();
                char plane = cmd.charAt(0);
                char dir = cmd.charAt(1);

                if (dir == '+') {
                    rotatePlane(cubePlane.get(plane));
                    rotateSide(cubePlane.get(plane));
                } else {
                    for (int j = 0; j < 3; j++) {
                        rotatePlane(cubePlane.get(plane));
                        rotateSide(cubePlane.get(plane));
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(cubeColor[i * 3 + j]);
                }

                sb.append('\n');
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void setCube() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    cube[i][j][k] = i * 9 + j * 3 + k;
                }
            }
        }
    }

    static void setCubeColor() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                cubeColor[i * 9 + j] = color[i];
            }
        }
    }

    public static void rotatePlane(int planeNum) {
        char[][] temp = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = cubeColor[cube[planeNum][i][j]];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cubeColor[cube[planeNum][j][2 - i]] = temp[i][j];
            }
        }
    }

    public static void rotateSide(int planeNum) {
        char[] temp = new char[12];

        for (int i = 0; i < 12; i++) {
            temp[i] = cubeColor[side[planeNum][i]];
        }

        for (int i = 0; i < 12; i++) {
            cubeColor[side[planeNum][i]] = temp[(i + 3) % 12];
        }
    }
}
