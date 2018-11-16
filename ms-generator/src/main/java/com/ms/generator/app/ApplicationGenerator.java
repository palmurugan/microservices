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

	private static final String BASE_SOURCE_PATH = "/src/main/java/com/msg/";
	private static final String BASE_RESOURCE_PATH = "/src/main/resources/";

	@Override
	public Boolean generate(MetaDataVO metaData) {
		String applicationName = metaData.getApplicationName();
		try {
			generateCode(POM_TPL, getLocationFromTemplate(POM_TPL, applicationName), getFileNameFromTemplate(POM_TPL),
					metaData);
			generateCode(APPLICATION_TPL, getLocationFromTemplate(APPLICATION_TPL, applicationName),
					getFileNameFromTemplate(APPLICATION_TPL), metaData);
			generateCode(DOMAIN_CLASS_TPL, getLocationFromTemplate(DOMAIN_CLASS_TPL, applicationName) + "/domain/",
					metaData.getEntityDetails().getName() + getFileNameFromTemplate(DOMAIN_CLASS_TPL), metaData);
			generateCode(APPLICATION_PROPERTIES_TPL,
					getLocationFromTemplate(APPLICATION_PROPERTIES_TPL, applicationName),
					getFileNameFromTemplate(APPLICATION_PROPERTIES_TPL), metaData);
		} catch (TemplateException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private String getLocationFromTemplate(String tplLocation, String applicationName) {
		return System.getProperty("user.dir") + "/output/" + applicationName + "/"
				+ tplLocation.substring(0, tplLocation.lastIndexOf("/"));
	}

	private String getFileNameFromTemplate(String tplLocation) {
		String fileName = tplLocation.substring(tplLocation.lastIndexOf("/") + 1);
		return fileName.substring(0, fileName.lastIndexOf("."));
	}

	private String getPomLocation(String applicationName) {
		return String.format(getBaseDir() + "%s%s", applicationName, "/");
	}

	private String getApplicationClassLocation(String applicationName) {
		return String.format(getBaseDir() + "%s%s", applicationName, BASE_SOURCE_PATH);
	}

	private String getDomainClassLocation(String applicationName) {
		return String.format(getBaseDir() + "%s%s", applicationName, BASE_SOURCE_PATH + "domain/");
	}

	private String getApplicationPropertyLocation(String applicationName) {
		return String.format(getBaseDir() + "%s%s", applicationName, BASE_RESOURCE_PATH);
	}

	private String getBaseDir() {
		return System.getProperty("user.dir") + "/output/";
	}
}
