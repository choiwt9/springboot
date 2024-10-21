package com.kh.iclinic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.iclinic.model.mapper.CounselMapper;
import com.kh.iclinic.model.vo.Counsel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CounselService {
	
	private final CounselMapper mapper;
	
	public List<Counsel> selectAllCounsel(String userId){
		return mapper.selectAllCounselByUserId(userId);
		
	}
   
}
