package goods;

public class Goods2App {
	public static void main(String[] args) {
		Goods2 goods = new Goods2();	
		goods.setName("5555");
		goods.setPrice(50);
		goods.setCountSold(20);
		goods.setCountStock(2);
		
		System.out.println(goods.calc(0.5));
		
		Goods2 goods2 = new Goods2("cannon",2000,20,30);
		goods2.showInfo();
		
		
	}

}
