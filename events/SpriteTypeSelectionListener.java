/*
 * 
 */
package animated_sprite_viewer.events;

import animated_sprite_viewer.AnimatedSpriteViewer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import sprite_renderer.AnimationState;
import sprite_renderer.Sprite;
import sprite_renderer.SpriteType;

/**
 *
 * @author Andrew Ireland
 */
public class SpriteTypeSelectionListener implements ListSelectionListener {

    private DefaultComboBoxModel model;
    private HashMap<String, SpriteType> spriteTypes;
    private ArrayList<Sprite> sprites;
    private JComboBox combobox;
    
    public SpriteTypeSelectionListener(JComboBox cb, DefaultComboBoxModel cbmodel, HashMap<String,SpriteType> st, ArrayList<Sprite> sl) 
    {
        model = cbmodel;
        spriteTypes = st;
        sprites = sl;
        combobox = cb;
    }
    
    @Override
    /**
     * this should take the list item clicked and add the animation states
     * to the combo box then enable the combobox
     */
    public void valueChanged(ListSelectionEvent e) 
    {
        String spriteTypeName = ((JList)e.getSource()).getSelectedValue().toString();
        SpriteType spriteType = spriteTypes.get(spriteTypeName);
        Iterator<AnimationState> animationIT = spriteType.getAnimationStates();
        while (animationIT.hasNext()) {
            AnimationState state = animationIT.next();
            model.addElement(state);
        }
        sprites.clear();
        combobox.setEnabled(true);
    }
    
}
