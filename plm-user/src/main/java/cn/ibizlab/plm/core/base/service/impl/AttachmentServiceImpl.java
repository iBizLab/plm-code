/**
 * Generate code from /{{projectName}}-user/src/main/java/{{packageName}}/core/{{modules}}/service/impl/{{entities@SQL}}ServiceImpl.java.hbs
 */
// @SkipOverwrite
package cn.ibizlab.plm.core.base.service.impl;

import cn.ibizlab.plm.core.base.domain.Attachment;
import cn.ibizlab.plm.core.projmgmt.domain.WorkItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 实体[附件] 服务对象接口实现
 *
 * @author generator
 */
@Slf4j
@Service("AttachmentService")
public class AttachmentServiceImpl extends AbstractAttachmentService {
    @Override
    public boolean saveByWorkItem(WorkItem workItem, List<Attachment> list) {
        if (list == null)
            return true;

        Map<String, Attachment> before = findByOwnerId(workItem.getId()).stream().filter(e->"WORK_ITEM".equals(e.getOwnerType())&& ObjectUtils.isEmpty(e.getOwnerSubtype())).collect(Collectors.toMap(Attachment::getId, e -> e));
        List<Attachment> update = new ArrayList<>();
        List<Attachment> create = new ArrayList<>();

        for (Attachment sub : list) {
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