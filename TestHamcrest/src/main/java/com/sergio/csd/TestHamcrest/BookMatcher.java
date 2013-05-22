package com.sergio.csd.TestHamcrest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class BookMatcher extends TypeSafeMatcher<Book>{

	public void describeTo(Description description) {
		description.appendText("expected result from getIsbn(): ").appendValue(isbn);
		
	}

	@Override
	protected boolean matchesSafely(Book arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}