package com.chrisliu12138.chrisapicommon.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 2023/8/18 - 15:25
 *
 * @author chrisliu12138
 */
@Data
public class UserInterfaceInfoVO implements Serializable {

    /**
     * 剩余调用次数
     */
    private int leftNum;

    /**
     * 总调用次数
     */
    private int totalNum;

    private static final long serialVersionUID = 1L;
}
