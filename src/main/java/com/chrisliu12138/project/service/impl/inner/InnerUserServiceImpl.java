package com.chrisliu12138.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chrisliu12138.chrisapicommon.model.entity.User;
import com.chrisliu12138.chrisapicommon.service.InnerUserService;
import com.chrisliu12138.project.common.ErrorCode;
import com.chrisliu12138.project.exception.BusinessException;
import com.chrisliu12138.project.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
//import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

//@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User getInvokeUser(String accessKey) {
        if (StringUtils.isAnyBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", accessKey);
        return userMapper.selectOne(queryWrapper);
    }
}
