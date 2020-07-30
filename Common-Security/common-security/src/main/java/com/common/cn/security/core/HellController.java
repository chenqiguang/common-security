package com.common.cn.security.core;

import com.common.cn.security.service.HellerWorldService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellController {

    @Autowired
    private HellerWorldService hellerWorldService;

    @ApiOperation(value = "hello", notes = "", response = String.class, authorizations = {
            @Authorization(value = "x-access-token")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "response", response = String.class)})
    @RequestMapping(value = "/{tenantId}/storage/v1/file/channel",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public String HellerWorld(){
        return hellerWorldService.HellerWorld();
    }
}
