package com.xiuxian.chat.service;

import com.xiuxian.chat.entity.FriendsEntity;
import com.xiuxian.chat.vo.friendlist.FriendListItemVo;
import com.xiuxian.chat.vo.friendlist.FriendListVo;
import com.xiuxian.chat.vo.friendlist.GroupListItemVo;
import com.xiuxian.chat.vo.friendlist.GroupListVo;

/**
 * 聊天列表
 *
 * @author Chenxiao 591343671@qq.com
 */
public interface FriendListService {
    //获取按聊天时间排序后（降序）的聊天列表
    FriendListVo getAllFriendList(String selfXiuxianId);

    GroupListVo getGroupList(String selfXiuxianId);

    FriendsEntity getFriendRelByselfXiuxianIdAndFriendXiuxianId(String selfXiuxianId,String friendXiuxianId);

    FriendListItemVo getFriendListItem(String selfXiuxianId,String friendXiuxianId);
    GroupListItemVo getGroupListItem(String selfXiuxianId, String friendXiuxianId);
}
