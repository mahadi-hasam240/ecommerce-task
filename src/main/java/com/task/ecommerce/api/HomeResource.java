package com.task.ecommerce.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class HomeResource {

    @GetMapping()
    public String index() {
        return "Ecommerce site is running..............";
    }
}
