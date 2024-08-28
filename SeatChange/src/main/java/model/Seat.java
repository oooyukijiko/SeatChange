package model;


import java.io.Serializable;
import java.util.Random;

public class Seat implements Serializable{
	private String[][] seat = {{ "0", "11",  "7",  "0"},
						       {"14", "10",  "6",  "3"},
						       {"13",  "9",  "5",  "2"},
						       {"12",  "8",  "4",  "1"}};
	private int headcount;
	
	public Seat() {
		
	}
	
	public Seat(int headcount) {
		this.headcount = headcount;
	}
	
	public String[][] getSeat() {
		return this.seat;
	}
	
	public void setSeat(String[][] seat) {
		this.seat = seat;
	}
	
	public int getHeadcount() {
		return this.headcount;
	}
	
	public void setHeadcount(int headcount) {
		this.headcount = headcount;
	}
	
	public int seatchange() {
		Random rand = new Random(System.currentTimeMillis());
		int num = rand.nextInt(headcount + 1);
		return num;
	}
	
}
