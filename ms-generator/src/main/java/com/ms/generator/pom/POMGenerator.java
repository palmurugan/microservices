package com.ms.generator.pom;

import java.io.IOException;

import com.ms.generator.BaseGenerator;
import com.ms.generator.Generator;

import freemarker.template.TemplateException;

/**
 * 
 * @author palmuruganc
 *
 */
public class POMGenerator extends BaseGenerator implements Generator {

	private static final String POM_TPL = "pom/pom.ftl";

	public Boolean generate(String data) {
		try {
			generateCode(POM_TPL, data);
		} catch (TemplateException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
