package chap13_Date;

import java.time.ZoneId;

public class Sample06_ZoneId1 {

	public static void main(String[] args) {
		ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
	}
}
