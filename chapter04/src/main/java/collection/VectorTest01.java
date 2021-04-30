package collection;

import java.lang.Enum.EnumDesc;
import java.util.Vector;
import java.util.Enumeration;

public class VectorTest01 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		
		v.addElement("둘리");
		v.addElement("마이콜");
		v.addElement("또치");
		
//순회1
		int count = v.size();
		for(int i = 0; i<count;i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
		
		v.removeElementAt(2);
		
		Enumeration<String> e =  v.elements();
		while(e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
		}
		
	}

}
