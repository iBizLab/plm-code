<template>
  <i-biz-special-view
    :context="props.context"
    :params="props.params"
    :modal="props.modal"
    :model-data="model"
  >
    <template #node="slotProps">
      <i-biz-control-shell v-bind="slotProps" />
    </template>
    <template #link="slotProps">
      <i-biz-control-shell v-bind="slotProps" />
    </template>
    <template #form="slotProps">
      <i-biz-edit-form-control v-bind="slotProps" />
    </template>
  </i-biz-special-view>
</template>
<script setup lang="ts">
import { IModal } from '@ibiz-template/runtime';
import { defineProps, withDefaults } from 'vue';
import model from '@/publish/model/views/psdems-logic-ms-logic-design-custom';

interface Props {
  context?: IContext;
  params?: IParams;
  modal?: IModal;
}
const props = withDefaults(defineProps<Props>(), {});
</script>
