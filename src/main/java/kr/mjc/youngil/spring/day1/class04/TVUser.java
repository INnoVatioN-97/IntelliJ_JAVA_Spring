package kr.mjc.youngil.spring.day1.class04;

public class TVUser {
    public static void main(String[] args) {
        Speaker sonySpeaker = new SonySpeaker();
        Speaker appleSpeaker = new AppleSpeaker();

        // inject sonySpeaker using constructor.
        SamsungTV samsungTV = new SamsungTV(appleSpeaker);

        // inject appleSpeaker using setter-method after creating LgTV instance by using default constructor.
        LgTV lgTV = new LgTV();
        lgTV.setSpeaker(appleSpeaker);

        //이상 빈에 대한 설정, 이하 빈에 대한 사용용

       samsungTV.volumeUp();
        lgTV.volumeDown();
    }
}
