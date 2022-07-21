package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2667 {
    static boolean[][] visited;
    static int[][] houseMap;
    static int N;
    public static void main(String[] args) throws IOException {

        //입력을 받는다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        houseMap = new int[N][N];

        String str;
        String[] strArr;
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
            str = br.readLine();
            strArr = str.split("");
            for (int j = 0; j < N; j++) {
                houseMap[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        //아파트단지 이중포문을 돌며 단지 내의 집 수를 구한다.
        List<Integer> houseCntList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (houseMap[i][j] == 1 && visited[i][j] == false) {
                    houseCntList.add(bfs(new Location(i, j)));
                }
            }
        }

        //리스트에 단지수를 넣어 정렬 후 출력
        Collections.sort(houseCntList);
        System.out.println(houseCntList.size());
        for (Integer houseCnt : houseCntList) {
            System.out.println(houseCnt);
        }
    }

    public static int bfs(Location location) {
        int[] rowOp = new int[]{0,0,-1,1};
        int[] columnOp = new int[]{1,-1,0,0};
        //집의 개수 0으로 초기화
        int cnt = 0;
        //큐에 넣고 visited배열에 표시, 집개수 +1
        Queue<Location> q = new LinkedList<>();
        q.add(location);
        visited[location.row][location.column] = true;
        cnt++;

        while (!q.isEmpty()) {
            //큐에서 하나씩 꺼내어 인접한 집 방문, 방문할 때 집 카운트 추가
            Location curLocation = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = curLocation.row + rowOp[i];
                int nextColumn = curLocation.column + columnOp[i];
                if((nextRow>=0&&nextColumn>=0&&nextRow<N&&nextColumn<N)
                    &&visited[nextRow][nextColumn] ==false
                    &&houseMap[nextRow][nextColumn] == 1){
                    q.add(new Location(nextRow, nextColumn));
                    visited[nextRow][nextColumn] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static class Location{
        int row;
        int column;

        public Location(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
