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
    case 'baseline_library_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-library-grid-view/baseline-library-grid-view.vue'
          ),
      );
    case 'work_item_wizard_change_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-wizard/work-item-wizard-change-view/work-item-wizard-change-view.vue'
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
    case 'review_content_under_review_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './review-content/review-content-under-review-grid-view/review-content-under-review-grid-view.vue'
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
    case 'waterfall_back_log_app_data_upload_view':
      return defineAsyncComponent(
        () =>
          import(
            './waterfall-back-log-app-data-upload-view/waterfall-back-log-app-data-upload-view.vue'
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
    case 'insight_view_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-edit-view/insight-view-edit-view.vue'
          ),
      );
    case 'test_plan_report_survey_custom_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-report-survey-custom-view/test-plan-report-survey-custom-view.vue'
          ),
      );
    case 'project_move_choose_pick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-move-choose-pick-up-view/project-move-choose-pick-up-view.vue'
          ),
      );
    case 'ticket_type_editor_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket-type/ticket-type-editor-view/ticket-type-editor-view.vue'
          ),
      );
    case 'work_item_dyna_waterfall_tree_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-dyna-waterfall-tree-grid-view/work-item-dyna-waterfall-tree-grid-view.vue'
          ),
      );
    case 'board_pick_up_view':
      return defineAsyncComponent(
        () => import('./board/board-pick-up-view/board-pick-up-view.vue'),
      );
    case 'review_wizard_create_wizard_view':
      return defineAsyncComponent(
        () =>
          import(
            './review-wizard/review-wizard-create-wizard-view/review-wizard-create-wizard-view.vue'
          ),
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
    case 'ps_sys_bi_cube_measure_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './ps-sys-bi-cube-measure/ps-sys-bi-cube-measure-redirect-view/ps-sys-bi-cube-measure-redirect-view.vue'
          ),
      );
    case 'release_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './release/release-quick-create-view/release-quick-create-view.vue'
          ),
      );
    case 'baseline_work_item_comparison_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline-work-item/baseline-work-item-comparison-grid-view/baseline-work-item-comparison-grid-view.vue'
          ),
      );
    case 'test_case_assessment_result_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-assessment-result-report-view/test-case-assessment-result-report-view.vue'
          ),
      );
    case 'baseline_test_case_relation_version_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline-test-case/baseline-test-case-relation-version-list-view/baseline-test-case-relation-version-list-view.vue'
          ),
      );
    case 'test_case_copy_test_case_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-copy-test-case-option-view/test-case-copy-test-case-option-view.vue'
          ),
      );
    case 'work_item_dyna_waterfall_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-dyna-waterfall-quick-create-view/work-item-dyna-waterfall-quick-create-view.vue'
          ),
      );
    case 'baseline_idea_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline-idea/baseline-idea-edit-view/baseline-idea-edit-view.vue'
          ),
      );
    case 'test_case_test_plan_re_test_case_prickup_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-test-plan-re-test-case-prickup-view/test-case-test-plan-re-test-case-prickup-view.vue'
          ),
      );
    case 'product_filter_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-filter-tab-exp-view/product-filter-tab-exp-view.vue'
          ),
      );
    case 'psde_field_global_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-field/psde-field-global-test-case-grid-view/psde-field-global-test-case-grid-view.vue'
          ),
      );
    case 'member_grid_view':
      return defineAsyncComponent(
        () => import('./member/member-grid-view/member-grid-view.vue'),
      );
    case 'discuss_topic_show_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-show-edit-view/discuss-topic-show-edit-view.vue'
          ),
      );
    case 'project_move_choose_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-move-choose-pick-up-grid-view/project-move-choose-pick-up-grid-view.vue'
          ),
      );
    case 'stage_redirect_view':
      return defineAsyncComponent(
        () => import('./stage/stage-redirect-view/stage-redirect-view.vue'),
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
    case 'test_case_re_case_by_sprint_pickup_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-re-case-by-sprint-pickup-view/test-case-re-case-by-sprint-pickup-view.vue'
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
    case 'test_plan_release_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-release-grid-view/test-plan-release-grid-view.vue'
          ),
      );
    case 'project_scrum_index_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-scrum-index-view/project-scrum-index-view.vue'
          ),
      );
    case 'psde_logic_all_log_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psde-logic-all-log-grid-view/psde-logic-all-log-grid-view.vue'
          ),
      );
    case 'portfolio_project_show_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-project-show-view/portfolio-project-show-view.vue'
          ),
      );
    case 'dyna_dashboard_info_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './dyna-dashboard/dyna-dashboard-info-edit-view/dyna-dashboard-info-edit-view.vue'
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
    case 'notify_setting_config_view':
      return defineAsyncComponent(
        () =>
          import(
            './notify-setting/notify-setting-config-view/notify-setting-config-view.vue'
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
    case 'relation_work_item_re_ticket_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-work-item-re-ticket-list-view/relation-work-item-re-ticket-list-view.vue'
          ),
      );
    case 'article_page_statistical_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-statistical-grid-view/article-page-statistical-grid-view.vue'
          ),
      );
    case 'relation_ticket_re_work_item_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-ticket-re-work-item-grid-view/relation-ticket-re-work-item-grid-view.vue'
          ),
      );
    case 'discuss_post_recent_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-post/discuss-post-recent-grid-view/discuss-post-recent-grid-view.vue'
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
    case 'workload_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-quick-create-view/workload-quick-create-view.vue'
          ),
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
    case 'baseline_product_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-product-create-view/baseline-product-create-view.vue'
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
    case 'baseline_space_main_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-space-main-view/baseline-space-main-view.vue'
          ),
      );
    case 'test_plan_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-quick-create-view/test-plan-quick-create-view.vue'
          ),
      );
    case 'idea_template_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea-template/idea-template-all-grid-view/idea-template-all-grid-view.vue'
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
    case 'idea_template_global_create_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea-template/idea-template-global-create-edit-view/idea-template-global-create-edit-view.vue'
          ),
      );
    case 'insight_view_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-redirect-view/insight-view-redirect-view.vue'
          ),
      );
    case 'relation_idea_re_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-idea-re-test-case-grid-view/relation-idea-re-test-case-grid-view.vue'
          ),
      );
    case 'release_relation_mpick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './release/release-relation-mpick-up-grid-view/release-relation-mpick-up-grid-view.vue'
          ),
      );
    case 'version_idea_grid_view':
      return defineAsyncComponent(
        () =>
          import('./version/version-idea-grid-view/version-idea-grid-view.vue'),
      );
    case 'article_page_baseline_mpick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-baseline-mpick-up-grid-view/article-page-baseline-mpick-up-grid-view.vue'
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
    case 'work_item_project_resource_gantt_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-project-resource-gantt-view/work-item-project-resource-gantt-view.vue'
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
    case 'discuss_topic_create_wizard_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-create-wizard-view/discuss-topic-create-wizard-view.vue'
          ),
      );
    case 'library_config_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-config-tree-exp-view/library-config-tree-exp-view.vue'
          ),
      );
    case 'discuss_post_my_attention_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-post/discuss-post-my-attention-grid-view/discuss-post-my-attention-grid-view.vue'
          ),
      );
    case 'work_item_dyna_hybrid_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-dyna-hybrid-quick-create-view/work-item-dyna-hybrid-quick-create-view.vue'
          ),
      );
    case 'search_attachment_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './search-attachment/search-attachment-redirect-view/search-attachment-redirect-view.vue'
          ),
      );
    case 'work_item_quick_create_bug_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-quick-create-bug-view/work-item-quick-create-bug-view.vue'
          ),
      );
    case 'baseline_space_update_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-space-update-view/baseline-space-update-view.vue'
          ),
      );
    case 'relation_test_case_re_bug_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-test-case-re-bug-list-view/relation-test-case-re-bug-list-view.vue'
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
    case 'baseline_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-redirect-view/baseline-redirect-view.vue'
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
    case 'guideline_config_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './guideline/guideline-config-option-view/guideline-config-option-view.vue'
          ),
      );
    case 'psde_field_test_case_extend_transmit_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-field/psde-field-test-case-extend-transmit-grid-view/psde-field-test-case-extend-transmit-grid-view.vue'
          ),
      );
    case 'relation_idea_re_customer_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-idea-re-customer-grid-view/relation-idea-re-customer-grid-view.vue'
          ),
      );
    case 'work_tree_grid_ex_view':
      return defineAsyncComponent(
        () =>
          import('./work/work-tree-grid-ex-view/work-tree-grid-ex-view.vue'),
      );
    case 'work_item_type_global_setting_view_waterfall':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-type/work-item-type-global-setting-view-waterfall/work-item-type-global-setting-view-waterfall.vue'
          ),
      );
    case 'ticket_type_config_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket-type/ticket-type-config-tab-exp-view/ticket-type-config-tab-exp-view.vue'
          ),
      );
    case 'project_edit_view':
      return defineAsyncComponent(
        () => import('./project/project-edit-view/project-edit-view.vue'),
      );
    case 'scrum_back_log_app_data_upload_view':
      return defineAsyncComponent(
        () =>
          import(
            './scrum-back-log-app-data-upload-view/scrum-back-log-app-data-upload-view.vue'
          ),
      );
    case 'user_valid_grid_view':
      return defineAsyncComponent(
        () => import('./user/user-valid-grid-view/user-valid-grid-view.vue'),
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
    case 'idea_template_global_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea-template/idea-template-global-all-grid-view/idea-template-global-all-grid-view.vue'
          ),
      );
    case 'workload_calendar_work_item_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-calendar-work-item-grid-view/workload-calendar-work-item-grid-view.vue'
          ),
      );
    case 'insight_member_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-member/insight-member-redirect-view/insight-member-redirect-view.vue'
          ),
      );
    case 'library_member_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './library-member/library-member-redirect-view/library-member-redirect-view.vue'
          ),
      );
    case 'psde_field_idea_extend_transmit_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-field/psde-field-idea-extend-transmit-grid-view/psde-field-idea-extend-transmit-grid-view.vue'
          ),
      );
    case 'project_org_grid_view':
      return defineAsyncComponent(
        () =>
          import('./project/project-org-grid-view/project-org-grid-view.vue'),
      );
    case 'review_all_grid_view':
      return defineAsyncComponent(
        () => import('./review/review-all-grid-view/review-all-grid-view.vue'),
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
    case 'release_sprint_relation_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './release/release-sprint-relation-grid-view/release-sprint-relation-grid-view.vue'
          ),
      );
    case 'workload_management_tab_search_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-management-tab-search-view/workload-management-tab-search-view.vue'
          ),
      );
    case 'baseline_library_categories_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-library-categories-pick-up-tree-view/baseline-library-categories-pick-up-tree-view.vue'
          ),
      );
    case 'workload_product_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-product-grid-view/workload-product-grid-view.vue'
          ),
      );
    case 'work_item_completed_drill_detail_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-completed-drill-detail-grid-view/work-item-completed-drill-detail-grid-view.vue'
          ),
      );
    case 'workload_management_library_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-management-library-grid-view/workload-management-library-grid-view.vue'
          ),
      );
    case 'member_all_resource_mpick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './member/member-all-resource-mpick-up-view/member-all-resource-mpick-up-view.vue'
          ),
      );
    case 'work_item_edit_view':
      return defineAsyncComponent(
        () => import('./work-item/work-item-edit-view/work-item-edit-view.vue'),
      );
    case 'article_page_with_version_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-with-version-view/article-page-with-version-view.vue'
          ),
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
    case 'baseline_test_case_relation_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline-test-case/baseline-test-case-relation-grid-view/baseline-test-case-relation-grid-view.vue'
          ),
      );
    case 'relation_idea_re_ticket_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-idea-re-ticket-list-view/relation-idea-re-ticket-list-view.vue'
          ),
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
    case 'baseline_edit_view':
      return defineAsyncComponent(
        () => import('./baseline/baseline-edit-view/baseline-edit-view.vue'),
      );
    case 'discuss_topic_in_progress_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-in-progress-grid-view/discuss-topic-in-progress-grid-view.vue'
          ),
      );
    case 'insight_view_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-tree-exp-view/insight-view-tree-exp-view.vue'
          ),
      );
    case 'work_item_kanban_bug_daily_tide_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-kanban-bug-daily-tide-report-view/work-item-kanban-bug-daily-tide-report-view.vue'
          ),
      );
    case 'workload_user_group_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-user-group-grid-view/workload-user-group-grid-view.vue'
          ),
      );
    case 'work_item_type_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-type/work-item-type-edit-view/work-item-type-edit-view.vue'
          ),
      );
    case 'insight_member_config_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-member/insight-member-config-grid-view/insight-member-config-grid-view.vue'
          ),
      );
    case 'discuss_topic_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-tree-exp-view/discuss-topic-tree-exp-view.vue'
          ),
      );
    case 'project_member_role_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-member/project-member-role-edit-view/project-member-role-edit-view.vue'
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
    case 'discuss_topic_index_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-index-view/discuss-topic-index-view.vue'
          ),
      );
    case 'baseline_space_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-space-tree-exp-view/baseline-space-tree-exp-view.vue'
          ),
      );
    case 'product_ticket_type_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-ticket-type/product-ticket-type-quick-create-view/product-ticket-type-quick-create-view.vue'
          ),
      );
    case 'baseline_product_categories_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-product-categories-pick-up-tree-view/baseline-product-categories-pick-up-tree-view.vue'
          ),
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
    case 'discuss_topic_is_archived_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-is-archived-grid-view/discuss-topic-is-archived-grid-view.vue'
          ),
      );
    case 'dyna_dashboard_system_board_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './dyna-dashboard/dyna-dashboard-system-board-grid-view/dyna-dashboard-system-board-grid-view.vue'
          ),
      );
    case 'test_plan_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-redirect-view/test-plan-redirect-view.vue'
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
    case 'login_log_grid_view':
      return defineAsyncComponent(
        () => import('./login-log/login-log-grid-view/login-log-grid-view.vue'),
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
    case 'psde_field_data_extend_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-field/psde-field-data-extend-grid-view/psde-field-data-extend-grid-view.vue'
          ),
      );
    case 'insight_view_in_progress_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-in-progress-grid-view/insight-view-in-progress-grid-view.vue'
          ),
      );
    case 'test_case_template_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case-template/test-case-template-edit-view/test-case-template-edit-view.vue'
          ),
      );
    case 'review_drill_detail_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './review/review-drill-detail-grid-view/review-drill-detail-grid-view.vue'
          ),
      );
    case 'workload_type_quick_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload-type/workload-type-quick-edit-view/workload-type-quick-edit-view.vue'
          ),
      );
    case 'idea_config_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-config-tab-exp-view/idea-config-tab-exp-view.vue'
          ),
      );
    case 'work_item_wizard_detail_target_state_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-wizard-detail/work-item-wizard-detail-target-state-grid-view/work-item-wizard-detail-target-state-grid-view.vue'
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
    case 'baseline_project_update_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-project-update-view/baseline-project-update-view.vue'
          ),
      );
    case 'customer_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import(
            './customer/customer-pick-up-tree-view/customer-pick-up-tree-view.vue'
          ),
      );
    case 'ps_sys_bi_cube_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './ps-sys-bi-cube/ps-sys-bi-cube-tree-exp-view/ps-sys-bi-cube-tree-exp-view.vue'
          ),
      );
    case 'product_edit_view':
      return defineAsyncComponent(
        () => import('./product/product-edit-view/product-edit-view.vue'),
      );
    case 'insight_view_team_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-team-grid-view/insight-view-team-grid-view.vue'
          ),
      );
    case 'release_release_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import(
            './release/release-release-pick-up-tree-view/release-release-pick-up-tree-view.vue'
          ),
      );
    case 'workload_update_view':
      return defineAsyncComponent(
        () =>
          import('./workload/workload-update-view/workload-update-view.vue'),
      );
    case 'workload_type_setup_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload-type/workload-type-setup-grid-view/workload-type-setup-grid-view.vue'
          ),
      );
    case 'baseline_library_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-library-create-view/baseline-library-create-view.vue'
          ),
      );
    case 'work_item_scrum_defect_property_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-scrum-defect-property-report-view/work-item-scrum-defect-property-report-view.vue'
          ),
      );
    case 'stage_data_global_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './stage/stage-data-global-grid-view/stage-data-global-grid-view.vue'
          ),
      );
    case 'product_details_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-details-setting-view/product-details-setting-view.vue'
          ),
      );
    case 'discuss_topic_config_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-config-tree-exp-view/discuss-topic-config-tree-exp-view.vue'
          ),
      );
    case 'discuss_member_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-member/discuss-member-edit-view/discuss-member-edit-view.vue'
          ),
      );
    case 'sprint_edit_view':
      return defineAsyncComponent(
        () => import('./sprint/sprint-edit-view/sprint-edit-view.vue'),
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
    case 'baseline_library_main_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-library-main-view/baseline-library-main-view.vue'
          ),
      );
    case 'insight_report_report_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-report/insight-report-report-tree-exp-view/insight-report-report-tree-exp-view.vue'
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
    case 'project_drill_detail_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-drill-detail-grid-view/project-drill-detail-grid-view.vue'
          ),
      );
    case 'member_role_edit_view':
      return defineAsyncComponent(
        () =>
          import('./member/member-role-edit-view/member-role-edit-view.vue'),
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
    case 'relation_depend_on_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-depend-on-list-view/relation-depend-on-list-view.vue'
          ),
      );
    case 'work_item_state_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-state/work-item-state-quick-create-view/work-item-state-quick-create-view.vue'
          ),
      );
    case 'project_scrum_flow_setting_tab_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-scrum-flow-setting-tab-view/project-scrum-flow-setting-tab-view.vue'
          ),
      );
    case 'insight_member_assigned_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-member/insight-member-assigned-grid-view/insight-member-assigned-grid-view.vue'
          ),
      );
    case 'space_shared_view':
      return defineAsyncComponent(
        () => import('./space/space-shared-view/space-shared-view.vue'),
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
    case 'project_scrum_main_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-scrum-main-view/project-scrum-main-view.vue'
          ),
      );
    case 'discuss_post_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-post/discuss-post-redirect-view/discuss-post-redirect-view.vue'
          ),
      );
    case 'relation_work_item_re_self_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-work-item-re-self-list-view/relation-work-item-re-self-list-view.vue'
          ),
      );
    case 'discuss_post_recycle_bin_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-post/discuss-post-recycle-bin-grid-view/discuss-post-recycle-bin-grid-view.vue'
          ),
      );
    case 'project_project_grid_parts':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-project-grid-parts/project-project-grid-parts.vue'
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
    case 'addon_library_setting_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './addon/addon-library-setting-grid-view/addon-library-setting-grid-view.vue'
          ),
      );
    case 'insight_view_config_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-config-tree-exp-view/insight-view-config-tree-exp-view.vue'
          ),
      );
    case 'psde_field_global_idea_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-field/psde-field-global-idea-grid-view/psde-field-global-idea-grid-view.vue'
          ),
      );
    case 'version_edit_view':
      return defineAsyncComponent(
        () => import('./version/version-edit-view/version-edit-view.vue'),
      );
    case 'project_state_quick_create_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-state/project-state-quick-create-option-view/project-state-quick-create-option-view.vue'
          ),
      );
    case 'discuss_post_main_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-post/discuss-post-main-view/discuss-post-main-view.vue'
          ),
      );
    case 'idea_edit_view':
      return defineAsyncComponent(
        () => import('./idea/idea-edit-view/idea-edit-view.vue'),
      );
    case 'review_content_grid_view_all':
      return defineAsyncComponent(
        () =>
          import(
            './review-content/review-content-grid-view-all/review-content-grid-view-all.vue'
          ),
      );
    case 'workload_management_work_type_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-management-work-type-grid-view/workload-management-work-type-grid-view.vue'
          ),
      );
    case 'idea_product_dyna_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-product-dyna-tab-exp-view/idea-product-dyna-tab-exp-view.vue'
          ),
      );
    case 'work_item_project_set_resource_gantt_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-project-set-resource-gantt-view/work-item-project-set-resource-gantt-view.vue'
          ),
      );
    case 'search_attachment_cur_product_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './search-attachment/search-attachment-cur-product-grid-view/search-attachment-cur-product-grid-view.vue'
          ),
      );
    case 'space_choose_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-choose-option-view/space-choose-option-view.vue'
          ),
      );
    case 'test_case_template_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case-template/test-case-template-all-grid-view/test-case-template-all-grid-view.vue'
          ),
      );
    case 'stage_edit_view':
      return defineAsyncComponent(
        () => import('./stage/stage-edit-view/stage-edit-view.vue'),
      );
    case 'template_flow_data_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/template-flow-data-view/template-flow-data-view.vue'
          ),
      );
    case 'article_page_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-pick-up-tree-view/article-page-pick-up-tree-view.vue'
          ),
      );
    case 'insight_report_set_category_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-report/insight-report-set-category-option-view/insight-report-set-category-option-view.vue'
          ),
      );
    case 'run_all_grid_view':
      return defineAsyncComponent(
        () => import('./run/run-all-grid-view/run-all-grid-view.vue'),
      );
    case 'ticket_app_data_upload_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket-app-data-upload-view/ticket-app-data-upload-view.vue'
          ),
      );
    case 'library_in_progress_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-in-progress-grid-view/library-in-progress-grid-view.vue'
          ),
      );
    case 'workload_drill_detail_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-drill-detail-grid-view/workload-drill-detail-grid-view.vue'
          ),
      );
    case 'waterfall_bug_app_data_upload_view':
      return defineAsyncComponent(
        () =>
          import(
            './waterfall-bug-app-data-upload-view/waterfall-bug-app-data-upload-view.vue'
          ),
      );
    case 'library_config_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-config-tab-exp-view/library-config-tab-exp-view.vue'
          ),
      );
    case 'space_create_wizard_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-create-wizard-view/space-create-wizard-view.vue'
          ),
      );
    case 'baseline_idea_relation_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline-idea/baseline-idea-relation-grid-view/baseline-idea-relation-grid-view.vue'
          ),
      );
    case 'library_all_grid_view':
      return defineAsyncComponent(
        () =>
          import('./library/library-all-grid-view/library-all-grid-view.vue'),
      );
    case 'test_case_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-test-case-grid-view/test-case-test-case-grid-view.vue'
          ),
      );
    case 'baseline_project_categories_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-project-categories-pick-up-tree-view/baseline-project-categories-pick-up-tree-view.vue'
          ),
      );
    case 'shared_space_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './shared-space/shared-space-edit-view/shared-space-edit-view.vue'
          ),
      );
    case 'library_is_archived_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-is-archived-grid-view/library-is-archived-grid-view.vue'
          ),
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
    case 'dictionary_data_ticket_confirm_remove_view':
      return defineAsyncComponent(
        () =>
          import(
            './dictionary-data/dictionary-data-ticket-confirm-remove-view/dictionary-data-ticket-confirm-remove-view.vue'
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
    case 'space_org_grid_view':
      return defineAsyncComponent(
        () => import('./space/space-org-grid-view/space-org-grid-view.vue'),
      );
    case 'shared_space_shared_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './shared-space/shared-space-shared-grid-view/shared-space-shared-grid-view.vue'
          ),
      );
    case 'space_member_assigned_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './space-member/space-member-assigned-grid-view/space-member-assigned-grid-view.vue'
          ),
      );
    case 'work_item_dyna_hybrid_tree_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-dyna-hybrid-tree-grid-view/work-item-dyna-hybrid-tree-grid-view.vue'
          ),
      );
    case 'portfolio_member_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio-member/portfolio-member-redirect-view/portfolio-member-redirect-view.vue'
          ),
      );
    case 'relation_test_case_re_idea_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-test-case-re-idea-grid-view/relation-test-case-re-idea-grid-view.vue'
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
    case 'project_property_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-property-edit-view/project-property-edit-view.vue'
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
    case 'space_is_archived_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-is-archived-grid-view/space-is-archived-grid-view.vue'
          ),
      );
    case 'product_tag_product_tag_confirm_remove_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-tag/product-tag-product-tag-confirm-remove-view/product-tag-product-tag-confirm-remove-view.vue'
          ),
      );
    case 'work_item_baseline_mpick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-baseline-mpick-up-view/work-item-baseline-mpick-up-view.vue'
          ),
      );
    case 'work_item_dyna_kanban_tree_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-dyna-kanban-tree-grid-view/work-item-dyna-kanban-tree-grid-view.vue'
          ),
      );
    case 'test_case_recycle_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-recycle-grid-view/test-case-recycle-grid-view.vue'
          ),
      );
    case 'product_show_edit_view':
      return defineAsyncComponent(
        () =>
          import('./product/product-show-edit-view/product-show-edit-view.vue'),
      );
    case 'test_case_re_case_by_workitem_pickup_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-re-case-by-workitem-pickup-view/test-case-re-case-by-workitem-pickup-view.vue'
          ),
      );
    case 'space_person_grid_view':
      return defineAsyncComponent(
        () =>
          import('./space/space-person-grid-view/space-person-grid-view.vue'),
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
    case 'customer_pick_up_view':
      return defineAsyncComponent(
        () =>
          import('./customer/customer-pick-up-view/customer-pick-up-view.vue'),
      );
    case 'article_page_quick_new_page_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-quick-new-page-option-view/article-page-quick-new-page-option-view.vue'
          ),
      );
    case 'baseline_work_item_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline-work-item/baseline-work-item-edit-view/baseline-work-item-edit-view.vue'
          ),
      );
    case 'discuss_post_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-post/discuss-post-edit-view/discuss-post-edit-view.vue'
          ),
      );
    case 'workspace_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './workspace/workspace-quick-create-view/workspace-quick-create-view.vue'
          ),
      );
    case 'work_item_child_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-child-grid-view/work-item-child-grid-view.vue'
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
    case 'relation_idea_re_work_item_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-idea-re-work-item-list-view/relation-idea-re-work-item-list-view.vue'
          ),
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
    case 'recent_recent_summary_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recent-recent-summary-view/recent-recent-summary-view.vue'
          ),
      );
    case 'work_item_scrum_bug_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-scrum-bug-grid-view/work-item-scrum-bug-grid-view.vue'
          ),
      );
    case 'insight_view_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-all-grid-view/insight-view-all-grid-view.vue'
          ),
      );
    case 'insight_report_bi_report_content_panel_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-report/insight-report-bi-report-content-panel-view/insight-report-bi-report-content-panel-view.vue'
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
    case 'ticket_type_global_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket-type/ticket-type-global-setting-view/ticket-type-global-setting-view.vue'
          ),
      );
    case 'article_page_upload_icon_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-upload-icon-option-view/article-page-upload-icon-option-view.vue'
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
    case 'test_case_app_data_upload_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case-app-data-upload-view/test-case-app-data-upload-view.vue'
          ),
      );
    case 'relation_idea_re_ticket_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-idea-re-ticket-grid-view/relation-idea-re-ticket-grid-view.vue'
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
    case 'addon_space_setting_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './addon/addon-space-setting-grid-view/addon-space-setting-grid-view.vue'
          ),
      );
    case 'test_case_baseline_mpick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-baseline-mpick-up-view/test-case-baseline-mpick-up-view.vue'
          ),
      );
    case 'dictionary_data_state_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './dictionary-data/dictionary-data-state-edit-view/dictionary-data-state-edit-view.vue'
          ),
      );
    case 'workload_day_type_link_management_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-day-type-link-management-grid-view/workload-day-type-link-management-grid-view.vue'
          ),
      );
    case 'stage_del_confirm_view':
      return defineAsyncComponent(
        () =>
          import('./stage/stage-del-confirm-view/stage-del-confirm-view.vue'),
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
    case 'product_plan_categories_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-plan/product-plan-categories-pick-up-tree-view/product-plan-categories-pick-up-tree-view.vue'
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
    case 'test_plan_report_dashboard_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-report-dashboard-view/test-plan-report-dashboard-view.vue'
          ),
      );
    case 'run_priority_distributions_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './run/run-priority-distributions-report-view/run-priority-distributions-report-view.vue'
          ),
      );
    case 'guideline_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './guideline/guideline-all-grid-view/guideline-all-grid-view.vue'
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
    case 'baseline_idea_comparison_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline-idea/baseline-idea-comparison-grid-view/baseline-idea-comparison-grid-view.vue'
          ),
      );
    case 'test_plan_in_progress_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-in-progress-grid-view/test-plan-in-progress-grid-view.vue'
          ),
      );
    case 'article_page_model_show_view_noupdown':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-model-show-view-noupdown/article-page-model-show-view-noupdown.vue'
          ),
      );
    case 'login_log_over_view':
      return defineAsyncComponent(
        () => import('./login-log/login-log-over-view/login-log-over-view.vue'),
      );
    case 'insight_view_person_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-person-grid-view/insight-view-person-grid-view.vue'
          ),
      );
    case 'idea_recycle_grid_view':
      return defineAsyncComponent(
        () =>
          import('./idea/idea-recycle-grid-view/idea-recycle-grid-view.vue'),
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
    case 'work_item_dyna_kanban_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-dyna-kanban-quick-create-view/work-item-dyna-kanban-quick-create-view.vue'
          ),
      );
    case 'project_baseinfo_over_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-baseinfo-over-view/project-baseinfo-over-view.vue'
          ),
      );
    case 'review_content_result_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './review-content/review-content-result-option-view/review-content-result-option-view.vue'
          ),
      );
    case 'discuss_post_my_create_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-post/discuss-post-my-create-grid-view/discuss-post-my-create-grid-view.vue'
          ),
      );
    case 'insight_view_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-setting-view/insight-view-setting-view.vue'
          ),
      );
    case 'member_edit_view':
      return defineAsyncComponent(
        () => import('./member/member-edit-view/member-edit-view.vue'),
      );
    case 'library_org_grid_view':
      return defineAsyncComponent(
        () =>
          import('./library/library-org-grid-view/library-org-grid-view.vue'),
      );
    case 'product_product_list_parts':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-product-list-parts/product-product-list-parts.vue'
          ),
      );
    case 'review_stage_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './review-stage/review-stage-list-view/review-stage-list-view.vue'
          ),
      );
    case 'idea_template_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea-template/idea-template-edit-view/idea-template-edit-view.vue'
          ),
      );
    case 'project_state_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-state/project-state-grid-view/project-state-grid-view.vue'
          ),
      );
    case 'baseline_idea_relation_version_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline-idea/baseline-idea-relation-version-list-view/baseline-idea-relation-version-list-view.vue'
          ),
      );
    case 'space_edit_view':
      return defineAsyncComponent(
        () => import('./space/space-edit-view/space-edit-view.vue'),
      );
    case 'relation_work_item_re_idea_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-work-item-re-idea-grid-view/relation-work-item-re-idea-grid-view.vue'
          ),
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
    case 'baseline_space_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-space-grid-view/baseline-space-grid-view.vue'
          ),
      );
    case 'test_plan_my_assignee_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-my-assignee-grid-view/test-plan-my-assignee-grid-view.vue'
          ),
      );
    case 'workload_day_type_link_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-day-type-link-grid-view/workload-day-type-link-grid-view.vue'
          ),
      );
    case 'discuss_member_config_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-member/discuss-member-config-grid-view/discuss-member-config-grid-view.vue'
          ),
      );
    case 'project_notice_show_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-notice-show-view/project-notice-show-view.vue'
          ),
      );
    case 'article_page_shared_with_me_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-shared-with-me-view/article-page-shared-with-me-view.vue'
          ),
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
    case 'test_case_my_attention_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-my-attention-grid-view/test-case-my-attention-grid-view.vue'
          ),
      );
    case 'project_waterfall_flow_setting_tab_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-waterfall-flow-setting-tab-view/project-waterfall-flow-setting-tab-view.vue'
          ),
      );
    case 'library_team_grid_view':
      return defineAsyncComponent(
        () =>
          import('./library/library-team-grid-view/library-team-grid-view.vue'),
      );
    case 'project_hybrid_flow_setting_tab_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-hybrid-flow-setting-tab-view/project-hybrid-flow-setting-tab-view.vue'
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
    case 'idea_show_edit_view':
      return defineAsyncComponent(
        () => import('./idea/idea-show-edit-view/idea-show-edit-view.vue'),
      );
    case 'insight_view_deleted_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-deleted-grid-view/insight-view-deleted-grid-view.vue'
          ),
      );
    case 'test_case_case_move_plan_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-case-move-plan-option-view/test-case-case-move-plan-option-view.vue'
          ),
      );
    case 'sprint_redirect_view':
      return defineAsyncComponent(
        () => import('./sprint/sprint-redirect-view/sprint-redirect-view.vue'),
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
    case 'member_all_resource_mpick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './member/member-all-resource-mpick-up-grid-view/member-all-resource-mpick-up-grid-view.vue'
          ),
      );
    case 'discuss_topic_group_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-group-grid-view/discuss-topic-group-grid-view.vue'
          ),
      );
    case 'ticket_setting_view':
      return defineAsyncComponent(
        () => import('./ticket/ticket-setting-view/ticket-setting-view.vue'),
      );
    case 'product_ticket_type_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-ticket-type/product-ticket-type-edit-view/product-ticket-type-edit-view.vue'
          ),
      );
    case 'insight_view_create_wizard_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-create-wizard-view/insight-view-create-wizard-view.vue'
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
    case 'discuss_reply_latest_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-reply/discuss-reply-latest-grid-view/discuss-reply-latest-grid-view.vue'
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
    case 'work_item_type_global_setting_view_kanban':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-type/work-item-type-global-setting-view-kanban/work-item-type-global-setting-view-kanban.vue'
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
    case 'scrum_bug_app_data_upload_view':
      return defineAsyncComponent(
        () =>
          import(
            './scrum-bug-app-data-upload-view/scrum-bug-app-data-upload-view.vue'
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
    case 'product_main_view':
      return defineAsyncComponent(
        () => import('./product/product-main-view/product-main-view.vue'),
      );
    case 'work_edit_view':
      return defineAsyncComponent(
        () => import('./work/work-edit-view/work-edit-view.vue'),
      );
    case 'relation_work_item_re_idea_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-work-item-re-idea-list-view/relation-work-item-re-idea-list-view.vue'
          ),
      );
    case 'sprint_base_info_custom_view':
      return defineAsyncComponent(
        () =>
          import(
            './sprint/sprint-base-info-custom-view/sprint-base-info-custom-view.vue'
          ),
      );
    case 'shared_space_setting_center_view':
      return defineAsyncComponent(
        () =>
          import(
            './shared-space/shared-space-setting-center-view/shared-space-setting-center-view.vue'
          ),
      );
    case 'review_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import(
            './review/review-pick-up-tree-view/review-pick-up-tree-view.vue'
          ),
      );
    case 'review_edit_view':
      return defineAsyncComponent(
        () => import('./review/review-edit-view/review-edit-view.vue'),
      );
    case 'psdelogicquick_create_view_schedule':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psdelogicquick-create-view-schedule/psdelogicquick-create-view-schedule.vue'
          ),
      );
    case 'test_case_move_case_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-move-case-option-view/test-case-move-case-option-view.vue'
          ),
      );
    case 'work_item_state_update_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-state/work-item-state-update-view/work-item-state-update-view.vue'
          ),
      );
    case 'group_update_view':
      return defineAsyncComponent(
        () => import('./group/group-update-view/group-update-view.vue'),
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
    case 'work_item_test_drill_detail_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-test-drill-detail-grid-view/work-item-test-drill-detail-grid-view.vue'
          ),
      );
    case 'product_is_archived_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-is-archived-grid-view/product-is-archived-grid-view.vue'
          ),
      );
    case 'ps_sys_bi_cube_dimension_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './ps-sys-bi-cube-dimension/ps-sys-bi-cube-dimension-edit-view/ps-sys-bi-cube-dimension-edit-view.vue'
          ),
      );
    case 'psdelogicquick_cfg_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psdelogicquick-cfg-view/psdelogicquick-cfg-view.vue'
          ),
      );
    case 'test_plan_conclude_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-conclude-edit-view/test-plan-conclude-edit-view.vue'
          ),
      );
    case 'review_content_no_grid_view_all':
      return defineAsyncComponent(
        () =>
          import(
            './review-content/review-content-no-grid-view-all/review-content-no-grid-view-all.vue'
          ),
      );
    case 'relation_run_re_work_item_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-run-re-work-item-grid-view/relation-run-re-work-item-grid-view.vue'
          ),
      );
    case 'review_complete_review_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './review/review-complete-review-option-view/review-complete-review-option-view.vue'
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
    case 'insight_view_base_info_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-base-info-edit-view/insight-view-base-info-edit-view.vue'
          ),
      );
    case 'sprint_drill_detail_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './sprint/sprint-drill-detail-grid-view/sprint-drill-detail-grid-view.vue'
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
    case 'article_page_space_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-space-grid-view/article-page-space-grid-view.vue'
          ),
      );
    case 'search_attachment_advanced_search_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './search-attachment/search-attachment-advanced-search-grid-view/search-attachment-advanced-search-grid-view.vue'
          ),
      );
    case 'workload_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-redirect-view/workload-redirect-view.vue'
          ),
      );
    case 'review_baseline_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './review/review-baseline-grid-view/review-baseline-grid-view.vue'
          ),
      );
    case 'run_filter_grid_view':
      return defineAsyncComponent(
        () => import('./run/run-filter-grid-view/run-filter-grid-view.vue'),
      );
    case 'space_team_grid_view':
      return defineAsyncComponent(
        () => import('./space/space-team-grid-view/space-team-grid-view.vue'),
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
    case 'space_project_re_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-project-re-tree-exp-view/space-project-re-tree-exp-view.vue'
          ),
      );
    case 'test_plan_update_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-update-option-view/test-plan-update-option-view.vue'
          ),
      );
    case 'relation_run_re_idea_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-run-re-idea-grid-view/relation-run-re-idea-grid-view.vue'
          ),
      );
    case 'psdelogicglobal_flow_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psdelogicglobal-flow-grid-view/psdelogicglobal-flow-grid-view.vue'
          ),
      );
    case 'product_org_grid_view':
      return defineAsyncComponent(
        () =>
          import('./product/product-org-grid-view/product-org-grid-view.vue'),
      );
    case 'work_item_all_scrum_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-all-scrum-grid-view/work-item-all-scrum-grid-view.vue'
          ),
      );
    case 'work_item_scrum_require_tree_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-scrum-require-tree-grid-view/work-item-scrum-require-tree-grid-view.vue'
          ),
      );
    case 'work_item_plan_work_item_mpick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-plan-work-item-mpick-up-view/work-item-plan-work-item-mpick-up-view.vue'
          ),
      );
    case 'idea_dyna_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import('./idea/idea-dyna-tab-exp-view/idea-dyna-tab-exp-view.vue'),
      );
    case 'work_item_scrum_defect_age_report_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-scrum-defect-age-report-view/work-item-scrum-defect-age-report-view.vue'
          ),
      );
    case 'discuss_reply_my_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-reply/discuss-reply-my-grid-view/discuss-reply-my-grid-view.vue'
          ),
      );
    case 'ps_sys_bi_cube_measure_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ps-sys-bi-cube-measure/ps-sys-bi-cube-measure-all-grid-view/ps-sys-bi-cube-measure-all-grid-view.vue'
          ),
      );
    case 'library_base_info_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-base-info-edit-view/library-base-info-edit-view.vue'
          ),
      );
    case 'dictionary_data_idea_confirm_remove_view':
      return defineAsyncComponent(
        () =>
          import(
            './dictionary-data/dictionary-data-idea-confirm-remove-view/dictionary-data-idea-confirm-remove-view.vue'
          ),
      );
    case 'work_item_burn_out_custom_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-burn-out-custom-view/work-item-burn-out-custom-view.vue'
          ),
      );
    case 'test_case_advanced_search_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-advanced-search-grid-view/test-case-advanced-search-grid-view.vue'
          ),
      );
    case 'work_item_wizard_detail_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-wizard-detail/work-item-wizard-detail-redirect-view/work-item-wizard-detail-redirect-view.vue'
          ),
      );
    case 'sprint_release_relation_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './sprint/sprint-release-relation-grid-view/sprint-release-relation-grid-view.vue'
          ),
      );
    case 'psde_field_grid_view':
      return defineAsyncComponent(
        () =>
          import('./psde-field/psde-field-grid-view/psde-field-grid-view.vue'),
      );
    case 'space_category_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-category-grid-view/space-category-grid-view.vue'
          ),
      );
    case 'category_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './category/category-pick-up-grid-view/category-pick-up-grid-view.vue'
          ),
      );
    case 'work_item_waterfall_require_tree_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-waterfall-require-tree-grid-view/work-item-waterfall-require-tree-grid-view.vue'
          ),
      );
    case 'work_item_dyna_scrum_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-dyna-scrum-quick-create-view/work-item-dyna-scrum-quick-create-view.vue'
          ),
      );
    case 'baseline_space_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-space-create-view/baseline-space-create-view.vue'
          ),
      );
    case 'project_is_archived_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-is-archived-grid-view/project-is-archived-grid-view.vue'
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
    case 'insight_view_advanced_setting_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-advanced-setting-edit-view/insight-view-advanced-setting-edit-view.vue'
          ),
      );
    case 'guideline_edit_view':
      return defineAsyncComponent(
        () => import('./guideline/guideline-edit-view/guideline-edit-view.vue'),
      );
    case 'product_team_grid_view':
      return defineAsyncComponent(
        () =>
          import('./product/product-team-grid-view/product-team-grid-view.vue'),
      );
    case 'idea_baseline_mpick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-baseline-mpick-up-grid-view/idea-baseline-mpick-up-grid-view.vue'
          ),
      );
    case 'baseline_product_update_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-product-update-view/baseline-product-update-view.vue'
          ),
      );
    case 'test_case_edit_view':
      return defineAsyncComponent(
        () => import('./test-case/test-case-edit-view/test-case-edit-view.vue'),
      );
    case 'test_case_mpick_up_view_review':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-mpick-up-view-review/test-case-mpick-up-view-review.vue'
          ),
      );
    case 'product_create_wizard_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-create-wizard-view/product-create-wizard-view.vue'
          ),
      );
    case 'addon_no_name_setting_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './addon/addon-no-name-setting-grid-view/addon-no-name-setting-grid-view.vue'
          ),
      );
    case 'library_member_role_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './library-member/library-member-role-edit-view/library-member-role-edit-view.vue'
          ),
      );
    case 'baseline_product_main_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-product-main-view/baseline-product-main-view.vue'
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
    case 'addon_product_setting_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './addon/addon-product-setting-grid-view/addon-product-setting-grid-view.vue'
          ),
      );
    case 'baseline_test_case_comparison_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline-test-case/baseline-test-case-comparison-grid-view/baseline-test-case-comparison-grid-view.vue'
          ),
      );
    case 'release_relation_mpick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './release/release-relation-mpick-up-view/release-relation-mpick-up-view.vue'
          ),
      );
    case 'product_ticket_type_global_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-ticket-type/product-ticket-type-global-setting-view/product-ticket-type-global-setting-view.vue'
          ),
      );
    case 'space_member_config_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './space-member/space-member-config-grid-view/space-member-config-grid-view.vue'
          ),
      );
    case 'idea_idea_filter_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-idea-filter-grid-view/idea-idea-filter-grid-view.vue'
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
    case 'work_item_release_work_item_custom_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-release-work-item-custom-view/work-item-release-work-item-custom-view.vue'
          ),
      );
    case 'product_recover_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-recover-tab-exp-view/product-recover-tab-exp-view.vue'
          ),
      );
    case 'baseline_work_item_relation_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline-work-item/baseline-work-item-relation-grid-view/baseline-work-item-relation-grid-view.vue'
          ),
      );
    case 'release_drill_detail_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './release/release-drill-detail-grid-view/release-drill-detail-grid-view.vue'
          ),
      );
    case 'test_case_version_comparison_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-version-comparison-view/test-case-version-comparison-view.vue'
          ),
      );
    case 'relation_idea_re_work_item_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-idea-re-work-item-grid-view/relation-idea-re-work-item-grid-view.vue'
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
    case 'discuss_topic_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-tab-exp-view/discuss-topic-tab-exp-view.vue'
          ),
      );
    case 'article_page_upload_view':
      return defineAsyncComponent(
        () => import('./article-page-upload-view/article-page-upload-view.vue'),
      );
    case 'discuss_member_role_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-member/discuss-member-role-edit-view/discuss-member-role-edit-view.vue'
          ),
      );
    case 'test_case_my_craeted_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-my-craeted-grid-view/test-case-my-craeted-grid-view.vue'
          ),
      );
    case 'idea_template_create_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea-template/idea-template-create-edit-view/idea-template-create-edit-view.vue'
          ),
      );
    case 'test_plan_sprint_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-sprint-grid-view/test-plan-sprint-grid-view.vue'
          ),
      );
    case 'test_case_re_case_by_release_pickup_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-re-case-by-release-pickup-view/test-case-re-case-by-release-pickup-view.vue'
          ),
      );
    case 'product_ticket_configuration_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-ticket-configuration-tab-exp-view/product-ticket-configuration-tab-exp-view.vue'
          ),
      );
    case 'project_kanban_flow_setting_tab_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-kanban-flow-setting-tab-view/project-kanban-flow-setting-tab-view.vue'
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
    case 'apploginview':
      return defineAsyncComponent(
        () => import('./apploginview/apploginview.vue'),
      );
    case 'discuss_topic_topic_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-topic-grid-view/discuss-topic-topic-grid-view.vue'
          ),
      );
    case 'baseline_product_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-product-grid-view/baseline-product-grid-view.vue'
          ),
      );
    case 'relation_work_item_re_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-work-item-re-test-case-grid-view/relation-work-item-re-test-case-grid-view.vue'
          ),
      );
    case 'stencil_show_edit_view':
      return defineAsyncComponent(
        () =>
          import('./stencil/stencil-show-edit-view/stencil-show-edit-view.vue'),
      );
    case 'relation_test_case_re_bug_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-test-case-re-bug-grid-view/relation-test-case-re-bug-grid-view.vue'
          ),
      );
    case 'recent_recent_page_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recent-recent-page-grid-view/recent-recent-page-grid-view.vue'
          ),
      );
    case 'test_plan_release_relation_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-release-relation-grid-view/test-plan-release-relation-grid-view.vue'
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
    case 'project_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import('./project/project-tree-exp-view/project-tree-exp-view.vue'),
      );
    case 'test_plan_categories_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-categories-pick-up-tree-view/test-plan-categories-pick-up-tree-view.vue'
          ),
      );
    case 'project_tag_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-tag/project-tag-redirect-view/project-tag-redirect-view.vue'
          ),
      );
    case 'idea_version_comparison_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-version-comparison-view/idea-version-comparison-view.vue'
          ),
      );
    case 'article_page_re_show_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-re-show-view/article-page-re-show-view.vue'
          ),
      );
    case 'review_content_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './review-content/review-content-edit-view/review-content-edit-view.vue'
          ),
      );
    case 'work_item_hybrid_kanban_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-hybrid-kanban-view/work-item-hybrid-kanban-view.vue'
          ),
      );
    case 'library_filter_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-filter-tab-exp-view/library-filter-tab-exp-view.vue'
          ),
      );
    case 'insight_view_management_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-management-tab-exp-view/insight-view-management-tab-exp-view.vue'
          ),
      );
    case 'user_redirect_view':
      return defineAsyncComponent(
        () => import('./user/user-redirect-view/user-redirect-view.vue'),
      );
    case 'test_case_configuration_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-configuration-view/test-case-configuration-view.vue'
          ),
      );
    case 'insight_report_baseinfo_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-report/insight-report-baseinfo-edit-view/insight-report-baseinfo-edit-view.vue'
          ),
      );
    case 'customer_idea_customer_info_view':
      return defineAsyncComponent(
        () =>
          import(
            './customer/customer-idea-customer-info-view/customer-idea-customer-info-view.vue'
          ),
      );
    case 'version_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './version/version-test-case-grid-view/version-test-case-grid-view.vue'
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
    case 'discuss_topic_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-all-grid-view/discuss-topic-all-grid-view.vue'
          ),
      );
    case 'discuss_topic_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-setting-view/discuss-topic-setting-view.vue'
          ),
      );
    case 'ticket_idea_re_ticket_statistics_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-idea-re-ticket-statistics-view/ticket-idea-re-ticket-statistics-view.vue'
          ),
      );
    case 'article_page_my_favorite_page_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-my-favorite-page-grid-view/article-page-my-favorite-page-grid-view.vue'
          ),
      );
    case 'space_space_grid_view':
      return defineAsyncComponent(
        () => import('./space/space-space-grid-view/space-space-grid-view.vue'),
      );
    case 'baseline_page_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline-page/baseline-page-edit-view/baseline-page-edit-view.vue'
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
    case 'ticket_type_confirm_remove_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket-type/ticket-type-confirm-remove-view/ticket-type-confirm-remove-view.vue'
          ),
      );
    case 'release_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import('./release/release-tree-exp-view/release-tree-exp-view.vue'),
      );
    case 'baseline_project_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-project-tree-exp-view/baseline-project-tree-exp-view.vue'
          ),
      );
    case 'guideline_library_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './guideline/guideline-library-all-grid-view/guideline-library-all-grid-view.vue'
          ),
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
    case 'baseline_test_case_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline-test-case/baseline-test-case-edit-view/baseline-test-case-edit-view.vue'
          ),
      );
    case 'baseline_project_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-project-grid-view/baseline-project-grid-view.vue'
          ),
      );
    case 'insight_kanban_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight/insight-kanban-grid-view/insight-kanban-grid-view.vue'
          ),
      );
    case 'discuss_post_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-post/discuss-post-tree-exp-view/discuss-post-tree-exp-view.vue'
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
    case 'baseline_product_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-product-tree-exp-view/baseline-product-tree-exp-view.vue'
          ),
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
    case 'user_account_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './user/user-account-tab-exp-view/user-account-tab-exp-view.vue'
          ),
      );
    case 'test_case_not_add_pick_up_grid_view_review':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-not-add-pick-up-grid-view-review/test-case-not-add-pick-up-grid-view-review.vue'
          ),
      );
    case 'library_library_grid_parts':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-library-grid-parts/library-library-grid-parts.vue'
          ),
      );
    case 'ticket_drill_detail_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-drill-detail-grid-view/ticket-drill-detail-grid-view.vue'
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
    case 'baseline_library_update_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-library-update-view/baseline-library-update-view.vue'
          ),
      );
    case 'release_redirect_view':
      return defineAsyncComponent(
        () =>
          import('./release/release-redirect-view/release-redirect-view.vue'),
      );
    case 'relation_idea_re_idea_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-idea-re-idea-grid-view/relation-idea-re-idea-grid-view.vue'
          ),
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
    case 'insight_report_system_report_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-report/insight-report-system-report-grid-view/insight-report-system-report-grid-view.vue'
          ),
      );
    case 'login_log_active_members':
      return defineAsyncComponent(
        () =>
          import(
            './login-log/login-log-active-members/login-log-active-members.vue'
          ),
      );
    case 'discuss_post_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-post/discuss-post-all-grid-view/discuss-post-all-grid-view.vue'
          ),
      );
    case 'article_page_shared_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-shared-setting-view/article-page-shared-setting-view.vue'
          ),
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
    case 'dyna_dashboard_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './dyna-dashboard/dyna-dashboard-edit-view/dyna-dashboard-edit-view.vue'
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
    case 'workload_type_confirm_remove_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload-type/workload-type-confirm-remove-view/workload-type-confirm-remove-view.vue'
          ),
      );
    case 'workspace_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './workspace/workspace-tab-exp-view/workspace-tab-exp-view.vue'
          ),
      );
    case 'workload_type_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload-type/workload-type-quick-create-view/workload-type-quick-create-view.vue'
          ),
      );
    case 'discuss_topic_management_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-management-tab-exp-view/discuss-topic-management-tab-exp-view.vue'
          ),
      );
    case 'psdeformdesign_modal':
      return defineAsyncComponent(
        () =>
          import('./psde-form/psdeformdesign-modal/psdeformdesign-modal.vue'),
      );
    case 'review_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './review/review-test-case-grid-view/review-test-case-grid-view.vue'
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
    case 'baseline_library_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-library-tree-exp-view/baseline-library-tree-exp-view.vue'
          ),
      );
    case 'library_create_wizard_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-create-wizard-view/library-create-wizard-view.vue'
          ),
      );
    case 'discuss_topic_archived_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-archived-grid-view/discuss-topic-archived-grid-view.vue'
          ),
      );
    case 'test_case_global_setting_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-global-setting-tab-exp-view/test-case-global-setting-tab-exp-view.vue'
          ),
      );
    case 'baseline_project_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-project-create-view/baseline-project-create-view.vue'
          ),
      );
    case 'stage_quick_create_view':
      return defineAsyncComponent(
        () =>
          import('./stage/stage-quick-create-view/stage-quick-create-view.vue'),
      );
    case 'baseline_snapshot_management_gird_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-snapshot-management-gird-view/baseline-snapshot-management-gird-view.vue'
          ),
      );
    case 'insight_report_bi_report_panel_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-report/insight-report-bi-report-panel-view/insight-report-bi-report-panel-view.vue'
          ),
      );
    case 'portfolio_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-pick-up-grid-view/portfolio-pick-up-grid-view.vue'
          ),
      );
    case 'work_item_change_state_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-change-state-view/work-item-change-state-view.vue'
          ),
      );
    case 'relation_test_case_re_work_item_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-test-case-re-work-item-grid-view/relation-test-case-re-work-item-grid-view.vue'
          ),
      );
    case 'test_case_configuration_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-configuration-tab-exp-view/test-case-configuration-tab-exp-view.vue'
          ),
      );
    case 'review_my_reviewed_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './review/review-my-reviewed-grid-view/review-my-reviewed-grid-view.vue'
          ),
      );
    case 'dictionary_data_ticket_state_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './dictionary-data/dictionary-data-ticket-state-grid-view/dictionary-data-ticket-state-grid-view.vue'
          ),
      );
    case 'relation_work_item_re_test_case_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-work-item-re-test-case-list-view/relation-work-item-re-test-case-list-view.vue'
          ),
      );
    case 'work_item_main_view':
      return defineAsyncComponent(
        () => import('./work-item/work-item-main-view/work-item-main-view.vue'),
      );
    case 'management_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './management/management-setting-view/management-setting-view.vue'
          ),
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
    case 'discuss_reply_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-reply/discuss-reply-list-view/discuss-reply-list-view.vue'
          ),
      );
    case 'project_state_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-state/project-state-edit-view/project-state-edit-view.vue'
          ),
      );
    case 'test_plan_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-all-grid-view/test-plan-all-grid-view.vue'
          ),
      );
    case 'run_drill_detail_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './run/run-drill-detail-grid-view/run-drill-detail-grid-view.vue'
          ),
      );
    case 'article_page_copy_page_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-copy-page-option-view/article-page-copy-page-option-view.vue'
          ),
      );
    case 'work_item_copy_view':
      return defineAsyncComponent(
        () => import('./work-item/work-item-copy-view/work-item-copy-view.vue'),
      );
    case 'release_edit_view':
      return defineAsyncComponent(
        () => import('./release/release-edit-view/release-edit-view.vue'),
      );
    case 'review_my_attention_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './review/review-my-attention-grid-view/review-my-attention-grid-view.vue'
          ),
      );
    case 'work_item_version_comparison_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-version-comparison-view/work-item-version-comparison-view.vue'
          ),
      );
    case 'stencil_space_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './stencil/stencil-space-all-grid-view/stencil-space-all-grid-view.vue'
          ),
      );
    case 'article_page_move_page_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-move-page-option-view/article-page-move-page-option-view.vue'
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
    case 'customer_app_data_upload_view':
      return defineAsyncComponent(
        () =>
          import(
            './customer-app-data-upload-view/customer-app-data-upload-view.vue'
          ),
      );
    case 'project_redirect_view':
      return defineAsyncComponent(
        () =>
          import('./project/project-redirect-view/project-redirect-view.vue'),
      );
    case 'baseline_edit_snapshot_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-edit-snapshot-view/baseline-edit-snapshot-view.vue'
          ),
      );
    case 'project_hybrid_index_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-hybrid-index-view/project-hybrid-index-view.vue'
          ),
      );
    case 'product_deleted_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-deleted-grid-view/product-deleted-grid-view.vue'
          ),
      );
    case 'release_overview_base_view':
      return defineAsyncComponent(
        () =>
          import(
            './release/release-overview-base-view/release-overview-base-view.vue'
          ),
      );
    case 'review_main_view':
      return defineAsyncComponent(
        () => import('./review/review-main-view/review-main-view.vue'),
      );
    case 'ticket_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-quick-create-view/ticket-quick-create-view.vue'
          ),
      );
    case 'baseline_space_categories_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-space-categories-pick-up-tree-view/baseline-space-categories-pick-up-tree-view.vue'
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
    case 'work_item_wizard_detail_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-wizard-detail/work-item-wizard-detail-edit-view/work-item-wizard-detail-edit-view.vue'
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
    case 'work_item_wizard_detail_target_type_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-wizard-detail/work-item-wizard-detail-target-type-grid-view/work-item-wizard-detail-target-type-grid-view.vue'
          ),
      );
    case 'test_case_mpick_up_view2_review':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-mpick-up-view-2-review/test-case-mpick-up-view-2-review.vue'
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
    case 'psdelogiclogicdesign':
      return defineAsyncComponent(
        () =>
          import('./psde-logic/psdelogiclogicdesign/psdelogiclogicdesign.vue'),
      );
    case 'discuss_topic_org_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-org-grid-view/discuss-topic-org-grid-view.vue'
          ),
      );
    case 'test_plan_my_part_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-my-part-grid-view/test-plan-my-part-grid-view.vue'
          ),
      );
    case 'review_content_set_result_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './review-content/review-content-set-result-edit-view/review-content-set-result-edit-view.vue'
          ),
      );
    case 'user_account_view':
      return defineAsyncComponent(
        () => import('./user/user-account-view/user-account-view.vue'),
      );
    case 'sprint_catrgories_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import(
            './sprint/sprint-catrgories-pick-up-tree-view/sprint-catrgories-pick-up-tree-view.vue'
          ),
      );
    case 'ticket_filter_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-filter-grid-view/ticket-filter-grid-view.vue'
          ),
      );
    case 'ticket_my_assign_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-my-assign-grid-view/ticket-my-assign-grid-view.vue'
          ),
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
    case 'workload_day_link_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-day-link-grid-view/workload-day-link-grid-view.vue'
          ),
      );
    case 'dictionary_data_idea_state_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './dictionary-data/dictionary-data-idea-state-grid-view/dictionary-data-idea-state-grid-view.vue'
          ),
      );
    case 'workload_type_pick_up_tap_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload-type/workload-type-pick-up-tap-exp-view/workload-type-pick-up-tap-exp-view.vue'
          ),
      );
    case 'test_plan_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-pick-up-grid-view/test-plan-pick-up-grid-view.vue'
          ),
      );
    case 'insight_view_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-tab-exp-view/insight-view-tab-exp-view.vue'
          ),
      );
    case 'relation_ticket_re_idea_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-ticket-re-idea-grid-view/relation-ticket-re-idea-grid-view.vue'
          ),
      );
    case 'project_setting_view':
      return defineAsyncComponent(
        () => import('./project/project-setting-view/project-setting-view.vue'),
      );
    case 'ps_app_portlet_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './ps-app-portlet/ps-app-portlet-edit-view/ps-app-portlet-edit-view.vue'
          ),
      );
    case 'sprint_program_pickup_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './sprint/sprint-program-pickup-grid-view/sprint-program-pickup-grid-view.vue'
          ),
      );
    case 'version_edit_version_view':
      return defineAsyncComponent(
        () =>
          import(
            './version/version-edit-version-view/version-edit-version-view.vue'
          ),
      );
    case 'category_pick_up_view':
      return defineAsyncComponent(
        () =>
          import('./category/category-pick-up-view/category-pick-up-view.vue'),
      );
    case 'product_member_assigned_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-member/product-member-assigned-grid-view/product-member-assigned-grid-view.vue'
          ),
      );
    case 'article_page_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-redirect-view/article-page-redirect-view.vue'
          ),
      );
    case 'work_item_executors_edit_form':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-executors-edit-form/work-item-executors-edit-form.vue'
          ),
      );
    case 'article_page_help_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-help-tree-exp-view/article-page-help-tree-exp-view.vue'
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
    case 'work_item_dyna_srcum_tree_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-dyna-srcum-tree-grid-view/work-item-dyna-srcum-tree-grid-view.vue'
          ),
      );
    case 'comment_list_view_idea':
      return defineAsyncComponent(
        () =>
          import('./comment/comment-list-view-idea/comment-list-view-idea.vue'),
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
    case 'idea_baseline_mpick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-baseline-mpick-up-view/idea-baseline-mpick-up-view.vue'
          ),
      );
    case 'relation_idea_re_customer_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-idea-re-customer-list-view/relation-idea-re-customer-list-view.vue'
          ),
      );
    case 'idea_template_global_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea-template/idea-template-global-edit-view/idea-template-global-edit-view.vue'
          ),
      );
    case 'project_waring_custom_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-waring-custom-view/project-waring-custom-view.vue'
          ),
      );
    case 'idea_idea_grid_parts':
      return defineAsyncComponent(
        () => import('./idea/idea-idea-grid-parts/idea-idea-grid-parts.vue'),
      );
    case 'review_my_created_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './review/review-my-created-grid-view/review-my-created-grid-view.vue'
          ),
      );
    case 'baseline_work_item_realtion_version_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline-work-item/baseline-work-item-realtion-version-list-view/baseline-work-item-realtion-version-list-view.vue'
          ),
      );
    case 'release_pick_up_view':
      return defineAsyncComponent(
        () => import('./release/release-pick-up-view/release-pick-up-view.vue'),
      );
    case 'section_pick_up_view':
      return defineAsyncComponent(
        () => import('./section/section-pick-up-view/section-pick-up-view.vue'),
      );
    case 'portfolio_mpick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-mpick-up-view/portfolio-mpick-up-view.vue'
          ),
      );
    case 'product_member_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-member/product-member-redirect-view/product-member-redirect-view.vue'
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
    case 'idea_drill_detail_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-drill-detail-grid-view/idea-drill-detail-grid-view.vue'
          ),
      );
    case 'customer_main_view':
      return defineAsyncComponent(
        () => import('./customer/customer-main-view/customer-main-view.vue'),
      );
    case 'kan_ban_work_item_app_data_upload_view':
      return defineAsyncComponent(
        () =>
          import(
            './kan-ban-work-item-app-data-upload-view/kan-ban-work-item-app-data-upload-view.vue'
          ),
      );
    case 'member_shared_page_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './member/member-shared-page-list-view/member-shared-page-list-view.vue'
          ),
      );
    case 'ticket_tree_exp_view':
      return defineAsyncComponent(
        () => import('./ticket/ticket-tree-exp-view/ticket-tree-exp-view.vue'),
      );
    case 'relation_work_item_re_self_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-work-item-re-self-grid-view/relation-work-item-re-self-grid-view.vue'
          ),
      );
    case 'review_tree_exp_view':
      return defineAsyncComponent(
        () => import('./review/review-tree-exp-view/review-tree-exp-view.vue'),
      );
    case 'insight_library_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight/insight-library-grid-view/insight-library-grid-view.vue'
          ),
      );
    case 'insight_report_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-report/insight-report-quick-create-view/insight-report-quick-create-view.vue'
          ),
      );
    case 'work_item_baseline_mpick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-baseline-mpick-up-grid-view/work-item-baseline-mpick-up-grid-view.vue'
          ),
      );
    case 'addon_project_setting_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './addon/addon-project-setting-grid-view/addon-project-setting-grid-view.vue'
          ),
      );
    case 'idea_others_re_mpick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-others-re-mpick-up-grid-view/idea-others-re-mpick-up-grid-view.vue'
          ),
      );
    case 'discuss_post_my_reply_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-post/discuss-post-my-reply-grid-view/discuss-post-my-reply-grid-view.vue'
          ),
      );
    case 'version_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './version/version-quick-create-view/version-quick-create-view.vue'
          ),
      );
    case 'relation_test_case_re_work_item_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-test-case-re-work-item-list-view/relation-test-case-re-work-item-list-view.vue'
          ),
      );
    case 'test_case_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-pick-up-tree-view/test-case-pick-up-tree-view.vue'
          ),
      );
    case 'ticket_customer_re_ticket_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-customer-re-ticket-grid-view/ticket-customer-re-ticket-grid-view.vue'
          ),
      );
    case 'insight_view_org_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-org-grid-view/insight-view-org-grid-view.vue'
          ),
      );
    case 'recent_my_assignee_item_tap_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recent-my-assignee-item-tap-exp-view/recent-my-assignee-item-tap-exp-view.vue'
          ),
      );
    case 'psdelogictemplate_info_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psdelogictemplate-info-view/psdelogictemplate-info-view.vue'
          ),
      );
    case 'relation_idea_re_test_case_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-idea-re-test-case-list-view/relation-idea-re-test-case-list-view.vue'
          ),
      );
    case 'space_member_role_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './space-member/space-member-role-edit-view/space-member-role-edit-view.vue'
          ),
      );
    case 'sprint_pick_up_view':
      return defineAsyncComponent(
        () => import('./sprint/sprint-pick-up-view/sprint-pick-up-view.vue'),
      );
    case 'discuss_member_bind_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-member/discuss-member-bind-grid-view/discuss-member-bind-grid-view.vue'
          ),
      );
    case 'section_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './section/section-pick-up-grid-view/section-pick-up-grid-view.vue'
          ),
      );
    case 'ticket_redirect_view':
      return defineAsyncComponent(
        () => import('./ticket/ticket-redirect-view/ticket-redirect-view.vue'),
      );
    case 'psdelogicredirectview':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psdelogicredirectview/psdelogicredirectview.vue'
          ),
      );
    case 'psdelogicquick_create_view_auto_flow':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psdelogicquick-create-view-auto-flow/psdelogicquick-create-view-auto-flow.vue'
          ),
      );
    case 'attention_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './attention/attention-tab-exp-view/attention-tab-exp-view.vue'
          ),
      );
    case 'login_log_edit_view':
      return defineAsyncComponent(
        () => import('./login-log/login-log-edit-view/login-log-edit-view.vue'),
      );
    case 'project_notice_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-notice-edit-view/project-notice-edit-view.vue'
          ),
      );
    case 'psde_field_ticekt_extend_transmit_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-field/psde-field-ticekt-extend-transmit-grid-view/psde-field-ticekt-extend-transmit-grid-view.vue'
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
    case 'article_page_baseline_mpick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-baseline-mpick-up-view/article-page-baseline-mpick-up-view.vue'
          ),
      );
    case 'insight_report_all_report_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-report/insight-report-all-report-grid-view/insight-report-all-report-grid-view.vue'
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
    case 'work_item_wizard_detail_change_confirm_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-wizard-detail/work-item-wizard-detail-change-confirm-grid-view/work-item-wizard-detail-change-confirm-grid-view.vue'
          ),
      );
    case 'test_case_re_run_main_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-re-run-main-view/test-case-re-run-main-view.vue'
          ),
      );
    case 'addon_setting_grid_view':
      return defineAsyncComponent(
        () =>
          import('./addon/addon-setting-grid-view/addon-setting-grid-view.vue'),
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
    case 'idea_app_data_upload_view':
      return defineAsyncComponent(
        () =>
          import('./idea-app-data-upload-view/idea-app-data-upload-view.vue'),
      );
    case 'release_change_stage_view':
      return defineAsyncComponent(
        () =>
          import(
            './release/release-change-stage-view/release-change-stage-view.vue'
          ),
      );
    case 'baseline_page_relation_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline-page/baseline-page-relation-grid-view/baseline-page-relation-grid-view.vue'
          ),
      );
    case 'project_management_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-management-tab-exp-view/project-management-tab-exp-view.vue'
          ),
      );
    case 'relation_test_case_re_idea_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-test-case-re-idea-list-view/relation-test-case-re-idea-list-view.vue'
          ),
      );
    case 'work_item_type_global_setting_view_scrum':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-type/work-item-type-global-setting-view-scrum/work-item-type-global-setting-view-scrum.vue'
          ),
      );
    case 'baseline_create_plan_snapshot_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-create-plan-snapshot-view/baseline-create-plan-snapshot-view.vue'
          ),
      );
    case 'insight_report_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-report/insight-report-edit-view/insight-report-edit-view.vue'
          ),
      );
    case 'discuss_topic_is_deleted_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-is-deleted-grid-view/discuss-topic-is-deleted-grid-view.vue'
          ),
      );
    case 'review_content_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './review-content/review-content-list-view/review-content-list-view.vue'
          ),
      );
    case 'project_tag_project_tag_confirm_remove_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-tag/project-tag-project-tag-confirm-remove-view/project-tag-project-tag-confirm-remove-view.vue'
          ),
      );
    case 'work_item_change_assignee_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-change-assignee-view/work-item-change-assignee-view.vue'
          ),
      );
    case 'release_overview_dashboard_view':
      return defineAsyncComponent(
        () =>
          import(
            './release/release-overview-dashboard-view/release-overview-dashboard-view.vue'
          ),
      );
    case 'user_info_custom_view':
      return defineAsyncComponent(
        () => import('./user/user-info-custom-view/user-info-custom-view.vue'),
      );
    case 'discuss_post_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-post/discuss-post-quick-create-view/discuss-post-quick-create-view.vue'
          ),
      );
    case 'project_team_grid_view':
      return defineAsyncComponent(
        () =>
          import('./project/project-team-grid-view/project-team-grid-view.vue'),
      );
    case 'group_tree_exp_view':
      return defineAsyncComponent(
        () => import('./group/group-tree-exp-view/group-tree-exp-view.vue'),
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
    case 'insight_view_index_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-index-view/insight-view-index-view.vue'
          ),
      );
    case 'insight_view_custom_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-custom-view/insight-view-custom-view.vue'
          ),
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
    case 'user_invalid_grid_view':
      return defineAsyncComponent(
        () =>
          import('./user/user-invalid-grid-view/user-invalid-grid-view.vue'),
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
    case 'ps_sys_bi_cube_dimension_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './ps-sys-bi-cube-dimension/ps-sys-bi-cube-dimension-redirect-view/ps-sys-bi-cube-dimension-redirect-view.vue'
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
    case 'sprint_overview_dashboard_view':
      return defineAsyncComponent(
        () =>
          import(
            './sprint/sprint-overview-dashboard-view/sprint-overview-dashboard-view.vue'
          ),
      );
    case 'work_redirect_view':
      return defineAsyncComponent(
        () => import('./work/work-redirect-view/work-redirect-view.vue'),
      );
    case 'psde_logic_test_auto_rules_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psde-logic-test-auto-rules-edit-view/psde-logic-test-auto-rules-edit-view.vue'
          ),
      );
    case 'insight_member_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-member/insight-member-edit-view/insight-member-edit-view.vue'
          ),
      );
    case 'work_item_under_work_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-under-work-grid-view/work-item-under-work-grid-view.vue'
          ),
      );
    case 'addon_resource_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './addon-resource/addon-resource-quick-create-view/addon-resource-quick-create-view.vue'
          ),
      );
    case 'workload_type_pick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload-type/workload-type-pick-up-grid-view/workload-type-pick-up-grid-view.vue'
          ),
      );
    case 'product_idea_configuration_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-idea-configuration-view/product-idea-configuration-view.vue'
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
    case 'work_item_sprint_contribution_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-sprint-contribution-grid-view/work-item-sprint-contribution-grid-view.vue'
          ),
      );
    case 'relation_idea_re_self_list_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-idea-re-self-list-view/relation-idea-re-self-list-view.vue'
          ),
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
    case 'stencil_edit_view':
      return defineAsyncComponent(
        () => import('./stencil/stencil-edit-view/stencil-edit-view.vue'),
      );
    case 'scrum_work_item_app_data_upload_view':
      return defineAsyncComponent(
        () =>
          import(
            './scrum-work-item-app-data-upload-view/scrum-work-item-app-data-upload-view.vue'
          ),
      );
    case 'library_member_assigned_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './library-member/library-member-assigned-grid-view/library-member-assigned-grid-view.vue'
          ),
      );
    case 'review_content_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './review-content/review-content-redirect-view/review-content-redirect-view.vue'
          ),
      );
    case 'release_program_pickup_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './release/release-program-pickup-grid-view/release-program-pickup-grid-view.vue'
          ),
      );
    case 'product_plan_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-plan/product-plan-tree-exp-view/product-plan-tree-exp-view.vue'
          ),
      );
    case 'discuss_topic_base_information_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-base-information-edit-view/discuss-topic-base-information-edit-view.vue'
          ),
      );
    case 'idea_template_pick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea-template/idea-template-pick-up-tree-view/idea-template-pick-up-tree-view.vue'
          ),
      );
    case 'workload_management_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-management-view/workload-management-view.vue'
          ),
      );
    case 'relation_edit_view':
      return defineAsyncComponent(
        () => import('./relation/relation-edit-view/relation-edit-view.vue'),
      );
    case 'work_item_calendar_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-calendar-view/work-item-calendar-view.vue'
          ),
      );
    case 'discuss_topic_advanced_setting_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-advanced-setting-edit-view/discuss-topic-advanced-setting-edit-view.vue'
          ),
      );
    case 'relation_work_item_re_ticket_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-work-item-re-ticket-grid-view/relation-work-item-re-ticket-grid-view.vue'
          ),
      );
    case 'ticket_global_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticket-global-setting-view/ticket-global-setting-view.vue'
          ),
      );
    case 'deliverable_target_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './deliverable/deliverable-target-grid-view/deliverable-target-grid-view.vue'
          ),
      );
    case 'product_member_role_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-member/product-member-role-edit-view/product-member-role-edit-view.vue'
          ),
      );
    case 'test_plan_drill_detail_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-drill-detail-grid-view/test-plan-drill-detail-grid-view.vue'
          ),
      );
    case 'work_item_program_pickup_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-program-pickup-grid-view/work-item-program-pickup-grid-view.vue'
          ),
      );
    case 'test_case_filter_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-filter-grid-view/test-case-filter-grid-view.vue'
          ),
      );
    case 'work_item_gantt_view':
      return defineAsyncComponent(
        () =>
          import('./work-item/work-item-gantt-view/work-item-gantt-view.vue'),
      );
    case 'project_global_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-global-setting-view/project-global-setting-view.vue'
          ),
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
    case 'space_advanced_setting_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/space-advanced-setting-edit-view/space-advanced-setting-edit-view.vue'
          ),
      );
    case 'product_setting_view':
      return defineAsyncComponent(
        () => import('./product/product-setting-view/product-setting-view.vue'),
      );
    case 'discuss_topic_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-topic/discuss-topic-edit-view/discuss-topic-edit-view.vue'
          ),
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
    case 'insight_view_show_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-view/insight-view-show-edit-view/insight-view-show-edit-view.vue'
          ),
      );
    case 'stage_update_view':
      return defineAsyncComponent(
        () => import('./stage/stage-update-view/stage-update-view.vue'),
      );
    case 'work_item_resource_gantt_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-resource-gantt-view/work-item-resource-gantt-view.vue'
          ),
      );
    case 'test_plan_general_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-general-grid-view/test-plan-general-grid-view.vue'
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
    case 'work_item_type_global_setting_mixed':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-type/work-item-type-global-setting-mixed/work-item-type-global-setting-mixed.vue'
          ),
      );
    case 'discuss_post_discuss_post_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-post/discuss-post-discuss-post-grid-view/discuss-post-discuss-post-grid-view.vue'
          ),
      );
    case 'test_suite_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-suite/test-suite-quick-create-view/test-suite-quick-create-view.vue'
          ),
      );
    case 'discuss_member_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './discuss-member/discuss-member-redirect-view/discuss-member-redirect-view.vue'
          ),
      );
    case 'product_idea_configuration_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-idea-configuration-tab-exp-view/product-idea-configuration-tab-exp-view.vue'
          ),
      );
    case 'idea_update_view':
      return defineAsyncComponent(
        () => import('./idea/idea-update-view/idea-update-view.vue'),
      );
    case 'test_case_baseline_mpick_up_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-baseline-mpick-up-grid-view/test-case-baseline-mpick-up-grid-view.vue'
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
    case 'review_set_category_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './review/review-set-category-option-view/review-set-category-option-view.vue'
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
    case 'article_page_shared_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-shared-grid-view/article-page-shared-grid-view.vue'
          ),
      );
    case 'test_case_global_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-global-setting-view/test-case-global-setting-view.vue'
          ),
      );
    case 'article_page_help_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-help-view/article-page-help-view.vue'
          ),
      );
    case 'relation_ticket_re_self_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-ticket-re-self-grid-view/relation-ticket-re-self-grid-view.vue'
          ),
      );
    case 'customer_add_category_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './customer/customer-add-category-option-view/customer-add-category-option-view.vue'
          ),
      );
    case 'test_case_drill_detail_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-drill-detail-grid-view/test-case-drill-detail-grid-view.vue'
          ),
      );
    case 'idea_global_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idea-global-setting-view/idea-global-setting-view.vue'
          ),
      );
    case 'insight_member_role_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './insight-member/insight-member-role-edit-view/insight-member-role-edit-view.vue'
          ),
      );
    case 'relation_run_re_bug_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './relation/relation-run-re-bug-grid-view/relation-run-re-bug-grid-view.vue'
          ),
      );
    case 'article_page_filter_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-filter-grid-view/article-page-filter-grid-view.vue'
          ),
      );
    case 'recent_custom_dashboard_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recent-custom-dashboard-view/recent-custom-dashboard-view.vue'
          ),
      );
    case 'review_stage_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './review-stage/review-stage-edit-view/review-stage-edit-view.vue'
          ),
      );
    case 'product_plan_edit_option_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-plan/product-plan-edit-option-view/product-plan-edit-option-view.vue'
          ),
      );
    case 'baseline_project_main_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline/baseline-project-main-view/baseline-project-main-view.vue'
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
    case 'baseline_page_comparison_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './baseline-page/baseline-page-comparison-grid-view/baseline-page-comparison-grid-view.vue'
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
    case 'search_attachment_cur_project_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './search-attachment/search-attachment-cur-project-grid-view/search-attachment-cur-project-grid-view.vue'
          ),
      );
    case 'ticket_type_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket-type/ticket-type-quick-create-view/ticket-type-quick-create-view.vue'
          ),
      );
    case 'article_page_updated_logs':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-updated-logs/article-page-updated-logs.vue'
          ),
      );
    case 'deliverable_target_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './deliverable/deliverable-target-edit-view/deliverable-target-edit-view.vue'
          ),
      );
    case 'dictionary_data_global_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './dictionary-data/dictionary-data-global-tab-exp-view/dictionary-data-global-tab-exp-view.vue'
          ),
      );
    case 'work_item_sprint_work_item_custom_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-sprint-work-item-custom-view/work-item-sprint-work-item-custom-view.vue'
          ),
      );
    case 'release_main_view':
      return defineAsyncComponent(
        () => import('./release/release-main-view/release-main-view.vue'),
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
    case 'test_plan_sprint_relation_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-sprint-relation-grid-view/test-plan-sprint-relation-grid-view.vue'
          ),
      );
    case 'addon_resource_all_capacity_view':
      return defineAsyncComponent(
        () =>
          import(
            './addon-resource/addon-resource-all-capacity-view/addon-resource-all-capacity-view.vue'
          ),
      );
    case 'article_page_shared_with_me_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-shared-with-me-grid-view/article-page-shared-with-me-grid-view.vue'
          ),
      );
    case 'workload_day_link_management_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-day-link-management-grid-view/workload-day-link-management-grid-view.vue'
          ),
      );
    case 'product_member_config_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-member/product-member-config-grid-view/product-member-config-grid-view.vue'
          ),
      );
    case 'ps_sys_bi_cube_dimension_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ps-sys-bi-cube-dimension/ps-sys-bi-cube-dimension-all-grid-view/ps-sys-bi-cube-dimension-all-grid-view.vue'
          ),
      );
    case 'psde_field_global_ticket_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-field/psde-field-global-ticket-grid-view/psde-field-global-ticket-grid-view.vue'
          ),
      );
    case 'ps_sys_bi_cube_measure_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './ps-sys-bi-cube-measure/ps-sys-bi-cube-measure-edit-view/ps-sys-bi-cube-measure-edit-view.vue'
          ),
      );
    case 'dictionary_data_quick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './dictionary-data/dictionary-data-quick-create-view/dictionary-data-quick-create-view.vue'
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
    case 'project_state_redirect_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-state/project-state-redirect-view/project-state-redirect-view.vue'
          ),
      );
    case 'work_item_workload_detail_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-workload-detail-grid-view/work-item-workload-detail-grid-view.vue'
          ),
      );
    case 'waterfall_work_item_app_data_upload_view':
      return defineAsyncComponent(
        () =>
          import(
            './waterfall-work-item-app-data-upload-view/waterfall-work-item-app-data-upload-view.vue'
          ),
      );
    default:
      throw new Error(`无法找到视图模型：${name}`);
  }
}
