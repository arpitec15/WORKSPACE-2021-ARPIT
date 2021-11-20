package pattern.decorator.decors;

import pattern.decorator.Pizza;

public abstract class ToppingDecorator extends Pizza {
	private Pizza pizza;

	public abstract String getDescription();

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}
