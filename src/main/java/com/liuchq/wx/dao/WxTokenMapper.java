package com.liuchq.wx.dao;

import com.liuchq.wx.bean.WxToken;
import com.liuchq.wx.bean.WxTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WxTokenMapper {
    long countByExample(WxTokenExample example);

    int deleteByExample(WxTokenExample example);

    int deleteByPrimaryKey(String id);

    int insert(WxToken record);

    int insertSelective(WxToken record);

    List<WxToken> selectByExample(WxTokenExample example);

    WxToken selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WxToken record, @Param("example") WxTokenExample example);

    int updateByExample(@Param("record") WxToken record, @Param("example") WxTokenExample example);

    int updateByPrimaryKeySelective(WxToken record);

    int updateByPrimaryKey(WxToken record);

    String getWxToken();
}