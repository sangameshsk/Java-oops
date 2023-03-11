package com.pratick.thrilio.entities;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import com.pratick.thrilio.constants.MovieGenre;
import com.pratick.thrilio.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		// fail("Not yet implemented");

		// Test 1:
		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);

		boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();

		assertFalse("For Horror Genre - isKidFriendlyEligible should return false", isKidFriendlyEligible);

		// Test 2

		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);

		isKidFriendlyEligible = movie.isKidFriendlyEligible();

		assertFalse("For Thrillers Genre - isKidFriendlyEligible should return false", isKidFriendlyEligible);
	}

}
