package com.bjpowernode.crm.vo;

import java.util.List;

public class PaginationVO<T> {
    private long total;
    private List<T> dataList;

    public long getTotal() {
        return total;
    }

    public PaginationVO(long total, List<T> dataList) {
        this.total = total;
        this.dataList = dataList;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
