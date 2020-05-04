package com.example.cainiaoguo.domain;

public class User {

    /**
     * flag : true
     * data : {"uid":"6","username":"李莫愁","passwd":"123456","address":"河南省开封市金明校区华苑3号楼811室","gender":"女","age":"17","identify":"273747596018273645","user_phone":"13588239999"}
     * errorMsg :
     */

    private boolean flag;
    private DataBean data;
    private String errorMsg;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * uid : 6
         * username : 李莫愁
         * passwd : 123456
         * address : 河南省开封市金明校区华苑3号楼811室
         * gender : 女
         * age : 17
         * identify : 273747596018273645
         * user_phone : 13588239999
         */

        private String uid;
        private String username;
        private String passwd;
        private String address;
        private String gender;
        private String age;
        private String identify;
        private String user_phone;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPasswd() {
            return passwd;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getIdentify() {
            return identify;
        }

        public void setIdentify(String identify) {
            this.identify = identify;
        }

        public String getUser_phone() {
            return user_phone;
        }

        public void setUser_phone(String user_phone) {
            this.user_phone = user_phone;
        }
    }
}
