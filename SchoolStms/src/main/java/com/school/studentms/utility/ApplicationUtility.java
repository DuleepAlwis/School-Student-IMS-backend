package com.school.studentms.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Random;

public class ApplicationUtility {

	private final static String chars = "abcdefghijklmnopqrztyz";
	private final static String specialChars = "!@#$%^&*()_-+=";
	private final static String numbers = "0123456789";

	public static String generatePassword(String password) {
		BCryptPasswordEncoder passwordEncode = new BCryptPasswordEncoder();
		return passwordEncode.encode(password);
	}
	
	public static boolean passwordMatches(String rawPassword,String hashPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(rawPassword, hashPassword);
	}

	public static String generateOrgCode(String orgName){
		Random random = new Random();
		StringBuilder sb = new StringBuilder(orgName.concat("_"));
		sb.append(new Timestamp(System.currentTimeMillis()));
		for(int i=0;i<3;i++){
			int num1 = random.nextInt(0,chars.length());
			int num2 = random.nextInt(0,chars.length());
			sb.append(chars.charAt(num1)).append(chars.toUpperCase().charAt(num2));
		}
		return sb.toString();

	}

	public static String generateTmpPassword(String email){
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		sb.append(email.charAt(random.nextInt(0,email.length()))).append(random.nextInt(0,email.length())).append(random.nextInt(0,email.length()
		));
		sb.append(specialChars.charAt(random.nextInt(0,specialChars.length())));
		sb.append(random.nextInt());
		sb.append(chars.charAt(random.nextInt(0,chars.length()))).append(chars.toUpperCase().charAt(random.nextInt(0,chars.length())));
		return sb.toString();
	}
}
