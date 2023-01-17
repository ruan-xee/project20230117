import axios from "axios";
import {Message} from "element-ui";
import router from "@/router";

//响应拦截器
axios.interceptors.response.use(success=>{
    if (success.status && success.status == 200){
        if (success.data.code == 500 || success.data.code == 401 || success.data.code == 403){
            Message.error({message: success.data.msg});
            return;
        }
        if (success.data.msg){
            Message.success({message: success.data.msg});
        }
    }
    return success.data;
}, error => {
    if (error.response.code == 504){
        Message.error({message:'服务器好像被吃了( ╯□╰ )'})
    } else if (error.response.code == 404){
        Message.error({message:'地址好像被吃了( ╯□╰ )'})
    } else if (error.response.code == 403){
        Message.error({message:'权限好像还不太够( ╯□╰ )'})
    } else if (error.response.code == 401){
        Message.error({message:'还没有登录呢喵( ╯□╰ )'})
        router.replace('/')
    } else {
        if (error.response.data.message){
            Message.error({message:error.response.data.message})
        } else {
            Message.error({message:'未知错误！'})
        }
    }
    return;
})

let base = '';

// 传送json格式的post请求
export const postRequest=(url, params)=>{
    return axios({
        method: 'post',
        url:`${base}${url}`,
        data:params
    });
}
