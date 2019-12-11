package com.wd.mvp.model.bean;

public class UserInfoBean {
    private int age;
    private String email;
    private String headPic;
    private int height;
    private int id;
    private String jiGuangPwd;
    private String nickName;
    private String sessionId;
    private int sex;
    private String userName;
    private int weight;
    private int whetherBingWeChat;
    private String userSignIn;

    public UserInfoBean(int age, int height, int id, String sessionId, int sex, String email, String jiGuangPwd, String nickName, String userName, int weight, String headPic, int whetherBingWeChat) {
        this.age = age;
        this.email = email;
        this.headPic = headPic;
        this.height = height;
        this.id = id;
        this.jiGuangPwd = jiGuangPwd;
        this.nickName = nickName;
        this.sessionId = sessionId;
        this.sex = sex;
        this.userName = userName;
        this.weight = weight;
        this.whetherBingWeChat = whetherBingWeChat;
        this.userSignIn = userSignIn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJiGuangPwd() {
        return jiGuangPwd;
    }

    public void setJiGuangPwd(String jiGuangPwd) {
        this.jiGuangPwd = jiGuangPwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWhetherBingWeChat() {
        return whetherBingWeChat;
    }

    public void setWhetherBingWeChat(int whetherBingWeChat) {
        this.whetherBingWeChat = whetherBingWeChat;
    }

    public String getUserSignIn() {
        return userSignIn;
    }

    public void setUserSignIn(String userSignIn) {
        this.userSignIn = userSignIn;
    }

    @Override
    public String toString() {
        return "UserInfoBean{" +
                "age=" + age +
                ", email='" + email + '\'' +
                ", headPic='" + headPic + '\'' +
                ", height=" + height +
                ", id=" + id +
                ", jiGuangPwd='" + jiGuangPwd + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", sex=" + sex +
                ", userName='" + userName + '\'' +
                ", weight=" + weight +
                ", whetherBingWeChat=" + whetherBingWeChat +
                ", userSignIn='" + userSignIn + '\'' +
                '}';
    }
}
