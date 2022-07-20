public class Main {
    public static void main(String[] args) {
//        Instance instance = Instance.getInstance();

        //死锁
        Object ob1 = new Object();
        Object ob2 = new Object();

        new Thread(() -> {
            String name = Thread.currentThread().getName();
            synchronized (ob1) {
                System.out.println(name + "获取锁1，请求锁2");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            synchronized (ob2){
                System.out.println(name + "获取锁2");
            }
        },"线程1").start();

        new Thread(() -> {
            String name = Thread.currentThread().getName();
            synchronized (ob2) {
                System.out.println(name + "获取锁2，请求锁1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            synchronized (ob1){
                System.out.println(name + "获取锁1");
            }
        },"线程2").start();

    }
}

class Instance{
    private static Instance instance;

    private Instance(){

    }

    public static synchronized Instance getInstance(){
        if(instance == null){
            instance = new Instance();
        }
        return instance;
    }
}
