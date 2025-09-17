import java.util.Scanner;

public class Main
{
    //основная функция - точка входа программы
    public static void main(String[] arParams)
    {
        Scanner scanner = new Scanner(System.in);

        printRules();

        while (true) {
            System.out.println("Введите выражение: ");

            var input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }

            MathExpressionService obMathExpression = new MathExpressionService(input);
            if (!obMathExpression.getValidated()) {
                System.out.println(obMathExpression.getLastError());
                continue;
            }

            System.out.println("Результат: " + obMathExpression.execute());
        }

        scanner.close();
    }

    protected static void printRules()
    {
        System.out.println("Введите выражение, содержащее следующие операции: + - * /");
        System.out.println("Внимание: унарный минус не поддерживается ни в одном из операндов");
        System.out.println("Для завершения работы введите exit");
    }
}
