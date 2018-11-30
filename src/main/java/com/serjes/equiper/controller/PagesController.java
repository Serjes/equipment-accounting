package com.serjes.equiper.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PagesController {

    private final Logger logger = LoggerFactory.getLogger("Pages controller");

    @GetMapping("/")
    public String indexPage() {
        logger.info("IndexPage");
        return "index";
    }

    @GetMapping("/error")
    public String errorPage() {
        logger.info("ErrorPage");
        return "error";
    }

    @GetMapping("/devices-table")
    public String devTablePage(HttpServletRequest request) {
        logger.info("DevicesTablePage");
        boolean authority = request.isUserInRole("FIN_RESP");
        if (authority){
            return "devices-table.html";
        }else return "devices-viewer.html";
    }

    @GetMapping("/contracts-table")
    public String contrTablePage(HttpServletRequest request) {
        logger.info("ContractsTablePage");
        boolean authority = request.isUserInRole("FIN_RESP");
        if (authority){
            return "contracts-table.html";
        }else return "contracts-viewer.html";
    }
}
