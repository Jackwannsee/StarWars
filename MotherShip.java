public class MotherShip
{
    private String Name;
    private int Money=1500;
    private int Wins = 0;
    private int Losses = 0;

    Ships[] Fleet = new Ships[100];

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

    void ListShips()
    {
        System.out.println();
        boolean Ships = false;
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
            System.out.println();
            System.out.println("You have 0 Ships go buy some");
        }
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
}
