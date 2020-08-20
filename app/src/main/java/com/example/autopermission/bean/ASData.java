package com.example.autopermission.bean;

public class ASData {
    public static String getData() {
        String data = "[{\n" +
                " \"delay_time\":600,\n" +
                " \"type_id\":2,\n" +
                " \"describe\":\"锁屏显示\",\n" +
                " \"intent\":{\n" +
                "  \"uriData\":\"package&com.xiaoniu.zuilaidian\",\n" +
                "  \"actionName\":\"android.settings.APPLICATION_DETAILS_SETTINGS\"\n" +
                " },\n" +
                " \"step\":[\n" +
                "  {\n" +
                "   \"delay_time\":600,\n" +
                "   \"find_text\":\"通知管理\",\n" +
                "   \"action_type\":\"ACTION_CLICK\",\n" +
                "   \"click_type\":\"parent\",\n" +
                "   \"reality_node_name\":\"android.widget.TextView\",\n" +
                "   \"reality_node_id\":\":id/switchWidget\"\n" +
                "  },{\n" +
                "   \"delay_time\":600,\n" +
                "   \"find_text\":\"允许通知\",\n" +
                "   \"action_type\":\"ACTION_CLICK\",\n" +
                "   \"click_type\":\"child\",\n" +
                "   \"reality_node_name\":\"android.widget.TextView\",\n" +
                "   \"reality_node_id\":\":id/switchWidget\"\n" +
                "  },{\n" +
                "   \"delay_time\":600,\n" +
                "   \"find_text\":\"在锁屏上显示\",\n" +
                "   \"action_type\":\"ACTION_CLICK\",\n" +
                "   \"click_type\":\"child\",\n" +
                "   \"reality_node_name\":\"android.widget.TextView\",\n" +
                "   \"reality_node_id\":\":id/switchWidget\"\n" +
                "  },{\n" +
                "   \"click_type\":\"system\",\n" +
                "   \"delay_time\":600,\n" +
                "   \"action_type\":\"GLOBAL_ACTION_BACK\"\n" +
                "  },{\n" +
                "   \"click_type\":\"system\",\n" +
                "   \"delay_time\":1000,\n" +
                "   \"action_type\":\"GLOBAL_ACTION_BACK\"\n" +
                "  }\n" +
                " ]\n" +
                "},{\n" +
                " \"delay_time\":600,\n" +
                " \"type_id\":4,\n" +
                " \"describe\":\"自启动\",\n" +
                " \"intent\":{\n" +
                "  \"componenPkg\":\"com.coloros.safecenter\",\n" +
                "  \"componenCls\":\"com.coloros.safecenter.startupapp.StartupAppListActivity\"\n" +
                " },\n" +
                " \"step\":[\n" +
                "  {\n" +
                "   \"delay_time\":600,\n" +
                "   \"find_text\":\"最来电\",\n" +
                "   \"action_type\":\"ACTION_CLICK\",\n" +
                "   \"click_type\":\"child\",\n" +
                "   \"reality_node_name\":\"android.widget.TextView\",\n" +
                "   \"reality_node_id\":\":id/switchWidget\"\n" +
                "  },{\n" +
                "   \"click_type\":\"system\",\n" +
                "   \"delay_time\":600,\n" +
                "   \"action_type\":\"GLOBAL_ACTION_BACK\"\n" +
                "  }\n" +
                " ]\n" +
                "},{\n" +
                " \"delay_time\":600,\n" +
                " \"type_id\":5,\n" +
                " \"describe\":\"通知管理\",\n" +
                " \"intent\":{\n" +
                "  \"uriData\":\"package&com.xiaoniu.zuilaidian\",\n" +
                "  \"actionName\":\"android.settings.APPLICATION_DETAILS_SETTINGS\"\n" +
                " },\n" +
                " \"step\":[\n" +
                "  {\n" +
                "   \"delay_time\":600,\n" +
                "   \"find_text\":\"通知管理\",\n" +
                "   \"action_type\":\"ACTION_CLICK\",\n" +
                "   \"click_type\":\"parent\",\n" +
                "   \"reality_node_name\":\"android.widget.TextView\",\n" +
                "   \"reality_node_id\":\":id/switchWidget\"\n" +
                "  },{\n" +
                "   \"delay_time\":600,\n" +
                "   \"find_text\":\"允许通知\",\n" +
                "   \"action_type\":\"ACTION_CLICK\",\n" +
                "   \"click_type\":\"child\",\n" +
                "   \"reality_node_name\":\"android.widget.TextView\",\n" +
                "   \"reality_node_id\":\":id/switchWidget\"\n" +
                "  },{\n" +
                "   \"delay_time\":600,\n" +
                "   \"find_text\":\"在屏幕顶部显示\",\n" +
                "   \"action_type\":\"ACTION_CLICK\",\n" +
                "   \"click_type\":\"child\",\n" +
                "   \"reality_node_name\":\"android.widget.TextView\",\n" +
                "   \"reality_node_id\":\":id/switchWidget\"\n" +
                "  },{\n" +
                "   \"click_type\":\"system\",\n" +
                "   \"delay_time\":600,\n" +
                "   \"action_type\":\"GLOBAL_ACTION_BACK\"\n" +
                "  },{\n" +
                "   \"click_type\":\"system\",\n" +
                "   \"delay_time\":1000,\n" +
                "   \"action_type\":\"GLOBAL_ACTION_BACK\"\n" +
                "  }\n" +
                " ]\n" +
                "}\n" +
                "]";
        return data;
    }
}
