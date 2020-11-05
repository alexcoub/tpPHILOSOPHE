package diningphilosophers;

public class ChopStick {

    private static int stickCount = 0;

    private boolean iAmFree = true;
    private final int myNumber;

    public ChopStick() {
        myNumber = ++stickCount;
    }

    synchronized public void take() throws InterruptedException {
        while (!iAmFree) {
            wait();
        }
        iAmFree = false;
        System.out.println("La baguette " + myNumber + " est prise");        
    }
    //...
    synchronized public void release() {
        System.out.println("La baguette " + myNumber + " est disponible");
        iAmFree = true;
        notifyAll(); 
    }

    @Override
    public String toString() {
        return "Stick#" + myNumber;
    }
}
