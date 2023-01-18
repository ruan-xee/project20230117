package com.rxee.backend.vo;

import com.rxee.backend.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接口统一返回包装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo {
    private String code;
    private String msg;
    private Object obj;

    public static ResultVo success(){
        return new ResultVo(Constants.CODE_200, "", null);
    }

    public static ResultVo success(Object obj){
        return new ResultVo(Constants.CODE_200, "", obj);
    }

    public static ResultVo fail(String code, String msg){
        return new ResultVo(code, msg, null);
    }

    public static ResultVo fail(){
        return new ResultVo(Constants.CODE_500, "服务器错误！", null);
    }
}
