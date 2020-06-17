package SingletonPattern;

public class Singleton {
    private static volatile Singleton singleton;
    public String str;
    private Singleton() {
    }

    public static Singleton getSingleInstance(){
        if (singleton == null){
            synchronized (Singleton.class) {
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
