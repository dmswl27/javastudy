package goods;


public class Goods{
	static public int countOfGoods;
	
	public Goods() {
		Goods.countOfGoods++;
	}
	public String name; // 모든 접근이 가능 (접근제한 없음)
	protected int price; // 같은 패키지 + 자식 접근 가능
	int countStock;  // 같은 패키지만 가능하고 
	private int countSold;  // 클래스 내부에서만 접근 가능
	
	
}
