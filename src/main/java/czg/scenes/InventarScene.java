package czg.scenes;

import czg.objects.BaseObject;
import czg.objects.ButtonObject;
import czg.objects.ItemObject;
import czg.objects.PlayerObject;
import czg.util.Draw;
import czg.util.Images;

import java.awt.*;

import static czg.MainWindow.*;

public class InventarScene extends BaseScene {

    /**
     * X-Koordinate der linken Seite
     */
    private static final int iLeft = (int)(WIDTH * 0.03);
    /**
     * Y-Koordinate der oberen Seite
     */
    private static final int iTop = (int)(HEIGHT * 0.03);
    /**
     * Breite des Inventars
     */
    private static final int iWidth = WIDTH - 2 * iLeft;
    /**
     * Höhe des Inventars
     */
    private static final int iHeight = (int)(HEIGHT * 0.3);
    /**
     * Abstand zwischen Items
     */
    private static final int iPadding = (int)(WIDTH * 0.025);


    private final String[] ITEM_NAMES;
    
    public InventarScene() {
        // Items
        ITEM_NAMES = new String[PlayerObject.INSTANCE.inventar.size()];

        int x = iLeft + iPadding;
        for(int i = 0; i < PlayerObject.INSTANCE.inventar.size(); i++) {
            ItemObject item = PlayerObject.INSTANCE.inventar.get(i);

            // Sprite
            BaseObject itemObject = new BaseObject(item.SPRITE, x, iTop + ((int) (HEIGHT * 0.05)));
            objects.add(itemObject);

            // Name speichern
            ITEM_NAMES[i] = item.NAME;

            x += itemObject.width + iPadding;
        }

        // Button zum Schließen
        ButtonObject exit = new ButtonObject (
                Images.get("/assets/minigames/general/button_exit.png"),
                SceneStack.INSTANCE::pop
        );

        exit.x = iLeft + iWidth - iPadding - exit.sprite.getWidth(null) * PIXEL_SCALE;
        exit.y = iTop + (iHeight / 2) - (exit.sprite.getHeight(null) * PIXEL_SCALE )/2;
        objects.add(exit);
    }
    
    @Override
    public void draw(Graphics2D g) {
        // Hintergrund
        g.setColor(new Color(0x9A6B9C));
        g.fillRect(iLeft, iTop, iWidth, iHeight);

        // Text
        g.setColor(Color.WHITE);
        g.setFont(Draw.FONT_TITLE.deriveFont(20f));
        for (int i = 0; i < objects.size()-1; i++) {
            BaseObject itemObject = objects.get(i);
            Draw.drawTextCentered(g, ITEM_NAMES[i], itemObject.x + itemObject.width / 2, itemObject.y + itemObject.height + 32);
        }

        // Objekte
        super.draw(g);
    }
    
}
