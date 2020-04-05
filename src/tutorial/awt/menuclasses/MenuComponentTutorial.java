/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.awt.menuclasses;

import java.awt.*;
import javax.accessibility.*;

/**
 *
 * @author Hossam
 */
public class MenuComponentTutorial {
    // @fields
    //--------
    //--------
    // @constructors
    //--------------
    // new menu component

    /**
     *
     */
    public static MenuComponent mcNew = new MenuComponent(){
        
    };
    //--------------
    // @methods
    //---------
    public static void vMethods() {
        // get accessible context
        AccessibleContext aContext = mcNew.getAccessibleContext();
        // get font of menu component
        Font font = mcNew.getFont();
        // get name of menu component
        String name = mcNew.getName();
        // get parent container of menu component
        MenuContainer mContain = mcNew.getParent();
        // remove peer for menu component
        mcNew.removeNotify();
        // set font for menu component
        mcNew.setFont(font);
        // set name for menu component
        mcNew.setName(name);
        // get menu component as string
        System.out.println(mcNew.toString());
        
        // some protected & inherited methods
    }
    //---------
}
