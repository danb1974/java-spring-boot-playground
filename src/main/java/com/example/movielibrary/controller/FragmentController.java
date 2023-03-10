package com.example.movielibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller
public class FragmentController {
    @GetMapping("/fragment/modal/confirmation")
    public String confirmationModal(Model model) {
        model.addAllAttributes(new HashMap<>() {{
            put("title", "Confirmation");
            put("content", "Are you sure you want to do something?");
        }});

        return "modals/confirmation";
    }
}
