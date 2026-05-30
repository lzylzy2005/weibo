<template>
  <div class="login-container">
    <div class="login-box">
      <h2>微博登录</h2>
      <input 
        type="text" 
        v-model="username" 
        placeholder="用户名"
        @keyup.enter="login"
      />
      <input 
        type="password" 
        v-model="password" 
        placeholder="密码"
        @keyup.enter="login"
      />
      <button @click="login">登录</button>
      <p v-if="errorMsg" class="error">{{ errorMsg }}</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

// 配置后端接口根地址（根据你的实际地址修改）
axios.defaults.baseURL = 'https://weibo-production.up.railway.app';

export default {
  name: 'LoginPage',
  data() {
    return {
      username: '',
      password: '',
      errorMsg: ''
    };
  },
  methods: {
    async login() {
      // 简单前端校验
      if (!this.username.trim() || !this.password.trim()) {
        this.errorMsg = '用户名和密码不能为空';
        return;
      }
      this.errorMsg = ''; // 清空旧的错误信息

      try {
        const res = await axios.post('/api/login', {
          username: this.username,
          password: this.password
        });

        if (res.data.code === 200) {
          // 存储 token 到 localStorage（或 sessionStorage）
          localStorage.setItem('token', res.data.token);
          // 跳转到微博页面（路由名称 '/weibo'）
          this.$router.push('/weibo');
        } else {
          this.errorMsg = res.data.msg || '登录失败';
        }
      } catch (error) {
        console.error('登录请求失败', error);
        this.errorMsg = '网络错误，请稍后重试';
      }
    }
  }
};
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: #f0f2f5;
}

.login-box {
  width: 350px;
  padding: 30px;
  background: white;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0,0,0,0.1);
  text-align: center;
}

.login-box h2 {
  margin-bottom: 20px;
  color: #333;
}

.login-box input {
  width: 100%;
  padding: 12px;
  margin-bottom: 15px;
  border: 1px solid #ddd;
  border-radius: 5px;
  font-size: 14px;
  box-sizing: border-box;
}

.login-box button {
  width: 100%;
  padding: 12px;
  background: #409eff;
  color: white;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
  transition: background 0.3s;
}

.login-box button:hover {
  background: #66b1ff;
}

.error {
  color: red;
  margin-top: 10px;
  font-size: 14px;
}
</style>