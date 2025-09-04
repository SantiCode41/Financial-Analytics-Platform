package com.financial.finApp.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DataController {

    @GetMapping("/data")
    public Map<String, String> getData() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "If I can see this then I successfully connected to my backend!!!");
        return response;
    }
}
