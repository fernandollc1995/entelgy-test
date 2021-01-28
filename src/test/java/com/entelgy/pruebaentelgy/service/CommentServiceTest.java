package com.entelgy.pruebaentelgy.service;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class CommentServiceTest {
    
    @Autowired
    CommentService commentService;

    @Test
    public void loadAllCommentsServiceTest() {
        List<String> data = commentService.loadAllComments().getData();
        Assert.assertEquals("1|1|Eliseo@gardner.biz", data.get(0));
    }
}
