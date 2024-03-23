/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/repository/{{entities@NoSQL}}Repository.java.hbs
 */
package cn.ibizlab.plm.core.ftr.repository;

import cn.ibizlab.plm.core.ftr.domain.SearchHub;
import cn.ibizlab.util.repository.IBZMongoRepository;

/**
 * 检索中心持久化[SearchHub]
 *
 * @author generator
 */
public interface SearchHubRepository extends IBZMongoRepository<SearchHub, String> {

}