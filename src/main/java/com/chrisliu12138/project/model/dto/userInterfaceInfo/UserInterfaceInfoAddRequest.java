package com.chrisliu12138.project.model.dto.userInterfaceInfo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInterfaceInfoAddRequest implements Serializable {

    /**
     * 调用用户 id
     */
    private Long userId;

    /**
     * 接口 id
     */
    private Long interfaceInfoId;

    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

}