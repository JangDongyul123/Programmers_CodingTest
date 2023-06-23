import java.io.*;
import java.util.*;

class Solution12345 {

    static class Progress{
        int order;//순서
        int progress;//일의 진행상황
        int speed;//속도
        Progress(int order, int progress, int speed){
            this.order = order;
            this.progress = progress;
            this.speed = speed;
        }
        public int getOrder(){
            return order;
        }
        public int getProgress(){
            return progress;
        }
        public int getSpeed(){
            return speed;
        }
    }

    static LinkedList<Progress> list = new LinkedList<>();

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<progresses.length; i++){
            list.offer(new Progress(i, progresses[i], speeds[i]));
        }
        int day=0;
        int cnt=0;
        while(!list.isEmpty()){
            day++;
            cnt=0;
            for(int i=0; i<list.size(); i++){
                list.get(i).progress+=list.get(i).speed;
            }

            while(list.size()>0 && list.get(0).progress>=100){//앞순서 일이 완료되면
                list.pollFirst();
                cnt++;
            }
            if(cnt>0){
                answer.add(cnt);
            }

        }
        int[] answer1 = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            answer1[i] = answer.get(i);
        }

        return answer1;
    }
}

public class 기능개발 {
    public static void main(String[] args) {
        new Solution12345().solution(new int[]{93,30,55},new int[]{1,30,5});
    }
}
