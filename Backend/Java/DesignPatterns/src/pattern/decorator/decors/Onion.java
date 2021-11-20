package pattern.decorator.decors;

import pattern.decorator.Pizza;

public class Onion extends ToppingDecorator {

	private Pizza pizza;

	public Onion(Pizza pizza) {
		this.pizza = pizza;

	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + " and onion ";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return pizza.cost() + 20;
	}

}
