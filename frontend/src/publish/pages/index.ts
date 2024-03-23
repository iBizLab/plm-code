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
    case 'boardpickupgridview':
      return defineAsyncComponent(
        () =>
          import('./board/board-pickup-grid-view/board-pickup-grid-view.vue'),
      );
    case 'ideaothers_re_view_pickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './idea/ideaothers-re-view-pickup-grid-view/ideaothers-re-view-pickup-grid-view.vue'
          ),
      );
    case 'work_itemtab_exp_view_test':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemtab-exp-view-test/work-itemtab-exp-view-test.vue'
          ),
      );
    case 'portfoliompickupview':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-m-pickup-view/portfolio-m-pickup-view.vue'
          ),
      );
    case 'usertree_exp_view':
      return defineAsyncComponent(
        () => import('./user/usertree-exp-view/usertree-exp-view.vue'),
      );
    case 'sprintmain_view':
      return defineAsyncComponent(
        () => import('./sprint/sprintmain-view/sprintmain-view.vue'),
      );
    case 'work_itemcase_re_bug_mpickup_view_pickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemcase-re-bug-mpickup-view-pickup-grid-view/work-itemcase-re-bug-mpickup-view-pickup-grid-view.vue'
          ),
      );
    case 'flow_tab_exp_view':
      return defineAsyncComponent(
        () => import('./psde-logic/flow-tab-exp-view/flow-tab-exp-view.vue'),
      );
    case 'sprintupdate_view':
      return defineAsyncComponent(
        () => import('./sprint/sprintupdate-view/sprintupdate-view.vue'),
      );
    case 'test_casecase_move_plan_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-casecase-move-plan-view/test-casecase-move-plan-view.vue'
          ),
      );
    case 'work_itemparent_pick_up_view_pickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemparent-pick-up-view-pickup-grid-view/work-itemparent-pick-up-view-pickup-grid-view.vue'
          ),
      );
    case 'ideaothers_re_idea_view':
      return defineAsyncComponent(
        () =>
          import('./idea/ideaothers-re-idea-view/ideaothers-re-idea-view.vue'),
      );
    case 'boardpickupview':
      return defineAsyncComponent(
        () => import('./board/board-pickup-view/board-pickup-view.vue'),
      );
    case 'test_caserecycle_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-caserecycle-grid-view/test-caserecycle-grid-view.vue'
          ),
      );
    case 'projecttab_exp_view_management':
      return defineAsyncComponent(
        () =>
          import(
            './project/projecttab-exp-view-management/projecttab-exp-view-management.vue'
          ),
      );
    case 'test_casework_item_re_case_gridview':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-casework-item-re-case-gridview/test-casework-item-re-case-gridview.vue'
          ),
      );
    case 'recentmy_assignee_item_tap_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recentmy-assignee-item-tap-exp-view/recentmy-assignee-item-tap-exp-view.vue'
          ),
      );
    case 'work_itemidea_tree_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemidea-tree-grid-view/work-itemidea-tree-grid-view.vue'
          ),
      );
    case 'ticketgrid_view_archived':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticketgrid-view-archived/ticketgrid-view-archived.vue'
          ),
      );
    case 'product_taggridview':
      return defineAsyncComponent(
        () =>
          import(
            './product-tag/product-tag-grid-view/product-tag-grid-view.vue'
          ),
      );
    case 'portfolioredirectview':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-redirect-view/portfolio-redirect-view.vue'
          ),
      );
    case 'librarytree_exp_view':
      return defineAsyncComponent(
        () => import('./library/librarytree-exp-view/librarytree-exp-view.vue'),
      );
    case 'work_itemredirectview':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-redirect-view/work-item-redirect-view.vue'
          ),
      );
    case 'work_itemrun_re_work_item_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemrun-re-work-item-grid-view/work-itemrun-re-work-item-grid-view.vue'
          ),
      );
    case 'space_membereditview':
      return defineAsyncComponent(
        () =>
          import(
            './space-member/space-member-edit-view/space-member-edit-view.vue'
          ),
      );
    case 'insightgrid_view':
      return defineAsyncComponent(
        () => import('./insight/insightgrid-view/insightgrid-view.vue'),
      );
    case 'recentrecent_page_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recentrecent-page-grid-view/recentrecent-page-grid-view.vue'
          ),
      );
    case 'ticketgrid_view_progress':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticketgrid-view-progress/ticketgrid-view-progress.vue'
          ),
      );
    case 'ideacreate_re_idea_view':
      return defineAsyncComponent(
        () =>
          import('./idea/ideacreate-re-idea-view/ideacreate-re-idea-view.vue'),
      );
    case 'libraryedit_view_base_info':
      return defineAsyncComponent(
        () =>
          import(
            './library/libraryedit-view-base-info/libraryedit-view-base-info.vue'
          ),
      );
    case 'projectoverview_view':
      return defineAsyncComponent(
        () => import('./project/projectoverview-view/projectoverview-view.vue'),
      );
    case 'runredirectview':
      return defineAsyncComponent(
        () => import('./run/run-redirect-view/run-redirect-view.vue'),
      );
    case 'test_plantree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plantree-exp-view/test-plantree-exp-view.vue'
          ),
      );
    case 'work_itemidea_re_work_item_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemidea-re-work-item-grid-view/work-itemidea-re-work-item-grid-view.vue'
          ),
      );
    case 'ideamy_assign_grid_view':
      return defineAsyncComponent(
        () =>
          import('./idea/ideamy-assign-grid-view/ideamy-assign-grid-view.vue'),
      );
    case 'projectpickupview':
      return defineAsyncComponent(
        () => import('./project/project-pickup-view/project-pickup-view.vue'),
      );
    case 'project_membergrid_view_assigned':
      return defineAsyncComponent(
        () =>
          import(
            './project-member/project-membergrid-view-assigned/project-membergrid-view-assigned.vue'
          ),
      );
    case 'test_planquick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-planquick-create-view/test-planquick-create-view.vue'
          ),
      );
    case 'work_itemre_self_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemre-self-grid-view/work-itemre-self-grid-view.vue'
          ),
      );
    case 'work_itemchange_state_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemchange-state-view/work-itemchange-state-view.vue'
          ),
      );
    case 'customeridea_re_customer_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './customer/customeridea-re-customer-grid-view/customeridea-re-customer-grid-view.vue'
          ),
      );
    case 'projectquick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/projectquick-create-view/projectquick-create-view.vue'
          ),
      );
    case 'stenciledit_view_show':
      return defineAsyncComponent(
        () =>
          import('./stencil/stenciledit-view-show/stenciledit-view-show.vue'),
      );
    case 'projectsetting_tab_view_scrum_flow':
      return defineAsyncComponent(
        () =>
          import(
            './project/projectsetting-tab-view-scrum-flow/projectsetting-tab-view-scrum-flow.vue'
          ),
      );
    case 'psdenotifyeditview':
      return defineAsyncComponent(
        () =>
          import(
            './psde-notify/psde-notify-edit-view/psde-notify-edit-view.vue'
          ),
      );
    case 'userm_pick_up_view2':
      return defineAsyncComponent(
        () => import('./user/userm-pick-up-view-2/userm-pick-up-view-2.vue'),
      );
    case 'article_pageloglistview':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-log-list-view/article-page-log-list-view.vue'
          ),
      );
    case 'producttree_exp_view':
      return defineAsyncComponent(
        () => import('./product/producttree-exp-view/producttree-exp-view.vue'),
      );
    case 'spacepick_up_tree_view':
      return defineAsyncComponent(
        () =>
          import('./space/spacepick-up-tree-view/spacepick-up-tree-view.vue'),
      );
    case 'spacecategory_tree__exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/spacecategory-tree-exp-view/spacecategory-tree-exp-view.vue'
          ),
      );
    case 'ticketgrid_view_all':
      return defineAsyncComponent(
        () => import('./ticket/ticketgrid-view-all/ticketgrid-view-all.vue'),
      );
    case 'test_casepickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-pickup-grid-view/test-case-pickup-grid-view.vue'
          ),
      );
    case 'work_itemrecycle_bin_grid_iew':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemrecycle-bin-grid-iew/work-itemrecycle-bin-grid-iew.vue'
          ),
      );
    case 'libraryindex_view':
      return defineAsyncComponent(
        () => import('./library/libraryindex-view/libraryindex-view.vue'),
      );
    case 'work_itemquick_create_view_bug':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemquick-create-view-bug/work-itemquick-create-view-bug.vue'
          ),
      );
    case 'test_casenosuite_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-casenosuite-test-case-grid-view/test-casenosuite-test-case-grid-view.vue'
          ),
      );
    case 'library_membergrid_view_config':
      return defineAsyncComponent(
        () =>
          import(
            './library-member/library-membergrid-view-config/library-membergrid-view-config.vue'
          ),
      );
    case 'test_casemy_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-casemy-test-case-grid-view/test-casemy-test-case-grid-view.vue'
          ),
      );
    case 'product_membergrid_view_config':
      return defineAsyncComponent(
        () =>
          import(
            './product-member/product-membergrid-view-config/product-membergrid-view-config.vue'
          ),
      );
    case 'work_item_stategridview':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-state/work-item-state-grid-view/work-item-state-grid-view.vue'
          ),
      );
    case 'spacetab_exp_view':
      return defineAsyncComponent(
        () => import('./space/spacetab-exp-view/spacetab-exp-view.vue'),
      );
    case 'insightredirect_view':
      return defineAsyncComponent(
        () => import('./insight/insightredirect-view/insightredirect-view.vue'),
      );
    case 'workredirectview':
      return defineAsyncComponent(
        () => import('./work/work-redirect-view/work-redirect-view.vue'),
      );
    case 'article_pageshow_view_model':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-pageshow-view-model/article-pageshow-view-model.vue'
          ),
      );
    case 'projecteditview':
      return defineAsyncComponent(
        () => import('./project/project-edit-view/project-edit-view.vue'),
      );
    case 'workload_typepickupview':
      return defineAsyncComponent(
        () =>
          import(
            './workload-type/workload-type-pickup-view/workload-type-pickup-view.vue'
          ),
      );
    case 'test_casenot_add_pickup_grid':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-casenot-add-pickup-grid/test-casenot-add-pickup-grid.vue'
          ),
      );
    case 'project_membereditview':
      return defineAsyncComponent(
        () =>
          import(
            './project-member/project-member-edit-view/project-member-edit-view.vue'
          ),
      );
    case 'projectgrid_view_management_deleted':
      return defineAsyncComponent(
        () =>
          import(
            './project/projectgrid-view-management-deleted/projectgrid-view-management-deleted.vue'
          ),
      );
    case 'customerpickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './customer/customer-pickup-grid-view/customer-pickup-grid-view.vue'
          ),
      );
    case 'sprintpick_up_view_pickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './sprint/sprintpick-up-view-pickup-grid-view/sprintpick-up-view-pickup-grid-view.vue'
          ),
      );
    case 'library_memberredirectview':
      return defineAsyncComponent(
        () =>
          import(
            './library-member/library-member-redirect-view/library-member-redirect-view.vue'
          ),
      );
    case 'spaceis_deleted_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/spaceis-deleted-grid-view/spaceis-deleted-grid-view.vue'
          ),
      );
    case 'test_casemy_craeted_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-casemy-craeted-grid-view/test-casemy-craeted-grid-view.vue'
          ),
      );
    case 'recenttab_exp_view':
      return defineAsyncComponent(
        () => import('./recent/recenttab-exp-view/recenttab-exp-view.vue'),
      );
    case 'work_itemgrid_view_bug_scrum':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemgrid-view-bug-scrum/work-itemgrid-view-bug-scrum.vue'
          ),
      );
    case 'project_membergrid_view_config':
      return defineAsyncComponent(
        () =>
          import(
            './project-member/project-membergrid-view-config/project-membergrid-view-config.vue'
          ),
      );
    case 'recentmy_created_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recentmy-created-tab-exp-view/recentmy-created-tab-exp-view.vue'
          ),
      );
    case 'test_caseidea_re_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-caseidea-re-test-case-grid-view/test-caseidea-re-test-case-grid-view.vue'
          ),
      );
    case 'portfolioproject_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolioproject-grid-view/portfolioproject-grid-view.vue'
          ),
      );
    case 'stencilspace_all_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './stencil/stencilspace-all-grid-view/stencilspace-all-grid-view.vue'
          ),
      );
    case 'workloadeditview':
      return defineAsyncComponent(
        () => import('./workload/workload-edit-view/workload-edit-view.vue'),
      );
    case 'work_itemeditview':
      return defineAsyncComponent(
        () => import('./work-item/work-item-edit-view/work-item-edit-view.vue'),
      );
    case 'work_itemkanban_view':
      return defineAsyncComponent(
        () =>
          import('./work-item/work-itemkanban-view/work-itemkanban-view.vue'),
      );
    case 'producttree_exp_view_config':
      return defineAsyncComponent(
        () =>
          import(
            './product/producttree-exp-view-config/producttree-exp-view-config.vue'
          ),
      );
    case 'ideaidea_re_plan_view':
      return defineAsyncComponent(
        () => import('./idea/ideaidea-re-plan-view/ideaidea-re-plan-view.vue'),
      );
    case 'project_taggrid_view_tag':
      return defineAsyncComponent(
        () =>
          import(
            './project-tag/project-taggrid-view-tag/project-taggrid-view-tag.vue'
          ),
      );
    case 'work_item_typeeditview':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-type/work-item-type-edit-view/work-item-type-edit-view.vue'
          ),
      );
    case 'spaceedit_view_base_info':
      return defineAsyncComponent(
        () =>
          import(
            './space/spaceedit-view-base-info/spaceedit-view-base-info.vue'
          ),
      );
    case 'test_suitetree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-suite/test-suitetree-exp-view/test-suitetree-exp-view.vue'
          ),
      );
    case 'work_itemcase_re_bug_mpickup_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemcase-re-bug-mpickup-view/work-itemcase-re-bug-mpickup-view.vue'
          ),
      );
    case 'spaceeditview':
      return defineAsyncComponent(
        () => import('./space/space-edit-view/space-edit-view.vue'),
      );
    case 'spaceindex_view':
      return defineAsyncComponent(
        () => import('./space/spaceindex-view/spaceindex-view.vue'),
      );
    case 'deliverabletarget_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './deliverable/deliverabletarget-grid-view/deliverabletarget-grid-view.vue'
          ),
      );
    case 'psdelogiclogicdesign':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psde-logic-logic-design/psde-logic-logic-design.vue'
          ),
      );
    case 'spaceproduct_choose_re_space':
      return defineAsyncComponent(
        () =>
          import(
            './space/spaceproduct-choose-re-space/spaceproduct-choose-re-space.vue'
          ),
      );
    case 'productrecover_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/productrecover-tab-exp-view/productrecover-tab-exp-view.vue'
          ),
      );
    case 'releasepickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './release/release-pickup-grid-view/release-pickup-grid-view.vue'
          ),
      );
    case 'portfolio_membereditview':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio-member/portfolio-member-edit-view/portfolio-member-edit-view.vue'
          ),
      );
    case 'recentcustom_dashboard_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recentcustom-dashboard-view/recentcustom-dashboard-view.vue'
          ),
      );
    case 'work_itemplan_work_item_pickview_pickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemplan-work-item-pickview-pickup-grid-view/work-itemplan-work-item-pickview-pickup-grid-view.vue'
          ),
      );
    case 'portfolio_memberredirectview':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio-member/portfolio-member-redirect-view/portfolio-member-redirect-view.vue'
          ),
      );
    case 'ideapickuptreeview':
      return defineAsyncComponent(
        () => import('./idea/idea-pickup-tree-view/idea-pickup-tree-view.vue'),
      );
    case 'ideatree_exp_view':
      return defineAsyncComponent(
        () => import('./idea/ideatree-exp-view/ideatree-exp-view.vue'),
      );
    case 'tickettag_choose_view':
      return defineAsyncComponent(
        () =>
          import('./ticket/tickettag-choose-view/tickettag-choose-view.vue'),
      );
    case 'ticketmy_created_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticketmy-created-grid-view/ticketmy-created-grid-view.vue'
          ),
      );
    case 'work_itemrun_re_work_item_bug_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemrun-re-work-item-bug-grid-view/work-itemrun-re-work-item-bug-grid-view.vue'
          ),
      );
    case 'customerquick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './customer/customerquick-create-view/customerquick-create-view.vue'
          ),
      );
    case 'producteditview':
      return defineAsyncComponent(
        () => import('./product/product-edit-view/product-edit-view.vue'),
      );
    case 'stenciledit_view':
      return defineAsyncComponent(
        () => import('./stencil/stenciledit-view/stenciledit-view.vue'),
      );
    case 'productedit_view_advanced_setting':
      return defineAsyncComponent(
        () =>
          import(
            './product/productedit-view-advanced-setting/productedit-view-advanced-setting.vue'
          ),
      );
    case 'work_itemmy_attention_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemmy-attention-grid-view/work-itemmy-attention-grid-view.vue'
          ),
      );
    case 'test_casemain_view':
      return defineAsyncComponent(
        () => import('./test-case/test-casemain-view/test-casemain-view.vue'),
      );
    case 'idearecycle_bin_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idearecycle-bin-grid-view/idearecycle-bin-grid-view.vue'
          ),
      );
    case 'libraryshow_edit_view':
      return defineAsyncComponent(
        () =>
          import('./library/libraryshow-edit-view/libraryshow-edit-view.vue'),
      );
    case 'librarypickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './library/library-pickup-grid-view/library-pickup-grid-view.vue'
          ),
      );
    case 'recentrecent_test_case_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recentrecent-test-case-grid-view/recentrecent-test-case-grid-view.vue'
          ),
      );
    case 'producttab_exp_view_management':
      return defineAsyncComponent(
        () =>
          import(
            './product/producttab-exp-view-management/producttab-exp-view-management.vue'
          ),
      );
    case 'releasepickupview':
      return defineAsyncComponent(
        () => import('./release/release-pickup-view/release-pickup-view.vue'),
      );
    case 'work_itempickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-item-pickup-grid-view/work-item-pickup-grid-view.vue'
          ),
      );
    case 'work_itemmain_view_dyna':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemmain-view-dyna/work-itemmain-view-dyna.vue'
          ),
      );
    case 'deliverablequick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './deliverable/deliverablequick-create-view/deliverablequick-create-view.vue'
          ),
      );
    case 'test_suitepickupview':
      return defineAsyncComponent(
        () =>
          import(
            './test-suite/test-suite-pickup-view/test-suite-pickup-view.vue'
          ),
      );
    case 'workloadcalendar_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workloadcalendar-grid-view/workloadcalendar-grid-view.vue'
          ),
      );
    case 'article_pagerecycle_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-pagerecycle-grid-view/article-pagerecycle-grid-view.vue'
          ),
      );
    case 'space_memberredirectview':
      return defineAsyncComponent(
        () =>
          import(
            './space-member/space-member-redirect-view/space-member-redirect-view.vue'
          ),
      );
    case 'ideaeditview':
      return defineAsyncComponent(
        () => import('./idea/idea-edit-view/idea-edit-view.vue'),
      );
    case 'project_tagoption_view_new':
      return defineAsyncComponent(
        () =>
          import(
            './project-tag/project-tagoption-view-new/project-tagoption-view-new.vue'
          ),
      );
    case 'rungrid_view_all':
      return defineAsyncComponent(
        () => import('./run/rungrid-view-all/rungrid-view-all.vue'),
      );
    case 'librarygrid_view_all':
      return defineAsyncComponent(
        () => import('./library/librarygrid-view-all/librarygrid-view-all.vue'),
      );
    case 'space_membergrid_view_assigned':
      return defineAsyncComponent(
        () =>
          import(
            './space-member/space-membergrid-view-assigned/space-membergrid-view-assigned.vue'
          ),
      );
    case 'projectmain_data_waterfall':
      return defineAsyncComponent(
        () =>
          import(
            './project/projectmain-data-waterfall/projectmain-data-waterfall.vue'
          ),
      );
    case 'productgrid_view_management_in_progress':
      return defineAsyncComponent(
        () =>
          import(
            './product/productgrid-view-management-in-progress/productgrid-view-management-in-progress.vue'
          ),
      );
    case 'test_suitepickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './test-suite/test-suite-pickup-grid-view/test-suite-pickup-grid-view.vue'
          ),
      );
    case 'work_itemgrid_view_all_kanban':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemgrid-view-all-kanban/work-itemgrid-view-all-kanban.vue'
          ),
      );
    case 'spaceis_archived_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/spaceis-archived-grid-view/spaceis-archived-grid-view.vue'
          ),
      );
    case 'spacepickupgridview':
      return defineAsyncComponent(
        () =>
          import('./space/space-pickup-grid-view/space-pickup-grid-view.vue'),
      );
    case 'deliverablegrid_view':
      return defineAsyncComponent(
        () =>
          import('./deliverable/deliverablegrid-view/deliverablegrid-view.vue'),
      );
    case 'userpickupgridview':
      return defineAsyncComponent(
        () => import('./user/user-pickup-grid-view/user-pickup-grid-view.vue'),
      );
    case 'article_pagestatistical_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-pagestatistical-grid-view/article-pagestatistical-grid-view.vue'
          ),
      );
    case 'work_itemgrid_view_story_waterfall':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemgrid-view-story-waterfall/work-itemgrid-view-story-waterfall.vue'
          ),
      );
    case 'test_plangrid_view_in_progress':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plangrid-view-in-progress/test-plangrid-view-in-progress.vue'
          ),
      );
    case 'customerpickupview':
      return defineAsyncComponent(
        () =>
          import('./customer/customer-pickup-view/customer-pickup-view.vue'),
      );
    case 'customermain_view':
      return defineAsyncComponent(
        () => import('./customer/customermain-view/customermain-view.vue'),
      );
    case 'article_pagecreate_view_document':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-pagecreate-view-document/article-pagecreate-view-document.vue'
          ),
      );
    case 'spacegrid_view_all':
      return defineAsyncComponent(
        () => import('./space/spacegrid-view-all/spacegrid-view-all.vue'),
      );
    case 'product_planquick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-plan/product-planquick-create-view/product-planquick-create-view.vue'
          ),
      );
    case 'test_caseset_level':
      return defineAsyncComponent(
        () => import('./test-case/test-caseset-level/test-caseset-level.vue'),
      );
    case 'spacetree_exp_view':
      return defineAsyncComponent(
        () => import('./space/spacetree-exp-view/spacetree-exp-view.vue'),
      );
    case 'projectoverview_view_baseinfo':
      return defineAsyncComponent(
        () =>
          import(
            './project/projectoverview-view-baseinfo/projectoverview-view-baseinfo.vue'
          ),
      );
    case 'runupdate_run_status':
      return defineAsyncComponent(
        () => import('./run/runupdate-run-status/runupdate-run-status.vue'),
      );
    case 'article_pagemy_favorite_page_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-pagemy-favorite-page-grid-view/article-pagemy-favorite-page-grid-view.vue'
          ),
      );
    case 'activitiyhistorylistview':
      return defineAsyncComponent(
        () =>
          import(
            './activitiy/activitiy-history-list-view/activitiy-history-list-view.vue'
          ),
      );
    case 'product_tagoption_view_new':
      return defineAsyncComponent(
        () =>
          import(
            './product-tag/product-tagoption-view-new/product-tagoption-view-new.vue'
          ),
      );
    case 'product_tagoption_view_edit':
      return defineAsyncComponent(
        () =>
          import(
            './product-tag/product-tagoption-view-edit/product-tagoption-view-edit.vue'
          ),
      );
    case 'product_setting_view':
      return defineAsyncComponent(
        () => import('./product/product-setting-view/product-setting-view.vue'),
      );
    case 'product_plangrid_view_all':
      return defineAsyncComponent(
        () =>
          import(
            './product-plan/product-plangrid-view-all/product-plangrid-view-all.vue'
          ),
      );
    case 'tickettags_tciket_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/tickettags-tciket-grid-view/tickettags-tciket-grid-view.vue'
          ),
      );
    case 'psdefieldquick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-field/psde-fieldquick-create-view/psde-fieldquick-create-view.vue'
          ),
      );
    case 'test_casemy_attention_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-casemy-attention-grid-view/test-casemy-attention-grid-view.vue'
          ),
      );
    case 'work_item_stateedit_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-state/work-item-stateedit-view/work-item-stateedit-view.vue'
          ),
      );
    case 'work_itemparent_pick_up_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemparent-pick-up-view/work-itemparent-pick-up-view.vue'
          ),
      );
    case 'libraryedit_view_advanced_setting':
      return defineAsyncComponent(
        () =>
          import(
            './library/libraryedit-view-advanced-setting/libraryedit-view-advanced-setting.vue'
          ),
      );
    case 'projectmain_data_scrum':
      return defineAsyncComponent(
        () =>
          import('./project/projectmain-data-scrum/projectmain-data-scrum.vue'),
      );
    case 'userquick_cfg_view':
      return defineAsyncComponent(
        () => import('./user/userquick-cfg-view/userquick-cfg-view.vue'),
      );
    case 'usergrid_view':
      return defineAsyncComponent(
        () => import('./user/usergrid-view/usergrid-view.vue'),
      );
    case 'productgrid_view_management_archived':
      return defineAsyncComponent(
        () =>
          import(
            './product/productgrid-view-management-archived/productgrid-view-management-archived.vue'
          ),
      );
    case 'sprintconfirm_finish_view':
      return defineAsyncComponent(
        () =>
          import(
            './sprint/sprintconfirm-finish-view/sprintconfirm-finish-view.vue'
          ),
      );
    case 'work_itemglobal_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemglobal-setting-view/work-itemglobal-setting-view.vue'
          ),
      );
    case 'ideawork_item_re_idea_gridview':
      return defineAsyncComponent(
        () =>
          import(
            './idea/ideawork-item-re-idea-gridview/ideawork-item-re-idea-gridview.vue'
          ),
      );
    case 'project_tagoption_view':
      return defineAsyncComponent(
        () =>
          import(
            './project-tag/project-tagoption-view/project-tagoption-view.vue'
          ),
      );
    case 'workloadwork_item_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workloadwork-item-grid-view/workloadwork-item-grid-view.vue'
          ),
      );
    case 'projectshow_edit_view':
      return defineAsyncComponent(
        () =>
          import('./project/projectshow-edit-view/projectshow-edit-view.vue'),
      );
    case 'work_itemticket_re_work_item_gridview':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemticket-re-work-item-gridview/work-itemticket-re-work-item-gridview.vue'
          ),
      );
    case 'portfolioproject_set_advanced_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolioproject-set-advanced-view/portfolioproject-set-advanced-view.vue'
          ),
      );
    case 'template_flow_data_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/template-flow-data-view/template-flow-data-view.vue'
          ),
      );
    case 'test_casequick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-casequick-create-view/test-casequick-create-view.vue'
          ),
      );
    case 'work_itemmy_created_grid_view_index':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemmy-created-grid-view-index/work-itemmy-created-grid-view-index.vue'
          ),
      );
    case 'spaceis_running_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/spaceis-running-grid-view/spaceis-running-grid-view.vue'
          ),
      );
    case 'work_item_typegridview':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-type/work-item-type-grid-view/work-item-type-grid-view.vue'
          ),
      );
    case 'ideaidea_re_idea_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/ideaidea-re-idea-grid-view/ideaidea-re-idea-grid-view.vue'
          ),
      );
    case 'librarygrid_view_deleted':
      return defineAsyncComponent(
        () =>
          import(
            './library/librarygrid-view-deleted/librarygrid-view-deleted.vue'
          ),
      );
    case 'product_tageditview':
      return defineAsyncComponent(
        () =>
          import(
            './product-tag/product-tag-edit-view/product-tag-edit-view.vue'
          ),
      );
    case 'spacempickupview':
      return defineAsyncComponent(
        () => import('./space/space-m-pickup-view/space-m-pickup-view.vue'),
      );
    case 'test_plangrid_view_my_part':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plangrid-view-my-part/test-plangrid-view-my-part.vue'
          ),
      );
    case 'product_planupdate_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-plan/product-planupdate-view/product-planupdate-view.vue'
          ),
      );
    case 'runtree_exp_view':
      return defineAsyncComponent(
        () => import('./run/runtree-exp-view/runtree-exp-view.vue'),
      );
    case 'work_itemunder_work_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemunder-work-grid-view/work-itemunder-work-grid-view.vue'
          ),
      );
    case 'work_itemshift_in_kanban':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemshift-in-kanban/work-itemshift-in-kanban.vue'
          ),
      );
    case 'productmain_view':
      return defineAsyncComponent(
        () => import('./product/productmain-view/productmain-view.vue'),
      );
    case 'work_itemmy_gird_view':
      return defineAsyncComponent(
        () =>
          import('./work-item/work-itemmy-gird-view/work-itemmy-gird-view.vue'),
      );
    case 'ticketmy_attention_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticketmy-attention-grid-view/ticketmy-attention-grid-view.vue'
          ),
      );
    case 'test_casempickupview':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-m-pickup-view/test-case-m-pickup-view.vue'
          ),
      );
    case 'work_itemmain_view':
      return defineAsyncComponent(
        () => import('./work-item/work-itemmain-view/work-itemmain-view.vue'),
      );
    case 'article_pageshow_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-pageshow-view/article-pageshow-view.vue'
          ),
      );
    case 'work_item_statequick_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-state/work-item-statequick-edit-view/work-item-statequick-edit-view.vue'
          ),
      );
    case 'test_casemove_case_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-casemove-case-view/test-casemove-case-view.vue'
          ),
      );
    case 'workloadmanagement_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workloadmanagement-view/workloadmanagement-view.vue'
          ),
      );
    case 'ticketmy_assign_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticketmy-assign-grid-view/ticketmy-assign-grid-view.vue'
          ),
      );
    case 'librarytree_exp_view_details_setting':
      return defineAsyncComponent(
        () =>
          import(
            './library/librarytree-exp-view-details-setting/librarytree-exp-view-details-setting.vue'
          ),
      );
    case 'test_casegrid_view_all':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-casegrid-view-all/test-casegrid-view-all.vue'
          ),
      );
    case 'product_plantree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './product-plan/product-plantree-exp-view/product-plantree-exp-view.vue'
          ),
      );
    case 'psdelogicglobal_flow_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psde-logicglobal-flow-grid-view/psde-logicglobal-flow-grid-view.vue'
          ),
      );
    case 'work_itemgrid_view_all_scrum':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemgrid-view-all-scrum/work-itemgrid-view-all-scrum.vue'
          ),
      );
    case 'releasepick_up_view_pickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './release/releasepick-up-view-pickup-grid-view/releasepick-up-view-pickup-grid-view.vue'
          ),
      );
    case 'librarygrid_view_in_progress':
      return defineAsyncComponent(
        () =>
          import(
            './library/librarygrid-view-in-progress/librarygrid-view-in-progress.vue'
          ),
      );
    case 'product_taggrid_view_tag':
      return defineAsyncComponent(
        () =>
          import(
            './product-tag/product-taggrid-view-tag/product-taggrid-view-tag.vue'
          ),
      );
    case 'stencilall_grid_view':
      return defineAsyncComponent(
        () => import('./stencil/stencilall-grid-view/stencilall-grid-view.vue'),
      );
    case 'commentlist_view':
      return defineAsyncComponent(
        () => import('./comment/commentlist-view/commentlist-view.vue'),
      );
    case 'workload_typepickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './workload-type/workload-type-pickup-grid-view/workload-type-pickup-grid-view.vue'
          ),
      );
    case 'work_itemmain_view_bug':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemmain-view-bug/work-itemmain-view-bug.vue'
          ),
      );
    case 'portfolioproject_set_delete_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolioproject-set-delete-grid-view/portfolioproject-set-delete-grid-view.vue'
          ),
      );
    case 'spacegrid_view_category':
      return defineAsyncComponent(
        () =>
          import('./space/spacegrid-view-category/spacegrid-view-category.vue'),
      );
    case 'customertree_exp_view':
      return defineAsyncComponent(
        () =>
          import('./customer/customertree-exp-view/customertree-exp-view.vue'),
      );
    case 'spaceinfo_view':
      return defineAsyncComponent(
        () => import('./space/spaceinfo-view/spaceinfo-view.vue'),
      );
    case 'productpickupview':
      return defineAsyncComponent(
        () => import('./product/product-pickup-view/product-pickup-view.vue'),
      );
    case 'test_caseeditview':
      return defineAsyncComponent(
        () => import('./test-case/test-case-edit-view/test-case-edit-view.vue'),
      );
    case 'test_plangrid_view_project':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plangrid-view-project/test-plangrid-view-project.vue'
          ),
      );
    case 'work_itemwork_item_testdyna':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemwork-item-testdyna/work-itemwork-item-testdyna.vue'
          ),
      );
    case 'psdefieldgrid_view':
      return defineAsyncComponent(
        () =>
          import('./psde-field/psde-fieldgrid-view/psde-fieldgrid-view.vue'),
      );
    case 'article_pagetree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-pagetree-exp-view/article-pagetree-exp-view.vue'
          ),
      );
    case 'test_caseset_state_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-caseset-state-view/test-caseset-state-view.vue'
          ),
      );
    case 'work_itemgrid_view_milestone':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemgrid-view-milestone/work-itemgrid-view-milestone.vue'
          ),
      );
    case 'releasetree_exp_view':
      return defineAsyncComponent(
        () => import('./release/releasetree-exp-view/releasetree-exp-view.vue'),
      );
    case 'idearun_re_idea_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/idearun-re-idea-grid-view/idearun-re-idea-grid-view.vue'
          ),
      );
    case 'insightedit_view':
      return defineAsyncComponent(
        () => import('./insight/insightedit-view/insightedit-view.vue'),
      );
    case 'ideamain_view':
      return defineAsyncComponent(
        () => import('./idea/ideamain-view/ideamain-view.vue'),
      );
    case 'work_itemplan_work_item_pickview':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemplan-work-item-pickview/work-itemplan-work-item-pickview.vue'
          ),
      );
    case 'sprintpickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './sprint/sprint-pickup-grid-view/sprint-pickup-grid-view.vue'
          ),
      );
    case 'spaceadvanced_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/spaceadvanced-setting-view/spaceadvanced-setting-view.vue'
          ),
      );
    case 'portfolio_memberproject_bind_member_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio-member/portfolio-memberproject-bind-member-grid-view/portfolio-memberproject-bind-member-grid-view.vue'
          ),
      );
    case 'ideamain_view_plan':
      return defineAsyncComponent(
        () => import('./idea/ideamain-view-plan/ideamain-view-plan.vue'),
      );
    case 'recenttree_exp_view':
      return defineAsyncComponent(
        () => import('./recent/recenttree-exp-view/recenttree-exp-view.vue'),
      );
    case 'projecttree_exp_view':
      return defineAsyncComponent(
        () => import('./project/projecttree-exp-view/projecttree-exp-view.vue'),
      );
    case 'project_tagredirectview':
      return defineAsyncComponent(
        () =>
          import(
            './project-tag/project-tag-redirect-view/project-tag-redirect-view.vue'
          ),
      );
    case 'article_pagere_show_view':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-pagere-show-view/article-pagere-show-view.vue'
          ),
      );
    case 'productdetails_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/productdetails-setting-view/productdetails-setting-view.vue'
          ),
      );
    case 'ideamy_attention_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/ideamy-attention-grid-view/ideamy-attention-grid-view.vue'
          ),
      );
    case 'productpickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './product/product-pickup-grid-view/product-pickup-grid-view.vue'
          ),
      );
    case 'productshow_eidt_view':
      return defineAsyncComponent(
        () =>
          import('./product/productshow-eidt-view/productshow-eidt-view.vue'),
      );
    case 'deliverableeditview':
      return defineAsyncComponent(
        () =>
          import(
            './deliverable/deliverable-edit-view/deliverable-edit-view.vue'
          ),
      );
    case 'portfolioproject_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolioproject-setting-view/portfolioproject-setting-view.vue'
          ),
      );
    case 'test_plantree_exp_view_project':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plantree-exp-view-project/test-plantree-exp-view-project.vue'
          ),
      );
    case 'portfolioproject_set_going_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolioproject-set-going-view/portfolioproject-set-going-view.vue'
          ),
      );
    case 'work_itemchange_assignee_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemchange-assignee-view/work-itemchange-assignee-view.vue'
          ),
      );
    case 'releaseupdate_view':
      return defineAsyncComponent(
        () => import('./release/releaseupdate-view/releaseupdate-view.vue'),
      );
    case 'work_itemchange_time_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemchange-time-view/work-itemchange-time-view.vue'
          ),
      );
    case 'work_itemfilter_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemfilter-grid-view/work-itemfilter-grid-view.vue'
          ),
      );
    case 'userpickupview':
      return defineAsyncComponent(
        () => import('./user/user-pickup-view/user-pickup-view.vue'),
      );
    case 'projectgrid_view_management_archived':
      return defineAsyncComponent(
        () =>
          import(
            './project/projectgrid-view-management-archived/projectgrid-view-management-archived.vue'
          ),
      );
    case 'work_itempickupview':
      return defineAsyncComponent(
        () =>
          import('./work-item/work-item-pickup-view/work-item-pickup-view.vue'),
      );
    case 'workloadlist_view':
      return defineAsyncComponent(
        () => import('./workload/workloadlist-view/workloadlist-view.vue'),
      );
    case 'recentdata_view':
      return defineAsyncComponent(
        () => import('./recent/recentdata-view/recentdata-view.vue'),
      );
    case 'libraryredirectview':
      return defineAsyncComponent(
        () =>
          import('./library/library-redirect-view/library-redirect-view.vue'),
      );
    case 'test_planpickupview':
      return defineAsyncComponent(
        () =>
          import('./test-plan/test-plan-pickup-view/test-plan-pickup-view.vue'),
      );
    case 'ticketallocate_person_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticketallocate-person-view/ticketallocate-person-view.vue'
          ),
      );
    case 'userunassigned_dept_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './user/userunassigned-dept-grid-view/userunassigned-dept-grid-view.vue'
          ),
      );
    case 'work_itemchild_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemchild-grid-view/work-itemchild-grid-view.vue'
          ),
      );
    case 'userredirectview':
      return defineAsyncComponent(
        () => import('./user/user-redirect-view/user-redirect-view.vue'),
      );
    case 'work_itemmy_todo_gird_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemmy-todo-gird-view/work-itemmy-todo-gird-view.vue'
          ),
      );
    case 'work_itemgantt_view':
      return defineAsyncComponent(
        () => import('./work-item/work-itemgantt-view/work-itemgantt-view.vue'),
      );
    case 'work_itemgrid_view_bug_waterfall':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemgrid-view-bug-waterfall/work-itemgrid-view-bug-waterfall.vue'
          ),
      );
    case 'attentiontab_exp_view':
      return defineAsyncComponent(
        () =>
          import('./attention/attentiontab-exp-view/attentiontab-exp-view.vue'),
      );
    case 'customerpickuptreeview':
      return defineAsyncComponent(
        () =>
          import(
            './customer/customer-pickup-tree-view/customer-pickup-tree-view.vue'
          ),
      );
    case 'psdelogiceditview':
      return defineAsyncComponent(
        () =>
          import('./psde-logic/psde-logic-edit-view/psde-logic-edit-view.vue'),
      );
    case 'projectcreate_wizard_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/projectcreate-wizard-view/projectcreate-wizard-view.vue'
          ),
      );
    case 'ideaquick_create_view':
      return defineAsyncComponent(
        () => import('./idea/ideaquick-create-view/ideaquick-create-view.vue'),
      );
    case 'runsetting_actual_executor_view':
      return defineAsyncComponent(
        () =>
          import(
            './run/runsetting-actual-executor-view/runsetting-actual-executor-view.vue'
          ),
      );
    case 'productedit_view_base_information':
      return defineAsyncComponent(
        () =>
          import(
            './product/productedit-view-base-information/productedit-view-base-information.vue'
          ),
      );
    case 'test_caseset_maintenance_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-caseset-maintenance-view/test-caseset-maintenance-view.vue'
          ),
      );
    case 'workloadproject_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workloadproject-grid-view/workloadproject-grid-view.vue'
          ),
      );
    case 'ticketgrid_view_plan':
      return defineAsyncComponent(
        () => import('./ticket/ticketgrid-view-plan/ticketgrid-view-plan.vue'),
      );
    case 'projectgrid_view_all':
      return defineAsyncComponent(
        () => import('./project/projectgrid-view-all/projectgrid-view-all.vue'),
      );
    case 'portfolioproject_index_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolioproject-index-view/portfolioproject-index-view.vue'
          ),
      );
    case 'test_casetest_plan_re_test_case_prickup_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-casetest-plan-re-test-case-prickup-view/test-casetest-plan-re-test-case-prickup-view.vue'
          ),
      );
    case 'spaceproduct_re_tree_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/spaceproduct-re-tree-exp-view/spaceproduct-re-tree-exp-view.vue'
          ),
      );
    case 'flow_tree_exp_view':
      return defineAsyncComponent(
        () => import('./psde-logic/flow-tree-exp-view/flow-tree-exp-view.vue'),
      );
    case 'ticketeditview':
      return defineAsyncComponent(
        () => import('./ticket/ticket-edit-view/ticket-edit-view.vue'),
      );
    case 'productcreate_wizard_view':
      return defineAsyncComponent(
        () =>
          import(
            './product/productcreate-wizard-view/productcreate-wizard-view.vue'
          ),
      );
    case 'project_taggridview':
      return defineAsyncComponent(
        () =>
          import(
            './project-tag/project-tag-grid-view/project-tag-grid-view.vue'
          ),
      );
    case 'psdelogicflow_panel_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psde-logicflow-panel-view/psde-logicflow-panel-view.vue'
          ),
      );
    case 'spacetree_exp_view_config':
      return defineAsyncComponent(
        () =>
          import(
            './space/spacetree-exp-view-config/spacetree-exp-view-config.vue'
          ),
      );
    case 'spacedetails_setting_view':
      return defineAsyncComponent(
        () =>
          import(
            './space/spacedetails-setting-view/spacedetails-setting-view.vue'
          ),
      );
    case 'portfolio_memberproject_member_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio-member/portfolio-memberproject-member-grid-view/portfolio-memberproject-member-grid-view.vue'
          ),
      );
    case 'productgrid_view_management_deleted':
      return defineAsyncComponent(
        () =>
          import(
            './product/productgrid-view-management-deleted/productgrid-view-management-deleted.vue'
          ),
      );
    case 'product_membereditview':
      return defineAsyncComponent(
        () =>
          import(
            './product-member/product-member-edit-view/product-member-edit-view.vue'
          ),
      );
    case 'work_item_typesetting_view_scrum':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-type/work-item-typesetting-view-scrum/work-item-typesetting-view-scrum.vue'
          ),
      );
    case 'test_plangrid_view_all':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plangrid-view-all/test-plangrid-view-all.vue'
          ),
      );
    case 'ticketre_self_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticketre-self-grid-view/ticketre-self-grid-view.vue'
          ),
      );
    case 'work_itemmy_created_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemmy-created-grid-view/work-itemmy-created-grid-view.vue'
          ),
      );
    case 'portfoliopickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolio-pickup-grid-view/portfolio-pickup-grid-view.vue'
          ),
      );
    case 'projectgrid_view_management_in_progress':
      return defineAsyncComponent(
        () =>
          import(
            './project/projectgrid-view-management-in-progress/projectgrid-view-management-in-progress.vue'
          ),
      );
    case 'space_membergrid_view_config':
      return defineAsyncComponent(
        () =>
          import(
            './space-member/space-membergrid-view-config/space-membergrid-view-config.vue'
          ),
      );
    case 'project_tageditview':
      return defineAsyncComponent(
        () =>
          import(
            './project-tag/project-tag-edit-view/project-tag-edit-view.vue'
          ),
      );
    case 'ideamy_created_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/ideamy-created-grid-view/ideamy-created-grid-view.vue'
          ),
      );
    case 'psdenotifylist_view_setting':
      return defineAsyncComponent(
        () =>
          import(
            './psde-notify/psde-notifylist-view-setting/psde-notifylist-view-setting.vue'
          ),
      );
    case 'projectredirectview':
      return defineAsyncComponent(
        () =>
          import('./project/project-redirect-view/project-redirect-view.vue'),
      );
    case 'work_itemquick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemquick-create-view/work-itemquick-create-view.vue'
          ),
      );
    case 'projectedit_view_base_information':
      return defineAsyncComponent(
        () =>
          import(
            './project/projectedit-view-base-information/projectedit-view-base-information.vue'
          ),
      );
    case 'releasemain_view':
      return defineAsyncComponent(
        () => import('./release/releasemain-view/releasemain-view.vue'),
      );
    case 'test_planupdate_view':
      return defineAsyncComponent(
        () =>
          import('./test-plan/test-planupdate-view/test-planupdate-view.vue'),
      );
    case 'projectedit_view_advanced_setting':
      return defineAsyncComponent(
        () =>
          import(
            './project/projectedit-view-advanced-setting/projectedit-view-advanced-setting.vue'
          ),
      );
    case 'recentredirectview':
      return defineAsyncComponent(
        () => import('./recent/recent-redirect-view/recent-redirect-view.vue'),
      );
    case 'workloadupdate_view':
      return defineAsyncComponent(
        () => import('./workload/workloadupdate-view/workloadupdate-view.vue'),
      );
    case 'ticketquick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticketquick-create-view/ticketquick-create-view.vue'
          ),
      );
    case 'ideaproduct_plan_re_idea_view2':
      return defineAsyncComponent(
        () =>
          import(
            './idea/ideaproduct-plan-re-idea-view-2/ideaproduct-plan-re-idea-view-2.vue'
          ),
      );
    case 'portfolioproject_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolioproject-edit-view/portfolioproject-edit-view.vue'
          ),
      );
    case 'rungrid_view_history':
      return defineAsyncComponent(
        () => import('./run/rungrid-view-history/rungrid-view-history.vue'),
      );
    case 'ideagrid_view_all':
      return defineAsyncComponent(
        () => import('./idea/ideagrid-view-all/ideagrid-view-all.vue'),
      );
    case 'work_itemgrid_view_bug_test_plan':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemgrid-view-bug-test-plan/work-itemgrid-view-bug-test-plan.vue'
          ),
      );
    case 'productgridview':
      return defineAsyncComponent(
        () => import('./product/product-grid-view/product-grid-view.vue'),
      );
    case 'projectmain_data_kanban':
      return defineAsyncComponent(
        () =>
          import(
            './project/projectmain-data-kanban/projectmain-data-kanban.vue'
          ),
      );
    case 'work_itemcopy_view':
      return defineAsyncComponent(
        () => import('./work-item/work-itemcopy-view/work-itemcopy-view.vue'),
      );
    case 'test_planpickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plan-pickup-grid-view/test-plan-pickup-grid-view.vue'
          ),
      );
    case 'librarygrid_view_archived':
      return defineAsyncComponent(
        () =>
          import(
            './library/librarygrid-view-archived/librarygrid-view-archived.vue'
          ),
      );
    case 'worktree_grid_ex_view':
      return defineAsyncComponent(
        () => import('./work/worktree-grid-ex-view/worktree-grid-ex-view.vue'),
      );
    case 'librarycreate_wizard_view':
      return defineAsyncComponent(
        () =>
          import(
            './library/librarycreate-wizard-view/librarycreate-wizard-view.vue'
          ),
      );
    case 'portfolioproject_show_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolioproject-show-view/portfolioproject-show-view.vue'
          ),
      );
    case 'product_membergrid_view_assigned':
      return defineAsyncComponent(
        () =>
          import(
            './product-member/product-membergrid-view-assigned/product-membergrid-view-assigned.vue'
          ),
      );
    case 'sprintgrid_view_all':
      return defineAsyncComponent(
        () => import('./sprint/sprintgrid-view-all/sprintgrid-view-all.vue'),
      );
    case 'appindexview':
      return defineAsyncComponent(
        () => import('./app-index-view/app-index-view.vue'),
      );
    case 'test_plangrid_view_my_assignee':
      return defineAsyncComponent(
        () =>
          import(
            './test-plan/test-plangrid-view-my-assignee/test-plangrid-view-my-assignee.vue'
          ),
      );
    case 'psdelogicflow_main_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psde-logicflow-main-view/psde-logicflow-main-view.vue'
          ),
      );
    case 'library_membereditview':
      return defineAsyncComponent(
        () =>
          import(
            './library-member/library-member-edit-view/library-member-edit-view.vue'
          ),
      );
    case 'portfolioproject_set_tab_exp_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolioproject-set-tab-exp-view/portfolioproject-set-tab-exp-view.vue'
          ),
      );
    case 'work_itemmove_view':
      return defineAsyncComponent(
        () => import('./work-item/work-itemmove-view/work-itemmove-view.vue'),
      );
    case 'test_caseredirectview':
      return defineAsyncComponent(
        () =>
          import(
            './test-case/test-case-redirect-view/test-case-redirect-view.vue'
          ),
      );
    case 'article_pageeditview':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-page-edit-view/article-page-edit-view.vue'
          ),
      );
    case 'ticketgrid_view_assignee':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticketgrid-view-assignee/ticketgrid-view-assignee.vue'
          ),
      );
    case 'product_memberredirectview':
      return defineAsyncComponent(
        () =>
          import(
            './product-member/product-member-redirect-view/product-member-redirect-view.vue'
          ),
      );
    case 'tickettree_exp_view':
      return defineAsyncComponent(
        () => import('./ticket/tickettree-exp-view/tickettree-exp-view.vue'),
      );
    case 'work_itemgrid_view_all_waterfall':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemgrid-view-all-waterfall/work-itemgrid-view-all-waterfall.vue'
          ),
      );
    case 'ticketrecover_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticketrecover-grid-view/ticketrecover-grid-view.vue'
          ),
      );
    case 'sprintpick_up_view':
      return defineAsyncComponent(
        () => import('./sprint/sprintpick-up-view/sprintpick-up-view.vue'),
      );
    case 'sprintpickupview':
      return defineAsyncComponent(
        () => import('./sprint/sprint-pickup-view/sprint-pickup-view.vue'),
      );
    case 'projectsetting_view':
      return defineAsyncComponent(
        () => import('./project/projectsetting-view/projectsetting-view.vue'),
      );
    case 'ticketredirectview':
      return defineAsyncComponent(
        () => import('./ticket/ticket-redirect-view/ticket-redirect-view.vue'),
      );
    case 'work_itemgrid_view_version':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemgrid-view-version/work-itemgrid-view-version.vue'
          ),
      );
    case 'psdefieldquick_cfg_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-field/psde-fieldquick-cfg-view/psde-fieldquick-cfg-view.vue'
          ),
      );
    case 'sprintquick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './sprint/sprintquick-create-view/sprintquick-create-view.vue'
          ),
      );
    case 'spacecreate_wizard_view':
      return defineAsyncComponent(
        () =>
          import('./space/spacecreate-wizard-view/spacecreate-wizard-view.vue'),
      );
    case 'ticketcreate_re_ticket_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticketcreate-re-ticket-view/ticketcreate-re-ticket-view.vue'
          ),
      );
    case 'projectpickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './project/project-pickup-grid-view/project-pickup-grid-view.vue'
          ),
      );
    case 'user_pickupgridview_user':
      return defineAsyncComponent(
        () =>
          import(
            './user/user-pickupgridview-user/user-pickupgridview-user.vue'
          ),
      );
    case 'project_memberredirectview':
      return defineAsyncComponent(
        () =>
          import(
            './project-member/project-member-redirect-view/project-member-redirect-view.vue'
          ),
      );
    case 'work_itemre_self_mpickup_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemre-self-mpickup-view/work-itemre-self-mpickup-view.vue'
          ),
      );
    case 'work_itembug_state_statement':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itembug-state-statement/work-itembug-state-statement.vue'
          ),
      );
    case 'workloadredirectview':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workload-redirect-view/workload-redirect-view.vue'
          ),
      );
    case 'psdelogicflow_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psde-logicflow-grid-view/psde-logicflow-grid-view.vue'
          ),
      );
    case 'ticketmain_view':
      return defineAsyncComponent(
        () => import('./ticket/ticketmain-view/ticketmain-view.vue'),
      );
    case 'projectmove_choose_pickup_view_pickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './project/projectmove-choose-pickup-view-pickup-grid-view/projectmove-choose-pickup-view-pickup-grid-view.vue'
          ),
      );
    case 'librarytab_exp_view_config':
      return defineAsyncComponent(
        () =>
          import(
            './library/librarytab-exp-view-config/librarytab-exp-view-config.vue'
          ),
      );
    case 'test_planmain_view':
      return defineAsyncComponent(
        () => import('./test-plan/test-planmain-view/test-planmain-view.vue'),
      );
    case 'ticketidea_re_ticket_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticketidea-re-ticket-grid-view/ticketidea-re-ticket-grid-view.vue'
          ),
      );
    case 'psdelogicquick_cfg_view':
      return defineAsyncComponent(
        () =>
          import(
            './psde-logic/psde-logicquick-cfg-view/psde-logicquick-cfg-view.vue'
          ),
      );
    case 'workloadcalendar_management_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workloadcalendar-management-view/workloadcalendar-management-view.vue'
          ),
      );
    case 'ideaticket_re_idea_gridview':
      return defineAsyncComponent(
        () =>
          import(
            './idea/ideaticket-re-idea-gridview/ideaticket-re-idea-gridview.vue'
          ),
      );
    case 'workloadlog_grid_view':
      return defineAsyncComponent(
        () =>
          import('./workload/workloadlog-grid-view/workloadlog-grid-view.vue'),
      );
    case 'projectmpickupview':
      return defineAsyncComponent(
        () =>
          import('./project/project-m-pickup-view/project-m-pickup-view.vue'),
      );
    case 'library_membergrid_view_assigned':
      return defineAsyncComponent(
        () =>
          import(
            './library-member/library-membergrid-view-assigned/library-membergrid-view-assigned.vue'
          ),
      );
    case 'librarytree_exp_view_config':
      return defineAsyncComponent(
        () =>
          import(
            './library/librarytree-exp-view-config/librarytree-exp-view-config.vue'
          ),
      );
    case 'work_itemcalendar_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemcalendar-view/work-itemcalendar-view.vue'
          ),
      );
    case 'workeditview':
      return defineAsyncComponent(
        () => import('./work/work-edit-view/work-edit-view.vue'),
      );
    case 'projecttree_exp_view_config':
      return defineAsyncComponent(
        () =>
          import(
            './project/projecttree-exp-view-config/projecttree-exp-view-config.vue'
          ),
      );
    case 'customerall_grid_view':
      return defineAsyncComponent(
        () =>
          import('./customer/customerall-grid-view/customerall-grid-view.vue'),
      );
    case 'work_itemre_self_mpickup_view_pickupgridview':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemre-self-mpickup-view-pickup-grid-view/work-itemre-self-mpickup-view-pickup-grid-view.vue'
          ),
      );
    case 'customeradd_categorys_view':
      return defineAsyncComponent(
        () =>
          import(
            './customer/customeradd-categorys-view/customeradd-categorys-view.vue'
          ),
      );
    case 'runmain_view':
      return defineAsyncComponent(
        () => import('./run/runmain-view/runmain-view.vue'),
      );
    case 'sprinttree_exp_view':
      return defineAsyncComponent(
        () => import('./sprint/sprinttree-exp-view/sprinttree-exp-view.vue'),
      );
    case 'work_itemmy_gird_view_index':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemmy-gird-view-index/work-itemmy-gird-view-index.vue'
          ),
      );
    case 'ticketcustomer_re_ticket_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticketcustomer-re-ticket-grid-view/ticketcustomer-re-ticket-grid-view.vue'
          ),
      );
    case 'workloadtab_exp_view':
      return defineAsyncComponent(
        () =>
          import('./workload/workloadtab-exp-view/workloadtab-exp-view.vue'),
      );
    case 'releasegrid_view_all':
      return defineAsyncComponent(
        () => import('./release/releasegrid-view-all/releasegrid-view-all.vue'),
      );
    case 'extend_loginfo_view':
      return defineAsyncComponent(
        () =>
          import('./extend-log/extend-loginfo-view/extend-loginfo-view.vue'),
      );
    case 'ideanot_re_pickup_grid':
      return defineAsyncComponent(
        () =>
          import('./idea/ideanot-re-pickup-grid/ideanot-re-pickup-grid.vue'),
      );
    case 'portfolioproject_create_wizard_view':
      return defineAsyncComponent(
        () =>
          import(
            './portfolio/portfolioproject-create-wizard-view/portfolioproject-create-wizard-view.vue'
          ),
      );
    case 'releasequick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './release/releasequick-create-view/releasequick-create-view.vue'
          ),
      );
    case 'test_suitequick_create_view':
      return defineAsyncComponent(
        () =>
          import(
            './test-suite/test-suitequick-create-view/test-suitequick-create-view.vue'
          ),
      );
    case 'work_itemtest_case_re_work_item_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemtest-case-re-work-item-grid-view/work-itemtest-case-re-work-item-grid-view.vue'
          ),
      );
    case 'article_pageedit_view_document':
      return defineAsyncComponent(
        () =>
          import(
            './article-page/article-pageedit-view-document/article-pageedit-view-document.vue'
          ),
      );
    case 'runrun_histor_re_run_edit_view':
      return defineAsyncComponent(
        () =>
          import(
            './run/runrun-histor-re-run-edit-view/runrun-histor-re-run-edit-view.vue'
          ),
      );
    case 'ticketgrid_view_submit':
      return defineAsyncComponent(
        () =>
          import('./ticket/ticketgrid-view-submit/ticketgrid-view-submit.vue'),
      );
    case 'work_itemgrid_view_sprint':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemgrid-view-sprint/work-itemgrid-view-sprint.vue'
          ),
      );
    case 'ideachange_state_view':
      return defineAsyncComponent(
        () => import('./idea/ideachange-state-view/ideachange-state-view.vue'),
      );
    case 'transition_historywork_item_calendar_view':
      return defineAsyncComponent(
        () =>
          import(
            './transition-history/transition-historywork-item-calendar-view/transition-historywork-item-calendar-view.vue'
          ),
      );
    case 'ideatest_case_re_idea_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './idea/ideatest-case-re-idea-grid-view/ideatest-case-re-idea-grid-view.vue'
          ),
      );
    case 'deliverableredirectview':
      return defineAsyncComponent(
        () =>
          import(
            './deliverable/deliverable-redirect-view/deliverable-redirect-view.vue'
          ),
      );
    case 'product_planpickuptreeview':
      return defineAsyncComponent(
        () =>
          import(
            './product-plan/product-plan-pickup-tree-view/product-plan-pickup-tree-view.vue'
          ),
      );
    case 'releasepick_up_view':
      return defineAsyncComponent(
        () => import('./release/releasepick-up-view/releasepick-up-view.vue'),
      );
    case 'workloadlog_management_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workloadlog-management-view/workloadlog-management-view.vue'
          ),
      );
    case 'librarypickupview':
      return defineAsyncComponent(
        () => import('./library/library-pickup-view/library-pickup-view.vue'),
      );
    case 'work_item_typeglobal_setting_view_scrum':
      return defineAsyncComponent(
        () =>
          import(
            './work-item-type/work-item-typeglobal-setting-view-scrum/work-item-typeglobal-setting-view-scrum.vue'
          ),
      );
    case 'recentrecent_project_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './recent/recentrecent-project-grid-view/recentrecent-project-grid-view.vue'
          ),
      );
    case 'work_itemtest_case_re_bug_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './work-item/work-itemtest-case-re-bug-grid-view/work-itemtest-case-re-bug-grid-view.vue'
          ),
      );
    case 'workloadtab_search_view':
      return defineAsyncComponent(
        () =>
          import(
            './workload/workloadtab-search-view/workloadtab-search-view.vue'
          ),
      );
    case 'projectmove_choose_pickup_view':
      return defineAsyncComponent(
        () =>
          import(
            './project/projectmove-choose-pickup-view/projectmove-choose-pickup-view.vue'
          ),
      );
    case 'ticketwork_item_re_grid_view':
      return defineAsyncComponent(
        () =>
          import(
            './ticket/ticketwork-item-re-grid-view/ticketwork-item-re-grid-view.vue'
          ),
      );
    case 'productgrid_view_all':
      return defineAsyncComponent(
        () => import('./product/productgrid-view-all/productgrid-view-all.vue'),
      );
    case 'productindex_view':
      return defineAsyncComponent(
        () => import('./product/productindex-view/productindex-view.vue'),
      );
    default:
      throw new Error(`无法找到视图模型：${name}`);
  }
}
