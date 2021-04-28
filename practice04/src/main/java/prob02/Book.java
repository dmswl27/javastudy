package prob02;

public class Book {
	private int bookNo;
	private String title;
	private String author;
	private int stateCode;
	
	public  Book() {
		
	}
	public Book(int bookNo, String title, String author) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
	}
	
	public void displayBookInfo( String title, String author,int stateCode ) {
		for(int i = 0; i<books.lenght;i++) {
			System.out.println("책 제목:" + books[i].title + ", 작가:" + author + ", 대여 유무:" + stateCode);
	}
	public void rent() {
		
	}
	public void print() {
		
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
