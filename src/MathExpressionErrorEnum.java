public enum MathExpressionErrorEnum
{
    NO_ERROR(""),
    DIVISION_BY_ZERO("Ошибка: деление на ноль");

    private final String title;

    MathExpressionErrorEnum(String title)
    {
        this.title = title;
    }

    String getTitle()
    {
        return this.title;
    }
}
