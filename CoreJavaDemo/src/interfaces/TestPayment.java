package interfaces;

public class TestPayment {

	public static void main(String[] args) {
		Payment payment = new DebitCard();
		//Order order = new Order(payment);
		Order order = new Order();
		order.setPayment(payment);
		order.checkout();
	}
}
