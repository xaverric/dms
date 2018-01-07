package cz.uhk.fim.repository.types.api;

import java.util.HashMap;
import java.util.Map;

public enum FileTypeEnum {

    JPEG("jpeg", FileTypeCategory.IMAGE),
    JPG("jpg", FileTypeCategory.IMAGE),
    PNG("png", FileTypeCategory.IMAGE),
    GIF("gif", FileTypeCategory.IMAGE),
    TIFF("tiff", FileTypeCategory.IMAGE),
    BMP("bpm", FileTypeCategory.IMAGE),

    TXT("txt", FileTypeCategory.DOCUMENT),
    PDF("pdf", FileTypeCategory.DOCUMENT),
    XML("xml", FileTypeCategory.DOCUMENT),
    DOC("doc", FileTypeCategory.DOCUMENT),
    XLS("xls", FileTypeCategory.DOCUMENT),
    DOCX("docx",FileTypeCategory.DOCUMENT),
    XLSX("xlsx", FileTypeCategory.DOCUMENT),

    JAVA("java", FileTypeCategory.DOCUMENT),
    CLASS("class", FileTypeCategory.CODE),
    C("c",FileTypeCategory.CODE),
    CPP("cpp", FileTypeCategory.CODE),

    AVI("avi", FileTypeCategory.VIDEO),
    MOV("mov", FileTypeCategory.VIDEO),
    FLV("flv", FileTypeCategory.VIDEO),
    WMV("wmv", FileTypeCategory.VIDEO);

    private static final Map<String, FileTypeEnum> categoryLookup = new HashMap();

    static {
        for(FileTypeEnum d : FileTypeEnum.values())
            categoryLookup.put(d.getSuffix(), d);
    }

    private String suffix;
    private String category;

    FileTypeEnum(String suffix, FileTypeCategory category) {
        this.suffix = suffix;
        this.category = category.toString();
    }

    public static String getCategoryBySuffix(String suffix){
        return categoryLookup.get(suffix).getCategory();
    }

    public String getSuffix() {
        return suffix;
    }

    public String getCategory() {
        return category;
    }


}
