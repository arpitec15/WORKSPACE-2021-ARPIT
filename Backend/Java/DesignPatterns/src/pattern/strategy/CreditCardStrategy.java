package pattern.strategy;

public class CreditCardStrategy implements PaymentStrategy {

	private String name;
	private String cardNumber;
	private String cvv;
	private String expiry;

	public CreditCardStrategy(String name, String cardNumber, String cvv, String expiry) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expiry = expiry;
	}

	@Override
	public void pay(int amount) {
		System.out.println("Paying using credit card and name is " + name);
	}

}
