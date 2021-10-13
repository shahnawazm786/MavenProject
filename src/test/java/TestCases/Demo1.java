package TestCases;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticExample.owner="Sachin";
		StaticExample merce=new StaticExample("F10","Mercidez");
		merce.infoCar();
		StaticExample audi=new StaticExample("A10","Audi");
		audi.infoCar();
		StaticExample porche=new StaticExample("A10","Porche");
		porche.infoCar();
		
		StaticExample jaguar=new StaticExample("J10","Jauguar");
		jaguar.infoCar();
	}

}
