package phoneFactory;

public interface PhoneFactoryInterface {
	public abstract void setPhoneName(String phoneName);

	public abstract String getPhoneName();
	
	// Du khong them tu khoa abstract nhưng trình biên dịch tư hiểu đây là 1 abstract method
	public void touchPhone();
}
