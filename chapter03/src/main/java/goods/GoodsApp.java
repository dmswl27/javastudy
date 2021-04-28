package goods;

public class GoodsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods goods = new Goods();
		// public은 접근 데한이 없다 
		goods.name = "camera";
//		(더중요 한것은 자식에서만 접근 가능하다.)
		// protected는 같은 패키지만 접근 가능하다.
		goods.price=1000;
		// 디폴트는 같은 패키지 내에서만 가능하다.
		goods.countStock =50;
//		private은 같은 클래그 내에서만 접근 가능하다.
//		goods.countSold = 20;
	
		System.out.println(goods.name);
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods);

	}

}
