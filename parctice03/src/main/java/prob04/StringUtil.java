package prob04;

public class StringUtil {
	private String[] strArr;
	private String resultStr;
	
	public static String concatenate(String[] strArr) {
		String arry = "";
		for(int i=0;i<strArr.length;i++) {
			arry = arry+strArr[i];
		}
		return arry;
		
	}
}
