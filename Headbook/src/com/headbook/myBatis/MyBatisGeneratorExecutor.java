package com.headbook.myBatis;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MyBatisGeneratorExecutor {

	public static void main(String[] args)  {
		try {
			List<String> warnings = new ArrayList<String>();
			   boolean overwrite = true;
			   File configFile = new File("d:\\git\\Hiberus\\Headbook\\prueba_tecnica\\Headbook\\WebContent\\mybatisConfig-BackOffice.xml");
			   ConfigurationParser cp = new ConfigurationParser(warnings);
			   Configuration config = cp.parseConfiguration(configFile);
			   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			
//			List<String> warnings = new ArrayList<String>();
//			boolean overwrite = true;
//			InputStream stream = MyBatisGeneratorExecutor.class.getResourceAsStream("/mybatisConfig-BackOffice.xml");
//			ConfigurationParser cp = new ConfigurationParser(warnings);
//			org.mybatis.generator.config.Configuration config = cp.parseConfiguration(stream);
//			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			   
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			System.out.println("MyBatis OK");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
