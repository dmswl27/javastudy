package prob05;

public class MyBase extends Base {
	private String state;

	public MyBase() {
		
	}
	public void afternoon(){
		System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
	}

	@Override
	public void service(String state) {
		if ("오후".equals(state)) {
			afternoon();
			return;
		}

		super.service(state);
	}


	@Override
	public void day() {
		System.out.println("낮에는 열심히 일하자!");
		// TODO Auto-generated method stub
		//super.day();
	}

	@Override
	public void night() {
		// TODO Auto-generated method stub
		super.night();
	}
	
	
}
