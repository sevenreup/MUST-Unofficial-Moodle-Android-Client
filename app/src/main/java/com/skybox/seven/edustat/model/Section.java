package com.skybox.seven.edustat.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

public class Section implements Parcelable {

    @Json(name = "id")
    private Integer id;
    @Json(name = "name")
    private String name;
    @Json(name = "visible")
    private Integer visible;
    @Json(name = "summary")
    private String summary;
    @Json(name = "summaryformat")
    private Integer summaryformat;
    @Json(name = "section")
    private Integer section;
    @Json(name = "hiddenbynumsections")
    private Integer hiddenbynumsections;
    @Json(name = "uservisible")
    private Boolean uservisible;
    @Json(name = "modules")
    private List<Module> modules = new ArrayList<>();

    protected Section(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
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
        if (in.readByte() == 0) {
            section = null;
        } else {
            section = in.readInt();
        }
        if (in.readByte() == 0) {
            hiddenbynumsections = null;
        } else {
            hiddenbynumsections = in.readInt();
        }
        byte tmpUservisible = in.readByte();
        uservisible = tmpUservisible == 0 ? null : tmpUservisible == 1;
    }

    public static final Creator<Section> CREATOR = new Creator<Section>() {
        @Override
        public Section createFromParcel(Parcel in) {
            return new Section(in);
        }

        @Override
        public Section[] newArray(int size) {
            return new Section[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public Integer getHiddenbynumsections() {
        return hiddenbynumsections;
    }

    public void setHiddenbynumsections(Integer hiddenbynumsections) {
        this.hiddenbynumsections = hiddenbynumsections;
    }

    public Boolean getUservisible() {
        return uservisible;
    }

    public void setUservisible(Boolean uservisible) {
        this.uservisible = uservisible;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
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
        dest.writeString(name);
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
        if (section == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(section);
        }
        if (hiddenbynumsections == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(hiddenbynumsections);
        }
        dest.writeByte((byte) (uservisible == null ? 0 : uservisible ? 1 : 2));
    }
}