package com.ms.generator;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

	public void generateCode(String templateName, String data) throws TemplateException, IOException {
		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("applicationName", "TestApp");
		Template template = prepareTemplate(templateName);
		try (StringWriter out = new StringWriter()) {
			template.process(dataMap, out);
            System.out.println(out.getBuffer().toString());
            out.flush();
        }
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
