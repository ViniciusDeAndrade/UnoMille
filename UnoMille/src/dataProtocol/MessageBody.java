package dataProtocol;

import java.io.Serializable;

public class MessageBody implements Serializable{

	private RequestHeader requestHeader;
	private RequestBody requestBody;
	private ReplyHeader replyHeader;
	private ReplyBody replyBody;

	public MessageBody(RequestHeader requestHeader, RequestBody requestBody, ReplyHeader replyHeader,
			ReplyBody replyBody) {
		
		this.requestHeader = requestHeader;
		this.requestBody = requestBody;
		this.replyHeader = replyHeader;
		this.replyBody = replyBody;
	}
	
	
	
	
}
