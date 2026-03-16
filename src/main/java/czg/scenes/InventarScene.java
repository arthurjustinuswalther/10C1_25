/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package czg.scenes;

import static czg.MainWindow.HEIGHT;
import java.awt.Color;
import java.awt.Graphics2D;
import czg.objects.BackdropObject;
import static czg.MainWindow.WIDTH;
import czg.objects.ButtonObject;
import czg.objects.ItemObject;
import czg.objects.PlayerObject;
import czg.util.Images;
import czg.util.Draw;

public class InventarScene extends BaseScene {
    
    private static final int iLeft = (int)(WIDTH * 0.05);
    private static final int iTop = (int)(HEIGHT * 0.675);
    private static final int iWidth = (int)(WIDTH * 0.75);
    private static final int iHeight = (int)(HEIGHT * 0.28);
    private static final int iPadding = (int)(WIDTH * 0.025);
    
    
    
    public InventarScene() {
        ButtonObject exit = new ButtonObject (
                Images.get("/assets/minigames/general/button_menu.png"),
            
                () -> SceneStack.INSTANCE.pop()
        );  
   
        exit.x = 440;
        exit.y = (HEIGHT/2) - (exit.height/2);
        objects.add(exit);
    }
    
    @Override
    public void draw(Graphics2D g) {

        
        g.setColor(new Color(64, 62, 57));
        g.fillRect(iLeft, iTop, iWidth, iHeight);
        
        for(int i = 0; i < PlayerObject.INSTANCE.inventar.size(); i++) {
            ItemObject item = PlayerObject.INSTANCE.inventar.get(i);
            
            g.drawImage(item.SPRITE, iLeft + (int)(WIDTH * 0.025) + (item.SPRITE.getWidth(null) + iPadding) * i, iTop + ((int)(HEIGHT*0.05)), null);
            //drawTextCentered();
        }
    }
    
}
