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
                System.out.print("Podaj operator (+, -, *, /): ");
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

class Dodawanie extends Kalkulator {
    @Override
    protected void obliczWynik() {
        int indexOperatora = 0;
        wynik = liczby[0];

        for (int i = 1; i < liczby.length; i++) {
            char operator = operatory[indexOperatora];
            double liczba = liczby[i];

            switch (operator) {
                case '+':
                    wynik += liczba;
                    break;

                default:
                    System.out.println("Nieprawidłowy operator.");
                    return;
            }

            indexOperatora++;
        }
    }
}

class Odejmowanie extends Kalkulator {
    @Override
    protected void obliczWynik() {
        int indexOperatora = 0;
        wynik = liczby[0];

        for (int i = 1; i < liczby.length; i++) {
            char operator = operatory[indexOperatora];
            double liczba = liczby[i];

            switch (operator) {
                case '-':
                    wynik -= liczba;
                    break;

                default:
                    System.out.println("Nieprawidłowy operator.");
                    return;
            }

            indexOperatora++;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Wybierz operację (1 - dodawanie, 2 - odejmowanie): ");
        int operacja = scanner.nextInt();

        Kalkulator kalkulator;

        if (operacja == 1) {
            kalkulator = new Dodawanie();
        } else if (operacja == 2) {
            kalkulator = new Odejmowanie();
        } else {
            System.out.println("Nieprawidłowa operacja.");
            return;
        }

        kalkulator.wczytajDane();
        kalkulator.obliczWynik();
        kalkulator.wyswietlWynik();
    }
}
