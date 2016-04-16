/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewPerusahaan;

import java.awt.event.ActionListener;

/**
 *
 * @author toshiba
 */
public interface View {
    
    public void addListener(ActionListener e);
    public void viewErrorMsg(String errorMsg);
}
