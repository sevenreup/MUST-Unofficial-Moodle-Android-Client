package com.skybox.seven.edustat.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.squareup.moshi.Json;

@Entity(tableName = "site")
public class Site {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo
    @Json(name="sitename")
    private String siteName;

    @ColumnInfo
    @Json(name="username")
    private String userName;

    @ColumnInfo
    @Json(name="firstname")
    private String firstName;

    @ColumnInfo
    @Json(name="lastname")
    private String lastName;

    @ColumnInfo
    @Json(name="fullname")
    private String fullName;

    @ColumnInfo
    @Json(name="lang")
    private String lang;

    @ColumnInfo
    @Json(name="userid")
    private Integer userId;

    @Json(name="siteurl")
    @ColumnInfo
    private String siteUrl;

    @ColumnInfo
    @Json(name="userpictureurl")
    private String userPicture;

    @ColumnInfo
    @Json(name="downloadfiles")
    private Integer downloadFiles;

    @ColumnInfo
    @Json(name="uploadfiles")
    private Integer uploadFiles;

    @ColumnInfo
    @Json(name="release")
    private String release;

    @ColumnInfo
    @Json(name="version")
    private String version;

    @ColumnInfo
    @Json(name="mobilecssurl")
    private String mobileCssUrl;

    @ColumnInfo
    @Json(name="usercanmanageownfiles")
    private Boolean userCanManageOwnFiles;

    @ColumnInfo
    @Json(name="userquota")
    private Integer UserQuota;

    @ColumnInfo
    @Json(name="usermaxuploadfilesize")
    private Integer UserMaxUploadFileSize;

    @ColumnInfo
    @Json(name="userhomepage")
    private Integer userHomepage;

    @ColumnInfo
    @Json(name="siteid")
    private Integer siteId;

    @ColumnInfo
    @Json(name="sitecalendartype")
    private String siteCalendarType;

    @ColumnInfo
    @Json(name="usercalendartype")
    private String UserCalendarType;

    @ColumnInfo
    @Json(name="theme")
    private String theme;


    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public Integer getDownloadFiles() {
        return downloadFiles;
    }

    public void setDownloadFiles(Integer downloadFiles) {
        this.downloadFiles = downloadFiles;
    }

    public Integer getUploadFiles() {
        return uploadFiles;
    }

    public void setUploadFiles(Integer uploadFiles) {
        this.uploadFiles = uploadFiles;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMobileCssUrl() {
        return mobileCssUrl;
    }

    public void setMobileCssUrl(String mobileCssUrl) {
        this.mobileCssUrl = mobileCssUrl;
    }

    public Boolean getUserCanManageOwnFiles() {
        return userCanManageOwnFiles;
    }

    public void setUserCanManageOwnFiles(Boolean userCanManageOwnFiles) {
        this.userCanManageOwnFiles = userCanManageOwnFiles;
    }

    public Integer getUserQuota() {
        return UserQuota;
    }

    public void setUserQuota(Integer userQuota) {
        UserQuota = userQuota;
    }

    public Integer getUserMaxUploadFileSize() {
        return UserMaxUploadFileSize;
    }

    public void setUserMaxUploadFileSize(Integer userMaxUploadFileSize) {
        UserMaxUploadFileSize = userMaxUploadFileSize;
    }

    public Integer getUserHomepage() {
        return userHomepage;
    }

    public void setUserHomepage(Integer userHomepage) {
        this.userHomepage = userHomepage;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getSiteCalendarType() {
        return siteCalendarType;
    }

    public void setSiteCalendarType(String siteCalendarType) {
        this.siteCalendarType = siteCalendarType;
    }

    public String getUserCalendarType() {
        return UserCalendarType;
    }

    public void setUserCalendarType(String userCalendarType) {
        UserCalendarType = userCalendarType;
    }

    public String getTheme() {
        return theme;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}