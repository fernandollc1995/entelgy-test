package com.entelgy.pruebaentelgy.model.response;

import lombok.Data;

@Data
public class CommentResponse {
    
    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;

}
