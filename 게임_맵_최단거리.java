import java.util.*;

class Solution2 {
    int [][] maps;
    int [][] dist;
    boolean [][] visit;
    int []dx={1,0,-1,0};
    int []dy={0,1,0,-1};
    int answer;

    public void bfs(int y, int x){
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int peekY = q.peek()[0];
            int peekX = q.peek()[1];
            q.poll();
            for(int i=0; i<4; i++){
                int ny = peekY+dy[i];
                int nx = peekX+dx[i];

                if(0<=ny && ny<maps.length && 0<=nx && nx<maps[0].length){
                    if(!visit[ny][nx] && (maps[ny][nx]==1)){
                        dist[ny][nx] = dist[peekY][peekX]+1;
                        visit[ny][nx] = true;
                        q.offer(new int[]{ny,nx});
                    }
                }
            }
        }
    }

    public int solution(int[][] maps) {
        int answer = 0;
        this.maps = maps;
        this.visit = new boolean[maps.length][maps[0].length];
        this.dist = new int[maps.length][maps[0].length];
        this.visit[0][0]=true;
        this.dist[0][0]=1;
        bfs(0,0);
        //for(int y=0;y<maps.length; y++){
        //  for(int x=0; x<maps[0].length; x++){
        //    System.out.print(dist[y][x]+" ");
        //}
        //System.out.println();
        // }
        answer = this.dist[maps.length-1][maps[0].length-1];
        if(answer == 0){
            answer = -1;
        }
        return answer;
    }
}

public class 게임_맵_최단거리 {
    public static void main(String[] args) {
        new Solution1().solution(new int[][] {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}});
    }
}
