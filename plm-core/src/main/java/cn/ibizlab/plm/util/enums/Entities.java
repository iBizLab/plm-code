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
    MS_VALUE_PROXY ("MSValueProxy","主状态值代理",cn.ibizlab.plm.core.base.domain.MSValueProxy.class,null,null),
    PSDE_DATAFLOW ("PSDEDataflow","实体数据流逻辑",cn.ibizlab.plm.core.extension.domain.PSDEDataflow.class,null,null),
    PSDE_FIELD ("PSDEField","实体属性",cn.ibizlab.plm.core.extension.domain.PSDEField.class,null,null),
    PSDE_FORM ("PSDEForm","实体表单",cn.ibizlab.plm.core.extension.domain.PSDEForm.class,null,null),
    PSDE_GRID ("PSDEGrid","实体表格",cn.ibizlab.plm.core.extension.domain.PSDEGrid.class,null,null),
    PSDE_LOGIC ("PSDELogic","实体处理逻辑",cn.ibizlab.plm.core.extension.domain.PSDELogic.class,null,null),
    PSDEMS_LOGIC ("PSDEMSLogic","实体主状态迁移逻辑",cn.ibizlab.plm.core.extension.domain.PSDEMSLogic.class,null,null),
    PSDE_NOTIFY ("PSDENotify","实体通知",cn.ibizlab.plm.core.extension.domain.PSDENotify.class,null,null),
    PSDE_NOTIFY_TARGET ("PSDENotifyTarget","消息通知目标",cn.ibizlab.plm.core.extension.domain.PSDENotifyTarget.class,null,null),
    PSWF_VERSION ("PSWFVersion","工作流版本",cn.ibizlab.plm.core.extension.domain.PSWFVersion.class,null,null),
    PS_WORKFLOW ("PSWorkflow","工作流",cn.ibizlab.plm.core.extension.domain.PSWorkflow.class,null,null),
    SYS_DEPARTMENT ("SysDepartment","部门",cn.ibizlab.plm.core.ebsx.domain.SysDepartment.class,cn.ibizlab.plm.core.ebsx.filter.SysDepartmentSearchContext.class,cn.ibizlab.plm.core.ebsx.service.SysDepartmentService.class),
    SYS_EMPLOYEE ("SysEmployee","人员",cn.ibizlab.plm.core.ebsx.domain.SysEmployee.class,cn.ibizlab.plm.core.ebsx.filter.SysEmployeeSearchContext.class,cn.ibizlab.plm.core.ebsx.service.SysEmployeeService.class),
    ACTIVITY ("Activity","活动",cn.ibizlab.plm.core.base.domain.Activity.class,cn.ibizlab.plm.core.base.filter.ActivitySearchContext.class,cn.ibizlab.plm.core.base.service.ActivityService.class),
    ARTICLE_PAGE ("ArticlePage","页面",cn.ibizlab.plm.core.wiki.domain.ArticlePage.class,cn.ibizlab.plm.core.wiki.filter.ArticlePageSearchContext.class,cn.ibizlab.plm.core.wiki.service.ArticlePageService.class),
    ATTACHMENT ("Attachment","附件",cn.ibizlab.plm.core.base.domain.Attachment.class,cn.ibizlab.plm.core.base.filter.AttachmentSearchContext.class,cn.ibizlab.plm.core.base.service.AttachmentService.class),
    ATTENTION ("Attention","关注",cn.ibizlab.plm.core.base.domain.Attention.class,cn.ibizlab.plm.core.base.filter.AttentionSearchContext.class,cn.ibizlab.plm.core.base.service.AttentionService.class),
    BASELINE ("Baseline","基线",cn.ibizlab.plm.core.base.domain.Baseline.class,cn.ibizlab.plm.core.base.filter.BaselineSearchContext.class,cn.ibizlab.plm.core.base.service.BaselineService.class),
    BOARD ("Board","看板",cn.ibizlab.plm.core.projmgmt.domain.Board.class,cn.ibizlab.plm.core.projmgmt.filter.BoardSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.BoardService.class),
    CASE_HISTORY ("CaseHistory","用例执行历史",cn.ibizlab.plm.core.testmgmt.domain.CaseHistory.class,cn.ibizlab.plm.core.testmgmt.filter.CaseHistorySearchContext.class,cn.ibizlab.plm.core.testmgmt.service.CaseHistoryService.class),
    CATEGORY ("Category","类别",cn.ibizlab.plm.core.base.domain.Category.class,cn.ibizlab.plm.core.base.filter.CategorySearchContext.class,cn.ibizlab.plm.core.base.service.CategoryService.class),
    CHANNEL ("Channel","工单渠道",cn.ibizlab.plm.core.prodmgmt.domain.Channel.class,cn.ibizlab.plm.core.prodmgmt.filter.ChannelSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.ChannelService.class),
    COMMENT ("Comment","评论",cn.ibizlab.plm.core.base.domain.Comment.class,cn.ibizlab.plm.core.base.filter.CommentSearchContext.class,cn.ibizlab.plm.core.base.service.CommentService.class),
    COMMON_FLOW ("CommonFlow","通用规则",cn.ibizlab.plm.core.base.domain.CommonFlow.class,null,null),
    CUSTOMER ("Customer","客户",cn.ibizlab.plm.core.prodmgmt.domain.Customer.class,cn.ibizlab.plm.core.prodmgmt.filter.CustomerSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.CustomerService.class),
    DAY_CAPACITY ("DayCapacity","日容量",cn.ibizlab.plm.core.projmgmt.domain.DayCapacity.class,null,null),
    DELIVERABLE ("Deliverable","交付物",cn.ibizlab.plm.core.base.domain.Deliverable.class,cn.ibizlab.plm.core.base.filter.DeliverableSearchContext.class,cn.ibizlab.plm.core.base.service.DeliverableService.class),
    DEPARTMENT ("Department","部门",cn.ibizlab.plm.core.base.domain.Department.class,null,null),
    DYNA_DASHBOARD ("DynaDashboard","动态数据看板",cn.ibizlab.plm.core.base.domain.DynaDashboard.class,cn.ibizlab.plm.core.base.filter.DynaDashboardSearchContext.class,cn.ibizlab.plm.core.base.service.DynaDashboardService.class),
    ENTRY ("Entry","看板栏",cn.ibizlab.plm.core.projmgmt.domain.Entry.class,cn.ibizlab.plm.core.projmgmt.filter.EntrySearchContext.class,cn.ibizlab.plm.core.projmgmt.service.EntryService.class),
    EXTEND_LOG ("ExtendLog","扩展日志",cn.ibizlab.plm.core.base.domain.ExtendLog.class,cn.ibizlab.plm.core.base.filter.ExtendLogSearchContext.class,cn.ibizlab.plm.core.base.service.ExtendLogService.class),
    EXTEND_STORAGE ("ExtendStorage","扩展存储",cn.ibizlab.plm.core.base.domain.ExtendStorage.class,cn.ibizlab.plm.core.base.filter.ExtendStorageSearchContext.class,cn.ibizlab.plm.core.base.service.ExtendStorageService.class),
    FAVORITE ("Favorite","收藏",cn.ibizlab.plm.core.base.domain.Favorite.class,cn.ibizlab.plm.core.base.filter.FavoriteSearchContext.class,cn.ibizlab.plm.core.base.service.FavoriteService.class),
    GROUP ("Group","团队",cn.ibizlab.plm.core.base.domain.Group.class,null,null),
    IDEA ("Idea","需求",cn.ibizlab.plm.core.prodmgmt.domain.Idea.class,cn.ibizlab.plm.core.prodmgmt.filter.IdeaSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.IdeaService.class),
    INSIGHT ("Insight","洞察力",cn.ibizlab.plm.core.base.domain.Insight.class,cn.ibizlab.plm.core.base.filter.InsightSearchContext.class,cn.ibizlab.plm.core.base.service.InsightService.class),
    JOB ("Job","岗位",cn.ibizlab.plm.core.base.domain.Job.class,null,null),
    LIBRARY ("Library","测试库",cn.ibizlab.plm.core.testmgmt.domain.Library.class,cn.ibizlab.plm.core.testmgmt.filter.LibrarySearchContext.class,cn.ibizlab.plm.core.testmgmt.service.LibraryService.class),
    LIBRARY_MEMBER ("LibraryMember","测试库成员",cn.ibizlab.plm.core.testmgmt.domain.LibraryMember.class,cn.ibizlab.plm.core.testmgmt.filter.LibraryMemberSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.LibraryMemberService.class),
    LOGIN_LOG ("LoginLog","登录日志",cn.ibizlab.plm.core.base.domain.LoginLog.class,null,null),
    MANAGEMENT ("Management","后台管理",cn.ibizlab.plm.core.base.domain.Management.class,null,null),
    MEMBER ("Member","成员",cn.ibizlab.plm.core.base.domain.Member.class,cn.ibizlab.plm.core.base.filter.MemberSearchContext.class,cn.ibizlab.plm.core.base.service.MemberService.class),
    NOTIFY_EVENT ("NotifyEvent","通知事件",cn.ibizlab.plm.core.extension.domain.NotifyEvent.class,null,null),
    NOTIFY_SETTING ("NotifySetting","通知设置",cn.ibizlab.plm.core.base.domain.NotifySetting.class,null,null),
    PORTFOLIO ("Portfolio","文件夹",cn.ibizlab.plm.core.base.domain.Portfolio.class,cn.ibizlab.plm.core.base.filter.PortfolioSearchContext.class,cn.ibizlab.plm.core.base.service.PortfolioService.class),
    PORTFOLIO_MEMBER ("PortfolioMember","文件夹成员",cn.ibizlab.plm.core.base.domain.PortfolioMember.class,cn.ibizlab.plm.core.base.filter.PortfolioMemberSearchContext.class,cn.ibizlab.plm.core.base.service.PortfolioMemberService.class),
    PRODUCT ("Product","产品",cn.ibizlab.plm.core.prodmgmt.domain.Product.class,cn.ibizlab.plm.core.prodmgmt.filter.ProductSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.ProductService.class),
    PRODUCT_MEMBER ("ProductMember","产品成员",cn.ibizlab.plm.core.prodmgmt.domain.ProductMember.class,cn.ibizlab.plm.core.prodmgmt.filter.ProductMemberSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.ProductMemberService.class),
    PRODUCT_PLAN ("ProductPlan","排期",cn.ibizlab.plm.core.prodmgmt.domain.ProductPlan.class,cn.ibizlab.plm.core.prodmgmt.filter.ProductPlanSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.ProductPlanService.class),
    PRODUCT_TAG ("ProductTag","产品标签",cn.ibizlab.plm.core.prodmgmt.domain.ProductTag.class,cn.ibizlab.plm.core.prodmgmt.filter.ProductTagSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.ProductTagService.class),
    PRODUCT_TICKET_TYPE ("ProductTicketType","产品工单类型",cn.ibizlab.plm.core.prodmgmt.domain.ProductTicketType.class,cn.ibizlab.plm.core.prodmgmt.filter.ProductTicketTypeSearchContext.class,cn.ibizlab.plm.core.prodmgmt.service.ProductTicketTypeService.class),
    PROGRESS ("Progress","项目进度",cn.ibizlab.plm.core.projmgmt.domain.Progress.class,cn.ibizlab.plm.core.projmgmt.filter.ProgressSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.ProgressService.class),
    PROJECT ("Project","项目",cn.ibizlab.plm.core.projmgmt.domain.Project.class,cn.ibizlab.plm.core.projmgmt.filter.ProjectSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.ProjectService.class),
    PROJECT_MEMBER ("ProjectMember","项目成员",cn.ibizlab.plm.core.projmgmt.domain.ProjectMember.class,cn.ibizlab.plm.core.projmgmt.filter.ProjectMemberSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.ProjectMemberService.class),
    PROJECT_TAG ("ProjectTag","项目标签",cn.ibizlab.plm.core.projmgmt.domain.ProjectTag.class,cn.ibizlab.plm.core.projmgmt.filter.ProjectTagSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.ProjectTagService.class),
    RECENT ("Recent","最近访问",cn.ibizlab.plm.core.base.domain.Recent.class,cn.ibizlab.plm.core.base.filter.RecentSearchContext.class,cn.ibizlab.plm.core.base.service.RecentService.class),
    REFERENCES_INDEX ("ReferencesIndex","引用索引",cn.ibizlab.plm.core.base.domain.ReferencesIndex.class,cn.ibizlab.plm.core.base.filter.ReferencesIndexSearchContext.class,cn.ibizlab.plm.core.base.service.ReferencesIndexService.class),
    RELATION ("Relation","关联",cn.ibizlab.plm.core.base.domain.Relation.class,cn.ibizlab.plm.core.base.filter.RelationSearchContext.class,cn.ibizlab.plm.core.base.service.RelationService.class),
    RELEASE ("Release","项目发布",cn.ibizlab.plm.core.projmgmt.domain.Release.class,cn.ibizlab.plm.core.projmgmt.filter.ReleaseSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.ReleaseService.class),
    REVIEW ("Review","评审",cn.ibizlab.plm.core.testmgmt.domain.Review.class,cn.ibizlab.plm.core.testmgmt.filter.ReviewSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.ReviewService.class),
    ROLE ("Role","角色",cn.ibizlab.plm.core.base.domain.Role.class,null,null),
    RUN ("Run","执行用例",cn.ibizlab.plm.core.testmgmt.domain.Run.class,cn.ibizlab.plm.core.testmgmt.filter.RunSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.RunService.class),
    RUN_ATTACHMENT ("RunAttachment","执行用例结果附件",cn.ibizlab.plm.core.testmgmt.domain.RunAttachment.class,cn.ibizlab.plm.core.testmgmt.filter.RunAttachmentSearchContext.class,cn.ibizlab.plm.core.testmgmt.service.RunAttachmentService.class),
    RUN_HISTORY ("RunHistory","执行结果",cn.ibizlab.plm.core.testmgmt.domain.RunHistory.class,cn.ibizlab.plm.core.testmgmt.filter.RunHistorySearchContext.class,cn.ibizlab.plm.core.testmgmt.service.RunHistoryService.class),
    SEARCH_ATTACHMENT ("SearchAttachment","附件搜索",cn.ibizlab.plm.core.base.domain.SearchAttachment.class,cn.ibizlab.plm.core.base.filter.SearchAttachmentSearchContext.class,cn.ibizlab.plm.core.base.service.SearchAttachmentService.class),
    SEARCH_COMMENT ("SearchComment","评论搜索",cn.ibizlab.plm.core.base.domain.SearchComment.class,cn.ibizlab.plm.core.base.filter.SearchCommentSearchContext.class,cn.ibizlab.plm.core.base.service.SearchCommentService.class),
    SEARCH_HUB ("SearchHub","检索中心",cn.ibizlab.plm.core.ftr.domain.SearchHub.class,cn.ibizlab.plm.core.ftr.filter.SearchHubSearchContext.class,cn.ibizlab.plm.core.ftr.service.SearchHubService.class),
    SECTION ("Section","分组",cn.ibizlab.plm.core.base.domain.Section.class,cn.ibizlab.plm.core.base.filter.SectionSearchContext.class,cn.ibizlab.plm.core.base.service.SectionService.class),
    SEQUENCE_GENERATOR ("SequenceGenerator","序列",cn.ibizlab.plm.core.base.domain.SequenceGenerator.class,cn.ibizlab.plm.core.base.filter.SequenceGeneratorSearchContext.class,cn.ibizlab.plm.core.base.service.SequenceGeneratorService.class),
    SPACE ("Space","空间",cn.ibizlab.plm.core.wiki.domain.Space.class,cn.ibizlab.plm.core.wiki.filter.SpaceSearchContext.class,cn.ibizlab.plm.core.wiki.service.SpaceService.class),
    SPACE_MEMBER ("SpaceMember","空间成员",cn.ibizlab.plm.core.wiki.domain.SpaceMember.class,cn.ibizlab.plm.core.wiki.filter.SpaceMemberSearchContext.class,cn.ibizlab.plm.core.wiki.service.SpaceMemberService.class),
    SPRINT ("Sprint","迭代",cn.ibizlab.plm.core.projmgmt.domain.Sprint.class,cn.ibizlab.plm.core.projmgmt.filter.SprintSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.SprintService.class),
    STAGE ("Stage","发布阶段",cn.ibizlab.plm.core.projmgmt.domain.Stage.class,cn.ibizlab.plm.core.projmgmt.filter.StageSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.StageService.class),
    STENCIL ("Stencil","页面模板",cn.ibizlab.plm.core.wiki.domain.Stencil.class,cn.ibizlab.plm.core.wiki.filter.StencilSearchContext.class,cn.ibizlab.plm.core.wiki.service.StencilService.class),
    STEP ("Step","用例步骤",cn.ibizlab.plm.core.testmgmt.domain.Step.class,null,null),
    SWIMLANE ("Swimlane","泳道",cn.ibizlab.plm.core.projmgmt.domain.Swimlane.class,cn.ibizlab.plm.core.projmgmt.filter.SwimlaneSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.SwimlaneService.class),
    SYS_PERSON ("SysPerson","人员",cn.ibizlab.plm.core.ibizsysmgr.domain.SysPerson.class,cn.ibizlab.plm.core.ibizsysmgr.filter.SysPersonSearchContext.class,cn.ibizlab.plm.core.ibizsysmgr.service.SysPersonService.class),
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
    USER ("User","企业用户",cn.ibizlab.plm.core.base.domain.User.class,null,null),
    VERSION ("Version","版本",cn.ibizlab.plm.core.base.domain.Version.class,cn.ibizlab.plm.core.base.filter.VersionSearchContext.class,cn.ibizlab.plm.core.base.service.VersionService.class),
    WORK ("Work","工作",cn.ibizlab.plm.core.base.domain.Work.class,cn.ibizlab.plm.core.base.filter.WorkSearchContext.class,cn.ibizlab.plm.core.base.service.WorkService.class),
    WORK_ITEM ("WorkItem","工作项",cn.ibizlab.plm.core.projmgmt.domain.WorkItem.class,cn.ibizlab.plm.core.projmgmt.filter.WorkItemSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.WorkItemService.class),
    WORK_ITEM_STATE ("WorkItemState","工作项状态",cn.ibizlab.plm.core.projmgmt.domain.WorkItemState.class,cn.ibizlab.plm.core.projmgmt.filter.WorkItemStateSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.WorkItemStateService.class),
    WORK_ITEM_TYPE ("WorkItemType","工作项类型",cn.ibizlab.plm.core.projmgmt.domain.WorkItemType.class,cn.ibizlab.plm.core.projmgmt.filter.WorkItemTypeSearchContext.class,cn.ibizlab.plm.core.projmgmt.service.WorkItemTypeService.class),
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