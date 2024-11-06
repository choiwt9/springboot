package com.kh.myEditor.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.myEditor.model.service.BoardService;
import com.kh.myEditor.model.vo.Board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService bService; 
	
	@GetMapping("/board")
	public String enrollBoard() {
		return "/board/enrollBoard";
	}
	
	// 리스폰스 바디를 붙였다: 비동기통신을 하겠다. 리턴ok를 한다: 리스폰스바디를 붙여야함
	@ResponseBody
	@PostMapping("/board")
	public String insertBoard(@RequestBody Board board) {
		log.info("data --> {}", board);
		int result = bService.insertBoard(board);
		
		return result > 0 ? "ok" : "fail";
	}
	/**
	 * 
	 * @param imgList
	 * @return
	 */
	@ResponseBody
	@PostMapping(value="/upload" produces="appication/json;charset=UTF-8")
	public String uploadImage(List<MultipartFile> imgList) {
		
		log.info("{}",imgList);
		
		List<String> changeNameList = new ArrayList<>();
		
		
		for(MultipartFile file : imgList) {
		log.info("change name : {}", changeName);	
		changeNameList.add(changeName);
		}	
		return new Gson().toJson(changeNameList); //ArrayList - > JSONArray
		
	}
	

//------------------------------------------------------------
public String saveFile(MultipartFile upfile) {
//* 현재 날짜 시간 관련 정보
			String currTime = new SimpleDateFormat("yyyyMMddHHmss").format(new Date());
			// *5자리 랜덤값 (10000~99999)

			int random = (int) (Math.random() * (99999 - 10000 + 1)) + 10000;

			// *확장자 (.txt, .java, .png, ...)
			String orgName = upfile.getOriginalFilename();
			String ext = orgName.substring(orgName.lastIndexOf("."));

			String chgName = currTime + random + ext;

			// 업로드할 파일을 저장할 위치의 물리적인 경로 조회
			String uploadDir = "./uploads";
			Path savePath = Paths.get(uploadDir+chgName);
			

			try {
				Files.createDirectories(savePath.getParent());
				Files.write(savePath, upfile.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return uploadDir + chgName;
		}

		// DB에 게시글 정보 저장(첨부파일 유/무 상관 없이 처리)
		int result = bService.insertBoard(b);

		if (result > 0) { // 게시글 등록 성공
			session.setAttribute("alertMsg", "게시글 등록 성공");

			return "redirect:/board/list";

		} else {// 게시글 등록 실패
			model.addAttribute("errorMsg", "게시글 등록 실패");
			return "common/errorPage";
		}

	}


















