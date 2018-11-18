package ${packageName}.rest;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.common.controller.AbstractRestController;
import ${packageName}.domain.${entityDetails.name};
import ${packageName}.service.${entityDetails.name}Service;

/**
 * 
 * @author ${author}
 *
 */

@RestController
@RequestMapping("/${entityDetails.name?lower_case}")
public class ${entityDetails.name}Resource extends AbstractRestController<${entityDetails.name}, Long> {

	@Inject
    public ${entityDetails.name}Resource(${entityDetails.name}Service reference) {
		super(reference);
    }
}
