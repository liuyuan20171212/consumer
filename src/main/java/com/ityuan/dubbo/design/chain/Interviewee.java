package com.ityuan.dubbo.design.chain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 面试者
 *
 * @Author ityuan
 * @Date 2019-06-28 15:47
 */
@Data
@AllArgsConstructor
public class Interviewee {
    /**
     * 姓名
     */
    private String name;

    /**
     * 是否有下一步
     */
    private boolean hasNext;

}
