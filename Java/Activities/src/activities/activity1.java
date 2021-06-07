package activities;

public class activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car toyota = new Car();
		toyota.make = 2014;
		toyota.color = "Black";
		toyota.transmission = "Manual";
		
		toyota.displaycharacteristics();
		toyota.accelerate();
		toyota.brake();

	}

}
