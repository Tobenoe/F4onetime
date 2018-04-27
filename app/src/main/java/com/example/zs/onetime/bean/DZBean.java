package com.example.zs.onetime.bean;

import java.util.List;

/**
 * Created by 杜晓彤 on 2018/4/26.
 */

public class DZBean {


    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"快乐的一直小青蛙","createTime":"2018-04-26T18:39:28","imgUrls":null,"jid":2304,"praiseNum":null,"shareNum":null,"uid":11186,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524574477979gaga_icon.jpg","nickname":"出来了","praiseNum":"null"}},{"commentNum":null,"content":"tggyhh\njbvg","createTime":"2018-04-26T18:33:57","imgUrls":null,"jid":2303,"praiseNum":null,"shareNum":null,"uid":13315,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524656999155avatar.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"啦啦啦啦啦啦啦","createTime":"2018-04-26T17:19:16","imgUrls":null,"jid":2302,"praiseNum":null,"shareNum":null,"uid":12457,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524481043273gaga_icon.jpg","nickname":"你林超级帅","praiseNum":"null"}},{"commentNum":null,"content":"nihao","createTime":"2018-04-26T16:46:46","imgUrls":null,"jid":2301,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"nihao","createTime":"2018-04-26T16:46:46","imgUrls":null,"jid":2300,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"你是个笑话","createTime":"2018-04-26T16:39:01","imgUrls":null,"jid":2299,"praiseNum":null,"shareNum":null,"uid":2845,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"nihao","createTime":"2018-04-26T16:36:50","imgUrls":null,"jid":2298,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"nihao","createTime":"2018-04-26T15:01:21","imgUrls":null,"jid":2297,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"nihao","createTime":"2018-04-26T15:01:21","imgUrls":null,"jid":2296,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"nihaoa","createTime":"2018-04-26T14:49:47","imgUrls":null,"jid":2295,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : null
         * content : 快乐的一直小青蛙
         * createTime : 2018-04-26T18:39:28
         * imgUrls : null
         * jid : 2304
         * praiseNum : null
         * shareNum : null
         * uid : 11186
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524574477979gaga_icon.jpg","nickname":"出来了","praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private Object imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(Object imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1524574477979gaga_icon.jpg
             * nickname : 出来了
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
