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

    JAVA("java", FileTypeCategory.CODE),
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
    private FileTypeCategory categoryType;

    FileTypeEnum(String suffix, FileTypeCategory category) {
        this.suffix = suffix;
        this.category = category.toString();
        this.categoryType = category;
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

    public String getName() {
        String name = "";
        switch (this.getFileTypeCategory()) {
            case CODE:
                name = "Code";
                break;
            case IMAGE:
                name = "Image";
                break;
            case DOCUMENT:
                name = "Document";
                break;
            case VIDEO:
                name = "Video";
                break;
        }
        return name;
    }

    public String getDesc() {
        String desc = "";
        switch (this.getFileTypeCategory()) {
            case IMAGE:
                desc = "File type image or photo";
                break;
            case DOCUMENT:
                desc = "Document file for texts";
                break;
            case CODE:
                desc = "File that contains source code for the programs";
                break;
            case VIDEO:
                desc = "File containing a video record";
                break;
        }
        return desc;
    }
    
    private FileTypeCategory getFileTypeCategory(){
        return categoryType;
    }

}
