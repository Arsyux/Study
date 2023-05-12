package chap18;

public class AutoMachine implements AutoCloseable {

	private static AutoMachine auto;
	
	public static AutoMachine getInstance() {
		System.out.println("AutoMachine을 시작합니다.");
		auto = new AutoMachine();
		return auto;
	}
	
	public void run() throws Exception {
		System.out.println("AutoMachine Run");
	}

	@Override
	public void close() throws Exception {
		System.out.println("AutoMachine을 종료합니다.");
		auto = null;
	}
}
