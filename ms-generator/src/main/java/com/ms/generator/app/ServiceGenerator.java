package com.ms.generator.app;

import static com.ms.util.Templates.ISERVICE_TPL;
import static com.ms.util.Templates.SERVICEIMPL_TPL;

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
public class ServiceGenerator extends BaseGenerator implements Generator {

	@Override
	public Boolean generate(MetaDataVO metaData) {
		for (EntityDetails entityDetail : metaData.getEntityDetails()) {
			try {
				generateCode(ISERVICE_TPL,
						GeneratorUtil.getSourceLocation(metaData.getApplicationName(), metaData.getPackageName(),
								"/service/"),
						GeneratorUtil.getFileNameFromTemplate(ISERVICE_TPL, entityDetail.getName() + "Service"),
						prepareData(metaData, entityDetail));
				generateCode(SERVICEIMPL_TPL,
						GeneratorUtil.getSourceLocation(metaData.getApplicationName(), metaData.getPackageName(),
								"/service/impl/"),
						GeneratorUtil.getFileNameFromTemplate(SERVICEIMPL_TPL, entityDetail.getName() + "ServiceImpl"),
						prepareData(metaData, entityDetail));
				System.out.println("Service Created Successfully");
			} catch (TemplateException | IOException e) {
				e.printStackTrace();
			}

		}
		return true;
	}

}
