package com.jim.data.model.domain;

/**
 * Author: Jim
 * Date: 2018/8/3:下午5:54
 * Description:
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {
    private static final Integer DEFAULT_PAGE_SIZE = 10;

    private static final Integer DEFAULT_CURRENT = 1;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    @ApiModelProperty(value = "当前页号")
    private Integer current = DEFAULT_CURRENT;

    @ApiModelProperty(value = "总条数")
    private Long total;

    @ApiModelProperty(value = "总页数")
    private Integer totalPageNum;
}
