/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/{{apis}}/dto/{{apiDtos@DEFILTER}}.java.hbs
 */
package cn.ibizlab.plm.serviceapi.dto;

import java.util.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.alibaba.fastjson.annotation.JSONField;
import cn.ibizlab.util.filter.FilterBase;

import lombok.*;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用例模板过滤[TestCaseTemplateFilterDTO]
 *
 * @author generator
 */
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("用例模板过滤DTO")
public class TestCaseTemplateFilterDTO extends FilterBase implements Serializable {

    /**
     * 重要程度EQ
     */
    @JsonProperty("n_level_eq")
    @JSONField(name = "n_level_eq")
    @ApiModelProperty(value = "重要程度EQ", position = 10)
	private String levelEQ;

    /**
     * 用例类型EQ
     */
    @JsonProperty("n_type_eq")
    @JSONField(name = "n_type_eq")
    @ApiModelProperty(value = "用例类型EQ", position = 20)
	private String typeEQ;

    /**
     * 测试类型EQ
     */
    @JsonProperty("n_test_type_eq")
    @JSONField(name = "n_test_type_eq")
    @ApiModelProperty(value = "测试类型EQ", position = 30)
	private String testTypeEQ;

    /**
     * 评审状态EQ
     */
    @JsonProperty("n_state_eq")
    @JSONField(name = "n_state_eq")
    @ApiModelProperty(value = "评审状态EQ", position = 80)
	private String stateEQ;

    /**
     * 执行结果EQ
     */
    @JsonProperty("n_run_status_eq")
    @JSONField(name = "n_run_status_eq")
    @ApiModelProperty(value = "执行结果EQ", position = 140)
	private String runStatusEQ;

    /**
     * 标识EQ
     */
    @JsonProperty("n_id_eq")
    @JSONField(name = "n_id_eq")
    @ApiModelProperty(value = "标识EQ", position = 200)
	private String idEQ;

    /**
     * 名称LIKE
     */
    @JsonProperty("n_name_like")
    @JSONField(name = "n_name_like")
    @ApiModelProperty(value = "名称LIKE", position = 210)
	private String nameLIKE;

    /**
     * 测试库标识EQ
     */
    @JsonProperty("n_test_library_id_eq")
    @JSONField(name = "n_test_library_id_eq")
    @ApiModelProperty(value = "测试库标识EQ", position = 260)
	private String testLibraryIdEQ;

    /**
     * 测试库名称EQ
     */
    @JsonProperty("n_test_library_name_eq")
    @JSONField(name = "n_test_library_name_eq")
    @ApiModelProperty(value = "测试库名称EQ", position = 270)
	private String testLibraryNameEQ;

    /**
     * 测试库名称LIKE
     */
    @JsonProperty("n_test_library_name_like")
    @JSONField(name = "n_test_library_name_like")
    @ApiModelProperty(value = "测试库名称LIKE", position = 271)
	private String testLibraryNameLIKE;

    /**
     * 用例模块标识EQ
     */
    @JsonProperty("n_suite_id_eq")
    @JSONField(name = "n_suite_id_eq")
    @ApiModelProperty(value = "用例模块标识EQ", position = 280)
	private String suiteIdEQ;

    /**
     * 模块名称EQ
     */
    @JsonProperty("n_suite_name_eq")
    @JSONField(name = "n_suite_name_eq")
    @ApiModelProperty(value = "模块名称EQ", position = 290)
	private String suiteNameEQ;

    /**
     * 模块名称LIKE
     */
    @JsonProperty("n_suite_name_like")
    @JSONField(name = "n_suite_name_like")
    @ApiModelProperty(value = "模块名称LIKE", position = 291)
	private String suiteNameLIKE;


}