package com.example.movielibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class FragmentController {
    @GetMapping("/fragment/modal/confirmation/rental")
    public String confirmationModal(@RequestParam(name = "movieId") int movieId, Model model) {
        model.addAllAttributes(new HashMap<>() {{
            put("title", "Confirmation");
            put("content", "Are you sure you want to rent this movie?");
            put("data", new HashMap<String, String>() {{
                put("movieId", Integer.toString(movieId));
            }});
        }});

        return "modals/confirmation";
    }
}
