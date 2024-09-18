import java.util.StringTokenizer;

public class App {
    public static void main(String args[]){
        try{
            if(args.length < 1){
                throw new MyExept("Nothing was entered");
            }
            String res = task(args[0]);
            System.out.println("Res = " + res);
        } catch(MyExept e) {
            System.out.println(e.getMessage());
        }
    }
    public static String task(String s){
        
        StringBuilder string = new StringBuilder();
        
        int resS = 0;
        int resE =0;
       
        StringTokenizer st = new StringTokenizer(s, "()", true);
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(token.equals("(")){
                resS++;
            } else if(token.equals(")")){
                resE++;
            } else if(resS == 1 && resE == 0 ){
                
            } else{
                string.append(token);
            }
        }
        if(resS != 1 || resE !=1 ){
            return s;
        }
        return string.toString();
    }
    static class MyExept extends Exception{
        MyExept(String s){
            super(s);
        }
    }
}
