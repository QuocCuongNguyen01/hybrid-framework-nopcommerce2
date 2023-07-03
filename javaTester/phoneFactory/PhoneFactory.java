package phoneFactory;

public abstract class PhoneFactory {
	protected String phoneName;
	
	protected abstract void setPhoneName(String phoneName);
	
	protected abstract String getPhoneName();
	
	
	// Dù không thêm từ khóa abstract nhưng trình biên dịch vẫn tự hiểu đây là 1 abstract method
	protected void touchPhone() {
		
	}
}
