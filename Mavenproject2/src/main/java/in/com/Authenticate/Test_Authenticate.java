package in.com.Authenticate;

import in.com.Bean.UserRagistrationBean;
import in.com.Controller.UserRagistrationmodel;

public class Test_Authenticate {

	
	
	static UserRagistrationmodel model = new UserRagistrationmodel();

	public static void main(String[] args) throws Exception {

		testAuthenticate();

	}

	public static void testAuthenticate() {

		UserRagistrationBean bean = new UserRagistrationBean();
		modelAuthenticate mod= new modelAuthenticate();
		try {
			bean= mod.modelauthenticate("rpziddi1@gmail.com", "123456");
			
			if (bean !=null) {
				System.out.println("valid");
		
			}else {
				System.out.println("invalid");
			}
					
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}	
}	
		
		
