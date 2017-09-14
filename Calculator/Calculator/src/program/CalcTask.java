package program;

public class CalcTask implements Runnable
{	
	private Print _obj;
	private Integer _n1;
	private Integer _n2;
	private char _action;
	
	private Calculator calc = new Calculator();
	
	public CalcTask(Print obj, int n1, int n2, char action)
	{
		_obj = obj;
		_n1 = n1;
		_n2 = n2;
		_action = action;
	}
	
	private void print(Object result)
	{
		_obj.print(result);
	}	

	@Override
	public void run()
	{		
		switch(_action)
		{
		case '+': print(calc.sum(_n1, _n2)); break;
		case '-': print(calc.subtract(_n1, _n2)); break;
		case '*': print(calc.multiply(_n1, _n2)); break;
		case '/': print(calc.divide(_n1, _n2)); break;
		}
	}
}
