import task1.MyInterface1;
import task1.MyInterface2;
import task2.Task2Factorial;
import task2.Task2Interface1;
import task2.Task2PrimeNumber;
import task3.Task3Interface;
import task4.Task4Interface1;
import task4.Task4Interface2;
import task4.Task4Interface3;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
        task4();
    }

    public static void task1() {
        MyInterface1<Integer> sum = (num1, num2, num3) -> num1 + num2 + num3;
        System.out.println("Сумма трех чисел = " + sum.func(1, 2, 3));
        MyInterface1<Integer> multiply = (num1, num2, num3) -> num1 * num2 * num3;
        System.out.println("Произведение трех чисел = " + sum.func(1, 2, 3));
        MyInterface2 currentTime = () -> {
            Date date = new Date();
            System.out.println("Текущее время: " + date.toString());
        };
        currentTime.func();
        MyInterface2 currentDate = () -> {
            LocalDate date = LocalDate.now();
            System.out.println("Текущя дата: " + date.toString());
        };
        currentDate.func();
    }

    public static void task2() {
        Task2Interface1 min = (n1, n2) -> Math.min(n1, n2);
        System.out.println("Минимум = " + min.func(2, 3));
        Task2Interface1 max = (n1, n2) -> Math.max(n1, n2);
        System.out.println("Максимум = " + max.func(2, 3));
        Task2Factorial factorial = (n) -> {
            int result = 1;
            for (int i = 2; i <= n; i++) {
                result = i * result;
            }
            return result;
        };
        int num = 6;
        System.out.println("Факториал от " + num + " = " + factorial.factorial(num));

        Task2PrimeNumber isPrimeNumber = (number) -> {
            boolean check = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
            }
            return check;
        };

        System.out.println(isPrimeNumber.check(8) ? "Простое" : "Не простое число");

    }

    public static void task3() {

        Task3Interface<Integer> min = (n1, n2, n3) -> Math.min(Math.min(n1, n2), n3);
        System.out.println("Минимум = " + min.func(1, 2, 3));
        Task3Interface<Integer> max = (n1, n2, n3) -> Math.max(Math.max(n1, n2), n3);
        System.out.println("Максимум = " + max.func(1, 2, 3));
    }

    public static void task4() {

        int[] numbers = new int[]{1, 2, 3, 4, 5};

        for (int i = 0; i < numbers.length; i++) {

        }
        Task4Interface1 sumEven = (n) -> n % 2 == 0;
        Task4Interface1 sumOdd = (n) -> n % 2 != 0;
        Task4Interface2 numInto = (num, a, b) -> {
            boolean result = false;
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            if(num >= min && num <= max){
                result = true;
            }
            return result;
        };
        Task4Interface3 sumMultiplyOfA = (n, a) -> n % a != 0;
        System.out.println("Сумма четных " + sum(numbers, sumEven));
        System.out.println("Сумма нечетных " + sum(numbers, sumOdd));
        System.out.println("Сумма нечетных " + sum(numbers, numInto, ));
        System.out.println("Сумма кратных A " + sum(numbers,sumMultiplyOfA));
    }

    static int sum(int[] numbers, Task4Interface1 func) {
        int result = 0;
        for(int i : numbers)
        {
            if (func.isEqual(i))
                result += i;
        }
        return result;
    }


}
