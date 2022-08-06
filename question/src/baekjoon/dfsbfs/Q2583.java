package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2583 {
    static int M, N, K;
    static boolean[][] square;
    static int[] rowOp = new int[]{-1, 1, 0, 0};
    static int[] columnOp = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        //k개의 직사각형 내부를 제외한 나머지 부분이 몇개로 분리되는지, 분리된 영영의 넓이 구하기

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        str = br.readLine();
        String[] strArr = str.split(" ");
        M = Integer.parseInt(strArr[0]);
        N = Integer.parseInt(strArr[1]);
        K = Integer.parseInt(strArr[2]);

        square = new boolean[M][N];

        //사각형 칠하기, boolean[][] 2차배열 1개로 문제 풀 수 있을 듯
        int leftRow, leftColumn, rightRow, rightColumn;
        for (int i = 0; i < K; i++) {
            str = br.readLine();
            strArr = str.split(" ");
            leftColumn = Integer.parseInt(strArr[0]);
            leftRow = Integer.parseInt(strArr[1]);
            rightColumn = Integer.parseInt(strArr[2]);
            rightRow = Integer.parseInt(strArr[3]);

            for (int m = leftRow; m < rightRow; m++) {
                for (int n = leftColumn; n < rightColumn; n++) {
                    square[m][n] = true;
                }
            }
        }

        //이동할 수 있는 공간 확인(이미 방문한 곳이 아니면 즉 false이면)하여 dfs cnt
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(square[i][j] == false){
                    //dfs리턴으로 받은 사각형 넓이 list에 저장
                    cnt++;
                    list.add(dfs(new Location(i, j)));
                }
            }
        }

        //정렬
        Collections.sort(list);
        System.out.println(cnt);
        for (Integer num : list) {
            System.out.print(num+" ");
        }
    }

    public static int dfs(Location v){
        //방문한 정점 방문 표시
        square[v.row][v.column] = true;

        //4방향 돌며 방문
        int nextRow;
        int nextColumn;
        int result = 0;
        for (int i = 0; i < 4; i++) {
            nextRow = v.row + rowOp[i];
            nextColumn = v.column + columnOp[i];
            //범위 안에 있고, 방문하지 않은 정점만 방문
            if ((nextRow>=0 && nextColumn >=0 && nextRow < M && nextColumn < N)
                && !square[nextRow][nextColumn]){
                result += dfs(new Location(nextRow, nextColumn));
            }
        }

        return result + 1;
    }

    static class Location{
        int row;
        int column;

        public Location(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
