package com.hts.report.util;

public class FilterUtil {

    public static String exchangeDataType(String dataType) {
        String filterDataType = null;
        switch (dataType) {
            case "int":
                filterDataType = "number";
                break;
            case "smallint":
                filterDataType = "number";
                break;
            case "mediumint":
                filterDataType = "number";
                break;
            case "float":
                filterDataType = "number";
                break;
            case "bigint":
                filterDataType = "number";
                break;
            case "double":
                filterDataType = "number";
                break;
            case "datetime":
                filterDataType = "date";
                break;
            case "date":
                filterDataType = "date";
                break;
            case "timestamp":
                filterDataType = "date";
                break;
            case "char":
                filterDataType = "string";
                break;
            case "varchar":
                filterDataType = "string";
                break;
            case "text":
                filterDataType = "string";
                break;
            case "tinyint":
                filterDataType = "boolean";
                break;

            default:
                break;
        }
        return filterDataType;
    }
}
