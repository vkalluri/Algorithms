package com.venkat.other;

import java.util.Objects;

public final class MyFinal {
	
	private final String myString;
	private final String anotherString;
	private final int myInt;
	
	public MyFinal(String myString, String anotherString, int myInt) {
		this.myInt = myInt;
		this.myString = myString;
		this.anotherString = anotherString;
	}

	/**
	 * @return the myString
	 */
	public String getMyString() {
		return myString;
	}

	/**
	 * @return the anotherString
	 */
	public String getAnotherString() {
		return anotherString;
	}

	/**
	 * @return the myInt
	 */
	public int getMyInt() {
		return myInt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anotherString, myInt, myString);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MyFinal)) {
			return false;
		}
		MyFinal other = (MyFinal) obj;
		return Objects.equals(anotherString, other.anotherString) && myInt == other.myInt
				&& Objects.equals(myString, other.myString);
	}
	
	

}
