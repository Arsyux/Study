package chap09_Interface;

public class Sample05_Polymorphism {

	// 인터페이스를 활용한 다형성
	public static void main(String[] args) {
		// Oracle에 접속합니다.
		Database db1 = new OracleDatabase();
		db1.getConnection();
		System.out.println(db1.getDbInfo());
		// MySQL에 접속합니다.
		Database db2 = new MysqlDatabase();
		System.out.println(db2.getDbInfo());
	}
}

interface Database {

	public void getConnection();

	public String getDbInfo();
}

class OracleDatabase implements Database {

	boolean conn = false;

	@Override
	public void getConnection() {
		this.conn = true;
	}

	@Override
	public String getDbInfo() {
		String ret = "";
		if (conn)
			ret = "Orcle에 접속성공!";
		else
			ret = "Orcle에 접속실패!";
		return ret;
	}
}

class MysqlDatabase implements Database {

	boolean conn = false;

	@Override
	public void getConnection() {
		this.conn = true;
	}

	@Override
	public String getDbInfo() {
		String ret = "";
		if (conn)
			ret = "MySQL에 접속성공!";
		else
			ret = "MySQL에 접속실패!";
		return ret;
	}
}