package com.burakcetn.n11bootcampcohorthw2.errorHandler;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class GenericRestResponse<T> {
    private T data;
    private LocalDateTime responseDate;
    private boolean isSuccess;
    private String messages;

    public GenericRestResponse(T data, boolean isSuccess){
        this.data = data;
        this.isSuccess = isSuccess;
        this.responseDate = LocalDateTime.now();
    }
    public static <T> GenericRestResponse<T> of(T t){
        return  new GenericRestResponse<>(t,true);
    }
    public static <T> GenericRestResponse<T> error(T t){
        return  new GenericRestResponse<>(t,false);
    }
    public static <T> GenericRestResponse<T> empty(T t){
        return  new GenericRestResponse<>(null,true);
    }

}
