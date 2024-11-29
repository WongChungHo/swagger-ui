package com.baeldung.apiswagger.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

@RestController
public class RedirectController {

//    @PostMapping(value = "/", consumes = "*/*")
//    Void updateActionItem(HttpServletRequest request) throws Exception {
//        HttpServletRequest.sendRedirect("https://twitter.com");
//    }
    @RequestMapping(
            value = "/",
            method = RequestMethod.GET)
    public void redirectToTwitter(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("/swagger-ui/");
    }

}



