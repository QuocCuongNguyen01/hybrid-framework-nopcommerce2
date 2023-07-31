package commons;

public class GlobalConstant {
	// Info dùng cho toàn bộ tất cả các class khác trong Frw có thể truy cập được
	// Biến dùng chung
	// User/ Pass -> App
	// User/ Pass -> Database
	// Database: Dev/ Testing/ Staging/ Product
	// Environment
	// Third Party: Sanbox Paypal
	// Os name
	// Cloud Testing: Browserstack/ Saucelab/ CrossbrowserTesting(Access Token/ ID)
	// .....
	
	public static final String DEV_USER_URL = "https://demo.nopcommerce.com";
	public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final String DEV_ADMIN_USERNAME = "admin@yourstore.com";
	public static final String DEV_ADMIN_PASSWORD = "admin";
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH+"/UploadFile/";
	public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH+"/download/";
	
}
