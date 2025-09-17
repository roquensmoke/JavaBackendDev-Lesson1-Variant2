public enum MathExpressionErrorEnum
{
    NO_ERROR(""),
    DIVISION_BY_ZERO("Ошибка: деление на ноль"),
    NO_FIRST_ARGUMENT("Ошибка: не задан или некорректен первый операнд"),
    NO_SECOND_ARGUMENT("Ошибка: не задан или некорректен второй операнд"),
    NO_OPERATION("Ошибка: не задана операция");

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
