package animated_sprite_viewer.events;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JList;
import sprite_renderer.*;

/**
 * This event listener implements Item Listener to handle ItemEvents
 * which should occur when a selection changes in the ComboBox
 * We want to do the following when this occurs:
 * 
 * -get the animation state just selected
 * -get the sprite type currently selected
 * -construct a sprite of that type and animation state
 * -clear the sprite list (ArrayList)
 * -add it to the sprite list (ArrayList)
 * -start the scene renderer
 * 
 * @author Andrew Ireland
 * 
 * @version 1.0
 */
public class AnimationStateSelectedListener implements ItemListener {

    private SceneRenderer renderer;
    private JList list;
    private HashMap<String, SpriteType> map;
    private ArrayList<Sprite> spriteList;
    private static final String SELECTION_DEFAULT = "Select Animation State";
    private boolean lamefix;
    /**
     * 
     * @param sr
     * @param jl
     * @param hmap
     * @param sl 
     */
    public AnimationStateSelectedListener(SceneRenderer sr, JList jl, HashMap<String, SpriteType> hmap, ArrayList<Sprite> sl)
    {
       renderer = sr;
       list = jl;
       map = hmap;
       spriteList = sl;
       //this variable is used in order to call startScene() only once
       lamefix = true;
    }
    
    @Override
    /**
     * start rendering the selected sprite type's animation state
     */
    public void itemStateChanged(ItemEvent e) 
    {
        if(e.getStateChange() == ItemEvent.SELECTED) {
        String itemSelected = ((JComboBox)e.getSource()).getModel().getSelectedItem().toString();
        //We want to prevent passing "Select Animation State" into the new Sprite
        if (!itemSelected.equals(SELECTION_DEFAULT)) {
            SpriteType type = map.get(list.getSelectedValue().toString());
            Sprite selectedSprite = new Sprite(type, AnimationState.valueOf(itemSelected));
            selectedSprite.setPositionX(300);
            selectedSprite.setPositionY(100);
            spriteList.clear();
            spriteList.add(selectedSprite);
            if (lamefix) {
                renderer.startScene();
                renderer.unpauseScene();
            }
            lamefix = false;
            }
        }
    }
}
