package chap13;

import java.util.Calendar;
import java.util.Date;

public class Sample01 {

	public static void main(String[] args) {
		// 추상 클래스이므로 생성자를 사용하여 인스턴스를 생성할 수 없어서 static 메서드를 호출하여 생성
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		System.out.println(date);

		// 레거시 프로그램에서 사용하는 경우가 있음.
		System.out.println("\n== Date ==");
		System.out.printf("%s %s %02d %02d:%02d:%02d KST %d\n"
				, getWeekName(date.getDay() + 1) // 0부터 시작하기 때문에 1을 더해줌.
				, getMonthName(date.getMonth())
				, date.getDate()
				, date.getHours()
				, date.getMinutes()
				, date.getSeconds()
				, date.getYear() + 1900
		);
		
		System.out.println("\n== Calendar ==");
		System.out.printf("%s %s %02d %02d:%02d:%02d KST %d\n"
				, getWeekName(cal.get(Calendar.DAY_OF_WEEK))
				, getMonthName(cal.get(Calendar.DAY_OF_MONTH))
				, cal.get(Calendar.DAY_OF_MONTH)
				, cal.get(Calendar.HOUR_OF_DAY)
				, cal.get(Calendar.MINUTE)
				, cal.get(Calendar.SECOND)
				, cal.get(Calendar.YEAR)
		);
	}

	public static String getWeekName(int WeekNumber) {
		String retVal = null;
		switch (WeekNumber) {
		case Calendar.SUNDAY:
			retVal = "Sun";
			break;
		case Calendar.MONDAY:
			retVal = "Mon";
			break;
		case Calendar.TUESDAY:
			retVal = "Tue";
			break;
		case Calendar.WEDNESDAY:
			retVal = "Wed";
			break;
		case Calendar.THURSDAY:
			retVal = "Thu";
			break;
		case Calendar.FRIDAY:
			retVal = "Fri";
			break;
		case Calendar.SATURDAY:
			retVal = "Sat";
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + WeekNumber);
		}
		return retVal;
	}

	public static String getMonthName(int MonthNumber) {
		String retVal = null;
		switch (MonthNumber) {
		case Calendar.JANUARY:
			retVal = "Jan";
			break;
		case Calendar.FEBRUARY:
			retVal = "Feb";
			break;
		case Calendar.MARCH:
			retVal = "Mar";
			break;
		case Calendar.APRIL:
			retVal = "Apr";
			break;
		case Calendar.MAY:
			retVal = "May";
			break;
		case Calendar.JUNE:
			retVal = "Jun";
			break;
		case Calendar.JULY:
			retVal = "Jul";
			break;
		case Calendar.AUGUST:
			retVal = "Aug";
			break;
		case Calendar.SEPTEMBER:
			retVal = "Sep";
			break;
		case Calendar.OCTOBER:
			retVal = "Oct";
			break;
		case Calendar.NOVEMBER:
			retVal = "Nov";
			break;
		case Calendar.DECEMBER:
			retVal = "Dec";
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + MonthNumber);
		}
		return retVal;
	}
}
