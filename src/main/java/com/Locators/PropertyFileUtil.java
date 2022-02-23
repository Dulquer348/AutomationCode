package com.Locators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil 
{

public static String getValueForKey(String key) throws Throwable, IOException



{
	Properties configproperties=new Properties();
	
	configproperties.load(new FileInputStream(new File ("C:\\Users\\QV136ZX\\PIPPROJECT\\Practice\\PropertyFile\\Environment.properties")));
	return configproperties.getProperty(key);
}
	

	
}
