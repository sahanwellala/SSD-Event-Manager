package com.sliit.ssd.controller;

import com.sliit.ssd.service.GoogleAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/api/google")
public class GoogleAuthController {

    @Autowired
    private GoogleAuthService googleAuthService;


    @GetMapping("/grant")
    public void grantPermissions(@RequestParam(value = "code", required = false) String code,
                                 @RequestParam(value = "error_code", required = false) String errorCode,
                                 HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (code != null) {
            if (googleAuthService.obtainAccessToken(code).equals("Bearer")) {
                HttpSession httpSession = request.getSession(true);
                response.sendRedirect("/home.html");
                return;
            }
            response.sendRedirect("/index.html");
            return;
        }
        response.sendRedirect("/index.html");
    }
}
