package com.jj.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class ProfileFileRenamePolicy implements FileRenamePolicy{

	// 원본파일 전달 받아서 파일명 수정작업 후 수정된 파일 반환시켜주는 메소드
	@Override
	public File rename(File originFile) { // originFile = 원본파일명
		
		// 원본파일명
		String originName = originFile.getName();
		
		// 수정파일명 ("2022 07 15 12:24:30 + 23145.jpg")
		// 파일 업로드 시간(년월일시분초) + 5자리랜덤값(10000~99999) + 원본파일확장자
		
		// 1) 파일 업로드 시간(년월일시분초) String currentTime
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format( new Date() );
		
		// 2) 5자리 랜덤값 (10000~99999) int ranNum
		int ranNum = (int)(Math.random() * 90000 + 10000);
		
		// 3) 원본파일 확장자 String ext = originName.substring(원본파일명에 제일 뒤에있는 .의 인덱스 위치)
		String ext = originName.substring(originName.lastIndexOf("."));
		
		// 수정파일명.확장자
		String changeName = "profile" + currentTime + ranNum + ext;
		
		// 파일 객체 생성해서 반환: 원본파일의 상위폴더에 변경한 이름 제시
		return new File(originFile.getParent(), changeName); 
	}

}
