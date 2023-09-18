public class Car {
	String color;
	int speed = 0;
	
	Car(String color, int speed) {
		this.color = color;
		this.speed = speed;
	}
	Car(int speed) {
		this.speed = speed;
	}  /*오버로딩 overloading*/
	Car() {
	}
		
	int getSpeed() {
	return speed;
	}
		void upSpeed(int value) {
				
		if (speed + value >= 200)
			speed = 200;
		else
			speed = speed + value;
		}
		void downSpeed(int value) {
		if (speed - value <= 0)
			speed = 0;
		else
			speed = speed - value;
		}
		String getColor() {
		return color;
		}
	}