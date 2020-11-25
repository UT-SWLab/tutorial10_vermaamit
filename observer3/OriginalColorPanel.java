package observer3;

import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OriginalColorPanel extends ColorPanel implements ChangeListener{
	
	JSlider hueSlider; 
	JSlider saturationSlider; 
	JSlider brightnessSlider; 
	
	public OriginalColorPanel(float hue, float saturation, float brightness, JSlider hueSlider, JSlider saturationSlider, JSlider brightnessSlider) {		
		super(hue, saturation, brightness);
		this.hueSlider = hueSlider; 
		this.saturationSlider = saturationSlider; 
		this.brightnessSlider = brightnessSlider; 
		hueSlider.addChangeListener(this);
	    saturationSlider.addChangeListener(this);
	    brightnessSlider.addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		if (hueSlider != null && saturationSlider != null && brightnessSlider != null) {
			float newHue = (float) hueSlider.getValue() / 100;
            float newSaturation = (float) saturationSlider.getValue() / 100;
            float newBrightness = (float) brightnessSlider.getValue() / 100;
            Color originalColor = Color.getHSBColor(newHue, newSaturation, newBrightness);
            this.setColor(originalColor);
            this.setHueNumber(newHue);
            this.setSaturationNumber(newSaturation);
            this.setBrightnessNumber(newBrightness);
		}
		
	}

	
	

}