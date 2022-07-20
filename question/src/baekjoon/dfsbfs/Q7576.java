package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7576 {
    static int N,M;
    static int[][] box;
    static int[][] visited;
    public static void main(String[] args) throws IOException {

        List<Location> startLocation =new ArrayList<>();
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] strArr;

        str = br.readLine();
        strArr = str.split(" ");

        M = Integer.parseInt(strArr[0]); //가로, 열
        N = Integer.parseInt(strArr[1]); //세로, 행

        box = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            strArr = str.split(" ");

            Arrays.fill(visited[i], 0);
            for (int j = 0; j < M; j++) {
                if(Integer.parseInt(strArr[j]) == 1) startLocation.add(new Location(i, j));
                box[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        //모든토마토가 익은 상태면 0
        if(isAllTomatoRiped()){
            System.out.println(0);
        } else{
            int minDate = bfs(startLocation);
            if(!isAllTomatoRiped()){ //토마토가 익지 못하는 상황 -1
                System.out.println(-1);
            } else{ //토마토가 익은 최소 날짜
                System.out.println(minDate);
            }
        }
    }

    private static boolean isAllTomatoRiped() {
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(box[i][j] == 0) flag = false;
            }
        }
        return flag;
    }

    //시작점이 여러 개일 수 있는 bfs탐색
    //상하좌우로 탐색하되 -1이면 탐색 못함
    //visited배열을 bfs level을 담는데 씀
    public static int bfs(List<Location> startLocation) {
        int answer = 0;
        List<Location> operator = new ArrayList<>();
        operator.add(new Location(0, 1));
        operator.add(new Location(0, -1));
        operator.add(new Location(1, 0));
        operator.add(new Location(-1, 0));

        Queue<Location> q = new LinkedList<>();
        for (Location location : startLocation) {
            q.add(location);
            visited[location.row][location.column] = 1;
        }

        while(!q.isEmpty()){
            //큐에서 하나 뺌
            Location curLocation = q.poll();
            //마지막 요소인지 체크하여 그 값 return


            for (int i = 0; i < 4; i++) {
                int nextRow = curLocation.row + operator.get(i).row;
                int nextColumn = curLocation.column + operator.get(i).column;
                //상하좌우 살펴보고, 범위 내인지, 지나왔던 토마토인지,막힌 벽이 아닌지 체크
                if((nextColumn>=0&&nextRow>=0&&nextColumn<M&&nextRow<N)
                    && visited[nextRow][nextColumn] == 0
                    && box[nextRow][nextColumn] != -1){
                    //큐에 넣어주고, visited에 level 표시, 박스에 익은 토마토 표시
                    visited[nextRow][nextColumn] = visited[curLocation.row][curLocation.column] + 1;
                    box[nextRow][nextColumn] = 1;
                    q.add(new Location(nextRow, nextColumn));
                }
            }
            if(q.isEmpty()){
                answer = visited[curLocation.row][curLocation.column];
            }
        }
        return answer-1;
    }

    static class Location{
        int row;
        int column;

        public Location(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public Location() {
        }
    }
}
