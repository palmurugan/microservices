package com.ms.util;

/**
 * 
 * @author palmurugan
 *
 */
public class GeneratorUtil {

	private static final String OUTPUT_DIR = "/output/";
	private static final String USER_DIR = "user.dir";
	private static final String SLASH = "/";

	/**
	 * 
	 * @param applicationName
	 * @return
	 */
	public static String getAppLocation(String applicationName) {
		return System.getProperty(USER_DIR) + OUTPUT_DIR + applicationName + SLASH;
	}

	/**
	 * 
	 * @param applicationName
	 * @param pacakgeName
	 * @param specificPackage
	 * @return
	 */
	public static String getSourceLocation(String applicationName, String pacakgeName, String specificPackage) {
		return System.getProperty(USER_DIR) + OUTPUT_DIR + applicationName + SLASH
				+ GeneratorConstants.BASE_SOURCE_PACKAGE + pacakgeName.replace(".", SLASH) + SLASH + specificPackage;
	}

	/**
	 * 
	 * @param applicationName
	 * @return
	 */
	public static String getResourceLocation(String applicationName) {
		return System.getProperty(USER_DIR) + OUTPUT_DIR + applicationName + SLASH
				+ GeneratorConstants.BASE_RESOURCE_PACKAGE;
	}

	/**
	 * 
	 * @param tplLocation
	 * @param externalFileName
	 * @return
	 */
	public static String getFileNameFromTemplate(String tplLocation, String externalFileName) {
		String templateFileName = tplLocation.substring(tplLocation.lastIndexOf(SLASH) + 1);
		String extension = getFileExtension(templateFileName.substring(0, templateFileName.lastIndexOf(".")));
		return (externalFileName != null && externalFileName != "") ? externalFileName + "." + extension
				: templateFileName.substring(0, templateFileName.lastIndexOf("."));
	}

	private static String getFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}
}
