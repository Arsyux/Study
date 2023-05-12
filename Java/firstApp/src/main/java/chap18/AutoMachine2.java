package chap18;

public class AutoMachine2 implements AutoCloseable {

	private static AutoMachine2 auto;
	
	public static AutoMachine2 getInstance() {
		System.out.println("AutoMachine2을 시작합니다.");
		auto = new AutoMachine2();
		return auto;
	}
	
	public void run() throws Exception {
		System.out.println("AutoMachine2 Run");
	}

	@Override
	public void close() throws Exception {
		System.out.println("AutoMachine2을 종료합니다.");
		auto = null;
	}
}
