package com.BlogApplication.Blog.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ResourceNotFoundException extends RuntimeException  {
    String resourceName;
    String fieldName;
    String fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValue) {
        super(String.format("No %s found with %s = %s", resourceName, fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = String.valueOf(fieldValue);
    }
}
