package com.aliyun.eci.demo.controlleradvice;

import com.aliyun.eci.demo.exception.SystemException;
import com.aliyun.eci.demo.work.CpuConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class JobController {

    @GetMapping("/hello")
    public String helloWorld() {
        // 发起一个消耗cpu的任务
        new Thread(CpuConsumer::consume).start();
        // 返回结果
        System.out.println("submit job success");
        return "submit job success";
    }

    @GetMapping("/helle")
    public String helloWorld2() throws Exception {
        throw new SystemException("error", "unsupported path");
    }
}
