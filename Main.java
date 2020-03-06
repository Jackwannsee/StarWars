import java.util.Scanner;

public class Main
{
    public static void main(String[] args)throws InterruptedException {
        Scanner in = new Scanner(System.in);

        MotherShip YourMotherShip = new MotherShip();
        Notifications Notification = new Notifications();

        YourMotherShip.AddShip(new Ships("Battle Droid", 1400, 500, 1500, 250));

        boolean Game = true;
        while (Game)
        {
            Notification.ErrorMain();

            int Wronginput = 0;
            while (!in.hasNextInt()) {
                Wronginput = Wronginput + 1;
                if (Wronginput % 3 == 0) {
                } else {
                    System.out.print("--> ");
                }
                in.next();      //in.next() resets the input so that it doesn't go into an infinite loop

                if (Wronginput % 3 == 0) {
                    Notification.ErrorMain();
                }
            }
            int Input = in.nextInt();
            in.nextLine();

            if (Input == 1) {
                if (YourMotherShip.NumberOfShips() > 0) {
                    int Limit = YourMotherShip.NumberOfShips() + 1;
                    int InputShip = 0;
                    YourMotherShip.ListShips();

                    boolean ShipsNotSelected = true;
                    while (ShipsNotSelected) {
                        System.out.print("\n Chose your ship: ");

                        while (!in.hasNextInt()) {
                            System.out.print("\n Chose your ship: ");
                            in = new Scanner(System.in);
                        }
                        InputShip = in.nextInt();

                        if (InputShip > 0 && InputShip < Limit) {
                            ShipsNotSelected = false;
                        }
                    }
                    InputShip = InputShip - 1;

                    YourMotherShip.GetShip(InputShip);
                    new Battle(YourMotherShip.GetShip(0), YourMotherShip, InputShip);
                }
                if (YourMotherShip.NumberOfShips() <= 0) {
                    System.out.println();
                    System.out.println();
                    System.out.println("You have no Ships go buy some");
                }
            }

            if (Input == 2)
            {
                Notification.MainPause();
                YourMotherShip.BuyShip(YourMotherShip);
            }

            if (Input == 3) {
                YourMotherShip.ListShips();
                Thread.sleep(500);
            }

            if (Input == 4) {
                YourMotherShip.AdjustShips(YourMotherShip);
            }

            if (Input == 5) {
                Game = false;
            }
        }
    }
}
