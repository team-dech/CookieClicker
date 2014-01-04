/**************************************************************************************************
 * cookieclicker Copyright (C) 2014 Joel Messerli - JMNetwork.ch                                  *
 *                                                                                                *
 *     This program is free software: you can redistribute it and/or modify                       *
 *     it under the terms of the GNU General Public License as published by                       *
 *     the Free Software Foundation, either version 3 of the License, or                          *
 *     (at your option) any later version.                                                        *
 *                                                                                                *
 *     This program is distributed in the hope that it will be useful,                            *
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of                             *
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the                              *
 *     GNU General Public License for more details.                                               *
 *                                                                                                *
 *     You should have received a copy of the GNU General Public License                          *
 *     along with this program.  If not, see [http://www.gnu.org/licenses/].                      *
 **************************************************************************************************/

package ch.jmnetwork.cookieclicker.ui;

import ch.jmnetwork.cookieclicker.CookieManager;

import javax.swing.*;
import java.awt.event.*;

public class CheatAddCookiesDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private CookieManager manager;

    public CheatAddCookiesDialog(CookieManager manager) {
        this.manager = manager;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {onOK();}
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {onCancel();}
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        manager.addCookies(Integer.parseInt(textField1.getText()));
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }
}
