import java.util.*;
public class Calculator {
    public static void main(String[] args) {
        String s = "5+8-2";
        System.out.println(calculate(s));
    }
    //function to calculate expression.
    public static int calculate(String s) {
        if(s==null || s.length()==0)
            return 0;
        Stack<Integer> st = new Stack<Integer>();
        int cur = 0;
        char opr = '+';
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            //check if valid expression.
            if(ch[i] >= 48 && ch[i] <= 57 || ch[i] == '+' || ch[i] == '-' || ch[i] == '*' || ch[i] =='/'){
                if(Character.isDigit(ch[i])){
                    cur = cur*10+ch[i]-'0';
                }
                if((!Character.isDigit(ch[i]) && ' ' != ch[i]) || i==ch.length-1){
                    if(opr=='-'){
                        st.push(-cur);
                    }
                    if(opr=='+'){
                        st.push(cur);
                    }
                    if(opr=='*'){
                        st.push(st.pop()*cur);
                    }
                    if(opr=='/'){
                        st.push(st.pop()/cur);
                    }
                    opr = s.charAt(i);
                    cur = 0;
                }
            }
            else{
                throw new RuntimeException("Not a Valid Expression!");
            }

        }

        int ans = 0;
        while(!st.isEmpty()){
            ans += st.pop();
        }

        return Math.abs(ans);
    }
}
