<template>
  <div>
    <el-form :rules="rules" ref="loginForm" :model="loginForm" class="loginContainer">
      <h3 class="loginTitle">系统登录</h3>
      <el-form-item prop="username">
        <el-input v-model="loginForm.username" auto-complete="false" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input v-model="loginForm.password" type="password" auto-complete="false" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item prop="code">
        <el-input v-model="loginForm.code" type="text" auto-complete="false" placeholder="点击图片更换验证码" style="width: 250px;margin-right: 5px"></el-input>
        <img :src="captchaUrl">
      </el-form-item>
      <el-checkbox v-model="checked" class="loginRemember">记住我</el-checkbox>
      <el-button type="primary" style="width: 100%" @click="submitLogin">登录</el-button>
    </el-form>
  </div>
</template>

<script>
import {postRequest} from "@/utils/api";

export default {
  name: "Login",
  data(){
    return{
      captchaUrl: '',
      loginForm:{
        username: '',
        password: '',
        code: '',
      },
      checked: true,
      rules:{
        username:[{required:true, message:'用户名不能为空！', trigger:'blur'}],
        password:[{required:true, message:'密码不能为空！', trigger:'blur'}],
        code:[{required:true, message:'验证码不能为空！', trigger:'blur'}],
      },
    }
  },
  methods:{
    submitLogin(){
      this.$refs.loginForm.validate((valid)=>{
        if (valid){
          postRequest("/test/t", {forms: this.forms}).then(res=>{
            console.log(res);
          })
        } else {
          this.$message.error('请正确输入登录信息！')
          return false;
        }
      })
    }
  }
}
</script>

<style>
.loginContainer{
  border-radius: 15px;
  background-clip: padding-box;
  margin: 180px auto;
  width: 350px;
  padding: 15px 35px 15px 35px;
  background: #ffffff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.loginTitle{
  margin: 0px auto 40px auto;
  text-align: center;
}
.loginRemember{
  text-align: left;
  margin: 0px 0px 15px 0px;
}
.el-form-item__content{
  display: flex;
  align-items: center;
}

</style>
