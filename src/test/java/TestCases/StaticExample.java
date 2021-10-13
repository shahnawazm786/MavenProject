package TestCases;

public class StaticExample {
	String model;
	String carName;
	static String owner;

	public StaticExample(String model,String carName) {
		this.model=model;
		this.carName=carName;
	}
	public void infoCar() {
		System.out.println(owner);
		System.out.println(carName);
		System.out.println(model);

	}
}
