/*
 * 
 */
package animated_sprite_viewer.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sprite_renderer.AnimationState;
import sprite_renderer.SpriteType;

/**
 *
 * @author Andrew Ireland
 */
public class SpriteTypeSelectionListener implements ListSelectionListener {

    private DefaultComboBoxModel model;
    private HashMap<String, SpriteType> spriteTypes;
    
    public SpriteTypeSelectionListener( DefaultComboBoxModel cbmodel, HashMap<String,SpriteType> st) 
    {
        model = cbmodel;
        spriteTypes = st;
    }
    
    @Override
    /**
     * this should take the list item clicked and add the animation states
     * to the combo box
     */
    public void valueChanged(ListSelectionEvent e) 
    {
        String spriteTypeName = model.getSelectedItem().toString();
        SpriteType spriteType = spriteTypes.get(spriteTypeName);
        Iterator<AnimationState> animationIT = spriteType.getAnimationStates();
        while (animationIT.hasNext()) {
            AnimationState state = animationIT.next();
            model.addElement(state);
        }
    }
    
}
