package altext;

public class Date {

	private final int year;
	private final int month;
	private final int day;
	public Date(int y,int m,int d){
		year=y;
		month=m;
		day=d;
	}
	public int year(){
		return year;
	}
	public int month(){
		return month;
	}
	public int day(){
		return day;
	}
	public String toString(){
		return "Date:"+year+"/"+month+"/"+day;
	}
}
