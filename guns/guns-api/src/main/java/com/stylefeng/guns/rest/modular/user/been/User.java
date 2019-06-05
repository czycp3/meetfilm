package com.stylefeng.guns.rest.modular.user.been;

/**
 * @auther 芮狼Dan
 * @date 2019-06-05 17:19
 */
public class User {
    int uuid;
    String user_name;
    String user_pwd;
    String nick_name;
    String user_sex;
    String birthday;
    String email;
    String user_phone;
    String address;
    String head_url;
    String biography;
    String life_state;
    String begin_time;
    String update_time;

    public User() {
    }

    public User(int uuid, String user_name, String user_pwd, String nick_name, String user_sex, String birthday, String email, String user_phone, String address, String head_url, String biography, String life_state, String begin_time, String update_time) {
        this.uuid = uuid;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
        this.nick_name = nick_name;
        this.user_sex = user_sex;
        this.birthday = birthday;
        this.email = email;
        this.user_phone = user_phone;
        this.address = address;
        this.head_url = head_url;
        this.biography = biography;
        this.life_state = life_state;
        this.begin_time = begin_time;
        this.update_time = update_time;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHead_url() {
        return head_url;
    }

    public void setHead_url(String head_url) {
        this.head_url = head_url;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getLife_state() {
        return life_state;
    }

    public void setLife_state(String life_state) {
        this.life_state = life_state;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", user_sex='" + user_sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", address='" + address + '\'' +
                ", head_url='" + head_url + '\'' +
                ", biography='" + biography + '\'' +
                ", life_state='" + life_state + '\'' +
                ", begin_time='" + begin_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
