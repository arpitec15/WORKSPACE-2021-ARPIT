package pattern.strategy;

public class Item {

	private String name;
	private String barCode;
	private int price;

	public Item(String name, String barCode, int price) {
		this.name = name;
		this.barCode = barCode;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
