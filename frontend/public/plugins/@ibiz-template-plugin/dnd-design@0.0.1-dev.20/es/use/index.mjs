import { inject } from 'vue';

"use strict";
function useRenderItems() {
  return inject("dndDesignRenderItems");
}

export { useRenderItems };
