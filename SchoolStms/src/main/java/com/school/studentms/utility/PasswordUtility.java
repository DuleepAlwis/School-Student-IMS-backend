package com.school.studentms.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtility {

	public static String generatePassword(String password) {
		BCryptPasswordEncoder passwordEncode = new BCryptPasswordEncoder();
		return passwordEncode.encode(password);
	}
	
	public static boolean passwordMatches(String rawPassword,String hashPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(rawPassword, hashPassword);
	}
}
