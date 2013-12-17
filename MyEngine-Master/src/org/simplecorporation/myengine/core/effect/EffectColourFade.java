/***********************************************
 * SIMPLE CORPORATION
 * 
 * MYENGINE
 * 
 * COPYRIGHT @ 2013
 * 
 * USE - EDUCATIONAL PURPOSES ONLY
 ***********************************************/

package org.simplecorporation.myengine.core.effect;

import org.simplecorporation.myengine.core.render.basic.BasicRenderer;
import org.simplecorporation.myengine.core.render.colour.Colour;
import org.simplecorporation.myengine.utils.timer.Timer;

public class EffectColourFade extends Effect {
	
	/* The name of this effect */
	public static final String EFFECT_NAME = "Colour Fade";
	
	/* The description of this effect */
	public static final String EFFECT_DESCRIPTION = "Fades a colour over time using its alpha";
	
	/* The id of this effect */
	public static final int EFFECT_ID = 1;
	
	/* The timer */
	public Timer timer;
	
	/* The time between fade */
	public long timeBetweenFade;
	
	/* The amount the alpha is change */
	public double amountAlphaChange;
	
	/* The colour */
	public Colour colour;
	
	/* The current fade direction */
	public int fadeDirection;
	
	/* Boolean that states whether the current cycle is the first */
	public boolean isFirstCycle;
	
	/* The original fade direction */
	public int originalFadeDirection;
	
	/* The number of cycles completed */
	public int numberOfCompletedCycles;
	
	/* The maximum cycles to complete */
	public int maxNumberOfCycles;
	
	/* The constructor */
	public EffectColourFade(long timeBetweenFade , double amountAlphaChange , Colour colour , int fadeDirection) {
		//Call the super constructor
		super(EFFECT_NAME , EFFECT_DESCRIPTION , EFFECT_ID);
		//Create the timer
		this.timer = new Timer();
		//Set the time between fade
		this.timeBetweenFade = timeBetweenFade;
		//Set the amount alpha change
		this.amountAlphaChange = amountAlphaChange;
		//Set the colour
		this.colour = colour;
		//Set the fade direction
		this.fadeDirection = fadeDirection;
		//Set up the cycle counting variables
		this.isFirstCycle = true;
		this.originalFadeDirection = this.fadeDirection;
		this.numberOfCompletedCycles = 0;
		this.maxNumberOfCycles = 0;
	}
	
	/* The method called to update the effect */
	public void updateEffect() {
		//Check the time that has passed
		if (this.timer.hasTimePassed(this.timeBetweenFade)) {
			//Change the alpha value of the colour
			this.colour.setA(this.colour.getA() + (this.amountAlphaChange * this.fadeDirection));
			//Restart the timer
			this.timer.start();
		}
		
		//Check the current fade direction
		if (this.fadeDirection == -1) {
			//Check the current alpha value
			if (this.colour.getA() < 0) {
				//Set the alpha colour
				this.colour.setA(0d);
				//Change the fade direction
				this.fadeDirection *= -1;
				//Check if this is the original fade direction and this isn't the first cycle
				if (this.fadeDirection == this.originalFadeDirection && ! this.isFirstCycle)
					//Add one to the number of completed cycles
					this.numberOfCompletedCycles++;
				//Make sure isFirstCycle is set to false
				this.isFirstCycle = false;
			}
		} else if (this.fadeDirection == 1) {
			//Check the current alpha value
			if (this.colour.getA() > 1) {
				//Set the alpha colour
				this.colour.setA(1d);
				//Change the fade direction
				this.fadeDirection *= -1;
				//Check if this is the original fade direction and this isn't the first cycle
				if (this.fadeDirection == this.originalFadeDirection && ! this.isFirstCycle)
					//Add one to the number of completed cycles
					this.numberOfCompletedCycles++;
				//Make sure isFirstCycle is set to false
				this.isFirstCycle = false;
			}
		}
		
		//Check the number of cycles
		if (this.maxNumberOfCycles != 0 && this.maxNumberOfCycles == this.numberOfCompletedCycles) {
			//Stop the effect
			this.stopEffect();
		}
	}
	
	/* The method called to apply the effect */
	public void applyEffect() {
		//Set the colour
		BasicRenderer.setColour(this.colour);
	}
	
	/* The method called to start the effect */
	public void startEffect() {
		//Start the timer
		this.timer.start();
	}
	
	/* The method called to stop the effect */
	public void stopEffect() {
		//Stop the timer
		this.timer.stop();
		//Set the fade direction to 0
		this.fadeDirection = 0;
	}
	
	/* The method called to reset an effect */
	public void resetEffect() {
		//Set up the cycle counting variables
		this.isFirstCycle = true;
		this.fadeDirection = this.originalFadeDirection;
		this.numberOfCompletedCycles = 0;
	}
	
}