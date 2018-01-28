package cz.uhk.fim.repository.types.api;

public enum FileTypeSuffix {

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

    private String suffix;
    private String category;

    FileTypeSuffix(String suffix, FileTypeCategory category) {
        this.suffix = suffix;
        this.category = category.toString();
    }

    public String getSuffx() {
        return suffix;
    }

    public String getCategory() {
        return category;
    }


}
