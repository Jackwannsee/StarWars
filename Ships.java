import java.beans.beancontext.BeanContextServiceRevokedEvent;

public class Ships
{
    private String Name;
    private double HP;
    private double ArmorPoints;
    private int Cost;

    Ships()
    {
        String[] _name = {"Star Fighter", "The Chosen One", "Master Palpatine", "General Taco", "Master Yoda"};
        int Number = (int)(Math.random()*4) + 1;
        Name = _name[Number];

        HP = (int)(Math.random()*2000)+ 1300;
        ArmorPoints = (int)(Math.random()*750) + 250;
    }

    Ships(String _Name)
    {
        Name = _Name;
        HP = (int)(Math.random()*2000)+ 1300;
        ArmorPoints = (int)(Math.random()*750) + 250;
    }

    Ships(String _Name, double _HP, double _ArmorPoints, int _Cost)
    {
        Name = _Name;
        HP = _HP;
        ArmorPoints = _ArmorPoints;
        Cost = _Cost;
    }

    void Information()
    {
        System.out.println(" *  " + Name + "  *  HP: " + HP + "  *  Armor: " + ArmorPoints);
    }

    void InformationCost() {System.out.println(" *  " + Name + "  *  HP: " + HP + "  *  Armor: " + ArmorPoints + "  *  Cost: " + Cost); }

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
}
