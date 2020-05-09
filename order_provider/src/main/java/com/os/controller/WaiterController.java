package com.os.controller;

import com.os.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author R
 * @date 2020/5/9 - 14:53
 */
@RestController
public class WaiterController {

    @Autowired
    UserinfoService userinfoService;


}
