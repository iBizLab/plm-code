import { Component, defineAsyncComponent } from 'vue';

function calcAppViewId(tag: string): string {
  let id = '';
  if (tag.indexOf('.') !== -1) {
    const ids = tag.split('.');
    id = ids[ids.length - 1];
  } else {
    id = tag.toLowerCase();
  }
  return id;
}

export async function getAppViewComponent(name: string): Promise<Component> {
  const _name = calcAppViewId(name).toLowerCase();
  switch (_name) {
    case 'idea_others_re_mpick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-others-re-mpick-up-view/idea-others-re-mpick-up-view.vue'
          ),
      );
    case 'customer_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './customer/customer-all-grid-view/customer-all-grid-view.vue'
          ),
      );
    case 'board_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import('./board/board-pick-up-grid-view/board-pick-up-grid-view.vue'),
      );
    case 'space_config_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-config-tree-exp-view/space-config-tree-exp-view.vue'
          ),
      );
    case 'recent_tree_exp_view':
      return defineAsyncComponent(
        () => import('./recent/recent-tree-exp-view/recent-tree-exp-view.vue'),
      );
    case 'sprint_main_view':
      return defineAsyncComponent(
        () => import('./sprint/sprint-main-view/sprint-main-view.vue'),
      );
    case 'customer_idea_re_customer_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './customer/customer-idea-re-customer-grid-view/customer-idea-re-customer-grid-view.vue'
          ),
      );
    case 'user_choose_mpick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './user/user-choose-mpick-up-view/user-choose-mpick-up-view.vue'
          ),
      );
    case 'article_page_recycle_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-recycle-grid-view/article-page-recycle-grid-view.vue'
          ),
      );
    case 'sprint_pick_up_around_view':
      return defineAsyncComponent(
        () =>
          import(
            './sprint/sprint-pick-up-around-view/sprint-pick-up-around-view.vue'
          ),
      );
    case 'portfolio_in_progress_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-in-progress-grid-view/portfolio-in-progress-grid-view.vue'
          ),
      );
    case 'portfolio_project_create_wizard_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-project-create-wizard-view/portfolio-project-create-wizard-view.vue'
          ),
      );
    case 'work_item_bug_state_statement':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-bug-state-statement/work-item-bug-state-statement.vue'
          ),
      );
    case 'project_move_choose_pick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-move-choose-pick-up-view/project-move-choose-pick-up-view.vue'
          ),
      );
    case 'board_pick_up_view':
      return defineAsyncComponent(
        () => import('./board/board-pick-up-view/board-pick-up-view.vue'),
      );
    case 'test_plan_project_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-project-tree-exp-view/test-plan-project-tree-exp-view.vue'
          ),
      );
    case 'project_advanced_setting_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-advanced-setting-edit-view/project-advanced-setting-edit-view.vue'
          ),
      );
    case 'release_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './release/release-quick-create-view/release-quick-create-view.vue'
          ),
      );
    case 'test_case_assessment_result_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-assessment-result-report-view/test-case-assessment-result-report-view.vue'
          ),
      );
    case 'test_case_test_plan_re_test_case_prickup_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-test-plan-re-test-case-prickup-view/test-case-test-plan-re-test-case-prickup-view.vue'
          ),
      );
    case 'project_move_choose_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-move-choose-pick-up-grid-view/project-move-choose-pick-up-grid-view.vue'
          ),
      );
    case 'workload_management_project_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-management-project-grid-view/workload-management-project-grid-view.vue'
          ),
      );
    case 'ticket_archived_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-archived-grid-view/ticket-archived-grid-view.vue'
          ),
      );
    case 'product_tag_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-tag/product-tag-grid-view/product-tag-grid-view.vue'
          ),
      );
    case 'workload_calendar_work_item_management_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-calendar-work-item-management-grid-view/workload-calendar-work-item-management-grid-view.vue'
          ),
      );
    case 'work_item_filter_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-filter-grid-view/work-item-filter-grid-view.vue'
          ),
      );
    case 'library_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import('./library/library-tree-exp-view/library-tree-exp-view.vue'),
      );
    case 'work_item_move_view':
      return defineAsyncComponent(
        () => import('./work-item/work-item-move-view/work-item-move-view.vue'),
      );
    case 'work_item_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-redirect-view/work-item-redirect-view.vue'
          ),
      );
    case 'project_scrum_index_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-scrum-index-view/project-scrum-index-view.vue'
          ),
      );
    case 'portfolio_project_show_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-project-show-view/portfolio-project-show-view.vue'
          ),
      );
    case 'work_item_plan_work_item_mpick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-plan-work-item-mpick-up-grid-view/work-item-plan-work-item-mpick-up-grid-view.vue'
          ),
      );
    case 'test_case_degree_importance_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-degree-importance-report-view/test-case-degree-importance-report-view.vue'
          ),
      );
    case 'work_item_all_waterfall_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-all-waterfall-grid-view/work-item-all-waterfall-grid-view.vue'
          ),
      );
    case 'work_item_test_follow_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-test-follow-edit-view/work-item-test-follow-edit-view.vue'
          ),
      );
    case 'ticket_progress_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-progress-grid-view/ticket-progress-grid-view.vue'
          ),
      );
    case 'work_item_re_self_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-re-self-grid-view/work-item-re-self-grid-view.vue'
          ),
      );
    case 'article_page_statistical_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-statistical-grid-view/article-page-statistical-grid-view.vue'
          ),
      );
    case 'run_redirect_view':
      return defineAsyncComponent(
        () => import('./run/run-redirect-view/run-redirect-view.vue'),
      );
    case 'test_plan_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-tree-exp-view/test-plan-tree-exp-view.vue'
          ),
      );
    case 'workload_calendar_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-calendar-test-case-grid-view/workload-calendar-test-case-grid-view.vue'
          ),
      );
    case 'project_pick_up_view':
      return defineAsyncComponent(
        () => import('./project/project-pick-up-view/project-pick-up-view.vue'),
      );
    case 'run_set_run_status_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './run/run-set-run-status-option-view/run-set-run-status-option-view.vue'
          ),
      );
    case 'ticket_recover_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-recover-grid-view/ticket-recover-grid-view.vue'
          ),
      );
    case 'project_member_assigned_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-member/project-member-assigned-grid-view/project-member-assigned-grid-view.vue'
          ),
      );
    case 'product_archived_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-archived-grid-view/product-archived-grid-view.vue'
          ),
      );
    case 'test_plan_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-quick-create-view/test-plan-quick-create-view.vue'
          ),
      );
    case 'project_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-quick-create-view/project-quick-create-view.vue'
          ),
      );
    case 'space_category_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-category-tree-exp-view/space-category-tree-exp-view.vue'
          ),
      );
    case 'test_case_set_state_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-set-state-option-view/test-case-set-state-option-view.vue'
          ),
      );
    case 'work_item_scrum_print_user_stat_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-scrum-print-user-stat-report-view/work-item-scrum-print-user-stat-report-view.vue'
          ),
      );
    case 'product_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import('./product/product-tree-exp-view/product-tree-exp-view.vue'),
      );
    case 'ticket_all_grid_view':
      return defineAsyncComponent(
        () => import('./ticket/ticket-all-grid-view/ticket-all-grid-view.vue'),
      );
    case 'test_case_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-pick-up-grid-view/test-case-pick-up-grid-view.vue'
          ),
      );
    case 'project_tag_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-tag/project-tag-option-view/project-tag-option-view.vue'
          ),
      );
    case 'test_case_nosuite_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-nosuite-test-case-grid-view/test-case-nosuite-test-case-grid-view.vue'
          ),
      );
    case 'insight_scrum_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight/insight-scrum-grid-view/insight-scrum-grid-view.vue'
          ),
      );
    case 'product_index_view':
      return defineAsyncComponent(
        () => import('./product/product-index-view/product-index-view.vue'),
      );
    case 'work_item_scrum_bug_state_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-scrum-bug-state-report-view/work-item-scrum-bug-state-report-view.vue'
          ),
      );
    case 'library_config_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-config-tree-exp-view/library-config-tree-exp-view.vue'
          ),
      );
    case 'work_item_quick_create_bug_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-quick-create-bug-view/work-item-quick-create-bug-view.vue'
          ),
      );
    case 'ticket_test_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-test-all-grid-view/ticket-test-all-grid-view.vue'
          ),
      );
    case 'workload_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import('./workload/workload-tab-exp-view/workload-tab-exp-view.vue'),
      );
    case 'work_item_scrum_temp_speed_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-scrum-temp-speed-report-view/work-item-scrum-temp-speed-report-view.vue'
          ),
      );
    case 'workload_management_product_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-management-product-grid-view/workload-management-product-grid-view.vue'
          ),
      );
    case 'transition_history_work_item_calendar_view':
      return defineAsyncComponent(
        () =>
          import(
            './transition-history/transition-history-work-item-calendar-view/transition-history-work-item-calendar-view.vue'
          ),
      );
    case 'work_item_state_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-state/work-item-state-grid-view/work-item-state-grid-view.vue'
          ),
      );
    case 'project_show_edit_view':
      return defineAsyncComponent(
        () =>
          import('./project/project-show-edit-view/project-show-edit-view.vue'),
      );
    case 'space_product_re_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-product-re-tree-exp-view/space-product-re-tree-exp-view.vue'
          ),
      );
    case 'release_all_grid_view':
      return defineAsyncComponent(
        () =>
          import('./release/release-all-grid-view/release-all-grid-view.vue'),
      );
    case 'work_tree_grid_ex_view':
      return defineAsyncComponent(
        () =>
          import('./work/work-tree-grid-ex-view/work-tree-grid-ex-view.vue'),
      );
    case 'project_edit_view':
      return defineAsyncComponent(
        () => import('./project/project-edit-view/project-edit-view.vue'),
      );
    case 'project_member_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-member/project-member-edit-view/project-member-edit-view.vue'
          ),
      );
    case 'customer_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './customer/customer-pick-up-grid-view/customer-pick-up-grid-view.vue'
          ),
      );
    case 'project_over_view':
      return defineAsyncComponent(
        () => import('./project/project-over-view/project-over-view.vue'),
      );
    case 'workload_calendar_work_item_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-calendar-work-item-grid-view/workload-calendar-work-item-grid-view.vue'
          ),
      );
    case 'library_member_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './library-member/library-member-redirect-view/library-member-redirect-view.vue'
          ),
      );
    case 'portfolio_project_index_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-project-index-view/portfolio-project-index-view.vue'
          ),
      );
    case 'test_case_case_type_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-case-type-report-view/test-case-case-type-report-view.vue'
          ),
      );
    case 'workload_management_tab_search_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-management-tab-search-view/workload-management-tab-search-view.vue'
          ),
      );
    case 'workload_product_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-product-grid-view/workload-product-grid-view.vue'
          ),
      );
    case 'workload_management_library_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-management-library-grid-view/workload-management-library-grid-view.vue'
          ),
      );
    case 'work_item_edit_view':
      return defineAsyncComponent(
        () => import('./work-item/work-item-edit-view/work-item-edit-view.vue'),
      );
    case 'space_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import('./space/space-pick-up-tree-view/space-pick-up-tree-view.vue'),
      );
    case 'flow_tree_exp_view':
      return defineAsyncComponent(
        () => import('./psde-logic/flow-tree-exp-view/flow-tree-exp-view.vue'),
      );
    case 'article_page_draft_show_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-draft-show-edit-view/article-page-draft-show-edit-view.vue'
          ),
      );
    case 'space_deleted_grid_view':
      return defineAsyncComponent(
        () =>
          import('./space/space-deleted-grid-view/space-deleted-grid-view.vue'),
      );
    case 'work_item_kanban_bug_daily_tide_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-kanban-bug-daily-tide-report-view/work-item-kanban-bug-daily-tide-report-view.vue'
          ),
      );
    case 'work_item_type_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-type/work-item-type-edit-view/work-item-type-edit-view.vue'
          ),
      );
    case 'deliverable_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './deliverable/deliverable-edit-view/deliverable-edit-view.vue'
          ),
      );
    case 'test_suite_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-suite/test-suite-tree-exp-view/test-suite-tree-exp-view.vue'
          ),
      );
    case 'test_case_activities_status_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-activities-status-report-view/test-case-activities-status-report-view.vue'
          ),
      );
    case 'run_results_report_view':
      return defineAsyncComponent(
        () =>
          import('./run/run-results-report-view/run-results-report-view.vue'),
      );
    case 'work_item_change_parent_pick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-change-parent-pick-up-view/work-item-change-parent-pick-up-view.vue'
          ),
      );
    case 'ticket_set_tags_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-set-tags-option-view/ticket-set-tags-option-view.vue'
          ),
      );
    case 'ticket_advanced_search_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-advanced-search-grid-view/ticket-advanced-search-grid-view.vue'
          ),
      );
    case 'user_pick_up_view':
      return defineAsyncComponent(
        () => import('./user/user-pick-up-view/user-pick-up-view.vue'),
      );
    case 'test_case_set_level_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-set-level-option-view/test-case-set-level-option-view.vue'
          ),
      );
    case 'workload_type_pick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload-type/workload-type-pick-up-view/workload-type-pick-up-view.vue'
          ),
      );
    case 'user_tab_exp_view':
      return defineAsyncComponent(
        () => import('./user/user-tab-exp-view/user-tab-exp-view.vue'),
      );
    case 'test_case_template_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case-template/test-case-template-edit-view/test-case-template-edit-view.vue'
          ),
      );
    case 'space_member_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './space-member/space-member-redirect-view/space-member-redirect-view.vue'
          ),
      );
    case 'customer_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './customer/customer-quick-create-view/customer-quick-create-view.vue'
          ),
      );
    case 'customer_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import(
            './customer/customer-pick-up-tree-view/customer-pick-up-tree-view.vue'
          ),
      );
    case 'product_edit_view':
      return defineAsyncComponent(
        () => import('./product/product-edit-view/product-edit-view.vue'),
      );
    case 'workload_update_view':
      return defineAsyncComponent(
        () =>
          import('./workload/workload-update-view/workload-update-view.vue'),
      );
    case 'work_item_scrum_defect_property_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-scrum-defect-property-report-view/work-item-scrum-defect-property-report-view.vue'
          ),
      );
    case 'product_details_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-details-setting-view/product-details-setting-view.vue'
          ),
      );
    case 'article_page_model_show_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-model-show-view/article-page-model-show-view.vue'
          ),
      );
    case 'test_case_main_view':
      return defineAsyncComponent(
        () => import('./test-case/test-case-main-view/test-case-main-view.vue'),
      );
    case 'recent_his_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recent-his-tab-exp-view/recent-his-tab-exp-view.vue'
          ),
      );
    case 'work_item_run_re_work_item_bug_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-run-re-work-item-bug-grid-view/work-item-run-re-work-item-bug-grid-view.vue'
          ),
      );
    case 'test_case_work_item_re_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-work-item-re-case-grid-view/test-case-work-item-re-case-grid-view.vue'
          ),
      );
    case 'ticket_my_attention_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-my-attention-grid-view/ticket-my-attention-grid-view.vue'
          ),
      );
    case 'library_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-pick-up-grid-view/library-pick-up-grid-view.vue'
          ),
      );
    case 'workload_project_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-project-grid-view/workload-project-grid-view.vue'
          ),
      );
    case 'run_daily_tendencies_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './run/run-daily-tendencies-report-view/run-daily-tendencies-report-view.vue'
          ),
      );
    case 'test_case_my_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-my-test-case-grid-view/test-case-my-test-case-grid-view.vue'
          ),
      );
    case 'project_scrum_flow_setting_tab_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-scrum-flow-setting-tab-view/project-scrum-flow-setting-tab-view.vue'
          ),
      );
    case 'work_item_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-pick-up-grid-view/work-item-pick-up-grid-view.vue'
          ),
      );
    case 'work_item_dyna_main_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-dyna-main-view/work-item-dyna-main-view.vue'
          ),
      );
    case 'test_suite_pick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-suite/test-suite-pick-up-view/test-suite-pick-up-view.vue'
          ),
      );
    case 'flow_tab_exp_view':
      return defineAsyncComponent(
        () => import('./psde-logic/flow-tab-exp-view/flow-tab-exp-view.vue'),
      );
    case 'idea_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import('./idea/idea-pick-up-tree-view/idea-pick-up-tree-view.vue'),
      );
    case 'ticket_ticket_re_ticket_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-ticket-re-ticket-grid-view/ticket-ticket-re-ticket-grid-view.vue'
          ),
      );
    case 'work_item_backlog_age_report_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-backlog-age-report-report-view/work-item-backlog-age-report-report-view.vue'
          ),
      );
    case 'project_member_config_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-member/project-member-config-grid-view/project-member-config-grid-view.vue'
          ),
      );
    case 'version_edit_view':
      return defineAsyncComponent(
        () => import('./version/version-edit-view/version-edit-view.vue'),
      );
    case 'idea_edit_view':
      return defineAsyncComponent(
        () => import('./idea/idea-edit-view/idea-edit-view.vue'),
      );
    case 'workload_management_work_type_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-management-work-type-grid-view/workload-management-work-type-grid-view.vue'
          ),
      );
    case 'space_product_re_space_choose_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-product-re-space-choose-option-view/space-product-re-space-choose-option-view.vue'
          ),
      );
    case 'test_case_template_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case-template/test-case-template-all-grid-view/test-case-template-all-grid-view.vue'
          ),
      );
    case 'template_flow_data_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/template-flow-data-view/template-flow-data-view.vue'
          ),
      );
    case 'run_all_grid_view':
      return defineAsyncComponent(
        () => import('./run/run-all-grid-view/run-all-grid-view.vue'),
      );
    case 'library_in_progress_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-in-progress-grid-view/library-in-progress-grid-view.vue'
          ),
      );
    case 'library_config_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-config-tab-exp-view/library-config-tab-exp-view.vue'
          ),
      );
    case 'work_item_requirement_tree_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-requirement-tree-grid-view/work-item-requirement-tree-grid-view.vue'
          ),
      );
    case 'space_create_wizard_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-create-wizard-view/space-create-wizard-view.vue'
          ),
      );
    case 'library_all_grid_view':
      return defineAsyncComponent(
        () =>
          import('./library/library-all-grid-view/library-all-grid-view.vue'),
      );
    case 'idea_change_state_view':
      return defineAsyncComponent(
        () =>
          import('./idea/idea-change-state-view/idea-change-state-view.vue'),
      );
    case 'test_suite_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-suite/test-suite-pick-up-grid-view/test-suite-pick-up-grid-view.vue'
          ),
      );
    case 'work_item_my_assignee_gird_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-my-assignee-gird-view/work-item-my-assignee-gird-view.vue'
          ),
      );
    case 'work_item_scrum_defect_total_trend_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-scrum-defect-total-trend-report-view/work-item-scrum-defect-total-trend-report-view.vue'
          ),
      );
    case 'space_member_assigned_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './space-member/space-member-assigned-grid-view/space-member-assigned-grid-view.vue'
          ),
      );
    case 'portfolio_member_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio-member/portfolio-member-redirect-view/portfolio-member-redirect-view.vue'
          ),
      );
    case 'release_pick_up_around_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './release/release-pick-up-around-grid-view/release-pick-up-around-grid-view.vue'
          ),
      );
    case 'project_waterfall_index_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-waterfall-index-view/project-waterfall-index-view.vue'
          ),
      );
    case 'version_work_item_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './version/version-work-item-grid-view/version-work-item-grid-view.vue'
          ),
      );
    case 'insight_kanban_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight/insight-kanban-tree-exp-view/insight-kanban-tree-exp-view.vue'
          ),
      );
    case 'user_grid_view':
      return defineAsyncComponent(
        () => import('./user/user-grid-view/user-grid-view.vue'),
      );
    case 'test_case_recycle_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-recycle-grid-view/test-case-recycle-grid-view.vue'
          ),
      );
    case 'product_show_eidt_view':
      return defineAsyncComponent(
        () =>
          import('./product/product-show-eidt-view/product-show-eidt-view.vue'),
      );
    case 'product_tag_edit_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-tag/product-tag-edit-option-view/product-tag-edit-option-view.vue'
          ),
      );
    case 'work_item_kanban_view':
      return defineAsyncComponent(
        () =>
          import('./work-item/work-item-kanban-view/work-item-kanban-view.vue'),
      );
    case 'work_item_waterfall_story_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-waterfall-story-grid-view/work-item-waterfall-story-grid-view.vue'
          ),
      );
    case 'customer_pick_up_view':
      return defineAsyncComponent(
        () =>
          import('./customer/customer-pick-up-view/customer-pick-up-view.vue'),
      );
    case 'work_item_child_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-child-grid-view/work-item-child-grid-view.vue'
          ),
      );
    case 'work_item_run_re_work_item_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-run-re-work-item-grid-view/work-item-run-re-work-item-grid-view.vue'
          ),
      );
    case 'product_plan_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-plan/product-plan-quick-create-view/product-plan-quick-create-view.vue'
          ),
      );
    case 'insight_edit_view':
      return defineAsyncComponent(
        () => import('./insight/insight-edit-view/insight-edit-view.vue'),
      );
    case 'sprint_confirm_finish_view':
      return defineAsyncComponent(
        () =>
          import(
            './sprint/sprint-confirm-finish-view/sprint-confirm-finish-view.vue'
          ),
      );
    case 'run_daily_test_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './run/run-daily-test-report-view/run-daily-test-report-view.vue'
          ),
      );
    case 'work_item_scrum_bug_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-scrum-bug-grid-view/work-item-scrum-bug-grid-view.vue'
          ),
      );
    case 'library_deleted_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-deleted-grid-view/library-deleted-grid-view.vue'
          ),
      );
    case 'release_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './release/release-pick-up-grid-view/release-pick-up-grid-view.vue'
          ),
      );
    case 'portfolio_member_project_bind_member_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio-member/portfolio-member-project-bind-member-grid-view/portfolio-member-project-bind-member-grid-view.vue'
          ),
      );
    case 'work_item_global_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-global-setting-view/work-item-global-setting-view.vue'
          ),
      );
    case 'space_in_progress_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-in-progress-grid-view/space-in-progress-grid-view.vue'
          ),
      );
    case 'workload_run_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-run-list-view/workload-run-list-view.vue'
          ),
      );
    case 'workload_log_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-log-grid-view/workload-log-grid-view.vue'
          ),
      );
    case 'product_advanced_setting_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-advanced-setting-edit-view/product-advanced-setting-edit-view.vue'
          ),
      );
    case 'recent_recent_project_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recent-recent-project-grid-view/recent-recent-project-grid-view.vue'
          ),
      );
    case 'product_plan_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-plan/product-plan-all-grid-view/product-plan-all-grid-view.vue'
          ),
      );
    case 'product_plan_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-plan/product-plan-pick-up-tree-view/product-plan-pick-up-tree-view.vue'
          ),
      );
    case 'psde_field_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-field/psde-field-quick-create-view/psde-field-quick-create-view.vue'
          ),
      );
    case 'search_hub_tab_search_view':
      return defineAsyncComponent(
        () =>
          import(
            './search-hub/search-hub-tab-search-view/search-hub-tab-search-view.vue'
          ),
      );
    case 'run_priority_distributions_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './run/run-priority-distributions-report-view/run-priority-distributions-report-view.vue'
          ),
      );
    case 'article_page_log_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-log-list-view/article-page-log-list-view.vue'
          ),
      );
    case 'workload_log_management_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-log-management-view/workload-log-management-view.vue'
          ),
      );
    case 'search_comment_advanced_search_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './search-comment/search-comment-advanced-search-grid-view/search-comment-advanced-search-grid-view.vue'
          ),
      );
    case 'portfolio_grid_view':
      return defineAsyncComponent(
        () => import('./portfolio/portfolio-grid-view/portfolio-grid-view.vue'),
      );
    case 'test_case_idea_re_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-idea-re-test-case-grid-view/test-case-idea-re-test-case-grid-view.vue'
          ),
      );
    case 'test_plan_in_progress_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-in-progress-grid-view/test-plan-in-progress-grid-view.vue'
          ),
      );
    case 'ticket_test_main_view':
      return defineAsyncComponent(
        () =>
          import('./ticket/ticket-test-main-view/ticket-test-main-view.vue'),
      );
    case 'idea_recycle_grid_view':
      return defineAsyncComponent(
        () =>
          import('./idea/idea-recycle-grid-view/idea-recycle-grid-view.vue'),
      );
    case 'work_item_project_resource_assignment_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-project-resource-assignment-view/work-item-project-resource-assignment-view.vue'
          ),
      );
    case 'library_show_edit_view':
      return defineAsyncComponent(
        () =>
          import('./library/library-show-edit-view/library-show-edit-view.vue'),
      );
    case 'idea_my_assign_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-my-assign-grid-view/idea-my-assign-grid-view.vue'
          ),
      );
    case 'project_baseinfo_over_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-baseinfo-over-view/project-baseinfo-over-view.vue'
          ),
      );
    case 'space_edit_view':
      return defineAsyncComponent(
        () => import('./space/space-edit-view/space-edit-view.vue'),
      );
    case 'idea_my_created_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-my-created-grid-view/idea-my-created-grid-view.vue'
          ),
      );
    case 'test_case_program_analyze_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-program-analyze-report-view/test-case-program-analyze-report-view.vue'
          ),
      );
    case 'test_plan_my_assignee_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-my-assignee-grid-view/test-plan-my-assignee-grid-view.vue'
          ),
      );
    case 'space_grid_view':
      return defineAsyncComponent(
        () => import('./space/space-grid-view/space-grid-view.vue'),
      );
    case 'test_case_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-quick-create-view/test-case-quick-create-view.vue'
          ),
      );
    case 'work_item_index_my_created_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-index-my-created-grid-view/work-item-index-my-created-grid-view.vue'
          ),
      );
    case 'work_item_type_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-type/work-item-type-grid-view/work-item-type-grid-view.vue'
          ),
      );
    case 'test_case_my_attention_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-my-attention-grid-view/test-case-my-attention-grid-view.vue'
          ),
      );
    case 'ticket_tags_tciket_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-tags-tciket-grid-view/ticket-tags-tciket-grid-view.vue'
          ),
      );
    case 'work_item_kanban_backlog_daily_trend_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-kanban-backlog-daily-trend-report-view/work-item-kanban-backlog-daily-trend-report-view.vue'
          ),
      );
    case 'project_deleted_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-deleted-grid-view/project-deleted-grid-view.vue'
          ),
      );
    case 'run_setting_actual_executor_view':
      return defineAsyncComponent(
        () =>
          import(
            './run/run-setting-actual-executor-view/run-setting-actual-executor-view.vue'
          ),
      );
    case 'work_item_scrum_backlog_state_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-scrum-backlog-state-report-view/work-item-scrum-backlog-state-report-view.vue'
          ),
      );
    case 'test_case_case_move_plan_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-case-move-plan-option-view/test-case-case-move-plan-option-view.vue'
          ),
      );
    case 'product_tag_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-tag/product-tag-edit-view/product-tag-edit-view.vue'
          ),
      );
    case 'work_item_kanban_user_stat_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-kanban-user-stat-report-view/work-item-kanban-user-stat-report-view.vue'
          ),
      );
    case 'test_case_only_attchment_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-only-attchment-view/test-case-only-attchment-view.vue'
          ),
      );
    case 'work_item_kanban_defect_age_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-kanban-defect-age-report-view/work-item-kanban-defect-age-report-view.vue'
          ),
      );
    case 'project_archived_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-archived-grid-view/project-archived-grid-view.vue'
          ),
      );
    case 'workload_calendar_test_case_management_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-calendar-test-case-management-grid-view/workload-calendar-test-case-management-grid-view.vue'
          ),
      );
    case 'product_base_information_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-base-information-edit-view/product-base-information-edit-view.vue'
          ),
      );
    case 'idea_my_attention_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-my-attention-grid-view/idea-my-attention-grid-view.vue'
          ),
      );
    case 'run_attachment_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './run-attachment/run-attachment-grid-view/run-attachment-grid-view.vue'
          ),
      );
    case 'work_item_kanban_acklog_age_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-kanban-acklog-age-report-view/work-item-kanban-acklog-age-report-view.vue'
          ),
      );
    case 'insight_scrum_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight/insight-scrum-tree-exp-view/insight-scrum-tree-exp-view.vue'
          ),
      );
    case 'run_tree_exp_view':
      return defineAsyncComponent(
        () => import('./run/run-tree-exp-view/run-tree-exp-view.vue'),
      );
    case 'portfolio_deleted_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-deleted-grid-view/portfolio-deleted-grid-view.vue'
          ),
      );
    case 'user_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import('./user/user-pick-up-grid-view/user-pick-up-grid-view.vue'),
      );
    case 'workload_library_gird_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-library-gird-view/workload-library-gird-view.vue'
          ),
      );
    case 'ticket_work_item_re_ticket_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-work-item-re-ticket-grid-view/ticket-work-item-re-ticket-grid-view.vue'
          ),
      );
    case 'product_main_view':
      return defineAsyncComponent(
        () => import('./product/product-main-view/product-main-view.vue'),
      );
    case 'portfolio_member_project_member_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio-member/portfolio-member-project-member-grid-view/portfolio-member-project-member-grid-view.vue'
          ),
      );
    case 'work_edit_view':
      return defineAsyncComponent(
        () => import('./work/work-edit-view/work-edit-view.vue'),
      );
    case 'test_case_mpick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-mpick-up-view/test-case-mpick-up-view.vue'
          ),
      );
    case 'portfolio_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-redirect-view/portfolio-redirect-view.vue'
          ),
      );
    case 'test_case_move_case_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-move-case-option-view/test-case-move-case-option-view.vue'
          ),
      );
    case 'idea_ticket_re_idea_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-ticket-re-idea-grid-view/idea-ticket-re-idea-grid-view.vue'
          ),
      );
    case 'recent_data_view':
      return defineAsyncComponent(
        () => import('./recent/recent-data-view/recent-data-view.vue'),
      );
    case 'space_member_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './space-member/space-member-edit-view/space-member-edit-view.vue'
          ),
      );
    case 'psdelogicquick_cfg_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psdelogicquick-cfg-view/psdelogicquick-cfg-view.vue'
          ),
      );
    case 'search_attachment_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './search-attachment/search-attachment-edit-view/search-attachment-edit-view.vue'
          ),
      );
    case 'product_tag_tag_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-tag/product-tag-tag-grid-view/product-tag-tag-grid-view.vue'
          ),
      );
    case 'comment_customer_connect_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './comment/comment-customer-connect-list-view/comment-customer-connect-list-view.vue'
          ),
      );
    case 'test_plan_project_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-project-grid-view/test-plan-project-grid-view.vue'
          ),
      );
    case 'idea_advanced_search_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-advanced-search-grid-view/idea-advanced-search-grid-view.vue'
          ),
      );
    case 'run_comparative_analysis_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './run/run-comparative-analysis-report-view/run-comparative-analysis-report-view.vue'
          ),
      );
    case 'user_tree_exp_view':
      return defineAsyncComponent(
        () => import('./user/user-tree-exp-view/user-tree-exp-view.vue'),
      );
    case 'space_info_view':
      return defineAsyncComponent(
        () => import('./space/space-info-view/space-info-view.vue'),
      );
    case 'search_attachment_advanced_search_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './search-attachment/search-attachment-advanced-search-grid-view/search-attachment-advanced-search-grid-view.vue'
          ),
      );
    case 'work_item_state_quick_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-state/work-item-state-quick-edit-view/work-item-state-quick-edit-view.vue'
          ),
      );
    case 'workload_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-redirect-view/workload-redirect-view.vue'
          ),
      );
    case 'library_index_view':
      return defineAsyncComponent(
        () => import('./library/library-index-view/library-index-view.vue'),
      );
    case 'test_case_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-all-grid-view/test-case-all-grid-view.vue'
          ),
      );
    case 'test_plan_update_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-update-option-view/test-plan-update-option-view.vue'
          ),
      );
    case 'psdelogicglobal_flow_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psdelogicglobal-flow-grid-view/psdelogicglobal-flow-grid-view.vue'
          ),
      );
    case 'work_item_all_scrum_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-all-scrum-grid-view/work-item-all-scrum-grid-view.vue'
          ),
      );
    case 'work_item_plan_work_item_mpick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-plan-work-item-mpick-up-view/work-item-plan-work-item-mpick-up-view.vue'
          ),
      );
    case 'work_item_scrum_defect_age_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-scrum-defect-age-report-view/work-item-scrum-defect-age-report-view.vue'
          ),
      );
    case 'library_base_info_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-base-info-edit-view/library-base-info-edit-view.vue'
          ),
      );
    case 'test_case_advanced_search_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-advanced-search-grid-view/test-case-advanced-search-grid-view.vue'
          ),
      );
    case 'psde_field_grid_view':
      return defineAsyncComponent(
        () =>
          import('./psde-field/psde-field-grid-view/psde-field-grid-view.vue'),
      );
    case 'work_item_bug_main_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-bug-main-view/work-item-bug-main-view.vue'
          ),
      );
    case 'space_category_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-category-grid-view/space-category-grid-view.vue'
          ),
      );
    case 'article_page_advanced_search_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-advanced-search-grid-view/article-page-advanced-search-grid-view.vue'
          ),
      );
    case 'test_case_not_add_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-not-add-pick-up-grid-view/test-case-not-add-pick-up-grid-view.vue'
          ),
      );
    case 'product_pick_up_view':
      return defineAsyncComponent(
        () => import('./product/product-pick-up-view/product-pick-up-view.vue'),
      );
    case 'test_case_edit_view':
      return defineAsyncComponent(
        () => import('./test-case/test-case-edit-view/test-case-edit-view.vue'),
      );
    case 'product_create_wizard_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-create-wizard-view/product-create-wizard-view.vue'
          ),
      );
    case 'work_item_work_item_testdyna':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-work-item-testdyna/work-item-work-item-testdyna.vue'
          ),
      );
    case 'release_pick_up_around_view':
      return defineAsyncComponent(
        () =>
          import(
            './release/release-pick-up-around-view/release-pick-up-around-view.vue'
          ),
      );
    case 'work_item_kanban_work_item_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-kanban-work-item-report-view/work-item-kanban-work-item-report-view.vue'
          ),
      );
    case 'project_tag_new_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-tag/project-tag-new-option-view/project-tag-new-option-view.vue'
          ),
      );
    case 'deliverable_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './deliverable/deliverable-redirect-view/deliverable-redirect-view.vue'
          ),
      );
    case 'run_history_grid_view':
      return defineAsyncComponent(
        () => import('./run/run-history-grid-view/run-history-grid-view.vue'),
      );
    case 'work_item_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-quick-create-view/work-item-quick-create-view.vue'
          ),
      );
    case 'space_member_config_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './space-member/space-member-config-grid-view/space-member-config-grid-view.vue'
          ),
      );
    case 'stencil_model_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './stencil/stencil-model-edit-view/stencil-model-edit-view.vue'
          ),
      );
    case 'idea_product_plan_re_idea_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-product-plan-re-idea-view/idea-product-plan-re-idea-view.vue'
          ),
      );
    case 'search_comment_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './search-comment/search-comment-edit-view/search-comment-edit-view.vue'
          ),
      );
    case 'product_recover_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-recover-tab-exp-view/product-recover-tab-exp-view.vue'
          ),
      );
    case 'work_item_ticket_re_work_item_gridview':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-ticket-re-work-item-gridview/work-item-ticket-re-work-item-gridview.vue'
          ),
      );
    case 'workload_management_member_calendar_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-management-member-calendar-grid-view/workload-management-member-calendar-grid-view.vue'
          ),
      );
    case 'idea_main_view':
      return defineAsyncComponent(
        () => import('./idea/idea-main-view/idea-main-view.vue'),
      );
    case 'psdelogicflow_main_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psdelogicflow-main-view/psdelogicflow-main-view.vue'
          ),
      );
    case 'ticket_my_created_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-my-created-grid-view/ticket-my-created-grid-view.vue'
          ),
      );
    case 'user_quick_cfg_view':
      return defineAsyncComponent(
        () => import('./user/user-quick-cfg-view/user-quick-cfg-view.vue'),
      );
    case 'work_item_my_attention_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-my-attention-grid-view/work-item-my-attention-grid-view.vue'
          ),
      );
    case 'idea_test_case_re_idea_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-test-case-re-idea-grid-view/idea-test-case-re-idea-grid-view.vue'
          ),
      );
    case 'test_case_my_craeted_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-my-craeted-grid-view/test-case-my-craeted-grid-view.vue'
          ),
      );
    case 'customer_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './customer/customer-tree-exp-view/customer-tree-exp-view.vue'
          ),
      );
    case 'sprint_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './sprint/sprint-pick-up-grid-view/sprint-pick-up-grid-view.vue'
          ),
      );
    case 'stencil_show_edit_view':
      return defineAsyncComponent(
        () =>
          import('./stencil/stencil-show-edit-view/stencil-show-edit-view.vue'),
      );
    case 'recent_recent_page_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recent-recent-page-grid-view/recent-recent-page-grid-view.vue'
          ),
      );
    case 'work_item_change_time_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-change-time-view/work-item-change-time-view.vue'
          ),
      );
    case 'work_item_backlog_daily_trend_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-backlog-daily-trend-report-view/work-item-backlog-daily-trend-report-view.vue'
          ),
      );
    case 'ticket_idea_re_ticket_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-idea-re-ticket-grid-view/ticket-idea-re-ticket-grid-view.vue'
          ),
      );
    case 'project_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import('./project/project-tree-exp-view/project-tree-exp-view.vue'),
      );
    case 'project_tag_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-tag/project-tag-redirect-view/project-tag-redirect-view.vue'
          ),
      );
    case 'article_page_re_show_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-re-show-view/article-page-re-show-view.vue'
          ),
      );
    case 'user_redirect_view':
      return defineAsyncComponent(
        () => import('./user/user-redirect-view/user-redirect-view.vue'),
      );
    case 'user_edit_view':
      return defineAsyncComponent(
        () => import('./user/user-edit-view/user-edit-view.vue'),
      );
    case 'version_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './version/version-test-case-grid-view/version-test-case-grid-view.vue'
          ),
      );
    case 'product_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-pick-up-grid-view/product-pick-up-grid-view.vue'
          ),
      );
    case 'workload_work_type_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-work-type-grid-view/workload-work-type-grid-view.vue'
          ),
      );
    case 'psdelogicflow_panel_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psdelogicflow-panel-view/psdelogicflow-panel-view.vue'
          ),
      );
    case 'article_page_my_favorite_page_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-my-favorite-page-grid-view/article-page-my-favorite-page-grid-view.vue'
          ),
      );
    case 'work_item_kanban_backlog_property_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-kanban-backlog-property-report-view/work-item-kanban-backlog-property-report-view.vue'
          ),
      );
    case 'product_tag_new_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-tag/product-tag-new-option-view/product-tag-new-option-view.vue'
          ),
      );
    case 'work_item_pick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-pick-up-view/work-item-pick-up-view.vue'
          ),
      );
    case 'article_page_test_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-test-edit-view/article-page-test-edit-view.vue'
          ),
      );
    case 'release_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import('./release/release-tree-exp-view/release-tree-exp-view.vue'),
      );
    case 'library_redirect_view':
      return defineAsyncComponent(
        () =>
          import('./library/library-redirect-view/library-redirect-view.vue'),
      );
    case 'test_plan_pick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-pick-up-view/test-plan-pick-up-view.vue'
          ),
      );
    case 'user_setting_view':
      return defineAsyncComponent(
        () => import('./user/user-setting-view/user-setting-view.vue'),
      );
    case 'insight_kanban_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight/insight-kanban-grid-view/insight-kanban-grid-view.vue'
          ),
      );
    case 'space_tree_exp_view':
      return defineAsyncComponent(
        () => import('./space/space-tree-exp-view/space-tree-exp-view.vue'),
      );
    case 'run_main_view':
      return defineAsyncComponent(
        () => import('./run/run-main-view/run-main-view.vue'),
      );
    case 'user_unassigned_dept_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './user/user-unassigned-dept-grid-view/user-unassigned-dept-grid-view.vue'
          ),
      );
    case 'run_run_re_run_history_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './run/run-run-re-run-history-edit-view/run-run-re-run-history-edit-view.vue'
          ),
      );
    case 'article_page_qucik_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-qucik-create-view/article-page-qucik-create-view.vue'
          ),
      );
    case 'work_item_my_todo_gird_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-my-todo-gird-view/work-item-my-todo-gird-view.vue'
          ),
      );
    case 'workload_list_view':
      return defineAsyncComponent(
        () => import('./workload/workload-list-view/workload-list-view.vue'),
      );
    case 'work_item_waterfall_bug_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-waterfall-bug-grid-view/work-item-waterfall-bug-grid-view.vue'
          ),
      );
    case 'idea_idea_re_plan_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-idea-re-plan-option-view/idea-idea-re-plan-option-view.vue'
          ),
      );
    case 'psdelogiceditview':
      return defineAsyncComponent(
        () => import('./psde-logic/psdelogiceditview/psdelogiceditview.vue'),
      );
    case 'extend_log_info_view':
      return defineAsyncComponent(
        () =>
          import('./extend-log/extend-log-info-view/extend-log-info-view.vue'),
      );
    case 'project_create_wizard_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-create-wizard-view/project-create-wizard-view.vue'
          ),
      );
    case 'idea_quick_create_view':
      return defineAsyncComponent(
        () =>
          import('./idea/idea-quick-create-view/idea-quick-create-view.vue'),
      );
    case 'test_case_person_distributions_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-person-distributions-report-view/test-case-person-distributions-report-view.vue'
          ),
      );
    case 'insight_redirect_view':
      return defineAsyncComponent(
        () =>
          import('./insight/insight-redirect-view/insight-redirect-view.vue'),
      );
    case 'activity_history_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './activity/activity-history-list-view/activity-history-list-view.vue'
          ),
      );
    case 'ticket_my_assignee_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-my-assignee-grid-view/ticket-my-assignee-grid-view.vue'
          ),
      );
    case 'work_item_re_self_mpick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-re-self-mpick-up-grid-view/work-item-re-self-mpick-up-grid-view.vue'
          ),
      );
    case 'project_tag_tag_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-tag/project-tag-tag-grid-view/project-tag-tag-grid-view.vue'
          ),
      );
    case 'ticket_un_plan_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-un-plan-grid-view/ticket-un-plan-grid-view.vue'
          ),
      );
    case 'work_item_my_created_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-my-created-grid-view/work-item-my-created-grid-view.vue'
          ),
      );
    case 'project_config_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-config-tree-exp-view/project-config-tree-exp-view.vue'
          ),
      );
    case 'comment_edit_view':
      return defineAsyncComponent(
        () => import('./comment/comment-edit-view/comment-edit-view.vue'),
      );
    case 'portfolio_project_set_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-project-set-tab-exp-view/portfolio-project-set-tab-exp-view.vue'
          ),
      );
    case 'space_tab_exp_view':
      return defineAsyncComponent(
        () => import('./space/space-tab-exp-view/space-tab-exp-view.vue'),
      );
    case 'project_all_grid_view':
      return defineAsyncComponent(
        () =>
          import('./project/project-all-grid-view/project-all-grid-view.vue'),
      );
    case 'workspace_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './workspace/workspace-tab-exp-view/workspace-tab-exp-view.vue'
          ),
      );
    case 'ticket_edit_view':
      return defineAsyncComponent(
        () => import('./ticket/ticket-edit-view/ticket-edit-view.vue'),
      );
    case 'idea_un_scheduled_pickup_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-un-scheduled-pickup-grid-view/idea-un-scheduled-pickup-grid-view.vue'
          ),
      );
    case 'library_create_wizard_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-create-wizard-view/library-create-wizard-view.vue'
          ),
      );
    case 'portfolio_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-pick-up-grid-view/portfolio-pick-up-grid-view.vue'
          ),
      );
    case 'project_tag_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-tag/project-tag-grid-view/project-tag-grid-view.vue'
          ),
      );
    case 'work_item_change_state_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-change-state-view/work-item-change-state-view.vue'
          ),
      );
    case 'work_item_test_case_re_bug_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-test-case-re-bug-grid-view/work-item-test-case-re-bug-grid-view.vue'
          ),
      );
    case 'work_item_main_view':
      return defineAsyncComponent(
        () => import('./work-item/work-item-main-view/work-item-main-view.vue'),
      );
    case 'product_member_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-member/product-member-edit-view/product-member-edit-view.vue'
          ),
      );
    case 'work_item_type_setting_view_scrum':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-type/work-item-type-setting-view-scrum/work-item-type-setting-view-scrum.vue'
          ),
      );
    case 'sprint_update_view':
      return defineAsyncComponent(
        () => import('./sprint/sprint-update-view/sprint-update-view.vue'),
      );
    case 'test_plan_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-all-grid-view/test-plan-all-grid-view.vue'
          ),
      );
    case 'management_config_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './management/management-config-tab-exp-view/management-config-tab-exp-view.vue'
          ),
      );
    case 'work_item_copy_view':
      return defineAsyncComponent(
        () => import('./work-item/work-item-copy-view/work-item-copy-view.vue'),
      );
    case 'stencil_space_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './stencil/stencil-space-all-grid-view/stencil-space-all-grid-view.vue'
          ),
      );
    case 'project_tag_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-tag/project-tag-edit-view/project-tag-edit-view.vue'
          ),
      );
    case 'work_item_milestone_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-milestone-grid-view/work-item-milestone-grid-view.vue'
          ),
      );
    case 'project_redirect_view':
      return defineAsyncComponent(
        () =>
          import('./project/project-redirect-view/project-redirect-view.vue'),
      );
    case 'product_deleted_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-deleted-grid-view/product-deleted-grid-view.vue'
          ),
      );
    case 'ticket_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-quick-create-view/ticket-quick-create-view.vue'
          ),
      );
    case 'work_item_scrum_property_distribution_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-scrum-property-distribution-report-view/work-item-scrum-property-distribution-report-view.vue'
          ),
      );
    case 'run_members_distribution_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './run/run-members-distribution-report-view/run-members-distribution-report-view.vue'
          ),
      );
    case 'work_item_scrum_bug_daily_tide_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-scrum-bug-daily-tide-report-view/work-item-scrum-bug-daily-tide-report-view.vue'
          ),
      );
    case 'space_base_info_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-base-info-edit-view/space-base-info-edit-view.vue'
          ),
      );
    case 'ticket_create_re_ticket_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-create-re-ticket-view/ticket-create-re-ticket-view.vue'
          ),
      );
    case 'space_setting_view':
      return defineAsyncComponent(
        () => import('./space/space-setting-view/space-setting-view.vue'),
      );
    case 'project_kanban_index_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-kanban-index-view/project-kanban-index-view.vue'
          ),
      );
    case 'idea_all_grid_view':
      return defineAsyncComponent(
        () => import('./idea/idea-all-grid-view/idea-all-grid-view.vue'),
      );
    case 'work_item_test_plan_bug_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-test-plan-bug-grid-view/work-item-test-plan-bug-grid-view.vue'
          ),
      );
    case 'product_grid_view':
      return defineAsyncComponent(
        () => import('./product/product-grid-view/product-grid-view.vue'),
      );
    case 'psdelogiclogicdesign':
      return defineAsyncComponent(
        () =>
          import('./psde-logic/psdelogiclogicdesign/psdelogiclogicdesign.vue'),
      );
    case 'test_plan_my_part_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-my-part-grid-view/test-plan-my-part-grid-view.vue'
          ),
      );
    case 'user_account_view':
      return defineAsyncComponent(
        () => import('./user/user-account-view/user-account-view.vue'),
      );
    case 'ticket_my_assign_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-my-assign-grid-view/ticket-my-assign-grid-view.vue'
          ),
      );
    case 'project_grid_view':
      return defineAsyncComponent(
        () => import('./project/project-grid-view/project-grid-view.vue'),
      );
    case 'article_page_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-tree-exp-view/article-page-tree-exp-view.vue'
          ),
      );
    case 'work_item_re_self_mpick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-re-self-mpick-up-view/work-item-re-self-mpick-up-view.vue'
          ),
      );
    case 'work_item_release_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-release-grid-view/work-item-release-grid-view.vue'
          ),
      );
    case 'library_archived_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-archived-grid-view/library-archived-grid-view.vue'
          ),
      );
    case 'space_archived_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-archived-grid-view/space-archived-grid-view.vue'
          ),
      );
    case 'ticket_allocate_person_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-allocate-person-view/ticket-allocate-person-view.vue'
          ),
      );
    case 'project_base_information_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-base-information-edit-view/project-base-information-edit-view.vue'
          ),
      );
    case 'library_member_config_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './library-member/library-member-config-grid-view/library-member-config-grid-view.vue'
          ),
      );
    case 'test_plan_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-pick-up-grid-view/test-plan-pick-up-grid-view.vue'
          ),
      );
    case 'project_setting_view':
      return defineAsyncComponent(
        () => import('./project/project-setting-view/project-setting-view.vue'),
      );
    case 'work_item_all_kanban_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-all-kanban-grid-view/work-item-all-kanban-grid-view.vue'
          ),
      );
    case 'product_member_assigned_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-member/product-member-assigned-grid-view/product-member-assigned-grid-view.vue'
          ),
      );
    case 'sprint_all_grid_view':
      return defineAsyncComponent(
        () => import('./sprint/sprint-all-grid-view/sprint-all-grid-view.vue'),
      );
    case 'app_index_view':
      return defineAsyncComponent(
        () => import('./app-index-view/app-index-view.vue'),
      );
    case 'test_plan_report_custom_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-report-custom-view/test-plan-report-custom-view.vue'
          ),
      );
    case 'work_item_kanban_defect_property_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-kanban-defect-property-report-view/work-item-kanban-defect-property-report-view.vue'
          ),
      );
    case 'library_member_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './library-member/library-member-edit-view/library-member-edit-view.vue'
          ),
      );
    case 'management_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './management/management-tab-exp-view/management-tab-exp-view.vue'
          ),
      );
    case 'test_case_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-redirect-view/test-case-redirect-view.vue'
          ),
      );
    case 'release_pick_up_view':
      return defineAsyncComponent(
        () => import('./release/release-pick-up-view/release-pick-up-view.vue'),
      );
    case 'portfolio_mpick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-mpick-up-view/portfolio-mpick-up-view.vue'
          ),
      );
    case 'idea_create_re_idea_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-create-re-idea-view/idea-create-re-idea-view.vue'
          ),
      );
    case 'product_member_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-member/product-member-redirect-view/product-member-redirect-view.vue'
          ),
      );
    case 'idea_run_re_idea_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-run-re-idea-grid-view/idea-run-re-idea-grid-view.vue'
          ),
      );
    case 'product_config_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-config-tree-exp-view/product-config-tree-exp-view.vue'
          ),
      );
    case 'insight_library_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight/insight-library-tree-exp-view/insight-library-tree-exp-view.vue'
          ),
      );
    case 'deliverable_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './deliverable/deliverable-quick-create-view/deliverable-quick-create-view.vue'
          ),
      );
    case 'article_page_show_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-show-view/article-page-show-view.vue'
          ),
      );
    case 'customer_main_view':
      return defineAsyncComponent(
        () => import('./customer/customer-main-view/customer-main-view.vue'),
      );
    case 'ticket_tree_exp_view':
      return defineAsyncComponent(
        () => import('./ticket/ticket-tree-exp-view/ticket-tree-exp-view.vue'),
      );
    case 'insight_library_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight/insight-library-grid-view/insight-library-grid-view.vue'
          ),
      );
    case 'idea_others_re_mpick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-others-re-mpick-up-grid-view/idea-others-re-mpick-up-grid-view.vue'
          ),
      );
    case 'version_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './version/version-quick-create-view/version-quick-create-view.vue'
          ),
      );
    case 'ticket_customer_re_ticket_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-customer-re-ticket-grid-view/ticket-customer-re-ticket-grid-view.vue'
          ),
      );
    case 'recent_my_assignee_item_tap_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recent-my-assignee-item-tap-exp-view/recent-my-assignee-item-tap-exp-view.vue'
          ),
      );
    case 'portfolio_project_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-project-edit-view/portfolio-project-edit-view.vue'
          ),
      );
    case 'psdelogictemplate_info_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psdelogictemplate-info-view/psdelogictemplate-info-view.vue'
          ),
      );
    case 'sprint_pick_up_view':
      return defineAsyncComponent(
        () => import('./sprint/sprint-pick-up-view/sprint-pick-up-view.vue'),
      );
    case 'ticket_redirect_view':
      return defineAsyncComponent(
        () => import('./ticket/ticket-redirect-view/ticket-redirect-view.vue'),
      );
    case 'attention_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './attention/attention-tab-exp-view/attention-tab-exp-view.vue'
          ),
      );
    case 'sprint_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './sprint/sprint-quick-create-view/sprint-quick-create-view.vue'
          ),
      );
    case 'library_setting_view':
      return defineAsyncComponent(
        () => import('./library/library-setting-view/library-setting-view.vue'),
      );
    case 'library_advanced_setting_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-advanced-setting-edit-view/library-advanced-setting-edit-view.vue'
          ),
      );
    case 'workload_edit_view':
      return defineAsyncComponent(
        () => import('./workload/workload-edit-view/workload-edit-view.vue'),
      );
    case 'library_grid_view':
      return defineAsyncComponent(
        () => import('./library/library-grid-view/library-grid-view.vue'),
      );
    case 'work_item_tree_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-tree-grid-view/work-item-tree-grid-view.vue'
          ),
      );
    case 'workload_tab_search_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-tab-search-view/workload-tab-search-view.vue'
          ),
      );
    case 'project_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-pick-up-grid-view/project-pick-up-grid-view.vue'
          ),
      );
    case 'test_case_re_run_main_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-re-run-main-view/test-case-re-run-main-view.vue'
          ),
      );
    case 'portfolio_project_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-project-grid-view/portfolio-project-grid-view.vue'
          ),
      );
    case 'project_member_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-member/project-member-redirect-view/project-member-redirect-view.vue'
          ),
      );
    case 'release_update_view':
      return defineAsyncComponent(
        () => import('./release/release-update-view/release-update-view.vue'),
      );
    case 'project_management_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-management-tab-exp-view/project-management-tab-exp-view.vue'
          ),
      );
    case 'work_item_type_global_setting_view_scrum':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-type/work-item-type-global-setting-view-scrum/work-item-type-global-setting-view-scrum.vue'
          ),
      );
    case 'work_item_change_assignee_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-change-assignee-view/work-item-change-assignee-view.vue'
          ),
      );
    case 'user_info_custom_view':
      return defineAsyncComponent(
        () => import('./user/user-info-custom-view/user-info-custom-view.vue'),
      );
    case 'idea_re_self_grid_view':
      return defineAsyncComponent(
        () =>
          import('./idea/idea-re-self-grid-view/idea-re-self-grid-view.vue'),
      );
    case 'workload_calendar_idea_management_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-calendar-idea-management-grid-view/workload-calendar-idea-management-grid-view.vue'
          ),
      );
    case 'ticket_main_view':
      return defineAsyncComponent(
        () => import('./ticket/ticket-main-view/ticket-main-view.vue'),
      );
    case 'test_case_set_maintenance_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-set-maintenance-option-view/test-case-set-maintenance-option-view.vue'
          ),
      );
    case 'test_plan_main_view':
      return defineAsyncComponent(
        () => import('./test-plan/test-plan-main-view/test-plan-main-view.vue'),
      );
    case 'idea_work_item_re_idea_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-work-item-re-idea-grid-view/idea-work-item-re-idea-grid-view.vue'
          ),
      );
    case 'article_page_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-edit-view/article-page-edit-view.vue'
          ),
      );
    case 'workload_calendar_idea_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-calendar-idea-grid-view/workload-calendar-idea-grid-view.vue'
          ),
      );
    case 'product_in_progress_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-in-progress-grid-view/product-in-progress-grid-view.vue'
          ),
      );
    case 'recent_recent_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recent-recent-test-case-grid-view/recent-recent-test-case-grid-view.vue'
          ),
      );
    case 'recent_redirect_view':
      return defineAsyncComponent(
        () => import('./recent/recent-redirect-view/recent-redirect-view.vue'),
      );
    case 'test_case_template_new_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case-template/test-case-template-new-edit-view/test-case-template-new-edit-view.vue'
          ),
      );
    case 'sprint_pick_up_around_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './sprint/sprint-pick-up-around-grid-view/sprint-pick-up-around-grid-view.vue'
          ),
      );
    case 'user_choose_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './user/user-choose-pick-up-grid-view/user-choose-pick-up-grid-view.vue'
          ),
      );
    case 'work_redirect_view':
      return defineAsyncComponent(
        () => import('./work/work-redirect-view/work-redirect-view.vue'),
      );
    case 'work_item_under_work_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-under-work-grid-view/work-item-under-work-grid-view.vue'
          ),
      );
    case 'workload_type_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload-type/workload-type-pick-up-grid-view/workload-type-pick-up-grid-view.vue'
          ),
      );
    case 'work_item_test_case_re_work_item_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-test-case-re-work-item-grid-view/work-item-test-case-re-work-item-grid-view.vue'
          ),
      );
    case 'project_in_progress_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-in-progress-grid-view/project-in-progress-grid-view.vue'
          ),
      );
    case 'project_mpick_up_view':
      return defineAsyncComponent(
        () =>
          import('./project/project-mpick-up-view/project-mpick-up-view.vue'),
      );
    case 'idea_plan_count_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-plan-count-grid-view/idea-plan-count-grid-view.vue'
          ),
      );
    case 'space_all_grid_view':
      return defineAsyncComponent(
        () => import('./space/space-all-grid-view/space-all-grid-view.vue'),
      );
    case 'library_member_assigned_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './library-member/library-member-assigned-grid-view/library-member-assigned-grid-view.vue'
          ),
      );
    case 'product_plan_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-plan/product-plan-tree-exp-view/product-plan-tree-exp-view.vue'
          ),
      );
    case 'workload_management_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-management-view/workload-management-view.vue'
          ),
      );
    case 'work_item_calendar_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-calendar-view/work-item-calendar-view.vue'
          ),
      );
    case 'deliverable_target_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './deliverable/deliverable-target-grid-view/deliverable-target-grid-view.vue'
          ),
      );
    case 'work_item_gantt_view':
      return defineAsyncComponent(
        () =>
          import('./work-item/work-item-gantt-view/work-item-gantt-view.vue'),
      );
    case 'sprint_tree_exp_view':
      return defineAsyncComponent(
        () => import('./sprint/sprint-tree-exp-view/sprint-tree-exp-view.vue'),
      );
    case 'psdelogiclogicdesign_readonly':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psdelogiclogicdesign-readonly/psdelogiclogicdesign-readonly.vue'
          ),
      );
    case 'work_item_change_parent_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-change-parent-pick-up-grid-view/work-item-change-parent-pick-up-grid-view.vue'
          ),
      );
    case 'work_item_index_my_assignee_gird_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-index-my-assignee-gird-view/work-item-index-my-assignee-gird-view.vue'
          ),
      );
    case 'psde_field_quick_cfg_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-field/psde-field-quick-cfg-view/psde-field-quick-cfg-view.vue'
          ),
      );
    case 'space_advanced_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-advanced-setting-view/space-advanced-setting-view.vue'
          ),
      );
    case 'product_setting_view':
      return defineAsyncComponent(
        () => import('./product/product-setting-view/product-setting-view.vue'),
      );
    case 'stencil_all_grid_view':
      return defineAsyncComponent(
        () =>
          import('./stencil/stencil-all-grid-view/stencil-all-grid-view.vue'),
      );
    case 'product_management_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-management-tab-exp-view/product-management-tab-exp-view.vue'
          ),
      );
    case 'test_case_choose_template_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-choose-template-option-view/test-case-choose-template-option-view.vue'
          ),
      );
    case 'work_item_idea_re_work_item_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-idea-re-work-item-grid-view/work-item-idea-re-work-item-grid-view.vue'
          ),
      );
    case 'work_item_advanced_search_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-advanced-search-grid-view/work-item-advanced-search-grid-view.vue'
          ),
      );
    case 'comment_list_view':
      return defineAsyncComponent(
        () => import('./comment/comment-list-view/comment-list-view.vue'),
      );
    case 'test_suite_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-suite/test-suite-quick-create-view/test-suite-quick-create-view.vue'
          ),
      );
    case 'ticket_submit_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-submit-grid-view/ticket-submit-grid-view.vue'
          ),
      );
    case 'work_item_sprint_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-sprint-grid-view/work-item-sprint-grid-view.vue'
          ),
      );
    case 'work_item_scrum_backlog_flow_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-scrum-backlog-flow-report-view/work-item-scrum-backlog-flow-report-view.vue'
          ),
      );
    case 'user_info_view':
      return defineAsyncComponent(
        () => import('./user/user-info-view/user-info-view.vue'),
      );
    case 'notify_setting_config_view':
      return defineAsyncComponent(
        () =>
          import(
            './notify-setting/notify-setting-config-view/notify-setting-config-view.vue'
          ),
      );
    case 'customer_add_category_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './customer/customer-add-category-option-view/customer-add-category-option-view.vue'
          ),
      );
    case 'recent_custom_dashboard_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recent-custom-dashboard-view/recent-custom-dashboard-view.vue'
          ),
      );
    case 'product_plan_edit_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-plan/product-plan-edit-option-view/product-plan-edit-option-view.vue'
          ),
      );
    case 'work_item_recycle_bin_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-recycle-bin-grid-view/work-item-recycle-bin-grid-view.vue'
          ),
      );
    case 'portfolio_member_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio-member/portfolio-member-edit-view/portfolio-member-edit-view.vue'
          ),
      );
    case 'deliverable_project_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './deliverable/deliverable-project-grid-view/deliverable-project-grid-view.vue'
          ),
      );
    case 'library_pick_up_view':
      return defineAsyncComponent(
        () => import('./library/library-pick-up-view/library-pick-up-view.vue'),
      );
    case 'recent_my_created_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recent-my-created-tab-exp-view/recent-my-created-tab-exp-view.vue'
          ),
      );
    case 'article_page_updated_logs':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-updated-logs/article-page-updated-logs.vue'
          ),
      );
    case 'release_main_view':
      return defineAsyncComponent(
        () => import('./release/release-main-view/release-main-view.vue'),
      );
    case 'portfolio_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-setting-view/portfolio-setting-view.vue'
          ),
      );
    case 'article_page_document_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-document-edit-view/article-page-document-edit-view.vue'
          ),
      );
    case 'idea_tree_exp_view':
      return defineAsyncComponent(
        () => import('./idea/idea-tree-exp-view/idea-tree-exp-view.vue'),
      );
    case 'product_member_config_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-member/product-member-config-grid-view/product-member-config-grid-view.vue'
          ),
      );
    case 'portfolio_project_set_advanced_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-project-set-advanced-view/portfolio-project-set-advanced-view.vue'
          ),
      );
    case 'product_all_grid_view':
      return defineAsyncComponent(
        () =>
          import('./product/product-all-grid-view/product-all-grid-view.vue'),
      );
    case 'space_index_view':
      return defineAsyncComponent(
        () => import('./space/space-index-view/space-index-view.vue'),
      );
    default:
      throw new Error(`无法找到视图模型：${name}`);
  }
}
