package chat;

public class TestEnum {
	public enum Company {
		 
	    SK("에스케이"),
	    LG("엘쥐"),
	    KT("케이티"),
	    SAMSUNG("삼성"),
	    APPLE("애플");
	    
	    private final String value;
	    
	    Company(String value){
	        this.value = value;
	            
	    }
	    
	    public String getValue(){
	        return value;
	    }
	 
	}

    
    public static void main(String[] args) {
 
        for(Company type : Company.values()){
            System.out.println(type); // SK, LG, KT, SAMSUNG, APPLE
        }
 
        System.out.println(Company.SAMSUNG.ordinal()); //4
 
    }
    
}

