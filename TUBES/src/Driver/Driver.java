/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.ControllerMain;
import Model.Aplikasi;
import ViewConsole.Console;
import java.io.IOException;

/**
 *
 * @author FebbyFebriansyah
 */
public class Driver {

    public static void main(String[] args) throws IOException {
        Aplikasi app = new Aplikasi();
        ControllerMain c=new ControllerMain(app);
    }
}
