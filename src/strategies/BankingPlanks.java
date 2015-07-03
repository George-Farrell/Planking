package strategies;

import main.LordPlanking;
import org.parabot.core.ui.Logger;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Bank;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;

public class BankingPlanks implements Strategy{
    @Override
    public boolean activate() {
        return Inventory.getCount(LordPlanking.PLANK_ID) == 28 && Players.getMyPlayer().getAnimation() == -1 ;
    }

    @Override
    public void execute() {
        Logger.addMessage("Banking", true);
        Bank.open();
        Time.sleep(new SleepCondition() {
            @Override
            public boolean isValid() {
                return Bank.isOpen();
            }
        }, 2500);
        Menu.sendAction(646,1438,58,21012);
        Time.sleep(new SleepCondition() {
            @Override
            public boolean isValid() {
                return Inventory.isEmpty();
            }
        }, 2500);
        Bank.withdraw(LordPlanking.LOG_ID, 28, 500);
        Time.sleep(new SleepCondition() {
            @Override
            public boolean isValid() {
                return Inventory.isFull();
            }
        },2500);
        Bank.close();
    }
}
