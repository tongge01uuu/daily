package daily.jave.se.construct;

public class Child extends Father
{
	static
	{
		System.out.println("child static");
	}
	
	public Child()
	{
		System.out.println("child construct");
	}
	
	public static void main(String[] args)
	{
		Child c=new Child();
	}
}
