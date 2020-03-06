import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MotherShip
{
    Scanner in = new Scanner(System.in);

    private String Name;
    private int Money=1500;
    private int Wins = 0;
    private int Losses = 0;
    private Ships[] Fleet = new Ships[100];

    MotherShip()
    {
        Name = "Death Star";
        Money = 1500;
        Wins = 0;
        Losses =0;
    }

    MotherShip(String _Name, int _Money)
    {
        Name = _Name;
        Money =_Money;
    }

    void ListShips()
    {
        System.out.println();
        boolean Ships = false;
        System.out.println("-=-=-=-=-=-=-=-=-= Your Ships =-=-=-=-=-=-=-=-=-");
        for (int i = 0; i < Fleet.length; i++)
        {
            if(Fleet[i] != null)
            {
                System.out.print((i+1) + ". ");
                Fleet[i].Information();
                Ships = true;
            }
        }
        if(Ships == false)
        {
            System.out.println("You have 0 Ships go buy some");
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }

    void AdjustShips (MotherShip Mothership) throws InterruptedException {
        System.out.println("");
        System.out.println("");
        System.out.println("-=-=-=-= Ships/ Details =-=-=-=-");
        System.out.println("1. REMOVE Ships");
        System.out.println("2. UPGRADE Ships");
        System.out.println("3. MotherShip Information");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.print("  --> ");

        while (!in.hasNextInt())
        {
            System.out.print("  --> ");
            in.nextLine();
        }
        int Input = in.nextInt();

        if(Input == 1)
        {
            Mothership.ListShips();
            System.out.println("This will give you about 50% of what you paid");
            System.out.print("# of ship to REMOVE --> ");

            while (!in.hasNextInt())
            {
                System.out.print("  --> ");
                in.nextLine();
            }
            int NextInput = in.nextInt();
            NextInput = NextInput - 1;

            Mothership.setMoney(Mothership.getMoney() + (Fleet[NextInput].getCost() / 2));
            Fleet[NextInput] = null;
            System.out.println("!! Ship Removed !!");

            List<Ships> values = new ArrayList<Ships>();
            for(Ships data: Fleet) {
                if(data != null) {
                    values.add(data);
                }
            }
            Fleet = values.toArray(new Ships[values.size()]);
        }

        if(Input == 2)
        {
            Mothership.ListShips();

            System.out.println();
            System.out.println("This will cost you 500$ to upgrade your ship by 25%");
            System.out.print("# of ship to UPGRADE --> ");

            int Limit = Mothership.NumberOfShips() + 1;
            boolean ShipsNotSelected = true;
            int InputShip = 0;

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

            Fleet[InputShip].setHP(Fleet[InputShip].getHP() * 1.25);
            Fleet[InputShip].setArmorPoints(Fleet[InputShip].getArmorPoints() * 1.25);
            Fleet[InputShip].setDamage(Fleet[InputShip].getDamage() * 1.25);

            System.out.println();
            System.out.print("New Stats ");
            Fleet[InputShip].Information();
            Mothership.setMoney(Mothership.getMoney() - 500);
            Thread.sleep(1000);
        }
        if(Input == 3)
        {
            System.out.println();
            System.out.println("Name: " + Mothership.getName());
            System.out.println("Money: " + Mothership.getMoney());
            System.out.println("Wins: " + Mothership.getWins());
            System.out.println("Losses: " + Mothership.getLosses());
            System.out.println("# of Ships: " + Mothership.NumberOfShips());
            System.out.println("# of Wins: " + NumberOfWins());
            System.out.println(("# of Losses: " + NumberOfLosses()));
            Thread.sleep(1500);
        }
    }

    int NumberOfLosses()
    {
        int NumberLosses = 0;
        for (int i = 0; i < Fleet.length; i++)
        {
            if(Fleet[i] != null)
            {
                NumberLosses = NumberLosses + Fleet[i].getLosses();
            }
        }
        return NumberLosses;
    }

    int NumberOfWins()
    {
        int NumberWins = 0;
        for (int i = 0; i < Fleet.length; i++)
        {
            if(Fleet[i] != null)
            {
                NumberWins = NumberWins + Fleet[i].getWins();
            }
        }
        return NumberWins;
    }

    int NumberOfShips()
    {
        int NumberOfShips = 0;
        for (int i = 0; i < Fleet.length; i++)
        {
            if(Fleet[i] != null)
            {
                NumberOfShips++;
            }
        }
        return NumberOfShips;
    }

    void AddShip(Ships S1)
    {
        for (int i = 0; i < Fleet.length; i++)
        {
            if(Fleet[i] == null)
            {
                Fleet[i] = S1;
                break;
            }
        }
    }

    void RemoveShip(int NumberOfShip)
    {
        Fleet[NumberOfShip] = null;
    }

    Ships[] ShipShop = new Ships[16];
    {
        ShipShop[0] = new Ships("Battle Droid", 1400, 500, 1500,250);
        ShipShop[1] = new Ships("Star Fighter", 1500, 550, 1550,250);
        ShipShop[2] = new Ships("Star Blaster", 1600, 600, 1600,250);
        ShipShop[3] = new Ships("Alpha Blaster", 1700, 650, 1700,300);
        ShipShop[4] = new Ships("Beta Blaster", 1800, 700, 1800,300);
        ShipShop[5] = new Ships("Gamma Blaster", 1900, 750, 1900,300);
        ShipShop[6] = new Ships("Trojan", 1950, 800, 1950,350);
        ShipShop[7] = new Ships("Karkinos", 2000, 850, 2000,350);
        ShipShop[8] = new Ships("Inferno", 2050, 900, 2050,350);
        ShipShop[9] = new Ships("LightSpeed", 2100, 950, 2100,400);
        ShipShop[10] = new Ships("Project X", 2150, 1000, 2150,400);
        ShipShop[11] = new Ships("Purge", 2200, 1050, 22001,450);
        ShipShop[12] = new Ships("Herculues", 2250, 1100, 2250,450);
        ShipShop[13] = new Ships("Hippocrates", 2300, 1200, 2300,500);
        ShipShop[14] = new Ships("Atomic Blaster", 2500, 1500, 2500,550);
        ShipShop[15] = new Ships("Taco God", 5000, 3000, 10000,700);
    }

    void BuyShip(MotherShip MotherShip)
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

        int BuyInput = in.nextInt();
        BuyInput = BuyInput -1;

        System.out.print("Chosen Ship " + (BuyInput+1) + " ");
        ShipShop[BuyInput].InformationCost();

        if(MotherShip.getMoney() < ShipShop[BuyInput].getCost())
        {
            System.out.println();
            System.out.println();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("         Go fight you need more money          ");
            System.out.println("                Your money: " + MotherShip.getMoney());
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }
        else
        {
            System.out.println();
            System.out.println();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("              !! Ship Bought !!                ");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            for (int i = 0; i < Fleet.length; i++)
            {
                if(Fleet[i] == null)
                {
                    Fleet[i] = ShipShop[BuyInput];
                    break;
                }
            }
            MotherShip.setMoney(MotherShip.getMoney() - ShipShop[BuyInput].getCost());
            System.out.println("                Money: " + MotherShip.getMoney());
        }
    }

    Ships GetShip(int X)
    {
        return Fleet[X];
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }

    public int getWins() {
        return Wins;
    }

    public void setWins(int wins) {
        Wins = wins;
    }

    public int getLosses() {
        return Losses;
    }

    public void setLosses(int losses) {
        Losses = losses;
    }

    public Ships[] getFleet() {
        return Fleet;
    }

    public void setFleet(Ships[] fleet) {
        Fleet = fleet;
    }
}
