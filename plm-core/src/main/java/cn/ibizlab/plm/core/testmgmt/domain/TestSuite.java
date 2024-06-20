/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/core/{{modules}}/domain/{{entities@SQL}}.java.hbs
 */
package cn.ibizlab.plm.core.testmgmt.domain;

import java.util.*;
import java.math.BigDecimal;
import cn.ibizlab.util.domain.IEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.util.*;
import org.springframework.data.annotation.*;
import cn.ibizlab.util.annotation.*;
import cn.ibizlab.util.enums.*;
import cn.ibizlab.util.domain.EntityMP;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.*;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import cn.ibizlab.plm.core.testmgmt.domain.Library;
import cn.ibizlab.plm.core.testmgmt.domain.TestCaseTemplate;
import cn.ibizlab.plm.core.testmgmt.domain.TestCase;

/**
 * 用例模块实体类[TestSuite]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(value = "handler")
@TableName(value = "TEST_SUITE", resultMap = "TestSuiteResultMap")
@ApiModel(value = "TEST_SUITE", description = "用例模块")
public class TestSuite extends EntityMP implements Serializable
{

    /**
    * 序号
    */
    @TableField(value = "sequence")
    @DEField(name = "sequence" , defaultValue = "1")
    @JSONField(name = "sequence")
    @JsonProperty("sequence")
    @ApiModelProperty(value = "sequence", notes = "序号")
    private BigDecimal sequence;

    /**
    * 模块路径
    */
    @TableField(value = "suites")
    @DEField(name = "suites" , preType = DEPredefinedFieldType.PARENTIDPATH)
    @JSONField(name = "suites")
    @JsonProperty("suites")
    @ApiModelProperty(value = "suites", notes = "模块路径")
    private String suites;

    /**
    * 是否叶子节点
    */
    @TableField(value = "is_leaf")
    @DEField(name = "is_leaf" , defaultValue = "1" , dict = "YesNo")
    @JSONField(name = "is_leaf")
    @JsonProperty("is_leaf")
    @ApiModelProperty(value = "is_leaf", notes = "是否叶子节点")
    private Integer isLeaf;

    /**
    * 标识
    */
    @Id
    @TableId(value = "id" , type = IdType.ASSIGN_UUID)
    @DEField(name = "id" , isKeyField = true)
    @JSONField(name = "id")
    @JsonProperty("id")
    @ApiModelProperty(value = "id", notes = "标识")
    private String id;

    /**
    * 名称
    */
    @TableField(value = "name")
    @DEField(name = "name")
    @JSONField(name = "name")
    @JsonProperty("name")
    @ApiModelProperty(value = "name", notes = "名称")
    private String name;

    /**
    * 建立人
    */
    @TableField(value = "create_man" , fill = FieldFill.INSERT)
    @DEField(name = "create_man" , preType = DEPredefinedFieldType.CREATEMAN , dict = "SysOperator")
    @JSONField(name = "create_man")
    @JsonProperty("create_man")
    @ApiModelProperty(value = "create_man", notes = "建立人")
    private String createMan;

    /**
    * 建立时间
    */
    @TableField(value = "create_time" , fill = FieldFill.INSERT)
    @DEField(name = "create_time" , preType = DEPredefinedFieldType.CREATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "create_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("create_time")
    @ApiModelProperty(value = "create_time", notes = "建立时间")
    private Date createTime;

    /**
    * 更新人
    */
    @TableField(value = "update_man")
    @DEField(name = "update_man" , preType = DEPredefinedFieldType.UPDATEMAN , dict = "SysOperator")
    @JSONField(name = "update_man")
    @JsonProperty("update_man")
    @ApiModelProperty(value = "update_man", notes = "更新人")
    private String updateMan;

    /**
    * 更新时间
    */
    @TableField(value = "update_time")
    @DEField(name = "update_time" , preType = DEPredefinedFieldType.UPDATEDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    @JSONField(name = "update_time" , format = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("update_time")
    @ApiModelProperty(value = "update_time", notes = "更新时间")
    private Date updateTime;

    /**
    * 测试库标识
    */
    @TableField(value = "library_id")
    @DEField(name = "library_id")
    @JSONField(name = "library_id")
    @JsonProperty("library_id")
    @ApiModelProperty(value = "library_id", notes = "测试库标识")
    private String libraryId;

    /**
    * 父标识
    */
    @TableField(value = "pid")
    @DEField(name = "pid")
    @JSONField(name = "pid")
    @JsonProperty("pid")
    @ApiModelProperty(value = "pid", notes = "父标识")
    private String pid;

    /**
    * 名称
    */
    @TableField(value = "pname" , exist = false)
    @DEField(name = "pname")
    @JSONField(name = "pname")
    @JsonProperty("pname")
    @ApiModelProperty(value = "pname", notes = "名称")
    private String pname;

    /**
    * 测试库名称
    */
    @TableField(value = "library_name" , exist = false)
    @DEField(name = "library_name")
    @JSONField(name = "library_name")
    @JsonProperty("library_name")
    @ApiModelProperty(value = "library_name", notes = "测试库名称")
    private String libraryName;

    /**
    * 测试库
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "library", notes = "测试库")
    private Library library;

    /**
    * 模块
    */
    @Transient
    @TableField(exist = false)
    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty(value = "test_suite", notes = "模块")
    private TestSuite testSuite;

    /**
    * 设置 [序号]
    */
    public TestSuite setSequence(BigDecimal sequence) {
        this.sequence = sequence;
        this.modify("sequence", sequence);
        return this;
    }

    /**
    * 设置 [是否叶子节点]
    */
    public TestSuite setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
        this.modify("is_leaf", isLeaf);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public TestSuite setName(String name) {
        this.name = name;
        this.modify("name", name);
        return this;
    }

    /**
    * 设置 [测试库标识]
    */
    public TestSuite setLibraryId(String libraryId) {
        this.libraryId = libraryId;
        this.modify("library_id", libraryId);
        return this;
    }

    /**
    * 设置 [父标识]
    */
    public TestSuite setPid(String pid) {
        this.pid = pid;
        this.modify("pid", pid);
        return this;
    }

    /**
    * 设置 [名称]
    */
    public TestSuite setPname(String pname) {
        this.pname = pname;
        this.modify("pname", pname);
        return this;
    }

    /**
    * 设置 [测试库名称]
    */
    public TestSuite setLibraryName(String libraryName) {
        this.libraryName = libraryName;
        this.modify("library_name", libraryName);
        return this;
    }


    /**
     * 复制当前对象数据到目标对象(粘贴重置)
     * @param targetEntity 目标数据对象
     * @param includeEmpty  是否包括空值
     * @param <T>
     * @return
     */
    @Override
    public <T> T pasteTo(T targetEntity, boolean includeEmpty) {
        super.pasteTo(targetEntity, includeEmpty);
        if(targetEntity instanceof IEntity) {
            IEntity entity = ((IEntity) targetEntity);
            entity.reset("id");
        }
        return targetEntity;
    }

}