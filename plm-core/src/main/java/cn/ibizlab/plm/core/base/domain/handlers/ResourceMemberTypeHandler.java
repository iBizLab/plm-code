/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/handlers/{{entities@NONE}}TypeHandler.java.hbs
 */
package cn.ibizlab.plm.core.base.domain.handlers;

import cn.ibizlab.plm.core.base.domain.ResourceMember;
import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 资源组件成员序列化辅助[ResourceMember]
 *
 * @author generator
 */
@Slf4j
@MappedTypes({List.class})
@MappedJdbcTypes(JdbcType.VARCHAR)
public class ResourceMemberTypeHandler extends AbstractJsonTypeHandler<List>
{
    private static ObjectMapper objectMapper = new ObjectMapper();
    private JavaType type;

    public ResourceMemberTypeHandler(Class<List> type) {
        this.type = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, ResourceMember.class);
    }

    @Override
    protected List parse(String json) {
        try {
            return objectMapper.readValue(json, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected String toJson(List obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setObjectMapper(ObjectMapper objectMapper) {
        ResourceMemberTypeHandler.objectMapper = objectMapper;
    }
}