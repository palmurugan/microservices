package ${packageName}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genesis.common.service.impl.GenericServiceImpl;
import ${packageName}.repository.${entityDetails.name}Repository;
import ${packageName}.domain.${entityDetails.name};
import ${packageName}.service.${entityDetails.name}Service;

/**
 * 
 * @author ${author}
 *
 */
@Service
public class ${entityDetails.name}ServiceImpl extends GenericServiceImpl<${entityDetails.name}, Long> implements ${entityDetails.name}Service {

	@Autowired
	private ${entityDetails.name}Repository reference;

	public ${entityDetails.name}ServiceImpl(${entityDetails.name}Repository reference) {
		super(reference);
	}
}
