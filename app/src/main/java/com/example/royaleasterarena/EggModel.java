package com.example.royaleasterarena;

import android.os.Parcel;
import android.os.Parcelable;

public class EggModel implements Parcelable {
    public static final Creator<Warrior> CREATOR = new Creator<Warrior>() {
        @Override
        public Warrior createFromParcel(Parcel in) {
            return new Warrior(in);
        }

        @Override
        public Warrior[] newArray(int size) {
            return new Warrior[size];
        }
    };
    private String imageEgg;
    private String nameEgg;
    private String caliber;
    private String rarity;
    private int pvEgg;

    public EggModel(String imageEgg, String nameEgg, String caliber,String rarity, int pvEgg) {
        this.imageEgg = imageEgg;
        this.nameEgg = nameEgg;
        this.caliber = caliber;
        this.rarity = rarity;
        this.pvEgg = pvEgg;
    }
    protected EggModel(Parcel in) {
        imageEgg = in.readString();
        nameEgg = in.readString();
        caliber = in.readString();
        rarity = in.readString();
        pvEgg = in.readInt();
    }

    public String getImageEgg() {
        return imageEgg;
    }

    public void setImageEgg(String imageEgg) {
        this.imageEgg = imageEgg;
    }

    public String getNameEgg() {
        return nameEgg;
    }

    public void setNameEgg(String nameEgg) {
        this.nameEgg = nameEgg;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getPvEgg() {
        return pvEgg;
    }

    public void setPvEgg(int pvEgg) {
        this.pvEgg = pvEgg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageEgg);
        dest.writeString(nameEgg);
        dest.writeString(caliber);
        dest.writeString(rarity);
        dest.writeInt(pvEgg);
    }
}
