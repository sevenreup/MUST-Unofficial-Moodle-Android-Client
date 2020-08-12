package com.skybox.seven.edustat.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

import java.util.ArrayList;
import java.util.List;

public class Member implements Parcelable {

    @Json(name = "id")
    private Integer id;
    @Json(name = "fullname")
    private String fullname;
    @Json(name = "profileurl")
    private String profileurl;
    @Json(name = "profileimageurl")
    private String profileimageurl;
    @Json(name = "profileimageurlsmall")
    private String profileimageurlsmall;
    @Json(name = "isonline")
    private Boolean isonline;
    @Json(name = "showonlinestatus")
    private Boolean showonlinestatus;
    @Json(name = "isblocked")
    private Boolean isblocked;
    @Json(name = "iscontact")
    private Boolean iscontact;
    @Json(name = "isdeleted")
    private Boolean isdeleted;
    @Json(name = "canmessage")
    private Object canmessage;
    @Json(name = "requirescontact")
    private Object requirescontact;
    @Json(name = "contactrequests")
    private List<Object> contactrequests = new ArrayList<>();

    protected Member(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        fullname = in.readString();
        profileurl = in.readString();
        profileimageurl = in.readString();
        profileimageurlsmall = in.readString();
        byte tmpIsonline = in.readByte();
        isonline = tmpIsonline == 0 ? null : tmpIsonline == 1;
        byte tmpShowonlinestatus = in.readByte();
        showonlinestatus = tmpShowonlinestatus == 0 ? null : tmpShowonlinestatus == 1;
        byte tmpIsblocked = in.readByte();
        isblocked = tmpIsblocked == 0 ? null : tmpIsblocked == 1;
        byte tmpIscontact = in.readByte();
        iscontact = tmpIscontact == 0 ? null : tmpIscontact == 1;
        byte tmpIsdeleted = in.readByte();
        isdeleted = tmpIsdeleted == 0 ? null : tmpIsdeleted == 1;
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel in) {
            return new Member(in);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }

    public String getProfileimageurl() {
        return profileimageurl;
    }

    public void setProfileimageurl(String profileimageurl) {
        this.profileimageurl = profileimageurl;
    }

    public String getProfileimageurlsmall() {
        return profileimageurlsmall;
    }

    public void setProfileimageurlsmall(String profileimageurlsmall) {
        this.profileimageurlsmall = profileimageurlsmall;
    }

    public Boolean getIsonline() {
        return isonline;
    }

    public void setIsonline(Boolean isonline) {
        this.isonline = isonline;
    }

    public Boolean getShowonlinestatus() {
        return showonlinestatus;
    }

    public void setShowonlinestatus(Boolean showonlinestatus) {
        this.showonlinestatus = showonlinestatus;
    }

    public Boolean getIsblocked() {
        return isblocked;
    }

    public void setIsblocked(Boolean isblocked) {
        this.isblocked = isblocked;
    }

    public Boolean getIscontact() {
        return iscontact;
    }

    public void setIscontact(Boolean iscontact) {
        this.iscontact = iscontact;
    }

    public Boolean getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    public Object getCanmessage() {
        return canmessage;
    }

    public void setCanmessage(Object canmessage) {
        this.canmessage = canmessage;
    }

    public Object getRequirescontact() {
        return requirescontact;
    }

    public void setRequirescontact(Object requirescontact) {
        this.requirescontact = requirescontact;
    }

    public List<Object> getContactrequests() {
        return contactrequests;
    }

    public void setContactrequests(List<Object> contactrequests) {
        this.contactrequests = contactrequests;
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
        dest.writeString(fullname);
        dest.writeString(profileurl);
        dest.writeString(profileimageurl);
        dest.writeString(profileimageurlsmall);
        dest.writeByte((byte) (isonline == null ? 0 : isonline ? 1 : 2));
        dest.writeByte((byte) (showonlinestatus == null ? 0 : showonlinestatus ? 1 : 2));
        dest.writeByte((byte) (isblocked == null ? 0 : isblocked ? 1 : 2));
        dest.writeByte((byte) (iscontact == null ? 0 : iscontact ? 1 : 2));
        dest.writeByte((byte) (isdeleted == null ? 0 : isdeleted ? 1 : 2));
    }
}
