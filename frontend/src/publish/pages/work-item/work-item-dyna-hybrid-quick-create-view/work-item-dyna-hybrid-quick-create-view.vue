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
    <template #_form_hybrid_bug="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
    <template #_form_hybrid_epic="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
    <template #_form_hybrid_feature="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
    <template #_form_hybrid_issue="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
    <template #_form_hybrid_milestone="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
    <template #_form_hybrid_requirement="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
    <template #_form_hybrid_stage="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
    <template #_form_hybrid_story="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
    <template #_form_hybrid_task="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
  </i-biz-view>
</template>
<script setup lang="ts">
import { IModal } from '@ibiz-template/runtime';
import { defineProps, withDefaults } from 'vue';
import model from '@/publish/model/views/work-item-dyna-hybrid-quick-create-view';

interface Props {
  context?: IContext;
  params?: IParams;
  modal?: IModal;
}
const props = withDefaults(defineProps<Props>(), {});
</script>
