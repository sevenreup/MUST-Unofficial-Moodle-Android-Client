package com.skybox.seven.edustat.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

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
    private String filePath;
    @ColumnInfo
    private Boolean downloaded = false;
    @Ignore
    String status;
    @Ignore
    DownloadStatus downloadStatus = DownloadStatus.IDLE;
    @Ignore
    Long progress = 0L;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DownloadStatus getDownloadStatus() {
        return downloadStatus;
    }

    public void setDownloadStatus(DownloadStatus downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    public Long getProgress() {
        return progress;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DownloadFile)) return false;
        DownloadFile that = (DownloadFile) o;
        return getModuleId().equals(that.getModuleId()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                getDownloadStatus() == that.getDownloadStatus() &&
                Objects.equals(getProgress(), that.getProgress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModuleId(), getStatus(), getDownloadStatus(), getProgress());
    }
}

