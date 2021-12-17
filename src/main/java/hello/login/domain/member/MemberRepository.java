package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository // 원래대로라면 db에서 관리할 수도 있고 memory에서 관리할 수도 있게 interface로 만드는 게 좋다.
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // static 사용
    private static long sequence = 0L; // // static 사용

    public Member save(Member member) {
        member.setId(++sequence);
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public Optional<Member> findByLoginId(String loginId) {
        // 회원 객체가 있을 수도 없을 수도 있으니까 Optional<> 사용 (java 8 문법)
//        List<Member> all = findAll();
//        for (Member m : all) {
//            if (m.getLoginId().equals(loginId)) {
//                return Optional.of(m);
//            }
//        }
//        return Optional.empty(); // 값이 없으면 empty()로 반환

        return findAll().stream() // stream() : 마치 loop 돌리는 것과 흡사
                .filter(m -> m.getLoginId().equals(loginId)) // filter로 조건에 맞는 것만 거른다
                .findFirst(); // 가장 먼저 나오는 객체 반환
        // java 8 람다식 사용 (요즘에는 기본으로 사용할 줄 알아야 한다)
        // 위의 주석 처리한 코드와 같은 내용
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    // 테스트 초기화 용도
    public void clearStore() {
        store.clear();
    }

}
