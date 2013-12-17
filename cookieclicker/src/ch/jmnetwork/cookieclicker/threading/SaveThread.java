package ch.jmnetwork.cookieclicker.threading;

import ch.jmnetwork.cookieclicker.ui.CCUserInterface;
import ch.jmnetwork.cookieclicker.util.CryptedSLHandler;

public class SaveThread implements Runnable {
    CCUserInterface ccui;
    CryptedSLHandler cslhandler;

    public SaveThread(CCUserInterface ccuserI, CryptedSLHandler cslhandler) {
        ccui = ccuserI;
        this.cslhandler = cslhandler;
    }

    @Override
    public void run() {
        ccui.setInfoMessage("Saving game...");
        System.out.println("\n[CC] Saving...");
        cslhandler.save();
        System.out.println("[CC] Saving complete.\n");
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
        }
        ccui.setInfoMessage("");
    }
}
