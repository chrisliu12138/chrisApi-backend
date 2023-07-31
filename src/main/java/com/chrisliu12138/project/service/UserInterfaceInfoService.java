package com.chrisliu12138.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chrisliu12138.project.model.entity.UserInterfaceInfo;

/**
 * 用户接口信息服务
 *
 * @author <a href="https://github.com/lichrisliu12138">chrisliu12138</a>
 * @from <a href="https://chrisliu12138.icu">编程导航知识星球</a>
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
