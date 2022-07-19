package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1012 {
    static boolean[][] vegetableSpot;
    static int M, N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String groundInfo = br.readLine();
            String[] groundInfoArr = groundInfo.split(" ");
            M = Integer.parseInt(groundInfoArr[0]);
            N = Integer.parseInt(groundInfoArr[1]);
            K = Integer.parseInt(groundInfoArr[2]);

            vegetableSpot = new boolean[N][M];

            for (int k = 0; k < N; k++) {
                Arrays.fill(vegetableSpot[k], false);
            }

            String baechuInfo;
            String[] baechuInfoArr;
            int row;
            int column;
            for (int j = 0; j < K; j++) {
                baechuInfo = br.readLine();
                baechuInfoArr = baechuInfo.split(" ");
                column = Integer.parseInt(baechuInfoArr[0]);
                row = Integer.parseInt(baechuInfoArr[1]);
                vegetableSpot[row][column] = true;
            }
            int cnt = 0;
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if(vegetableSpot[n][m]){
                        bfs(new Location(n, m));
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void bfs(Location location){
        List<Location> operator = new ArrayList<>();
        operator.add(new Location(1, 0));
        operator.add(new Location(-1, 0));
        operator.add(new Location(0, 1));
        operator.add(new Location(0, -1));


        Queue<Location> q = new LinkedList<>();
        q.add(location);
        vegetableSpot[location.x][location.y] = false;

        while (!q.isEmpty()){
            Location curLocation = q.poll();

            for(int i = 0; i<4;i++) {
                int nextX = curLocation.x + operator.get(i).x;
                int nextY = curLocation.y + operator.get(i).y;
                if ((nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) && vegetableSpot[nextX][nextY]) {
                    vegetableSpot[nextX][nextY] = false;
                    q.add(new Location(nextX, nextY));
                }
            }
        }
    }

    static class Location{
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
