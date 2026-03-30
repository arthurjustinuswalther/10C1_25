package czg.scenes.minigame;
import czg.objects.BackdropObject;
import czg.objects.ButtonObject;
import czg.objects.Department;
import czg.objects.minigame.ChemieGameObject;
import czg.scenes.BaseScene;
import czg.scenes.SceneStack;
import czg.util.Images;

/* Scene über vom LevelSelectorScene aufgerufen.
 */
public class ChemieLevelScene extends LevelScene {
    /**
     * @param level Das zu spielende Level (1–3)
     */
    public ChemieLevelScene(int level) {
        super(Department.CHEMISTRY,level);
    // Hintergrund
        objects.add(new BackdropObject(
                Images.get("/assets/minigames/chemistry/ChemieBackground.png")));
    // Chemie-Spielobjekt (enthält gesamte Spiellogik)
        objects.add(new ChemieGameObject(level, this));
    }
    
    @Override
    public LevelScene reset() {
        return new ChemieLevelScene(LEVEL);
    }
}