package com.kh.iclinic.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.iclinic.model.vo.Counsel;

@Mapper
public interface CounselMapper {
	// 사용자가 등록한 상담내역 조회
	List<Counsel> selectAllCounselByUserId(String id);

}
