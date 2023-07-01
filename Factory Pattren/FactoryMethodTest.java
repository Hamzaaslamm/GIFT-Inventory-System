public class FactoryMethodTest {
		   public static void main(String[] args) {
		      ComputerFactory computerFactory = new ComputerFactory();

		      Computer c1 = computerFactory.getComputer("SERVER");
		      c1.print();

		      Computer c2 = computerFactory.getComputer("PC");
		      c2.print();
	}
}