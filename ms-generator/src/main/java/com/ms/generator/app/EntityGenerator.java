package com.ms.generator.app;

import static com.ms.util.Templates.DOMAIN_CLASS_TPL;

import java.io.IOException;

import com.ms.generator.BaseGenerator;
import com.ms.generator.Generator;
import com.ms.util.GeneratorUtil;
import com.ms.vo.EntityDetails;
import com.ms.vo.MetaDataVO;

import freemarker.template.TemplateException;

/**
 * 
 * @author palmurugan
 *
 */
public class EntityGenerator extends BaseGenerator implements Generator {

	@Override
	public Boolean generate(MetaDataVO metaData) {
		for (EntityDetails entityDetail : metaData.getEntityDetails()) {
			try {
				generateCode(DOMAIN_CLASS_TPL,
						GeneratorUtil.getSourceLocation(metaData.getApplicationName(), metaData.getPackageName(),
								"/domain/"),
						GeneratorUtil.getFileNameFromTemplate(DOMAIN_CLASS_TPL, entityDetail.getName()),
						prepareData(metaData, entityDetail));
				System.out.println("Entity Created Successfully");
			} catch (TemplateException | IOException e) {
				e.printStackTrace();
			}

		}
		return true;
	}
}
