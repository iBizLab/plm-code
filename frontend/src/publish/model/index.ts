import { CodeListService } from '@ibiz-template/runtime';
import {
  IAppCodeList,
  IAppDataEntity,
  IApplication,
  IAppView,
} from '@ibiz/model-core';

export async function registerCodeList(
  codeListService: CodeListService,
): Promise<void> {
  const setCodeList = (model: IData) => {
    codeListService.setCodeList(model as IAppCodeList);
  };
  setCodeList(
    await import('./code-list/base-attention-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/base-baseline-status').then(m => m.default),
  );
  setCodeList(await import('./code-list/base-index-type').then(m => m.default));
  setCodeList(
    await import('./code-list/base-insight-group').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/base-recent-index').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/base-recent-type').then(m => m.default),
  );
  setCodeList(await import('./code-list/base-recent-use').then(m => m.default));
  setCodeList(
    await import('./code-list/base-recent-visite').then(m => m.default),
  );
  setCodeList(await import('./code-list/base-role-type').then(m => m.default));
  setCodeList(
    await import('./code-list/base-workload-type').then(m => m.default),
  );
  setCodeList(await import('./code-list/ftr-search-menu').then(m => m.default));
  setCodeList(
    await import('./code-list/prod-mgmt-category').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-customer-level').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-customer-sector').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-idea-advanced-search-field').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-idea-priority').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-idea-section').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-idea-state').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-product-list').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-product-tag').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-product-ticket-type').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-solutions').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-test-case-advanced-search-field').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-ticket-advanced-search-field').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-ticket-priority').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-ticket-state').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-usr-code-list-0122047845').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-cur-project-member').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-cur-sprint').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-defect-property-distribution').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-demand-sources').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-kanban-bar').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-notify-field').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-project-state').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-project-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-rep-days-0-to-30').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-reproduction-probability').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-requirement-type').then(m => m.default),
  );
  setCodeList(await import('./code-list/proj-mgmt-risk').then(m => m.default));
  setCodeList(
    await import('./code-list/proj-mgmt-scrum-state').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-severity').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-sprint-status').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-state-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-task-category').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-version-status').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-work-item-advanced-search-field').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-work-item-group-field').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-work-item-priority').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-work-item-state').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-work-item-state-2').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-work-item-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-work-item-type-group').then(
      m => m.default,
    ),
  );
  setCodeList(await import('./code-list/sys-operator').then(m => m.default));
  setCodeList(
    await import('./code-list/test-mgmt-cur-library-member').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/test-mgmt-library-list').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-library-member').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-rep-times-1-to-10').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/test-mgmt-run-status').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-test-case-level').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-test-case-state').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-test-case-test-type').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/test-mgmt-test-case-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-test-plan').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-test-plan-status').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-test-plan-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-test-suite').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/wiki-page-advanced-search-field').then(
      m => m.default,
    ),
  );
  setCodeList(await import('./code-list/wiki-page-type').then(m => m.default));
  setCodeList(
    await import('./code-list/wiki-stenci-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/wiki-stencil-scope').then(m => m.default),
  );
  setCodeList(await import('./code-list/yes-no').then(m => m.default));
  setCodeList(
    await import('./code-list/extension-de-logic-sub-type').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/extension-de-notify-sub-type').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/extension-de-notify-target-type').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/extension-wf-infom-msg-type').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/extension-enable-action').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/extension-extension-status').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/extension-log-state').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/extension-notify-event').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/extension-psdefield-dyna').then(m => m.default),
  );
  setCodeList(await import('./code-list/field-data-type').then(m => m.default));
  setCodeList(await import('./code-list/field-type').then(m => m.default));
  setCodeList(await import('./code-list/visibility').then(m => m.default));
}

export async function getAppDataEntityModel(
  name: string,
): Promise<IAppDataEntity> {
  const _name = name.toLowerCase();
  switch (_name) {
    case 'plmweb.workspace':
    case 'workspace':
      return import('./entities/workspace').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.library_member':
    case 'library_member':
      return import('./entities/library-member').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.baseline':
    case 'baseline':
      return import('./entities/baseline').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.psdeform':
    case 'psdeform':
      return import('./entities/psde-form').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.psdenotifytarget':
    case 'psdenotifytarget':
      return import('./entities/psde-notify-target').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.favorite':
    case 'favorite':
      return import('./entities/favorite').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.deliverable':
    case 'deliverable':
      return import('./entities/deliverable').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.management':
    case 'management':
      return import('./entities/management').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.step':
    case 'step':
      return import('./entities/step').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.entry':
    case 'entry':
      return import('./entities/entry').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.product':
    case 'product':
      return import('./entities/product').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.run_attachment':
    case 'run_attachment':
      return import('./entities/run-attachment').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.ticket':
    case 'ticket':
      return import('./entities/ticket').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.stencil':
    case 'stencil':
      return import('./entities/stencil').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.attachment':
    case 'attachment':
      return import('./entities/attachment').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.workload_type':
    case 'workload_type':
      return import('./entities/workload-type').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.search_hub':
    case 'search_hub':
      return import('./entities/search-hub').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.department':
    case 'department':
      return import('./entities/department').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.project':
    case 'project':
      return import('./entities/project').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.run':
    case 'run':
      return import('./entities/run').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.category':
    case 'category':
      return import('./entities/category').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.idea':
    case 'idea':
      return import('./entities/idea').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.run_history':
    case 'run_history':
      return import('./entities/run-history').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.project_member':
    case 'project_member':
      return import('./entities/project-member').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.day_capacity':
    case 'day_capacity':
      return import('./entities/day-capacity').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.relation':
    case 'relation':
      return import('./entities/relation').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.sprint':
    case 'sprint':
      return import('./entities/sprint').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.psdefield':
    case 'psdefield':
      return import('./entities/psde-field').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.transition_history':
    case 'transition_history':
      return import('./entities/transition-history').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.work_item_type':
    case 'work_item_type':
      return import('./entities/work-item-type').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.references_index':
    case 'references_index':
      return import('./entities/references-index').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.product_ticket_type':
    case 'product_ticket_type':
      return import('./entities/product-ticket-type').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.project_tag':
    case 'project_tag':
      return import('./entities/project-tag').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.login_log':
    case 'login_log':
      return import('./entities/login-log').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.comment':
    case 'comment':
      return import('./entities/comment').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.work_item':
    case 'work_item':
      return import('./entities/work-item').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.library':
    case 'library':
      return import('./entities/library').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.extend_log':
    case 'extend_log':
      return import('./entities/extend-log').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.notify_setting':
    case 'notify_setting':
      return import('./entities/notify-setting').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.psdelogic':
    case 'psdelogic':
      return import('./entities/psde-logic').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.product_member':
    case 'product_member':
      return import('./entities/product-member').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.board':
    case 'board':
      return import('./entities/board').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.test_suite':
    case 'test_suite':
      return import('./entities/test-suite').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.portfolio_member':
    case 'portfolio_member':
      return import('./entities/portfolio-member').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.workload':
    case 'workload':
      return import('./entities/workload').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.work_item_state':
    case 'work_item_state':
      return import('./entities/work-item-state').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.insight':
    case 'insight':
      return import('./entities/insight').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.space_member':
    case 'space_member':
      return import('./entities/space-member').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.activity':
    case 'activity':
      return import('./entities/activity').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.test_plan':
    case 'test_plan':
      return import('./entities/test-plan').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.article_page':
    case 'article_page':
      return import('./entities/article-page').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.product_tag':
    case 'product_tag':
      return import('./entities/product-tag').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.group':
    case 'group':
      return import('./entities/group').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.customer':
    case 'customer':
      return import('./entities/customer').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.psdemslogic':
    case 'psdemslogic':
      return import('./entities/psdems-logic').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.job':
    case 'job':
      return import('./entities/job').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.search_attachment':
    case 'search_attachment':
      return import('./entities/search-attachment').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.ms_value_proxy':
    case 'ms_value_proxy':
      return import('./entities/ms-value-proxy').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.version':
    case 'version':
      return import('./entities/version').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.dyna_dashboard':
    case 'dyna_dashboard':
      return import('./entities/dyna-dashboard').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.work':
    case 'work':
      return import('./entities/work').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.psdenotify':
    case 'psdenotify':
      return import('./entities/psde-notify').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.template_flow':
    case 'template_flow':
      return import('./entities/template-flow').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.space':
    case 'space':
      return import('./entities/space').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.user':
    case 'user':
      return import('./entities/user').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.attention':
    case 'attention':
      return import('./entities/attention').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.notify_event':
    case 'notify_event':
      return import('./entities/notify-event').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.release':
    case 'release':
      return import('./entities/release').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.search_comment':
    case 'search_comment':
      return import('./entities/search-comment').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.recent':
    case 'recent':
      return import('./entities/recent').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.test_case_template':
    case 'test_case_template':
      return import('./entities/test-case-template').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.product_plan':
    case 'product_plan':
      return import('./entities/product-plan').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.portfolio':
    case 'portfolio':
      return import('./entities/portfolio').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.section':
    case 'section':
      return import('./entities/section').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.test_case':
    case 'test_case':
      return import('./entities/test-case').then(
        m => m.default as unknown as IAppDataEntity,
      );
    default:
      throw new Error(`无法找到实体模型：${name}`);
  }
}
export async function getAppViewModel(name: string): Promise<IAppView> {
  const _name = name.toLowerCase();
  switch (_name) {
    case 'work_item_redirect_view':
      return import('./views/work-item-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_redirect_view':
      return import('./views/run-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_member_redirect_view':
      return import('./views/library-member-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_member_redirect_view':
      return import('./views/space-member-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_member_redirect_view':
      return import('./views/portfolio-member-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_redirect_view':
      return import('./views/portfolio-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_redirect_view':
      return import('./views/workload-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'deliverable_redirect_view':
      return import('./views/deliverable-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_tag_redirect_view':
      return import('./views/project-tag-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_redirect_view':
      return import('./views/user-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_redirect_view':
      return import('./views/library-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_redirect_view':
      return import('./views/insight-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_redirect_view':
      return import('./views/project-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_redirect_view':
      return import('./views/test-case-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_member_redirect_view':
      return import('./views/product-member-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_redirect_view':
      return import('./views/ticket-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_member_redirect_view':
      return import('./views/project-member-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_redirect_view':
      return import('./views/recent-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_redirect_view':
      return import('./views/work-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    default:
      throw new Error(`无法找到视图模型：${name}`);
  }
}

export async function getAppModel(): Promise<IApplication> {
  ibiz.hub.defaultAppIndexViewName = 'app_index_view';
  return import('./app/app').then(m => {
    const app = m.default as IData;
    app.appId = undefined;
    return app as IApplication;
  });
}
