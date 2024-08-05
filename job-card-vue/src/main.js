import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'

//Vue.config.productionTip = false

axios.defaults.baseURL = import.meta.env.VUE_APP_REMOTE_API;

const app = createApp(App)

app.use(router)

app.mount('#app')
