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
                System.out.print("Podaj operator (+, -, *, /, ^): ");
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

class Mnozenie extends Kalkulator {
    @Override
    protected void obliczWynik() {
        int indexOperatora = 0;
        wynik = liczby[0];

        for (int i = 1; i < liczby.length; i++) {
            char operator = operatory[indexOperatora];
            double liczba = liczby[i];

            switch (operator) {
                case '*':
                    wynik *= liczba;
                    break;

                default:
                    System.out.println("Nieprawidłowy operator.");
                    return;
            }

            indexOperatora++;
        }
    }
}

class Dzielenie extends Kalkulator {
    @Override
    protected void obliczWynik() {
        int indexOperatora = 0;
        wynik = liczby[0];

        for (int i = 1; i < liczby.length; i++) {
            char operator = operatory[indexOperatora];
            double liczba = liczby[i];

            switch (operator) {
                case '/':
                    if (liczba == 0) {
                        System.out.println("Dzielenie przez zero!");
                        return;
                    }
                    wynik /= liczba;
                    break;

                default:
                    System.out.println("Nieprawidłowy operator.");
                    return;
            }

            indexOperatora++;
        }
    }
}

class Potegowanie extends Kalkulator {
    @Override
    protected void obliczWynik() {
        int indexOperatora = 0;
        wynik = liczby[0];

        for (int i = 1; i < liczby.length; i++) {
            char operator = operatory[indexOperatora];
            double liczba = liczby[i];

            switch (operator) {
                case '^':
                    wynik = Math.pow(wynik, liczba);
                    break;

                default:
                    System.out.println("Nieprawidłowy operator.");
                    return;
            }

            indexOperatora++;
        }
    }
}

class Macierze extends Kalkulator {
    private double[][] macierz1;
    private double[][] macierz2;
    private double[][] wynikMacierzy;

    @Override
    protected void wczytajDane() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj ilość wierszy pierwszej macierzy: ");
        int wiersze1 = scanner.nextInt();
        System.out.print("Podaj ilość kolumn pierwszej macierzy: ");
        int kolumny1 = scanner.nextInt();
        System.out.print("Podaj ilość wierszy drugiej macierzy: ");
        int wiersze2 = scanner.nextInt();
        System.out.print("Podaj ilość kolumn drugiej macierzy: ");
        int kolumny2 = scanner.nextInt();

        if (kolumny1 != wiersze2) {
            System.out.println("Nieprawidłowe rozmiary macierzy!");
            return;
        }

        macierz1 = new double[wiersze1][kolumny1];
        macierz2 = new double[wiersze2][kolumny2];
        wynikMacierzy = new double[wiersze1][kolumny2];

        System.out.println("Podaj elementy pierwszej macierzy:");
        for (int i = 0; i < wiersze1; i++) {
            for (int j = 0; j < kolumny1; j++) {
                System.out.print("Podaj element [" + i + "][" + j + "]: ");
                macierz1[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Podaj elementy drugiej macierzy:");
        for (int i = 0; i < wiersze2; i++) {
            for (int j = 0; j < kolumny2; j++) {
                System.out.print("Podaj element [" + i + "][" + j + "]: ");
                macierz2[i][j] = scanner.nextDouble();
            }
        }
    }

    @Override
    protected void obliczWynik() {
        int wiersze1 = macierz1.length;
        int kolumny1 = macierz1[0].length;
        int wiersze2 = macierz2.length;
        int kolumny2 = macierz2[0].length;

        wynikMacierzy = new double[wiersze1][kolumny2];

        for (int i = 0; i < wiersze1; i++) {
            for (int j = 0; j < kolumny2; j++) {
                for (int k = 0; k < kolumny1; k++) {
                    wynikMacierzy[i][j] += macierz1[i][k] * macierz2[k][j];
                }
            }
        }
    }

    @Override
    protected void wyswietlWynik() {
        System.out.println("Wynik mnożenia macierzy:");

        for (int i = 0; i < wynikMacierzy.length; i++) {
            for (int j = 0; j < wynikMacierzy[0].length; j++) {
                System.out.print(wynikMacierzy[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Wybierz operację (1 - dodawanie, 2 - odejmowanie, 3 - mnożenie, 4 - dzielenie, 5 - potęgowanie, 6 - mnożenie macierzy): ");
        int operacja = scanner.nextInt();

        Kalkulator kalkulator;

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
            default:
                System.out.println("Nieprawidłowa operacja.");
                return;
        }

        kalkulator.wczytajDane();
        kalkulator.obliczWynik();
        kalkulator.wyswietlWynik();
    }
}
