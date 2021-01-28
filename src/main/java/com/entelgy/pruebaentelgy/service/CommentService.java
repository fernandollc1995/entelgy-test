package com.entelgy.pruebaentelgy.service;

import java.util.List;

import com.entelgy.pruebaentelgy.model.response.Response;

public interface CommentService {
    
    public Response<List<String>> loadAllComments();
}
