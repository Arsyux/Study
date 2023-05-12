package chap10_Generic;

public class Sample07_LimitedGenericMethod3 {
	
	public static void main(String[] args) {
		// 내 지갑
		Wallet MyWallet = new Wallet();
		
		// Pocket Money
		Money<Integer> m1 = new Money<>();
		m1.getMoney(10000);
		
		// Part time job
		Money<Integer> m2 = new Money<>();
		m2.getMoney(600000);
		
		// 금액 입력
		MyWallet.insertMoney(m1);
		MyWallet.insertMoney(m2);
		
		// 지갑 확인
		System.out.println(MyWallet.checkWalletMoney());
	}
	
}

class Wallet {
	double totalMoney = 0;
	
	// 와일드 카드 제네릭 타입 (Generic Unbounded wildcard)
	public void insertMoney(Money<?> myMoney) {
		totalMoney += myMoney.getMyMoney();
	}

	public double checkWalletMoney() {
		return totalMoney;
	}

}

class Money<E extends Number> {
	double myMoney;

	public void getMoney(E info) {
		this.myMoney += info.doubleValue();
	}

	public double getMyMoney() {
		return myMoney;
	}
}