package pattern.decorator.decors;

import pattern.decorator.Pizza;

public class Cheese extends ToppingDecorator {

	public Cheese(Pizza pizza) {
		this.setPizza(pizza);
	}

	@Override
	public String getDescription() {

		return getPizza().getDescription() + " with extra cheese ";
	}

	public double cost() {
		return getPizza().cost() + 50;
	}
}
