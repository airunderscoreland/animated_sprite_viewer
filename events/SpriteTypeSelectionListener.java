package animated_sprite_viewer.events;

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
 * This class is an event listener for ListSelectionEvents. A ListSelectionEvent
 * occurs when a change of selection is made to the JList (list of SpriteTypes).
 * 
 * @author Andrew Ireland
 * @version 1.0
 */
public class SpriteTypeSelectionListener implements ListSelectionListener {

    private DefaultComboBoxModel model;
    private HashMap<String, SpriteType> spriteTypes;
    private ArrayList<Sprite> sprites;
    private JComboBox combobox;
    private static final String SELECTION_DEFAULT = "Select Animation State";
    //DEBUG
    private int count;
    
    /**
     * Default constructor
     * 
     * @param cb The combobox in which to add the animation states
     * @param st The hash map of sprite types
     * @param sl The sprite list of rendered sprites
     */
    public SpriteTypeSelectionListener(JComboBox cb, HashMap<String,SpriteType> st, ArrayList<Sprite> sl) 
    {
        combobox = cb;
        model = (DefaultComboBoxModel) cb.getModel();
        spriteTypes = st;
        sprites = sl;
        count=0;
    }
    
    @Override
    /**
     * this should take the list item clicked and add the animation states
     * to the combo box then enable the combobox
     */
    public void valueChanged(ListSelectionEvent e) 
    {
        //This method gets called twice when a new selection is made so we only
        //want this to run once per new selection
        count++;
        if (count%2==1) {
        String spriteTypeName = ((JList)e.getSource()).getSelectedValue().toString();
        SpriteType spriteType = spriteTypes.get(spriteTypeName);
        //Remove all but "Select Animation State" from combobox
        model.removeAllElements();
        model.addElement(SELECTION_DEFAULT);
        Iterator<AnimationState> animationIT = spriteType.getAnimationStates();
        while (animationIT.hasNext()) {
            AnimationState state = animationIT.next();
            model.addElement(state);
        }
        sprites.clear();
        combobox.setEnabled(true);
        }
    }
    
}
