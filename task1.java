
import java.util.Scanner;
import java.util.Locale;

public class task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер задания(1-10): ");
        int num = scan.nextInt();
        task t = new task();
        switch (num){
            case 1:
                try{
                    System.out.print("Введите целое число галлонов: ");
                    int a = scan.nextInt();
                    if (a>0){
                        System.out.println("Количество литров: " + t.one(a));
                    } else{
                        System.out.println("Галлоны не могут быть отрицательными...");
                    }
                    break;
                } catch(java.util.InputMismatchException e){
                    System.out.println("Ошибка. Значение не является целым");
                    break;
                }
            case 2:
                try{
                    System.out.print("Введите время тренировки в минутах: ");
                    int a = scan.nextInt();
                    System.out.print("Введите интенсивность тренировки 1/2/3: ");
                    int b = scan.nextInt();
                    if ((b==1 || b==2 || b==3) && (a >= 0)){
                        System.out.println("Количество сожженных калорий: " + t.two(a,b));
                    } else{
                        System.out.println("У тренировки есть только 3 режима интенсивности!\nВремя не может быть отрицательным!");
                    }
                    break;
                } catch(java.util.InputMismatchException e){
                    System.out.println("Ошибка. Значение не является целым");
                    break;
                }
            case 3:
                try{
                    System.out.print("Введите количество коробок: ");
                    int a = scan.nextInt();
                    System.out.print("Введите количество мешков: ");
                    int b = scan.nextInt();
                    System.out.print("Введите количество бочек: ");
                    int c = scan.nextInt();
                    if (a>0 && b>0 && c>0){
                        System.out.println("Общее количество товаров на складе: " + t.three(a,b,c));
                    } else{
                        System.out.println("Количество не может быть отрицательным...");
                    }
                    break;
                } catch(java.util.InputMismatchException e){
                    System.out.println("Ошибка. Значение не является целым");
                    break;
                }
            case 4:
                scan.useLocale(Locale.US);
                System.out.print("Введите первую длину стороны треугольника: ");
                float x = scan.nextFloat();
                System.out.print("Введите вторую длину стороны треугольника: ");
                float y = scan.nextFloat();
                System.out.print("Введите третью длину стороны треугольника: ");
                float z = scan.nextFloat();
                if (x > 0 && y > 0 && z > 0){
                    System.out.println("Треугольник является: " + t.four(x,y,z));
                } else{
                    System.out.println("Длина не может быть отрицательной...");
                }
                break;
            case 5:
                try{
                    System.out.print("Введите целое число a: ");
                    int a = scan.nextInt();
                    System.out.print("Введите целое число b: ");
                    int b = scan.nextInt();
                    System.out.println("Большее введенное число: " + t.five(a,b));
                    break;
                } catch(java.util.InputMismatchException e){
                    System.out.println("Ошибка. Значение не является целым");
                    break;
                }
            case 6:
                scan.useLocale(Locale.US);
                System.out.print("Введите длину ткани в метрах: ");
                x = scan.nextFloat();
                System.out.print("Введите ширину пододеяльника: ");
                y = scan.nextFloat();
                System.out.print("Введите длину пододеяльника: ");
                z = scan.nextFloat();
                if (x > 0 && y > 0 && z > 0){
                    System.out.println("Количество пододеяльников, которые сможете сшить, прежде чем кончится рулон: " + t.six(x,y,z));
                } else{
                    System.out.println("Длина и ширина не могут быть отрицательными...");
                }
                break;
            case 7:
                try{
                    System.out.print("Введите целое положительное число a: ");
                    int a = scan.nextInt();
                    if (a>=0){
                        System.out.println("Факториал числа a: " + t.seven(a));
                    } else{
                        System.out.println("Факториал отрицательного числа неисчислимый");
                    }
                    break;
                } catch(java.util.InputMismatchException e){
                    System.out.println("Ошибка. Значение не является целым");
                    break;
                }
            case 8:
                try{
                    System.out.print("Введите целое число a: ");
                    int a = scan.nextInt();
                    System.out.print("Введите целое число b: ");
                    int b = scan.nextInt();
                    System.out.println("Наибольший общий делитель: " + t.eight(a, b));
                    break;
                } catch(java.util.InputMismatchException e){
                    System.out.println("Ошибка. Значение не является целым");
                    break;
                }
            case 9:
                try{
                    System.out.print("Введите количество билетов: ");
                    int a = scan.nextInt();
                    System.out.print("Введите стоимость одного билета: ");
                    int b = scan.nextInt();
                    if (a>0 && b>0){
                        System.out.println("Общая выручка от продажи билетов: " + t.nine(a, b));
                    } else{
                        System.out.println("Вы ввели отрицательное число или 0");
                    }
                    break;
                } catch(java.util.InputMismatchException e){
                    System.out.println("Ошибка. Значение не является целым");
                    break;
                }
            case 10:
                try{
                    System.out.print("Введите целое число студентов: ");
                    x = scan.nextFloat();
                    System.out.print("Введите целое число парт: ");
                    y = scan.nextFloat();
                    if (x>0 && y>0){
                        System.out.println(t.ten(x, y) + " столов не хватает для размещения всех студентов");
                    } else{
                        System.out.println("Вы ввели отрицательное число");
                    }
                    break;
                } catch(java.util.InputMismatchException e){
                    System.out.println("Ошибка. Значение не является целым");
                    break;
                }
            default:
            System.out.print("задания (1-10)");
            scan.close();
        }
    }
}

class task{
    public float one(int a){
        return a * 3.875f;
    }
    public int two(int a, int b){
        return a * b;
    }
    public int three(int a, int b, int c){
        return a*20 + b*50 + c*100;
    }
    public String four(float x, float y, float z){
        if ((x+y>z && x+z>y && y+z>x)){
            if (x==y && y==z){
                return "isosceles";
            } else if (x == y || x == z || z == y){
                return "equilateral";
            } else {
                return "different-sided";
            }
        } 
        return "not a triangle";
    }
    public int five(int a, int b){
        if (a >= b){
            return a;
        } else{
            return b;
        }
    }
    public int six(float x, float y, float z){
        return (int) (x/(y*z*2));
    }
    public int seven(int a){
        int res = 1;
        for (int i = 1; i <= a; i++){
            res *= i;
        }
        return res;
    }
    public int eight(int a, int b){
        int res = 1;
        if (a >= b) {
            for (int i = 1; i <= a; i++) {
                if (b % i == 0) {
                    int x = b / i;
                    if (a%x ==0){
                        res = x;
                        break;
                    }
                    
                }
            }
        }
        else {
            for (int i = 1; i <= b; i++) {
                if (a % i == 0) {
                    int x = a / i;
                    if (b%x ==0){
                        res = x;
                        break;
                    }
                }
            }
        }
        return res;
    }
    public int nine(int a, int b){
        return ((a*b/100)*72);
    }
    public int ten(float a, float b){
        float c = a/2;
        int v = (int) Math.ceil(c);
        return (int) (v - b);
    }
}