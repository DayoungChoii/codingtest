package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q4963 {
    static int w, h;
    static int[][] islandMap;
    static boolean[][] visited;
    static int[] rowOp = {1,-1,0,0,1,1,-1,-1};
    static int[] columnOp = {0,0,1,-1,1,-1,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] strArr;
        //입력 while문으로 할 것 w, h가 0,0이 들어오면 while문 종료
        while(true) {
            str = br.readLine();
            strArr = str.split(" ");

            w = Integer.parseInt(strArr[0]);
            h = Integer.parseInt(strArr[1]);

            islandMap = new int[h][w];
            visited = new boolean[h][w];

            if (w == 0 && h == 0) {
                break;
            }

            for (int i = 0; i < h; i++) {
                str = br.readLine();
                strArr = str.split(" ");
                Arrays.fill(visited[i], false);
                for (int j = 0; j < w; j++) {
                    islandMap[i][j] = Integer.parseInt(strArr[j]);
                }
            }

            //섬의 개수 세기
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    //섬이고 방문하지 않았으면 dfs, 카운트 올려주기
                    if(islandMap[i][j] == 1 && visited[i][j] == false){
                        dfs(new Location(i, j));
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }

    public static void dfs(Location location) {
        //방문한 섬 visited표시
        visited[location.row][location.column] = true;

        //상하좌우, 대각선 돌며
        for(int i = 0;i<8;i++){
            int nextRow = location.row + rowOp[i];
            int nextColumn = location.column + columnOp[i];
            //범위 내에 있고 섬이고 방문하지 않았으면 섬 방문
            if((nextRow>=0&&nextColumn>=0&&nextRow<h&&nextColumn<w)
                && islandMap[nextRow][nextColumn] == 1
                && !visited[nextRow][nextColumn]){
                dfs(new Location(nextRow, nextColumn));
            }
        }

    }

    public static class Location{
        int row;
        int column;

        public Location(int row, int coloum) {
            this.row = row;
            this.column = coloum;
        }
    }

}
