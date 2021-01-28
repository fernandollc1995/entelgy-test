package com.entelgy.pruebaentelgy.model.response;

import lombok.Data;

@Data
public class Response<T>{
    private T data;
}

