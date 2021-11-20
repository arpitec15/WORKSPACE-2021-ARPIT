package pattern.decorator.decors;

import pattern.decorator.Pizza;

public class Corn extends ToppingDecorator {

	public Corn(Pizza pizza) {
		this.setPizza(pizza);
	}

	@Override
	public String getDescription() {

		return getPizza().getDescription() + " and golden corn ";
	}

	public double cost() {
		return getPizza().cost() + 30;
	}
}
