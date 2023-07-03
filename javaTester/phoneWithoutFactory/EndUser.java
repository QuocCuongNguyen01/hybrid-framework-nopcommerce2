package phoneWithoutFactory;

public class EndUser {

	public static void main(String[] args) {
		// Quan 3 - iphone
		Iphone iPhone = new Iphone();
		iPhone.setPhoneName("Iphone 14");
		System.out.println(iPhone.getPhoneName());
		iPhone.setPhoneName("Iphone 14 Pro");
		System.out.println(iPhone.getPhoneName());
		iPhone.setPhoneName("Iphone 14 Pro Max");
		System.out.println(iPhone.getPhoneName());
		// Quan 8 - Samsung
		Samsung sam = new Samsung();
		sam.setPhoneName("Samsung S22");
		System.out.println(sam.getPhoneName());
		sam.setPhoneName("Samsung S22 Plus");
		System.out.println(sam.getPhoneName());
		sam.setPhoneName("Samsung S22 Ultra");
		System.out.println(sam.getPhoneName());
		// Quna 5 - Reno
		Reno reno = new Reno();
		reno.setPhoneName("Reno 6");
		System.out.println(reno.getPhoneName());
		reno.setPhoneName("Reno 7");
		System.out.println(reno.getPhoneName());
		reno.setPhoneName("Reno 8");
		System.out.println(reno.getPhoneName());
	}

}
