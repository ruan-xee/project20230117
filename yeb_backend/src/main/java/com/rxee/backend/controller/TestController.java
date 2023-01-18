package com.rxee.backend.controller;

import com.rxee.backend.vo.ResultVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/t")
    public ResultVo test(@RequestBody Object forms){
        return ResultVo.success(forms);
    }
}
