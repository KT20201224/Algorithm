package org.kyoungtae;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724 {

    static int N, M;
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            map[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            map[s].add(e);
            map[e].add(s);
        }

        int count = 0;

        for(int i = 1; i < N; i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    public static void DFS(int v){
        if(visited[v]) return;
        for(int i : map[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}
