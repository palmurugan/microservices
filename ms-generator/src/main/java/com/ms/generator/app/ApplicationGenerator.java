package com.ms.generator.app;

import static com.ms.util.Templates.APPLICATION_PROPERTIES_TPL;
import static com.ms.util.Templates.APPLICATION_TPL;
import static com.ms.util.Templates.DOMAIN_CLASS_TPL;
import static com.ms.util.Templates.ISERVICE_TPL;
import static com.ms.util.Templates.POM_TPL;
import static com.ms.util.Templates.REPOSITORY_TPL;
import static com.ms.util.Templates.RESOURCE_TPL;
import static com.ms.util.Templates.SERVICEIMPL_TPL;
import static com.ms.util.Templates.SWAGGER_CONFIG_TPL;

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

	private static final String BASE_SOURCE_PACKAGE = "src/main/java/";
	private static final String BASE_RESOURCE_PACKAGE = "src/main/resources/";
	private static final String EMPTY_STRING = "";

	@Override
	public Boolean generate(MetaDataVO metaData) {
		String applicationName = metaData.getApplicationName();
		try {
			generateCode(POM_TPL, getAppLocation(applicationName), getFileNameFromTemplate(POM_TPL, null), metaData);
			System.out.println("POM Created");

			generateCode(APPLICATION_TPL, getSourceLocation(applicationName, metaData.getPackageName(), EMPTY_STRING),
					getFileNameFromTemplate(APPLICATION_TPL, metaData.getApplicationName()), metaData);
			System.out.println("Application Created");

			generateCode(DOMAIN_CLASS_TPL, getSourceLocation(applicationName, metaData.getPackageName(), "/domain/"),
					getFileNameFromTemplate(DOMAIN_CLASS_TPL, metaData.getEntityDetails().getName()), metaData);
			System.out.println("Domain Created");

			generateCode(APPLICATION_PROPERTIES_TPL, getResourceLocation(applicationName),
					getFileNameFromTemplate(APPLICATION_PROPERTIES_TPL, null), metaData);
			System.out.println("Properties Created");

			generateCode(REPOSITORY_TPL, getSourceLocation(applicationName, metaData.getPackageName(), "/repository/"),
					getFileNameFromTemplate(REPOSITORY_TPL, metaData.getEntityDetails().getName() + "Repository"),
					metaData);
			System.out.println("Repository Created");

			generateCode(ISERVICE_TPL, getSourceLocation(applicationName, metaData.getPackageName(), "/service/"),
					getFileNameFromTemplate(ISERVICE_TPL, metaData.getEntityDetails().getName() + "Service"), metaData);
			System.out.println("Interface Service Created");

			generateCode(SERVICEIMPL_TPL,
					getSourceLocation(applicationName, metaData.getPackageName(), "/service/impl/"),
					getFileNameFromTemplate(SERVICEIMPL_TPL, metaData.getEntityDetails().getName() + "ServiceImpl"),
					metaData);
			System.out.println("Service Created");

			generateCode(RESOURCE_TPL,
					getSourceLocation(applicationName, metaData.getPackageName(), "/rest/"),
					getFileNameFromTemplate(RESOURCE_TPL, metaData.getEntityDetails().getName() + "Resource"),
					metaData);
			System.out.println("Resource Created");

			generateCode(SWAGGER_CONFIG_TPL, getSourceLocation(applicationName, metaData.getPackageName(), "/config/"),
					getFileNameFromTemplate(SWAGGER_CONFIG_TPL, null),
					metaData);
			System.out.println("Swagger Configuration Created");

		} catch (TemplateException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private String getAppLocation(String applicationName) {
		return System.getProperty("user.dir") + "/output/" + applicationName + "/";
	}

	private String getSourceLocation(String applicationName, String pacakgeName, String specificPackage) {
		return System.getProperty("user.dir") + "/output/" + applicationName + "/" + BASE_SOURCE_PACKAGE
				+ pacakgeName.replace(".", "/") + "/" + specificPackage;
	}

	private String getResourceLocation(String applicationName) {
		return System.getProperty("user.dir") + "/output/" + applicationName + "/" + BASE_RESOURCE_PACKAGE;
	}

	private String getFileNameFromTemplate(String tplLocation, String externalFileName) {
		String templateFileName = tplLocation.substring(tplLocation.lastIndexOf("/") + 1);
		String extension = getFileExtension(templateFileName.substring(0, templateFileName.lastIndexOf(".")));
		return (externalFileName != null && externalFileName != "") ? externalFileName + "." + extension
				: templateFileName.substring(0, templateFileName.lastIndexOf("."));
	}

	private String getFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}
}
