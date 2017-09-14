package program;

public class Display1 implements Print
{	
	public void calcular()
	{
		CalcTask ct = new CalcTask(this, 10, 2, '+');
		Thread t = new Thread(ct);	
		
		t.start();
	}
	
	@Override
	public void print(Object _result)
	{
		System.out.println("Display 1 - O resultado é: " + _result);
	}
}
