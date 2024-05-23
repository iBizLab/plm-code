/**
 * Generate code from /{{projectName}}-user/src/main/java/{{packageName}}/core/{{modules}}/service/impl/{{entities@SQL}}ServiceImpl.java.hbs
 */
// @SkipOverwrite
package cn.ibizlab.plm.core.base.service.impl;

import cn.ibizlab.plm.core.base.domain.Deliverable;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 实体[交付物] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
@Service("DeliverableService")
public class DeliverableServiceImpl extends AbstractDeliverableService {
    @Override
    public boolean saveByWorkItem(WorkItem workItem, List<Deliverable> list) {
        if (list == null)
            return true;

        Map<String, Deliverable> before = findByOwnerId(workItem.getId()).stream().filter(e-> "WORK_ITEM".equals(e.getOwnerType()) && "DELIVERABLE".equals(e.getOwnerSubtype())).collect(Collectors.toMap(Deliverable::getId, e -> e));
        List<Deliverable> update = new ArrayList<>();
        List<Deliverable> create = new ArrayList<>();

        for (Deliverable sub : list) {
            sub.setOwnerId(workItem.getId());
            sub.setWorkItem(workItem);
            if (!ObjectUtils.isEmpty(sub.getId()) && before.containsKey(sub.getId())) {
                before.remove(sub.getId());
                update.add(sub);
            } else
                create.add(sub);
        }
        if (!update.isEmpty())
            update.forEach(item -> this.getSelf().update(item));
        if (!create.isEmpty() && !getSelf().createBatch(create))
            return false;
        else if (!before.isEmpty() && !getSelf().removeBatch(before.keySet()))
            return false;
        else
            return true;
    }
}