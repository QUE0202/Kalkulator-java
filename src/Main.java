import java.util.Scanner;

class Kalkulator {
    protected double liczba1, liczba2, wynik;
    protected char operator;

    protected void wczytajDane() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj pierwszą liczbę: ");
        liczba1 = scanner.nextDouble();

        System.out.print("Podaj operator (+, -, *, /): ");
        operator = scanner.next().charAt(0);

        System.out.print("Podaj drugą liczbę: ");
        liczba2 = scanner.nextDouble();
    }

    protected void obliczWynik() {
        switch (operator) {
            case '+':
                wynik = liczba1 + liczba2;
                break;

            case '-':
                wynik = liczba1 - liczba2;
                break;

            case '*':
                wynik = liczba1 * liczba2;
                break;

            case '/':
                wynik = liczba1 / liczba2;
                break;

            default:
                System.out.println("Nieprawidłowy operator.");
                return;
        }
    }

    protected void wyswietlWynik() {
        System.out.println(liczba1 + " " + operator + " " + liczba2 + " = " + wynik);
    }
}

public class Main extends Kalkulator {
    public static void main(String[] args) {
        Main main = new Main();
        main.wczytajDane();
        main.obliczWynik();
        main.wyswietlWynik();
    }
}
