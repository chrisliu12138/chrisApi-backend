package com.chrisliu12138.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chrisliu12138.project.common.ErrorCode;
import com.chrisliu12138.project.exception.BusinessException;
import com.chrisliu12138.project.mapper.PostMapper;
import com.chrisliu12138.project.model.entity.Post;
import com.chrisliu12138.project.model.enums.PostGenderEnum;
import com.chrisliu12138.project.model.enums.PostReviewStatusEnum;
import com.chrisliu12138.project.service.PostService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 帖子服务实现类
 *
 * @author <a href="https://github.com/lichrisliu12138">chrisliu12138</a>
 * @from <a href="https://chrisliu12138.icu">编程导航知识星球</a>
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Override
    public void validPost(Post post, boolean add) {
        if (post == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Integer age = post.getAge();
        Integer gender = post.getGender();
        String content = post.getContent();
        String job = post.getJob();
        String place = post.getPlace();
        String education = post.getEducation();
        String loveExp = post.getLoveExp();
        Integer reviewStatus = post.getReviewStatus();
        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(content, job, place, education, loveExp) || ObjectUtils.anyNull(age, gender)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(content) && content.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "内容过长");
        }
        if (reviewStatus != null && !PostReviewStatusEnum.getValues().contains(reviewStatus)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if (age != null && (age < 18 || age > 100)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "年龄不符合要求");
        }
        if (gender != null && !PostGenderEnum.getValues().contains(gender)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "性别不符合要求");
        }
    }
}




