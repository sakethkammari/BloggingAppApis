package com.saketh.blog.payloads;

public class Api_Response {

			
		public Api_Response(String message, String body) {
		super();
		this.message = message;
		this.body = body;
	}
		public String message;
		public Api_Response() {
			super();
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		public String body;
}
