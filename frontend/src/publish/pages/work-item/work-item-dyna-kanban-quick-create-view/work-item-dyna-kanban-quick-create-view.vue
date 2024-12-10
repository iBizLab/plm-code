<template>
  <i-biz-view
    :context="props.context"
    :params="props.params"
    :modal="props.modal"
    :model-data="model"
  >
    <template #form="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
    <template #_form_kanban_bug="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
    <template #_form_kanban_epic="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
    <template #_form_kanban_feature="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
    <template #_form_kanban_issue="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
    <template #_form_kanban_story="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
    <template #_form_kanban_task="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
  </i-biz-view>
</template>
<script setup lang="ts">
import { IModal } from '@ibiz-template/runtime';
import { defineProps, withDefaults } from 'vue';
import model from '@/publish/model/views/work-item-dyna-kanban-quick-create-view';

interface Props {
  context?: IContext;
  params?: IParams;
  modal?: IModal;
}
const props = withDefaults(defineProps<Props>(), {});
</script>
