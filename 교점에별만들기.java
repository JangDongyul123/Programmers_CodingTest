import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution1 {
    class Point{
        long x, y;
        Point(long x, long y){
            this.x = x;
            this.y=y;
        }
    }

    Point intersection(long A, long B, long E, long C, long D, long F){
        double x = (double)(B*F-E*D)/(double)(A*D-B*C);
        double y = (double)(E*C-A*F)/(double)(A*D-B*C);
        if((x%1!=0) || (y%1!=0)){
            return null;
        }
        return new Point((long)x,(long)y);
    }

    Point getMinimumPoint(List<Point> points){
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for(Point point : points){
            if(point.x<x){
                x= point.x;
            }
            if(point.y<y){
                y= point.y;
            }
        }
        return  new Point(x,y);
    }

    Point getMaximumPoint(List<Point> points){
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for(Point point : points){
            if(point.x>x){
                x= point.x;
            }
            if(point.y>y){
                y= point.y;
            }
        }
        return  new Point(x,y);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        for(int i=0; i<line.length; i++){
            for(int j=i+1; j<line.length; j++){
                Point point = intersection(line[i][0],line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if(point == null){
                    continue;
                }
                points.add(point);
            }
        }
        Point minimumPoint = getMinimumPoint(points);
        Point maximumPoint = getMaximumPoint(points);

        int height = (int)(maximumPoint.y - minimumPoint.y)+1;
        int weight = (int)(maximumPoint.x - minimumPoint.x)+1;
        char[][] map = new char[height][weight];
        for(char[] lineOfMap : map){
            Arrays.fill(lineOfMap, '.');
        }

        for(Point point : points){
            int mapOfX = (int)(point.x-minimumPoint.x);
            int mapOfY = (int)(maximumPoint.y - point.y);
            map[mapOfY][mapOfX] = '*';
        }

        String[] answer = new String[map.length];

        for(int i=0; i< map.length; i++){
            String mapLine = new String(map[i]);
            answer[i] = mapLine;
        }

        return answer;
    }
}

public class 교점에별만들기 {
    public static void main(String[] args) {
        String[] k = new Solution1().solution(new int[][]{{0,1,-1},{1,0,-1},{1,0,1}});
        for(int i=0; i< k.length; i++) {
            System.out.println(k[i]);
        }
    }
}