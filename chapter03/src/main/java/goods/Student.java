package goods;

import javax.management.loading.PrivateClassLoader;

public class Student extends Person {
	private int grade;
	private String major;
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Student() {
		
		//super();
		//자식 생성자 앞에 호출된다.
		//자식의 모든 생성자에서 부모의 특정 생성자를 명시하지 않으면 암묵적으로 부모의 기본생성자가 자동으로 호출된다. 
		System.out.println("Student() called");
	
	}
}
