package com.ms.generator.app;


import static com.ms.util.Templates.APPLICATION_TPL;
import static com.ms.util.Templates.POM_TPL;

import java.io.IOException;

import com.ms.generator.BaseGenerator;
import com.ms.generator.Generator;
import com.ms.vo.MetaDataVO;

import freemarker.template.TemplateException;

/**
 * 
 * @author palmurugan
 *
 */
public class ApplicationGenerator extends BaseGenerator implements Generator {

	private static final String POM_LOCATION = "/Users/palmurugan/tmp/%s%s";
	private static final String APPLICATION_CLASS_LOCATION = "/Users/palmurugan/tmp/%s%s";

	@Override
	public Boolean generate(MetaDataVO metaData) {
		String applicationName = metaData.getApplicationName();
		try {
			generateCode(POM_TPL, getPomLocation(applicationName), "pom.xml", metaData);
			generateCode(APPLICATION_TPL, getApplicationClassLocation(applicationName), applicationName + ".java",
					metaData);
		} catch (TemplateException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private String getPomLocation(String applicationName) {
		return String.format(POM_LOCATION, applicationName, "/");
	}

	private String getApplicationClassLocation(String applicationName) {
		return String.format(APPLICATION_CLASS_LOCATION, applicationName, "/src/main/java/com/msg/");
	}

}
