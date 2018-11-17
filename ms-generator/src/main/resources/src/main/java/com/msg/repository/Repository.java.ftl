package ${packageName}.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ${packageName}.domain.${entityDetails.name};

/**
 * 
 * @author ${author}
 *
 */
 
@Repository
public interface ${entityDetails.name}Repository extends PagingAndSortingRepository<${entityDetails.name}, Long> {

}
