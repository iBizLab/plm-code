/**
 * Generate code from /{{projectName}}-core/src/main/java/{{packageName}}/util/enums/Entities.java.hbs
 */
package cn.ibizlab.plm.util.enums;

import cn.ibizlab.util.domain.IEntity;
import cn.ibizlab.util.filter.ISearchContext;
import cn.ibizlab.util.helper.BeanCache;
import cn.ibizlab.util.security.SpringContextHolder;
import lombok.SneakyThrows;
import java.util.Arrays;
import java.util.Optional;

/**
 * 注册实体枚举
 *
 * @author generator
 */
public enum Entities {

    AUTH_LOG ("AuthLog","认证日志",cn.ibizlab.plm.core.ebsx.domain.AuthLog.class,cn.ibizlab.plm.core.ebsx.filter.AuthLogSearchContext.class,cn.ibizlab.plm.core.ebsx.service.AuthLogService.class),
    MS_VALUE_PROXY ("MSValueProxy","主状态值代理",cn.ibizlab.plm.core.extension.domain.MSValueProxy.class,null,null),
    PS_APP_PORTLET ("PSAppPortlet","应用门户部件",cn.ibizlab.plm.core.extension.domain.PSAppPortlet.class,null,null),
    PS_CORE_PRD ("PSCorePrd","核心产品",cn.ibizlab.plm.core.extension.domain.PSCorePrd.class,null,null),
    PS_CORE_PRD_CAT ("PSCorePrdCat","核心产品分类",cn.ibizlab.plm.core.extension.domain.PSCorePrdCat.class,null,null),
    PS_CORE_PRD_FUNC ("PSCorePrdFunc","核心产品功能",cn.ibizlab.plm.core.extension.domain.PSCorePrdFunc.class,null,null),
    PSDE_DATAFLOW ("PSDEDataflow","实体数据流逻辑",cn.ibizlab.plm.core.extension.domain.PSDEDataflow.class,null,null),
    PSDE_FIELD ("PSDEField","实体属性",cn.ibizlab.plm.core.extension.domain.PSDEField.class,null,null),
    PSDE_FORM ("PSDEForm","实体表单",cn.ibizlab.plm.core.extension.domain.PSDEForm.class,null,null),
    PSDE_GRID ("PSDEGrid","实体表格",cn.ibizlab.plm.core.extension.domain.PSDEGrid.class,null,null),
    PSDE_LOGIC ("PSDELogic","实体处理逻辑",cn.ibizlab.plm.core.extension.domain.PSDELogic.class,null,null),
    PSDE_LOGIC_LINK ("PSDELogicLink","实体处理逻辑链接",cn.ibizlab.plm.core.extension.domain.PSDELogicLink.class,null,null),
    PSDE_LOGIC_NODE ("PSDELogicNode","实体处理逻辑节点",cn.ibizlab.plm.core.extension.domain.PSDELogicNode.class,null,null),
    PSDEMS_LOGIC ("PSDEMSLogic","实体主状态迁移逻辑",cn.ibizlab.plm.core.extension.domain.PSDEMSLogic.class,null,null),
    PSDE_NOTIFY ("PSDENotify","实体通知",cn.ibizlab.plm.core.extension.domain.PSDENotify.class,null,null),
    PSDE_NOTIFY_TARGET ("PSDENotifyTarget","消息通知目标",cn.ibizlab.plm.core.extension.domain.PSDENotifyTarget.class,null,null),
    PS_SYS_BI_CUBE ("PSSysBICube","智能报表立方体",cn.ibizlab.plm.core.extension.domain.PSSysBICube.class,null,null),
    PS_SYS_BI_CUBE_DIMENSION ("PSSysBICubeDimension","智能报表立方体维度",cn.ibizlab.plm.core.extension.domain.PSSysBICubeDimension.class,null,null),
    PS_SYS_BI_CUBE_MEASURE ("PSSysBICubeMeasure","智能报表立方体指标",cn.ibizlab.plm.core.extension.domain.PSSysBICubeMeasure.class,null,null),
    PS_SYS_BI_REPORT ("PSSysBIReport","智能报表",cn.ibizlab.plm.core.extension.domain.PSSysBIReport.class,null,null),
    PS_SYS_BI_REPORT_ITEM ("PSSysBIReportItem","智能报表项",cn.ibizlab.plm.core.extension.domain.PSSysBIReportItem.class,null,null),
    PSWF_VERSION ("PSWFVersion","工作流版本",cn.ibizlab.plm.core.extension.domain.PSWFVersion.class,null,null),
    PS_WORKFLOW ("PSWorkflow","工作流",cn.ibizlab.plm.core.extension.domain.PSWorkflow.class,null,null),
    ROLE ("Role","系统角色",cn.ibizlab.plm.core.ebsx.domain.Role.class,cn.ibizlab.plm.core.ebsx.filter.RoleSearchContext.class,cn.ibizlab.plm.core.ebsx.service.RoleService.class),
    SYS_DEPARTMENT ("SysDepartment","部门",cn.ibizlab.plm.core.ebsx.domain.SysDepartment.class,cn.ibizlab.plm.core.ebsx.filter.SysDepartmentSearchContext.class,cn.ibizlab.plm.core.ebsx.service.SysDepartmentService.class),
    SYS_EMPLOYEE ("SysEmployee","人员",cn.ibizlab.plm.core.ebsx.domain.SysEmployee.class,cn.ibizlab.plm.core.ebsx.filter.SysEmployeeSearchContext.class,cn.ibizlab.plm.core.ebsx.service.SysEmployeeService.class),
    SYS_ORGANIZATION ("SysOrganization","组织",cn.ibizlab.plm.core.ebsx.domain.SysOrganization.class,cn.ibizlab.plm.core.ebsx.filter.SysOrganizationSearchContext.class,cn.ibizlab.plm.core.ebsx.service.SysOrganizationService.class),
    SYS_TODO ("SysTodo","待办",cn.ibizlab.plm.core.ebsx.domain.SysTodo.class,cn.ibizlab.plm.core.ebsx.filter.SysTodoSearchContext.class,cn.ibizlab.plm.core.ebsx.service.SysTodoService.class),
    USER_ROLE ("UserRole","用户角色关系",cn.ibizlab.plm.core.ebsx.domain.UserRole.class,cn.ibizlab.plm.core.ebsx.filter.UserRoleSearchContext.class,cn.ibizlab.plm.core.ebsx.service.UserRoleService.class),
    ACTIVITY ("Activity","活动",cn.ibizlab.plm.core.base.domain.Activity.class,cn.ibizlab.plm.core.base.filter.ActivitySearchContext.class,cn.ibizlab.plm.core.base.service.ActivityService.class),
    ADDON ("Addon","组件",cn.ibizlab.plm.core.base.domain.Addon.class,cn.ibizlab.plm.core.base.filter.AddonSearchContext.class,cn.ibizlab.plm.core.base.service.AddonService.class),
    ADDON_APPLICATION_ACTIVITY ("AddonApplicationActivity","应用插件活动",cn.ibizlab.plm.core.base.domain.AddonApplicationActivity.class,cn.ibizlab.plm.core.base.filter.AddonApplicationActivitySearchContext.class,cn.ibizlab.plm.core.base.service.AddonApplicationActivityService.class),
    ADDON_RESOURCE ("AddonResource","资源组件",cn.ibizlab.plm.core.base.domain.AddonResource.class,cn.ibizlab.plm.core.base.filter.AddonResourceSearchContext.class,cn.ibizlab.plm.core.base.service.AddonResourceService.class),
    ADDON_ROLE_MEMBER ("AddonRoleMember","组件权限成员",cn.ibizlab.plm.core.base.domain.AddonRoleMember.class,cn.ibizlab.plm.core.base.filter.AddonRoleMemberSearchContext.class,cn.ibizlab.plm.core.base.service.AddonRoleMemberService.class),
    APP_VIEW_THEME ("AppViewTheme","应用视图主题",cn.ibizlab.plm.core.ebsx.domain.AppViewTheme.class,cn.ibizlab.plm.core.ebsx.filter.AppViewThemeSearchContext.class,cn.ibizlab.plm.core.ebsx.service.AppViewThemeService.class),
    ARTICLE_PAGE ("ArticlePage","页面",cn.ibizlab.plm.core.wiki.domain.ArticlePage.class,cn.ibizlab.plm.core.wiki.filter.ArticlePageSearchContext.class,cn.ibizlab.plm.core.wiki.service.ArticlePageService.class),
    ATTACHMENT ("Attachment","附件",cn.ibizlab.plm.core.base.domain.Attachment.class,cn.ibizlab.plm.core.base.filter.AttachmentSearchContext.class,cn.ibizlab.plm.core.base.service.AttachmentService.class),
    ATTENTION ("Attention","关注",cn.ibizlab.plm.core.base.domain.Attention.class,cn.ibizlab.plm.core.base.filter.AttentionSearchContext.class,cn.ibizlab.plm.core.base.service.AttentionService.class),
    AUTH_LOG_ADMIN ("AuthLogAdmin","认证日志",cn.ibizlab.plm.core.ebsx.domain.AuthLogAdmin.class,cn.ibizlab.plm.core.ebsx.filter.AuthLogAdminSearchContext.class,cn.ibizlab.plm.core.ebsx.service.AuthLogAdminService.class),
    BASELINE ("Baseline","基线",cn.ibizlab.plm.core.base.domain.Baseline.class,cn.ibizlab.plm.core.base.filter.BaselineSearchContext.class,cn.ibizlab.plm.core.base.service.BaselineService.class),
    BASELINE_IDEA ("BaselineIdea","基线需求",cn.ibizlab.plm.core.prodmgmt.domain.BaselineIdea.class,cn.ibizlab.plm.core.prodmgmt.filter.BaselineIdeaSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.BaselineIdeaService.class),
    BASELINE_PAGE ("BaselinePage","基线页面",cn.ibizlab.plm.core.wiki.domain.BaselinePage.class,cn.ibizlab.plm.core.wiki.filter.BaselinePageSearchContext.class,cn.ibizlab.plm.core.wiki.service.BaselinePageService.class),
    BASELINE_TEST_CASE ("BaselineTestCase","基线用例",cn.ibizlab.plm.core.testmgmt.domain.BaselineTestCase.class,cn.ibizlab.plm.core.testmgmt.filter.BaselineTestCaseSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.BaselineTestCaseService.class),
    BASELINE_WORK_ITEM ("BaselineWorkItem","基线工作项",cn.ibizlab.plm.core.projmgmt.domain.BaselineWorkItem.class,cn.ibizlab.plm.core.projmgmt.filter.BaselineWorkItemSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.BaselineWorkItemService.class),
    BOARD ("Board","看板",cn.ibizlab.plm.core.projmgmt.domain.Board.class,cn.ibizlab.plm.core.projmgmt.filter.BoardSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.BoardService.class),
    BRANCH ("Branch","代码分支",cn.ibizlab.plm.core.devops.domain.Branch.class,cn.ibizlab.plm.core.devops.filter.BranchSearchContext.class,cn.ibizlab.plm.core.devops.service.BranchService.class),
    BRANCH_REF_COMMIT ("BranchRefCommit","分支提交关联",cn.ibizlab.plm.core.devops.domain.BranchRefCommit.class,cn.ibizlab.plm.core.devops.filter.BranchRefCommitSearchContext.class,cn.ibizlab.plm.core.devops.service.BranchRefCommitService.class),
    BUILD ("Build","构建",cn.ibizlab.plm.core.devops.domain.Build.class,null,null),
    CASE_HISTORY ("CaseHistory","用例执行历史",cn.ibizlab.plm.core.testmgmt.domain.CaseHistory.class,cn.ibizlab.plm.core.testmgmt.filter.CaseHistorySearchContext.class,cn.ibizlab.plm.core.testmgmt.service.CaseHistoryService.class),
    CATEGORY ("Category","类别",cn.ibizlab.plm.core.base.domain.Category.class,cn.ibizlab.plm.core.base.filter.CategorySearchContext.class,cn.ibizlab.plm.core.base.service.CategoryService.class),
    CHANNEL ("Channel","工单渠道",cn.ibizlab.plm.core.prodmgmt.domain.Channel.class,cn.ibizlab.plm.core.prodmgmt.filter.ChannelSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.ChannelService.class),
    COMMENT ("Comment","评论",cn.ibizlab.plm.core.base.domain.Comment.class,cn.ibizlab.plm.core.base.filter.CommentSearchContext.class,cn.ibizlab.plm.core.base.service.CommentService.class),
    COMMIT ("Commit","代码提交",cn.ibizlab.plm.core.devops.domain.Commit.class,cn.ibizlab.plm.core.devops.filter.CommitSearchContext.class,cn.ibizlab.plm.core.devops.service.CommitService.class),
    COMMON_FLOW ("CommonFlow","通用规则",cn.ibizlab.plm.core.base.domain.CommonFlow.class,null,null),
    CUSTOMER ("Customer","客户",cn.ibizlab.plm.core.prodmgmt.domain.Customer.class,cn.ibizlab.plm.core.prodmgmt.filter.CustomerSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.CustomerService.class),
    DATA_SYNC_TASK ("DataSyncTask","数据同步任务",cn.ibizlab.plm.core.base.domain.DataSyncTask.class,cn.ibizlab.plm.core.base.filter.DataSyncTaskSearchContext.class,cn.ibizlab.plm.core.base.service.DataSyncTaskService.class),
    DAY_CAPACITY ("DayCapacity","日容量",cn.ibizlab.plm.core.projmgmt.domain.DayCapacity.class,null,null),
    DELIVERABLE ("Deliverable","交付物",cn.ibizlab.plm.core.base.domain.Deliverable.class,cn.ibizlab.plm.core.base.filter.DeliverableSearchContext.class,cn.ibizlab.plm.core.base.service.DeliverableService.class),
    DEPARTMENT ("Department","部门",cn.ibizlab.plm.core.base.domain.Department.class,null,null),
    DICTIONARY_DATA ("DictionaryData","数据字典",cn.ibizlab.plm.core.base.domain.DictionaryData.class,cn.ibizlab.plm.core.base.filter.DictionaryDataSearchContext.class,cn.ibizlab.plm.core.base.service.DictionaryDataService.class),
    DISCUSS_MEMBER ("DiscussMember","协作成员",cn.ibizlab.plm.core.team.domain.DiscussMember.class,cn.ibizlab.plm.core.team.filter.DiscussMemberSearchContext.class,cn.ibizlab.plm.core.team.service.DiscussMemberService.class),
    DISCUSS_POST ("DiscussPost","讨论",cn.ibizlab.plm.core.team.domain.DiscussPost.class,cn.ibizlab.plm.core.team.filter.DiscussPostSearchContext.class,cn.ibizlab.plm.core.team.service.DiscussPostService.class),
    DISCUSS_REPLY ("DiscussReply","讨论回复",cn.ibizlab.plm.core.team.domain.DiscussReply.class,cn.ibizlab.plm.core.team.filter.DiscussReplySearchContext.class,cn.ibizlab.plm.core.team.service.DiscussReplyService.class),
    DISCUSS_TOPIC ("DiscussTopic","话题",cn.ibizlab.plm.core.team.domain.DiscussTopic.class,cn.ibizlab.plm.core.team.filter.DiscussTopicSearchContext.class,cn.ibizlab.plm.core.team.service.DiscussTopicService.class),
    DYNA_APPMENU ("DynaAppmenu","动态应用菜单",cn.ibizlab.plm.core.base.domain.DynaAppmenu.class,cn.ibizlab.plm.core.base.filter.DynaAppmenuSearchContext.class,cn.ibizlab.plm.core.base.service.DynaAppmenuService.class),
    DYNA_DASHBOARD ("DynaDashboard","动态数据看板",cn.ibizlab.plm.core.base.domain.DynaDashboard.class,cn.ibizlab.plm.core.base.filter.DynaDashboardSearchContext.class,cn.ibizlab.plm.core.base.service.DynaDashboardService.class),
    DYNA_PORTLET_SETTING ("DynaPortletSetting","动态看板部件配置",cn.ibizlab.plm.core.base.domain.DynaPortletSetting.class,null,null),
    ENTRY ("Entry","看板栏",cn.ibizlab.plm.core.projmgmt.domain.Entry.class,cn.ibizlab.plm.core.projmgmt.filter.EntrySearchContext.class,cn.ibizlab.plm.core.projmgmt.service.EntryService.class),
    EXECUTOR ("Executor","执行人",cn.ibizlab.plm.core.base.domain.Executor.class,cn.ibizlab.plm.core.base.filter.ExecutorSearchContext.class,cn.ibizlab.plm.core.base.service.ExecutorService.class),
    EXTEND_LOG ("ExtendLog","扩展日志",cn.ibizlab.plm.core.base.domain.ExtendLog.class,cn.ibizlab.plm.core.base.filter.ExtendLogSearchContext.class,cn.ibizlab.plm.core.base.service.ExtendLogService.class),
    EXTEND_STORAGE ("ExtendStorage","扩展存储",cn.ibizlab.plm.core.base.domain.ExtendStorage.class,cn.ibizlab.plm.core.base.filter.ExtendStorageSearchContext.class,cn.ibizlab.plm.core.base.service.ExtendStorageService.class),
    FAVORITE ("Favorite","收藏",cn.ibizlab.plm.core.base.domain.Favorite.class,cn.ibizlab.plm.core.base.filter.FavoriteSearchContext.class,cn.ibizlab.plm.core.base.service.FavoriteService.class),
    GROUP ("Group","团队",cn.ibizlab.plm.core.base.domain.Group.class,cn.ibizlab.plm.core.base.filter.GroupSearchContext.class,cn.ibizlab.plm.core.base.service.GroupService.class),
    GUIDELINE ("Guideline","流程准则",cn.ibizlab.plm.core.testmgmt.domain.Guideline.class,cn.ibizlab.plm.core.testmgmt.filter.GuidelineSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.GuidelineService.class),
    IDEA ("Idea","需求",cn.ibizlab.plm.core.prodmgmt.domain.Idea.class,cn.ibizlab.plm.core.prodmgmt.filter.IdeaSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.IdeaService.class),
    IDEA_TEMPLATE ("IdeaTemplate","需求模板",cn.ibizlab.plm.core.prodmgmt.domain.IdeaTemplate.class,cn.ibizlab.plm.core.prodmgmt.filter.IdeaTemplateSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.IdeaTemplateService.class),
    INSIGHT ("Insight","洞察力",cn.ibizlab.plm.core.base.domain.Insight.class,cn.ibizlab.plm.core.base.filter.InsightSearchContext.class,cn.ibizlab.plm.core.base.service.InsightService.class),
    INSIGHT_MEMBER ("InsightMember","效能成员",cn.ibizlab.plm.core.insight.domain.InsightMember.class,cn.ibizlab.plm.core.insight.filter.InsightMemberSearchContext.class,cn.ibizlab.plm.core.insight.service.InsightMemberService.class),
    INSIGHT_REPORT ("InsightReport","效能报表",cn.ibizlab.plm.core.insight.domain.InsightReport.class,cn.ibizlab.plm.core.insight.filter.InsightReportSearchContext.class,cn.ibizlab.plm.core.insight.service.InsightReportService.class),
    INSIGHT_VIEW ("InsightView","效能视图",cn.ibizlab.plm.core.insight.domain.InsightView.class,cn.ibizlab.plm.core.insight.filter.InsightViewSearchContext.class,cn.ibizlab.plm.core.insight.service.InsightViewService.class),
    JOB ("Job","岗位",cn.ibizlab.plm.core.base.domain.Job.class,null,null),
    KEY_RESULT ("KeyResult","关键结果",cn.ibizlab.plm.core.team.domain.KeyResult.class,cn.ibizlab.plm.core.team.filter.KeyResultSearchContext.class,cn.ibizlab.plm.core.team.service.KeyResultService.class),
    LIBRARY ("Library","测试库",cn.ibizlab.plm.core.testmgmt.domain.Library.class,cn.ibizlab.plm.core.testmgmt.filter.LibrarySearchContext.class,cn.ibizlab.plm.core.testmgmt.service.LibraryService.class),
    LIBRARY_MEMBER ("LibraryMember","测试库成员",cn.ibizlab.plm.core.testmgmt.domain.LibraryMember.class,cn.ibizlab.plm.core.testmgmt.filter.LibraryMemberSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.LibraryMemberService.class),
    LOCAL_DEPARTMENT ("LocalDepartment","部门",cn.ibizlab.plm.core.base.domain.LocalDepartment.class,cn.ibizlab.plm.core.base.filter.LocalDepartmentSearchContext.class,cn.ibizlab.plm.core.base.service.LocalDepartmentService.class),
    LOCAL_USER ("LocalUser","企业用户",cn.ibizlab.plm.core.base.domain.LocalUser.class,cn.ibizlab.plm.core.base.filter.LocalUserSearchContext.class,cn.ibizlab.plm.core.base.service.LocalUserService.class),
    LOGIN_LOG ("LoginLog","登录日志",cn.ibizlab.plm.core.base.domain.LoginLog.class,null,null),
    MANAGEMENT ("Management","后台管理",cn.ibizlab.plm.core.base.domain.Management.class,null,null),
    MEMBER ("Member","成员",cn.ibizlab.plm.core.base.domain.Member.class,cn.ibizlab.plm.core.base.filter.MemberSearchContext.class,cn.ibizlab.plm.core.base.service.MemberService.class),
    NOTIFY_EVENT ("NotifyEvent","通知事件",cn.ibizlab.plm.core.extension.domain.NotifyEvent.class,null,null),
    NOTIFY_SETTING ("NotifySetting","通知设置",cn.ibizlab.plm.core.base.domain.NotifySetting.class,null,null),
    OBJECTIVE ("Objective","目标",cn.ibizlab.plm.core.team.domain.Objective.class,cn.ibizlab.plm.core.team.filter.ObjectiveSearchContext.class,cn.ibizlab.plm.core.team.service.ObjectiveService.class),
    ORGANIZATION ("Organization","组织",cn.ibizlab.plm.core.base.domain.Organization.class,null,null),
    PAGE_VERSION ("PageVersion","页面版本",cn.ibizlab.plm.core.wiki.domain.PageVersion.class,cn.ibizlab.plm.core.wiki.filter.PageVersionSearchContext.class,cn.ibizlab.plm.core.wiki.service.PageVersionService.class),
    PARAMETER ("Parameter","系统参数",cn.ibizlab.plm.core.base.domain.Parameter.class,cn.ibizlab.plm.core.base.filter.ParameterSearchContext.class,cn.ibizlab.plm.core.base.service.ParameterService.class),
    PERIOD ("Period","周期",cn.ibizlab.plm.core.team.domain.Period.class,cn.ibizlab.plm.core.team.filter.PeriodSearchContext.class,cn.ibizlab.plm.core.team.service.PeriodService.class),
    PORTFOLIO ("Portfolio","文件夹",cn.ibizlab.plm.core.base.domain.Portfolio.class,cn.ibizlab.plm.core.base.filter.PortfolioSearchContext.class,cn.ibizlab.plm.core.base.service.PortfolioService.class),
    PORTFOLIO_MEMBER ("PortfolioMember","文件夹成员",cn.ibizlab.plm.core.base.domain.PortfolioMember.class,cn.ibizlab.plm.core.base.filter.PortfolioMemberSearchContext.class,cn.ibizlab.plm.core.base.service.PortfolioMemberService.class),
    POSITION ("Position","职位",cn.ibizlab.plm.core.base.domain.Position.class,cn.ibizlab.plm.core.base.filter.PositionSearchContext.class,cn.ibizlab.plm.core.base.service.PositionService.class),
    PRODUCT ("Product","产品",cn.ibizlab.plm.core.prodmgmt.domain.Product.class,cn.ibizlab.plm.core.prodmgmt.filter.ProductSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.ProductService.class),
    PRODUCT_MEMBER ("ProductMember","产品成员",cn.ibizlab.plm.core.prodmgmt.domain.ProductMember.class,cn.ibizlab.plm.core.prodmgmt.filter.ProductMemberSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.ProductMemberService.class),
    PRODUCT_PLAN ("ProductPlan","排期",cn.ibizlab.plm.core.prodmgmt.domain.ProductPlan.class,cn.ibizlab.plm.core.prodmgmt.filter.ProductPlanSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.ProductPlanService.class),
    PRODUCT_TAG ("ProductTag","产品标签",cn.ibizlab.plm.core.prodmgmt.domain.ProductTag.class,cn.ibizlab.plm.core.prodmgmt.filter.ProductTagSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.ProductTagService.class),
    PRODUCT_TICKET_TYPE ("ProductTicketType","产品工单类型",cn.ibizlab.plm.core.prodmgmt.domain.ProductTicketType.class,cn.ibizlab.plm.core.prodmgmt.filter.ProductTicketTypeSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.ProductTicketTypeService.class),
    PROGRESS ("Progress","项目进度",cn.ibizlab.plm.core.projmgmt.domain.Progress.class,cn.ibizlab.plm.core.projmgmt.filter.ProgressSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.ProgressService.class),
    PROJECT ("Project","项目",cn.ibizlab.plm.core.projmgmt.domain.Project.class,cn.ibizlab.plm.core.projmgmt.filter.ProjectSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.ProjectService.class),
    PROJECT_MEMBER ("ProjectMember","项目成员",cn.ibizlab.plm.core.projmgmt.domain.ProjectMember.class,cn.ibizlab.plm.core.projmgmt.filter.ProjectMemberSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.ProjectMemberService.class),
    PROJECT_STATE ("ProjectState","项目状态",cn.ibizlab.plm.core.projmgmt.domain.ProjectState.class,cn.ibizlab.plm.core.projmgmt.filter.ProjectStateSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.ProjectStateService.class),
    PROJECT_TAG ("ProjectTag","项目标签",cn.ibizlab.plm.core.projmgmt.domain.ProjectTag.class,cn.ibizlab.plm.core.projmgmt.filter.ProjectTagSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.ProjectTagService.class),
    PULL_REQUEST ("PullRequest","拉取提交",cn.ibizlab.plm.core.devops.domain.PullRequest.class,cn.ibizlab.plm.core.devops.filter.PullRequestSearchContext.class,cn.ibizlab.plm.core.devops.service.PullRequestService.class),
    RECENT ("Recent","最近访问",cn.ibizlab.plm.core.base.domain.Recent.class,cn.ibizlab.plm.core.base.filter.RecentSearchContext.class,cn.ibizlab.plm.core.base.service.RecentService.class),
    REFERENCES_INDEX ("ReferencesIndex","引用索引",cn.ibizlab.plm.core.base.domain.ReferencesIndex.class,cn.ibizlab.plm.core.base.filter.ReferencesIndexSearchContext.class,cn.ibizlab.plm.core.base.service.ReferencesIndexService.class),
    RELATION ("Relation","关联",cn.ibizlab.plm.core.base.domain.Relation.class,cn.ibizlab.plm.core.base.filter.RelationSearchContext.class,cn.ibizlab.plm.core.base.service.RelationService.class),
    RELEASE ("Release","项目发布",cn.ibizlab.plm.core.projmgmt.domain.Release.class,cn.ibizlab.plm.core.projmgmt.filter.ReleaseSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.ReleaseService.class),
    REPOSITORY ("Repository","代码仓库",cn.ibizlab.plm.core.devops.domain.Repository.class,null,null),
    RESOURCE_MEMBER ("ResourceMember","资源组件成员",cn.ibizlab.plm.core.base.domain.ResourceMember.class,null,null),
    REVIEW ("Review","评审",cn.ibizlab.plm.core.testmgmt.domain.Review.class,cn.ibizlab.plm.core.testmgmt.filter.ReviewSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.ReviewService.class),
    REVIEW_ACTION_RULE ("ReviewActionRule","评审后置动作",cn.ibizlab.plm.core.testmgmt.domain.ReviewActionRule.class,null,null),
    REVIEW_CONTENT ("ReviewContent","评审内容",cn.ibizlab.plm.core.testmgmt.domain.ReviewContent.class,cn.ibizlab.plm.core.testmgmt.filter.ReviewContentSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.ReviewContentService.class),
    REVIEW_CONTENT_EXTEND ("ReviewContentExtend","评审内容扩展",cn.ibizlab.plm.core.testmgmt.domain.ReviewContentExtend.class,cn.ibizlab.plm.core.testmgmt.filter.ReviewContentExtendSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.ReviewContentExtendService.class),
    REVIEW_RESULT ("ReviewResult","评审结果",cn.ibizlab.plm.core.testmgmt.domain.ReviewResult.class,cn.ibizlab.plm.core.testmgmt.filter.ReviewResultSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.ReviewResultService.class),
    REVIEW_RULE ("ReviewRule","评审规则",cn.ibizlab.plm.core.testmgmt.domain.ReviewRule.class,null,null),
    REVIEW_STAGE ("ReviewStage","评审阶段",cn.ibizlab.plm.core.testmgmt.domain.ReviewStage.class,null,null),
    REVIEW_WIZARD ("ReviewWizard","评审向导",cn.ibizlab.plm.core.testmgmt.domain.ReviewWizard.class,cn.ibizlab.plm.core.testmgmt.filter.ReviewWizardSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.ReviewWizardService.class),
    ROLE_MEMBER ("RoleMember","系统角色成员",cn.ibizlab.plm.core.base.domain.RoleMember.class,null,null),
    RUN ("Run","执行用例",cn.ibizlab.plm.core.testmgmt.domain.Run.class,cn.ibizlab.plm.core.testmgmt.filter.RunSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.RunService.class),
    RUN_ATTACHMENT ("RunAttachment","执行用例结果附件",cn.ibizlab.plm.core.testmgmt.domain.RunAttachment.class,cn.ibizlab.plm.core.testmgmt.filter.RunAttachmentSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.RunAttachmentService.class),
    RUN_HISTORY ("RunHistory","执行结果",cn.ibizlab.plm.core.testmgmt.domain.RunHistory.class,cn.ibizlab.plm.core.testmgmt.filter.RunHistorySearchContext.class,cn.ibizlab.plm.core.testmgmt.service.RunHistoryService.class),
    SCM_REVIEW ("ScmReview","代码评审",cn.ibizlab.plm.core.devops.domain.ScmReview.class,cn.ibizlab.plm.core.devops.filter.ScmReviewSearchContext.class,cn.ibizlab.plm.core.devops.service.ScmReviewService.class),
    SEARCH_ATTACHMENT ("SearchAttachment","附件搜索",cn.ibizlab.plm.core.base.domain.SearchAttachment.class,cn.ibizlab.plm.core.base.filter.SearchAttachmentSearchContext.class,cn.ibizlab.plm.core.base.service.SearchAttachmentService.class),
    SEARCH_COMMENT ("SearchComment","评论搜索",cn.ibizlab.plm.core.base.domain.SearchComment.class,cn.ibizlab.plm.core.base.filter.SearchCommentSearchContext.class,cn.ibizlab.plm.core.base.service.SearchCommentService.class),
    SEARCH_HUB ("SearchHub","检索中心",cn.ibizlab.plm.core.ftr.domain.SearchHub.class,null,null),
    SECTION ("Section","分组",cn.ibizlab.plm.core.base.domain.Section.class,cn.ibizlab.plm.core.base.filter.SectionSearchContext.class,cn.ibizlab.plm.core.base.service.SectionService.class),
    SEQUENCE_GENERATOR ("SequenceGenerator","序列",cn.ibizlab.plm.core.base.domain.SequenceGenerator.class,cn.ibizlab.plm.core.base.filter.SequenceGeneratorSearchContext.class,cn.ibizlab.plm.core.base.service.SequenceGeneratorService.class),
    SHARED_SPACE ("SharedSpace","共享空间",cn.ibizlab.plm.core.wiki.domain.SharedSpace.class,cn.ibizlab.plm.core.wiki.filter.SharedSpaceSearchContext.class,cn.ibizlab.plm.core.wiki.service.SharedSpaceService.class),
    SPACE ("Space","空间",cn.ibizlab.plm.core.wiki.domain.Space.class,cn.ibizlab.plm.core.wiki.filter.SpaceSearchContext.class,cn.ibizlab.plm.core.wiki.service.SpaceService.class),
    SPACE_MEMBER ("SpaceMember","空间成员",cn.ibizlab.plm.core.wiki.domain.SpaceMember.class,cn.ibizlab.plm.core.wiki.filter.SpaceMemberSearchContext.class,cn.ibizlab.plm.core.wiki.service.SpaceMemberService.class),
    SPRINT ("Sprint","迭代",cn.ibizlab.plm.core.projmgmt.domain.Sprint.class,cn.ibizlab.plm.core.projmgmt.filter.SprintSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.SprintService.class),
    SPRINT_ALTERATION ("SprintAlteration","迭代变更",cn.ibizlab.plm.core.projmgmt.domain.SprintAlteration.class,cn.ibizlab.plm.core.projmgmt.filter.SprintAlterationSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.SprintAlterationService.class),
    STAGE ("Stage","发布阶段",cn.ibizlab.plm.core.projmgmt.domain.Stage.class,cn.ibizlab.plm.core.projmgmt.filter.StageSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.StageService.class),
    STENCIL ("Stencil","页面模板",cn.ibizlab.plm.core.wiki.domain.Stencil.class,cn.ibizlab.plm.core.wiki.filter.StencilSearchContext.class,cn.ibizlab.plm.core.wiki.service.StencilService.class),
    STEP ("Step","用例步骤",cn.ibizlab.plm.core.testmgmt.domain.Step.class,null,null),
    SWIMLANE ("Swimlane","泳道",cn.ibizlab.plm.core.projmgmt.domain.Swimlane.class,cn.ibizlab.plm.core.projmgmt.filter.SwimlaneSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.SwimlaneService.class),
    SYS_PERSON ("SysPerson","人员",cn.ibizlab.plm.core.ibizsysmgr.domain.SysPerson.class,cn.ibizlab.plm.core.ibizsysmgr.filter.SysPersonSearchContext.class,cn.ibizlab.plm.core.ibizsysmgr.service.SysPersonService.class),
    SYS_ROLE ("SysRole","系统角色",cn.ibizlab.plm.core.ibizsysmgr.domain.SysRole.class,cn.ibizlab.plm.core.ibizsysmgr.filter.SysRoleSearchContext.class,cn.ibizlab.plm.core.ibizsysmgr.service.SysRoleService.class),
    SYS_ROLE_MEMBER ("SysRoleMember","系统角色成员",cn.ibizlab.plm.core.ibizsysmgr.domain.SysRoleMember.class,cn.ibizlab.plm.core.ibizsysmgr.filter.SysRoleMemberSearchContext.class,cn.ibizlab.plm.core.ibizsysmgr.service.SysRoleMemberService.class),
    SYSTEM_EXTENSION_NOTIFY_SETTING ("SystemExtensionNotifySetting","通知设置",cn.ibizlab.plm.core.extension.domain.SystemExtensionNotifySetting.class,cn.ibizlab.plm.core.extension.filter.SystemExtensionNotifySettingSearchContext.class,cn.ibizlab.plm.core.extension.service.SystemExtensionNotifySettingService.class),
    TEAM ("Team","企业",cn.ibizlab.plm.core.base.domain.Team.class,null,null),
    TEMPLATE_FLOW ("TemplateFlow","规则模板",cn.ibizlab.plm.core.base.domain.TemplateFlow.class,null,null),
    TEST_CASE ("TestCase","用例",cn.ibizlab.plm.core.testmgmt.domain.TestCase.class,cn.ibizlab.plm.core.testmgmt.filter.TestCaseSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.TestCaseService.class),
    TEST_CASE_TEMPLATE ("TestCaseTemplate","用例模板",cn.ibizlab.plm.core.testmgmt.domain.TestCaseTemplate.class,cn.ibizlab.plm.core.testmgmt.filter.TestCaseTemplateSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.TestCaseTemplateService.class),
    TEST_PLAN ("TestPlan","测试计划",cn.ibizlab.plm.core.testmgmt.domain.TestPlan.class,cn.ibizlab.plm.core.testmgmt.filter.TestPlanSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.TestPlanService.class),
    TEST_SUITE ("TestSuite","用例模块",cn.ibizlab.plm.core.testmgmt.domain.TestSuite.class,cn.ibizlab.plm.core.testmgmt.filter.TestSuiteSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.TestSuiteService.class),
    TICKET ("Ticket","工单",cn.ibizlab.plm.core.prodmgmt.domain.Ticket.class,cn.ibizlab.plm.core.prodmgmt.filter.TicketSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.TicketService.class),
    TICKET_TYPE ("TicketType","工单类型",cn.ibizlab.plm.core.prodmgmt.domain.TicketType.class,cn.ibizlab.plm.core.prodmgmt.filter.TicketTypeSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.TicketTypeService.class),
    TRANSITION_HISTORY ("TransitionHistory","流转记录",cn.ibizlab.plm.core.projmgmt.domain.TransitionHistory.class,cn.ibizlab.plm.core.projmgmt.filter.TransitionHistorySearchContext.class,cn.ibizlab.plm.core.projmgmt.service.TransitionHistoryService.class),
    UPDATE_RECORD ("UpdateRecord","进展",cn.ibizlab.plm.core.team.domain.UpdateRecord.class,cn.ibizlab.plm.core.team.filter.UpdateRecordSearchContext.class,cn.ibizlab.plm.core.team.service.UpdateRecordService.class),
    USER ("User","企业用户",cn.ibizlab.plm.core.base.domain.User.class,null,null),
    VERSION ("Version","版本",cn.ibizlab.plm.core.base.domain.Version.class,cn.ibizlab.plm.core.base.filter.VersionSearchContext.class,cn.ibizlab.plm.core.base.service.VersionService.class),
    VERSION_DATA ("VersionData","附加数据版本",cn.ibizlab.plm.core.base.domain.VersionData.class,cn.ibizlab.plm.core.base.filter.VersionDataSearchContext.class,cn.ibizlab.plm.core.base.service.VersionDataService.class),
    VIEW_THEME_SETTING ("ViewThemeSetting","视图主题设置",cn.ibizlab.plm.core.base.domain.ViewThemeSetting.class,null,null),
    WORK ("Work","工作",cn.ibizlab.plm.core.base.domain.Work.class,cn.ibizlab.plm.core.base.filter.WorkSearchContext.class,cn.ibizlab.plm.core.base.service.WorkService.class),
    WORK_ITEM ("WorkItem","工作项",cn.ibizlab.plm.core.projmgmt.domain.WorkItem.class,cn.ibizlab.plm.core.projmgmt.filter.WorkItemSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.WorkItemService.class),
    WORK_ITEM_STATE ("WorkItemState","工作项状态",cn.ibizlab.plm.core.projmgmt.domain.WorkItemState.class,cn.ibizlab.plm.core.projmgmt.filter.WorkItemStateSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.WorkItemStateService.class),
    WORK_ITEM_TYPE ("WorkItemType","工作项类型",cn.ibizlab.plm.core.projmgmt.domain.WorkItemType.class,cn.ibizlab.plm.core.projmgmt.filter.WorkItemTypeSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.WorkItemTypeService.class),
    WORK_ITEM_WIZARD ("WorkItemWizard","工作项操作向导",cn.ibizlab.plm.core.projmgmt.domain.WorkItemWizard.class,null,null),
    WORK_ITEM_WIZARD_DETAIL ("WorkItemWizardDetail","工作项操作向导明细",cn.ibizlab.plm.core.projmgmt.domain.WorkItemWizardDetail.class,null,null),
    WORKLOAD ("Workload","工时",cn.ibizlab.plm.core.base.domain.Workload.class,cn.ibizlab.plm.core.base.filter.WorkloadSearchContext.class,cn.ibizlab.plm.core.base.service.WorkloadService.class),
    WORKLOAD_TYPE ("WorkloadType","工时类别",cn.ibizlab.plm.core.base.domain.WorkloadType.class,cn.ibizlab.plm.core.base.filter.WorkloadTypeSearchContext.class,cn.ibizlab.plm.core.base.service.WorkloadTypeService.class),
    WORKSPACE ("Workspace","工作台",cn.ibizlab.plm.core.base.domain.Workspace.class,null,null);

    public final String codeName;
    public final String displayName;
    public final Class<? extends IEntity> entityClass;
    public final Class<? extends ISearchContext> filterClass;
    public final Class<?> serviceClass;

    public BeanCache.BeanSchema getSchema() {
        return BeanCache.get(entityClass);
    }

    @SneakyThrows
    public IEntity newEntityInstance() {
        return entityClass.newInstance();
    }

    @SneakyThrows
    public ISearchContext newFilterInstance() {
        return filterClass.newInstance();
    }

    @SneakyThrows
    public <T> T getService() {
        return (T) SpringContextHolder.getBean(serviceClass);
    }

    private Entities(String codeName, String displayName, Class<? extends IEntity> entityClass, Class<? extends ISearchContext> filterClass, Class serviceClass){
        this.codeName = codeName;
        this.displayName = displayName;
        this.entityClass = entityClass;
        this.filterClass = filterClass;
        this.serviceClass = serviceClass;
    }

    public static Optional<Entities> from(String codeName) {
        return Arrays.stream(Entities.values()).filter(item -> item.codeName.equalsIgnoreCase(codeName)||item.name().equalsIgnoreCase(codeName)||item.codeName.equalsIgnoreCase(codeName.replace("_",""))||item.name().equalsIgnoreCase(codeName+"DTO")||item.name().equalsIgnoreCase(codeName+"FilterDTO")).findFirst();
    }

    @Override
    public String toString() {
        return codeName;
    }

    public boolean equals(String codeName) {
        return this.codeName.equalsIgnoreCase(codeName)||this.name().equalsIgnoreCase(codeName)||this.codeName.equalsIgnoreCase(codeName.replace("_",""));
    }
}