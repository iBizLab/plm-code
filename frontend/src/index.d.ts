import '@ibiz/model-core';
import { App } from 'vue';

declare global {
  interface Window {
    vueInstances: Map<App, App>;
  }
}

declare module 'vue' {
  interface ComponentCustomProperties {
    $textFormat: (value: string, code: string) => string;
  }
}
