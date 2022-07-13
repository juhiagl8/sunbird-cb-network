package org.sunbird.cb.hubservices.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConnectionRequest {

	private String userIdFrom;
	private String userIdTo;
	private String connectionId;
	private String status;
	private String createdAt;
	private String updatedAt;
	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserIdFrom() {
		return userIdFrom;
	}

	public void setUserIdFrom(String userIdFrom) {
		this.userIdFrom = userIdFrom;
	}

	public String getUserIdTo() {
		return userIdTo;
	}

	public void setUserIdTo(String userIdTo) {
		this.userIdTo = userIdTo;
	}

	public String getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}
}
