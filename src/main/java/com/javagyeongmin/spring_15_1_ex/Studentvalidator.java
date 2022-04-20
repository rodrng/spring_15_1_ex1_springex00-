package com.javagyeongmin.spring_15_1_ex;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class Studentvalidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) { // 검증할 객체의 클래스 타입 정보
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Student student = (Student) target; // 믹스매치 라서 스튜던트로 형변환
		
		String studentId = student.getId();
		
		if(studentId == null || studentId.trim().isEmpty()) {
			
			System.out.println("student의 ID값이 비어있다");
			errors.reject("id", "트러블트러블트러블메이커");
		}

			int studentPw = student.getPw();


			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw", "trouble");
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "trouble"); // 위에 if문처럼 안쓰고 이렇게 넣어도 됨
		
	}

}
