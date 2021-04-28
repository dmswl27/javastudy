package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String acount) {
		this.accountNo = acount;
		System.out.println(accountNo + "계좌가 개설되었습니다.");
	}
	
	public int save(int money) {
		System.out.println(accountNo + "계좌에 " + money + "만원이 입금되었습니다.");
		balance = balance+money;
		return balance;
	}
	public int deposit(int money) {
		System.out.println(accountNo + "계좌에 " + money + "만원이 출금되었습니다.");
		balance= balance- money;
		return balance;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
