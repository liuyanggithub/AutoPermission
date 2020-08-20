package com.example.autopermission.bean;

import java.io.Serializable;
import java.util.List;

public class ASBase implements Serializable {

    /**
     * 行为延迟时间
     */
    public int delay_time;
    /**
     * 大分类ID
     */
    public int type_id;
    /**
     * 描述
     */
    public String describe;
    public ASIntentBean intent;
    public List<ASStepBean> step;


}
