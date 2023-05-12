package chap17_Stream;

import java.util.stream.IntStream;

public class Sample07_ParallelStream {

	public static void main(String[] args) {
		// 병렬 스트림 생성
		// 지금까지 스트림은 순차처리이므로 마지막 요소는 한참을 기다리게 됨
		// 순서가 필요하지 않은 작업일때 동시에 처리하면 기다리는 시간이 짧아서 빨리 처리할 수 있음
		// 스트림을 생성하고 parallel()메서드를 사용하면 직렬 스트림을 병렬 스트림으로 전환하게 됨.
		long processTime1 = System.currentTimeMillis();
		IntStream.rangeClosed(1, 100000)
				.forEach(x -> System.out.println(Thread.currentThread().getClass() + " - " + x));
		long time1 = System.currentTimeMillis() - processTime1;
		
		long processTime2 = System.currentTimeMillis();
		IntStream.rangeClosed(1, 10000).parallel()
				.forEach(x -> System.out.println(Thread.currentThread().getClass() + " - " + x));
		long time2 = System.currentTimeMillis() - processTime2;
		
		System.out.println("직렬 스트림 출력 시간 - " + time1);
		System.out.println("병렬 스트림 출력 시간 - " + time2);
	}

}
