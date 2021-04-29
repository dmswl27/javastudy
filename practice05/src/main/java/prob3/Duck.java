package prob3;

public abstract class Duck extends Bird{
	private String name;
	public Duck() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String sing() {
		return "꿱꿱이";
		
	}
	public String fly() {
		return "날지 않습니다.";
		
	}
}
