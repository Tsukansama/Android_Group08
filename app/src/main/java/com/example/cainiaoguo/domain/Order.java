package com.example.cainiaoguo.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Order implements Parcelable {

    /**
     * flag : true
     * data : {"uid":1,"sender_address":"河南省开封市明伦校区仁和宿舍3号楼811室","sender_name":"张三","sender_phone":"13566668888","receiver_address":"河南省开封市金明校区华苑3号楼811室","receiver_name":"李四","receiver_phone":"13788239999","order_id":372036854775807,"sign_for":"N","sign_date":null,"weight":20,"type":"易碎品","real_time_address":"河南省开封市明伦校区仁和宿舍3号楼811室"}
     * errorMsg :
     */

    private boolean flag;
    private DataBean data;
    private String errorMsg;

    protected Order(Parcel in) {
        flag = in.readByte() != 0;
        errorMsg = in.readString();
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (flag ? 1 : 0));
        dest.writeString(errorMsg);
    }

    public static class DataBean {
        /**
         * uid : 1
         * sender_address : 河南省开封市明伦校区仁和宿舍3号楼811室
         * sender_name : 张三
         * sender_phone : 13566668888
         * receiver_address : 河南省开封市金明校区华苑3号楼811室
         * receiver_name : 李四
         * receiver_phone : 13788239999
         * order_id : 372036854775807
         * sign_for : N
         * sign_date : null
         * weight : 20
         * type : 易碎品
         * real_time_address : 河南省开封市明伦校区仁和宿舍3号楼811室
         */

        private int uid;
        private String sender_address;
        private String sender_name;
        private String sender_phone;
        private String receiver_address;
        private String receiver_name;
        private String receiver_phone;
        private long order_id;
        private String sign_for;
        private Object sign_date;
        private int weight;
        private String type;
        private String real_time_address;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getSender_address() {
            return sender_address;
        }

        public void setSender_address(String sender_address) {
            this.sender_address = sender_address;
        }

        public String getSender_name() {
            return sender_name;
        }

        public void setSender_name(String sender_name) {
            this.sender_name = sender_name;
        }

        public String getSender_phone() {
            return sender_phone;
        }

        public void setSender_phone(String sender_phone) {
            this.sender_phone = sender_phone;
        }

        public String getReceiver_address() {
            return receiver_address;
        }

        public void setReceiver_address(String receiver_address) {
            this.receiver_address = receiver_address;
        }

        public String getReceiver_name() {
            return receiver_name;
        }

        public void setReceiver_name(String receiver_name) {
            this.receiver_name = receiver_name;
        }

        public String getReceiver_phone() {
            return receiver_phone;
        }

        public void setReceiver_phone(String receiver_phone) {
            this.receiver_phone = receiver_phone;
        }

        public long getOrder_id() {
            return order_id;
        }

        public void setOrder_id(long order_id) {
            this.order_id = order_id;
        }

        public String getSign_for() {
            return sign_for;
        }

        public void setSign_for(String sign_for) {
            this.sign_for = sign_for;
        }

        public Object getSign_date() {
            return sign_date;
        }

        public void setSign_date(Object sign_date) {
            this.sign_date = sign_date;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getReal_time_address() {
            return real_time_address;
        }

        public void setReal_time_address(String real_time_address) {
            this.real_time_address = real_time_address;
        }
    }
}
