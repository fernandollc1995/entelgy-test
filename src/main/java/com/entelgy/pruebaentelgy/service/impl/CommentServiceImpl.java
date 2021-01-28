package com.entelgy.pruebaentelgy.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.entelgy.pruebaentelgy.model.response.CommentResponse;
import com.entelgy.pruebaentelgy.model.response.Response;
import com.entelgy.pruebaentelgy.service.CommentService;
import com.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Response<List<String>> loadAllComments() {
        
        Response<List<String>> response = new Response<>();

        ResponseEntity<List<CommentResponse>> responseEntity = 
        restTemplate.exchange(
            Constants.URL_COMMENT,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<CommentResponse>>() {});
        
        List<CommentResponse> comments = responseEntity.getBody();
        List<String> commentsString = comments.stream().map( c -> {
            return c.getPostId()+"|"+c.getId()+"|"+c.getEmail();
        }).collect(Collectors.toList());
        
        response.setData(commentsString);
        return response;
    }
}
