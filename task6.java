import java.math.BigInteger;
import java.util.*;

class CustomMathException extends Exception {
	public CustomMathException(String text) {
		System.out.println(text);
	}
}

public class task6 {
	public static void main(String[] args) throws CustomMathException {
        System.out.println("Задание 1:");
		System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
		System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
		System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
		System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
		System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
		System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
		System.out.println("\n");
        System.out.println("Задание 2:");
		System.out.println(collect("intercontinentalisationalism", 6));
		System.out.println(collect("strengths", 3) );
		System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));
		System.out.println("\n");
        System.out.println("Задание 3:");
		System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
		System.out.println(nicoCipher("andiloveherso", "tesha"));
		System.out.println(nicoCipher("mubashirhassan", "crazy"));
		System.out.println(nicoCipher("edabitisamazing", "matt"));
		System.out.println(nicoCipher("iloveher", "612345"));
		System.out.println("\n");
        System.out.println("Задание 4:");
		System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45)));
		System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
		System.out.println(Arrays.toString(twoProduct(new int[]{1,  2, -1,  4,  5,  6,  10, 7}, 20)));
		System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5,  6, 7, 8, 9, 10}, 10)));
		System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15)));
		System.out.println("\n");
        System.out.println("Задание 5:");
		System.out.println(Arrays.toString(isExact(6)));
		System.out.println(Arrays.toString(isExact(24)));
		System.out.println(Arrays.toString(isExact(125)));
		System.out.println(Arrays.toString(isExact(720)));
		System.out.println(Arrays.toString(isExact(1024)));
		System.out.println(Arrays.toString(isExact(40320)));
		System.out.println("\n");
        System.out.println("Задание 6:");
		System.out.println(fractions("0.(6)"));
		System.out.println(fractions("1.(1)"));
		System.out.println(fractions("3.(142857)"));
		System.out.println(fractions("0.19(2367)"));
		System.out.println(fractions("0.1097(3)"));
		System.out.println("\n");
        System.out.println("Задание 7:");
		System.out.println(pilish_string("33314444"));
		System.out.println(pilish_string("TOP"));
		System.out.println(pilish_string("X"));
		System.out.println(pilish_string(""));
		System.out.println(pilish_string("CANIMAKEAGUESSNOW"));
		System.out.println(pilish_string("FORALOOP"));
		System.out.println(pilish_string("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMME" +
				"CHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
		System.out.println("\n");
        System.out.println("Задание 8:");
		System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
		System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));
		System.out.println("\n");
        System.out.println("Задание 9:");
		System.out.println(isValid("aabbcd"));
		System.out.println(isValid("aabbccddeefghi"));
		System.out.println(isValid("abcdefghhgfedecba"));
		System.out.println("\n");
        System.out.println("Задание 10:");
		System.out.println(findLCS("abcd", "bd"));
		System.out.println(findLCS("aggtab", "gxtxamb") );
	}

	public static String hiddenAnagram(String str1, String str2) {
		String newString = str1.replaceAll("[^A-Za-z]", "");
		str2 = str2.replace(" ", "");
		newString = newString.toLowerCase();
		str2 = str2.toLowerCase();
		for (int i = 0; i <= newString.length() - str2.length(); i++) {
			// Получаем подстроку длины str2
			String subStr = newString.substring(i, i + str2.length());
			// Преобразуем подстроки в массивы символов и сортируем их
			char[] array1 = subStr.toCharArray();
			char[] array2 = str2.toCharArray();
			Arrays.sort(array1);
			Arrays.sort(array2);
			if (Arrays.equals(array1, array2)) {
				return subStr;
			}
		}
		return "notfound";
	}


	public static ArrayList<String> collect(String str, int n) {
		if (str.length() < n) {
			return new ArrayList<String>();
		}
		ArrayList<String> list = new ArrayList<>();
		list.add(str.substring(0, n));
		// Рекурсивно вызываем collect для оставшейся части строки и добавляем все подстроки в список
		list.addAll(collect(str.substring(n), n));
		// Сортируем список
		Collections.sort(list);
		// Возвращаем отсортированный список подстрок
		return list;
	}


	public static String nicoCipher(String message, String key) {
		// Преобразуем ключ и создаем отсортированный массив ключа
		char[] keyArray = key.toCharArray();
		char[] sortedKeyArray = key.toCharArray();
		Arrays.sort(sortedKeyArray);
		// Инициализируем массив для хранения индексов символов ключа
		int[] numChar = new int[key.length()];
		int i = 0;
		// Находим индексы символов ключа в отсортированном порядке
		for (char symbol1 : sortedKeyArray) {
			for (int j = 0; j < key.length(); j++) {
				if (symbol1 == keyArray[j]) {
					numChar[i] = j;
					keyArray[j] = '_'; // Помечаем использованный символ в массиве ключа
					i++;
				}
			}
		}

		// Вычисляем количество столбцов и строк
		int columns = key.length();
		int rows = (message.length() + columns - 1) / columns;
		// Преобразуем сообщение в массив символов
		char[] messageArray = message.toCharArray();
		// Строим зашифрованное сообщение
		StringBuilder answer = new StringBuilder();
		for (i = 0; i < rows; i++) {
			for (int j : numChar) {
				int num = i * columns + j;
				if (num < message.length()) {
					answer.append(messageArray[num]);
				} else {
					answer.append(" "); // Добавляем пробел, если достигнут конец сообщения
				}
			}
		}
		// Возвращаем зашифрованное сообщение в виде строки
		return answer.toString();
	}


	public static int[] twoProduct(int[] nums, int n) {
		// Создаем ArrayList для хранения чисел, пройденных слева
		ArrayList<Integer> leftNums = new ArrayList<>();
		// Перебираем числа в массиве
		for (int i = 0; i < nums.length; i++) {
			// Перебираем числа, пройденные слева
			for (int j = 0; j < leftNums.size(); j++) {
				// Если произведение пары чисел равно n, возвращаем эту пару
				if (leftNums.get(j) * nums[i] == n) {
					return new int[]{leftNums.get(j), nums[i]};
				}
			}
			// Добавляем текущее число в массив пройденных слева
			leftNums.add(nums[i]);
		}
		// Если не найдено, возвращаем пустой массив
		return new int[0];
	}


	public static int[] isExact(int number) {
		int dynamicNumber = number;
		// Если число равно 1, возвращаем {1, 1}
		if (number == 1) {
			return new int[]{1, 1};
		}
		// Если число равно 2, возвращаем {2, 2}
		if (number == 2) {
			return new int[]{2, 2};
		}
		// Перебираем делители от 2 до числа
		for (int i = 2; i <= number; i++) {
			// Если число не делится на i, проверяем условия
			if (dynamicNumber % i != 0) {
				// Если i равно 2, возвращаем пустой массив
				if (i == 2) {
					return new int[0];
				} else {
					// Рекурсивно вызываем isExact для number / (i - 1)
					int[] temp = isExact(number / (i - 1));

					// Если результат пустой, возвращаем пустой массив
					if (temp.length == 0) {
						return new int[0];
					} else {
						// Если (i - 1) равно второму элементу из результата temp, возвращаем пустой массив
						if (i - 1 == temp[1]) {
							return new int[0];
						}
						// Иначе возвращаем {number, (i-1)}
						return new int[]{number, (i - 1)};
					}
				}
			}
			// Делим dynamicNumber на i
			dynamicNumber /= i;
		}
		// Если не найдено подходящей пары, возвращаем пустой массив
		return new int[0];
	}


	public static String fractions(String decimal) {
		int index = decimal.indexOf("(");
		// Проверяем, есть ли период в десятичной дроби
		if (index != -1) {
			// Получаем части десятичной дроби
			String before = decimal.substring(0, index);
			String repeat = decimal.substring(index + 1, decimal.length() - 1);
			String afterDecimal = before.substring(before.indexOf(".") + 1);
			before = before.substring(0, before.indexOf("."));
			// Собираем числитель, вычитая часть без периода
			String num = before + afterDecimal + repeat;
			String numWithoutRepeat = before + afterDecimal;
			BigInteger numerator = new BigInteger(num).subtract(new BigInteger(numWithoutRepeat));
			// Создаем знаменатель, состоящий из девяток и нулей
			StringBuilder den = new StringBuilder();
			for (int i = 0; i < repeat.length(); i++) {
				den.append("9");
			}
			for (int i = 0; i < afterDecimal.length(); i++) {
				den.append("0");
			}
			// Создаем объекты BigInteger для числителя и знаменателя
			BigInteger denominator = new BigInteger(den.toString());
			// Находим НОД числителя и знаменателя
			BigInteger gcd = numerator.gcd(denominator);
			// Возвращаем результат в виде строки
			return "" + numerator.divide(gcd) + "/" + denominator.divide(gcd);
		} else {
			// Если нет периода, возвращаем исходную десятичную дробь
			return decimal;
		}
	}


	public static String pilish_string(String str) {
		// Если входная строка пуста, возвращаем пустую строку
		if (str.isEmpty()) {
			return "";
		}
		// Задаем значение числа π
		double pi = 3.14159265358979;
		// Создаем массив для хранения цифр числа π
		int[] piNums = new int[15];
		// Инициализируем индекс i и заполняем массив цифрами числа π
		int i = 0;
		for (char number : Double.toString(pi).toCharArray()) {
			if (number != '.') {
				piNums[i] = Character.getNumericValue(number);
				i++;
			}
		}
		// Создаем StringBuilder для построения ответа
		StringBuilder answer = new StringBuilder();
		// Инициализируем переменные для отслеживания текущей позиции в строке
		int nowSymbols = 0;
		i = 0;
		// Построение пилотажной строки
		while (nowSymbols < str.length()) {
			// Если достигнут конец массива с цифрами π, выходим из цикла
			if (i == 15) {
				break;
			}
			// Добавляем подстроку к ответу в соответствии с цифрой числа π
			if (nowSymbols + piNums[i] > str.length()) {
				answer.append(str, nowSymbols, str.length());
			} else {
				answer.append(str, nowSymbols, nowSymbols + piNums[i]);
			}
			// Обновляем текущую позицию в строке
			nowSymbols += piNums[i];
			// Переходим к следующей цифре числа π
			i++;
			// Если текущая позиция меньше длины строки, добавляем пробел
			if (nowSymbols < str.length()) {
				answer.append(" ");
			}
		}
		// Дополняем строку, если текущая позиция больше длины строки
		if (nowSymbols > str.length()) {
			while (nowSymbols != str.length()) {
				answer.append(str.substring(str.length() - 1));
				nowSymbols -= 1;
			}
		}
		// Возвращаем построенную пилотажную строку
		return answer.toString();
	}


	public static int generateNonconsecutive(String str) throws CustomMathException {
		String operations = "+-/*";
		str = str.replaceAll("\\(", "( ");
		str = str.replaceAll("\\)", " )");
		String[] strArray = str.split("\\s+");
		// Красивый показ (на защиту)
		//System.out.println(Arrays.toString(strArray));
		boolean lastNum = false;
		String now;
		int bracketCounter = 0;
		int openBrackets = 0;
		// Обработка ислючений
		for (int i = 0; i < strArray.length; i++) {
			now = strArray[i];
			if (operations.contains(now)) {
				if ((i == 0 || i == strArray.length - 1)) {
					throw new CustomMathException("Неверный формат ввода (начинается или заканичивается операцией))");
				}
				if (!lastNum) {
					throw new CustomMathException("Неверный формат ввода (две операции подряд или ошибка у скобок)");
				}
				lastNum = false;
			}
			else if (now.equals("(")) {
				openBrackets += 1;
				bracketCounter += 1;
			}
			else if (now.equals(")")) {
				openBrackets -= 1;
				if (openBrackets < 0) {
					throw new CustomMathException("Неверный формат ввода (неправильный порядок скобок)");
				}
			}
			else if (now.matches("-?\\d+")) {
				if (lastNum) {
					throw new CustomMathException("Неверный формат ввода (два числа подряд или ошибка у скобок)");
				}
				lastNum = true;
			}
			else {
				throw new CustomMathException("Неверный формат ввода (встречается неизвестная подстрока)");
			}
		}
		if (openBrackets != 0) {
			throw new CustomMathException("Неверный формат ввода (неправильный порядок скобок)");
		}

		// Простой случай операции
		if (strArray.length == 3) {
			switch (strArray[1]) {
				case "+" -> {
					return Integer.parseInt(strArray[0]) + Integer.parseInt(strArray[2]);
				}
				case "-" -> {
					return Integer.parseInt(strArray[0]) - Integer.parseInt(strArray[2]);
				}
				case "*" -> {
					return Integer.parseInt(strArray[0]) * Integer.parseInt(strArray[2]);
				}
				case "/" -> {
					try {
						return Integer.parseInt(strArray[0]) / Integer.parseInt(strArray[2]);
					}
					catch (ArithmeticException e) {
						throw new CustomMathException("Ошибка: В строке происходит деление на ноль");
					}
				}
			}
		}
		// Разбиение на простые случаи
		else {
			// Учитывание скобок
			if (bracketCounter != 0) {
				int firstBracket = -1;
				int secondBracket = -1;
				// Ищем скобки
				for (int i = 0; i < strArray.length; i++) {
					now = strArray[i];
					if (now.equals("(") && firstBracket == -1) firstBracket = i;
					if (now.equals(")")) secondBracket = i;
				}
				// Создаем новую строку, учитывая скобки
				String newStr = "";
				if (firstBracket != 0) {
					newStr += String.join(" ", Arrays.copyOfRange(strArray, 0, firstBracket)) + " ";
				}
				newStr += (generateNonconsecutive(
						String.join(" ",
								Arrays.copyOfRange(strArray, firstBracket + 1, secondBracket))
				));
				if (secondBracket != strArray.length) {
					newStr += " " +
							String.join(" ",
									Arrays.copyOfRange(strArray, secondBracket + 1, strArray.length));
				}
				return generateNonconsecutive(newStr);
			}
			// Сокращение через базовые операции
			else {
				int operationIndex = -1;
				boolean higher = false;
				for (int i = 0; i < strArray.length; i++) {
					now = strArray[i];
					if ("+-".contains(now) && operationIndex == -1) operationIndex = i;
					if ("*/".contains(now) && !higher) {
						operationIndex = i;
						higher = true;
					}
				}
				// Построение новой строки
				String newStr = "";
				if (operationIndex != 1) {
					newStr += String.join(" ",
							Arrays.copyOfRange(strArray, 0, operationIndex - 1)) + " ";
				}
				newStr += (generateNonconsecutive(
						String.join(" ",
								Arrays.copyOfRange(strArray, operationIndex - 1, operationIndex + 2))
				));
				if (openBrackets != strArray.length - 1) {
					newStr += " " +
							String.join(" ",
									Arrays.copyOfRange(strArray, operationIndex + 2, strArray.length));
				}
				return generateNonconsecutive(newStr);
			}
		}
		// Вывод 0, чтобы компилятор пропустил
		return 0;
	}


	public static String isValid(String str) {
		// Инициализация словаря для подсчета частоты символов
		Map<Character, Integer> dictionary = new HashMap<>();
		// Переменная для отслеживания уникальных символов
		int unique = 0;
		// Подсчет частоты символов и определение уникальных символов
		for (char symbol : str.toCharArray()) {
			if (dictionary.containsKey(symbol)) {
				dictionary.put(symbol, dictionary.get(symbol) + 1);
			} else {
				dictionary.put(symbol, 1);
				unique += 1;
			}
		}
		// Создание массива для хранения значений частот
		int[] values = new int[unique];
		int i = 0;
		// Заполнение массива значениями частот
		for (int value : dictionary.values()) {
			values[i] = value;
			i++;
		}
		// Сортировка массива значений частот
		Arrays.sort(values);
		// Проверка критериев и возвращение результата
		if (values[0] == values[values.length - 1]) {
			return "YES";
		} else if (values[1] == values[values.length - 1] && values[0] == 1) {
			return "YES";
		} else if (values[0] == values[values.length - 2] && values[values.length - 1] - 1 == values[0]) {
			return "YES";
		}
		return "NO";
	}


	public static String findLCS(String str1, String str2) {
		// Инициализация матрицы для хранения результатов динамического программирования
		int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
		// Заполнение матрицы значениями для LCS
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				if (i == 0 || j == 0) {
					matrix[i][j] = 0;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				} else {
					matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
				}
			}
		}

		// Восстановление LCS из матрицы
		ArrayList<Character> chars = new ArrayList<>();
		int temp_i = str1.length() - 1;
		int temp_j = str2.length() - 1;
		while (temp_i >= 0 && temp_j >= 0) {
			if (str1.charAt(temp_i) == str2.charAt(temp_j)) {
				chars.add(str1.charAt(temp_i));
				temp_i -= 1;
				temp_j -= 1;
			} else if (matrix[temp_i][temp_j + 1] >= matrix[temp_i + 1][temp_j]) {
				temp_i -= 1;
			} else {
				temp_j -= 1;
			}
		}
		// Обратное переворачивание списка символов
		Collections.reverse(chars);
		// Построение строки из списка символов
		StringBuilder answer = new StringBuilder();
		for (char c : chars) {
			answer.append(c);
		}
		// Возвращение строки, представляющей LCS
		return answer.toString();
	}
}