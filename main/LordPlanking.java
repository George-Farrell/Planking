package main;


import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import strategies.BankingPlanks;
import strategies.Planking;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;

@ScriptManifest(author = "Lord",
        category = Category.OTHER,
        description = "Makes all planks on IKOV",
        name = "LordPlanking",
        servers = { "Ikov" },
        version = 1.1)

public class LordPlanking extends Script implements Paintable {
        private static ArrayList<Strategy> strategies = new ArrayList<Strategy>();
        public static int LOG_ID;
        public static int PLANK_ID;
        public static long startTime;
        public static int PLANKS_MADE;
        private final Color color1 = new Color(255, 255, 255);
        private final Font font1 = new Font("Arial", 0, 14);
        private final Image img1 = getImage("http://i.imgur.com/uHQnKCL.png");

        public boolean onExecute() {
                UI Gui = new UI();
                Gui.setVisible(true);
                while (Gui.isVisible()) {
                        sleep(20);
                }
                startTime = System.currentTimeMillis();
                strategies.add(new Planking());
                strategies.add(new BankingPlanks());
                provide(strategies);
                return true;
        }

        public static String runTime(long i) {

                DecimalFormat nf = new DecimalFormat("00");
                long millis = System.currentTimeMillis() - i;
                long hours = millis / (1000 * 60 * 60);
                millis -= hours * (1000 * 60 * 60);
                long minutes = millis / (1000 * 60);
                millis -= minutes * (1000 * 60);
                long seconds = millis / 1000;
                return nf.format(hours) + ":" + nf.format(minutes) + ":" + nf.format(seconds);
        }
        private Image getImage(String url) {
                try {
                        return ImageIO.read(new URL(url));
                } catch(IOException e) {
                        return null;
                }
        }

        public void paint(Graphics g1) {
                {
                        Graphics2D g = (Graphics2D)g1;
                        g.drawImage(img1, -4, 248, null);
                        g.setFont(font1);
                        g.setColor(color1);
                        g.drawString(" " + LordPlanking.PLANKS_MADE, 120, 431);
                        g.drawString(" " + runTime(startTime), 90, 399);
                }
        }
        //END: Code generated using Enfilade's Easel
}