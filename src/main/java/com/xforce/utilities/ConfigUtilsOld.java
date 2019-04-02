package com.xforce.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.testng.annotations.Test;

public class ConfigUtilsOld {
	Properties prop;
	FileInputStream cfile;

	public ConfigUtilsOld()  {
		try {
		cfile = new FileInputStream("./\\ConfigurationFiles\\config.properties");
		prop = new Properties();
		prop.load(cfile);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
public String applnUrl() {
	return prop.getProperty("url");
}
	public String applnUserName() {
		return prop.getProperty("userName");
	}

	public String applnUserPwd() {
		return prop.getProperty("userPwd");
	}

	public String applnChromPath() {
		return prop.getProperty("chromePath");
	}

	public String applnIePath() {
		return prop.getProperty("iePath");
	}
}
