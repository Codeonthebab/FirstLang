package com.concertExam;

public class Seat {
	private String Name;
	
	public Seat () {
		Name = null;
	}

	public String getName() {
		return Name;
	}
	public void cancel () {
		Name = null;
	}
	
	public void reserve (String Name) {
		this.Name = Name;
	}
	public boolean isOccupied () {
		// 좌석이 예약되어 있는지 확인하는 메소드
		// 좌석이 예약되어 있으면 true를 반환
		if (Name == null) {
			return false;
		} else {
			return true;			
		}
	}
	
	public boolean match (String Name) {
		// 맞는 이름인지 아닌지 확인하는 메소드
		return Name.equals (this.Name);		
	}
}
