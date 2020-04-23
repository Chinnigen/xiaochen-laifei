package com.cry.common.enums;

/**
 * @program: xiaochen-laofei
 * @description: 操作员枚举
 * @author: Cry
 * @create: 2020-03-23 15:16
 **/
public enum OperEnum {

    /*
    操作员列表
     */
    WEB_MANAGER(0, "WEB端管理员"),
    MANAGER_CHENRIYUAN(1, "管理员-陈日源");

    private Integer operID;

    private String operName;

    OperEnum(Integer operID, String operName) {
        this.operID = operID;
        this.operName = operName;
    }

    public Integer operID() {
        return this.operID;
    }

    public String operName() {
        return this.operName;
    }

    public static String getOperName(String name) {
        for (OperEnum item : OperEnum.values()) {
            if (item.name().equals(name)) {
                return item.operName;
            }
        }
        return name;
    }

    public static Integer getOperID(String name) {
        for (OperEnum item : OperEnum.values()) {
            if (item.name().equals(name)) {
                return item.operID;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
