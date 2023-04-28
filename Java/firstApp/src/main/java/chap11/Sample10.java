package chap11;

import java.util.HashMap;
import java.util.TreeMap;

public class Sample10 {

	public static void main(String[] args) {
		System.out.println("HashMap은 정렬되지 않은 Key, Value 형태로 저장됩니다.");
		var hm = new HashMap<String, String>();
		hm.put("230401", "A");
		hm.put("230402", "B");
		hm.put("230403", "C");
		hm.put("230404", "D");
		hm.put("230405", "E");
		hm.put("230406", "F");
		hm.put("230407", "G");
		hm.put("230408", "H");
		hm.put("230409", "I");
		hm.put("230410", "J");
		hm.put("230411", "K");
		hm.put("230412", "L");
		System.out.println(hm);

		System.out.println("Treemap은 정렬하며 Key, Value 형태로 저장됩니다.");
		var tm = new TreeMap<String, String>();
		tm.putAll(hm);
		System.out.println(tm);
		
		System.out.println("Number가 230403이거나 더 큰 값을 갖는 가장 가까운 알파벳");
		System.out.println(tm.ceilingEntry("230403")); // entry 형태로 반환
		System.out.print(tm.ceilingKey("230403")); // key 반환
		System.out.println("," + tm.get("230403"));
		
		if(tm.containsKey("230413")) {
			System.out.println("230413이 있습니다.");
		}else {
			System.out.println("230413이 없습니다.");
		}
				
	}

}
