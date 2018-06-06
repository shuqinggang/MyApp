package com.example.mayn.myapp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mayn on 2018/5/18.
 */

public class TestBean {

    /**
     * list : [{"create_date":"2018-05-18T03:53:09.000Z","id":122582,"image":"http://s3.amazonaws.com/voicecall/af9e38ee-8043-492b-9d63-34a1ef4d7bd4.jpg","isChecked":false,"nickname":"qings","play_times":0,"prime_date":"2018-05-18T03:53:08.000Z","prime_status":1,"prime_time":0,"prime_type":0,"promote":0,"promote_charge":0,"promote_date":"2018-05-18T03:53:08.000Z","share_play":0,"share_times":0,"share_vendor":0,"status":0,"story":"http://dg6m0ddeht37z.cloudfront.net/cake_9a108d18-6ef5-47ac-8e6a-5dd4276f8424.mp4","story_id":"cake_9a108d18-6ef5-47ac-8e6a-5dd4276f8424","thumbdown":0,"thumbup":0,"time":417,"username":"429035093@qq.com","vendor_times":0},{"create_date":"2018-05-18T03:37:55.000Z","id":122570,"image":"http://s3.amazonaws.com/voicecall/af9e38ee-8043-492b-9d63-34a1ef4d7bd4.jpg","isChecked":false,"nickname":"qings","play_times":0,"prime_date":"2018-05-18T03:37:55.000Z","prime_status":0,"prime_time":0,"prime_type":0,"promote":0,"promote_charge":0,"promote_dat e":"2018-05-18T03:37:55.000Z","share_play":0,"share_times":0,"share_vendor":0,"status":0,"story":"http://dg6m0ddeht37z.cloudfront.net/cake_7537cb33-9f7a-409f-b61f-4b3120f7883a.mp4","story_id":"cake_7537cb33-9f7a-409f-b61f-4b3120f7883a","thumbdown":0,"thumbup":0,"time":14,"username":"429035093@qq.com","vendor_times":0},{"create_date":"2018-05-18T03:34:51.000Z","id":122563,"image":"http://s3.amazonaws.com/voicecall/af9e38ee-8043-492b-9d63-34a1ef4d7bd4.jpg","isChecked":false,"nickname":"qings","play_times":0,"prime_date":"2018-05-18T03:34:51.000Z","prime_status":0,"prime_time":0,"prime_type":0,"promote":0,"promote_charge":0,"promote_date":"2018-05-18T03:34:51.000Z","share_play":0,"share_times":0,"share_vendor":0,"status":0,"story":"http://dg6m0ddeht37z.cloudfront.net/cake_414a646c-f20a-43bc-bab2-194aa5d4d0ea.mp4","story_id":"cake_414a646c-f20a-43bc-bab2-194aa5d4d0ea","thumbdown":0,"thumbup":0,"time":12,"username":"429035093@qq.com","vendor_times":0},{"create_date":"2018-05-17T03:41:58.000Z","id":121867,"image":" http://s3.amazonaws.com/voicecall/af9e38ee-8043-492b-9d63-34a1ef4d7bd4.jpg","isChecked":false,"nickname":"qings","play_times":0,"prime_date":"2018-05-17T03:41:57.000Z","prime_status":1,"prime_time":0,"prime_type":0,"promote":0,"promote_charge":0,"promote_date":"2018-05-17T03:41:57.000Z","share_play":0,"share_times":0,"share_vendor":0,"status":0,"story":"http://dg6m0ddeht37z.cloudfront.net/cake_be0ac787-b85e-41f3-8787-07f6c906d5a0.mp4","story_id":"cake_be0ac787-b85e-41f3-8787-07f6c906d5a0","thumbdown":0,"thumbup":0,"time":600,"username":"429035093@qq.com","vendor_times":0}]
     * status : 1
     */

    private int status;
    private List<ListBean> list;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * create_date : 2018-05-18T03:53:09.000Z
         * id : 122582
         * image : http://s3.amazonaws.com/voicecall/af9e38ee-8043-492b-9d63-34a1ef4d7bd4.jpg
         * isChecked : false
         * nickname : qings
         * play_times : 0
         * prime_date : 2018-05-18T03:53:08.000Z
         * prime_status : 1
         * prime_time : 0
         * prime_type : 0
         * promote : 0
         * promote_charge : 0
         * promote_date : 2018-05-18T03:53:08.000Z
         * share_play : 0
         * share_times : 0
         * share_vendor : 0
         * status : 0
         * story : http://dg6m0ddeht37z.cloudfront.net/cake_9a108d18-6ef5-47ac-8e6a-5dd4276f8424.mp4
         * story_id : cake_9a108d18-6ef5-47ac-8e6a-5dd4276f8424
         * thumbdown : 0
         * thumbup : 0
         * time : 417
         * username : 429035093@qq.com
         * vendor_times : 0
         * promote_dat e : 2018-05-18T03:37:55.000Z
         */

        private String create_date;
        private int id;
        private String image;
        private boolean isChecked;
        private String nickname;
        private int play_times;
        private String prime_date;
        private int prime_status;
        private int prime_time;
        private int prime_type;
        private int promote;
        private int promote_charge;
        private String promote_date;
        private int share_play;
        private int share_times;
        private int share_vendor;
        private int status;
        private String story;
        private String story_id;
        private int thumbdown;
        private int thumbup;
        private int time;
        private String username;
        private int vendor_times;
        @SerializedName("promote_dat e")
        private String _$Promote_datE41; // FIXME check this code

        public String getCreate_date() {
            return create_date;
        }

        public void setCreate_date(String create_date) {
            this.create_date = create_date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public boolean isIsChecked() {
            return isChecked;
        }

        public void setIsChecked(boolean isChecked) {
            this.isChecked = isChecked;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getPlay_times() {
            return play_times;
        }

        public void setPlay_times(int play_times) {
            this.play_times = play_times;
        }

        public String getPrime_date() {
            return prime_date;
        }

        public void setPrime_date(String prime_date) {
            this.prime_date = prime_date;
        }

        public int getPrime_status() {
            return prime_status;
        }

        public void setPrime_status(int prime_status) {
            this.prime_status = prime_status;
        }

        public int getPrime_time() {
            return prime_time;
        }

        public void setPrime_time(int prime_time) {
            this.prime_time = prime_time;
        }

        public int getPrime_type() {
            return prime_type;
        }

        public void setPrime_type(int prime_type) {
            this.prime_type = prime_type;
        }

        public int getPromote() {
            return promote;
        }

        public void setPromote(int promote) {
            this.promote = promote;
        }

        public int getPromote_charge() {
            return promote_charge;
        }

        public void setPromote_charge(int promote_charge) {
            this.promote_charge = promote_charge;
        }

        public String getPromote_date() {
            return promote_date;
        }

        public void setPromote_date(String promote_date) {
            this.promote_date = promote_date;
        }

        public int getShare_play() {
            return share_play;
        }

        public void setShare_play(int share_play) {
            this.share_play = share_play;
        }

        public int getShare_times() {
            return share_times;
        }

        public void setShare_times(int share_times) {
            this.share_times = share_times;
        }

        public int getShare_vendor() {
            return share_vendor;
        }

        public void setShare_vendor(int share_vendor) {
            this.share_vendor = share_vendor;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getStory() {
            return story;
        }

        public void setStory(String story) {
            this.story = story;
        }

        public String getStory_id() {
            return story_id;
        }

        public void setStory_id(String story_id) {
            this.story_id = story_id;
        }

        public int getThumbdown() {
            return thumbdown;
        }

        public void setThumbdown(int thumbdown) {
            this.thumbdown = thumbdown;
        }

        public int getThumbup() {
            return thumbup;
        }

        public void setThumbup(int thumbup) {
            this.thumbup = thumbup;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getVendor_times() {
            return vendor_times;
        }

        public void setVendor_times(int vendor_times) {
            this.vendor_times = vendor_times;
        }

        public String get_$Promote_datE41() {
            return _$Promote_datE41;
        }

        public void set_$Promote_datE41(String _$Promote_datE41) {
            this._$Promote_datE41 = _$Promote_datE41;
        }
    }
}
