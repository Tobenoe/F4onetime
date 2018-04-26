package com.example.zs.onetime.api;

/**
 * Created by work on 2018/4/25.
 */

public class Api {
    //主接口
   static  final  String  ONTETIME = "https://www.zhaoapi.cn/quarter/";
   //广告接口 https://www.zhaoapi.cn/quarter/getAd
    static final  String  ADV = ONTETIME+"getAd";
    //.版本更新接口
    static final  String NEWVSN = ONTETIME+"getVersion";
    //登录接口
    static final  String LOGIN = "https://www.zhaoapi.cn/user/login";
    //注册接口 https://www.zhaoapi.cn/quarter/register
    static final  String REGISTER = ONTETIME+"register";

      //发布视频
    static final String RELESE = ONTETIME+"publishVideo ";

    //获取视频列表
    static final String VLIE = ONTETIME+"getVideos ";

    //获取某个用户的视频作品集
    static final String PSGVIDEO = ONTETIME+"getUserVideos  ";
    //关注
    static final String ATTENTION = ONTETIME+"follow ";
    //获取关注用户列表
    static final String ATNLIE = ONTETIME+"getFollowUsers ";

    //作品点赞
    static final String LIKE = ONTETIME+"praise ";
    //收藏作品
    static final String SCCOLLECT = ONTETIME+"addFavorite ";
    //取消收藏
    static final String NOCOLLECT = ONTETIME+"cancelFavorite ";
    //作品评论
    static final String COMMENT = ONTETIME+"comment ";

    //视频作品详情
    static final String VIDXQ = ONTETIME+"getVideoDetail ";
    //段子详情
    static final String DZXQ = ONTETIME+"getJokeDetail ";
    //段子点赞
    static final String JOKEPASE = ONTETIME+"jokePraise ";
    //段子评论
    static final String JOKERCOMMENT = ONTETIME+"commentJoke ";
    //随机钟友
    static final String RANDOM = ONTETIME+"randomFriends ";
    //搜索钟友
    static final String FIND = ONTETIME+"searchFriends ";
    //获取热门视频列表
    static final String HOTVIDEO = ONTETIME+"getHotVideos ";
    //获取附近视频列表
    static final String NEARBAYVIDEO = ONTETIME+"getNearVideos ";
    //删除收藏
    static final String DELECT = ONTETIME+"removeFavorite ";
    //删除作品
    static final String DELECTPRODUCTION = ONTETIME+"removeWork ";
    //.获取作品个人中心（新增）
    static final String GETPRESENAGE = ONTETIME+"getWorkInfo ";
    //收藏列表
    static final String COLLECT = ONTETIME+"getFavorites ";
    //修改年龄
    static final String UPDATEAGE = ONTETIME+"updateAge ";

}
