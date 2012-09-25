package animated_sprite_viewer.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sprite_renderer.SceneRenderer;

/**
 * When the speed up button is pressed, this handler
 * will call the actionPerformed method and decrease
 * the timer scaler by 15%
 * 
 * @author Andrew Ireland
 * 
 * @version 1.0
 */
public class SlowDownAnimationHandler implements ActionListener 
{

    private SceneRenderer renderer;
    
    public SlowDownAnimationHandler(SceneRenderer sr) {
        renderer = sr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Get the animation time scaler and multiply it by 1.15 and save that
        float scaler = renderer.getTimeScaler();
        renderer.setTimeScaler((float)(scaler*1.15));
    }
    
    
}
