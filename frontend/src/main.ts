import 'vue';
import { runApp } from '@ibiz-template/vue3-components';
import VueTextFormat from 'vue-text-format';
import gridLayout from 'vue-grid-layout';
import UserRegister from './user-register';
import ComponentsRegister from './components/index';
import { StaticAuthGuard } from './guard/auth-guard/auth-guard';
import '@/publish/sys.css';

runApp([VueTextFormat, gridLayout, ComponentsRegister, UserRegister], {
  getAuthGuard: () => new StaticAuthGuard(),
});
