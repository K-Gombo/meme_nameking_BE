package com.sparta.meme_nameking.dto;

import com.sparta.meme_nameking.entity.Post;
import com.sun.tools.javac.Main;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class MainPageResponseDto {

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = true)
    private String bestComment;

    // 게시글 등록 완성되면 수정하면 될 부분
    @Column(nullable = true)
    private String imageUrl;

    @Column(nullable = true)
    private int postDdabong;

    public MainPageResponseDto(Post post, String bestComment){
        this.postId = post.getId();
        this.bestComment = bestComment;
        this.imageUrl = post.getImageUrl();
        this.postDdabong = post.getDdabong();
    }
}
