package com.skybox.seven.edustat.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "downloads")
public class DownloadFile {
    @PrimaryKey
    private Integer moduleId;
    @ColumnInfo
    private Integer taskId;
    @ColumnInfo
    private Integer courseId;
    @ColumnInfo
    private String description;
    @ColumnInfo
    private Integer sectionId;
    @ColumnInfo
    private String mimeType;
    @ColumnInfo
    private String fileUrl;
    @ColumnInfo
    private String filename;
    @ColumnInfo
    private String type;
    @ColumnInfo
    private Integer fileSize;
    @ColumnInfo
    private Boolean downloaded = false;
    @Ignore
    private Boolean downloading = false;
    @Ignore
    private Boolean failed = false;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public Boolean getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(Boolean downloaded) {
        this.downloaded = downloaded;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDownloading() {
        return downloading;
    }

    public void setDownloading(Boolean downloading) {
        this.downloading = downloading;
    }

    public Boolean getFailed() {
        return failed;
    }

    public void setFailed(Boolean failed) {
        this.failed = failed;
    }
}
