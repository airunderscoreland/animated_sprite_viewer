package animated_sprite_viewer.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sprite_renderer.SceneRenderer;

/**
 * When the speed up button is pressed, this handler
 * will call the actionPerformed method and increase
 * the timer scaler by 10%
 * 
 * @author Andrew Ireland
 */
public class SpeedUpAnimationHandler implements ActionListener 
{

    private SceneRenderer renderer;
    
    public SpeedUpAnimationHandler(SceneRenderer sr) {
        renderer = sr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Get the animation time scaler and multiply it by 0.9 and save that
        float scaler = renderer.getTimeScaler();
        renderer.setTimeScaler((float)(scaler*0.90));
    }
    
    
}
