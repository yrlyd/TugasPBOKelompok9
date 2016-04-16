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
import viewPerusahaan.Profile;
import Model.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerMain implements ActionListener {

    private Aplikasi model;
    private View view;

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
            if (l.getjComboBox1() == "Pelamar") {
                if (model.cariIdPerusahaan(l.getjTextField1()) != null) {
                    if (source.equals(l.getjButton1())) {
                        viewPerusahaan.Profile p = new viewPerusahaan.Profile();
                        p.setVisible(true);
                        p.addListener(this);
                        l.dispose();
                        view = (View) p;
                    } else if (source.equals(l.getjButton2())) {
                        Register r = new Register();
                        r.setVisible(true);
                        r.addListener(this);
                        l.dispose();
                    }
                } else {
                    l.reset();
                }

            } else if (l.getjComboBox1() == "Perusahaan") {
                if (model.cariIdPelamar(l.getjTextField1()) != null) {
                    if (source.equals(l.getjButton1())) {
                        viewPelamar.Profile p = new viewPelamar.Profile();
                        p.setVisible(true);
                        p.addListener(this);
                        l.dispose();
                        view = (View) p;
                    } else if (source.equals(l.getjButton2())) {
                        Register r = new Register();
                        r.setVisible(true);
                        r.addListener(this);
                        l.dispose();
                    }
                } else {
                    l.reset();
                }
            }
        } else if (view instanceof Register) {
            Register r = (Register) view;
            if (r.getjComboBox1() == "Perusahaan"){
                if (model.cariIdPerusahaan(r.getjTextField3()) == null) {
                    r.reset();   
                } else {
                    viewPerusahaan.Profile p = new viewPerusahaan.Profile();
                    Perusahaan prsh=new Perusahaan(r.getjTextField3(),r.getjTextField1(),r.getjTextField2(), (long) Double.parseDouble(r.getjTextField4()));
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
                    
                }
            } else if (r.getjComboBox1()=="Pelamar"){
                if(model.cariIdPelamar(r.getjTextField3())==null){
                    r.reset();
                } else{
                    viewPelamar.Profile p = new viewPelamar.Profile();
                    Pelamar plmr=new Pelamar(r.getjTextField3(),r.getjTextField1(),r.getjTextField2(), (long) Double.parseDouble(r.getjTextField4()));
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
                }
                
            }

        }
    }

}
