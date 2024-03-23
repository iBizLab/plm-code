rm -rf node_modules
yarn
yarn add "@ibiz-template/vue3-util@latest" "@ibiz-template/runtime@latest" "@ibiz-template/core@latest" "@ibiz-template/theme@latest"
yarn build
rm -rf node_modules
pnpm install
npm run dev