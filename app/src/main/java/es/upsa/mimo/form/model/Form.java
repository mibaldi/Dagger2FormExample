package es.upsa.mimo.form.model;

/**
 * Created by sergiogarcia on 9/6/16.
 */
public class Form {

    private String mName;
    private String mSurnames;
    private String mAddress;
    private int mAge;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getSurnames() {
        return mSurnames;
    }

    public void setSurnames(String surnames) {
        this.mSurnames = surnames;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        this.mAddress = address;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        this.mAge = age;
    }

    public void decrementAge() {
        if(mAge > 0) {
            mAge--;
        }
    }

    public void incrementAge() {
        mAge++;
    }
}
