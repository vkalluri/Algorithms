package com.venkat.other;

import java.util.Objects;

public class TestingClass {
	
	private String myStringValue;
	private Integer myIntValue;
	/**
	 * @return the myStringValue
	 */
	public String getMyStringValue() {
		return myStringValue;
	}
	/**
	 * @param myStringValue the myStringValue to set
	 */
	public void setMyStringValue(String myStringValue) {
		this.myStringValue = myStringValue;
	}
	/**
	 * @return the myIntValue
	 */
	public Integer getMyIntValue() {
		return myIntValue;
	}
	/**
	 * @param myIntValue the myIntValue to set
	 */
	public void setMyIntValue(Integer myIntValue) {
		this.myIntValue = myIntValue;
	}
	@Override
	public int hashCode() {
		return Objects.hash(myIntValue, myStringValue);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TestingClass)) {
			return false;
		}
		TestingClass other = (TestingClass) obj;
		return Objects.equals(myIntValue, other.myIntValue) && Objects.equals(myStringValue, other.myStringValue);
	}
	@Override
	public String toString() {
		return "TestingClass [myStringValue=" + myStringValue + ", myIntValue=" + myIntValue + "]";
	}
	

}
