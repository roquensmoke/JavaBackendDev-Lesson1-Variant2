public class MathExpressionService
{
    protected String expression;
    protected String lastError = "";
    protected boolean bValidated = false;
    protected MathExpressionErrorEnum enumError;
    protected MathExpressionOperationEnum enumOperation = MathExpressionOperationEnum.NO_OPERATION;
    protected Double[] arArgs;

    public MathExpressionService(String expression)
    {
        this.expression = expression.trim();
        this.arArgs = new Double[]{null, null};
        this.parse().validate();
    }

    protected MathExpressionService parse()
    {
        if (!this.expression.matches("^(\\d+(\\.\\d+)?\\s*)?[+\\-*/](\\s*\\d+(\\.\\d+)?)?$")) {
            return this;
        }

        int operationPosition = -1;
        if (this.expression.contains("+")) {
            this.enumOperation = MathExpressionOperationEnum.ADD;
            operationPosition = this.expression.indexOf("+");
        }
        if (this.expression.contains("-")) {
            this.enumOperation = MathExpressionOperationEnum.SUBTRACT;
            operationPosition = this.expression.indexOf("-");
        }
        if (this.expression.contains("*")) {
            this.enumOperation = MathExpressionOperationEnum.MULTIPLY;
            operationPosition = this.expression.indexOf("*");
        }
        if (this.expression.contains("/")) {
            this.enumOperation = MathExpressionOperationEnum.DIVIDE;
            operationPosition = this.expression.indexOf("/");
        }
        var operand1 = this.expression.substring(0, operationPosition).trim();
        var operand2 = this.expression.substring(operationPosition + 1).trim();
        try {
            this.arArgs[0] = Double.parseDouble(operand1);
        } catch (Exception _) {}
        try {
            this.arArgs[1] = Double.parseDouble(operand2);
        } catch (Exception _) {}

        return this;
    }

    protected MathExpressionService validate()
    {
        this.enumError = MathExpressionErrorEnum.NO_ERROR;

        if (this.enumOperation == MathExpressionOperationEnum.NO_OPERATION) {
            this.enumError = MathExpressionErrorEnum.NO_OPERATION;
        } else if (this.arArgs[0] == null) {
            this.enumError = MathExpressionErrorEnum.NO_FIRST_ARGUMENT;
        } else if (this.arArgs[1] == null) {
            this.enumError = MathExpressionErrorEnum.NO_SECOND_ARGUMENT;
        } else if (this.arArgs[1] == 0 && this.enumOperation == MathExpressionOperationEnum.DIVIDE) {
            this.enumError = MathExpressionErrorEnum.DIVISION_BY_ZERO;
        }

        this.lastError = this.enumError.getTitle();
        this.bValidated = this.lastError.isEmpty();
        return this;
    }

    public boolean getValidated()
    {
        return bValidated;
    }

    public String getLastError()
    {
        return this.lastError;
    }

    public double execute()
    {
        if (this.bValidated) {
            return switch (this.enumOperation) {
                case ADD -> this.add(this.arArgs[0], this.arArgs[1]);
                case SUBTRACT -> this.subtract(this.arArgs[0], this.arArgs[1]);
                case MULTIPLY -> this.multiply(this.arArgs[0], this.arArgs[1]);
                case DIVIDE -> this.divide(this.arArgs[0], this.arArgs[1]);
                default -> 0;
            };
        }
        return 0;
    }

    protected double add(double a, double b)
    {
        return a + b;
    }

    protected double subtract(double a, double b)
    {
        return a - b;
    }

    protected double multiply(double a, double b)
    {
        return a * b;
    }

    protected double divide(double a, double b)
    {
        return a / b;
    }

    public String getParsedExpressionAsString()
    {
        if (this.bValidated) {
            return this.arArgs[0] + this.enumOperation.getPresentation() + this.arArgs[1];
        }
        return "Ошибка";
    }
}
