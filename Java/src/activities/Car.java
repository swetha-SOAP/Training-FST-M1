package activities;

public class  {
	
	
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	
	Car(){
		tyres= 4;
		doors= 4;
	 }
	
	public void DisplayCharacterstics() {
		System.out.println("color of the car: " + color);
		System.out.println("Transmission of the car: " + transmission);
		System.out.println("Make of the car: " + make);
		System.out.println("no. of doors: " + doors);
		System.out.println("no. of tyres: " + tyres);	
	}

	public void accelerate()
	
	{
		System.out.println("car is moving forward");
		}
	public void brake()
	
	{
		System.out.println("stopped");
	}
}
