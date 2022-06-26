package beans;

public class ResponseModel {

	private int status;
    private String message;
    
    //default constructor
    public ResponseModel() { }
    
    //non-default constructor
	public ResponseModel(int status, String message) {
		this.status = status;
		this.message = message;
	}
	
	//getters and setters
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
