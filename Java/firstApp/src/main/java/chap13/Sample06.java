package chap13;

import java.time.ZoneId;

public class Sample06 {

	public static void main(String[] args) {
		ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
	}
}
