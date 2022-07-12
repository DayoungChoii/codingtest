package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260 {

    static int N;
    static int M;
    static int V;

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String graghInfo  = br.readLine();
        String[] graghInfoArr = graghInfo.split(" ");

        N = Integer.parseInt(graghInfoArr[0]);
        M = Integer.parseInt(graghInfoArr[1]);
        V = Integer.parseInt(graghInfoArr[2]);

        visited = new boolean[N+1];
        graph = new ArrayList[N+1];
        Arrays.fill(visited, false);

        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            graph[i] = list;
        }
        for (int i = 0; i < M; i++) {
            String edgeInfo = br.readLine();
            String[] edgeInfoArr = edgeInfo.split(" ");
            int firstNode = Integer.parseInt(edgeInfoArr[0]);
            int secondNode = Integer.parseInt(edgeInfoArr[1]);
            graph[firstNode].add(secondNode);
            graph[secondNode].add(firstNode);
        }

        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> nodeGroup = graph[i];
            Collections.sort(nodeGroup);
        }

        dfs(V);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(V);

    }

    public static void dfs(int v){
        visited[v] = true;
        System.out.print(v+" ");

        for(int node : graph[v]){
            if(!visited[node]){
                dfs(node);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();

        visited[v] = true;
        System.out.print(v + " ");
        q.add(v);

        while(!q.isEmpty()){
            int curNode = q.poll();

            for (int node : graph[curNode]) {
                if(!visited[node]){
                    visited[node] = true;
                    System.out.print(node + " ");
                    q.add(node);
                }
            }
        }
    }
}
