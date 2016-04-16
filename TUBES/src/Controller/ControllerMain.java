/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author toshiba
 */
import viewMain.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Date;
import javafx.application.Application;
import Model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class ControllerMain implements ActionListener {

    private Aplikasi model;
    private View view;
    private Pelamar pel;
    private Perusahaan per;

    public ControllerMain(Aplikasi model) {
        this.model = model;
        Login l = new Login();
        l.setVisible(true);
        l.addListener((ActionListener) this);
        view = (View) l;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (view instanceof Login) {
            Login l = (Login) view;
            if (source.equals(l.getjButton1())) {
                if (l.getjComboBox1() == "Perusahaan") {

                    if (model.cariIdPerusahaan(l.getjTextField1()) != null) {
                        per = model.getPerusahaan(l.getjTextField1());
                        ProfilePerusahaan p = new ProfilePerusahaan();
                        p.setVisible(true);
                        p.addListener(this);
                        l.dispose();
                        view = (View) p;
                    } else if (model.cariIdPerusahaan(l.getjTextField1()) == null) {
                        l.reset();
                    }
                } else if (l.getjComboBox1() == "Pelamar") {
                    if (source.equals(l.getjButton1())) {
                        if (model.cariIdPelamar(l.getjTextField1()) != null) {
                            pel = model.getPelamar(l.getjTextField1());
                            ProfilePelamar p = new ProfilePelamar();
                            p.setVisible(true);
                            p.addListener(this);
                            l.dispose();
                            view = (View) p;
                        } else if (model.cariIdPelamar(l.getjTextField1()) == null) {
                            l.reset();
                        }
                    }
                }
            } else if (source.equals(l.getjButton2())) {
                Register r = new Register();
                r.setVisible(true);
                r.addListener(this);
                l.dispose();
                view = r;
            }
        } else if (view instanceof Register) {
            Register r = (Register) view;
            if (source.equals(r.getjButton1())) {
                if (r.getjComboBox1() == "Perusahaan") {
                    if (model.cariIdPerusahaan(r.getjTextField3()) == null) {
                        ProfilePerusahaan p = new ProfilePerusahaan();
                        Perusahaan prsh = new Perusahaan(r.getjTextField3(), r.getjTextField1(), r.getjTextField2(), (long) Double.parseDouble(r.getjTextField4()));
                        model.addPerusahaan(prsh);
                        try {
                            model.savePerusahaan();
                        } catch (IOException ex) {
                            Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        p.setVisible(true);
                        p.addListener(this);
                        r.dispose();
                        view = (View) p;

                    } else {
                        r.reset();

                    }
                } else if (r.getjComboBox1() == "Pelamar") {
                    if (model.cariIdPelamar(r.getjTextField3()) == null) {
                        ProfilePelamar p = new ProfilePelamar();
                        Pelamar plmr = new Pelamar(r.getjTextField3(), r.getjTextField1(), r.getjTextField2(), (long) Double.parseDouble(r.getjTextField4()));
                        model.addPelamar(plmr);
                        try {
                            model.savePelamar();
                        } catch (IOException ex) {
                            Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        p.setVisible(true);
                        p.addListener(this);
                        r.dispose();
                        view = (View) p;

                    } else {
                        r.reset();
                    }
                }
            } else if (source.equals(r.getjButton2())) {
                Login l = new Login();
                l.setVisible(true);
                l.addListener(this);
                r.dispose();
                view = l;
            }

        } else if (view instanceof ProfilePelamar) {
            ProfilePelamar p = (ProfilePelamar) view;
            String currentView;
            JPanel mainPanel;
            LihatLowongan ll = new LihatLowongan();
            CariLowongan cl = new CariLowongan();
            CreateBerkas cb = new CreateBerkas();

            ll.addListener(this);
            cb.addListener(this);

            mainPanel = p.getjPanel1();
            mainPanel.add(ll, "0");
            mainPanel.add(cl, "1");
            mainPanel.add(cb, "2");
            currentView = "0";
            p.getCardLayout().show(mainPanel, currentView);
            p.setVisible(true);
            p.addListener(this);

            if (source.equals(p.getjButton3())) {
                try {
                    model.savePelamar();
                } catch (IOException ex) {
                    p.viewErrorMsg(ex.getMessage());
                }
                System.exit(0);
            } else if (source.equals(p.getjButton1())) {
                currentView="0";
                p.getCardLayout().show(mainPanel, currentView);
            } else if (source.equals(p.getjButton4())) {
                currentView="1";
                p.getCardLayout().show(mainPanel, currentView);
            } else if (source.equals(p.getjButton2())) {
                currentView="2";
                p.getCardLayout().show(mainPanel, currentView);
            }

        }else if (view instanceof ProfilePerusahaan) {
            ProfilePerusahaan p = (ProfilePerusahaan) view;
            String currentView;
            JPanel mainPanel;
            ListPelamarMasuk lp = new ListPelamarMasuk();
            CreateLowongan cl = new CreateLowongan();
            TerimaBerkas tb = new TerimaBerkas();

            tb.addListener(this);
            cl.addListener(this);

            mainPanel = p.getjPanel1();
            mainPanel.add(lp, "0");
            mainPanel.add(cl, "1");
            mainPanel.add(tb, "2");
            currentView = "0";
            p.getCardLayout().show(mainPanel, currentView);
            p.setVisible(true);
            p.addListener(this);

            if (source.equals(p.getjButton3())) {
                try {
                    model.savePelamar();
                } catch (IOException ex) {
                    p.viewErrorMsg(ex.getMessage());
                }
                System.exit(0);
            } else if (source.equals(p.getjButton2())) {
                currentView="0";
                p.getCardLayout().show(mainPanel, currentView);
            } else if (source.equals(p.getjButton1())) {
                currentView="1";
                p.getCardLayout().show(mainPanel, currentView);
            } else if (source.equals(p.getjButton4())) {
                currentView="2";
                p.getCardLayout().show(mainPanel, currentView);
            }

        }
    }

}
