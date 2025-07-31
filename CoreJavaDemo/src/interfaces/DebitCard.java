package interfaces;

public class DebitCard  implements Payment{

	@Override
	public void pay() {
		System.out.println("Debit card payment mode");
	}
}
