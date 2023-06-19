public class 문자열나누기 {
    static class Solution {
        public int solution(String s) {
            int answer=0;
            char x='0';
            int same=0;
            int different=0;

            for(int i=0; i<s.length(); i++){
                if(x=='0'){
                    answer++;
                    same++;
                    x=s.charAt(i);
                }else if(x==s.charAt(i)){
                    same++;
                }else {
                    different++;
                }
                if(same == different){
                    x='0';
                    same=0;
                    different=0;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("abracadabra"));
    }
}
