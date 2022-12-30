package hello.springStudyBasic.singleton;

public class SingletonService {

    // static으로 들어가기 때문에 instance 하나로 이루어진다. (static 영역에 객체를 딱 1개만 생성해둔다.)
    private static final SingletonService instance = new SingletonService();

    // 위 객체의 인스턴스가 필요하면 getInstance()로만 조회할 수 있도록 한다.
    // public으로 열어서 객체 인스터스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 다른 객체 인스턴스를 생성할 수 없도록 처리(생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.)
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
