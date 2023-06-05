package com.saketh.blog.payloads;

public class FileResponse {
	
	String msgString="";

	public String getMsgString() {
		return msgString;
	}

	public void setMsgString(String msgString) {
		this.msgString = msgString;
	}

	public FileResponse() {
		super();
	}

	public FileResponse(String msgString) {
		super();
		this.msgString = msgString;
	}
	
	

}
