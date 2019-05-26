package dev.ryastark.simulation.characters;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import dev.ryastark.simulation.Battle;
import javax.imageio.ImageIO;

public class Robot {
	
	public int attackValue;
	public int defenseValue;
	public int speedValue;
	public int energyValue = 100;
	public int locationCoords;
	
	public Graphics g;
	public String path;
	public Battle battle;
	
	public Robot(int attackValue, int defenseValue, int speedValue, int location, String path) {
		this.attackValue = attackValue;
		this.defenseValue = defenseValue;
		this.speedValue = speedValue;
		this.locationCoords = location;
		this.path = path;
	}

	public int getAttackValue() {
		return attackValue;
	}

	public void setAttackValue(int attackValue) {
		this.attackValue = attackValue;
	}

	public int getDefenseValue() {
		return defenseValue;
	}

	public void setDefenseValue(int defenseValue) {
		this.defenseValue = defenseValue;
	}

	public int getSpeedValue() {
		return speedValue;
	}

	public void setSpeedValue(int speedValue) {
		this.speedValue = speedValue;
	}

	public int getEnergyValue() {
		return energyValue;
	}

	public void setEnergyValue(int energyValue) {
		this.energyValue = energyValue;
	}

	public int getLocationCoords() {
		return locationCoords;
	}

	public void setLocationCoords(int locationCoords) {
		this.locationCoords = locationCoords;
	}
	
	
	
}
