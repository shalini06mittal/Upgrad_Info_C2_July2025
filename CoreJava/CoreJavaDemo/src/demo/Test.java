package demo;

public class Test {

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "Shalini");
		//System.out.println(e1.getId());
		// Object - super
		// to print string repn of e1
		System.out.println(e1.toString());
		Employee e2 = new Employee(2, "Chirag");
		//System.out.println(e1.getId());
		// Object - super
		System.out.println(e2.toString());
		int x = 10;
		System.out.println(x);//10
	}

}
