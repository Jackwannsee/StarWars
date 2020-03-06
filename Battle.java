import java.util.Scanner;
import java.text.DecimalFormat;


public class Battle {
    Scanner in = new Scanner(System.in);
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    int BattleNumber = 1;   //Starts at 1 otherwise it looks weird if it is 0
    double PlayerDamage;
    double EnemyDamage;
    double Random;

    Notifications Notification = new Notifications();

    public Battle(Ships Player, MotherShip MotherShip, int NumberOfShip) throws InterruptedException
    {
        if (Player.getHP() > 0) {
            double OriginalHP = Player.getHP();
            double OriginalArmor = Player.getArmorPoints();

            Random = (Math.random() * (1.05 - 0.6)) + 0.6;
            double TempHP = Player.getHP() * Random;

            Random = (Math.random() * (1.05 - 0.6)) + 0.6;
            double TempArmor = Player.getArmorPoints() * Random;

            Random = (Math.random() * (1.05 - 0.65)) + 0.65;
            double TempDamage = Player.getDamage() * Random;

            Ships TempEnemy = new Ships(TempHP, TempArmor, TempDamage);

            System.out.println();
            System.out.println("Rules: \n1) DIE = Lose Ship      \n2) Both Die = Restore Ship");
            System.out.println("Note:   Player Damage Varies");
            System.out.println();

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

                PlayerDamage = Player.getDamage() + BattleNumber * (int) (Math.random() * 100 + 1);
                if (TempEnemy.getArmorPoints() > 0) {
                    TempEnemy.setArmorPoints(TempEnemy.getArmorPoints() - PlayerDamage * 0.75);
                    TempEnemy.setHP(TempEnemy.getHP() - PlayerDamage * 0.25);

                    if (TempEnemy.getArmorPoints() < 0) {
                        TempEnemy.setHP(TempEnemy.getHP() + TempEnemy.getArmorPoints());
                        TempEnemy.setArmorPoints(0);
                    }
                }
                else {
                    TempEnemy.setHP(TempEnemy.getHP() - PlayerDamage);
                }

                EnemyDamage = TempEnemy.getDamage() + BattleNumber * (int) (Math.random() * 100 + 1);
                if (Player.getArmorPoints() > 0) {
                    Player.setArmorPoints(Player.getArmorPoints() - PlayerDamage * 0.75);
                    Player.setHP(Player.getHP() - PlayerDamage * 0.25);

                    if (Player.getArmorPoints() < 0) {
                        Player.setHP(Player.getHP() + Player.getArmorPoints());
                        Player.setArmorPoints(0);
                    }
                }
                else {
                    Player.setHP(Player.getHP() - EnemyDamage);
                }

                BattleNumber = BattleNumber + 1;
            }

            if (Player.getHP() <= 0 && TempEnemy.getHP() < 0) {
                System.out.println();
                System.out.println("You have both died");
                System.out.println();
                Thread.sleep(1000);
                System.out.print("Clap  ");
                Thread.sleep(1000);
                System.out.println("Clap");
                Thread.sleep(2000);

                Player.setHP(OriginalHP);
                Player.setArmorPoints(OriginalArmor);
            }

            else if (Player.getHP() <= 0)
            {
                System.out.println();
                System.out.println("Your Ship got demolished in battle ... your ship has been removed");
                System.out.println("Enemy HP: " + df2.format(TempEnemy.getHP()));
                Player.setLosses(Player.getLosses() + 1);
                MotherShip.RemoveShip(NumberOfShip);
                Thread.sleep(2000);
            }

            else if (TempEnemy.getHP() <= 0)
            {
                System.out.println();
                System.out.println("You have demolished the Enemy");
                System.out.println("Your HP: " + df2.format(Player.getHP()));
                System.out.println("You have gained 2000$");
                MotherShip.setMoney(MotherShip.getMoney() + 2000);
                Player.setWins(Player.getWins() + 1);
                Thread.sleep(1700);
            }
        }
        else
        {
            System.out.println("Your ship is dead please buy a new ship or repair this one");
        }
    }
}
