package observer2;

import java.awt.Color;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ComplementaryColorPanel extends ColorPanel implements ChangeListener{
	
	public ComplementaryColorPanel(Color initialColor, JSlider hue, JSlider saturation, JSlider brightness) {
		super(initialColor, hue, saturation, brightness); 
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		if (hue != null && saturation != null && brightness  != null) {
			float newHue = (float) hue.getValue() / 100;
            float newSaturation = (float) saturation.getValue() / 100;
            float newBrightness = (float) brightness.getValue() / 100;
            float complementaryHue = newHue - (float) 0.5;
            if (complementaryHue < 0) {
              complementaryHue = complementaryHue + 1;
            }
            Color complementaryColor = Color.getHSBColor(complementaryHue, newSaturation, newBrightness);
            this.setColor(complementaryColor);
		}
	}
}
