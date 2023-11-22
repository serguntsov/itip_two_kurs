import java.util.*;

public class task4 {
    public static void main(String[] args){
//Напишите рекурсивную функцию, которая принимает строку и удаляет из неё повторяющиеся символы
        System.out.println("\nЗадание 1:");
        System.out.println("abracadabra => " + one("abracadabra"));
        System.out.println("paparazzi => " + one("paparazzi"));
//Напишите функцию, которая генерирует все возможные правильные комбинации пар скобок для заданного числа n
        System.out.println("\nЗадание 2:");
        System.out.println("1 => " + two(1));
        System.out.println("2 => " + two(2));
        System.out.println("3 => " + two(3));
//Напишите функцию, которая генерирует все возможные бинарные комбинации длины n, в которых не может быть соседствующих нулей
        System.out.println("\nЗадание 3:");
        System.out.println("3 => " + Arrays.toString(three(3)));
        System.out.println("4 => " + Arrays.toString(three(4)));
//Реализуйте функцию, которая принимает строку и возвращает длину самого длинного последовательного ряда в этом массиве
        System.out.println("\nЗадание 4:");
        System.out.println("abcdjuwx => " + four("abcdjuwx")); //ababab не вводите, пожалуйста! и bcbcbc тоже!
        System.out.println("klmabzyxw => " + four("klmabzyxw"));
//Напишите функцию, которая принимает строку и подсчитывает количество идущих подряд символов, заменяя соответствующим числом повторяющиеся символы
        System.out.println("\nЗадание 5:"); 
        System.out.println("aaabbcdd => " + five("aaabbcdd"));
        System.out.println("vvvvaajaaaaa => "+ five("vvvvaajaaaaa"));
//Напишите функцию, принимающую положительное целое число в строковом формате, не превышающее 1000, и возвращающую его целочисленное представление
        System.out.println("\nЗадание 6:");
        System.out.println("eight => " + six("eight"));
        System.out.println("five hundred sixty seven => " + six("five hundred sixty seven"));
        System.out.println("thirty one => " + six("thirty one"));
//Напишите функцию, принимающую строку цифр, выполняющую поиск подстроки максимальной длины с уникальными элементами
        System.out.println("\nЗадание 7:");
        System.out.println("123412324 => " + seven("123412324"));
        System.out.println("111111 => " + seven("111111"));
        System.out.println("77897898 => " + seven("77897898"));
//Напишите функцию поисковик наименьшего матричного пути
        System.out.println("\nЗадание 8:");
        System.out.println("{1, 3, 1}" + "\n{1, 5, 1} => "  + eight(new int[][]{
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}}) + "\n{4, 2, 1}");
        System.out.println("\n{2, 7, 3}" + "\n{1, 4, 8} => "  + eight(new int[][]{
            {2, 7, 3}, 
            {1, 4, 8}, 
            {4, 5, 9}}) + "\n{4, 5, 9}");
//Создайте функцию, принимающую строку, содержащую числа внутри слов. Эти числа представляют расположение слова для новой строящейся строки
            System.out.println("\nЗадание 9:");
            System.out.println("t3o the5m 1One all6 r4ule ri2ng => " + nine("t3o the5m 1One all6 r4ule ri2ng"));
            System.out.println("re6sponsibility Wit1h gr5eat power3 4comes g2reat => " + nine("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
//Напишите функцию, принимающую два числа, которая делает второе число максимально возможным за счет замены своих элементов элементами первого числа
            System.out.println("\nЗадание 10:");
            System.out.println("519, 723 => " + switchNums(519, 723));
            System.out.println("491, 3912 => " + switchNums(491, 3912));
            System.out.println("6274, 71259 => " + switchNums(6274, 71259));
    }
//Задание 1
    public static String one(String text){
       if (text == null || text.length() == 1) {
        return text;
        }
        String restOfString = one(text.substring(1));
        restOfString = restOfString.replaceAll(String.valueOf(text.charAt(0)), "");
        return text.charAt(0) + restOfString;
    }
//Задание 2
    public static List<String> two(int n) {
        List<String> combinations = new ArrayList<>();
        backtrack("", 0, 0, n, combinations);
        return combinations;
    }
    public static void backtrack(String com, int open, int close, int n, List<String> combinations) {
        if (com.length() == n * 2) {
            combinations.add(com);
            return;
        }
        if (open < n) {
            backtrack(com + "(", open + 1, close, n, combinations);
        }
        if (close < open) {
            backtrack(com + ")", open, close + 1, n, combinations);
        }
    }
//Задание 3
    public static String[] three(int n) {
        List<String> combinations = new ArrayList<>();
        backtrack("", n, combinations);
        return combinations.toArray(new String[0]);
    }
    public static void backtrack(String combination, int n, List<String> combinations) {
        if (combination.length() == n) {
            combinations.add(combination);
            return;
        }
        //Заканчивается ли на 0
        if (!combination.endsWith("0")) {
            backtrack(combination + "0", n, combinations);
        }
        backtrack(combination + "1", n, combinations);
    }
//Задание 4
public static String four(String str) {
    if (str == null || str.length() == 0) {
        return "";
    }
    String longestRow = "";
    String currentRow = "" + str.charAt(0);
    for (int i = 1; i < str.length(); i++) {
        char currentChar = str.charAt(i);
        char previousChar = str.charAt(i - 1);
        
        if (currentChar == previousChar + 1 || currentChar == previousChar - 1) {
            if (currentRow.indexOf(currentChar) == -1) {
            currentRow += currentChar;
            }
        } else {
            if (currentRow.length() > longestRow.length()) {
                longestRow = currentRow;
            }
            currentRow = "" + currentChar;
        }
        if (currentRow.length() > longestRow.length()) {
        longestRow = currentRow;
    }
    }     
    // Удаляем повторяющиеся символы из самого длинного ряда
    String uniqueLongestRow = "";
    for (int i = 0; i < longestRow.length(); i++) {
        char currentChar = longestRow.charAt(i);
        if (uniqueLongestRow.indexOf(currentChar) == -1) {
            uniqueLongestRow += currentChar;
        }
    }
    return uniqueLongestRow;
}
//Задание 5
public static String five(String string) {
    Map<Character, Integer> map = new HashMap<>();
    for (char ch : string.toCharArray()) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
    }
    StringBuilder res = new StringBuilder();
    List<Integer> values = new ArrayList<>(map.values());
    Collections.sort(values);
    while (!values.isEmpty() && !map.isEmpty()) {
        for (Character key : map.keySet()) {
            if (map.get(key).equals(values.get(0))) {
                res.append(key);
                res.append(values.get(0));
                map.remove(key);
                values.remove(0);
                break;
            }
        }
    }
    return res.toString();
}
//Задание 6
    public static int six(String str) {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);
        map.put("hundred", 100);
        String[] words = str.split(" ");
            int current = 0;
            for (String word : words) {
                int value = map.get(word);
                if (value == 100 && current != 0) {
                    current = current * value;
                } else {
                    current += value;
                }
            }
        return current;
    }
//Задание 7
    public static String seven(String s) {
        int start = 0;
        int maxLength = 0;
        int currentStart = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charIndexMap.containsKey(c) && charIndexMap.get(c) >= currentStart) {
                currentStart = charIndexMap.get(c) + 1;
            }
            charIndexMap.put(c, i);
            if (i - currentStart + 1 > maxLength) {
                maxLength = i - currentStart + 1;
                start = currentStart;
            }
        }
        return s.substring(start, start + maxLength);
    }
//Задание 8
    public static int eight(int[][] matrix) {
        int n = matrix.length;
        int[][] cursor = new int[n][n];
        // Инициализация первой строки и первого столбца
        cursor[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            cursor[i][0] = cursor[i - 1][0] + matrix[i][0];
            cursor[0][i] = cursor[0][i - 1] + matrix[0][i];
        }
        // Нахождение наименьшего пути для остальных ячеек
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                cursor[i][j] = matrix[i][j] + Math.min(cursor[i - 1][j], cursor[i][j - 1]);
            }
        }
        return cursor[n - 1][n - 1];
    }
//Задание 9
public static String nine(String s) {
    String[] words = s.split(" ");
    StringBuilder fin = new StringBuilder();
    for (int i = 1; i <= words.length; i++) {
        for (String subStr : words) {
            if (subStr.contains(Integer.toString(i))) {
                subStr = subStr.replace(Integer.toString(i), "");
                fin.append(subStr);
            }
        }
        fin.append(" ");
    }
    return fin.toString();
}
//Задание 10
public static int switchNums(int a, int b) {
    List<Integer> numsA = new ArrayList<>();
    List<Integer> numsB = new ArrayList<>();
    while (a > 0) {
        numsA.add(a % 10);
        a = a / 10;
    }
    while (b > 0) {
        numsB.add(b % 10);
        b = b / 10;
    }
    int fin = 0;
    for (int i = numsB.size() - 1; i >= 0; i--) {
        int B = numsB.get(i);
        int ind = 0;
        if (!numsA.isEmpty()) {
            for (int j = 0; j < numsA.size(); j++) {
                if (numsA.get(j) > B) {
                    B = numsA.get(j);
                    ind = j;
                }
            }
            numsA.remove(ind);
        }
        fin = fin * 10 + B;
        }
        return fin;
    }
}