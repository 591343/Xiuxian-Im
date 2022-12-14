package com.xiuxian.chat.service;

import com.xiuxian.chat.entity.ChatListEntity;
import com.xiuxian.chat.vo.chatlist.ChatListItemRelVo;
import com.xiuxian.chat.vo.chatlist.ChatListItemVo;
import com.xiuxian.chat.vo.chatlist.ChatListVo;

import java.util.List;


/**
 * 聊天列表
 *
 * @author Chenxiao 591343671@qq.com
 */
public interface ChatListService {
    //获取按聊天时间排序后（降序）的聊天列表
    ChatListVo getLatestChatList(String selfXiuxianId,String toId,Boolean single);

    void addChatList(ChatListEntity chatListEntity);

    ChatListItemVo getChatListItem(String selfXiuxianId, String friendXiuxianId);

    void deleteChatListItem(ChatListItemRelVo chatListItemRelVo);

    Boolean isChatRel(String fromId, String toId);

    void updateStartTime(String xiuxianUserId, String xiuxianGroupId, long startTime);
}
