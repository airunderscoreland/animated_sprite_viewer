/*
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
 */
package animated_sprite_viewer.events;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JList;
import sprite_renderer.*;

/**
 *
 * @author Andrew Ireland
 */
public class AnimationStateSelectedListener implements ItemListener {

    private SceneRenderer renderer;
    private JList list;
    private HashMap<String, SpriteType> map;
    private ArrayList<Sprite> spriteList;
    
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
    }
    
    @Override
    /**
     * start rendering the selected sprite type's animation state
     */
    public void itemStateChanged(ItemEvent e) 
    {
        String itemSelected = ((JComboBox)e.getSource()).getModel().getSelectedItem().toString();
        SpriteType type = map.get(list.getSelectedValue().toString());
        Sprite selectedSprite = new Sprite(type, AnimationState.valueOf(itemSelected));
        selectedSprite.setPositionX(300);
        selectedSprite.setPositionY(100);
        spriteList.clear();
        spriteList.add(selectedSprite);
        renderer.startScene();
    }
    
}
