package Utils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class DialogRobot {
    private static Robot robot;

    static {
     try {
      robot = new Robot();
     } catch (AWTException e) {
      e.printStackTrace();
     }
    }
    public static void paste() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
    public static void pressEnter() {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public static void openSearchBar() {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
    public static void addToClipBoard(String str) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(str);
        clipboard.setContents(stringSelection, null);
    }
}
