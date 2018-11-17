package com.ms.util;

/**
 * 
 * @author palmurugan
 *
 */
public class Templates {

	public static final String POM_TPL = "/pom.xml.ftl";
	public static final String APPLICATION_TPL = "src/main/java/com/msg/Application.java.ftl";
	public static final String DOMAIN_CLASS_TPL = "src/main/java/com/msg/domain/Entity.java.ftl";
	public static final String APPLICATION_PROPERTIES_TPL = "src/main/resources/application.properties.ftl";
	public static final String REPOSITORY_TPL = "src/main/java/com/msg/repository/Repository.java.ftl";
	public static final String ISERVICE_TPL = "src/main/java/com/msg/service/IService.java.ftl";
	public static final String SERVICEIMPL_TPL = "src/main/java/com/msg/service/impl/ServiceImpl.java.ftl";
	public static final String RESOURCE_TPL = "src/main/java/com/msg/rest/Resource.java.ftl";

	/* Configuration Templates */
	public static final String SWAGGER_CONFIG_TPL = "src/main/java/com/msg/config/SwaggerConfiguration.java.ftl";

	private Templates() {
	}
}
