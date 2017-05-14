package de.workshops.messaging;

public class Message {
	private String body;
	
	public Message() {
	}
	
	public Message(String body) {
		this.body = body;
	}

	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}

	@Override
    public String toString() {
        return String.format("Message{body=%s}", getBody());
    }
}
