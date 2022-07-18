package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q2606 {

    static int theNumberOfComputer;
    static int edgeNum;
    static boolean[] visited;
    static ArrayList<Integer>[] networkMap;
    static int infectedComputer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        theNumberOfComputer = Integer.parseInt(br.readLine());
        edgeNum = Integer.parseInt(br.readLine());

        networkMap = new ArrayList[theNumberOfComputer + 1];
        visited = new boolean[theNumberOfComputer + 1];

        Arrays.fill(visited, false);

        for (int i = 1; i <= theNumberOfComputer; i++) {
            networkMap[i] = new ArrayList<>();
        }

        int first;
        int second;
        for (int i = 0; i < edgeNum; i++) {
            String edgeInfo = br.readLine();
            String[] edgeInfoArr = edgeInfo.split(" ");

            first = Integer.parseInt(edgeInfoArr[0]);
            second = Integer.parseInt(edgeInfoArr[1]);

            networkMap[first].add(second);
            networkMap[second].add(first);
        }

        dfs(1);
        System.out.println(infectedComputer);
    }

    static void dfs(int v){
        visited[v] = true;
        infectedComputer++;

        for (int computer : networkMap[v]) {
            if (visited[computer] == false) {
                dfs(computer);
            }
        }

    }

}
