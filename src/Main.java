import java.util.Scanner;

abstract class Kalkulator {
    protected double[] liczby;
    protected char[] operatory;
    protected double wynik;
    protected double prawdopodobienstwo; // Nowe pole przechowujące prawdopodobieństwo

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

    protected void obliczPrawdopodobienstwo() {
        prawdopodobienstwo = wynik / 100.0; // Obliczanie prawdopodobieństwa
    }

    protected void wyswietlWynik() {
        System.out.print(liczby[0]);

        for (int i = 1; i < liczby.length; i++) {
            System.out.print(" " + operatory[i - 1] + " " + liczby[i]);
        }

        System.out.println(" = " + wynik);
        System.out.println("Prawdopodobieństwo: " + prawdopodobienstwo); // Wyświetlanie wyniku prawdopodobieństwa
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

        obliczPrawdopodobienstwo(); // Obliczanie prawdopodobieństwa
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

        obliczPrawdopodobienstwo(); // Obliczanie prawdopodobieństwa
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

        obliczPrawdopodobienstwo(); // Obliczanie prawdopodobieństwa
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

        obliczPrawdopodobienstwo(); // Obliczanie prawdopodobieństwa
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

        obliczPrawdopodobienstwo(); // Obliczanie prawdopodobieństwa
    }
}

class Pierwiastkowanie extends Kalkulator {
    @Override
    protected void obliczWynik() {
        int indexOperatora = 0;

        for (int i = 0; i < liczby.length; i++) {
            char operator = operatory[indexOperatora];
            double liczba = liczby[i];

            switch (operator) {
                case 's':
                    wynik = Math.sqrt(liczba);
                    break;

                default:
                    System.out.println("Nieprawidłowy operator.");
                    return;
            }

            indexOperatora++;
        }

        obliczPrawdopodobienstwo(); // Obliczanie prawdopodobieństwa
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

        obliczPrawdopodobienstwo(); // Obliczanie prawdopodobieństwa
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

        System.out.print("Wybierz operację (1 - dodawanie, 2 - odejmowanie, 3 - mnożenie, 4 - dzielenie, 5 - potęgowanie, 6 - pierwiastkowanie, 7 - mnożenie macierzy): ");
        int wybor = scanner.nextInt();

        Kalkulator kalkulator = null;

        switch (wybor) {
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
                kalkulator = new Pierwiastkowanie();
                break;
            case 7:
                kalkulator = new Macierze();
                break;
            default:
                System.out.println("Nieprawidłowy wybór.");
                return;
        }

        kalkulator.wczytajDane();
        kalkulator.obliczWynik();
        kalkulator.wyswietlWynik();
    }
}
