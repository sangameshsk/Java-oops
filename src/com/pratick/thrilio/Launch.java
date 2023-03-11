package com.pratick.thrilio;

import com.pratick.thrilio.entities.Bookmark;
import com.pratick.thrilio.entities.User;
import com.pratick.thrilio.managers.BookmarkManager;
import com.pratick.thrilio.managers.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData() {
		System.out.println("1.    Loading Data...");
		DataStore.loadData();

		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookamarks();

		// System.out.println("Printing Data");
		// printUserData();
		// printBookmarkData();

	}

	private static void printUserData() {
		for (User user : users) {
			System.out.println(user);
		}
	}

	private static void printBookmarkData() {
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				System.out.println(bookmark);
			}
		}
	}

	private static void statrt() {
		// System.out.println("\n" + "2. Bookmarking....");
		for (User user : users) {
			View.browse(user, bookmarks);
		}
	}

	public static void main(String[] args) {
		loadData();
		statrt();
	}

}
