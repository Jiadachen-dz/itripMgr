package cn.bdqn.itrip.utils;

import java.util.List;

public class PageBean<T> {
    /**
     * 页码
     */
    private int pageIndex;
    /**
     * 页面容量
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 总数量
     */
    private int totalCount;

    /**
     * 查询到的数据集合
     */
    private List<T> list;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        if (pageIndex<1){
            this.pageIndex =1;
        }else if (pageIndex>totalPage){
            this.pageIndex =totalPage;
        }else {
            this.pageIndex = pageIndex;
        }
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize<1){
            this.pageSize = 1;
        }else {
            this.pageSize = pageSize;
        }
        setTotalPage();
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage() {
        this.totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getStartRow(){
        return (pageIndex-1)*pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
