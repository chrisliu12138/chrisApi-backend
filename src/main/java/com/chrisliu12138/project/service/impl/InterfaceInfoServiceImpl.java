package com.chrisliu12138.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chrisliu12138.project.common.ErrorCode;
import com.chrisliu12138.project.exception.BusinessException;
import com.chrisliu12138.project.mapper.InterfaceInfoMapper;
import com.chrisliu12138.project.service.InterfaceInfoService;
import com.chrisliu12138.project.model.entity.InterfaceInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 接口信息服务实现类
 *
 * @author <a href="https://github.com/lichrisliu12138">chrisliu12138</a>
 * @from <a href="https://chrisliu12138.icu">编程导航知识星球</a>
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        String name = interfaceInfo.getName();
        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }
    
}




