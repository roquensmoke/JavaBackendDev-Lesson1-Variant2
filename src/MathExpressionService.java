public class MathExpressionService
{
    protected String expression;
    protected String lastError = "";
    protected boolean bValidated = false;
    protected MathExpressionErrorEnum enumError;

    public MathExpressionService(String expression)
    {
        this.expression = expression;
        this.parse().validate();
    }

    protected MathExpressionService parse()
    {
        return this;
    }

    protected MathExpressionService validate()
    {
        enumError = MathExpressionErrorEnum.NO_ERROR;

        this.lastError = enumError.getTitle();
        this.bValidated = !this.lastError.isEmpty();
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
            //
        }
        return 0;
    }
}
