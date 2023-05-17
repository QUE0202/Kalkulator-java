public class Main {
    public static voic main(String[] args) {
    private class Kalkulator {

        public static void main(String[] args) {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            double liczba1, liczba2, wynik;
            char operator;

            System.out.print("Podaj pierwszą liczbę: ");
            liczba1 = scanner.nextDouble();

            System.out.print("Podaj operator (+, -, *, /): ");
            operator = scanner.next().charAt(0);

            System.out.print("Podaj drugą liczbę: ");
            liczba2 = scanner.nextDouble();

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
                    System.out.printf("Nieprawidłowy operator.");
                    return;
            }

            System.out.println(liczba1 + " " + operator + " " + liczba2 + " = " + wynik);
        }
    }
    }
}