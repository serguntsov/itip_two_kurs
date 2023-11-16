import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class task3 {
    public static void main(String[] args){
//Создайте функцию, которая принимает строку и заменяет все гласные буквы на символ «*».
        System.out.println("\nЗадание 1:");
        System.out.println("apple => " + one("apple"));
        System.out.println("Even if you did this task not by yourself, you have to understand every single line of code. => " 
        + one("Even if you did this task not by yourself, you have to understand every single line of code."));
//Напишите функцию, которая принимает строку и заменяет две идущие подряд буквы по шаблону «Double*».
        System.out.println("\nЗадание 2:");
        System.out.println("hello => " + two("hello"));
        System.out.println("bookkeeper => " + two("bookkeeper"));
//Напишите функцию, которая принимает измерения игрушечного блока и возвращает true, если этот блок может поместиться в отверстие.
        System.out.println("\nЗадание 3:");
        System.out.println("1, 3, 5, 4, 5 => " + three(1, 3, 5, 4, 5));
        System.out.println("1, 8, 1, 1, 1 => " + three(1, 8, 1, 1, 1));
        System.out.println("1, 2, 2, 1, 1 => " + three(1, 2, 2, 1, 1));
//Напишите функцию, которая принимает число в качестве входных данных и возвращает true, если сумма квадратов его цифр имеет ту же четность, что и само число.
        System.out.println("\nЗадание 4:");
        System.out.println("243 => " + four(243));
        System.out.println("52 => " + four(52));
//Создайте метод, который берет массив целых чисел-коэффициентов и возвращает количество целочисленных корней квадратного уравнения. 
        System.out.println("\nЗадание 5:");
        System.out.println("[1, -3, 2] => " + five(new int[] {1, -3, 2}));
        System.out.println("[2, 5, 2] => "+ five(new int[] {2, 5, 2}) );
        System.out.println("[1, -6, 9] => "+ five(new int[] {1, -6, 9}) );
//Создайте метод, который принимает двумерный массив, и возвращает товары, которые были проданы в каждом из магазинов.
        System.out.println("\nЗадание 6");
        System.out.println("Пример 1 => " 
        + six(new String[][]{{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                            {"Banana", "Shop2", "Shop3", "Shop4"}, 
                            {"Orange", "Shop1", "Shop3", "Shop4"}, 
                            {"Pear", "Shop2", "Shop4"}}));
        System.out.println("Пример 2 => " 
        + six(new String[][]{{"Fridge", "Shop2", "Shop3"},
                            {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"}, 
                            {"Laptop", "Shop3", "Shop4"}, 
                            {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}}));
//Создайте функцию, которая определяет, можно ли разбить заданное предложение на слова так, чтобы каждое слово начиналось с последней буквы предыдущего слова.
        System.out.println("\nЗадание 7");
        System.out.println("\"apple eagle egg goat\" => " + seven("apple eagle egg goat"));
        System.out.println("\"cat tog goose fish\" => " + seven("cat tog goose fish"));
//Напишите метод, который определяет, является ли заданный массив «волнообразным».
        System.out.println("\nЗадание 8");
        System.out.println("\"1, 2, 3, 4, 5\" => " + eight(new int[] {1, 2, 3, 4, 5}));
        System.out.println("\"1, 2, -6, 10, 3\" => " + eight(new int[] {1, 2, -6, 10, 3}));
//Напишите функцию, которая находит наиболее часто встречающуюся гласную в предложении.
        System.out.println("\nЗадание 9");
        System.out.println("\"Hello world\" => " + nine("Hello world"));
        System.out.println("\"Actions speak louder than words.\" => " + nine("Actions speak louder than words."));
//Создайте функцию, которая принимает n целочисленных массивов длины n, а затем изменяет каждый n-ый элемент n-го массива на среднее арифметическое элементов n-го столбца остальных массивов.
        System.out.println("\nЗадание 10");
        int[][] mas1 = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {5, 5, 5, 5, 5},
            {7, 4, 3, 14, 2},
            {1, 0, 11, 10, 1}
        };
        int[][] result1 = ten(mas1);
        System.out.println("Массив 1 => " + Arrays.deepToString(result1));
        int[][] mas2 = {
            {6, 4, 19, 0, 0},
            {81, 25, 3, 1, 17},
            {48, 12, 60, 32, 14},
            {91, 47, 16, 65, 217},
            {5, 73, 0, 4, 21}
        };
        int[][] result2 = ten(mas2);
        System.out.println("Массив 2 => " + Arrays.deepToString(result2));
    }
//Задание 1
    public static String one(String text){
        text = text.toLowerCase();
        return text.replaceAll("[aoeiuy]" , "*");
    }
//Задание 2
    public static String two(String text) {
        String b = ""; 
        for(int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) == text.charAt(i+1)){
                String ch = String.valueOf(text.charAt(i)).toUpperCase();
                b += "Double" + ch;
                i++;
            }
            else
                b += text.charAt(i);
            }
        return b + text.charAt(text.length() - 1);
//Задание 3
    }
    public static Boolean three(int a, int b, int c, int w, int h){
        return ((a <= w && b <= h) || (b <= w && c <= h) || (c <= w && a <= h));
    }
//Задание 4
    public static boolean four(int a){
    int b = 0;
    int c = a;
    while (a != 0) {
        int i = a % 10; 
        b += i*i; 
        a /= 10; 
    }
    return (c % 2 == b % 2);
    }
//Задание 5
    public static int five(int[] arr) {
        //double x1 = (-b + Math.sqrt(d))/(2*a);
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        int d = b*b - 4*a*c;
        if (d > 0) {
            double x1 = (-b + Math.sqrt(d))/(2*a);
            double x2 = (-b - Math.sqrt(d))/(2*a);
            //System.out.println("x1%: " + x1 % 1);
            //System.out.println("x2%:  " + x2 % 1);
            if (x1 % 1 == 0 && x2 % 1 == 0) {
                return 2;
            }
            if (x1 % 1 != 0 && x2 % 1 == 0 || x1 % 1 == 0 && x2 % 1 != 0) {
                return 1;
            }
        }
        else if (d == 0) {
            double x3 = (-b + Math.sqrt(d))/(2*a);
            //System.out.println("x3%: " + x3 % 1);
            if (x3 % 1 == 0)
                return 1;
        }
        return 0;
    }
//Задание 6
    public static String six(String[][] arr){
        Set<String> set = new HashSet<>();
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++){
            for (int j = 1; j < arr[i].length; j++){
                set.add(arr[i][j]);
            }
        }
        for (String x : set){
            System.out.println(x + " ");
        }
    return "fs";
    }
//Задание 7
    public static Boolean seven(String text){
        String str = text.replaceAll("\\pP", "");
        String[] arr = str.split(" ");
        for (int i = arr.length - 1; i >= 1;){
        char x1 = arr[i].charAt(0);
        char x2 = arr[i-1].charAt(arr[i-1].length() - 1);
        return (x1 == x2);
        }
    return false;
    }
//Задание 8
    public static Boolean eight(int[] arr){
        boolean ft = false;
        for (int i = 0; i < arr.length - 1; i++){
            int diff = arr[i + 1] - arr[i];
        if (diff > 0) {
            if (ft) {
                return false;
            }
            ft = true; //
        } else {
            if (!ft) {
                return false; //
            }
            ft = false;
            }
        }
    return true;
    }
//Задание 9
    public static char nine(String text){
        text = text.toLowerCase();
        String dict = "aoeiuy";
        int[] counts = new int[128];
        for (int i = 0; i < text.length(); i++){
        if (dict.indexOf(text.charAt(i)) != -1) {
            counts[text.charAt(i)]++;
            }
        }
        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < counts.length; i++) {
        if (counts[i] > maxCount) {
            maxCount = counts[i];
            maxIndex = i;
        }
    }
    return (char) maxIndex;
    }
//Задание 10
public static int[][] ten(int[][] matrix) {
    int len = matrix.length;
    for (int j = 0; j < len; j++) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (i != j) {
                sum += matrix[i][j];
            }
        }
        int average = Math.round((float) sum / (len-1));
        matrix[j][j] = average;
    }
    return matrix;
    }
}