package pattern.decorator;

import pattern.decorator.decors.Cheese;
import pattern.decorator.decors.Corn;
import pattern.decorator.decors.Onion;

public class PizzaStore {

	public static void main(String[] args) {

		Pizza pizza = new ThinCrustPizza();
		Pizza cheesePizza = new Cheese(pizza);
		Pizza goldenCorn = new Corn(cheesePizza);
		Pizza onionPizza = new Onion(goldenCorn);

		System.out.println(onionPizza.getDescription());
		System.out.println("Price is Rs " + onionPizza.cost());

	}

}
