package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

//실제로 Gmail 사용하기위해서 계정 정보 입력 
public  class Gmail extends Authenticator {
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("abcehgus@gmail.com", "wjsehgus12!!");
	}

}
