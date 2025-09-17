import java.util.Scanner;

public class Main
{
    public static void main(String[] arParams)
    {
        Scanner scanner = new Scanner(System.in);

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
            System.out.println(obMathExpression.execute());
        }

        scanner.close();
    }
}
