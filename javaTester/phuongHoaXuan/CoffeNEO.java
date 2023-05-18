package phuongHoaXuan;

public class CoffeNEO {
	// Thuộc tính: Variable/ Property
	public String espresso = "cafe Espresso";
	protected String milkcoffe = "milk Coffe";
	String lemonfruit = "Lemon Fruit";
	private String neocafe = "cafe NEO";
	
	// Phương thức: Method/ Function
	public void shipEspresso() {
		System.out.println("Ship cafe: " + espresso);
	}
	protected void shipMilkCoffe() {
		System.out.println("Ship cafe: " + milkcoffe);
	}
	void shipLemon() {
		System.out.println("Ship Lemon: " + lemonfruit);
	}
	private void shipCafeNeo() {
		System.out.println("Ship Cafe Neo: " + neocafe);
	}
	public static void main(String[] args) {
		CoffeNEO neo = new  CoffeNEO();
		neo.shipEspresso();
		neo.shipMilkCoffe();
		neo.shipLemon();
		neo.shipCafeNeo();
	}
}
