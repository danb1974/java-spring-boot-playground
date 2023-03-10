package com.example.movielibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;

@Controller
public class FragmentController {
//    @GetMapping("/fragments/modal/confirmation/rental")
//    public String confirmationModal(@RequestParam(name = "movieId") int movieId, Model model) {
//        model.addAllAttributes(new HashMap<>() {{
//            put("title", "Confirmation");
//            put("content", "Are you sure you want to rent this movie?");
//            put("method", "post");
//            put("action", UriComponentsBuilder.newInstance().path("/fragments/movie/rent").query("movieId={movieId}").buildAndExpand(movieId));
//        }});
//
//        return "modals/confirmation";
//    }
//
//    @PostMapping("/fragments/movie/rent")
//    public String rentMovie(@RequestParam(name = "movieId") int movieId, Model model) {
//        model.addAllAttributes(new HashMap<>() {{
//            put("title", "Info");
//            put("content", "Movie has been rented");
//        }});
//
//        return "modals/info";
//    }
}
