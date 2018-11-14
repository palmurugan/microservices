package com.ms.generator.app;


import static com.ms.util.Templates.APPLICATION_PROPERTIES_TPL;
import static com.ms.util.Templates.APPLICATION_TPL;
import static com.ms.util.Templates.DOMAIN_CLASS_TPL;
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

	@Override
	public Boolean generate(MetaDataVO metaData) {
		String applicationName = metaData.getApplicationName();
		try {
			generateCode(POM_TPL, getPomLocation(applicationName), "pom.xml", metaData);
			generateCode(APPLICATION_TPL, getApplicationClassLocation(applicationName), applicationName + ".java",
					metaData);
			generateCode(DOMAIN_CLASS_TPL, getDomainClassLocation(applicationName),
					metaData.getEntityDetails().getName() + ".java",
					metaData);
			generateCode(APPLICATION_PROPERTIES_TPL, getApplicationPropertyLocation(applicationName),
					"application.properties",
					metaData);
		} catch (TemplateException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private String getPomLocation(String applicationName) {
		return String.format(getBaseDir() + "%s%s", applicationName, "\\");
	}

	private String getApplicationClassLocation(String applicationName) {
		return String.format(getBaseDir() + "%s%s", applicationName, "\\src\\main\\java\\com\\msg\\");
	}

	private String getDomainClassLocation(String applicationName) {
		return String.format(getBaseDir() + "%s%s", applicationName, "\\src\\main\\java\\com\\msg\\domain\\");
	}

	private String getApplicationPropertyLocation(String applicationName) {
		return String.format(getBaseDir() + "%s%s", applicationName, "\\src\\main\\resources\\");
	}

	private String getBaseDir() {
		return System.getProperty("user.dir") + "\\output\\";
	}
}
