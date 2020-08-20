package com.example.autopermission.bean;

import java.io.Serializable;

public class ASStepBean implements Serializable {

    /**
     * 一步需要的延迟时间
     */
    public int delay_time;
    /**
     * 需要找到的文本
     */
    public String find_text;
    /**
     * 行为(点击, 选择)
     */
    public String action_type;
    /**
     *   //点击类型,parent 点击这个控件的父容器,child点击指定的控件(reality_node_id 不能为空,findId=true 采用 accessibilityNodeInfosByViewId方式) system,点击系统的返回按键,self 点击自己
     */
    public String click_type;
    /**
     * 精确查找
     */
    public boolean findId;
    /**
     * 禁止滚动
     */
    public boolean banScrollable;
    /**
     * 控件无法点击的提示文案
     */
    public String clickFailToast;
    public String reality_node_name;
    /**
     * 查找的ID findId为true 时reality_node_id为全路径ID
     */
    public String reality_node_id;
    /**
     * 指定滚动的控件ID
     */
    public String reality_scrollable_node_id;
    /**
     * 本次任务如果已经完成则移除下一步任务
     */
    public boolean checkedRemoveNext;

    public int getDelay_time() {
        return delay_time;
    }

    public void setDelay_time(int delay_time) {
        this.delay_time = delay_time;
    }

    public String getFind_text() {
        return find_text;
    }

    public void setFind_text(String find_text) {
        this.find_text = find_text;
    }

    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }

    public String getClick_type() {
        return click_type;
    }

    public void setClick_type(String click_type) {
        this.click_type = click_type;
    }

    public String getReality_node_name() {
        return reality_node_name;
    }

    public void setReality_node_name(String reality_node_name) {
        this.reality_node_name = reality_node_name;
    }

    public String getReality_node_id() {
        return reality_node_id;
    }

    public void setReality_node_id(String reality_node_id) {
        this.reality_node_id = reality_node_id;
    }

    public boolean isFindId() {
        return findId;
    }

    public void setFindId(boolean findId) {
        this.findId = findId;
    }

    public String getReality_scrollable_node_id() {
        return reality_scrollable_node_id;
    }

    public void setReality_scrollable_node_id(String reality_scrollable_node_id) {
        this.reality_scrollable_node_id = reality_scrollable_node_id;
    }

    public boolean isBanScrollable() {
        return banScrollable;
    }

    public void setBanScrollable(boolean banScrollable) {
        this.banScrollable = banScrollable;
    }

    public boolean isCheckedRemoveNext() {
        return checkedRemoveNext;
    }

    public void setCheckedRemoveNext(boolean checkedRemoveNext) {
        this.checkedRemoveNext = checkedRemoveNext;
    }

    public String getClickFailToast() {
        return clickFailToast;
    }

    public void setClickFailToast(String clickFailToast) {
        this.clickFailToast = clickFailToast;
    }


}