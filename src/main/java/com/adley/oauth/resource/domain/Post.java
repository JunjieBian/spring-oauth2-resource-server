package com.adley.oauth.resource.domain;

@Data
@Accessors(chain = true)
public class Post implements Serializable {
    private Long id;
    private String title;
    private String content;
}
