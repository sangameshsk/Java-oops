package com.pratick.thrilio;

import com.pratick.thrilio.constants.KidFriendlyStatus;
import com.pratick.thrilio.constants.UserType;
import com.pratick.thrilio.controllers.BookmarkController;
import com.pratick.thrilio.entities.Bookmark;
import com.pratick.thrilio.entities.User;
import com.pratick.thrilio.partner.Sharable;

public class View {
	/*
	 * public static void bookmark(User user, Bookmark[][] bookmarks) {
	 * System.out.println("\n " + user.getEmail() + " is bookmarking"); for (int i =
	 * 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) { int typeOffset = (int)
	 * (Math.random() * DataStore.BOOKMARK_TYPES_CONSTANT); int bookmarkOffset =
	 * (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
	 *
	 * Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
	 *
	 * BookmarkController.getInstance().saveUserBookmark(user, bookmark);
	 *
	 * System.out.println(bookmark); } }
	 */

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n " + user.getEmail() + " is browsing items ...");
		int bookmarkCount = 0;

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				// !!
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);

					if (isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.println("New Item Bookmarked..." + bookmark);
					}
				}

				// mark as kid friendly

				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getIsKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);

						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);

						}
					}

					// Sharing!!
					if (bookmark.getIsKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
							&& bookmark instanceof Sharable) {
						boolean isShared = getShareDecision();

						if (isShared) {
							BookmarkController.getInstance().share(user, bookmark);
						}
					}
				}
			}
		}

	}

	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {

		double randomVal = Math.random();
		return randomVal < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;

		/*
		 * return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED : (Math.random() >=
		 * 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED :
		 * KidFriendlyStatus.UNKNOWN;
		 */
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;
	}

}
