package activities;

public class activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array;
		array= new int[] {10, 77, 10, 54, -11, 10};
		int sum = 0;
		
		for (int i=0; i<6; i++)
		{
			if (i==10) 
			
			{ 
				sum = sum+i;
			}
		           
		}
		if (sum == 30)
		
		{
			System.out.println("sum of all the 10's is 30, true");
	}
		else
		{
			System.out.println("sum of all the 10's is not 30, False");
		}
	}
}