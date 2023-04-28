//내부 클래스는 인스턴스 내부클래스 사용권장 (x)
//내부 객체가 외부 객체에 대한 외부참조를 가져서
//GC가 외부참조 때문에 메모리 해제를 못한다. (메모리 누수 발생)
//그러니 스태틱 내부클래스를 사용하자.

class classA{
    int instanceA=10;
    static int staticA=20;

    public void sout(){
        System.out.println(instanceA);
        System.out.println(instanceA);
        System.out.println(staticA);

        //System.out.println(instanceB);
        //내부 객체가 언제 만들어질 줄 알고?
        //System.out.println(staticB);
        ///인스턴스 이너 클래스는 태생적으로 static이 없으므로 classA 객체에서 사용하기 위한 것
        // 즉, 외부 클래스 내부에 객체를 만들기 위한 녀석이라 static 변수없음

        //System.out.println(instanceC);
        //classC의 인스턴스가 언제 만들어질 줄 알고?
        System.out.println(classC.staticC);
        System.out.println(classA.classC.staticC);
        //classA.classB.staticB = classB.staticB
    }


    class classB{
        int instanceB=30;
        //static int staticB=40;
        //classA 외부클래스의 객체 내부에 객체를 만들기 위해 탄생한 클래스여서
        //태생적 한계로 static 영역을 사용하지 않는 듯하다.
        //애초에 innerclass가 static이 안붙었다는 것은 객체를 생성해야만 쓸 수 있게 만든 클래스여서
        // 즉, 외부 클래스 내부에 객체를 만들기 위한 녀석이라 static 변수없음

        public void sout(){
            System.out.println(instanceA);
            //classA 클래스의 객체 안에 classB 클래스의 객체가 생성되어, 외부참조 가능하다.
            //당연히 외부 객체의 변수 사용 가능
            System.out.println(classA.this.instanceA);
            //부모 인스턴스 변수를 쓰면 컴파일러가 자동으로 부모.this를 붙여줌
            System.out.println(classA.staticA);
            //static 영역의 클래스 변수는 누구나 사용 가능
            System.out.println(instanceB);
            //자신의 객체의 변수 가용 가능
            //System.out.println(staticB);
            //staticB가 불가능
            //태생적 한계로 static 영역을 사용하지 않는 듯하다.
            //애초에 innerclass가 static이 안붙었다는 것은 객체를 생성해야만 쓸 수 있게 만든 클래스여서

            //System.out.println(instanceC);
            //다른 클래스의 객체가 언제 생길 줄 사용하냐?
            System.out.println(classC.staticC);
            //static 영역이므로 접근가능
            System.out.println(classA.classC.staticC);
        }
    }
    static class classC{
        int instanceC=50;
        static int staticC=60;

        public void sout(){
            //System.out.println(instanceA);
            //인스턴스가 언제 생길지 모르고, 어떤 인스턴스인지도 모르니 클래스에서 인스턴스로 접근 불가능
            System.out.println(staticA);
            //스태틱은 어디서든 접근 가능
            System.out.println(classA.staticA);
            //staticA = classA.staticA
            //System.out.println(instanceB);
            //인스턴스가 언제 생길지 모르고, 어떤 인스턴스인지도 모르니 클래스에서 인스턴스로 접근 불가능
            //System.out.println(staticB);
            //태생적 한계로 static 영역을 사용하지 않는 듯하다.
            //애초에 innerclass가 static이 안붙었다는 것은 객체를 생성해야만 쓸 수 있게 만든 클래스여서

            System.out.println(instanceC);
            System.out.println(staticC);
        }
    }
}

public class 테스트 {
    public static void main(String[] args) {
        System.out.println(classA.staticA);
        classA a = new classA();
        classA.classB b = a.new classB();
        //classA.classB instanceB = new classA().new classB();
        classA.classC c = new classA.classC();

    }
}
