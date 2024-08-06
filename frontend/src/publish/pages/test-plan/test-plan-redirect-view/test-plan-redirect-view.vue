<template>
  <i-biz-de-redirect-view
    :context="props.context"
    :params="props.params"
    :modal="props.modal"
    :model-data="model"
  >
  </i-biz-de-redirect-view>
</template>
<script setup lang="ts">
import { IModal } from '@ibiz-template/runtime';
import { defineProps, withDefaults } from 'vue';
import model from '@/publish/model/views/test-plan-redirect-view';

interface Props {
  context?: IContext;
  params?: IParams;
  modal?: IModal;
}
const props = withDefaults(defineProps<Props>(), {});
</script>
