package com.pratick.thrilio.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.pratick.thrilio.managers.BookmarkManager;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test 1: porn in url --- false
		WebLink webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");

		boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertFalse("For porn in url - isKidFriendlyEligible() must be return false", isKidFriendlyEligible);

		// Test 2: porn in tittle --- false

		webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming porn, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertFalse("For porn in title - isKidFriendlyEligible() must be return false", isKidFriendlyEligible);

		// Test 3: adult in host --- false

		webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming porn, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.adult.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertFalse("For adult in host - isKidFriendlyEligible() must be return false", isKidFriendlyEligible);
		// Test 4: adult in url not in host --- true

		webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertTrue("For adult url, but not in host - isKidFriendlyEligible() must be return true",
				isKidFriendlyEligible);

		// Test 5: adult in tittle only --- true

		webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming adult, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();

		assertTrue("For porn in title - isKidFriendlyEligible() must be return true", isKidFriendlyEligible);
	}

}
