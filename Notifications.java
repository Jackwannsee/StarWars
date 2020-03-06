public class Notifications
{
    void MainPause() throws InterruptedException
    {
        System.out.println();
        System.out.print("Loading");
        Thread.sleep(500);
        System.out.print("...");
        Thread.sleep(500);
        System.out.print("...");
        Thread.sleep(750);
    }

    void ErrorMain()
    {
        System.out.println("");
        System.out.println("");
        System.out.println("1. Lets Fight");
        System.out.println("2. Buy a Ship");
        System.out.println("3. Your fleet");
        System.out.println("4. Ships/ Details");
        System.out.println("5. End Game");
        System.out.print("--> ");
    }

}
