package com.cry.common.constant;

/**
* @Description:  常用正则表达式
* @Author: Cry
* @Date: 2020-03-23
*/
public enum RegexpEnum {

    /* 成功状态码 */
    DATE_REGEXP("((\\d{2}(([02468][048])|([13579][26]))[\\-]((((0?[13578])|(1[02]))[\\-]((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-]((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-]((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-]((((0?[13578])|(1[02]))[\\-]((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-]((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-]((0?[1-9])|(1[0-9])|(2[0-8]))))))\n", "日期YYYY-MM-DD正则"),
    DATETIME_REGEXP("((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s((([0-1][0-9])|(2?[0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))", "日期YYYY-MM-DD HH:mm:ss正则"),
    ID_NUMBER_REGEXP("(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)", "大陆身份证号码正则");

    private String regexpStr;

    private String description;

    RegexpEnum(String regexpStr, String description) {
        this.regexpStr = regexpStr;
        this.description = description;
    }

    public String regexpStr() {
        return this.regexpStr;
    }

    public String description() {
        return this.description;
    }

    public static String getDescription(String name) {
        for (RegexpEnum item : RegexpEnum.values()) {
            if (item.name().equals(name)) {
                return item.description;
            }
        }
        return name;
    }

    public static String getRegexpStr(String name) {
        for (RegexpEnum item : RegexpEnum.values()) {
            if (item.name().equals(name)) {
                return item.regexpStr;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
