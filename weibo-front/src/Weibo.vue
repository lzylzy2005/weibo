<template>
  <div class="box">
    <h1>本地微博</h1>

    <div class="publish">
      <textarea v-model="content" rows="4" placeholder="说点什么..."></textarea>
      <button @click="publish">发布微博</button>
    </div>

    <div class="list">
      <div class="item" v-for="item in list" :key="item.id">
        <p>用户：{{ item.userId }}</p>
        <p>{{ item.content }}</p>
        <p>{{ formatTime(item.createTime) }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
axios.defaults.baseURL = 'https://weibo-production.up.railway.app/api';

export default {
  name: 'App',
  data() {
    return {
      content: '',
      list: []
    }
  },
  mounted() {
    this.getList()
  },
  methods: {
    async getList() {
      const res = await axios.get('/weibo')
      this.list = res.data.data
    },
    async publish() {
      await axios.post('/weibo',
      { content: this.content },
      { 
        headers:{
        token: localStorage.getItem('token')
        }
      })
      this.content = ''
      this.getList()
    },
    formatTime(time) {
      if (!time) return ''
        return time.replace('T', ' ').substring(0, 19)
    }
  }
}
</script>

<style>
.box { width: 600px; margin: 0 auto; padding: 20px; }
.publish { margin-bottom: 20px; }
textarea { width: 100%; padding: 10px; margin-bottom: 10px; }
.item { border: 1px solid #ddd; padding: 15px; margin-bottom: 10px; border-radius: 8px; }
</style>