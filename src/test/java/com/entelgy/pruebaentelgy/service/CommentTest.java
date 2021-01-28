package com.entelgy.pruebaentelgy.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.entelgy.pruebaentelgy.model.response.CommentResponse;
import com.entelgy.pruebaentelgy.service.impl.CommentServiceImpl;
import com.utils.Constants;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;


@RunWith(MockitoJUnitRunner.class)
public class CommentTest{

    @InjectMocks
    private CommentService commentService = new CommentServiceImpl();
    
    @Mock
    private RestTemplate restTemplate;

    @Test
    public void loadAllCommentsServiceTestU()
    {
        List<CommentResponse> commentsResponse = new ArrayList<>();
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setPostId(1);
        commentResponse.setId(1);
        commentResponse.setName("id labore ex et quam laborum");
        commentResponse.setEmail("Eliseo@gardner.biz");
        commentResponse.setBody("laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium");
        commentsResponse.add(commentResponse);

        when(
            restTemplate.exchange(
                Constants.URL_COMMENT,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CommentResponse>>() {}
            )
        ).thenReturn(
            new ResponseEntity<List<CommentResponse>>(commentsResponse, HttpStatus.OK)
        );
    
        List<String> comments = commentService.loadAllComments().getData();
        Assert.assertEquals("1|1|Eliseo@gardner.biz", comments.get(0));
        Assert.assertEquals(1, comments.size());
    }

}