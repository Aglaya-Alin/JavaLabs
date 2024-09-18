import java.util.StringTokenizer;

public class Calc{
    public static void main(String args[]){
        try{
            if(args.length != 1){
                throw new MyExept("Not 1");
            }
            int res = calcStr(args[0]);
            System.out.println("Res = " + res);
        } catch(MyExept e) {
            System.out.println(e.getMessage());
        } catch(NumberFormatException e){
            System.out.println("not number: " + e.getMessage());
        }
    }
    public static int calcStr(String s) throws NumberFormatException {
        int res = 0;
        boolean operation = true;   //true + false -
        StringTokenizer st = new StringTokenizer(s, "+-", true);
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            int num = 0;
            if(token.equals("+")){
                operation = true;
            } else if(token.equals("-")){
                operation = false;
            } else{
                num = Integer.parseInt(token);
            }
            if(operation == true){
                res += num;
            } else{
                res -= num;
            }
        }
        return res;
    }
    static class MyExept extends Exception{
        MyExept(String s){
            super(s);
        }
    }
}