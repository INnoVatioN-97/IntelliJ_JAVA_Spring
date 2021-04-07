package kr.mjc.youngil.spring.day1.class04;

import kr.mjc.youngil.spring.day1.class02.TV;

public class LgTV implements TV {
    private Speaker speaker = null;

    public LgTV() {
        System.out.println("LGTV is created.");
    }

    public void setSpeaker(Speaker speaker){
        this.speaker = speaker;
        System.out.println("lgTV setter에서 speaker를 넣었습니다.");
    }

    @Override
    public void volumeUp() {
        System.out.print("lgTV : ");
        speaker.volumeUp();
    }

    @Override
    public void volumeDown() {
        System.out.print("lgTV : ");
        speaker.volumeDown();
    }
}
