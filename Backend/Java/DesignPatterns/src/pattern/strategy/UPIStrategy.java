package pattern.strategy;

public class UPIStrategy implements PaymentStrategy {

	private String upiId;

	public UPIStrategy(String upiId) {
		this.upiId = upiId;
	}

	@Override
	public void pay(int amount) {
		System.out.println("Paying using UPI and upiId is " + upiId);
	}

}
