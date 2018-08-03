package com.jim.data.model.domain;

/**
 * Author: Jim
 * Date: 2018/8/3:下午5:53
 * Description:
 */

import com.github.pagehelper.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class G2Page<T> extends Pagination implements Serializable {
    private List<T> list = new ArrayList<>();

    public G2Page() {
        super();
    }

    public G2Page(Page page) {
        super();
        this.list = page.getResult();
        super.setCurrent(page.getPageNum());
        super.setPageSize(page.getPageSize());
        super.setTotal(page.getTotal());
    }

    public G2Page(List<T> list, Page page) {
        super();
        this.list = list;
        super.setCurrent(page.getPageNum());
        super.setPageSize(page.getPageSize());
        super.setTotal(page.getTotal());
    }

    public G2Page(List<T> list, Integer current, Integer pageSize, Long total) {
        super();
        this.list = list;
        super.setCurrent(current);
        super.setPageSize(pageSize);
        super.setTotal(total);
    }
}
