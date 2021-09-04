package com.jagex.net;

import com.rspsi.cache.CacheFileType;

public class ResourceRequest {
	
	private int file;
	private CacheFileType type;
	private long requestTime;
	
	public ResourceRequest(int file, CacheFileType type) {
		this.file = file;
		this.type = type;
		this.requestTime = System.currentTimeMillis();
	}

	public long getAge() {
		return System.currentTimeMillis() - requestTime;
	}

	public CacheFileType getType() {
		return type;
	}
}