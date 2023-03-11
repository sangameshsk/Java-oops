package com.pratick.thrilio.dao;

import com.pratick.thrilio.DataStore;
import com.pratick.thrilio.entities.Bookmark;
import com.pratick.thrilio.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
