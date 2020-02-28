import static java.lang.Thread.currentThread;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)throws InterruptedException{
        Scanner in = new Scanner(System.in);

        MotherShip FleetMain = new MotherShip();
        //FleetMain.AddShip(ShipShop[0]);

        MotherShip YourMotherShip = new MotherShip();

        YourMotherShip.AddShip(new Ships("Battle Droid", 1400, 500, 1500,250));

        boolean Game = true;
        int Input =0;
        while(Game)
        {
            System.out.println("");
            System.out.println("");
            System.out.println("!! Welcome Young Padawan !!");
            System.out.println("1. Lets Fight");
            System.out.println("2. Buy a Ship");
            System.out.println("3. Your fleet");
            System.out.println("4. Ships/ Details");
            System.out.println("5. End Game");
            System.out.print("--> ");

            int Wronginput = 0;
            while (!in.hasNextInt())
            {
                Wronginput = Wronginput + 1;
                if (Wronginput % 3 == 0) {
                }
                else {
                    System.out.print("--> ");
                }

                in.next();      //in.next() resets the input so that it doesn't go into an infinite loop

                if (Wronginput % 3 == 0) {
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
            Input = in.nextInt();
            in.nextLine();

            if (Input == 1)
            {
                int Limit = YourMotherShip.NumberOfShips();
                YourMotherShip.ListShips();
                System.out.print("\n Chose your ship: ");
                while (!in.hasNextInt() || in.nextInt() > Limit || in.nextInt() <= 0)
                {
                    System.out.print("        --> ");
                    in.nextLine();
                }
                int InputShip = in.nextInt();

                YourMotherShip.GetShip(InputShip);
                new Battle(YourMotherShip.GetShip(0));
            }

            if (Input == 2)
            {
                Pause();
                YourMotherShip.BuyShip(YourMotherShip);
            }

            if (Input == 3)
            {
                YourMotherShip.ListShips();
            }

            if (Input == 4)
            {
                YourMotherShip.AdjustShips(YourMotherShip);
            }

            if (Input == 5)
            {
                Game = false;
            }
        }
    }

    //function to pause program
    private static void Pause() throws InterruptedException     //The Throws interrupted Exception is just there for the time otherwise there is a error
    {
        System.out.println();
        System.out.print("Loading");
        Thread.sleep(500);
        System.out.print("...");
        Thread.sleep(500);
        System.out.print("...");
        Thread.sleep(750);
    }
}
