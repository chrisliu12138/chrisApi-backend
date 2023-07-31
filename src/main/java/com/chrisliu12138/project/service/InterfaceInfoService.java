package com.chrisliu12138.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chrisliu12138.project.model.entity.InterfaceInfo;

/**
 * 接口信息服务
 *
 * @author <a href="https://github.com/lichrisliu12138">chrisliu12138</a>
 * @from <a href="https://chrisliu12138.icu">编程导航知识星球</a>
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
