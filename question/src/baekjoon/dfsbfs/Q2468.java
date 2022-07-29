package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q2468 {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        String str;
        String[] strArr;
        int h = 0;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            strArr = str.split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(strArr[j]);
                h = Math.max(h, map[i][j]);
            }
        }


        int cnt;
        int maxCnt = 1;
        //최대 높이까지 loop
        for (int i = 1; i <= h; i++) {
            //새로들어올 때 visited, cnt초기
            for (int j = 0; j < N; j++) {
                Arrays.fill(visited[j], false);
            }
            cnt = 0;
            //이중for문으로 map탐색화
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < N; m++) {
                    if(visited[n][m] == false && map[n][m] > i){
                        bfs(new Location(n, m), i);
                        cnt++;
                    }
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }

        System.out.println(maxCnt);
    }

    public static void bfs(Location location, int h) {
        //operation
        int[] rowOP = new int[]{-1, 1, 0, 0};
        int[] columnOP = new int[]{0, 0, -1, 1};

        //q만들어서 시작점 더하기
        Queue<Location> q = new LinkedList<>();
        q.add(location);
        visited[location.row][location.column] = true;

        //q에 요소 없어질 때까지
        while(!q.isEmpty()) {
            //q에서 요소하나 꺼내서 다음 갈 지점 만들기
            Location curLocation = q.poll();
            for(int i = 0 ; i < 4 ; i++) {
                int nextRow = curLocation.row + rowOP[i];
                int nextColumn = curLocation.column + columnOP[i];

                //다음지점 조건확인, map범위 내에 있는지, visited 거짓인지, 주어진 높이보다 높은지
                if((nextRow>=0 && nextColumn >= 0 && nextRow < N && nextColumn < N)
                    && visited[nextRow][nextColumn] == false
                    && map[nextRow][nextColumn] >h){
                    //q에 넣고 visited에 참 표시
                    q.add(new Location(nextRow, nextColumn));
                    visited[nextRow][nextColumn] = true;
                }
            }
        }
    }

    static class Location {
        int row;
        int column;

        public Location(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
