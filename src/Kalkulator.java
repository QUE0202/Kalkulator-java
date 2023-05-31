import java.util.Scanner;

abstract class Kalkulator {
    protected double[] liczby;
    protected char[] operatory;
    protected double wynik;

    protected void wczytajDane() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj ilość liczb: ");
        int iloscLiczb = scanner.nextInt();
        liczby = new double[iloscLiczb];
        operatory = new char[iloscLiczb - 1];

        for (int i = 0; i < iloscLiczb; i++) {
            System.out.print("Podaj liczbę " + (i + 1) + ": ");
            liczby[i] = scanner.nextDouble();

            if (i < iloscLiczb - 1) {
                System.out.print("Podaj operator (+, -, *, /, ^, sqrt): ");
                operatory[i] = scanner.next().charAt(0);
            }
        }
    }

    protected abstract void obliczWynik();

    protected void wyswietlWynik() {
        System.out.print(liczby[0]);

        for (int i = 1; i < liczby.length; i++) {
            System.out.print(" " + operatory[i - 1] + " " + liczby[i]);
        }

        System.out.println(" = " + wynik);
    }
}
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Wybierz operację (1 - dodawanie, 2 - odejmowanie, 3 - mnożenie, 4 - dzielenie, 5 - potęgowanie, 6 - mnożenie macierzy, 7 - pierwiastkowanie): ");
        int operacja = scanner.nextInt();

        Calc kalkulator;

        switch (operacja) {
            case 1:
                kalkulator = new Dodawanie();
                break;
            case 2:
                kalkulator = new Odejmowanie();
                break;
            case 3:
                kalkulator = new Mnozenie();
                break;
            case 4:
                kalkulator = new Dzielenie();
                break;
            case 5:
                kalkulator = new Potegowanie();
                break;
            case 6:
                kalkulator = new Macierze();
                break;
            case 7:
                kalkulator = new Pierwiastkowanie();
                break;
            default:
                System.out.println("Nieprawidłowa operacja.");
                return;
        }

        kalkulator.wczytajDane();
        kalkulator.obliczWynik();
        kalkulator.wyswietlWynik();
    }
}