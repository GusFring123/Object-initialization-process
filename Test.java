package important;

class Fu {
    int num = 5;

    static {
        System.out.println("1静态父类构造代码块执行");
    }

    static {
        System.out.println("2静态父类构造代码块执行");
    }

    {
        System.out.println("1父类构造代码块num= " + num);
    }

    {
        System.out.println("2父类构造代码块num= " + num);
    }

    Fu() {
        //隐藏的三步骤
        //1.  super();//Object类的构造方法
        //2.  显示初始化 本来默认num=0的，在这里第二步显示初始化为5
        //3.  执行构造代码块
        System.out.println("父类构造方法num= " + num);
        show();
    }

    void show() {
        System.out.println("父类show方法= " + num);
    }
}

class Zi extends Fu {
    int num = 8;

    static {
        System.out.println("1静态子类构造代码块执行");
    }

    static {
        System.out.println("2静态子类构造代码块执行");
    }

    {
        System.out.println("1子类构造代码块num= " + num);
    }

    {
        System.out.println("2子类构造代码块num= " + num);
    }

    Zi() {
        //隐藏的三步骤
        //1.  super();//Fu类的构造方法
        //2.  显示初始化 本来默认num=0的，在这里第二步显示初始化为8
        //3.  执行构造代码块
        System.out.println("子类构造方法num= " + num);
        show();
    }

    void show() {
        System.out.println("子类show方法num= " + num);
    }

}

public class Test {

    @org.junit.Test
    public void test() {
        new Zi();
        /* 答案
        1静态父类构造代码块执行
        2静态父类构造代码块执行
        1静态子类构造代码块执行
        2静态子类构造代码块执行
        1父类构造代码块num= 5
        2父类构造代码块num= 5
        父类构造方法num= 5
        子类show方法num= 0
        1子类构造代码块num= 8
        2子类构造代码块num= 8
        子类构造方法num= 8
        子类show方法num= 8
        */
    }

}
