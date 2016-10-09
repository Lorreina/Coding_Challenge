/**
 * JAVA basic - Polymorphism
 * @author lorreina
 *
 */
public class Java_Polymorphism {
	public static class Fruit {
		public void print() {
			System.out.println("I am a Fruit.");
		}
	}
	
	public static class Apple extends Fruit {
		public void print() {
			System.out.println("I am an apple.");
		}
	}
	
	public static void main(String[] args) {
		Fruit fruit = new Fruit();
		Apple apple = new Apple();
		Fruit apple2 = new Apple();
		fruit.print();
		apple.print();
		apple2.print();
		((Fruit) apple).print();
//		((Apple) fruit).print();
		
	}
}
