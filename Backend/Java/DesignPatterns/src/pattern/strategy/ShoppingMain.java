package pattern.strategy;

//https://www.journaldev.com/1754/strategy-design-pattern-in-java-example-tutorial

public class ShoppingMain {

	public static void main(String[] args) {

		ShoppingCart cart = new ShoppingCart();

		Item item1 = new Item("Book", "1234", 1000);
		Item item2 = new Item("Monitor", "5678", 95000);

		cart.addItem(item1);
		cart.addItem(item2);

		// pay by upi-id
		cart.pay(new UPIStrategy("9897325918@upi"));

		// pay by credit card
		cart.pay(new CreditCardStrategy("Arpit Shrivastava", "1234567890123456", "786", "12/15"));

	}

}
