package com.example.study.controller;

import com.example.study.model.SearchParm;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") //localhost:8080/api/getMethod
    public String getRequest() {
        return "hi getMthod";
    }

    @GetMapping("/getParameter") // localhost:8080/api/getParameter
    public String getParameter(@RequestParam(name="id") String id, @RequestParam(name="password") String pwd) {
        String password = "bbbb";
        System.out.println("id = " + id);
        System.out.println("password = " + pwd);
        return id + pwd;
    }

    //localhost:8080/api/multiParameter?... -> model 로 받는 방법
    @GetMapping("getMultiParameter")
    public SearchParm getMultiParameter(SearchParm searchParm) {
        System.out.println("searchParm.getAccount() = " + searchParm.getAccount());
        System.out.println("searchParm.getEmail() = " + searchParm.getEmail());
        System.out.println("searchParm.getPage() = " + searchParm.getPage());
        return searchParm;
    }
}
