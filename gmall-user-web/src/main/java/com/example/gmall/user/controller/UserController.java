package com.example.gmall.user.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.example.gmall.beans.UmsMember;
import com.example.gmall.beans.UmsMemberReceiveAddress;
import com.example.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "Hello User";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<UmsMember> getAllUsers() {
        List<UmsMember> umsMembers = userService.getAllUsers();
        return  umsMembers;
    }

    @RequestMapping("/receiveAddress/{memberId}")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(@PathVariable("memberId") String memberId) {
        return userService.getReceiveAddressByMemberId(memberId);
    }

}
