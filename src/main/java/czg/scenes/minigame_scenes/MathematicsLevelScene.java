package czg.scenes.minigame_scenes;

import czg.MainWindow;
import czg.objects.BaseObject;
import czg.objects.Department;
import czg.objects.minigame_objects.MathematicsPuzzleObject;
import czg.objects.minigame_objects.TangramPieceObject;
import czg.util.Images;

import java.util.Arrays;

public class MathematicsLevelScene extends LevelScene {
    public MathematicsLevelScene(int level) {
        super(Department.MATHEMATICS, level);
        
        MathematicsPuzzleObject puzzle = MathematicsPuzzleObject.getPuzzle(level);
        
        puzzle.reset();
         
        objects.addAll(Arrays.asList(TangramPieceObject.PIECES));

        BaseObject puzzleObject = new BaseObject(puzzle.sprite, 0, 0);
        
        int size = MainWindow.HEIGHT / 2;
        double scale = Images.get("/assets/minigames/mathematics/tangram_packed.png").getWidth(null) / (double) size;
    
        
        puzzleObject.width *= scale;
        puzzleObject.height *= scale;

        puzzleObject.x = (int) (MainWindow.WIDTH - puzzleObject.width - MainWindow.WIDTH*0.1);
        puzzleObject.y = (MainWindow.HEIGHT - puzzleObject.height)/2;

        objects.add(puzzleObject);
    }
}
