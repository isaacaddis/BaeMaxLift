package org.usfirst.frc.team687.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TalonSRX;

public class ClosedLoopControl {
	/*
	 * @author 687
	 * @description Given kP, kD, desired inches, actual inches(en)
	 */
	private Encoder m_encode;
	private double m_kP, m_kD, m_desired;
	private double error =0;
	private double deltaError;
	private double lastError = 0;
	private double currentTime,lastTime,deltaTime;
	public ClosedLoopControl(double kP, double kD, double desired){
		m_kP = kP;
		m_kD = kD;
		m_desired = desired;
		currentTime = System.currentTimeMillis();
	}
	public double get(double actual){
		error = m_desired - actual;
		deltaError = error - lastError;
		deltaTime = currentTime - lastTime;
		lastError = error;
		lastTime = currentTime;
		return (m_kP*error)+(m_kD*(deltaError/deltaTime));
	}
}
