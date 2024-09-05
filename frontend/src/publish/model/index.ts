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
  setCodeList(await import('./code-list/base-auth-code').then(m => m.default));
  setCodeList(
    await import('./code-list/base-attention-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/base-baseline-status').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/base-baseline-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/base-choose-job-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/base-contains-archive').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/base-contains-delete').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/base-cur-project-work-item-type').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/base-dictionary-catalog').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/base-dictionary-type').then(m => m.default),
  );
  setCodeList(await import('./code-list/base-index-type').then(m => m.default));
  setCodeList(
    await import('./code-list/base-insight-group').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/base-member-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/base-plan-snapshot-type').then(m => m.default),
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
  setCodeList(
    await import('./code-list/base-report-type').then(m => m.default),
  );
  setCodeList(await import('./code-list/base-role-type').then(m => m.default));
  setCodeList(await import('./code-list/base-stage-type').then(m => m.default));
  setCodeList(
    await import('./code-list/base-user-group-role-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/base-user-report-flag').then(m => m.default),
  );
  setCodeList(await import('./code-list/base-version').then(m => m.default));
  setCodeList(
    await import('./code-list/base-workload-type').then(m => m.default),
  );
  setCodeList(await import('./code-list/code-list-46').then(m => m.default));
  setCodeList(await import('./code-list/code-list-54').then(m => m.default));
  setCodeList(await import('./code-list/ftr-search-menu').then(m => m.default));
  setCodeList(
    await import('./code-list/insight-bi-chart-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/insight-bi-chart-type-2').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/insight-bi-form-case').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/insight-bi-form-idea-ratio').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/insight-bi-form-item').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/insight-bi-form-item-bug').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/insight-bi-form-ticket').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/insight-bi-form-work-item-state').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/insight-bi-form-work-item-state-type').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/insight-dynadashboard').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/insight-insight-report').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/insight-report-group-bi').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-base-ticket-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-category').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-common-level').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-cur-product-idea-category').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-cur-product-tag').then(m => m.default),
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
    await import('./code-list/prod-mgmt-idea-categories').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-idea-priority').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-idea-section').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-idea-section-2').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-idea-state').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/prod-mgmt-idea-template').then(m => m.default),
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
    await import('./code-list/proj-mgmt-after-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-change-work-item-type').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-choose-relation-type').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-cur-board-upload').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-cur-project-member').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-cur-project-stage').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-cur-release-stage').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-cur-sprint').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-cur-sprint-upload').then(
      m => m.default,
    ),
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
    await import('./code-list/proj-mgmt-front-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-kanban-bar').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-notify-field').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-project-board').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-project-state').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-project-tag').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-project-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-relation-type').then(m => m.default),
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
    await import('./code-list/proj-mgmt-scope-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-scrum-state').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-severity').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/proj-mgmt-sprint-alteration-type').then(
      m => m.default,
    ),
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
    await import('./code-list/proj-mgmt-weekday').then(m => m.default),
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
    await import('./code-list/proj-mgmt-work-item-origin-state').then(
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
    await import('./code-list/team-discuss-status').then(m => m.default),
  );
  setCodeList(await import('./code-list/team-topic-list').then(m => m.default));
  setCodeList(
    await import('./code-list/test-mgmt-all-library').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-case-state').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-case-template').then(m => m.default),
  );
  setCodeList(
    await import(
      './code-list/test-mgmt-complete-review-state-passordenial'
    ).then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-cur-library-member').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/test-mgmt-final-stage-results').then(
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
    await import('./code-list/test-mgmt-review-change-type').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/test-mgmt-review-result').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-review-stage-data').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/test-mgmt-review-state-passordenial').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/test-mgmt-review-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-review-type-guideline').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/test-mgmt-reviewer-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-run-status').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/test-mgmt-stage-state').then(m => m.default),
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
    await import('./code-list/test-mgmt-test-suite-upload').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/usr-code-list-0424934582').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/wiki-history-version-list').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/wiki-page-advanced-search-field').then(
      m => m.default,
    ),
  );
  setCodeList(await import('./code-list/wiki-page-type').then(m => m.default));
  setCodeList(
    await import('./code-list/wiki-shared-page-check-type').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/wiki-shared-pages').then(m => m.default),
  );
  setCodeList(await import('./code-list/wiki-space-list').then(m => m.default));
  setCodeList(
    await import('./code-list/wiki-space-shared-scope').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/wiki-space-shared-status').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/wiki-stenci-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/wiki-stencil-scope').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/wiki-user-scope-type').then(m => m.default),
  );
  setCodeList(await import('./code-list/yes-no').then(m => m.default));
  setCodeList(
    await import('./code-list/extension-bi-dimension-type').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/extension-bi-measure-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/extension-de-logic-node-type').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/extension-de-logic-node-type-3').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/extension-de-logic-node-type-ms').then(
      m => m.default,
    ),
  );
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
    await import('./code-list/extension-ms-logic-design-mode').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/extension-wf-infom-msg-type').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/extension-auto-flow-type').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/extension-enable-action').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/extension-enable-field-change').then(
      m => m.default,
    ),
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
    await import('./code-list/extension-portlet-runtime').then(m => m.default),
  );
  setCodeList(
    await import('./code-list/extension-product-func-state').then(
      m => m.default,
    ),
  );
  setCodeList(
    await import('./code-list/extension-psdefield-dyna').then(m => m.default),
  );
  setCodeList(await import('./code-list/field-data-type').then(m => m.default));
  setCodeList(
    await import('./code-list/field-data-type-simple').then(m => m.default),
  );
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
    case 'plmweb.dictionary_data':
    case 'dictionary_data':
      return import('./entities/dictionary-data').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.addon':
    case 'addon':
      return import('./entities/addon').then(
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
    case 'plmweb.resource_member':
    case 'resource_member':
      return import('./entities/resource-member').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.favorite':
    case 'favorite':
      return import('./entities/favorite').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.baseline_test_case':
    case 'baseline_test_case':
      return import('./entities/baseline-test-case').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.psappportlet':
    case 'psappportlet':
      return import('./entities/ps-app-portlet').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.deliverable':
    case 'deliverable':
      return import('./entities/deliverable').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.baseline_work_item':
    case 'baseline_work_item':
      return import('./entities/baseline-work-item').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.discuss_member':
    case 'discuss_member':
      return import('./entities/discuss-member').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.discuss_topic':
    case 'discuss_topic':
      return import('./entities/discuss-topic').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.management':
    case 'management':
      return import('./entities/management').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.insight_member':
    case 'insight_member':
      return import('./entities/insight-member').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.step':
    case 'step':
      return import('./entities/step').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.discuss_reply':
    case 'discuss_reply':
      return import('./entities/discuss-reply').then(
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
    case 'plmweb.addon_role_member':
    case 'addon_role_member':
      return import('./entities/addon-role-member').then(
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
    case 'plmweb.sprint_alteration':
    case 'sprint_alteration':
      return import('./entities/sprint-alteration').then(
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
    case 'plmweb.pssysbicubedimension':
    case 'pssysbicubedimension':
      return import('./entities/ps-sys-bi-cube-dimension').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.idea_template':
    case 'idea_template':
      return import('./entities/idea-template').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.day_capacity':
    case 'day_capacity':
      return import('./entities/day-capacity').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.pscoreprdcat':
    case 'pscoreprdcat':
      return import('./entities/ps-core-prd-cat').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.pscoreprd':
    case 'pscoreprd':
      return import('./entities/ps-core-prd').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.insight_view':
    case 'insight_view':
      return import('./entities/insight-view').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.psdelogicnode':
    case 'psdelogicnode':
      return import('./entities/psde-logic-node').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.review_stage':
    case 'review_stage':
      return import('./entities/review-stage').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.relation':
    case 'relation':
      return import('./entities/relation').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.insight_report':
    case 'insight_report':
      return import('./entities/insight-report').then(
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
    case 'plmweb.review_wizard':
    case 'review_wizard':
      return import('./entities/review-wizard').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.work_item_type':
    case 'work_item_type':
      return import('./entities/work-item-type').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.pssysbicubemeasure':
    case 'pssysbicubemeasure':
      return import('./entities/ps-sys-bi-cube-measure').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.baseline_idea':
    case 'baseline_idea':
      return import('./entities/baseline-idea').then(
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
    case 'plmweb.review_result':
    case 'review_result':
      return import('./entities/review-result').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.baseline_page':
    case 'baseline_page':
      return import('./entities/baseline-page').then(
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
    case 'plmweb.page_version':
    case 'page_version':
      return import('./entities/page-version').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.notify_setting':
    case 'notify_setting':
      return import('./entities/notify-setting').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.psdelogiclink':
    case 'psdelogiclink':
      return import('./entities/psde-logic-link').then(
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
    case 'plmweb.addon_resource':
    case 'addon_resource':
      return import('./entities/addon-resource').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.review':
    case 'review':
      return import('./entities/review').then(
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
    case 'plmweb.pssysbireportitem':
    case 'pssysbireportitem':
      return import('./entities/ps-sys-bi-report-item').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.work_item_state':
    case 'work_item_state':
      return import('./entities/work-item-state').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.work_item_wizard_detail':
    case 'work_item_wizard_detail':
      return import('./entities/work-item-wizard-detail').then(
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
    case 'plmweb.shared_space':
    case 'shared_space':
      return import('./entities/shared-space').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.review_rule':
    case 'review_rule':
      return import('./entities/review-rule').then(
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
    case 'plmweb.stage':
    case 'stage':
      return import('./entities/stage').then(
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
    case 'plmweb.ticket_type':
    case 'ticket_type':
      return import('./entities/ticket-type').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.search_attachment':
    case 'search_attachment':
      return import('./entities/search-attachment').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.msvalueproxy':
    case 'msvalueproxy':
      return import('./entities/ms-value-proxy').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.member':
    case 'member':
      return import('./entities/member').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.parameter':
    case 'parameter':
      return import('./entities/parameter').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.version':
    case 'version':
      return import('./entities/version').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.guideline':
    case 'guideline':
      return import('./entities/guideline').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.dyna_appmenu':
    case 'dyna_appmenu':
      return import('./entities/dyna-appmenu').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.review_content':
    case 'review_content':
      return import('./entities/review-content').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.review_action_rule':
    case 'review_action_rule':
      return import('./entities/review-action-rule').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.dyna_dashboard':
    case 'dyna_dashboard':
      return import('./entities/dyna-dashboard').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.discuss_post':
    case 'discuss_post':
      return import('./entities/discuss-post').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.work':
    case 'work':
      return import('./entities/work').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.systodo':
    case 'systodo':
      return import('./entities/sys-todo').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.pssysbireport':
    case 'pssysbireport':
      return import('./entities/ps-sys-bi-report').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.pscoreprdfunc':
    case 'pscoreprdfunc':
      return import('./entities/ps-core-prd-func').then(
        m => m.default as unknown as IAppDataEntity,
      );
    case 'plmweb.pssysbicube':
    case 'pssysbicube':
      return import('./entities/ps-sys-bi-cube').then(
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
    case 'plmweb.work_item_wizard':
    case 'work_item_wizard':
      return import('./entities/work-item-wizard').then(
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
    case 'idea_others_re_mpick_up_view':
      return import('./views/idea-others-re-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_library_grid_view':
      return import('./views/baseline-library-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_wizard_change_view':
      return import('./views/work-item-wizard-change-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'customer_all_grid_view':
      return import('./views/customer-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'board_pick_up_grid_view':
      return import('./views/board-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_config_tree_exp_view':
      return import('./views/space-config-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_content_under_review_grid_view':
      return import('./views/review-content-under-review-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_tree_exp_view':
      return import('./views/recent-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_main_view':
      return import('./views/sprint-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'waterfall_back_log_app_data_upload_view':
      return import('./views/waterfall-back-log-app-data-upload-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'customer_idea_re_customer_grid_view':
      return import('./views/customer-idea-re-customer-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_choose_mpick_up_view':
      return import('./views/user-choose-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_recycle_grid_view':
      return import('./views/article-page-recycle-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_pick_up_around_view':
      return import('./views/sprint-pick-up-around-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_in_progress_grid_view':
      return import('./views/portfolio-in-progress-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_project_create_wizard_view':
      return import('./views/portfolio-project-create-wizard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_bug_state_statement':
      return import('./views/work-item-bug-state-statement').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_logic_logic_design_custom':
      return import('./views/psde-logic-logic-design-custom').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_edit_view':
      return import('./views/insight-view-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_report_survey_custom_view':
      return import('./views/test-plan-report-survey-custom-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_move_choose_pick_up_view':
      return import('./views/project-move-choose-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_type_editor_view':
      return import('./views/ticket-type-editor-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_dyna_waterfall_tree_grid_view':
      return import('./views/work-item-dyna-waterfall-tree-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'board_pick_up_view':
      return import('./views/board-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_wizard_create_wizard_view':
      return import('./views/review-wizard-create-wizard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_project_tree_exp_view':
      return import('./views/test-plan-project-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_advanced_setting_edit_view':
      return import('./views/project-advanced-setting-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_sys_bi_cube_measure_redirect_view':
      return import('./views/ps-sys-bi-cube-measure-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_quick_create_view':
      return import('./views/release-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_work_item_comparison_grid_view':
      return import('./views/baseline-work-item-comparison-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_assessment_result_report_view':
      return import('./views/test-case-assessment-result-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_test_case_relation_version_list_view':
      return import(
        './views/baseline-test-case-relation-version-list-view'
      ).then(m => m.default as unknown as IAppView);
    case 'test_case_copy_test_case_option_view':
      return import('./views/test-case-copy-test-case-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_idea_edit_view':
      return import('./views/baseline-idea-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_test_plan_re_test_case_prickup_view':
      return import(
        './views/test-case-test-plan-re-test-case-prickup-view'
      ).then(m => m.default as unknown as IAppView);
    case 'product_filter_tab_exp_view':
      return import('./views/product-filter-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'member_grid_view':
      return import('./views/member-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_show_edit_view':
      return import('./views/discuss-topic-show-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_move_choose_pick_up_grid_view':
      return import('./views/project-move-choose-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'stage_redirect_view':
      return import('./views/stage-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_management_project_grid_view':
      return import('./views/workload-management-project-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_archived_grid_view':
      return import('./views/ticket-archived-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_tag_grid_view':
      return import('./views/product-tag-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_calendar_work_item_management_grid_view':
      return import(
        './views/workload-calendar-work-item-management-grid-view'
      ).then(m => m.default as unknown as IAppView);
    case 'project_move_option_view':
      return import('./views/project-move-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdemslogicdesigneditview_ms':
      return import('./views/psdemslogicdesigneditview-ms').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_filter_grid_view':
      return import('./views/work-item-filter-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'board_edit_view':
      return import('./views/board-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_tree_exp_view':
      return import('./views/library-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_move_view':
      return import('./views/work-item-move-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_redirect_view':
      return import('./views/work-item-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_release_grid_view':
      return import('./views/test-plan-release-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'customer_set_category_option_view':
      return import('./views/customer-set-category-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_scrum_index_view':
      return import('./views/project-scrum-index-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_logic_all_log_grid_view':
      return import('./views/psde-logic-all-log-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_project_show_view':
      return import('./views/portfolio-project-show-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dyna_dashboard_info_edit_view':
      return import('./views/dyna-dashboard-info-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_plan_work_item_mpick_up_grid_view':
      return import('./views/work-item-plan-work-item-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_degree_importance_report_view':
      return import('./views/test-case-degree-importance-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_all_waterfall_grid_view':
      return import('./views/work-item-all-waterfall-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'notify_setting_config_view':
      return import('./views/notify-setting-config-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_test_follow_edit_view':
      return import('./views/work-item-test-follow-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_progress_grid_view':
      return import('./views/ticket-progress-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_work_item_re_ticket_list_view':
      return import('./views/relation-work-item-re-ticket-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_statistical_grid_view':
      return import('./views/article-page-statistical-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_ticket_re_work_item_grid_view':
      return import('./views/relation-ticket-re-work-item-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_post_recent_grid_view':
      return import('./views/discuss-post-recent-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_redirect_view':
      return import('./views/run-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_tree_exp_view':
      return import('./views/test-plan-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_calendar_test_case_grid_view':
      return import('./views/workload-calendar-test-case-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_template_pickup_grid_view':
      return import('./views/test-case-template-pickup-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_detail_list_view':
      return import('./views/workload-detail-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_pick_up_view':
      return import('./views/project-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_quick_create_view':
      return import('./views/workload-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_set_run_status_option_view':
      return import('./views/run-set-run-status-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_sys_bi_cube_measure_quick_create_measure':
      return import('./views/ps-sys-bi-cube-measure-quick-create-measure').then(
        m => m.default as unknown as IAppView,
      );
    case 'resource_member_redirect_view':
      return import('./views/resource-member-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_recover_grid_view':
      return import('./views/ticket-recover-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_product_create_view':
      return import('./views/baseline-product-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_member_assigned_grid_view':
      return import('./views/project-member-assigned-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_archived_grid_view':
      return import('./views/product-archived-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_space_main_view':
      return import('./views/baseline-space-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_quick_create_view':
      return import('./views/test-plan-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'management_test_setting_view':
      return import('./views/management-test-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_template_all_grid_view':
      return import('./views/idea-template-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_quick_create_view':
      return import('./views/project-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_category_tree_exp_view':
      return import('./views/space-category-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_redirect_view':
      return import('./views/insight-view-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_idea_re_test_case_grid_view':
      return import('./views/relation-idea-re-test-case-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_relation_mpick_up_grid_view':
      return import('./views/release-relation-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'version_idea_grid_view':
      return import('./views/version-idea-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_baseline_mpick_up_grid_view':
      return import('./views/article-page-baseline-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'attachment_quick_create_deliver_target_view':
      return import('./views/attachment-quick-create-deliver-target-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_group_day_link_grid_view':
      return import('./views/workload-group-day-link-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_set_state_option_view':
      return import('./views/test-case-set-state-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'customer_test_tree_select_edit_view':
      return import('./views/customer-test-tree-select-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_scrum_print_user_stat_report_view':
      return import('./views/work-item-scrum-print-user-stat-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_base_info_edit_view':
      return import('./views/article-page-base-info-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_tree_exp_view':
      return import('./views/product-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_my_todo_item_tap_exp_view':
      return import('./views/recent-my-todo-item-tap-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_all_grid_view':
      return import('./views/ticket-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_project_resource_gantt_view':
      return import('./views/work-item-project-resource-gantt-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_pick_up_grid_view':
      return import('./views/test-case-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_tag_option_view':
      return import('./views/project-tag-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_nosuite_test_case_grid_view':
      return import('./views/test-case-nosuite-test-case-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_scrum_grid_view':
      return import('./views/insight-scrum-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_index_view':
      return import('./views/product-index-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_show_update_log_view':
      return import('./views/article-page-show-update-log-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_scrum_bug_state_report_view':
      return import('./views/work-item-scrum-bug-state-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_create_wizard_view':
      return import('./views/discuss-topic-create-wizard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_config_tree_exp_view':
      return import('./views/library-config-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_template_choose_template_option_view':
      return import(
        './views/test-case-template-choose-template-option-view'
      ).then(m => m.default as unknown as IAppView);
    case 'discuss_post_my_attention_grid_view':
      return import('./views/discuss-post-my-attention-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'search_attachment_redirect_view':
      return import('./views/search-attachment-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_quick_create_bug_view':
      return import('./views/work-item-quick-create-bug-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_redirect_view':
      return import('./views/discuss-topic-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_space_update_view':
      return import('./views/baseline-space-update-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_dyna_scrum_grid_view':
      return import('./views/work-item-dyna-scrum-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_epic_main_view':
      return import('./views/work-item-epic-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_test_case_re_bug_list_view':
      return import('./views/relation-test-case-re-bug-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_redirect_view_dyna':
      return import('./views/work-item-redirect-view-dyna').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_test_all_grid_view':
      return import('./views/ticket-test-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_tab_exp_view':
      return import('./views/workload-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_scrum_temp_speed_report_view':
      return import('./views/work-item-scrum-temp-speed-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_management_product_grid_view':
      return import('./views/workload-management-product-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'references_index_edit_view':
      return import('./views/references-index-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'transition_history_work_item_calendar_view':
      return import('./views/transition-history-work-item-calendar-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_state_grid_view':
      return import('./views/work-item-state-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_redirect_view':
      return import('./views/baseline-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_show_edit_view':
      return import('./views/project-show-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_product_re_tree_exp_view':
      return import('./views/space-product-re-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_all_grid_view':
      return import('./views/release-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'guideline_config_option_view':
      return import('./views/guideline-config-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_idea_re_customer_grid_view':
      return import('./views/relation-idea-re-customer-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_tree_grid_ex_view':
      return import('./views/work-tree-grid-ex-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_type_global_setting_view_waterfall':
      return import(
        './views/work-item-type-global-setting-view-waterfall'
      ).then(m => m.default as unknown as IAppView);
    case 'ticket_type_config_tab_exp_view':
      return import('./views/ticket-type-config-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'version_list_exp_view':
      return import('./views/version-list-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_edit_view':
      return import('./views/project-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_depend_mpick_up_view':
      return import('./views/work-item-depend-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'scrum_back_log_app_data_upload_view':
      return import('./views/scrum-back-log-app-data-upload-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_member_edit_view':
      return import('./views/project-member-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'member_portfolio_resource_mpick_up_grid_view':
      return import(
        './views/member-portfolio-resource-mpick-up-grid-view'
      ).then(m => m.default as unknown as IAppView);
    case 'customer_pick_up_grid_view':
      return import('./views/customer-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_over_view':
      return import('./views/project-over-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'version_pick_up_grid_view':
      return import('./views/version-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_calendar_work_item_grid_view':
      return import('./views/workload-calendar-work-item-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_member_redirect_view':
      return import('./views/insight-member-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dyna_dashboard_list_exp_view2':
      return import('./views/dyna-dashboard-list-exp-view-2').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_review_content_grid_view':
      return import('./views/test-case-review-content-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_member_redirect_view':
      return import('./views/library-member-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_alteration_log_grid_view':
      return import('./views/sprint-alteration-log-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdeformdesign':
      return import('./views/psdeformdesign').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_others_re_mpick_up_view':
      return import('./views/test-case-others-re-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_org_grid_view':
      return import('./views/project-org-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_all_grid_view':
      return import('./views/review-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_quick_create_view':
      return import('./views/product-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_project_index_view':
      return import('./views/portfolio-project-index-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_report_copy_option_view':
      return import('./views/insight-report-copy-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_case_type_report_view':
      return import('./views/test-case-case-type-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_sprint_relation_grid_view':
      return import('./views/release-sprint-relation-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_management_tab_search_view':
      return import('./views/workload-management-tab-search-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_page_redirect_view':
      return import('./views/baseline-page-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_tag_redirect_view':
      return import('./views/product-tag-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_library_categories_pick_up_tree_view':
      return import(
        './views/baseline-library-categories-pick-up-tree-view'
      ).then(m => m.default as unknown as IAppView);
    case 'workload_product_grid_view':
      return import('./views/workload-product-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_plan_quick_create_view':
      return import('./views/work-item-plan-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_completed_drill_detail_grid_view':
      return import('./views/work-item-completed-drill-detail-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_management_library_grid_view':
      return import('./views/workload-management-library-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'member_all_resource_mpick_up_view':
      return import('./views/member-all-resource-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_edit_view':
      return import('./views/work-item-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'board_quick_create_view':
      return import('./views/board-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_with_version_view':
      return import('./views/article-page-with-version-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_pick_up_tree_view':
      return import('./views/space-pick-up-tree-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'flow_tree_exp_view':
      return import('./views/flow-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_test_case_relation_grid_view':
      return import('./views/baseline-test-case-relation-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_report_set_board_option_view':
      return import('./views/insight-report-set-board-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_idea_re_ticket_list_view':
      return import('./views/relation-idea-re-ticket-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_draft_show_edit_view':
      return import('./views/article-page-draft-show-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_deleted_grid_view':
      return import('./views/space-deleted-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_edit_view':
      return import('./views/baseline-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_in_progress_grid_view':
      return import('./views/discuss-topic-in-progress-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_tree_exp_view':
      return import('./views/insight-view-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_kanban_bug_daily_tide_report_view':
      return import('./views/work-item-kanban-bug-daily-tide-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_user_group_grid_view':
      return import('./views/workload-user-group-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_type_edit_view':
      return import('./views/work-item-type-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_member_config_grid_view':
      return import('./views/insight-member-config-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_tree_exp_view':
      return import('./views/discuss-topic-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'entry_pick_up_grid_view':
      return import('./views/entry-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_member_role_edit_view':
      return import('./views/project-member-role-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_grid_view':
      return import('./views/relation-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'deliverable_edit_view':
      return import('./views/deliverable-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_suite_tree_exp_view':
      return import('./views/test-suite-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_re_self_mpick_up_view':
      return import('./views/ticket-re-self-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_activities_status_report_view':
      return import('./views/test-case-activities-status-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_move_space_view':
      return import('./views/space-move-space-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_results_report_view':
      return import('./views/run-results-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_notify_redirect_view':
      return import('./views/psde-notify-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_work_item_test':
      return import('./views/work-item-work-item-test').then(
        m => m.default as unknown as IAppView,
      );
    case 'customer_edit_view':
      return import('./views/customer-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_member_grid_view':
      return import('./views/insight-member-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_index_view':
      return import('./views/discuss-topic-index-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_space_tree_exp_view':
      return import('./views/baseline-space-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sys_todo_redirect_view':
      return import('./views/sys-todo-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_ticket_type_quick_create_view':
      return import('./views/product-ticket-type-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_product_categories_pick_up_tree_view':
      return import(
        './views/baseline-product-categories-pick-up-tree-view'
      ).then(m => m.default as unknown as IAppView);
    case 'work_item_depend_mpick_up_view_pickup_grid_view':
      return import(
        './views/work-item-depend-mpick-up-view-pickup-grid-view'
      ).then(m => m.default as unknown as IAppView);
    case 'work_item_change_parent_pick_up_view':
      return import('./views/work-item-change-parent-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_set_tags_option_view':
      return import('./views/ticket-set-tags-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_is_archived_grid_view':
      return import('./views/discuss-topic-is-archived-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'deliverable_grid_view':
      return import('./views/deliverable-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dyna_dashboard_system_board_grid_view':
      return import('./views/dyna-dashboard-system-board-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_redirect_view':
      return import('./views/test-plan-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_advanced_search_grid_view':
      return import('./views/ticket-advanced-search-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_pick_up_view':
      return import('./views/user-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_set_level_option_view':
      return import('./views/test-case-set-level-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'login_log_grid_view':
      return import('./views/login-log-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_index_view3':
      return import('./views/insight-view-index-view-3').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_type_pick_up_view':
      return import('./views/workload-type-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_tab_exp_view':
      return import('./views/user-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_field_data_extend_grid_view':
      return import('./views/psde-field-data-extend-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_logic_test_auto_rules_grid_view':
      return import('./views/psde-logic-test-auto-rules-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_in_progress_grid_view':
      return import('./views/insight-view-in-progress-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_template_edit_view':
      return import('./views/test-case-template-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_drill_detail_grid_view':
      return import('./views/review-drill-detail-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_move_option_view':
      return import('./views/idea-move-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_type_quick_edit_view':
      return import('./views/workload-type-quick-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_config_tab_exp_view':
      return import('./views/idea-config-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_wizard_detail_target_state_grid_view':
      return import(
        './views/work-item-wizard-detail-target-state-grid-view'
      ).then(m => m.default as unknown as IAppView);
    case 'space_member_redirect_view':
      return import('./views/space-member-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'customer_quick_create_view':
      return import('./views/customer-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dyna_dashboard_insight_view_grid_view':
      return import('./views/dyna-dashboard-insight-view-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_project_update_view':
      return import('./views/baseline-project-update-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'customer_pick_up_tree_view':
      return import('./views/customer-pick-up-tree-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_sys_bi_cube_tree_exp_view':
      return import('./views/ps-sys-bi-cube-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_edit_view':
      return import('./views/product-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_team_grid_view':
      return import('./views/insight-view-team-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_release_pick_up_tree_view':
      return import('./views/release-release-pick-up-tree-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_update_view':
      return import('./views/workload-update-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_move_option_view':
      return import('./views/product-move-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_daily_test_option_view':
      return import('./views/run-daily-test-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdemslogicmslogicdesign':
      return import('./views/psdemslogicmslogicdesign').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_type_setup_grid_view':
      return import('./views/workload-type-setup-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_library_create_view':
      return import('./views/baseline-library-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_scrum_defect_property_report_view':
      return import('./views/work-item-scrum-defect-property-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'stage_data_global_grid_view':
      return import('./views/stage-data-global-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_details_setting_view':
      return import('./views/product-details-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_config_tree_exp_view':
      return import('./views/discuss-topic-config-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_member_edit_view':
      return import('./views/discuss-member-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'page_version_list_exp_view':
      return import('./views/page-version-list-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_edit_view':
      return import('./views/sprint-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_model_show_view':
      return import('./views/article-page-model-show-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'attachment_edit_view':
      return import('./views/attachment-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_main_view':
      return import('./views/test-case-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_his_tab_exp_view':
      return import('./views/recent-his-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_work_item_gantt_view':
      return import('./views/baseline-work-item-gantt-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'addon_setting_view':
      return import('./views/addon-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_library_main_view':
      return import('./views/baseline-library-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_report_report_tree_exp_view':
      return import('./views/insight-report-report-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_my_attention_grid_view':
      return import('./views/ticket-my-attention-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_set_status_option_view':
      return import('./views/run-set-status-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_edit_view':
      return import('./views/test-plan-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_pick_up_grid_view':
      return import('./views/library-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_project_grid_view':
      return import('./views/workload-project-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_drill_detail_grid_view':
      return import('./views/project-drill-detail-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'member_role_edit_view':
      return import('./views/member-role-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dictionary_data_global_create_view':
      return import('./views/dictionary-data-global-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_daily_tendencies_report_view':
      return import('./views/run-daily-tendencies-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_my_test_case_grid_view':
      return import('./views/test-case-my-test-case-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_logic_node_design_view_create_work_item':
      return import(
        './views/psde-logic-node-design-view-create-work-item'
      ).then(m => m.default as unknown as IAppView);
    case 'test_suite_edit_view':
      return import('./views/test-suite-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_depend_on_list_view':
      return import('./views/relation-depend-on-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_quick_create_milestone_view':
      return import('./views/work-item-quick-create-milestone-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_state_quick_create_view':
      return import('./views/work-item-state-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_scrum_flow_setting_tab_view':
      return import('./views/project-scrum-flow-setting-tab-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_member_assigned_grid_view':
      return import('./views/insight-member-assigned-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_shared_view':
      return import('./views/space-shared-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_pick_up_grid_view':
      return import('./views/work-item-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_dyna_main_view':
      return import('./views/work-item-dyna-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_suite_pick_up_view':
      return import('./views/test-suite-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_pick_up_view':
      return import('./views/space-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_scrum_main_view':
      return import('./views/project-scrum-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_post_redirect_view':
      return import('./views/discuss-post-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_work_item_re_self_list_view':
      return import('./views/relation-work-item-re-self-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_post_recycle_bin_grid_view':
      return import('./views/discuss-post-recycle-bin-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_report_tree_exp_view':
      return import('./views/insight-report-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'flow_tab_exp_view':
      return import('./views/flow-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_pick_up_tree_view':
      return import('./views/idea-pick-up-tree-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_backlog_age_report_report_view':
      return import('./views/work-item-backlog-age-report-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_member_config_grid_view':
      return import('./views/project-member-config-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_all_report_grid_view':
      return import('./views/insight-all-report-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'addon_library_setting_grid_view':
      return import('./views/addon-library-setting-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_config_tree_exp_view':
      return import('./views/insight-view-config-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'version_edit_view':
      return import('./views/version-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_post_main_view':
      return import('./views/discuss-post-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_edit_view':
      return import('./views/idea-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_calendar_grid_view':
      return import('./views/workload-calendar-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_content_grid_view_all':
      return import('./views/review-content-grid-view-all').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_management_work_type_grid_view':
      return import('./views/workload-management-work-type-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'parameter_grid_view':
      return import('./views/parameter-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_project_set_resource_gantt_view':
      return import('./views/work-item-project-set-resource-gantt-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_choose_option_view':
      return import('./views/space-choose-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_template_all_grid_view':
      return import('./views/test-case-template-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'stage_edit_view':
      return import('./views/stage-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'template_flow_data_view':
      return import('./views/template-flow-data-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_pick_up_tree_view':
      return import('./views/article-page-pick-up-tree-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_report_set_category_option_view':
      return import('./views/insight-report-set-category-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'entry_pick_up_view':
      return import('./views/entry-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_all_grid_view':
      return import('./views/run-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_app_data_upload_view':
      return import('./views/ticket-app-data-upload-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_in_progress_grid_view':
      return import('./views/library-in-progress-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_drill_detail_grid_view':
      return import('./views/workload-drill-detail-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_type_pick_up_view':
      return import('./views/work-item-type-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'board_confirm_remove_view':
      return import('./views/board-confirm-remove-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'waterfall_bug_app_data_upload_view':
      return import('./views/waterfall-bug-app-data-upload-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_others_re_ticket_mpick_up_view':
      return import('./views/ticket-others-re-ticket-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_config_tab_exp_view':
      return import('./views/library-config-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_requirement_tree_grid_view':
      return import('./views/work-item-requirement-tree-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_create_wizard_view':
      return import('./views/space-create-wizard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_idea_relation_grid_view':
      return import('./views/baseline-idea-relation-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_implementation_results_report_view':
      return import(
        './views/test-case-implementation-results-report-view'
      ).then(m => m.default as unknown as IAppView);
    case 'library_all_grid_view':
      return import('./views/library-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_project_categories_pick_up_tree_view':
      return import(
        './views/baseline-project-categories-pick-up-tree-view'
      ).then(m => m.default as unknown as IAppView);
    case 'shared_space_edit_view':
      return import('./views/shared-space-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_is_archived_grid_view':
      return import('./views/library-is-archived-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dictionary_data_global_grid_view':
      return import('./views/dictionary-data-global-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_change_state_view':
      return import('./views/idea-change-state-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_others_re_mpick_up_grid_view':
      return import('./views/work-item-others-re-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_suite_pick_up_grid_view':
      return import('./views/test-suite-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dictionary_data_ticket_confirm_remove_view':
      return import('./views/dictionary-data-ticket-confirm-remove-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_customer_re_ticket_pick_up_grid_view':
      return import('./views/ticket-customer-re-ticket-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_alteration_edit_view':
      return import('./views/sprint-alteration-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_my_assignee_gird_view':
      return import('./views/work-item-my-assignee-gird-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_scrum_defect_total_trend_report_view':
      return import(
        './views/work-item-scrum-defect-total-trend-report-view'
      ).then(m => m.default as unknown as IAppView);
    case 'space_org_grid_view':
      return import('./views/space-org-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'shared_space_shared_grid_view':
      return import('./views/shared-space-shared-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_member_assigned_grid_view':
      return import('./views/space-member-assigned-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_member_redirect_view':
      return import('./views/portfolio-member-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_test_case_re_idea_grid_view':
      return import('./views/relation-test-case-re-idea-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_pick_up_around_grid_view':
      return import('./views/release-pick-up-around-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_waterfall_index_view':
      return import('./views/project-waterfall-index-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_property_edit_view':
      return import('./views/project-property-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'version_work_item_grid_view':
      return import('./views/version-work-item-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_kanban_tree_exp_view':
      return import('./views/insight-kanban-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_is_archived_grid_view':
      return import('./views/space-is-archived-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_tag_product_tag_confirm_remove_view':
      return import('./views/product-tag-product-tag-confirm-remove-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_recycle_edit_view':
      return import('./views/test-case-recycle-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_baseline_mpick_up_view':
      return import('./views/work-item-baseline-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_redirect_view':
      return import('./views/space-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_main_view':
      return import('./views/library-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_dyna_kanban_tree_grid_view':
      return import('./views/work-item-dyna-kanban-tree-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_grid_view':
      return import('./views/user-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'favorite_edit_view':
      return import('./views/favorite-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_recycle_grid_view':
      return import('./views/test-case-recycle-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_show_edit_view':
      return import('./views/product-show-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'search_comment_redirect_view':
      return import('./views/search-comment-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_person_grid_view':
      return import('./views/space-person-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_tag_edit_option_view':
      return import('./views/product-tag-edit-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_kanban_view':
      return import('./views/work-item-kanban-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_waterfall_story_grid_view':
      return import('./views/work-item-waterfall-story-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'customer_pick_up_view':
      return import('./views/customer-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_plan_redirect_view':
      return import('./views/product-plan-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_report_custom_card_view':
      return import('./views/insight-report-custom-card-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_customer_re_ticket_pick_up_view':
      return import('./views/ticket-customer-re-ticket-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_quick_new_page_option_view':
      return import('./views/article-page-quick-new-page-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_other_re_sapce_page_grid_view':
      return import('./views/article-page-other-re-sapce-page-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_choose_child_mpick_up_view':
      return import('./views/work-item-choose-child-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_work_item_edit_view':
      return import('./views/baseline-work-item-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_post_edit_view':
      return import('./views/discuss-post-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workspace_quick_create_view':
      return import('./views/workspace-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_child_grid_view':
      return import('./views/work-item-child-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_move_test_case_view':
      return import('./views/test-case-move-test-case-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_plan_quick_create_view':
      return import('./views/product-plan-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_edit_view':
      return import('./views/insight-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_idea_re_work_item_list_view':
      return import('./views/relation-idea-re-work-item-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_case_re_bug_mpick_up_grid_view':
      return import('./views/work-item-case-re-bug-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_confirm_finish_view':
      return import('./views/sprint-confirm-finish-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_daily_test_report_view':
      return import('./views/run-daily-test-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_scrum_bug_grid_view':
      return import('./views/work-item-scrum-bug-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_all_grid_view':
      return import('./views/insight-view-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_report_bi_report_content_panel_view':
      return import('./views/insight-report-bi-report-content-panel-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_deleted_grid_view':
      return import('./views/library-deleted-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_pick_up_grid_view':
      return import('./views/release-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_member_project_bind_member_grid_view':
      return import(
        './views/portfolio-member-project-bind-member-grid-view'
      ).then(m => m.default as unknown as IAppView);
    case 'ticket_type_global_setting_view':
      return import('./views/ticket-type-global-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_upload_icon_option_view':
      return import('./views/article-page-upload-icon-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_global_setting_view':
      return import('./views/work-item-global-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_in_progress_grid_view':
      return import('./views/space-in-progress-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_app_data_upload_view':
      return import('./views/test-case-app-data-upload-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_idea_re_ticket_grid_view':
      return import('./views/relation-idea-re-ticket-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_run_list_view':
      return import('./views/workload-run-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_log_grid_view':
      return import('./views/workload-log-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'addon_space_setting_grid_view':
      return import('./views/addon-space-setting-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_baseline_mpick_up_view':
      return import('./views/test-case-baseline-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dictionary_data_state_edit_view':
      return import('./views/dictionary-data-state-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_type_global_create_view':
      return import('./views/work-item-type-global-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_day_type_link_management_grid_view':
      return import('./views/workload-day-type-link-management-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'stage_del_confirm_view':
      return import('./views/stage-del-confirm-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'stencil_center_list_view':
      return import('./views/stencil-center-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_advanced_setting_edit_view':
      return import('./views/product-advanced-setting-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_recent_project_grid_view':
      return import('./views/recent-recent-project-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_plan_all_grid_view':
      return import('./views/product-plan-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_plan_categories_pick_up_tree_view':
      return import('./views/product-plan-categories-pick-up-tree-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_field_quick_create_view':
      return import('./views/psde-field-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'search_hub_tab_search_view':
      return import('./views/search-hub-tab-search-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_report_dashboard_view':
      return import('./views/test-plan-report-dashboard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_priority_distributions_report_view':
      return import('./views/run-priority-distributions-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_log_list_view':
      return import('./views/article-page-log-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'guideline_all_grid_view':
      return import('./views/guideline-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_log_management_view':
      return import('./views/workload-log-management-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'search_comment_advanced_search_grid_view':
      return import('./views/search-comment-advanced-search-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_priority_distributions_report_view':
      return import(
        './views/test-case-priority-distributions-report-view'
      ).then(m => m.default as unknown as IAppView);
    case 'portfolio_grid_view':
      return import('./views/portfolio-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_case_person_report_view':
      return import('./views/test-case-case-person-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_idea_comparison_grid_view':
      return import('./views/baseline-idea-comparison-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_in_progress_grid_view':
      return import('./views/test-plan-in-progress-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'login_log_over_view':
      return import('./views/login-log-over-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_quick_create_view':
      return import('./views/library-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_person_grid_view':
      return import('./views/insight-view-person-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_test_case_redirect_view':
      return import('./views/baseline-test-case-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_pickup_view':
      return import('./views/insight-view-pickup-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_notify_field_change_hook_edit_view':
      return import('./views/psde-notify-field-change-hook-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_test_main_view':
      return import('./views/ticket-test-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_recycle_grid_view':
      return import('./views/idea-recycle-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_core_prd_info_view':
      return import('./views/ps-core-prd-info-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_show_edit_view':
      return import('./views/library-show-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'attachment_redirect_view':
      return import('./views/attachment-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_my_assign_grid_view':
      return import('./views/idea-my-assign-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'transition_history_idea_calendar_view':
      return import('./views/transition-history-idea-calendar-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_baseinfo_over_view':
      return import('./views/project-baseinfo-over-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_content_result_option_view':
      return import('./views/review-content-result-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_post_my_create_grid_view':
      return import('./views/discuss-post-my-create-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_setting_view':
      return import('./views/insight-view-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'member_edit_view':
      return import('./views/member-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_org_grid_view':
      return import('./views/library-org-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_stage_list_view':
      return import('./views/review-stage-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_template_edit_view':
      return import('./views/idea-template-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_idea_relation_version_list_view':
      return import('./views/baseline-idea-relation-version-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_core_prd_func_redirect_view':
      return import('./views/ps-core-prd-func-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_edit_view':
      return import('./views/space-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_work_item_re_idea_grid_view':
      return import('./views/relation-work-item-re-idea-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_my_created_grid_view':
      return import('./views/idea-my-created-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_program_analyze_report_view':
      return import('./views/test-case-program-analyze-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_relation_mpick_up_view':
      return import('./views/sprint-relation-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_suite_grid_view':
      return import('./views/test-suite-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'stencil_list_exp_view':
      return import('./views/stencil-list-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_space_grid_view':
      return import('./views/baseline-space-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_my_assignee_grid_view':
      return import('./views/test-plan-my-assignee-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_day_type_link_grid_view':
      return import('./views/workload-day-type-link-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_grid_view':
      return import('./views/space-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dictionary_data_edit_view':
      return import('./views/dictionary-data-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_redirect_view':
      return import('./views/product-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_member_config_grid_view':
      return import('./views/discuss-member-config-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_notice_show_view':
      return import('./views/project-notice-show-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_shared_with_me_view':
      return import('./views/article-page-shared-with-me-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_quick_create_view':
      return import('./views/test-case-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_index_my_created_grid_view':
      return import('./views/work-item-index-my-created-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_type_edit_view':
      return import('./views/ticket-type-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_bi_form_case_ratio_view':
      return import('./views/test-case-bi-form-case-ratio-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_type_grid_view':
      return import('./views/work-item-type-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_my_attention_grid_view':
      return import('./views/test-case-my-attention-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_waterfall_flow_setting_tab_view':
      return import('./views/project-waterfall-flow-setting-tab-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_team_grid_view':
      return import('./views/library-team-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_tags_tciket_grid_view':
      return import('./views/ticket-tags-tciket-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_kanban_backlog_daily_trend_report_view':
      return import(
        './views/work-item-kanban-backlog-daily-trend-report-view'
      ).then(m => m.default as unknown as IAppView);
    case 'project_deleted_grid_view':
      return import('./views/project-deleted-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'references_index_grid_view':
      return import('./views/references-index-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_setting_actual_executor_view':
      return import('./views/run-setting-actual-executor-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_scrum_backlog_state_report_view':
      return import('./views/work-item-scrum-backlog-state-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_show_edit_view':
      return import('./views/idea-show-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_deleted_grid_view':
      return import('./views/insight-view-deleted-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_sys_bi_cube_dimension_quick_create_dimension':
      return import(
        './views/ps-sys-bi-cube-dimension-quick-create-dimension'
      ).then(m => m.default as unknown as IAppView);
    case 'test_case_case_move_plan_option_view':
      return import('./views/test-case-case-move-plan-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_tag_edit_view':
      return import('./views/product-tag-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_redirect_view':
      return import('./views/sprint-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_grid_view':
      return import('./views/recent-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_kanban_user_stat_report_view':
      return import('./views/work-item-kanban-user-stat-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_only_attchment_view':
      return import('./views/test-case-only-attchment-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'member_all_resource_mpick_up_grid_view':
      return import('./views/member-all-resource-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_group_grid_view':
      return import('./views/discuss-topic-group-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_dashboard_view':
      return import('./views/insight-view-dashboard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_ticket_type_edit_view':
      return import('./views/product-ticket-type-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_others_re_notbug_view':
      return import('./views/work-item-others-re-notbug-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'template_flow_grid_view':
      return import('./views/template-flow-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_create_wizard_view':
      return import('./views/insight-view-create-wizard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_kanban_defect_age_report_view':
      return import('./views/work-item-kanban-defect-age-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_archived_grid_view':
      return import('./views/project-archived-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_calendar_test_case_management_grid_view':
      return import(
        './views/workload-calendar-test-case-management-grid-view'
      ).then(m => m.default as unknown as IAppView);
    case 'discuss_reply_latest_grid_view':
      return import('./views/discuss-reply-latest-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_base_information_edit_view':
      return import('./views/product-base-information-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_daily_test_report_view':
      return import('./views/test-case-daily-test-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_my_attention_grid_view':
      return import('./views/idea-my-attention-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_attachment_grid_view':
      return import('./views/run-attachment-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_kanban_acklog_age_report_view':
      return import('./views/work-item-kanban-acklog-age-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_type_global_setting_view_kanban':
      return import('./views/work-item-type-global-setting-view-kanban').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_scrum_tree_exp_view':
      return import('./views/insight-scrum-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_tree_exp_view':
      return import('./views/run-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_deleted_grid_view':
      return import('./views/portfolio-deleted-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogicnodedesignview_begin':
      return import('./views/psdelogicnodedesignview-begin').then(
        m => m.default as unknown as IAppView,
      );
    case 'scrum_bug_app_data_upload_view':
      return import('./views/scrum-bug-app-data-upload-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_pick_up_grid_view':
      return import('./views/user-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_library_gird_view':
      return import('./views/workload-library-gird-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_main_view':
      return import('./views/product-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_member_project_member_grid_view':
      return import('./views/portfolio-member-project-member-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_edit_view':
      return import('./views/work-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_work_item_re_idea_list_view':
      return import('./views/relation-work-item-re-idea-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_mpick_up_view':
      return import('./views/test-case-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_base_info_custom_view':
      return import('./views/sprint-base-info-custom-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_pick_up_around_view':
      return import('./views/test-plan-pick-up-around-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'shared_space_setting_center_view':
      return import('./views/shared-space-setting-center-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_pick_up_tree_view':
      return import('./views/review-pick-up-tree-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_edit_view':
      return import('./views/review-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogicquick_create_view_schedule':
      return import('./views/psdelogicquick-create-view-schedule').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_redirect_view':
      return import('./views/portfolio-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_move_case_option_view':
      return import('./views/test-case-move-case-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_others_re_ticket_mpick_up_grid_view':
      return import('./views/ticket-others-re-ticket-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_state_update_view':
      return import('./views/work-item-state-update-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'group_update_view':
      return import('./views/group-update-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_plan_edit_view':
      return import('./views/product-plan-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_test_ai_main_view':
      return import('./views/ticket-test-ai-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_state_edit_view':
      return import('./views/work-item-state-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_data_view':
      return import('./views/recent-data-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_member_edit_view':
      return import('./views/space-member-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdems_logic_ms_logic_design_custom':
      return import('./views/psdems-logic-ms-logic-design-custom').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_test_drill_detail_grid_view':
      return import('./views/work-item-test-drill-detail-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_member_test_list_view':
      return import('./views/project-member-test-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_is_archived_grid_view':
      return import('./views/product-is-archived-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_sys_bi_cube_dimension_edit_view':
      return import('./views/ps-sys-bi-cube-dimension-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogicquick_cfg_view':
      return import('./views/psdelogicquick-cfg-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_conclude_edit_view':
      return import('./views/test-plan-conclude-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_content_no_grid_view_all':
      return import('./views/review-content-no-grid-view-all').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_run_re_work_item_grid_view':
      return import('./views/relation-run-re-work-item-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_complete_review_option_view':
      return import('./views/review-complete-review-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'search_attachment_edit_view':
      return import('./views/search-attachment-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_group_duration_link_grid_view':
      return import('./views/workload-group-duration-link-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_tag_tag_grid_view':
      return import('./views/product-tag-tag-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'comment_customer_connect_list_view':
      return import('./views/comment-customer-connect-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_project_grid_view':
      return import('./views/test-plan-project-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_base_info_edit_view':
      return import('./views/insight-view-base-info-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_drill_detail_grid_view':
      return import('./views/sprint-drill-detail-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_bi_form_ticket_ratio':
      return import('./views/ticket-bi-form-ticket-ratio').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_advanced_search_grid_view':
      return import('./views/idea-advanced-search-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_comparative_analysis_report_view':
      return import('./views/run-comparative-analysis-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_tree_exp_view':
      return import('./views/user-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_info_view':
      return import('./views/space-info-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'search_attachment_advanced_search_grid_view':
      return import('./views/search-attachment-advanced-search-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_redirect_view':
      return import('./views/workload-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'parameter_edit_view':
      return import('./views/parameter-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_baseline_grid_view':
      return import('./views/review-baseline-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_filter_grid_view':
      return import('./views/run-filter-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_team_grid_view':
      return import('./views/space-team-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_index_view':
      return import('./views/library-index-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_all_grid_view':
      return import('./views/test-case-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_update_option_view':
      return import('./views/test-plan-update-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_run_re_idea_grid_view':
      return import('./views/relation-run-re-idea-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogicglobal_flow_grid_view':
      return import('./views/psdelogicglobal-flow-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_org_grid_view':
      return import('./views/product-org-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_all_scrum_grid_view':
      return import('./views/work-item-all-scrum-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_scrum_require_tree_grid_view':
      return import('./views/work-item-scrum-require-tree-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_move_library_view':
      return import('./views/library-move-library-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogiclinkdesigneditview_ms':
      return import('./views/psdelogiclinkdesigneditview-ms').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_plan_work_item_mpick_up_view':
      return import('./views/work-item-plan-work-item-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_scrum_defect_age_report_view':
      return import('./views/work-item-scrum-defect-age-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_reply_my_grid_view':
      return import('./views/discuss-reply-my-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_sys_bi_cube_measure_all_grid_view':
      return import('./views/ps-sys-bi-cube-measure-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'customer_test_tree_select_grid_view':
      return import('./views/customer-test-tree-select-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_base_info_edit_view':
      return import('./views/library-base-info-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_config_tab_exp_view':
      return import('./views/ticket-config-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dictionary_data_idea_confirm_remove_view':
      return import('./views/dictionary-data-idea-confirm-remove-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_burn_out_custom_view':
      return import('./views/work-item-burn-out-custom-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_advanced_search_grid_view':
      return import('./views/test-case-advanced-search-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_wizard_detail_redirect_view':
      return import('./views/work-item-wizard-detail-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_release_relation_grid_view':
      return import('./views/sprint-release-relation-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_field_grid_view':
      return import('./views/psde-field-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_bug_main_view':
      return import('./views/work-item-bug-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_category_grid_view':
      return import('./views/space-category-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dyna_dashboard_show_edit_view':
      return import('./views/dyna-dashboard-show-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_others_re_mpick_up_grid_view':
      return import('./views/test-case-others-re-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'category_pick_up_grid_view':
      return import('./views/category-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_waterfall_require_tree_grid_view':
      return import('./views/work-item-waterfall-require-tree-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogicnodequickcreateview_msnode2':
      return import('./views/psdelogicnodequickcreateview-msnode-2').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_space_create_view':
      return import('./views/baseline-space-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_usr07302198_grid_view':
      return import('./views/work-item-usr-07302198-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_is_archived_grid_view':
      return import('./views/project-is-archived-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_advanced_search_grid_view':
      return import('./views/article-page-advanced-search-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_not_add_pick_up_grid_view':
      return import('./views/test-case-not-add-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'references_index_index_pick_up_data_view':
      return import('./views/references-index-index-pick-up-data-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_advanced_setting_edit_view':
      return import('./views/insight-view-advanced-setting-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'guideline_edit_view':
      return import('./views/guideline-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_team_grid_view':
      return import('./views/product-team-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_baseline_mpick_up_grid_view':
      return import('./views/idea-baseline-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_product_update_view':
      return import('./views/baseline-product-update-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_pick_up_view':
      return import('./views/product-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_choose_child_mpick_up_grid_view':
      return import('./views/work-item-choose-child-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_edit_view':
      return import('./views/test-case-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_alteration_redirect_view':
      return import('./views/sprint-alteration-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_mpick_up_view_review':
      return import('./views/test-case-mpick-up-view-review').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_create_wizard_view':
      return import('./views/product-create-wizard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_grid_view':
      return import('./views/insight-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'resource_member_edit_view':
      return import('./views/resource-member-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dictionary_data_redirect_view':
      return import('./views/dictionary-data-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_work_item_testdyna':
      return import('./views/work-item-work-item-testdyna').then(
        m => m.default as unknown as IAppView,
      );
    case 'addon_no_name_setting_grid_view':
      return import('./views/addon-no-name-setting-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_member_role_edit_view':
      return import('./views/library-member-role-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_product_main_view':
      return import('./views/baseline-product-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_pick_up_around_view':
      return import('./views/release-pick-up-around-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_kanban_work_item_report_view':
      return import('./views/work-item-kanban-work-item-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_tag_new_option_view':
      return import('./views/project-tag-new-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'deliverable_redirect_view':
      return import('./views/deliverable-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_bi_form_view_item_bug':
      return import('./views/work-item-bi-form-view-item-bug').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_history_grid_view':
      return import('./views/run-history-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_quick_create_view':
      return import('./views/work-item-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_idea_redirect_view':
      return import('./views/baseline-idea-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'addon_product_setting_grid_view':
      return import('./views/addon-product-setting-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_test_case_comparison_grid_view':
      return import('./views/baseline-test-case-comparison-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_relation_mpick_up_view':
      return import('./views/release-relation-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_ticket_type_global_setting_view':
      return import('./views/product-ticket-type-global-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_member_config_grid_view':
      return import('./views/space-member-config-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'comment_wiki_list_view':
      return import('./views/comment-wiki-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_idea_filter_grid_view':
      return import('./views/idea-idea-filter-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'stencil_model_edit_view':
      return import('./views/stencil-model-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_product_plan_re_idea_view':
      return import('./views/idea-product-plan-re-idea-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'search_comment_edit_view':
      return import('./views/search-comment-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_release_work_item_custom_view':
      return import('./views/work-item-release-work-item-custom-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_recover_tab_exp_view':
      return import('./views/product-recover-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_work_item_relation_grid_view':
      return import('./views/baseline-work-item-relation-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_drill_detail_grid_view':
      return import('./views/release-drill-detail-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_version_comparison_view':
      return import('./views/test-case-version-comparison-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_idea_re_work_item_grid_view':
      return import('./views/relation-idea-re-work-item-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_report_tree_exp_view':
      return import('./views/insight-report-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_management_member_calendar_grid_view':
      return import(
        './views/workload-management-member-calendar-grid-view'
      ).then(m => m.default as unknown as IAppView);
    case 'comment_redirect_view':
      return import('./views/comment-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_main_view':
      return import('./views/idea-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogicflow_main_view':
      return import('./views/psdelogicflow-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_my_created_grid_view':
      return import('./views/ticket-my-created-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_quick_cfg_view':
      return import('./views/user-quick-cfg-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_my_attention_grid_view':
      return import('./views/work-item-my-attention-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_tab_exp_view':
      return import('./views/discuss-topic-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_upload_view':
      return import('./views/article-page-upload-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_member_role_edit_view':
      return import('./views/discuss-member-role-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'addon_resource_quick_edit_view':
      return import('./views/addon-resource-quick-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_my_craeted_grid_view':
      return import('./views/test-case-my-craeted-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_template_create_edit_view':
      return import('./views/idea-template-create-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_waterfall_tree_grid_view':
      return import('./views/work-item-waterfall-tree-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_sprint_grid_view':
      return import('./views/test-plan-sprint-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_relation_mpick_up_grid_view':
      return import('./views/sprint-relation-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_dyna_waterfall_grid_view':
      return import('./views/work-item-dyna-waterfall-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_kanban_flow_setting_tab_view':
      return import('./views/project-kanban-flow-setting-tab-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'customer_tree_exp_view':
      return import('./views/customer-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_pick_up_grid_view':
      return import('./views/sprint-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_product_grid_view':
      return import('./views/baseline-product-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_work_item_re_test_case_grid_view':
      return import('./views/relation-work-item-re-test-case-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'stencil_show_edit_view':
      return import('./views/stencil-show-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_test_case_re_bug_grid_view':
      return import('./views/relation-test-case-re-bug-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_recent_page_grid_view':
      return import('./views/recent-recent-page-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_release_relation_grid_view':
      return import('./views/test-plan-release-relation-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_change_time_view':
      return import('./views/work-item-change-time-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_backlog_daily_trend_report_view':
      return import('./views/work-item-backlog-daily-trend-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_notify_tab_exp_view':
      return import('./views/psde-notify-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_tree_exp_view':
      return import('./views/project-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_categories_pick_up_tree_view':
      return import('./views/test-plan-categories-pick-up-tree-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_tag_redirect_view':
      return import('./views/project-tag-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_re_self_mpick_up_view':
      return import('./views/idea-re-self-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_setting_member_view':
      return import('./views/library-setting-member-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_logic_design_edit_view':
      return import('./views/psde-logic-design-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_template_redirect_view':
      return import('./views/idea-template-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_version_comparison_view':
      return import('./views/idea-version-comparison-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_type_pick_up_grid_view':
      return import('./views/ticket-type-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_re_show_view':
      return import('./views/article-page-re-show-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_content_edit_view':
      return import('./views/review-content-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_grid_view':
      return import('./views/idea-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_filter_tab_exp_view':
      return import('./views/library-filter-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_management_tab_exp_view':
      return import('./views/insight-view-management-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_notify_edit_view':
      return import('./views/psde-notify-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_redirect_view':
      return import('./views/user-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_post_move_choose_view':
      return import('./views/discuss-post-move-choose-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_edit_view':
      return import('./views/user-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_report_baseinfo_edit_view':
      return import('./views/insight-report-baseinfo-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'resource_member_binding_grid_view':
      return import('./views/resource-member-binding-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'customer_idea_customer_info_view':
      return import('./views/customer-idea-customer-info-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'version_test_case_grid_view':
      return import('./views/version-test-case-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_pick_up_grid_view':
      return import('./views/product-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_work_type_grid_view':
      return import('./views/workload-work-type-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogicflow_panel_view':
      return import('./views/psdelogicflow-panel-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_type_global_grid_view':
      return import('./views/work-item-type-global-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_move_discuss_topic_view':
      return import('./views/discuss-topic-move-discuss-topic-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_all_grid_view':
      return import('./views/discuss-topic-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_setting_view':
      return import('./views/discuss-topic-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_implementationresults_option_view':
      return import('./views/run-implementationresults-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_grid_view':
      return import('./views/work-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'job_pick_up_grid_view':
      return import('./views/job-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_idea_re_ticket_statistics_view':
      return import('./views/ticket-idea-re-ticket-statistics-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'addon_resource_redirect_view':
      return import('./views/addon-resource-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_grid_view':
      return import('./views/discuss-topic-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_create_wizard_view':
      return import('./views/review-create-wizard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_edit_view':
      return import('./views/run-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_my_favorite_page_grid_view':
      return import('./views/article-page-my-favorite-page-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_page_edit_view':
      return import('./views/baseline-page-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_dashboard_view':
      return import('./views/recent-dashboard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_redirect_view':
      return import('./views/relation-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_kanban_backlog_property_report_view':
      return import(
        './views/work-item-kanban-backlog-property-report-view'
      ).then(m => m.default as unknown as IAppView);
    case 'product_tag_new_option_view':
      return import('./views/product-tag-new-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_pick_up_view':
      return import('./views/work-item-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_type_confirm_remove_view':
      return import('./views/ticket-type-confirm-remove-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_test_edit_view':
      return import('./views/article-page-test-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_tree_exp_view':
      return import('./views/release-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_project_tree_exp_view':
      return import('./views/baseline-project-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_re_mpick_up_grid_view':
      return import('./views/work-item-re-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'guideline_library_all_grid_view':
      return import('./views/guideline-library-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_redirect_view':
      return import('./views/library-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_pick_up_view':
      return import('./views/test-plan-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_setting_view':
      return import('./views/user-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_type_pick_up_grid_view':
      return import('./views/work-item-type-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_test_case_edit_view':
      return import('./views/baseline-test-case-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_grid_view':
      return import('./views/work-item-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_project_grid_view':
      return import('./views/baseline-project-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'transition_history_ticket_calendar_view':
      return import('./views/transition-history-ticket-calendar-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_report_redirect_view':
      return import('./views/insight-report-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_kanban_grid_view':
      return import('./views/insight-kanban-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_show_custom_view':
      return import('./views/article-page-show-custom-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_post_tree_exp_view':
      return import('./views/discuss-post-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_tree_exp_view':
      return import('./views/space-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_main_view':
      return import('./views/run-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_product_tree_exp_view':
      return import('./views/baseline-product-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_unassigned_dept_grid_view':
      return import('./views/user-unassigned-dept-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_run_re_run_history_edit_view':
      return import('./views/run-run-re-run-history-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_qucik_create_view':
      return import('./views/article-page-qucik-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_my_todo_gird_view':
      return import('./views/work-item-my-todo-gird-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'shared_space_setting_view':
      return import('./views/shared-space-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_set_name_version_option_view':
      return import('./views/article-page-set-name-version-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_list_view':
      return import('./views/workload-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_waterfall_bug_grid_view':
      return import('./views/work-item-waterfall-bug-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_not_add_pick_up_grid_view_review':
      return import('./views/test-case-not-add-pick-up-grid-view-review').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_details_setting_tree_exp_view':
      return import('./views/library-details-setting-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_drill_detail_grid_view':
      return import('./views/ticket-drill-detail-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'customer_redirect_view':
      return import('./views/customer-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_idea_re_plan_option_view':
      return import('./views/idea-idea-re-plan-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogiceditview':
      return import('./views/psdelogiceditview').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_test_all_grid_view':
      return import('./views/test-case-test-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'extend_log_info_view':
      return import('./views/extend-log-info-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_create_wizard_view':
      return import('./views/project-create-wizard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_quick_create_view':
      return import('./views/idea-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_library_update_view':
      return import('./views/baseline-library-update-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_redirect_view':
      return import('./views/release-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_idea_re_idea_grid_view':
      return import('./views/relation-idea-re-idea-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_person_distributions_report_view':
      return import('./views/test-case-person-distributions-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_prickup_grid_view':
      return import('./views/idea-prickup-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_redirect_view':
      return import('./views/insight-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'references_index_index_pick_up_view':
      return import('./views/references-index-index-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_report_system_report_grid_view':
      return import('./views/insight-report-system-report-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'login_log_active_members':
      return import('./views/login-log-active-members').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_post_all_grid_view':
      return import('./views/discuss-post-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'version_pick_up_view':
      return import('./views/version-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_shared_setting_view':
      return import('./views/article-page-shared-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'activity_history_list_view':
      return import('./views/activity-history-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_my_assignee_grid_view':
      return import('./views/ticket-my-assignee-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_re_self_mpick_up_grid_view':
      return import('./views/work-item-re-self-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_tag_tag_grid_view':
      return import('./views/project-tag-tag-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_details_setting_view':
      return import('./views/space-details-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_un_plan_grid_view':
      return import('./views/ticket-un-plan-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dyna_dashboard_edit_view':
      return import('./views/dyna-dashboard-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_my_created_grid_view':
      return import('./views/work-item-my-created-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_config_tree_exp_view':
      return import('./views/project-config-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'comment_edit_view':
      return import('./views/comment-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_pick_up_around_gird_view':
      return import('./views/test-plan-pick-up-around-gird-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_member_role_edit_view':
      return import('./views/portfolio-member-role-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'favorite_redirect_view':
      return import('./views/favorite-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_project_set_tab_exp_view':
      return import('./views/portfolio-project-set-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_tab_exp_view':
      return import('./views/space-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_all_grid_view':
      return import('./views/project-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'addon_resource_project_capacity_view':
      return import('./views/addon-resource-project-capacity-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_type_confirm_remove_view':
      return import('./views/workload-type-confirm-remove-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_calendar_duration_link_grid_view':
      return import('./views/workload-calendar-duration-link-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workspace_tab_exp_view':
      return import('./views/workspace-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_test_tab_exp_view':
      return import('./views/work-item-test-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_notify_event_hook_edit_view':
      return import('./views/psde-notify-event-hook-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dyna_dashboard_redirect_view':
      return import('./views/dyna-dashboard-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_type_quick_create_view':
      return import('./views/workload-type-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_management_tab_exp_view':
      return import('./views/discuss-topic-management-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_waterfall_main_view':
      return import('./views/project-waterfall-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdeformdesign_modal':
      return import('./views/psdeformdesign-modal').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_this_suite_test_case_grid_view':
      return import('./views/test-case-this-suite-test-case-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_test_case_grid_view':
      return import('./views/review-test-case-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_edit_view':
      return import('./views/ticket-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_un_scheduled_pickup_grid_view':
      return import('./views/idea-un-scheduled-pickup-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_library_tree_exp_view':
      return import('./views/baseline-library-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogicnodedesignview_msnode2':
      return import('./views/psdelogicnodedesignview-msnode-2').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_create_wizard_view':
      return import('./views/library-create-wizard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_archived_grid_view':
      return import('./views/discuss-topic-archived-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_project_create_view':
      return import('./views/baseline-project-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'stage_quick_create_view':
      return import('./views/stage-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_snapshot_management_gird_view':
      return import('./views/baseline-snapshot-management-gird-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_report_bi_report_panel_view':
      return import('./views/insight-report-bi-report-panel-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_data_grid_main':
      return import('./views/project-data-grid-main').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_pick_up_grid_view':
      return import('./views/portfolio-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_recycle_bin_edit_view':
      return import('./views/work-item-recycle-bin-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_tag_grid_view':
      return import('./views/project-tag-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_change_state_view':
      return import('./views/work-item-change-state-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_test_case_re_work_item_grid_view':
      return import('./views/relation-test-case-re-work-item-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_my_reviewed_grid_view':
      return import('./views/review-my-reviewed-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dictionary_data_ticket_state_grid_view':
      return import('./views/dictionary-data-ticket-state-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'version_redirect_view':
      return import('./views/version-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_work_item_re_test_case_list_view':
      return import('./views/relation-work-item-re-test-case-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_members_distribution_option_view':
      return import('./views/run-members-distribution-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_main_view':
      return import('./views/work-item-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'management_setting_view':
      return import('./views/management-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_pickup_grid_view':
      return import('./views/discuss-topic-pickup-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_member_edit_view':
      return import('./views/product-member-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_type_setting_view_scrum':
      return import('./views/work-item-type-setting-view-scrum').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_update_view':
      return import('./views/sprint-update-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_reply_list_view':
      return import('./views/discuss-reply-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_core_prd_func_info_view':
      return import('./views/ps-core-prd-func-info-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_all_grid_view':
      return import('./views/test-plan-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_drill_detail_grid_view':
      return import('./views/run-drill-detail-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'management_config_tab_exp_view':
      return import('./views/management-config-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_copy_page_option_view':
      return import('./views/article-page-copy-page-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_copy_view':
      return import('./views/work-item-copy-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_edit_view':
      return import('./views/release-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'activity_pick_up_grid_view':
      return import('./views/activity-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_my_attention_grid_view':
      return import('./views/review-my-attention-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_version_comparison_view':
      return import('./views/work-item-version-comparison-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'stencil_space_all_grid_view':
      return import('./views/stencil-space-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'activity_pick_up_view':
      return import('./views/activity-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_management_duration_link_grid_view':
      return import('./views/workload-management-duration-link-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dictionary_data_global_edit_view':
      return import('./views/dictionary-data-global-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_move_page_option_view':
      return import('./views/article-page-move-page-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_tree_exp_view':
      return import('./views/test-case-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_tag_edit_view':
      return import('./views/project-tag-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_milestone_grid_view':
      return import('./views/work-item-milestone-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_calendar_management_view':
      return import('./views/workload-calendar-management-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'customer_app_data_upload_view':
      return import('./views/customer-app-data-upload-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_edit_view':
      return import('./views/library-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_redirect_view':
      return import('./views/project-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_edit_snapshot_view':
      return import('./views/baseline-edit-snapshot-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_deleted_grid_view':
      return import('./views/product-deleted-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_template_show_edit_view':
      return import('./views/test-case-template-show-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_move_option_view':
      return import('./views/insight-view-move-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'guideline_redirect_view':
      return import('./views/guideline-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogicflow_grid_view':
      return import('./views/psdelogicflow-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_overview_base_view':
      return import('./views/release-overview-base-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_main_view':
      return import('./views/review-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'stencil_save_option_view':
      return import('./views/stencil-save-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_quick_create_view':
      return import('./views/ticket-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_space_categories_pick_up_tree_view':
      return import('./views/baseline-space-categories-pick-up-tree-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_scrum_property_distribution_report_view':
      return import(
        './views/work-item-scrum-property-distribution-report-view'
      ).then(m => m.default as unknown as IAppView);
    case 'ticket_type_redirect_view':
      return import('./views/ticket-type-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_notify_list_view_setting':
      return import('./views/psde-notify-list-view-setting').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_members_distribution_report_view':
      return import('./views/run-members-distribution-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_scrum_bug_daily_tide_report_view':
      return import('./views/work-item-scrum-bug-daily-tide-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_base_info_edit_view':
      return import('./views/space-base-info-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_create_re_ticket_view':
      return import('./views/ticket-create-re-ticket-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_type_redirect_view':
      return import('./views/work-item-type-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_bi_form_view_item_state':
      return import('./views/work-item-bi-form-view-item-state').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_wizard_detail_edit_view':
      return import('./views/work-item-wizard-detail-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_setting_view':
      return import('./views/space-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_after_new_edit_view':
      return import('./views/article-page-after-new-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_kanban_index_view':
      return import('./views/project-kanban-index-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_wizard_detail_target_type_grid_view':
      return import(
        './views/work-item-wizard-detail-target-type-grid-view'
      ).then(m => m.default as unknown as IAppView);
    case 'test_case_mpick_up_view2_review':
      return import('./views/test-case-mpick-up-view-2-review').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_all_grid_view':
      return import('./views/idea-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_test_plan_bug_grid_view':
      return import('./views/work-item-test-plan-bug-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_type_of_link_management_grid_view':
      return import('./views/workload-type-of-link-management-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_grid_view':
      return import('./views/product-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogiclogicdesign':
      return import('./views/psdelogiclogicdesign').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_org_grid_view':
      return import('./views/discuss-topic-org-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_my_part_grid_view':
      return import('./views/test-plan-my-part-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_content_set_result_edit_view':
      return import('./views/review-content-set-result-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_account_view':
      return import('./views/user-account-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_catrgories_pick_up_tree_view':
      return import('./views/sprint-catrgories-pick-up-tree-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_filter_grid_view':
      return import('./views/ticket-filter-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'board_grid_view':
      return import('./views/board-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_my_assign_grid_view':
      return import('./views/ticket-my-assign-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_grid_view':
      return import('./views/project-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_tree_exp_view':
      return import('./views/article-page-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_re_self_mpick_up_view':
      return import('./views/work-item-re-self-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_release_grid_view':
      return import('./views/work-item-release-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_archived_grid_view':
      return import('./views/library-archived-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_archived_grid_view':
      return import('./views/space-archived-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_allocate_person_view':
      return import('./views/ticket-allocate-person-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_core_prd_func_tree_exp_view':
      return import('./views/ps-core-prd-func-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_base_information_edit_view':
      return import('./views/project-base-information-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_member_config_grid_view':
      return import('./views/library-member-config-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_day_link_grid_view':
      return import('./views/workload-day-link-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dictionary_data_idea_state_grid_view':
      return import('./views/dictionary-data-idea-state-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_type_pick_up_tap_exp_view':
      return import('./views/workload-type-pick-up-tap-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_redirect_view':
      return import('./views/review-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_pick_up_grid_view':
      return import('./views/test-plan-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_tab_exp_view':
      return import('./views/insight-view-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_ticket_re_idea_grid_view':
      return import('./views/relation-ticket-re-idea-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_setting_view':
      return import('./views/project-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_app_portlet_edit_view':
      return import('./views/ps-app-portlet-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_all_kanban_grid_view':
      return import('./views/work-item-all-kanban-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'version_edit_version_view':
      return import('./views/version-edit-version-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'category_pick_up_view':
      return import('./views/category-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'member_portfolio_resource_mpick_up_view':
      return import('./views/member-portfolio-resource-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_member_assigned_grid_view':
      return import('./views/product-member-assigned-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_redirect_view':
      return import('./views/article-page-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_help_tree_exp_view':
      return import('./views/article-page-help-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_all_grid_view':
      return import('./views/sprint-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'app_index_view':
      return import('./views/app-index-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_dyna_srcum_tree_grid_view':
      return import('./views/work-item-dyna-srcum-tree-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_grid_view':
      return import('./views/ticket-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_report_custom_view':
      return import('./views/test-plan-report-custom-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_kanban_defect_property_report_view':
      return import(
        './views/work-item-kanban-defect-property-report-view'
      ).then(m => m.default as unknown as IAppView);
    case 'library_member_edit_view':
      return import('./views/library-member-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'management_tab_exp_view':
      return import('./views/management-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_baseline_mpick_up_view':
      return import('./views/idea-baseline-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_idea_re_customer_list_view':
      return import('./views/relation-idea-re-customer-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdemslogicmslogicdesign_modal':
      return import('./views/psdemslogicmslogicdesign-modal').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_redirect_view':
      return import('./views/test-case-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'group_quick_create_view':
      return import('./views/group-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_dyna_kanban_grid_view':
      return import('./views/work-item-dyna-kanban-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_my_created_grid_view':
      return import('./views/review-my-created-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_work_item_realtion_version_list_view':
      return import(
        './views/baseline-work-item-realtion-version-list-view'
      ).then(m => m.default as unknown as IAppView);
    case 'department_pick_up_grid_view':
      return import('./views/department-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_pick_up_view':
      return import('./views/release-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'section_pick_up_view':
      return import('./views/section-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_user_pick_up_tree_view':
      return import('./views/user-user-pick-up-tree-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_mpick_up_view':
      return import('./views/portfolio-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_create_re_idea_view':
      return import('./views/idea-create-re-idea-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_member_redirect_view':
      return import('./views/product-member-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_shift_in_kanban':
      return import('./views/work-item-shift-in-kanban').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_config_tree_exp_view':
      return import('./views/product-config-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_library_tree_exp_view':
      return import('./views/insight-library-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'deliverable_quick_create_view':
      return import('./views/deliverable-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_type_of_link_grid_view':
      return import('./views/workload-type-of-link-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_test_grid_view':
      return import('./views/article-page-test-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_show_view':
      return import('./views/article-page-show-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_drill_detail_grid_view':
      return import('./views/idea-drill-detail-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'customer_main_view':
      return import('./views/customer-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'kan_ban_work_item_app_data_upload_view':
      return import('./views/kan-ban-work-item-app-data-upload-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_copy_option_view':
      return import('./views/idea-copy-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'member_shared_page_list_view':
      return import('./views/member-shared-page-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_data_exp_view':
      return import('./views/recent-data-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_tree_exp_view':
      return import('./views/ticket-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_work_item_re_self_grid_view':
      return import('./views/relation-work-item-re-self-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_tree_exp_view':
      return import('./views/review-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_library_grid_view':
      return import('./views/insight-library-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dyna_dashboard_list_exp_view':
      return import('./views/dyna-dashboard-list-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_report_quick_create_view':
      return import('./views/insight-report-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_baseline_mpick_up_grid_view':
      return import('./views/work-item-baseline-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'addon_project_setting_grid_view':
      return import('./views/addon-project-setting-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'addon_resource_edit_view':
      return import('./views/addon-resource-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_others_re_mpick_up_grid_view':
      return import('./views/idea-others-re-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'shared_space_redirect_view':
      return import('./views/shared-space-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_post_my_reply_grid_view':
      return import('./views/discuss-post-my-reply-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_re_mpick_up_view':
      return import('./views/work-item-re-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_idea_re_ticket_chart_view':
      return import('./views/ticket-idea-re-ticket-chart-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'version_quick_create_view':
      return import('./views/version-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_type_pick_up_view':
      return import('./views/ticket-type-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'department_pick_up_view':
      return import('./views/department-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_test_case_re_work_item_list_view':
      return import('./views/relation-test-case-re-work-item-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_pick_up_tree_view':
      return import('./views/test-case-pick-up-tree-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_customer_re_ticket_grid_view':
      return import('./views/ticket-customer-re-ticket-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_core_prd_market_application_view':
      return import('./views/ps-core-prd-market-application-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_org_grid_view':
      return import('./views/insight-view-org-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'job_pick_up_view':
      return import('./views/job-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_my_assignee_item_tap_exp_view':
      return import('./views/recent-my-assignee-item-tap-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_project_edit_view':
      return import('./views/portfolio-project-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogictemplate_info_view':
      return import('./views/psdelogictemplate-info-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_idea_re_test_case_list_view':
      return import('./views/relation-idea-re-test-case-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_template_pickup_view':
      return import('./views/test-case-template-pickup-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_create_form_stencil_edit_view':
      return import('./views/article-page-create-form-stencil-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_member_role_edit_view':
      return import('./views/space-member-role-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_pick_up_view':
      return import('./views/sprint-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_member_bind_grid_view':
      return import('./views/discuss-member-bind-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'section_pick_up_grid_view':
      return import('./views/section-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dyna_dashboard_test_dashboard_view':
      return import('./views/dyna-dashboard-test-dashboard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_notify_field_change_hook_grid_view':
      return import('./views/psde-notify-field-change-hook-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_redirect_view':
      return import('./views/ticket-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogicredirectview':
      return import('./views/psdelogicredirectview').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogicquick_create_view_auto_flow':
      return import('./views/psdelogicquick-create-view-auto-flow').then(
        m => m.default as unknown as IAppView,
      );
    case 'attention_tab_exp_view':
      return import('./views/attention-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'login_log_edit_view':
      return import('./views/login-log-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_notice_edit_view':
      return import('./views/project-notice-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_quick_create_view':
      return import('./views/sprint-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_setting_view':
      return import('./views/library-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_advanced_setting_edit_view':
      return import('./views/library-advanced-setting-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_edit_view':
      return import('./views/workload-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_grid_view':
      return import('./views/library-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_srcum_tree_grid_view':
      return import('./views/work-item-srcum-tree-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_baseline_mpick_up_view':
      return import('./views/article-page-baseline-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_report_all_report_grid_view':
      return import('./views/insight-report-all-report-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_tab_search_view':
      return import('./views/workload-tab-search-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'attachment_run_re_attachment_grid_view':
      return import('./views/attachment-run-re-attachment-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_pick_up_grid_view':
      return import('./views/project-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_pickup_view':
      return import('./views/discuss-topic-pickup-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_wizard_detail_change_confirm_grid_view':
      return import(
        './views/work-item-wizard-detail-change-confirm-grid-view'
      ).then(m => m.default as unknown as IAppView);
    case 'test_case_re_run_main_view':
      return import('./views/test-case-re-run-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'addon_setting_grid_view':
      return import('./views/addon-setting-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'activity_test_all_list_view':
      return import('./views/activity-test-all-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_project_grid_view':
      return import('./views/portfolio-project-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_idea_re_ticket_pick_up_view':
      return import('./views/ticket-idea-re-ticket-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_kanban_main_view':
      return import('./views/project-kanban-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_member_redirect_view':
      return import('./views/project-member-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_update_view':
      return import('./views/release-update-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_app_data_upload_view':
      return import('./views/idea-app-data-upload-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_change_stage_view':
      return import('./views/release-change-stage-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_page_relation_grid_view':
      return import('./views/baseline-page-relation-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_management_tab_exp_view':
      return import('./views/project-management-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'stencil_redirect_view':
      return import('./views/stencil-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_test_case_re_idea_list_view':
      return import('./views/relation-test-case-re-idea-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_type_global_setting_view_scrum':
      return import('./views/work-item-type-global-setting-view-scrum').then(
        m => m.default as unknown as IAppView,
      );
    case 'member_project_resource_mpick_up_view':
      return import('./views/member-project-resource-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_create_plan_snapshot_view':
      return import('./views/baseline-create-plan-snapshot-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_dyna_create_view':
      return import('./views/work-item-dyna-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_report_edit_view':
      return import('./views/insight-report-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_is_deleted_grid_view':
      return import('./views/discuss-topic-is-deleted-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dictionary_data_grid_view':
      return import('./views/dictionary-data-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_content_list_view':
      return import('./views/review-content-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_tag_project_tag_confirm_remove_view':
      return import('./views/project-tag-project-tag-confirm-remove-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_change_assignee_view':
      return import('./views/work-item-change-assignee-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_overview_dashboard_view':
      return import('./views/release-overview-dashboard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_info_custom_view':
      return import('./views/user-info-custom-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_post_quick_create_view':
      return import('./views/discuss-post-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_team_grid_view':
      return import('./views/project-team-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'group_tree_exp_view':
      return import('./views/group-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_data_test_view':
      return import('./views/recent-data-test-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_history_re_run_edit_view':
      return import('./views/run-history-re-run-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_calendar_idea_management_grid_view':
      return import('./views/workload-calendar-idea-management-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_main_view':
      return import('./views/ticket-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_index_view':
      return import('./views/insight-view-index-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_custom_view':
      return import('./views/insight-view-custom-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_set_maintenance_option_view':
      return import('./views/test-case-set-maintenance-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_main_view':
      return import('./views/test-plan-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_redirect_view':
      return import('./views/idea-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_edit_view':
      return import('./views/article-page-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_calendar_idea_grid_view':
      return import('./views/workload-calendar-idea-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_in_progress_grid_view':
      return import('./views/product-in-progress-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_recent_test_case_grid_view':
      return import('./views/recent-recent-test-case-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_sys_bi_cube_dimension_redirect_view':
      return import('./views/ps-sys-bi-cube-dimension-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_pickup_grid_view':
      return import('./views/insight-view-pickup-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_redirect_view':
      return import('./views/recent-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_template_new_edit_view':
      return import('./views/test-case-template-new-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_pick_up_around_grid_view':
      return import('./views/sprint-pick-up-around-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_choose_pick_up_grid_view':
      return import('./views/user-choose-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_overview_dashboard_view':
      return import('./views/sprint-overview-dashboard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_redirect_view':
      return import('./views/work-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_logic_test_auto_rules_edit_view':
      return import('./views/psde-logic-test-auto-rules-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_member_edit_view':
      return import('./views/insight-member-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_under_work_grid_view':
      return import('./views/work-item-under-work-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'addon_resource_quick_create_view':
      return import('./views/addon-resource-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_type_pick_up_grid_view':
      return import('./views/workload-type-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_type_global_edit_view':
      return import('./views/work-item-type-global-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_in_progress_grid_view':
      return import('./views/project-in-progress-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_mpick_up_view':
      return import('./views/project-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_sprint_contribution_grid_view':
      return import('./views/work-item-sprint-contribution-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_idea_re_self_list_view':
      return import('./views/relation-idea-re-self-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_plan_count_grid_view':
      return import('./views/idea-plan-count-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_index_view':
      return import('./views/recent-index-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_all_grid_view':
      return import('./views/space-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'stencil_edit_view':
      return import('./views/stencil-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'scrum_work_item_app_data_upload_view':
      return import('./views/scrum-work-item-app-data-upload-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_member_assigned_grid_view':
      return import('./views/library-member-assigned-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_content_redirect_view':
      return import('./views/review-content-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_plan_tree_exp_view':
      return import('./views/product-plan-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_group_member_grid_view':
      return import('./views/workload-group-member-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dyna_dashboard_dashboard_view_show':
      return import('./views/dyna-dashboard-dashboard-view-show').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_pick_up_view':
      return import('./views/test-case-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_base_information_edit_view':
      return import('./views/discuss-topic-base-information-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_template_pick_up_tree_view':
      return import('./views/idea-template-pick-up-tree-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_management_view':
      return import('./views/workload-management-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_set_grid_view':
      return import('./views/work-item-set-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_bi_form_idea_ratio':
      return import('./views/idea-bi-form-idea-ratio').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_review_re_test_case_grid_view':
      return import('./views/relation-review-re-test-case-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_edit_view':
      return import('./views/relation-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_calendar_view':
      return import('./views/work-item-calendar-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_advanced_setting_edit_view':
      return import('./views/discuss-topic-advanced-setting-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_work_item_re_ticket_grid_view':
      return import('./views/relation-work-item-re-ticket-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'deliverable_target_grid_view':
      return import('./views/deliverable-target-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_member_role_edit_view':
      return import('./views/product-member-role-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_project_setting_view':
      return import('./views/portfolio-project-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_drill_detail_grid_view':
      return import('./views/test-plan-drill-detail-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_filter_grid_view':
      return import('./views/test-case-filter-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_gantt_view':
      return import('./views/work-item-gantt-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'project_global_setting_view':
      return import('./views/project-global-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sprint_tree_exp_view':
      return import('./views/sprint-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psdelogiclogicdesign_readonly':
      return import('./views/psdelogiclogicdesign-readonly').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_core_prd_func_installed_grid_view':
      return import('./views/ps-core-prd-func-installed-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_change_parent_pick_up_grid_view':
      return import('./views/work-item-change-parent-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_index_my_assignee_gird_view':
      return import('./views/work-item-index-my-assignee-gird-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_field_quick_cfg_view':
      return import('./views/psde-field-quick-cfg-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_advanced_setting_edit_view':
      return import('./views/space-advanced-setting-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_setting_view':
      return import('./views/product-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_topic_edit_view':
      return import('./views/discuss-topic-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'stencil_all_grid_view':
      return import('./views/stencil-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_management_tab_exp_view':
      return import('./views/product-management-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_view_show_edit_view':
      return import('./views/insight-view-show-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'stage_update_view':
      return import('./views/stage-update-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_choose_template_option_view':
      return import('./views/test-case-choose-template-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_resource_gantt_view':
      return import('./views/work-item-resource-gantt-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_general_grid_view':
      return import('./views/test-plan-general-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_core_prd_func_market_application_view':
      return import('./views/ps-core-prd-func-market-application-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_edit_view':
      return import('./views/recent-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_advanced_search_grid_view':
      return import('./views/work-item-advanced-search-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'comment_list_view':
      return import('./views/comment-list-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_work_item_redirect_view':
      return import('./views/baseline-work-item-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'addon_resource_project_set_capacity_view':
      return import('./views/addon-resource-project-set-capacity-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'psde_notify_event_hook_grid_view':
      return import('./views/psde-notify-event-hook-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_suite_quick_create_view':
      return import('./views/test-suite-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'discuss_member_redirect_view':
      return import('./views/discuss-member-redirect-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_pick_up_grid_view':
      return import('./views/space-pick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_update_view':
      return import('./views/idea-update-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_baseline_mpick_up_grid_view':
      return import('./views/test-case-baseline-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_submit_grid_view':
      return import('./views/ticket-submit-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_sprint_grid_view':
      return import('./views/work-item-sprint-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_set_category_option_view':
      return import('./views/review-set-category-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_scrum_backlog_flow_report_view':
      return import('./views/work-item-scrum-backlog-flow-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_info_view':
      return import('./views/user-info-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_shared_grid_view':
      return import('./views/article-page-shared-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'addon_resource_all_grid_view':
      return import('./views/addon-resource-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_help_view':
      return import('./views/article-page-help-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_test_report_view':
      return import('./views/work-item-test-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_ticket_re_self_grid_view':
      return import('./views/relation-ticket-re-self-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'notify_setting_config_view_test':
      return import('./views/notify-setting-config-view-test').then(
        m => m.default as unknown as IAppView,
      );
    case 'customer_add_category_option_view':
      return import('./views/customer-add-category-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_drill_detail_grid_view':
      return import('./views/test-case-drill-detail-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'insight_member_role_edit_view':
      return import('./views/insight-member-role-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_run_re_bug_grid_view':
      return import('./views/relation-run-re-bug-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_filter_grid_view':
      return import('./views/article-page-filter-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sys_todo_edit_view':
      return import('./views/sys-todo-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'run_daily_tendencies_option_view':
      return import('./views/run-daily-tendencies-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_others_re_notbug_mpick_up_grid_view':
      return import(
        './views/work-item-others-re-notbug-mpick-up-grid-view'
      ).then(m => m.default as unknown as IAppView);
    case 'recent_custom_dashboard_view':
      return import('./views/recent-custom-dashboard-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'member_project_resource_mpick_up_grid_view':
      return import('./views/member-project-resource-mpick-up-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'favorite_space_grid_view':
      return import('./views/favorite-space-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'review_stage_edit_view':
      return import('./views/review-stage-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'sys_todo_all_grid_view':
      return import('./views/sys-todo-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_plan_edit_option_view':
      return import('./views/product-plan-edit-option-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_project_main_view':
      return import('./views/baseline-project-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_recycle_bin_grid_view':
      return import('./views/work-item-recycle-bin-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_member_edit_view':
      return import('./views/portfolio-member-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'user_mpick_up_view':
      return import('./views/user-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'baseline_page_comparison_grid_view':
      return import('./views/baseline-page-comparison-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'deliverable_project_grid_view':
      return import('./views/deliverable-project-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'library_pick_up_view':
      return import('./views/library-pick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_my_created_tab_exp_view':
      return import('./views/recent-my-created-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_kanban_tree_grid_view':
      return import('./views/work-item-kanban-tree-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ticket_type_quick_create_view':
      return import('./views/ticket-type-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_updated_logs':
      return import('./views/article-page-updated-logs').then(
        m => m.default as unknown as IAppView,
      );
    case 'deliverable_target_edit_view':
      return import('./views/deliverable-target-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dictionary_data_global_tab_exp_view':
      return import('./views/dictionary-data-global-tab-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_sprint_work_item_custom_view':
      return import('./views/work-item-sprint-work-item-custom-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'relation_test_plan_bug_grid_vew':
      return import('./views/relation-test-plan-bug-grid-vew').then(
        m => m.default as unknown as IAppView,
      );
    case 'release_main_view':
      return import('./views/release-main-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_setting_view':
      return import('./views/portfolio-setting-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_document_edit_view':
      return import('./views/article-page-document-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'idea_tree_exp_view':
      return import('./views/idea-tree-exp-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_plan_sprint_relation_grid_view':
      return import('./views/test-plan-sprint-relation-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_show_version_view':
      return import('./views/article-page-show-version-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'addon_resource_all_capacity_view':
      return import('./views/addon-resource-all-capacity-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'article_page_shared_with_me_grid_view':
      return import('./views/article-page-shared-with-me-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'workload_day_link_management_grid_view':
      return import('./views/workload-day-link-management-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_member_config_grid_view':
      return import('./views/product-member-config-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_case_re_bug_mpick_up_view':
      return import('./views/work-item-case-re-bug-mpick-up-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_others_re_view':
      return import('./views/work-item-others-re-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'recent_todo_custom_view':
      return import('./views/recent-todo-custom-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_sys_bi_cube_dimension_all_grid_view':
      return import('./views/ps-sys-bi-cube-dimension-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'ps_sys_bi_cube_measure_edit_view':
      return import('./views/ps-sys-bi-cube-measure-edit-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'dictionary_data_quick_create_view':
      return import('./views/dictionary-data-quick-create-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'portfolio_project_set_advanced_view':
      return import('./views/portfolio-project-set-advanced-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'test_case_daily_tendencies_report_view':
      return import('./views/test-case-daily-tendencies-report-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'product_all_grid_view':
      return import('./views/product-all-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'space_index_view':
      return import('./views/space-index-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'work_item_workload_detail_grid_view':
      return import('./views/work-item-workload-detail-grid-view').then(
        m => m.default as unknown as IAppView,
      );
    case 'waterfall_work_item_app_data_upload_view':
      return import('./views/waterfall-work-item-app-data-upload-view').then(
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
    app.appUtils.forEach((util: IData) => {
      util.appId = app.appId;
    });
    app.appId = undefined;
    return app as IApplication;
  });
}
