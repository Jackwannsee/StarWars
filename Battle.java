import java.time.Period;
import java.util.Scanner;
import static java.lang.Thread.currentThread;
import java.util.concurrent.TimeUnit;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class Battle
{
    Scanner in = new Scanner(System.in);
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    boolean Game = true;
    int BattleNumber = 1;   //Starts at 1 otherwise it looks weird if it is 0
    double PlayerDamage;
    Double RandomChance;

    public Battle(Ships Player) throws InterruptedException
    {
        if(Player.getHP() > 0) {
            double TempHP = Player.getHP() * (Math.random() * 1.1) + 0.9;
            double TempArmor = Player.getArmorPoints() * (Math.random() * 1.1) + 0.9;
            double TempDamage = Player.getDamage() * (Math.random() * 1.1) + 0.9;
            Ships TempEnemy = new Ships(TempHP, TempArmor, TempDamage);

            System.out.println();
            System.out.println("Note:   Player Damage Varies");
            while (TempEnemy.getHP() >= 0 && Player.getHP() >= 0) {
                System.out.println("-=-=-=-=-=-=-=-=-= Battle " + BattleNumber + " =-=-=-=-=-=-=-=-=-");

                System.out.print("Your Fighter ");
                Player.Information();
                System.out.print("Enemy Fighter");
                TempEnemy.Information();

                System.out.println();
                System.out.println("            !! Press Enter to FIGHT !!");
                System.out.print("                      ");
                in.nextLine();

                RandomChance = Math.random();
                PlayerDamage = Player.getDamage() * (BattleNumber * 0.5) * RandomChance;
                if (TempEnemy.getArmorPoints() <= 0) {
                    TempEnemy.setHP(TempEnemy.getHP() - PlayerDamage);
                } else {
                    TempEnemy.setHP(TempEnemy.getHP() - PlayerDamage * 0.75);
                    TempEnemy.setArmorPoints(TempEnemy.getArmorPoints() - PlayerDamage * 0.25);
                }

                RandomChance = Math.random();
                PlayerDamage = 0;
                PlayerDamage = TempEnemy.getDamage() * (BattleNumber * 0.5) * RandomChance;
                if (Player.getArmorPoints() <= 0) {
                    Player.setHP(Player.getHP() - PlayerDamage);
                } else {
                    Player.setHP(Player.getHP() - PlayerDamage * 0.75);
                    Player.setArmorPoints(Player.getArmorPoints() - PlayerDamage * 0.25);
                }

                BattleNumber = BattleNumber + 1;
            }

            if (Player.getHP() <= 0 && TempEnemy.getHP() < 0)
            {
                System.out.println();
                System.out.println("You have both died");
                System.out.println();
                Thread.sleep(1000);
                System.out.print("Clap  ");
                Thread.sleep(1000);
                System.out.println("Clap");
                Thread.sleep(2000);
            }

            else if (Player.getHP() <= 0)
            {
                System.out.println();
                System.out.println("Your Ship got demolished in battle");
                System.out.println("Enemy HP: " + df2.format(TempEnemy.getHP()));
                Thread.sleep(2000);
            }

            else if (TempEnemy.getHP() <= 0)
            {
                System.out.println();
                System.out.println("You have demolished the Enemy");
                System.out.println("Your HP: " + df2.format(Player.getHP()));
                Thread.sleep(2000);
            }
        }
        else
        {
            System.out.println("Your ship is dead please buy a new ship or repair this one");
        }
    }
}
