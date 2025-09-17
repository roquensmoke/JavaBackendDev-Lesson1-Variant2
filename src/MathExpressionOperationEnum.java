public enum MathExpressionOperationEnum
{
    NO_OPERATION(""),
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String title;

    MathExpressionOperationEnum(String title)
    {
        this.title = title;
    }

    String getPresentation()
    {
        return this.title;
    }
}
