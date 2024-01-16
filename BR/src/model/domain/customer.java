package model.domain;
// 데이터 전송 계층 Data Transfer Object
// 클래스 하나에 테이블 하나를 대응시켜서 작성
// 각 SQL테이블의 '필드'는 클래스의 멤버 '필드'와 일대일 대응 -> 자료형
import lombok.*;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class customer {
	@ToString.Include
	String name;
	int age;
	int price;
	int reservation_ID;
}