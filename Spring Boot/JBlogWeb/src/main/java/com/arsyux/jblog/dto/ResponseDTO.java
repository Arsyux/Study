package com.arsyux.jblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {

	// 응답 전용 DTO 작성
	// 컨트롤러의 응답으로 DTO(Data Transfer Object, 데이터 전송 객체)를 사용하는 이유는
	// 클라이언트에게 일관성 있는 응답을 전송하기 위해서임.
	// 예를 들어, 컨트롤러의 메소드가 브라우저의 요청에 대해
	// 성공과 실패의 의미로 1 또는 0을 반환한다고 가정하면,
	// 당연히 서버의 응답 결과를 받는 쪽에서 반환값의 의미를 알고 있어야 한다.
	// 따라서 응답의 의미나 종류가 임의로 변경되면 그에 맞게 프로그램도 수정되어야 한다.
	// 이러한 서버의 응답을 일관성 있게 처리하기 위해서는 표준화된 응답 데이터 형식이 필요함.
	// 따라서 우리는 HTTP 응답 상태(status) 정보를 DTO로 감싸서 처리할 것임.
	
	// HTTP 응답 상태 코드 -> HTTP 응답 상태를 저장함.
	private int status;

	// 실제 응답할 데이터
	private T data;
}
