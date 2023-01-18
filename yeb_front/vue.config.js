const { defineConfig } = require('@vue/cli-service')

let proxyObj={}
proxyObj['/']={
  //websocket
  ws: false,
  //目标地址
  target: 'http://localhost:8081',
  //发送请求头host会被设置target
  changeOrigin: true,

  pathRewrite:{
    '^/': '/'
  }
}

module.exports = defineConfig({
  transpileDependencies: true,
  devServer:{
    host: 'localhost',
    port: 8080,
    proxy: proxyObj
  }
})
