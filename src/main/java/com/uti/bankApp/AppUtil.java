package com.uti.bankApp;

public class AppUtil {
	
	public static String getEncryptedAccNuumber(Long accntNumber) {
		String accntNumberStr=accntNumber.toString();
		String accntNumberSubStr=accntNumberStr.substring(accntNumberStr.length()-4, accntNumberStr.length());
		accntNumberSubStr="XXXXXXXX"+accntNumberSubStr;
		return accntNumberSubStr;
	}

}
