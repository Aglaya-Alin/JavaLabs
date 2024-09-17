


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
        
        //boolean operation = false;
        StringBuilder string = new StringBuilder(s);
        int position = 0;
        int countBrackets = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(' ) {
                position = i;
                countBrackets++;
            }
            if (string.charAt(i) == ')' && countBrackets==1) {
                    string.delete(position, i+1);
                    countBrackets--;
                }
            
        }
        
        return string.toString();
    }
    static class MyExept extends Exception{
        MyExept(String s){
            super(s);
        }
    }
}
