package PageUIs;

public class HomePageUI {
	// Field / biến
	public static final String REGISTER_LINK = "//a[@class='ico-register']";
	public static final String LOGIN_LINK = "//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
	
	//a.ico-account
	// 1 - public 
	// Không set protected vì các class bên ngoài package sẽ không dùng được -> không áp dụng kế thừa
	// không set private: ngoài class không dùng đc
	// không set default: ngoài package không dùng được
	// public: bất kì class nào cũng gọi tới để sử dụng được
	
	// 2 - static
	// truy cập từ phạm vi class ở 1 class khác được
	
	// 3 - 3 final
	// không được phép thay đổi giá trị của biến trong quá trình sử dụng
	
	// không có từ khóa nào là đại diện cho hằng số
	// kết hợp 2 từ khóa lại với nhau = HẮNG SỐ => không thể thay dổi : static + final
	
	// Tên biến hằng số : viết hoa lên
	// nếu nhiều hơn 1 từ phân cách bởi dấu _
}
