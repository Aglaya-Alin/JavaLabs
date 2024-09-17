import java.util.StringTokenizer;

public class App {
    public static void main(String[] args) {
        try {
            // Проверяем, есть ли аргументы командной строки
            if (args.length == 0) {
                throw new InvalidInputException("Необходимо передать строку как аргумент командной строки.");
            }
           
            System.out.println("Исходная строка: " + args[0]);

            // Обрабатываем строку
            String result = processString1(args[0]);
            System.out.println("Обработанная строка: " + result);

        } catch (InvalidInputException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }
    public static String processString1(String input) {
        
        
        StringBuilder res = new StringBuilder();
        StringTokenizer t = new StringTokenizer(input, ".", true); // true для сохранения пробелов
        System.out.println( t.countTokens() + "count");
        while (t.hasMoreTokens()) {
            String token = t.nextToken();
            if(token.equals(".")){
                res.append(token);
            } else{
                int num = 0;
                for (int i = 0; i< token.length(); i++) {
                    if(!Character.isDigit(token.charAt(i))){
                        res.append(token.charAt(i));
                    } else{
                        if(num <2){
                            res.append(token.charAt(i));
                            num++;
                        }else{
                            break;
                    }
                    }
                }
            }
        }

        return res.toString();
    }

   
}
