package com.entelgy.pruebaentelgy.controller;

import java.util.List;

import com.entelgy.pruebaentelgy.model.response.Response;
import com.entelgy.pruebaentelgy.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    
    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/comments")
    public ResponseEntity<Response<List<String>>> loadAllComments(){
        Response<List<String>> comments = commentService.loadAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

}
