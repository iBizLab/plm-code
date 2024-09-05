<template>
  <i-biz-view
    :context="props.context"
    :params="props.params"
    :modal="props.modal"
    :model-data="model"
  >
    <template #searchform="slotProps">
      <i-biz-search-form-control v-bind="slotProps" />
    </template>
    <template #chart="slotProps">
      <i-biz-chart-control v-bind="slotProps" />
    </template>
  </i-biz-view>
</template>
<script setup lang="ts">
import { IModal } from '@ibiz-template/runtime';
import { defineProps, withDefaults } from 'vue';
import model from '@/publish/model/views/ticket-idea-re-ticket-chart-view';

interface Props {
  context?: IContext;
  params?: IParams;
  modal?: IModal;
}
const props = withDefaults(defineProps<Props>(), {});
</script>
