
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;


public class task5 {
    public static void main(String[] args) {
//Создайте функцию, которая возвращает true, если две строки имеют один и тот же буквенный шаблон, и false в противном случае.
        System.out.println("\nЗадание 1:");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
//Паутина определяется кольцами, пронумерованными от 0 до 4 от центра, и радиалами, помеченными по часовой стрелке сверху как A-H. 
        System.out.println("\nЗадание 2:");
        System.out.println(spiderVsFly("H3", "B3"));
        System.out.println(spiderVsFly("A4", "H2"));
        System.out.println(spiderVsFly("A2", "H4"));
//Создайте функцию, которая будет рекурсивно подсчитывать количество цифр числа
        System.out.println("\nЗадание 3:");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
//Создайте функцию, которая принимает в массив уже угаданных слов расшифрованное 6-буквенное слово и возвращает общее количество очков, набранных игроком в определенном раунде
        System.out.println("\nЗадание 4:");
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"},"tossed"));
//Создайте функцию, которая получает каждую пару чисел из массива, который суммирует до восьми, и возвращает его как массив пар 
        System.out.println("\nЗадание 5:");
        System.out.println(sumsUp(new int[]{1, 2, 3, 4, 5}));
        System.out.println(sumsUp(new int[]{1, 2, 3, 7, 9}));
        System.out.println(sumsUp(new int[]{10, 9, 7, 2, 8}));
        System.out.println(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7}));
//Какой процент вы можете набрать на тесте, который в одиночку снижает средний балл по классу на 5%?
        System.out.println("\nЗадание 6:");
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10%"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));
//Создайте функцию, которая будет шифровать и дешифровать сообщения с использованием шифра Цезаря
        System.out.println("\nЗадание 7:");
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "almost last task!", 4));
//Создайте метод для рекурсивного вычисления количества различных способов как можно разместить k элементов из множества из n элементов без повторений
        System.out.println("\nЗадание 8:");
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));
//Вы должны вернуть новую метку времени с датой и соответствующим временем в cityB
        System.out.println("\nЗадание 9:");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
//Напишите функцию, которая принимает неотрицательное целое число и возвращает true, если целое число является новым числом, и false, если это не так
        System.out.println("\nЗадание 10:");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(1203));
    }
//Задание 1
    public static boolean sameLetterPattern(String x,String y){
        if(x.length() != y.length()) {
            return false;
        }
        HashMap<Character, Integer> xmap = new HashMap<>();
        HashMap<Character, Integer> ymap = new HashMap<>();

        for(int i = 0; i < x.length(); i++) {
            if (xmap.get(x.charAt(i)) != ymap.get(y.charAt(i))) return false;
            xmap.put(x.charAt(i), i);
            ymap.put(y.charAt(i), i);
        }
        return true;
    }
//Задание 2
    public static String spiderVsFly(String spiderCord, String flyCord) {
        int spiderSymbol = spiderCord.charAt(0) - 65;
        int spiderNumber = Integer.parseInt(spiderCord.substring(1, 2));
        int flySymbol = flyCord.charAt(0) - 65;
        int flyNumber = Integer.parseInt(flyCord.substring(1, 2));
        if (flyNumber == 0) flySymbol = 0;


        double straightWay = 1;
        double[] ways = new double[5];
        for (int i = 0; i < 5; i++) ways[i] = i * Math.sqrt(2 - Math.sqrt(2));

        StringBuilder strWay1 = new StringBuilder(spiderCord);
        double intWay1 = 0;
        int nowSpiderSymbol1 = spiderSymbol;
        int nowSpiderNumber1 = spiderNumber;
        while (nowSpiderSymbol1 != flySymbol || nowSpiderNumber1 != flyNumber) {
            if (nowSpiderNumber1 == 0) {
                nowSpiderSymbol1 = flySymbol;
                nowSpiderNumber1 = 1;
            } else if (nowSpiderSymbol1 == spiderSymbol) {
                nowSpiderNumber1 -= 1;
                if (nowSpiderNumber1 == 0) nowSpiderSymbol1 = 0;
            } else {
                nowSpiderNumber1 += 1;
            }
            strWay1.append("-").append((char) (nowSpiderSymbol1 + 65)).append(nowSpiderNumber1);
            intWay1 += straightWay;
        }

        StringBuilder strWay2 = new StringBuilder(spiderCord);
        double intWay2 = 0;
        int nowSpiderSymbol2 = spiderSymbol;
        int nowSpiderNumber2 = spiderNumber;
        if (nowSpiderNumber2 > flyNumber) {
            while (nowSpiderNumber2 != flyNumber) {
                nowSpiderNumber2 -= 1;
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += straightWay;
            }
            while (nowSpiderSymbol2 != flySymbol) {
                int clock = flySymbol - nowSpiderSymbol2;
                if (clock < 0) clock += 8;
                if (clock <= 4) {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 1) % 8;

                }
                else {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 7) % 8;
                }
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += ways[nowSpiderNumber2];
            }
        }
        else {
            while (nowSpiderSymbol2 != flySymbol) {
                int clock = flySymbol - nowSpiderSymbol2;
                if (clock < 0) clock += 8;
                if (clock <= 4) {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 1) % 8;

                }
                else {
                    nowSpiderSymbol2 = (nowSpiderSymbol2 + 7) % 8;
                }
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += ways[nowSpiderNumber2];
            }
            while (nowSpiderNumber2 != flyNumber) {
                nowSpiderNumber2 += 1;
                strWay2.append("-").append((char) (nowSpiderSymbol2 + 65)).append(nowSpiderNumber2);
                intWay2 += straightWay;
            }
        }
        if (intWay1 <= intWay2) {
            return strWay1.toString();
        }
        return strWay2.toString();
    }
//Задание 3
    public static int digitsCount(long numb) {
        if (numb < 10) {
            return 1;
        }
        return digitsCount(numb / 10) + 1;
    }
//Задание 4
    public static int totalPoints(String[] words, String scrambledWord) {
        int answer = 0;
        LinkedList<String> uniqueWords = new LinkedList<>();
        uniqueWordList:
        for (String word: words) {
            for (String uniqueWord: uniqueWords) {
                if (uniqueWord.equals(word)) {
                    continue uniqueWordList;
                }
            }
            uniqueWords.add(word);
        }
        wordCheck:
        for (String word: uniqueWords) {
            if (word.length() > 2) {
                for (char symbol : word.toCharArray()) {
                    int symbolCount1 = word.length() - word.replace(String.valueOf(symbol), "").length();
                    int symbolCount2 = scrambledWord.length() - scrambledWord.replace(
                            String.valueOf(symbol), "").length();
                    if (symbolCount1 > symbolCount2) continue wordCheck;
                }
                answer += word.length() - 2;
                if (word.length() == 6) {
                    answer += 50;
                }
            }
        }
        return answer;
    }
//Задание 5
    public static String sumsUp(int[] nums) {
        LinkedList<String> answer = new LinkedList<>();
        LinkedList<Integer> numsBefore = new LinkedList<>();
        check:
        for (int num: nums) {
            for(int i = 0; i < numsBefore.size(); i++) {
                int numBefore = numsBefore.get(i);
                if (num + numBefore == 8) {
                    answer.add(Arrays.toString(new int[] {Math.min(num, numBefore), Math.max(num, numBefore)}));
                    numsBefore.remove(i);
                    continue check;
                }
            }
            numsBefore.add(num);
        }
        return Arrays.toString(answer.toArray());
    }
//Задание 6
    public static String takeDownAverage(String[] percentages) {
        int sumNum = 0;
        int n = percentages.length;
        for (String percentage : percentages) {
            int num = Integer.parseInt(percentage.replace("%", ""));
            sumNum += num;
        }
        double average = (double) sumNum / n;
        int myPercentage = (int) ((average - 5) * (n + 1) - sumNum);
        return myPercentage + "%";
    }
//Задание 7
static String caesarCipher(String operation, String message, int shift) {
    StringBuilder result = new StringBuilder();

    for (char ch : message.toCharArray()) {
        if (Character.isLetter(ch)) {
            char base = Character.isUpperCase(ch) ? 'A' : 'a';

            int newChar = (ch - base + (operation.equals("encode") ? shift : 26 - shift)) % 26;

            if (newChar < 0) {
                newChar += 26;
            }

            result.append((char) (newChar + base));
        } else {
            result.append(ch);
        }
    }

    return result.toString().toUpperCase(Locale.ROOT);
}
//Задание 8
    public static int setSetup(int n, int k) {
        if (k == 1) {
            return n;
        }
        return n * setSetup(n - 1, k - 1);
    }
//Задание 9
    static String timeDifference(String cityA, String timestampA, String cityB) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.US);

        LocalDateTime localDateTimeA = LocalDateTime.parse(timestampA, formatter);

        ZoneId zoneA = ZoneId.of(getTimeZone(cityA));
        ZoneId zoneB = ZoneId.of(getTimeZone(cityB));


        ZonedDateTime zonedDateTimeA = ZonedDateTime.of(localDateTimeA, zoneA);
        ZonedDateTime zonedDateTimeB = zonedDateTimeA.withZoneSameInstant(zoneB);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
        return zonedDateTimeB.format(outputFormatter);
    }
    static String getTimeZone(String city) {
        switch (city) {
            case "Los Angeles":
                return "America/Los_Angeles";
            case "New York":
                return "America/New_York";
            case "Caracas":
                return "America/Caracas";
            case "Buenos Aires":
                return "America/Argentina/Buenos_Aires";
            case "London":
                return "Europe/London";
            case "Rome":
                return "Europe/Rome";
            case "Moscow":
                return "Europe/Moscow";
            case "Tehran":
                return "Asia/Tehran";
            case "New Delhi":
                return "Asia/Kolkata";
            case "Beijing":
                return "Asia/Shanghai";
            case "Canberra":
                return "Australia/Sydney";
            default:
                throw new IllegalArgumentException("Unknown city: " + city);
        }
    }
//Задание 10
    public static boolean isNew(int numb) {
        String strNumb = Integer.toString(numb);
        int[] numbs = new int[strNumb.length()];
        String numbWithoutZeros = strNumb.replace("0", "");
        int[] numbsWithoutZeros = new int[numbWithoutZeros.length()];
        int j = 0;
        for (int i = 0; i < strNumb.length(); i++) {
            int nowNumb = Integer.parseInt(strNumb.substring(i, i + 1));
            if (nowNumb != 0) {
                numbsWithoutZeros[j] = nowNumb;
                j += 1;
            }
            numbs[i] = nowNumb;
        }
        Arrays.sort(numbs);
        Arrays.sort(numbsWithoutZeros);
        StringBuilder minNumb = new StringBuilder(Integer.toString(numbsWithoutZeros[0]));
        int index = numbs.length - numbsWithoutZeros.length;
        for (int i = 0; i < numbs.length; i++) {
            if (i != index) minNumb.append(numbs[i]);
        }
        return strNumb.contentEquals(minNumb);
    }
}