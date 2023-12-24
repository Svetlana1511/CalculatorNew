import java.util.Scanner;
    class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение из двух чисел от 1 до 10 (арабских или римских): ");
        String example = scanner.nextLine();
        System.out.println(parse(example));
    }
    public static String parse(String example) throws Exception {
        int number1;
        int number2;
        String operation;
        String result;
        boolean romNum;
        String[] string = example.split("[+\\-*/]");
        if (string.length != 2) throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        operation = calcValues(example);
        if (operation == null) throw new Exception("Неверно. Данная операция не поддерживается");

        if (Roman.romNum(string[0]) && Roman.romNum(string[1])) {
            number1 = Roman.convertToArabic(string[0]);
            number2 = Roman.convertToArabic(string[1]);
            romNum = true;
        }
        else if (!Roman.romNum(string[0]) && !Roman.romNum(string[1])) {
            number1 = Integer.parseInt(string[0]);
            number2 = Integer.parseInt(string[1]);
            romNum = false;
        }
        else {
            throw new Exception("Числа должны быть в одной системе счисления");
        }
        if (number1 > 10 || number2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arabic = calc(number1, number2, operation);
        if (romNum) {
            if (arabic <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            result = Roman.convertToRoman(arabic);
        } else {
            result = String.valueOf(arabic);
        }
        return result;
    }
    static String calcValues(String expression) {
        if (expression.contains("-")) return "-";
        else if (expression.contains("+")) return "+";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }
    static int calc(int a, int b, String operation) {
        if (operation.equals("-")) return a - b;
        else if (operation.equals("+")) return a + b;
        else if (operation.equals("*")) return a * b;
        else return a / b;
    }

}
    class Roman {
    static String[] romanNumbers = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};
    public static boolean romNum(String val) {
        for (int i = 0; i < romanNumbers.length; i++) {
            if (val.equals(romanNumbers[i])) {
                return true;
            }
        }
        return false;
    }
    public static int convertToArabic(String roman) {
        for (int i = 0; i < romanNumbers.length; i++) {
            if (roman.equals(romanNumbers[i])) {
                return i;
            }
        }
        return -1;
    }
    public static String convertToRoman(int arabic) {
        return romanNumbers[arabic];
    }
}














