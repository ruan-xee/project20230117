package com.rxee.backend.common;


public interface Constants {
    //状态码
    /**
     * 成功
     */
    String CODE_200 = "200";
    /**
     * 权限不足
     */
    String CODE_401 = "401";
    /**
     * 参数错误
     */
    String CODE_400 = "400";
    /**
     * 系统错误
     */
    String CODE_500 = "500";
    /**
     * 业务异常
     */
    String CODE_600 = "600";

    /**
     * 角色类型：管理员
     */
    String ROLE_ADMIN = "admin";
    /**
     * 角色类型：普通用户
     */
    String ROLE_USER = "user";

}
