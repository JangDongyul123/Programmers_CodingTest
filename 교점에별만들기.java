import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution1 {

    //선분의 교점
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
        //여기서 double 형변환을 왜 하냐면
        //정수 타입인 int 또는 long은 나누기 0 하면 ArithmeticException: / by zero 예외 생김
        //실수 타입인 float 또는 double은 나누기 0 해도 예외 안생김
        //부동소수점이라 그렇다

        if((x%1!=0) || (y%1!=0)){
            //교차점 중 하나라도 정수가 아니면
            return null;
        }
        //정수면 %1 =0 이 나와야 한다. 음수도 그렇대
        return new Point((long)x,(long)y);
    }

    //최소의 x,y만 리턴
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

    //최대의 x,y를 리턴
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
        //교차점들의 집합
        for(int i=0; i<line.length; i++){//모든 선분에 대한 교차점 조사
            for(int j=i+1; j<line.length; j++){
                Point point = intersection(line[i][0],line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if(point == null){
                    //정수좌표 교차점이 없으면
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