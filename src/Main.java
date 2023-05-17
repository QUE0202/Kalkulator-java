import java.util.Scanner;

class Kalkulator {
    protected double[] liczby;
    protected char operator;
    protected double wynik;

    protected void wczytajDane() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj ilość liczb: ");
        int iloscLiczb = scanner.nextInt();
        liczby = new double[iloscLiczb];

        for (int i = 0; i < iloscLiczb; i++) {
            System.out.print("Podaj liczbę " + (i + 1) + ": ");
            liczby[i] = scanner.nextDouble();
        }

        System.out.print("Podaj operator (+, -, *, /): ");
        operator = scanner.next().charAt(0);
    }

    protected void obliczWynik() {
        switch (operator) {
            case '+':
                wynik = 0;
                for (double liczba : liczby) {
                    wynik += liczba;
                }
                break;

            case '-':
                wynik = liczby[0];
                for (int i = 1; i < liczby.length; i++) {
                    wynik -= liczby[i];
                }
                break;

            case '*':
                wynik = 1;
                for (double liczba : liczby) {
                    wynik *= liczba;
                }
                break;

            case '/':
                wynik = liczby[0];
                for (int i = 1; i < liczby.length; i++) {
                    if (liczby[i] == 0) {
                        System.out.println("Dzielenie przez zero!");
                        return;
                    }
                    wynik /= liczby[i];
                }
                break;

            default:
                System.out.println("Nieprawidłowy operator.");
                return;
        }
    }

    protected void wyswietlWynik() {
        System.out.print(liczby[0]);
        for (int i = 1; i < liczby.length; i++) {
            System.out.print(" " + operator + " " + liczby[i]);
        }
        System.out.println(" = " + wynik);
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
