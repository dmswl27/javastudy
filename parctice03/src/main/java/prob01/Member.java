package prob01;

public class Member {
	private String id;
	private String name;
	private int point;
	
	public Member() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public void show() {
		System.out.println("name = " + name + ", Id = " + id + ", point = " + point);
	}
	
}