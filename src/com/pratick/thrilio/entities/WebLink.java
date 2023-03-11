package com.pratick.thrilio.entities;

import com.pratick.thrilio.partner.Sharable;

public class WebLink extends Bookmark implements Sharable {
	@Override
	public String toString() {
		return "WebLink [url=" + url + ", host=" + host + "]";
	}

	private String url;
	private String host;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public boolean isKidFriendlyEligible() {

		if (url.contains("porn") || getTitle().contains("porn") || host.contains("adult")) {
			return false;
		}
		return true;
	}

	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();

		builder.append("<item");
		builder.append("<type>").append(getTitle()).append("</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<url>").append(url).append("</url>");
		builder.append("<host>").append(host).append("</host>");
		builder.append("</item");

		return builder.toString();
	}

}
