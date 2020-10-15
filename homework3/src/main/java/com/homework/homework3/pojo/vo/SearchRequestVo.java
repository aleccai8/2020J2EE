package com.homework.homework3.pojo.vo;

/**
 * @author zhengheng7913
 */
public class SearchRequestVo {

    private String param;

    private String option;

    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getOption() {
        return option;
    }

    public String getParam() {
        return param;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setParam(String param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "SearchRequestVo{" +
                "param='" + param + '\'' +
                ", option='" + option + '\'' +
                '}';
    }
}
