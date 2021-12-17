package hello.login.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
// @Getter , @Setter , @ToString , @EqualsAndHashCode , @RequiredArgsConstructor 를 자동으로 적용해준다.
// 핵심 도메인 모델에서 사용하기 위험하다
// 예측하지 못하게 동작할 수 있기 때문
// 단순하게 data 왔다갔다할 때 사용하는 DTO일 경우에는 확인해보고 사용해도 괜찮다
// @toString 등 추가적으로 필요하면 분리해서 사용하는 걸 추천
public class Member {

    private Long id; // DB에 저장되고 관리되는 ID

    @NotEmpty
    private String loginId; // 로그인할 때 사용되는 ID
    @NotEmpty
    private String name; // 사용자 이름
    @NotEmpty
    private String password; // 비밀번호
}

// 이전 수업에서 했듯이 AddMemberForm, UpdateMemberForm 등을 생성해주는 것이 좋지만 예시가 간단하므로
// Member 객체에 bean validation 명시해주었다다