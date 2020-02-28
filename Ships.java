import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Ships
{
    Scanner in = new Scanner(System.in);
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    private String Name;
    private double HP;
    private double ArmorPoints;
    private double Damage;
    private int Cost;
    private Ships[] ShipShop = new Ships[100];

    Ships(String _Name)
    {
        Name = _Name;
        HP = (int)(Math.random()*2000)+ 1300;
        ArmorPoints = (int)(Math.random()*750) + 250;
        Damage = 250;
    }

    Ships(String _Name, double _HP, double _ArmorPoints, int _Cost, double _Damage)
    {
        Name = _Name;
        HP = _HP;
        ArmorPoints = _ArmorPoints;
        Cost = _Cost;
        Damage = _Damage;
    }

    Ships(double _HP, double _ArmorPoints, double _Damage)
    {
        String[] _name = {"Star Fighter", "The Chosen One", "Master Palpatine", "General Taco", "Master Yoda"};
        int Number = (int)(Math.random()*4) + 1;
        Name = _name[Number];

        HP = _HP;
        ArmorPoints = _ArmorPoints;
        Damage = _Damage;
    }

    void Information() {
        System.out.println(" *  " + Name + "  *  HP: " + df2.format(HP) + "  *  Armor: " + df2.format(ArmorPoints)+ "  *  Attack: " + Damage);
    }

    void InformationCost() {
        System.out.println(" *  " + Name + "  *  HP: " + HP + "  *  Armor: " + ArmorPoints + "  *  Attack: " + Damage + "  *  Cost: " + Cost); }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getHP() {
        return HP;
    }

    public void setHP(double HP) {
        this.HP = HP;
    }

    public double getArmorPoints() {
        return ArmorPoints;
    }

    public void setArmorPoints(double armorPoints) {
        ArmorPoints = armorPoints;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public double getDamage() {

        return Damage;
    }

    public void setDamage(double damage) {
        Damage = damage;
    }
}
