package com.cry.common.utils;


import com.byteblogs.helloblog.dto.PageInfo;
import com.cry.common.base.BaseVO;
import com.cry.common.base.constants.Constants;
import com.github.pagehelper.Page;

/**
 * @author: byteblogs
 * @date: 2019/8/3 14:57
 */
public class PageUtil {

    public static Page checkAndInitPage(BaseVO baseVO) {
        if (baseVO.getPage() == null) {
            baseVO.setPage(Constants.DEFAULT_PAGE_INDEX);
        }
        if (baseVO.getSize() == null) {
            baseVO.setSize(Constants.DEFAULT_PAGE_SIZE);
        }

        return new Page(baseVO.getPage(), baseVO.getSize());
    }

    public static Page initPage() {
        return new Page(Constants.DEFAULT_PAGE_INDEX, Constants.DEFAULT_PAGE_SIZE);
    }

    public static PageInfo initPageInfo(Page page) {
        if (page != null) {
            return new PageInfo().setPage(1).setSize(page.getPageSize()).setTotal(page.getTotal());
        }
        return null;
    }
}
