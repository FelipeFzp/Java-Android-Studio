package program;

public class Display2 implements Print
{
	public void calcular()
	{
		CalcTask ct = new CalcTask(this, 10, 2, '*');
		new Thread(ct).start();
	}
	
	@Override
	public void print(Object _result)
	{
		System.out.println("Display 2 - O resultado é: " + _result);
	}
}
