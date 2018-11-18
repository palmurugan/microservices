package com.ms.generator.app;

import static com.ms.util.Templates.REPOSITORY_TPL;

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
public class RepositoryGenerator extends BaseGenerator implements Generator {

	@Override
	public Boolean generate(MetaDataVO metaData) {
		for (EntityDetails entityDetail : metaData.getEntityDetails()) {
			try {
				generateCode(REPOSITORY_TPL,
						GeneratorUtil.getSourceLocation(metaData.getApplicationName(), metaData.getPackageName(),
								"/repository/"),
						GeneratorUtil.getFileNameFromTemplate(REPOSITORY_TPL, entityDetail.getName() + "Repository"),
						prepareData(metaData, entityDetail));
				System.out.println("Repository Created Successfully");
			} catch (TemplateException | IOException e) {
				e.printStackTrace();
			}

		}
		return true;
	}

}
