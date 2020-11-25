package observer3;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

public class ComplementaryColorPanel extends ColorPanel implements PropertyChangeListener{
	
	OriginalColorPanel original; 
	
	public ComplementaryColorPanel(float hue, float saturation, float brightness, OriginalColorPanel originalColor) {
		super(hue, saturation, brightness);	
		original = originalColor; 
		original.addPropertyChangeListener(this); 
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		
		//we really only need to care about the hue as that is the only property needed to determine
		//the complementary color
		float newHue = original.getHueNumber() - (float).5;
		if(newHue < 0){
			 newHue++; 
		 }
		float saturation = original.getSaturationNumber(); 
		float brightness = original.getBrightnessNumber(); 
		Color newColor = Color.getHSBColor(newHue, saturation, brightness);
		this.setColor(newColor);
	}

}