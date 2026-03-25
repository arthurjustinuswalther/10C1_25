package czg.objects.minigame_objects;

import czg.objects.BaseObject;
import czg.scenes.BaseScene;
import czg.scenes.minigame_scenes.MathematicsLevelScene;
import czg.util.Images;
import czg.util.Input;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class TangramPieceObject extends BaseObject {
    public final int ID;
    private final String SPRITE_PATH;
    public double rotation;
    public MathematicsLevelScene levelScene;

    private boolean isDragged = false;

    private TangramPieceObject(int id) {
       super(Images.get(String.format("/assets/minigames/mathematics/tangram_piece_%02d.png", id)));
       this.ID = id;
       this.SPRITE_PATH = String.format("/assets/minigames/mathematics/tangram_piece_%02d.png", id);
       this.rotation = 0;
       this.levelScene = null;
    }

    public static TangramPieceObject[] generatePieces() {
        return new TangramPieceObject[] {
            new TangramPieceObject(0),
            new TangramPieceObject(1),
            new TangramPieceObject(2),
            new TangramPieceObject(3),
            new TangramPieceObject(4),
            new TangramPieceObject(5),
            new TangramPieceObject(6)
        };
    }

    public static void setLevelScene(TangramPieceObject[] pieces, MathematicsLevelScene levelScene) {
        for (TangramPieceObject piece : pieces) {
            piece.levelScene = levelScene;
        }
    }

    public static void generatePacked(TangramPieceObject[] pieces, int x, int y, int width, int height) {
        pieces[0].x = x;
        pieces[0].y = y;
        pieces[0].width = width;
        pieces[0].height = height/2;
        pieces[0].setRotation(0);
        
        pieces[1].x = x;
        pieces[1].y = y;
        pieces[1].width = width/2;
        pieces[1].height = height;
        pieces[1].setRotation(0);
        
        pieces[2].x = x + width/2;
        pieces[2].y = y + height/2;
        pieces[2].width = width/2;
        pieces[2].height = height/2;
        pieces[2].setRotation(0);
        
        pieces[3].x = x;
        pieces[3].y = y + (int) (height*0.75);
        pieces[3].width = width/2;
        pieces[3].height = height/4;
        pieces[3].setRotation(0);
        
        pieces[4].x = x + width/2;
        pieces[4].y = y + height/4;
        pieces[4].width = width/4;
        pieces[4].height = height/2;
        pieces[4].setRotation(0);
        
        pieces[5].x = x + (int) (width*0.75);
        pieces[5].y = y;
        pieces[5].width = width/4;
        pieces[5].height = (int) (height*0.75);
        pieces[5].setRotation(0);
        
        pieces[6].x = x + width/4;
        pieces[6].y = y + height/2;
        pieces[6].width = width/2;
        pieces[6].height = height/2;
        pieces[6].setRotation(0);
    }

    public void rotate(double degree) {
        rotation += degree;

        rotation %= 360;

        double scaleX = (double) width / sprite.getWidth(null);
        double scaleY = (double) height / sprite.getHeight(null);

        Image rotatedSprite = Images.rotateImage(Images.get(SPRITE_PATH), rotation);

        Point imageCenter = new Point(x + width/2, y + height/2);

        width = (int) (rotatedSprite.getWidth(null) * scaleX);
        height = (int) (rotatedSprite.getHeight(null) * scaleY);

        sprite = rotatedSprite;

        x = imageCenter.x - width/2;
        y = imageCenter.y - height/2;
    }

    public void setRotation(double degree) {
        double currentRotation = rotation;

        rotate(degree - currentRotation);
    }

    @Override
    public void update(BaseScene scene) {
        // Aktuelle und vorherige Maus-Position abfragen
        Point mousePos = Input.INSTANCE.getMousePosition();
        Point lastMousePos = Input.INSTANCE.getLastMousePosition();
        // Diese *können* (technisch gesehen) null sein
        if(mousePos == null || lastMousePos == null)
            return;

        if(! isDragged && isClicked(false)) {
            // Wenn das Objekt angeklickt wird, verschieben wir es an oberste Stelle (z-Achse) und beginnen, es zu ziehen
            scene.objects.remove(this);
            scene.objects.add(this);

            isDragged = true;
        } else if (isDragged && !Input.INSTANCE.getMouseState(MouseEvent.BUTTON1).isDown()) {
            // Wenn die linke Maustaste losgelassen wird, wird das Objekt nicht mehr gezogen
            isDragged = false;
            // Und überprüft, ob das Puzzle gelöst ist
            levelScene.checkPuzzle();
        }

        if (isDragged) {
            // Aktualisierung der Position
            this.x += mousePos.x - lastMousePos.x;
            this.y += mousePos.y - lastMousePos.y;

            // Rotieren des Objektes
            if(Input.INSTANCE.getKeyState(KeyEvent.VK_R) == Input.KeyState.PRESSED) {
                rotate(45);
            }
        }
    }
}
