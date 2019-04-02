package com.xforce.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.collections4.functors.CatchAndRethrowClosure;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.testng.annotations.Test;

public class ConfigUtils {
	static FileInputStream cfile;
	static Properties prop;

	public ConfigUtils() {
		try {
			cfile = new FileInputStream("./\\ConfigurationFiles\\config.properties");
			prop = new Properties();
			prop.load(cfile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String applnUrl() {
		return prop.getProperty("url");
	}

	public static String applnUserName() {
		return prop.getProperty("userName");
	}

	public static String applnUserPwd() {
		return prop.getProperty("userPwd");
	}

	public static String applnChromPath() {
		return prop.getProperty("chromePath");
	}

	public static String applnIePath() {
		return prop.getProperty("iePath");
	}
}
