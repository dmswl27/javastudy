package prob3;

public class Sparrow  extends Bird{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		super.setName(name);
		
	}

	@Override
	protected void fly() {
		System.out.println("참새(" + name +")는 날아다닙니다.");
		
	}

	@Override
	protected void sing() {
		
		System.out.println("참새(" + name + ")가 소리내어 웁니다.");
	}

	@Override
	public String toString() {
		
		return "참새의 이름은 " + name + "이 입니다.";
	}
	
	
}
