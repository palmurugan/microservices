package com.ms.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

import com.ms.vo.EntityDetails;
import com.ms.vo.MetaDataVO;
import com.ms.vo.ServiceDetailsVO;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 
 * @author palmuruganc
 *
 */
public abstract class BaseGenerator {

	private static Configuration configuration = null;

	public void generateCode(String templateName, String destination, String fileName, Object metaData)
			throws TemplateException, IOException {
		Template template = prepareTemplate(templateName);
		File file = new File(destination + fileName);
		if (destination.length() > 0) {
			file.getParentFile().mkdirs();
		}
		try (Writer fileWriter = new FileWriter(file)) {
			template.process(metaData, fileWriter);
			fileWriter.flush();
		}
	}

	public ServiceDetailsVO prepareData(MetaDataVO metaData, EntityDetails entityDetail) {
		return new ServiceDetailsVO(metaData.getAuthor(), metaData.getApplicationName(), entityDetail,
				metaData.getPackageName());
	}

	private Template prepareTemplate(String templateName) {
		Template template = null;
		try {
			template = getConfiguration().getTemplate(templateName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return template;
	}

	private Configuration getConfiguration() {
		if (Objects.isNull(configuration)) {
			configuration = new Configuration(Configuration.VERSION_2_3_28);
			configuration.setClassForTemplateLoading(BaseGenerator.class, "/");
			configuration.setDefaultEncoding("UTF-8");
		}
		return configuration;
	}
}
