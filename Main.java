import com.sun.nio.file.SensitivityWatchEventModifier;

import java.awt.*;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        MotherShip[] MotherShipShips = new MotherShip[5];
        MotherShipShips[0] = new MotherShip();

        Ships[] ShipShop = new Ships[16];
        {
            ShipShop[0] = new Ships("Battle Droid", 1400, 500, 1500);
            ShipShop[1] = new Ships("Star Fighter", 1500, 550, 1550);
            ShipShop[2] = new Ships("Star Blaster", 1600, 600, 1600);
            ShipShop[3] = new Ships("Alpha Blaster", 1700, 650, 1700);
            ShipShop[4] = new Ships("Beta Blaster", 1800, 700, 1800);
            ShipShop[5] = new Ships("Gamma Blaster", 1900, 750, 1900);
            ShipShop[6] = new Ships("Trojan", 1950, 800, 1950);
            ShipShop[7] = new Ships("Karkinos", 2000, 850, 2000);
            ShipShop[8] = new Ships("Inferno", 2050, 900, 2050);
            ShipShop[9] = new Ships("LightSpeed", 2100, 950, 2100);
            ShipShop[10] = new Ships("Project X", 2150, 1000, 2150);
            ShipShop[11] = new Ships("Purge", 2200, 1050, 22001);
            ShipShop[12] = new Ships("Herculues", 2250, 1100, 2250);
            ShipShop[13] = new Ships("Hippocrates", 2300, 1200, 2300);
            ShipShop[14] = new Ships("Atomic Blaster", 2500, 1500, 2500);
            ShipShop[15] = new Ships("Taco God", 5000, 3000, 10000);
        }

        MotherShip FleetMain = new MotherShip();

        Ships[] Enemy = new Ships[1];       //enemy 0 defined bellow

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
            System.out.println("4. End Game");
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
                    System.out.println("4. End Game");
                    System.out.print("--> ");
                }
            }
            Input = in.nextInt();
            in.nextLine();


            if (Input == 1)
            {
                System.out.println("");
                System.out.println("");
                System.out.print("You're Fighting ");
                Enemy[0] = new Ships();
                Enemy[0].Information();

            }


            if (Input == 2)
            {
                System.out.println();
                System.out.println();
                System.out.println("-=-=-=-=-=-=-=-=-= Buy Ships =-=-=-=-=-=-=-=-=-");
                for (int i = 0; i < ShipShop.length; i++)
                {
                    System.out.print((i+1) + ". ");
                    ShipShop[i].InformationCost();
                }
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.print("Ships # --> ");

                while (!in.hasNextInt())
                {
                    System.out.print("        --> ");
                    in.nextLine();
                }
                Input = in.nextInt();
                Input = Input -1;

                System.out.println();
                System.out.print("Ship " + (Input+1) + " ");
                ShipShop[Input].InformationCost();

                if(MotherShipShips[0].getMoney() < ShipShop[Input].getCost())
                {
                    System.out.println();
                    System.out.println();
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("Go fight you need more money");
                    System.out.println("Your money: " + MotherShipShips[0].getMoney());
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                }
                else
                {
                    System.out.println();
                    System.out.println();
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("              !! Ship Bought !!                ");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

                    FleetMain.AddShip(ShipShop[Input]);
                    MotherShipShips[0].setMoney(MotherShipShips[0].getMoney() - ShipShop[Input].getCost());
                    System.out.println("                  Money: " + MotherShipShips[0].getMoney());
                }
            }

            if (Input == 3)
            {
                FleetMain.ListShips();
            }

            if (Input == 4)
            {
                Game = false;
            }
        }
    }
}
