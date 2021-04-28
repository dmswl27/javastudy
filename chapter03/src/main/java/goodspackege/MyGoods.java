package goodspackege;

import goods.Goods;

public class MyGoods extends Goods {
	private float discountRate = 0.5f;
	
	public float getDiscountPrice() {
		// propacted 자식에서 접근할 수 있다.
		return  (price * discountRate);
	}

}
