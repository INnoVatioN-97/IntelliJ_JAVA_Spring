package kr.mjc.youngil.spring.day1.class04;

import kr.mjc.youngil.spring.day1.class02.TV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV {

    private Speaker speaker;

    // speaker를 주입하는 생성자
    // @Qualifier는 같은 타입이 두 개 이상일 때
    @Autowired
    public SamsungTV(@Qualifier("sonySpeaker") Speaker speaker) {
        this.speaker = speaker;
        System.out.println("samsungTV constructor에서 speaker를 넣었습니다.");
        System.out.println("Samsung TV is created.");
    }

    @Override
    public void volumeUp() {
        System.out.print("samsungTV : ");
        speaker.volumeUp();
    }

    @Override
    public void volumeDown() {
        System.out.print("samsungTV : ");
        speaker.volumeDown();
    }
}