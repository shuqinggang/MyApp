package com.example.mayn.myapp.bean;

import java.util.List;

/**
 * Created by shuqinggang on 2018/6/7.
 */

public class FirstWangyi {

    private List<VideoBean> video;

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideoBean {
        /**
         * accoutClassify : 1
         * autoPlay : 0
         * category : 搞笑/自制搞笑
         * cover : http://dingyue.nosdn.127.net/vFxga0RuWxO8opxaPxOgWpXqXClmzrYmADtxXYaWqa2hH1527699351956.jpeg
         * danmu : 1
         * extraTags : ["爆笑剧","幽默剧","内涵段子"]
         * length : 16
         * m3u8_url : http://flv.bn.netease.com/videolib3/1805/31/rmAYc9347/SD/movie_index.m3u8
         * mp4_url : http://flv3.bn.netease.com/videolib3/1805/31/rmAYc9347/SD/rmAYc9347-mobile.mp4
         * playCount : 18123
         * playersize : 0
         * program : base
         * prompt : 成功为您推荐10条新视频
         * ptime : 2018-05-31 16:37:49.0
         * recomCount : 0
         * replyBoard : video_bbs
         * replyCount : 57
         * replyid : JI5QBO9R050835RB
         * sectiontitle : http://vimg1.ws.126.net/image/snapshot/2018/1/J/D/VD83ERRJD.jpg
         * sizeHD : 0
         * sizeSD : 696
         * sizeSHD : 0
         * title : 哥们你耍流氓能不能快速点，我还是个孩子，真墨迹
         * topicDesc : 最大最权威的星座性格解析平台，带你走&amp;amp;#8203;进每个星座的内心世界，一起分享我们的喜怒哀乐欢！
         * topicImg : http://vimg1.ws.126.net/image/snapshot/2018/1/J/D/VD83ERRJD.jpg
         * topicName : 星座漫画儿
         * topicSid : VD83ERRJ8
         * unlikeReason : ["自制搞笑视频/1","来源:星座漫画儿/4","内容质量差/6","看过了/6","低俗重口/6"]
         * vCategory : 情感
         * vid : VJI5QBO9R
         * videoRatio : 0.75
         * videoTag : ["爆笑剧"]
         * videoTopic : {"alias":"每日/每周/每月星座运势","ename":"T1506666420618","tid":"T1506666420618","tname":"星座漫画儿","topic_icons":"http://dingyue.nosdn.127.net/LNBL7CbfH7gI=VkdF1w3qh1fujDxuUSgzEphLyUyOgInB1506666419881.jpg"}
         * videosource : 新媒体
         * voteCount : 220
         * m3u8Hd_url : http://flv.bn.netease.com/videolib3/1806/02/TDqSU4631/HD/movie_index.m3u8
         * mp4Hd_url : http://flv3.bn.netease.com/videolib3/1806/02/TDqSU4631/HD/TDqSU4631-mobile.mp4
         */

        private int accoutClassify;
        private int autoPlay;
        private String category;
        private String cover;
        private int danmu;
        private int length;
        private String m3u8_url;
        private String mp4_url;
        private int playCount;
        private int playersize;
        private String program;
        private String prompt;
        private String ptime;
        private int recomCount;
        private String replyBoard;
        private int replyCount;
        private String replyid;
        private String sectiontitle;
        private int sizeHD;
        private int sizeSD;
        private int sizeSHD;
        private String title;
        private String topicDesc;
        private String topicImg;
        private String topicName;
        private String topicSid;
        private String vCategory;
        private String vid;
        private double videoRatio;
        private VideoTopicBean videoTopic;
        private String videosource;
        private int voteCount;
        private String m3u8Hd_url;
        private String mp4Hd_url;
        private List<String> extraTags;
        private List<String> unlikeReason;
        private List<String> videoTag;

        public int getAccoutClassify() {
            return accoutClassify;
        }

        public void setAccoutClassify(int accoutClassify) {
            this.accoutClassify = accoutClassify;
        }

        public int getAutoPlay() {
            return autoPlay;
        }

        public void setAutoPlay(int autoPlay) {
            this.autoPlay = autoPlay;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getDanmu() {
            return danmu;
        }

        public void setDanmu(int danmu) {
            this.danmu = danmu;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getM3u8_url() {
            return m3u8_url;
        }

        public void setM3u8_url(String m3u8_url) {
            this.m3u8_url = m3u8_url;
        }

        public String getMp4_url() {
            return mp4_url;
        }

        public void setMp4_url(String mp4_url) {
            this.mp4_url = mp4_url;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public int getPlayersize() {
            return playersize;
        }

        public void setPlayersize(int playersize) {
            this.playersize = playersize;
        }

        public String getProgram() {
            return program;
        }

        public void setProgram(String program) {
            this.program = program;
        }

        public String getPrompt() {
            return prompt;
        }

        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public int getRecomCount() {
            return recomCount;
        }

        public void setRecomCount(int recomCount) {
            this.recomCount = recomCount;
        }

        public String getReplyBoard() {
            return replyBoard;
        }

        public void setReplyBoard(String replyBoard) {
            this.replyBoard = replyBoard;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public String getReplyid() {
            return replyid;
        }

        public void setReplyid(String replyid) {
            this.replyid = replyid;
        }

        public String getSectiontitle() {
            return sectiontitle;
        }

        public void setSectiontitle(String sectiontitle) {
            this.sectiontitle = sectiontitle;
        }

        public int getSizeHD() {
            return sizeHD;
        }

        public void setSizeHD(int sizeHD) {
            this.sizeHD = sizeHD;
        }

        public int getSizeSD() {
            return sizeSD;
        }

        public void setSizeSD(int sizeSD) {
            this.sizeSD = sizeSD;
        }

        public int getSizeSHD() {
            return sizeSHD;
        }

        public void setSizeSHD(int sizeSHD) {
            this.sizeSHD = sizeSHD;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTopicDesc() {
            return topicDesc;
        }

        public void setTopicDesc(String topicDesc) {
            this.topicDesc = topicDesc;
        }

        public String getTopicImg() {
            return topicImg;
        }

        public void setTopicImg(String topicImg) {
            this.topicImg = topicImg;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public String getTopicSid() {
            return topicSid;
        }

        public void setTopicSid(String topicSid) {
            this.topicSid = topicSid;
        }

        public String getVCategory() {
            return vCategory;
        }

        public void setVCategory(String vCategory) {
            this.vCategory = vCategory;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public double getVideoRatio() {
            return videoRatio;
        }

        public void setVideoRatio(double videoRatio) {
            this.videoRatio = videoRatio;
        }

        public VideoTopicBean getVideoTopic() {
            return videoTopic;
        }

        public void setVideoTopic(VideoTopicBean videoTopic) {
            this.videoTopic = videoTopic;
        }

        public String getVideosource() {
            return videosource;
        }

        public void setVideosource(String videosource) {
            this.videosource = videosource;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }

        public String getM3u8Hd_url() {
            return m3u8Hd_url;
        }

        public void setM3u8Hd_url(String m3u8Hd_url) {
            this.m3u8Hd_url = m3u8Hd_url;
        }

        public String getMp4Hd_url() {
            return mp4Hd_url;
        }

        public void setMp4Hd_url(String mp4Hd_url) {
            this.mp4Hd_url = mp4Hd_url;
        }

        public List<String> getExtraTags() {
            return extraTags;
        }

        public void setExtraTags(List<String> extraTags) {
            this.extraTags = extraTags;
        }

        public List<String> getUnlikeReason() {
            return unlikeReason;
        }

        public void setUnlikeReason(List<String> unlikeReason) {
            this.unlikeReason = unlikeReason;
        }

        public List<String> getVideoTag() {
            return videoTag;
        }

        public void setVideoTag(List<String> videoTag) {
            this.videoTag = videoTag;
        }

        public static class VideoTopicBean {
            /**
             * alias : 每日/每周/每月星座运势
             * ename : T1506666420618
             * tid : T1506666420618
             * tname : 星座漫画儿
             * topic_icons : http://dingyue.nosdn.127.net/LNBL7CbfH7gI=VkdF1w3qh1fujDxuUSgzEphLyUyOgInB1506666419881.jpg
             */

            private String alias;
            private String ename;
            private String tid;
            private String tname;
            private String topic_icons;

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public String getEname() {
                return ename;
            }

            public void setEname(String ename) {
                this.ename = ename;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getTopic_icons() {
                return topic_icons;
            }

            public void setTopic_icons(String topic_icons) {
                this.topic_icons = topic_icons;
            }
        }
    }
}
