<template>
  <i-biz-view
    :context="props.context"
    :params="props.params"
    :modal="props.modal"
    :model-data="model"
  >
    <template #pickupviewpanel="slotProps">
      <i-biz-pickup-view-panel-control v-bind="slotProps" />
    </template>
    <template #treeexpbar="slotProps">
      <i-biz-tree-exp-bar-control v-bind="slotProps" />
    </template>
    <template #simplelist="slotProps">
      <i-biz-control-shell v-bind="slotProps" />
    </template>
  </i-biz-view>
</template>
<script setup lang="ts">
import { IModal } from '@ibiz-template/runtime';
import { defineProps, withDefaults } from 'vue';
import model from '@/publish/model/views/ticket-others-re-ticket-mpick-up-view';

interface Props {
  context?: IContext;
  params?: IParams;
  modal?: IModal;
}
const props = withDefaults(defineProps<Props>(), {});
</script>
