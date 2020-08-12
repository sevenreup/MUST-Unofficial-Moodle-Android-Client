package com.skybox.seven.edustat.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.squareup.moshi.Json;

public class Course implements Parcelable {

    @Json(name = "id")
    private Integer id;
    @Json(name = "shortname")
    private String shortname;
    @Json(name = "fullname")
    private String fullname;
    @Json(name = "displayname")
    private String displayname;
    @Json(name = "enrolledusercount")
    private Integer enrolledusercount;
    @Json(name = "idnumber")
    private String idnumber;
    @Json(name = "visible")
    private Integer visible;
    @Json(name = "summary")
    private String summary;
    @Json(name = "summaryformat")
    private Integer summaryformat;
    @Json(name = "format")
    private String format;
    @Json(name = "showgrades")
    private Boolean showgrades;
    @Json(name = "lang")
    private String lang;
    @Json(name = "enablecompletion")
    private Boolean enablecompletion;
    @Json(name = "completionhascriteria")
    private Boolean completionhascriteria;
    @Json(name = "completionusertracked")
    private Boolean completionusertracked;
    @Json(name = "category")
    private Integer category;
    @Json(name = "progress")
    private Double progress;
    @Json(name = "completed")
    private Boolean completed;
    @Json(name = "startdate")
    private Integer startdate;
    @Json(name = "enddate")
    private Integer enddate;
    @Json(name = "marker")
    private Integer marker;
    @Json(name = "lastaccess")
    private Integer lastaccess;
    @Json(name = "isfavourite")
    private Boolean isfavourite;
    @Json(name = "hidden")
    private Boolean hidden;

    protected Course(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        shortname = in.readString();
        fullname = in.readString();
        displayname = in.readString();
        if (in.readByte() == 0) {
            enrolledusercount = null;
        } else {
            enrolledusercount = in.readInt();
        }
        idnumber = in.readString();
        if (in.readByte() == 0) {
            visible = null;
        } else {
            visible = in.readInt();
        }
        summary = in.readString();
        if (in.readByte() == 0) {
            summaryformat = null;
        } else {
            summaryformat = in.readInt();
        }
        format = in.readString();
        byte tmpShowgrades = in.readByte();
        showgrades = tmpShowgrades == 0 ? null : tmpShowgrades == 1;
        lang = in.readString();
        byte tmpEnablecompletion = in.readByte();
        enablecompletion = tmpEnablecompletion == 0 ? null : tmpEnablecompletion == 1;
        byte tmpCompletionhascriteria = in.readByte();
        completionhascriteria = tmpCompletionhascriteria == 0 ? null : tmpCompletionhascriteria == 1;
        byte tmpCompletionusertracked = in.readByte();
        completionusertracked = tmpCompletionusertracked == 0 ? null : tmpCompletionusertracked == 1;
        if (in.readByte() == 0) {
            category = null;
        } else {
            category = in.readInt();
        }
        if (in.readByte() == 0) {
            progress = null;
        } else {
            progress = in.readDouble();
        }
        byte tmpCompleted = in.readByte();
        completed = tmpCompleted == 0 ? null : tmpCompleted == 1;
        if (in.readByte() == 0) {
            startdate = null;
        } else {
            startdate = in.readInt();
        }
        if (in.readByte() == 0) {
            enddate = null;
        } else {
            enddate = in.readInt();
        }
        if (in.readByte() == 0) {
            marker = null;
        } else {
            marker = in.readInt();
        }
        if (in.readByte() == 0) {
            lastaccess = null;
        } else {
            lastaccess = in.readInt();
        }
        byte tmpIsfavourite = in.readByte();
        isfavourite = tmpIsfavourite == 0 ? null : tmpIsfavourite == 1;
        byte tmpHidden = in.readByte();
        hidden = tmpHidden == 0 ? null : tmpHidden == 1;
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public Integer getEnrolledusercount() {
        return enrolledusercount;
    }

    public void setEnrolledusercount(Integer enrolledusercount) {
        this.enrolledusercount = enrolledusercount;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getSummaryformat() {
        return summaryformat;
    }

    public void setSummaryformat(Integer summaryformat) {
        this.summaryformat = summaryformat;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Boolean getShowgrades() {
        return showgrades;
    }

    public void setShowgrades(Boolean showgrades) {
        this.showgrades = showgrades;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Boolean getEnablecompletion() {
        return enablecompletion;
    }

    public void setEnablecompletion(Boolean enablecompletion) {
        this.enablecompletion = enablecompletion;
    }

    public Boolean getCompletionhascriteria() {
        return completionhascriteria;
    }

    public void setCompletionhascriteria(Boolean completionhascriteria) {
        this.completionhascriteria = completionhascriteria;
    }

    public Boolean getCompletionusertracked() {
        return completionusertracked;
    }

    public void setCompletionusertracked(Boolean completionusertracked) {
        this.completionusertracked = completionusertracked;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Integer getStartdate() {
        return startdate;
    }

    public void setStartdate(Integer startdate) {
        this.startdate = startdate;
    }

    public Integer getEnddate() {
        return enddate;
    }

    public void setEnddate(Integer enddate) {
        this.enddate = enddate;
    }

    public Integer getMarker() {
        return marker;
    }

    public void setMarker(Integer marker) {
        this.marker = marker;
    }

    public Integer getLastaccess() {
        return lastaccess;
    }

    public void setLastaccess(Integer lastaccess) {
        this.lastaccess = lastaccess;
    }

    public Boolean getIsfavourite() {
        return isfavourite;
    }

    public void setIsfavourite(Boolean isfavourite) {
        this.isfavourite = isfavourite;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(shortname);
        dest.writeString(fullname);
        dest.writeString(displayname);
        if (enrolledusercount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(enrolledusercount);
        }
        dest.writeString(idnumber);
        if (visible == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(visible);
        }
        dest.writeString(summary);
        if (summaryformat == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(summaryformat);
        }
        dest.writeString(format);
        dest.writeByte((byte) (showgrades == null ? 0 : showgrades ? 1 : 2));
        dest.writeString(lang);
        dest.writeByte((byte) (enablecompletion == null ? 0 : enablecompletion ? 1 : 2));
        dest.writeByte((byte) (completionhascriteria == null ? 0 : completionhascriteria ? 1 : 2));
        dest.writeByte((byte) (completionusertracked == null ? 0 : completionusertracked ? 1 : 2));
        if (category == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(category);
        }
        if (progress == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(progress);
        }
        dest.writeByte((byte) (completed == null ? 0 : completed ? 1 : 2));
        if (startdate == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(startdate);
        }
        if (enddate == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(enddate);
        }
        if (marker == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(marker);
        }
        if (lastaccess == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(lastaccess);
        }
        dest.writeByte((byte) (isfavourite == null ? 0 : isfavourite ? 1 : 2));
        dest.writeByte((byte) (hidden == null ? 0 : hidden ? 1 : 2));
    }
}