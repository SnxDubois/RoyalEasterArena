package com.example.royaleasterarena;

import android.os.Parcel;
import android.os.Parcelable;

public class Warrior implements Parcelable {

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
    private String image;
    private String name;
    private String species;
    private String gender;
    private String origin;
    private int pv;
    private int attack;

    public Warrior(String image, String name, String species, String gender, String origin, int pv, int attack) {
        this.image = image;
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.origin = origin;
        this.pv = pv;
        this.attack = attack;
    }

    protected Warrior(Parcel in) {
        image = in.readString();
        name = in.readString();
        species = in.readString();
        gender = in.readString();
        origin = in.readString();
        pv = in.readInt();
        attack = in.readInt();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
        dest.writeString(name);
        dest.writeString(species);
        dest.writeString(gender);
        dest.writeString(origin);
        dest.writeInt(pv);
        dest.writeInt(attack);
    }
}
