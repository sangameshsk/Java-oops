package com.pratick.thrilio.entities;

import com.pratick.thrilio.constants.KidFriendlyStatus;

public abstract class Bookmark {
	private long id;
	private String title;
	private String profileUrl;
	private String isKidFriendlyStatus = KidFriendlyStatus.UNKNOWN;
	private User kidFriendlyMArkedBy;
	private User sharedBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public abstract boolean isKidFriendlyEligible();

	public String getIsKidFriendlyStatus() {
		return isKidFriendlyStatus;
	}

	public void setIsKidFriendlyStatus(String isKidFriendlyStatus) {
		this.isKidFriendlyStatus = isKidFriendlyStatus;
	}

	public User getKidFriendlyMArkedBy() {
		return kidFriendlyMArkedBy;
	}

	public void setKidFriendlyMArkedBy(User kidFriendlyMArkedBy) {
		this.kidFriendlyMArkedBy = kidFriendlyMArkedBy;
	}

	public User getSharedBy() {
		return sharedBy;
	}

	public void setSharedBy(User sharedBy) {
		this.sharedBy = sharedBy;
	}
}
