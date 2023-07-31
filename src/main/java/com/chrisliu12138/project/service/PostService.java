package com.chrisliu12138.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chrisliu12138.project.model.entity.Post;

/**
 * 帖子服务
 *
 * @author <a href="https://github.com/lichrisliu12138">chrisliu12138</a>
 * @from <a href="https://chrisliu12138.icu">编程导航知识星球</a>
 */
public interface PostService extends IService<Post> {

    /**
     * 校验
     *
     * @param post
     * @param add 是否为创建校验
     */
    void validPost(Post post, boolean add);
}
