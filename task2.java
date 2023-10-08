
import java.util.Arrays;
import java.util.Random;

public class task2{
    public static void main(String[] args) {
        System.out.println("\nЗадание 1");
        System.out.println("Donald => " + one("Donald") );
        System.out.println("orange => " + one("orange") );

        System.out.println("\nЗадание 2");
        System.out.println("Ryan Gosling => " + two("Ryan Gosling") );
        System.out.println("Barack Obama => " + two("Barack Obama") );

        System.out.println("\nЗадание 3");
        System.out.println("Первый массив (44, 32, 86, 19) => " + three("44, 32, 86, 19") );
        System.out.println("Второй массив (22, 50, 16, 63, 31, 55) => " + three("22, 50, 16, 63, 31, 55") );

        System.out.println("\nЗадание 4");
        System.out.println("Первый массив (1, 2, 3, 4, 5) => " + four("1, 2, 3, 4, 5") );
        System.out.println("Второй массив (1, 2, 3, 4, 5, 6) => " + four("1, 2, 3, 4, 5, 6") );

        System.out.println("\nЗадание 5");
        System.out.println("Первый массив (1, 2, 3) => " + Arrays.toString(five(new int[] {1, 2, 3})));
        System.out.println("Второй массив (3, 3, -2, 408, 3, 31) => " + Arrays.toString(five(new int[] {3, 3, -2, 408, 3, 31})));

        System.out.println("\nЗадание 6");
        System.out.println("Hello world => " + six("Hello world") );
        System.out.println("The quick brown fox. => " + six("The quick brown fox.") );

        System.out.println("\nЗадание 7");
        System.out.println("(7) => " + seven(7) );
        System.out.println("(11) => " + seven(11) );

        System.out.println("\nЗадание 8");
        System.out.println("(5) => " + eight(5) );
        System.out.println("(10) => " + eight(10) );
        System.out.println("(0) => " + eight(0) );

        System.out.println("\nЗадание 9");
        System.out.println("Hello, I'm under the water, please help me => " + nine("Hello, I'm under the water, he helps me"));
        System.out.println("Two pepperoni pizzas please => " + nine("Two pepperoni pizzas please") );

        System.out.println("\nЗадание 10");
        System.out.println("listen, silent => " + ten("listen", "silent"));
        System.out.println("eleven plus two, twelve plus one => " + ten("eleven plus two", "twelve plus one") );
        System.out.println("hello, world => " + ten("hello", "world") );
    }
    public static Boolean one(String text){
// Повторяющиеся символы
        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++){
            for (int j = 0; j < i; j++){
                if (text.charAt(i) == text.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }
    public static String two(String text){
// Инициалы (Фамилия, Имя)
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == ' '){
                String a = String.valueOf(text.charAt(0)) + String.valueOf(text.charAt(i+1));
                return a;
            }
        }
        return "error";
    }
    public static int three(String numb){
// Разнисть суммы четных и нечетных
        int b = 0;
        int d = 0;
        String[] arr = numb.split(", ");
        for (int i = 0; i < arr.length; i++){
            int a = Integer.valueOf(arr[i]);
            if (a%2 == 0){
                b += a;
            } else {
                d += a;
            }
        }
        return b - d;
    }
    public static Boolean four(String numb){
// Есть ли в массиве ср.арифм
        float b = 0;
        String[] arr = numb.split(", ");
        for (int i = 0; i < arr.length; i++){
            Float a = Float.valueOf(arr[i]);
            b += a;
        }
        b = b/arr.length;
        for (int j = 0; j < arr.length; j++){
            if (j == b){
                return true;
            }
        }
        return false;
    }
    public static int[] five(int[] arr){
// Каждое число умножено на свой индекс в массиве
//1 массив данных
        for (int i = 0; i < arr.length; i++){
            int a = Integer.valueOf(arr[i]);
            arr[i] = a * i;
        }
        return arr;
    }
    public static String six(String text){
// Обратный порядок строки
        String b = "";
        for (int i = text.length() - 1; i >= 0; i--){
            String a = String.valueOf(text.charAt(i));
            b = b + a;
        }
        return b;
    }
    public static int seven(int n){
// Число Трибоначчи
        if (n == 0 || n == 1 || n == 2) {
            return 0;
        } else if (n == 3) {
            return 1;
        } else {
            return seven(n - 1) + seven(n - 2) + seven(n - 3);
        }
    }
    public static String eight(int n){
// Генерация квази-хэша
        Random rand = new Random();
        String dictionary = "0123456789abcdef";
        String b = "";
        for (int i = 0; i < n; i++){
            int a = rand.nextInt(15);
            char randomChar = dictionary.charAt(a);
            b = b + randomChar;
        }
        return b;
    }
    public static String nine(String input) {
        String str = input.replaceAll("\\pP", "");
        String[] words = str.toLowerCase().split(" ");
        System.out.println(Arrays.toString(words));
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("help"))
                return "calling for a staff member";
        }
        return "keep waiting";
    }
    public static boolean ten(String str1, String str2){
// проверка на анаграмму через массив символов
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();
        if (str1.length() == str2.length()){
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            return Arrays.equals(arr1, arr2);
        }
    return false;
    }
}
