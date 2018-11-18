package com.ms.generator.app;

import static com.ms.util.Templates.APPLICATION_PROPERTIES_TPL;
import static com.ms.util.Templates.APPLICATION_TPL;
import static com.ms.util.Templates.POM_TPL;
import static com.ms.util.Templates.SWAGGER_CONFIG_TPL;

import java.io.IOException;

import com.ms.generator.BaseGenerator;
import com.ms.generator.Generator;
import com.ms.util.GeneratorUtil;
import com.ms.vo.MetaDataVO;

import freemarker.template.TemplateException;

/**
 * 
 * @author palmurugan
 *
 */
public class ApplicationGenerator extends BaseGenerator implements Generator {

	private static final String EMPTY_STRING = "";

	@Override
	public Boolean generate(MetaDataVO metaData) {
		String applicationName = metaData.getApplicationName();
		try {
			generateCode(POM_TPL, GeneratorUtil.getAppLocation(applicationName),
					GeneratorUtil.getFileNameFromTemplate(POM_TPL, null), metaData);
			System.out.println("POM Created");

			generateCode(APPLICATION_TPL,
					GeneratorUtil.getSourceLocation(applicationName, metaData.getPackageName(), EMPTY_STRING),
					GeneratorUtil.getFileNameFromTemplate(APPLICATION_TPL, metaData.getApplicationName()), metaData);
			System.out.println("Application Created");

			new EntityGenerator().generate(metaData);

			new RepositoryGenerator().generate(metaData);

			new ServiceGenerator().generate(metaData);

			new ResourceGenerator().generate(metaData);

			generateCode(SWAGGER_CONFIG_TPL,
					GeneratorUtil.getSourceLocation(applicationName, metaData.getPackageName(), "/config/"),
					GeneratorUtil.getFileNameFromTemplate(SWAGGER_CONFIG_TPL, null), metaData);
			System.out.println("Swagger Configuration Created");

			generateCode(APPLICATION_PROPERTIES_TPL, GeneratorUtil.getResourceLocation(applicationName),
					GeneratorUtil.getFileNameFromTemplate(APPLICATION_PROPERTIES_TPL, null), metaData);
			System.out.println("Properties Created");

		} catch (TemplateException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
