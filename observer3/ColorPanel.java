package observer3;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;

public abstract class ColorPanel extends JPanel{
    private Color color;
    private float hueNumber; 
    private float saturationNumber; 
    private float brightnessNumber; 

    public ColorPanel(float hue, float saturation, float brightness) {
        this.color = Color.getHSBColor(hue, saturation, brightness);
        this.hueNumber = hue; 
        this.saturationNumber = saturation; 
        this.brightnessNumber = brightness; 
    }

    public void setColor(Color newColor) {
        this.color = newColor;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        this.setBackground(color);
        super.paintComponent(g);
    }
	
	public float getHueNumber() { 
		return this.hueNumber; 
	}
	
	public float getSaturationNumber() { 
		return this.saturationNumber; 
	}
	
	public float getBrightnessNumber() { 
		return this.brightnessNumber; 
	}
	
	public void setHueNumber(float hue) {
		this.hueNumber = hue; 
	}
	
	public void setSaturationNumber(float saturation) { 
		this.saturationNumber = saturation; 
	}
	
	public void setBrightnessNumber(float brightness) {
		this.brightnessNumber = brightness;
	}
}