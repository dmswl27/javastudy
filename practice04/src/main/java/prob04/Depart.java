package prob04;

public class Depart extends Employee {
	private String department;
	public Depart() {
	}
	public Depart(String name, int salary, String department ) {
		super.setName(name);
		super.setSalary(salary);
		this.department = department;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public int getSalary() {
		// TODO Auto-generated method stub
		return super.getSalary();
	}

	@Override
	public void setSalary(int salary) {
		// TODO Auto-generated method stub
		super.setSalary(salary);
	}

	
	public void getInformation() {
		System.out.println( "이름:" + getName() + "연봉:" + getSalary() + "부서:" + department );
	}



}
